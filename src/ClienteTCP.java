import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteTCP{

    Integer porta;
    String nomeColaborador, sentenca;
    public Boolean conect = false;
    public ClienteTCP(Integer porta, String nomeColaborador) throws IOException {

        //System.out.println(porta);
        //System.out.println(new APP().getIP());
        //Cria cadeia de entrada
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        this.nomeColaborador = nomeColaborador;
        Socket clientSocket = new Socket(new APP().getIP(), porta);
        //System.out.println(this.nomeColaborador + " Conectou: " + clientSocket.isConnected());
        conect = clientSocket.isConnected();

        if(conect == true){

            //Cria cadeia de saida conectada ao socket
            DataOutputStream outToServer =
                    new DataOutputStream(clientSocket.getOutputStream());

            //Cria cadeia de entrada conectada ao socket
            BufferedReader inFromServer =
                    new BufferedReader(new
                            InputStreamReader(clientSocket.getInputStream()));

            //Envia uma linha ao servidor
            outToServer.writeBytes(this.nomeColaborador );

        }

    }

}