import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class lab04 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // set up title for the window
        primaryStage.setTitle("Lab 04 Solution");

        // Creating grid window
        GridPane myGrid = new GridPane();

        // set the alignment to the left
        myGrid.setAlignment(Pos.BASELINE_LEFT);

        // set the gaps and lengths for each text box
        myGrid.setHgap(5);
        myGrid.setVgap(10);

        myGrid.setPadding(new Insets(25, 25, 25, 25));

        Text title = new Text("Welcome:"); // welcome

        // Labels for each input
        Label UName = new Label("Username:"); // user name

        Label Password = new Label("Password:"); // password

        Label EMail = new Label("E-Mail:"); // email

        Label FName = new Label("Full Name:"); // full name

        Label DB = new Label("Date of Birth:"); // date of birth

        Label PhoneNumber = new Label("Phone #:"); // phone

        // Inputs
        TextField txtUN = new TextField(); // txt for username

        PasswordField psP = new PasswordField(); // password for password

        TextField txtEM = new TextField(); // txt for email

        TextField txtFN = new TextField(); // txt for full name

        DatePicker txtDB = new DatePicker(); // datepicker for dob

        TextField txtPN = new TextField(); // txt for phone number

        // put text prompts on each text box
        txtUN.setPromptText("Username");
        psP.setPromptText("Password");
        txtFN.setPromptText("Full Name");
        txtEM.setPromptText("E-mail");
        txtPN.setPromptText("Phone #");
        txtDB.setPromptText("Date-of-Birth:");

        // make the button
        Button reg = new Button();

        // give button some text name
        reg.setText("Register");

        // Add the components onto the myGrid pane

        // title card
        myGrid.add(title, 0, 0, 2, 1);

        // follow the order in the example
        // username
        myGrid.add(UName, 0, 1);
        myGrid.add(txtUN, 1, 1);

        // password
        myGrid.add(Password, 0, 2);
        myGrid.add(psP, 1, 2);

        // full name
        myGrid.add(FName, 0, 3);
        myGrid.add(txtFN, 1, 3);

        // email
        myGrid.add(EMail, 0, 4);
        myGrid.add(txtEM, 1, 4);

        // PN
        myGrid.add(PhoneNumber, 0, 5);
        myGrid.add(txtPN, 1, 5);

        // DoB
        myGrid.add(DB, 0, 6);
        myGrid.add(txtDB, 1, 6);

        // button
        myGrid.add(reg, 1, 7);

        // out put the values obtained from the user
        reg.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // outputs
                System.out.println(txtUN.getText()); // user name

                System.out.println(psP.getText()); // password

                System.out.println(txtFN.getText()); // Full Name

                System.out.println(txtEM.getText()); // E Mail

                System.out.println(txtPN.getText()); // Phone Number

                System.out.println(txtDB.getValue()); // Date of Birth
            }
        });

        // ui dimensions
        // Creating myScene with custom layout
        Scene myScene = new Scene(myGrid, 330, 330);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
