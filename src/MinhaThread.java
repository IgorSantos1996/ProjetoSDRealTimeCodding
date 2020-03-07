import javax.swing.*;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MinhaThread extends Thread {

    private static HashMap<Integer, String> listaColaboradores = new HashMap<>();
    Integer Codigo; // 10, 11 ou 12
    String temp = "";
    Integer id;
    String nome, textoCodigo;

    Socket socket;

    public MinhaThread(String nome, int id, String textoCodigo, int Codigo) {
        this.nome = nome;
        this.id = id;
        this.textoCodigo = textoCodigo;
        this.Codigo = Codigo;
    }

    public MinhaThread(String nome, int id, int Codigo) {
        this.nome = nome;
        this.id = id;
        this.Codigo = Codigo;
    }

    public MinhaThread(Socket socket) {
        this.socket = socket;
    }

    public MinhaThread() {
    }

    public void run() {

        temp = this.textoCodigo;
        if (Codigo == 10) {

            if (!listaColaboradores.containsKey(this.id)) {

                listaColaboradores.put(this.id, temp);

                listaColaboradores.forEach((k, v) -> System.out.println("Id: " + k + "Texto da pessoa: " + v));

            } else {
                for (Map.Entry<Integer, String> pesquisar : listaColaboradores.entrySet()) {
                    if (this.id == pesquisar.getKey()) {
                        listaColaboradores.put(this.id, temp);
                    }
                }
                listaColaboradores.forEach((k, v) -> System.out.println("Id: " + k + "Texto da pessoa: " + v));
            }


        } else if (Codigo == 11) {
            System.out.println(temp);
            while (true) {
                for (Map.Entry<Integer, String> pesquisar : listaColaboradores.entrySet()) {
                    if (temp != pesquisar.getValue()) {
                        System.out.println("entrei na condição");
                        temp = pesquisar.getValue();
                        EnviarTextoAtualizado(temp);
                        System.out.println("Testo enviado");

                    } else {
                        System.out.println(temp);
                        System.out.println("Não entrou na condição");

                    }
                }
            }
        }
    }

    public void EnviarTextoAtualizado(String texto) {
        ClienteTCP clienteTCP = new ClienteTCP(texto);
    }

    public String getTemp() {
        return temp;
    }

}
