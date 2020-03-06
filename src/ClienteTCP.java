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
    String mensagem = "";

    public ClienteTCP(String texto){
        this.mensagem = texto;
    }

    public ClienteTCP(Integer porta, String nomeColaborador) throws IOException {

        //this.nomeColaborador = nomeColaborador;
        Socket clientSocket = new Socket("10.50.206.205", porta);
        DataOutputStream outToServer =
                new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer =
                new BufferedReader(new
                        InputStreamReader(clientSocket.getInputStream()));

        mensagem = new MinhaThread().getTemp();
        System.out.println(mensagem);
        outToServer.writeBytes(mensagem);

    }

}