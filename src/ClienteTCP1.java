import javax.swing.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClienteTCP1 extends Thread {

    //private static HashMap<Integer, String> listaColaboradores = new HashMap<>();
    String Codigo; // 10, 11 ou 12
    String temp = "";
    Integer id;
    String nome, textoCodigo;
    Socket socket;
    JTextArea j;
    Thread Minhathread;

    public ClienteTCP1(String nome, String textoCodigo, String Codigo) {
        this.nome = nome;
        this.textoCodigo = textoCodigo;
        this.Codigo = Codigo;
    }

    public ClienteTCP1(JTextArea j, String nome, String Codigo) {
        this.nome = nome;
        this.Codigo = Codigo;
        this.j = j;
    }


    public void run() {

        if (Codigo.equalsIgnoreCase("10")) {
            try {

                Socket clientSocket = new Socket("192.168.137.81", 6000);
                DataOutputStream outToServer =
                        new DataOutputStream(clientSocket.getOutputStream());

                outToServer.writeBytes(Codigo + '\n');

                outToServer.writeBytes(nome + '\n');

                outToServer.writeBytes(textoCodigo + '\n');

                clientSocket.close();


            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        } else if (Codigo.equalsIgnoreCase("11")) {
            //j.setText("bsdnfdsnfdsnfdsn");
            try {
                Socket clienteSocket = new Socket("192.168.137.81", 6000);
                DataOutputStream outToServer =
                        new DataOutputStream(clienteSocket.getOutputStream());
                outToServer.writeBytes(Codigo + '\n');
                outToServer.writeBytes(nome + '\n');
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
                while (true) {

                    String sentence = inFromServer.readLine();
                    System.out.println("Sentence: " + sentence);
                    //j.setText(sentence);
                    //new T1().stop();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
