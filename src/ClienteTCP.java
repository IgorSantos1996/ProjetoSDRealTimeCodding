import javax.swing.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteTCP {

    Integer porta;
    String nomeColaborador, sentenca, modifiedSentence;
    public Boolean conect = false;
    Escritorio escritorio;
    String mensagem = "";

    public ClienteTCP(Integer porta, String nomeColaborador, String texto) throws IOException {
        this.mensagem = texto;
        this.porta = porta;

        //cadeia de entrada
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("192.168.31.92", porta);
        if (clientSocket.isConnected()) {
            System.out.println("Connected");
        }
        DataOutputStream outToServer =
                new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer =
                new BufferedReader(new
                        InputStreamReader(clientSocket.getInputStream()));

        sentenca = texto;
        System.out.println("ClienteTCP: " + sentenca);
        outToServer.writeBytes(sentenca);
        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);
        clientSocket.close();
    }

}