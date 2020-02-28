import javax.swing.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

    String sentencaCliente;
    String JtextAreaColaborador;
    Escritorio escritorio;

    //Escritorio escritorio;


//    private void textareaAtualiza(){
//
//
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//    }

    public ServidorTCP() {
        try {

            ServerSocket welcomeSocket = new ServerSocket(6000);

            System.out.println("Servidor instaciado");

            while (true) {
                Socket connectionSocket = welcomeSocket.accept();

                //Cria cadeia de entrada, conectada ao socket
                BufferedReader inFromClient =
                        new BufferedReader(new
                                InputStreamReader(connectionSocket.getInputStream()));

                //Cria cadeia de saida, conectada ao socket
                DataOutputStream outToClient =
                        new DataOutputStream(connectionSocket.getOutputStream());

                sentencaCliente = inFromClient.readLine();
                JtextAreaColaborador = inFromClient.readLine();

                System.out.println("Nome do colaborador: " + sentencaCliente);

                if (sentencaCliente != null) {
                    new Escritorio(sentencaCliente).jFrame.show();
                    //sentencaCliente = null;
               // } else if (JtextAreaColaborador != null) {
                  //  escritorio.jTextArea1.setText(JtextAreaColaborador);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
