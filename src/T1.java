import javax.swing.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class T1 extends Thread {

    Socket socket;

    public T1(Socket socket) {
        this.socket = socket;
    }

    public T1() {

    }
    public void run() {
        try {
            BufferedReader inFromCliente = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String codigo = inFromCliente.readLine();
            System.out.println(codigo);
            if (codigo.equalsIgnoreCase("10")) {
                System.out.println("entrou no 10");
                String nome = inFromCliente.readLine();
                System.out.println(nome);
                String texto = inFromCliente.readLine();
                System.out.println(texto);
                ServidorTCP1.listaColaboradores.put(nome, texto);
            } else if (codigo.equalsIgnoreCase("11")) {
                String nome = inFromCliente.readLine();
                String s = null;
                System.out.println("receber 1");
                while (true) {
                    System.out.println("receber 2");

                    if (s != ServidorTCP1.listaColaboradores.get(nome)) {
                        s = ServidorTCP1.listaColaboradores.get(nome);
                        DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
                        outToClient.writeBytes(s + '\n');
                        System.out.println("receber 3");
                    }

                }
            } else if (codigo.equalsIgnoreCase("12")) {
                String listaNomes = "";
                for (Map.Entry<String, String> pesquisar : ServidorTCP1.listaColaboradores.entrySet()) {
                    listaNomes += pesquisar.getKey() + ";";
                }
                DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
                outToClient.writeBytes(listaNomes + '\n');
            }


            socket.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }
}
