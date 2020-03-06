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
            //System.out.println("Nome: "+this.nome+"Id: "+this.id+"Texto: "+temp+"Codigo: "+this.Codigo);
            if (!listaColaboradores.containsKey(this.id)) {
                //antes de inserir no HashMap
                listaColaboradores.put(this.id, temp);
                //depois de inserir no HashMap
                listaColaboradores.forEach((k,v) -> System.out.println("Id: " + k + "Texto da pessoa: "+  v) );

            } else {
                for (Map.Entry<Integer, String> pesquisar : listaColaboradores.entrySet()) {
                    if (this.id == pesquisar.getKey()) {
                        listaColaboradores.put(this.id, temp);
                    }
                }
            }
            //try {
             //   socket.close();
            //} catch (IOException e) {
              //  e.printStackTrace();
            //}

        } else if (Codigo == 11) {
            temp = "";
            while (true) {
                for (Map.Entry<Integer, String> pesquisar : listaColaboradores.entrySet()) {
                    if (this.id == pesquisar.getKey() && temp != pesquisar.getValue()) {
                        temp = pesquisar.getValue();
                        EnviarTextoAtualizado(temp);
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
