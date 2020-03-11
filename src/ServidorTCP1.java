import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ServidorTCP1 {

    public static HashMap<String, String> listaColaboradores = new HashMap<>();


    public static void main(String args[]) {
        try {

            ServerSocket welcomeSocket = new ServerSocket(6000);

            while (true) {

                Socket connectionSocket = welcomeSocket.accept();
                System.out.println("Aceitou conexao");
                T1 t = new T1(connectionSocket);
                t.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
