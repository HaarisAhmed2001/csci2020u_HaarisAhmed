import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class lab05 extends Application {

    // Create a public class that will hold your variables that will be manipulated
    // in order to operate the table
    public class StudentRecord {
        // these values represent each value to each of their respective columns on the
        // table
        String studentID;
        String letGrade;
        float midterm;
        float assignment;
        float finalExam;
        float finalMark;

        // create a constructor
        public StudentRecord(String id, float assign, float mt, float exam) {
            // set each value
            this.studentID = id;
            this.assignment = assign;
            this.midterm = mt;
            this.finalExam = exam;

            // set the final mark
            finalMark = (midterm * 0.3f) + (assignment * 0.2f) + (finalExam * 0.5f);

            // create if statements to determine the letter grade
            if (this.finalMark < 50) {
                this.letGrade = "F";
            } else if (this.finalMark >= 50 && this.finalMark < 60) {
                this.letGrade = "D";
            } else if (this.finalMark >= 60 && this.finalMark < 70) {
                this.letGrade = "C";
            } else if (this.finalMark >= 70 && this.finalMark < 80) {
                this.letGrade = "B";
            } else if (this.finalMark >= 80 && this.finalMark <= 100) {
                this.letGrade = "A";
            }
        }

        // getter section, set up a bunch of getters
        // student ID
        public String getStudentID() {
            // return value
            return studentID;
        }

        // Letter Grade
        public String getLetGrade() {
            // return value
            return letGrade;
        }

        // Midterm
        public float getMidterm() {
            // return value
            return midterm;
        }

        // Assignment
        public float getAssignment() {
            // return value
            return assignment;
        }

        // Finale Exam
        public float getFinalExam() {
            // return value
            return finalExam;
        }

        // Final Mark
        public float getFinalMark() {
            // return value
            return finalMark;
        }

    }

    public class DataSource {

        public ObservableList<StudentRecord> getAllMarks() {

            ObservableList<StudentRecord> marks = FXCollections.observableArrayList();

            // Student ID, Assignments, Midterm, Final exam
            marks.add(new StudentRecord("100100100", 75.0f, 68.0f, 54.25f));
            marks.add(new StudentRecord("100100101", 70.0f, 69.25f, 51.5f));
            marks.add(new StudentRecord("100100102", 100.0f, 97.0f, 92.5f));
            marks.add(new StudentRecord("100100103", 90.0f, 88.5f, 68.75f));
            marks.add(new StudentRecord("100100104", 72.25f, 74.75f, 58.25f));
            marks.add(new StudentRecord("100100105", 85.0f, 56.0f, 62.5f));
            marks.add(new StudentRecord("100100106", 70.0f, 66.5f, 61.75f));
            marks.add(new StudentRecord("100100107", 55.0f, 47.0f, 50.5f));
            marks.add(new StudentRecord("100100108", 40.0f, 32.5f, 27.75f));
            marks.add(new StudentRecord("100100109", 82.5f, 77.0f, 74.25f));

            return marks;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // window title
        primaryStage.setTitle("Lab 05 Solutions");

        // Use table function to allow tables
        TableView tableView = new TableView();

        // create the columns for each specific table
        TableColumn<StudentRecord, String> idColumn = new TableColumn<>("SID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("studentID"));

        TableColumn<StudentRecord, String> letterGrade = new TableColumn<>("Letter Grade");
        letterGrade.setCellValueFactory(new PropertyValueFactory<>("letGrade"));

        TableColumn<StudentRecord, String> midtermColumn = new TableColumn<>("Midterm");
        midtermColumn.setCellValueFactory(new PropertyValueFactory<>("midterm"));

        // create the column variables that will be used to represent each values in the
        // table
        TableColumn<StudentRecord, String> assignColumn = new TableColumn<>("Assignments");
        assignColumn.setCellValueFactory(new PropertyValueFactory<>("assignment"));

        TableColumn<StudentRecord, String> finalE = new TableColumn<>("Final Exam");
        finalE.setCellValueFactory(new PropertyValueFactory<>("finalExam"));

        TableColumn<StudentRecord, String> finalM = new TableColumn<>("Final Mark");
        finalM.setCellValueFactory(new PropertyValueFactory<>("finalMark"));

        // use this to create a view or a look for the table
        tableView.getColumns().add(idColumn);
        tableView.getColumns().add(assignColumn);
        tableView.getColumns().add(midtermColumn);
        tableView.getColumns().add(finalE);
        tableView.getColumns().add(finalM);
        tableView.getColumns().add(letterGrade);

        // use a loop to get the values from student record and add them to the table
        // use a for loop
        for (StudentRecord r : new DataSource().getAllMarks()) {
            // add the values to the table
            tableView.getItems().add(r);
        }

        VBox vbox = new VBox(tableView);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
