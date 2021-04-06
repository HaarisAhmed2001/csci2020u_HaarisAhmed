import java.io.*;
import java.net.*;
import java.util.*;

public class lab10ServerThread extends Thread {
    protected Socket socket = null;
    protected PrintWriter out = null;
    protected BufferedReader in = null;

    // create a constructor for this Server thread
    public lab10ServerThread(Socket socket) {
        // call super
        super();

        // set the socket
        this.socket = socket;

        // use try catchto control the information that goes within the server and out
        // of the server
        try {
            // create an in variable which will send the data into the proram
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // create a variable that will take data out from the program
            out = new PrintWriter(socket.getOutputStream(), true);

        } catch (IOException e) {
            // output error
            System.err.println("IOEXception while opening a read/write connection");
        }
    }

    // create the run function
    public void run() {
        // initialize interaction
        out.println("Connected to the Server");

        // create a boolean variable to keep track of the process
        boolean endOfSession = false;

        // loop until the proccess is finished
        while (!endOfSession) {
            endOfSession = processCommand();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // create the process command function
    protected boolean processCommand() {
        // create a string variable that will be a holder for commands
        String holder = null;

        try {
            // set holder to holding the info
            holder = in.readLine();
        } catch (IOException e) {
            // output error message
            System.err.println("Error reading command from socket.");
            return true;
        }
        // use an if statement to check if the holder is null
        if (holder == null) {
            // return true
            return true;
        }

        // create a tokenizer variable
        StringTokenizer st = new StringTokenizer(holder);

        // create a string variable that will hold the command
        String commands = st.nextToken();

        // create the variables that will be proccessed to execute the commands
        String info = null;
        String names = null;

        if (st.hasMoreTokens()) {
            names = holder.substring(commands.length() + 1, holder.length());
        }

        // return the outcome of the process
        return processCommand(commands, info, names);
    }

    // set up the actual process
    protected boolean processCommand(String commands, String info, String names) {
        // use an if statement to determine which command shall be exectuted
        if (commands.equalsIgnoreCase("")) {
            try {

            } catch (Exception e) {
                // output error
                System.out.println(" failed");
            }

            // return true to the user
            return true;

        } else if (commands.equalsIgnoreCase("")) {
            // use trycatch to catch any error
            try {

            } catch (Exception e) {
                // output error
                System.out.println("Failed");
            }
            // return true to the user
            return true;
        } else {
            // output invalid command
            System.out.println("command is nonexistant");
            // return true to the user
            return true;
        }
    }
}
