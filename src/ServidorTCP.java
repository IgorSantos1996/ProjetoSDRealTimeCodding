import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {


    public ServidorTCP() {
        try {
            ServerSocket welcomeSocket = new ServerSocket(6000);
            while (true) {
                Socket connectionSocket = welcomeSocket.accept();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
