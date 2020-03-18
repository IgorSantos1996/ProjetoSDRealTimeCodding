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

                //String parar="0";
                TARMENGO TTTT = new TARMENGO(socket);
                TTTT.start();
                while (true) {

                    if (TTTT.parar.equalsIgnoreCase("1")) {
                        System.out.println("entrou isconnected");
                        return;
                    }

                    System.out.println(TTTT.parar);

                    System.out.println(ServidorTCP1.listaColaboradores.get(nome));
                    if (s != ServidorTCP1.listaColaboradores.get(nome)) {
                        s = ServidorTCP1.listaColaboradores.get(nome);
                        DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
                        outToClient.writeBytes(s + '\n');
                    }

                }
            } else if (codigo.equalsIgnoreCase("12")) {
                System.out.println("Entrou na listagem de nomes");
                String listaNomes = "";
                for (Map.Entry<String, String> pesquisar : ServidorTCP1.listaColaboradores.entrySet()) {
                    listaNomes += pesquisar.getKey() + ";";
                }
                DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
                System.out.println("Lista nomes no servidor: " + listaNomes);
                outToClient.writeBytes(listaNomes + '\n');
            }


            socket.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }
}
