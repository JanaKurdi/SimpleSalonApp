package Server;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Razan Alshaikh
 */
public class ThreadedHandlerServer implements Runnable {

    private Socket client;
    private PrintWriter Out;
    private serverWindow serverWindow;
    private boolean done = false;

    public ThreadedHandlerServer(Socket client, serverWindow serverWindow) {
        this.client = client;
        this.serverWindow = serverWindow;

    }

    public void run() {

        try {
            InputStream inStream = client.getInputStream();
            OutputStream outStream = client.getOutputStream();
            Scanner sc = new Scanner(inStream);
            Out = new PrintWriter(outStream, true);

            Out.println("Dear Customer we are hear to help you! "
                    + "Please let us know if there's anything "
                    + "we can help you with or  Enter BYE to exit.");
           
            while (!done) {
                String text = sc.nextLine();
                System.out.println(text);
                if (text.startsWith("Name")) {
                    serverWindow.setClientName(text.split(";")[1]);
                } else {
                    serverWindow.addClientText(text);
                }
            }
            client.close();
        } catch (Exception e) {

            return;
        }

    }

    public void sendMessage(String text) {
        Out.println(text);
        if (text.trim().equalsIgnoreCase("bye")) {
            done = true;
        }
    }
}
