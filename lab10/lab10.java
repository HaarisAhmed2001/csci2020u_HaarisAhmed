import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import java.io.IOException;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.net.Socket;

public class lab10 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Lab 10: Simple BBS Client v 1.0.");

        // create grid
        GridPane grid = new GridPane();

        // align to the center
        grid.setAlignment(Pos.CENTER);

        // set grid measurements
        Scene scene = new Scene(grid, 400, 450);

        // set text box and label measurments
        grid.setHgap(10);
        grid.setVgap(100);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // create buttons
        Button send = new Button("Send");
        Button exit = new Button("Exit");

        // create textfields
        TextField txtMess = new TextField();
        TextField txtUser = new TextField();

        // create labels
        Label message = new Label("Message: ");
        Label username = new Label("Username: ");

        // set the placement of each text box
        grid.add(message, 0, 1);
        grid.add(txtMess, 1, 1);
        grid.add(username, 0, 2);
        grid.add(txtUser, 1, 2);
        grid.add(send, 0, 3);
        grid.add(exit, 1, 3);

        // set scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
