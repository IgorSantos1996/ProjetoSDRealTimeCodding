import javax.swing.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteTCP {

    Integer porta;
    String nomeColaborador, sentenca;
    public Boolean conect = false;
    Escritorio escritorio;

    public ClienteTCP(Integer porta, String nomeColaborador) throws IOException {


        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        this.nomeColaborador = nomeColaborador;


        Socket clientSocket = new Socket("192.168.1.7", porta);
        //System.out.println(this.nomeColaborador + " Conectou: " + clientSocket.isConnected());
        conect = clientSocket.isConnected();

        if (conect == true) {

            //Cria cadeia de saida conectada ao socket
            DataOutputStream outToServer =
                    new DataOutputStream(clientSocket.getOutputStream());

            //Cria cadeia de entrada conectada ao socket
            BufferedReader inFromServer =
                    new BufferedReader(new
                            InputStreamReader(clientSocket.getInputStream()));

            //Envia uma linha ao servidor
            outToServer.writeBytes(this.nomeColaborador);
            outToServer.writeUTF(escritorio.jTextArea1.getText());


        } else {
            System.out.println("Cliente não está conectada");
        }


    }
}