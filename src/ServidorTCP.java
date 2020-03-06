import javax.swing.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ServidorTCP  {
    Socket connectionSocket;
    Escritorio escritorio;
    Colaborador colaborador;
    //Escritorio escritorio;

    public ServidorTCP() {
        try {

            ServerSocket welcomeSocket = new ServerSocket(6000);

            while (true) {
                connectionSocket = welcomeSocket.accept();


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
