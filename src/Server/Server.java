package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Razan Alshaikh
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (ServerSocket s = new ServerSocket(8189)) {
            System.out.println("Server started waiting for clients !!");
            while (true) {
                Socket client = s.accept();
                new serverWindow(client).setVisible(true);
 }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
