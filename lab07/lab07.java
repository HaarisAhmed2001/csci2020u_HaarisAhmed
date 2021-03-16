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
import java.util.*;
import java.io.*;

public class lab07 extends Application {

    // create a new canvas variable
    private Canvas can;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // make the title
        primaryStage.setTitle("Lab 07");

        // set the group and scene
        Group root = new Group();
        Scene scene = new Scene(root, 1300, 850);

        // create a title and a scene
        primaryStage.setTitle("Wheather - Pie Chart");
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
    public static Color[] pieCol = { Color.BLUE, Color.YELLOW, Color.ORANGE, Color.GREEN };

    private void draw(Group root) {
        // create a string variable that will act as a path for the reader
        String path = "C:\\csci2020u\\lab07\\weatherwarnings-2015.csv";

        // make a variable that will represent a value within the xml file
        String line = "";

        // use a try-catch method to catch potential errors
        try {
            // create a br var
            BufferedReader read = new BufferedReader(new FileReader(path));

            // use a while loop to cut each value into an array
            while ((line = read.readLine()) != null) {
                // create a new array to store the values
                String[] xmlVals = line.split(",");
            }

        } catch (Exception e) {
            System.out.println("Error");
        }
        // create a graphics context variable
        GraphicsContext gc = can.getGraphicsContext2D();
    }

    public static void main(String[] args) {
        launch();
    }
}