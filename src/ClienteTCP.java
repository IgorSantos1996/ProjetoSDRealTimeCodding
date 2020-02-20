import java.io.IOException;
import java.net.Socket;

public class ClienteTCP{

    Integer porta;
    String nomeColaborador;
    public Boolean conect = false;
    public ClienteTCP(Integer porta, String nomeColaborador) throws IOException {

        //System.out.println(porta);
        //System.out.println(new APP().getIP());

        this.nomeColaborador = nomeColaborador;
        Socket clientSocket = new Socket("localhost", porta);
        System.out.println(this.nomeColaborador + " Conectou: " + clientSocket.isConnected());
        conect = clientSocket.isConnected();

    }

}
