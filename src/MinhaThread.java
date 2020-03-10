import javax.swing.*;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
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
            temp = textoCodigo;
            while (true) {
                for (Map.Entry<Integer, String> pesquisar : listaColaboradores.entrySet()) {
                    if (this.temp.equalsIgnoreCase(pesquisar.getValue())) {
                        JOptionPane.showMessageDialog(null, "Não houve alteração", "Informação do servidor", JOptionPane.WARNING_MESSAGE);
                    } else {
                        temp = pesquisar.getValue();
                        try {
                            EnviarTextoAtualizado(6000, "", temp);
                            System.out.println("Testo enviado");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
                return;
            }

        }
    }

    public void EnviarTextoAtualizado(Integer porta, String nomeColaborador, String texto) throws IOException {
        System.out.println("Texto quando chama o método para enviar ao servidor: " + texto);
        ClienteTCP clienteTCP = new ClienteTCP(porta, "", texto);
    }

    public String getTemp() {
        return temp;
    }

}
