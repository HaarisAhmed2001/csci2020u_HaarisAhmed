import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.Group;
import javafx.stage.Stage;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class lab09 extends Application {
    // create a graphics context variable
    private GraphicsContext graphics;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // set up canvas variable
        Canvas can = new Canvas();

        // create a new group variable
        Group gr = new Group();

        // create anew scene variable
        Scene sc = new Scene(gr, 1000, 700);

        // set title
        primaryStage.setTitle("lab09 - Stock Line graphs");

        // ser height and width property for the window
        can.heightProperty().bind(primaryStage.heightProperty());
        can.widthProperty().bind(primaryStage.widthProperty());

        // add all parameters to the group
        gr.getChildren().add(can);

        // initialize teh graphics context variable
        graphics = can.getGraphicsContext2D();

        // set the scene
        primaryStage.setScene(sc);

        // set the stage
        primaryStage.show();

        // call drawLinePlot function
        drawLinePlot();
    }

    private double[] downloadStockPrices(String link, LocalDateTime begin, LocalDateTime finish) {
        HttpClient main = HttpClient.newHttpClient();
        HttpResponse<String> res = null;
        String url = "https://query1.finance.yahoo.com/v7/finance/download/" + link + "?period1="
                + String.valueOf(begin.toEpochSecond(ZoneOffset.UTC)) + "&period2="
                + String.valueOf(finish.toEpochSecond(ZoneOffset.UTC))
                + "&interval=1wk&events=history&includeAdjustedClose=true";
        HttpRequest temp = HttpRequest.newBuilder().uri(URI.create(url)).build();

        // use try catch to create populate the HttpResponse variable
        try {
            res = main.send(temp, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println("IOException Error!");
        }

        String[] lines = res.body().split("\n");
        double[] prices = new double[lines.length - 1];
        for (int i = 1; i < lines.length; i++) {
            prices[i - 1] = Float.parseFloat(lines[i].split(",")[5]);
        }
        return prices;
    }

    private Double yMax;
    private Double yMin;

    private void plotLine(double[] stockPrice, Color color) {
        graphics.setStroke(color);
        int prevX = 50;
        double norm = (stockPrice[0] - yMin) / (yMax - yMin);
        double prevY = 500 - (norm * (450 - 50));
        double incX = (double) ((500 - 50) / stockPrice.length);
        for (int i = 1; i < stockPrice.length; i++) {
            double num = (stockPrice[i] - yMin) / (yMax - yMin); // normalize
            double yPos = 500 - (num * (450 - 50)); // denormalize
            graphics.strokeLine(prevX, prevY, (int) (prevX + incX), (int) yPos);
            prevX = prevX + (int) incX;
            prevY = (int) yPos;
        }
    }

    private void drawLinePlot() {
        double[] adjClose1 = downloadStockPrices("MSFT", LocalDateTime.of(2020, 1, 1, 0, 0),
                LocalDateTime.of(2021, 1, 1, 0, 0));
        double[] adjClose2 = downloadStockPrices("AAPL", LocalDateTime.of(2020, 1, 1, 0, 0),
                LocalDateTime.of(2021, 1, 1, 0, 0));

        yMax = Double.MIN_VALUE;
        yMin = Double.MAX_VALUE;
        for (int i = 0; i < adjClose1.length - 1; i++) {
            yMax = Double.max(yMax, adjClose1[i]);
            yMax = Double.max(yMax, adjClose2[i]);

            yMin = Double.min(yMin, adjClose1[i]);
            yMin = Double.min(yMin, adjClose2[i]);
        }

        plotLine(adjClose1, Color.BLUE);
        plotLine(adjClose2, Color.RED);

        graphics.setStroke(Color.BLACK);
        graphics.strokeLine(50, 500, 450, 500);
        graphics.strokeLine(50, 500, 50, 50);
    }

    public static void main(String[] args) {
        launch(args);
    }
}