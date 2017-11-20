/*
* @author Nikolay Gabaraev
* @version dated Nov 03, 2017
* @task 6
* @mark
*/
import java.io.*;
import java.net.*;
import java.util.*;

class SimpleClient {

    final String SERVER_ADDR = "127.0.0.1"; // or "localhost"
    final int SERVER_PORT = 2048;
    final String CLIENT_PROMPT = "$ ";
    final String CONNECT_TO_SERVER = "Connection to server established.";
    final String CONNECT_CLOSED = "Connection closed.";
    final String EXIT_COMMAND = "exit"; // command for exit

    Socket socket;
    Scanner scanner;
    PrintWriter writer;
    String message;
    BufferedReader reader;
    String serverSay;

    public static void main(String[] args) {
        new SimpleClient();
    }

    SimpleClient()  {
        scanner = new Scanner(System.in); // for keyboard input
        try {
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());
            System.out.println(CONNECT_TO_SERVER);
            do {
                System.out.print(CLIENT_PROMPT);
                message = scanner.nextLine();
                writer.println(message);
                writer.flush();
                serverSay = reader.readLine();

                if (serverSay.isEmpty()) {
                }else {
                    System.out.println("Server: " + serverSay);
                }

            } while (!message.equals(EXIT_COMMAND));
            writer.close();
            socket.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(CONNECT_CLOSED);
    }
}