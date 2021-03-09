import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static java.awt.Font.*;
import static javafx.scene.text.Font.font;
import javafx.scene.chart.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.layout.VBox;

public class lab06 extends Application {
    // create a canvas variable
    private Canvas can;

    @Override
    public void start(Stage primaryStage) throws Exception {
        double[] avgHousingPricesByYear = { 247381.0, 264171.4, 287715.3, 294736.1, 308431.4, 322635.9, 340253.0,
                363153.7 };
        double[] avgCommercialProcesByYear = { 1121585.3, 1219479.5, 1246354.2, 1295364.8, 1335932.6, 1472362.0,
                1583521.9, 1613246.3 };

        // make the title
        primaryStage.setTitle("Lab 06");

        // set the group and scene
        Group root = new Group();
        Scene scene = new Scene(root, 1300, 850);

        // create a title and a scene
        primaryStage.setTitle("Graphics - Bar and pie charts");
        primaryStage.setScene(scene);
        primaryStage.show();

        // create a new canvas that will display the graphs in question
        can = new Canvas();
        can.widthProperty().bind(primaryStage.widthProperty());
        can.heightProperty().bind(primaryStage.heightProperty());
        root.getChildren().add(can);

        // create the root
        draw(root);
    }

    // create arrays that will group up a bunch of values to make them easier to
    // chart colours
    public static Color[] pieCol = { Color.AQUA, Color.GOLD, Color.DARKORANGE, Color.DARKSALMON, Color.LAWNGREEN,
            Color.PLUM };
    // chart ages
    public static String[] ages = { "18-25", "26-35", "36-45", "46-55", "56-65", "65+" };
    // chart's purchases by ages
    public static int[] purBA = { 648, 1021, 2453, 3173, 1868, 2247 };
    // chart's commercial process by year
    public static double[] avgCPBY = { 1121585.3, 1219479.5, 1246354.2, 1295364.8, 1335932.6, 1472362.0, 1583521.9,
            1613246.3 };
    // chart's
    public static double[] avgHBPY = { 247381.0, 264171.4, 287715.3, 294736.1, 308431.4, 322635.9, 340253.0, 363153.7 };

    // create the draw function
    public void draw(Group root) {
        // create a graphics context variable
        GraphicsContext gc = can.getGraphicsContext2D();

        // output for the pie graph
        // counter for each group
        int numGroups = 0;
        // loop for each value purBA
        for (int temp : purBA)
            // update
            numGroups += temp;

        // new counter
        double begin = 0.0;
        // loop until the counter is no longer less than the lenght of purBA
        for (int f = 0; f < purBA.length; f++) {
            // store value
            double slicePercentage = (double) purBA[f] / (double) numGroups;
            // create teh angle
            double sweepAngle = slicePercentage * 360.0;

            // create each section of the pie chart
            gc.setFill(pieCol[f]);
            // output
            gc.fillArc(920, 100, 300, 300, begin, sweepAngle, ArcType.ROUND);

            // update beginning
            begin += sweepAngle;
        }

        // bars for the average commecial processes by Year
        // the colour shall be blue for this ser of bars
        gc.setFill(Color.BLUE);
        // each bar will be 50 spaces apart
        gc.fillRect(35, 800 - avgCPBY[0] / 4000, 20, avgCPBY[0] / 4000);
        gc.fillRect(85, 800 - avgCPBY[1] / 4000, 20, avgCPBY[1] / 4000);
        gc.fillRect(135, 800 - avgCPBY[2] / 4000, 20, avgCPBY[2] / 4000);
        gc.fillRect(185, 800 - avgCPBY[3] / 4000, 20, avgCPBY[3] / 4000);
        gc.fillRect(235, 800 - avgCPBY[4] / 4000, 20, avgCPBY[4] / 4000);
        gc.fillRect(285, 800 - avgCPBY[5] / 4000, 20, avgCPBY[5] / 4000);
        gc.fillRect(335, 800 - avgCPBY[6] / 4000, 20, avgCPBY[6] / 4000);
        gc.fillRect(385, 800 - avgCPBY[7] / 4000, 20, avgCPBY[7] / 4000);

        // bars for the average housing prices by Year
        // the colour shall be red for this ser of bars
        gc.setFill(Color.RED);
        // each bar will be spaced 50 spaces apart
        gc.fillRect(10, 800 - avgHBPY[0] / 2000, 20, avgHBPY[0] / 2000);
        gc.fillRect(60, 800 - avgHBPY[1] / 2000, 20, avgHBPY[1] / 2000);
        gc.fillRect(110, 800 - avgHBPY[2] / 2000, 20, avgHBPY[2] / 2000);
        gc.fillRect(160, 800 - avgHBPY[3] / 2000, 20, avgHBPY[3] / 2000);
        gc.fillRect(210, 800 - avgHBPY[4] / 2000, 20, avgHBPY[4] / 2000);
        gc.fillRect(260, 800 - avgHBPY[5] / 2000, 20, avgHBPY[5] / 2000);
        gc.fillRect(310, 800 - avgHBPY[6] / 2000, 20, avgHBPY[6] / 2000);
        gc.fillRect(360, 800 - avgHBPY[7] / 2000, 20, avgHBPY[7] / 2000);

    }

    public static void main(String[] args) {
        // launch the program
        launch(args);
    }
}