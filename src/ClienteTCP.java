import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteTCP extends Thread {

    Integer porta;
    String nomeColaborador, modifiedSentence;
    String sentence;
    DataOutputStream outToServer;
    BufferedReader inFromServer;

    public ClienteTCP(Integer porta, String nomeColaborador) throws IOException {

        //System.out.println(porta);
        //System.out.println(new APP().getIP());

        this.nomeColaborador = nomeColaborador;
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("localhost", porta);
        System.out.println(this.nomeColaborador + " Conectou: " + clientSocket.isConnected());

        if (clientSocket.isConnected()) {
            DataOutputStream outToServer =
                    new DataOutputStream(clientSocket.getOutputStream());

            BufferedReader inFromServer =
                    new BufferedReader(new
                            InputStreamReader(clientSocket.getInputStream()));

            sentence = inFromUser.readLine();
        }


    }

    public void run() {
        try {

            outToServer.writeBytes(this.sentence + '\n');
            modifiedSentence = inFromServer.readLine();
            System.out.println("FROM SERVER: " + modifiedSentence);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
