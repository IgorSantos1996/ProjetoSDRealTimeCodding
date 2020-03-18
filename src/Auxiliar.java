import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Map;

public class Auxiliar extends Thread {

    Socket socket;
    String parar="";

    public Auxiliar(Socket socket) {
        this.socket = socket;
    }

    public Auxiliar() {

    }
    public void run() {
        try {
            BufferedReader inFromCliente = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          //  System.out.println("tar 1");
            String codigo = inFromCliente.readLine();
            parar ="1";
          //  System.out.println("tar 2");
            socket.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }
}
