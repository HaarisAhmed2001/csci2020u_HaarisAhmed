import java.io.*;
import java.net.*;
import java.util.Vector;

public class lab10SecondServer {

    // declare thedefault parameter variables
    protected Socket ctSocket = null;
    protected ServerSocket serSocket = null;
    protected lab10ServerThread[] serThreads = null;
    protected int clientNums = 0;

    // set a max number of clients
    public static int maxClients = 50;

    // create a server port
    public static int serverPort = 11111;

    // create a server function
    public lab10SecondServer() {
        // use try catch to catch any variables
        try {
            // set the server socket
            serSocket = new ServerSocket(serverPort);

            // output a message to the user
            System.out.println("---------------------------");
            System.out.println("Simple BBS Server Application is running");
            System.out.println("---------------------------");
            System.out.println("Listening to port: " + serverPort);

            // set the length of the serThreads variable
            serThreads = new lab10ServerThread[maxClients];

            // use a while loop to constantly loop through the clients at hand
            while (true) {
                ctSocket = serSocket.accept();
                System.out.println("Client #" + (clientNums + 1) + " connected.");
                serThreads[clientNums] = new lab10ServerThread(ctSocket);
                serThreads[clientNums].start();
                clientNums++;
            }
        } catch (Exception e) {
            // output error
            System.out.println("Failure has occured when connecting to the server");
        }
    }

    public static void main(String[] args) {
        lab10Server altServer = new lab10Server();
    }
}