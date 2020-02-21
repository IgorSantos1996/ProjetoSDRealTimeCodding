import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    String clientSentence;
    String capitalizedSentence;
    BufferedReader inFromClient;
    DataOutputStream outToClient;

    public ServidorTCP() {
        try {
            ServerSocket welcomeSocket = new ServerSocket(6000);
            while (true) {
                Socket connectionSocket = welcomeSocket.accept();
                BufferedReader inFromClient =
                        new BufferedReader(new
                                InputStreamReader(connectionSocket.getInputStream()));

                DataOutputStream outToClient =
                        new DataOutputStream(connectionSocket.getOutputStream());

                clientSentence = inFromClient.readLine();

                outToClient.writeBytes(clientSentence);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
