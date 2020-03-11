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

    Socket clienteSocket;

    JTextArea j;
    Thread Minhathread;
    boolean conexao=true;

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


    public void teste() {
        System.out.println("entrou em teste");
        try {
            System.out.println("entrou em teste 2");
            if (clienteSocket != null) {
                System.out.println("entrou em teste 3");
                DataOutputStream outToServer =
                        new DataOutputStream(clienteSocket.getOutputStream());
                System.out.println("entrou em teste 4");
                outToServer.writeBytes("oi" + '\n');
                System.out.println("entrou em teste 5");
            }
        } catch (Exception ex) {
            System.out.println("entrou em teste 6");
        }
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
                clienteSocket = new Socket("192.168.137.81", 6000);
                DataOutputStream outToServer =
                        new DataOutputStream(clienteSocket.getOutputStream());
                outToServer.writeBytes(Codigo + '\n');
                outToServer.writeBytes(nome + '\n');
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
                while (conexao) {

                    String sentence = inFromServer.readLine();
                    System.out.println("Sentence: " + sentence);
                    j.setText(sentence);
                    //new T1().stop();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
