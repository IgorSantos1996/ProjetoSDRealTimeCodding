import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

    String sentencaCliente;

    public ServidorTCP() {
        try {
            ServerSocket welcomeSocket = new ServerSocket(6000);
            while (true) {
                Socket connectionSocket = welcomeSocket.accept();

                //Cria cadeia de entrada, conectada ao socket
                BufferedReader inFromClient =
                        new BufferedReader(new
                                InputStreamReader(connectionSocket.getInputStream()));

                //Cria cadeia de saida, conectada ao socket
                DataOutputStream outToClient =
                        new DataOutputStream(connectionSocket.getOutputStream());

                sentencaCliente = inFromClient.readLine();

                System.out.println("Nome do colaborador: "+sentencaCliente);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
