import javax.swing.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ServidorTCP {
    Socket connectionSocket;
    Escritorio escritorio;
    Colaborador colaborador;
    String clienteSetence;

    public ServidorTCP() {
        try {

            ServerSocket welcomeSocket = new ServerSocket(6000);

            while (true) {

                connectionSocket = welcomeSocket.accept();
                BufferedReader inFromCliente = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

                clienteSetence = inFromCliente.readLine();

                outToClient.writeBytes(clienteSetence.toUpperCase());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
