/**
 * Java. Level 2. Lesson 6. Networking, my homework.
 * Class HelloClient: connect and ge hello from server
 *
 * @author Ilshat Nurgalimov
 * @version dated 12.11.2017
 * @task 6
 * @mark
 */
import java.net.*;
import java.io.*;

class HelloClient extends Thread {

    public static void main(String[] args) {
        while(true) {
            new HelloClient().start();
        }
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket("127.0.0.1", 1024); // or localhost
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());
            reader.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}