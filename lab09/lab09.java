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

    }

    // create private variables for some functions for the private functions
    public Double yaxismin;
    private Double yaxismax;

    private void plotLine(double[] stockPrice, Color color) {

    }

    }

    private void drawLinePlot() {
        double[] stock1 = downloadStockPrices("MSFT", LocalDateTime.of(2020, 1, 1, 0, 0),
                LocalDateTime.of(2021, 1, 1, 0, 0));
        double[] stock2 = downloadStockPrices("AAPL", LocalDateTime.of(2020, 1, 1, 0, 0),
                LocalDateTime.of(2021, 1, 1, 0, 0));

    }

    plotLine(stock1, Color.BLUE);
        plotLine(stock2, Color.RED);

        graphics.setStroke(Color.BLACK);
        graphics.strokeLine(50, 500, 450, 500);
        graphics.strokeLine(50, 500, 50, 50);
    }

    public static void main(String[] args) {
        launch(args);
    }
}