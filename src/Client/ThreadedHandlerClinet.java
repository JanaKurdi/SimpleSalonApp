package Client;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Razan Alshaikh
 */
public class ThreadedHandlerClinet implements Runnable {

    private Socket client;
    private PrintWriter Out;
    private clientWindow clientWindow;

    private boolean done = false;

    public ThreadedHandlerClinet(Socket client, clientWindow clientWindow) {
        this.client = client;
        this.clientWindow = clientWindow;
    }

    public void run() {

        try {
            InputStream inStream = client.getInputStream();
            OutputStream outStream = client.getOutputStream();
            Scanner sc = new Scanner(inStream);
            Out = new PrintWriter(outStream, true);
            clientWindow.addServerText(sc.nextLine());
            Out.println("Name;" + clientWindow.customer.getFName());
            while (!done) {
                String text = sc.nextLine();
                if (text.trim().equalsIgnoreCase("BYE")) {
                    done = true;
                    clientWindow.dispose();
                }
                clientWindow.addServerText(text);
            }
            client.close();

        } catch (Exception e) {
            System.exit(0);
        }
    }

    public void sendMessage(String text) {

        Out.println(text);
        if (text.trim().equalsIgnoreCase("BYE")) {
            done = true;
            clientWindow.dispose();
        }

    }

}
