import javax.swing.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MinhaThread extends Thread {

    //private static HashMap<Integer, String> listaColaboradores = new HashMap<>();
    String Codigo; // 10, 11 ou 12
    String temp = "";
    Integer id;
    String nome, textoCodigo;
    Socket socket;
    JTextArea j;

    public MinhaThread(String nome, String textoCodigo, String Codigo) {
        this.nome = nome;
        this.textoCodigo = textoCodigo;
        this.Codigo = Codigo;
    }

    public MinhaThread(JTextArea j, String nome, String Codigo) {
        this.nome = nome;
        this.Codigo = Codigo;
        this.j = j;
    }


    public void run() {

        if (Codigo == "10") {
            try {
                System.out.println("teste1");
                Socket clientSocket = new Socket("192.168.137.81", 6000);
                DataOutputStream outToServer =
                        new DataOutputStream(clientSocket.getOutputStream());
                System.out.println("teste2");
                outToServer.writeBytes(Codigo + '\n');
                System.out.println(Codigo);
                outToServer.writeBytes(nome + '\n');
                System.out.println(nome);
                outToServer.writeBytes(textoCodigo + '\n');
                System.out.println(textoCodigo);
                clientSocket.close();
                System.out.println("teste3");


            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        } else if (Codigo == "11") {
            j.setText("bsdnfdsnfdsnfdsn");
        }
    }

    /*public void EnviarTextoAtualizado(Integer porta, String nomeColaborador, String texto) throws IOException {
        System.out.println("Texto quando chama o método para enviar ao servidor: " + texto);
        ClienteTCP clienteTCP = new ClienteTCP(porta, "", texto);
    }*/


}
