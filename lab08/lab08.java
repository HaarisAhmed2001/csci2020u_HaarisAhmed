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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.Group;
import java.io.File;
import java.io.FileWriter;
import javafx.stage.FileChooser;

public class lab08 extends Application {

    // Create a public class that will hold your variables that will be manipulated
    // in order to operate the table

    // create a variable that will select and hold a file path
    public String processedFile = "";

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
        primaryStage.setTitle("Lab 08 Solutions");

        // Use table function to allow tables
        TableView table = new TableView();

        // set a vbox variable
        VBox vb = new VBox(0);

        // create a new scene based from the vbox
        Scene scene = new Scene(vb);

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
        table.getColumns().add(idColumn);
        table.getColumns().add(assignColumn);
        table.getColumns().add(midtermColumn);
        table.getColumns().add(finalE);
        table.getColumns().add(finalM);
        table.getColumns().add(letterGrade);

        // use a loop to get the values from student record and add them to the table
        // use a for loop
        for (StudentRecord r : new DataSource().getAllMarks()) {
            // add the values to the table
            table.getItems().add(r);
        }

        // Creating a menu
        Menu fileMenu = new Menu("File");
        // Creating menu Items
        // ∙ New
        // ∙ Open
        // ∙ Save
        // ∙ Save As
        // ∙ Exit
        MenuItem newF = new MenuItem("New");
        MenuItem open = new MenuItem("Open");
        MenuItem save = new MenuItem("Save");
        MenuItem saveAs = new MenuItem("Save As");
        MenuItem exit = new MenuItem("Exit");

        // Adding all the menu items to the menu
        fileMenu.getItems().addAll(newF, open, save, saveAs, exit);

        // focus on all events related to the menu
        // set the save menu bar function
        save.setOnAction(s -> {
            // call save function
            saveData();
        });

        // set the new menu bar function
        newF.setOnAction(nF -> {
            // set the file string variable to blank
            processedFile = "";

            // use the clear functions to clear the items from the table
            table.getItems().clear();
        });

        // set the exit option
        exit.setOnAction(new EventHandler<ActionEvent>() {
            // use a public function with a activation event variable
            public void handle(ActionEvent t) {

                // ask the system to shuut down
                System.exit(0);
            }
        });

        // set save as function
        saveAs.setOnAction(sA -> {
            // create a file chooser variable
            FileChooser Choose = new FileChooser();

            // create a regular file variable that selects different files
            File selected = Choose.showOpenDialog(primaryStage);

            // set the current file string to an actual file path
            processedFile = selected.getName();

            // call the save function
            saveData();
        });

        // create the open menubar function
        open.setOnAction(o -> {
            // create a file chooser variable
            FileChooser Choose = new FileChooser();

            // create a regular file variable that selects different files
            File selected = Choose.showOpenDialog(primaryStage);

            // set the current file string to an actual file path
            processedFile = selected.getName();

            // create a observable list to access the selectefile, in order to access the
            // info in student record
            // using a load function load the information into the list
            ObservableList<StudentRecord> studentMarks = loadData(selected);

            // use a for loop to loop through each piece of information within StudentRecord
            for (StudentRecord student : studentMarks) {
                // add items to the table
                table.getItems().add(student);
            }
        });

        // create a menu bar
        MenuBar menuB = new MenuBar();

        // add the file menu values to the file menu bars
        menuB.getMenus().add(fileMenu);

        // add the menu bar to the virtual box
        vb.getChildren().add(menuB);

        // add the table view to the virtual box
        vb.getChildren().add(table);

        // add the scene to the stage
        primaryStage.setScene(scene);

        // start the show
        primaryStage.show();
    }

    public ObservableList<StudentRecord> loadData(File f) {
        ObservableList<StudentRecord> info = FXCollections.observableArrayList();
        return info;
    }

    // save function
    public void saveData() {
        // use trycatch to catch possible errors
        try {
            // use an if statement to determine whether the processed file is blank or not
            if (processedFile != "") {
                // create a new filewriter variable
                FileWriter scribe = new FileWriter(processedFile);

                // create a new file variable
                File handle = new File(processedFile);

                // create the heading on the file
                scribe.write("SID, Assignments, Midterm, Exam");
                scribe.write("\n");

                // use a for loop to loop through the information in student record to get all
                // the marks
                for (StudentRecord student : new DataSource().getAllMarks()) {
                    // create a new variable that will represent the written information on the file
                    String fileInfo = student.getStudentID() + student.getAssignment() + student.getMidterm()
                            + student.getFinalExam() + student.getFinalMark() + student.getLetGrade();

                    // append the information to the file
                    scribe.write(fileInfo);
                }

                // stop the writer
                scribe.close();
            } else {
                // change the current file name
                processedFile = "BlankFile.txt";
            }
        } catch (Exception e) {
            // display an error message
            System.out.println("System was not able to save data.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
