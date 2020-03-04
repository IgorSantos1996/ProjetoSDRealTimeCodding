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

        //this.nomeColaborador = nomeColaborador;

        Socket clientSocket = new Socket("10.50.197.114", porta);




    }
}