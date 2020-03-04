import java.util.HashMap;

public class MinhaThread extends Thread {
    private static HashMap<Integer, String> listaColaboradores = new HashMap<>();
    String textoCodigo = new Escritorio().jTextArea1.getText();
    Integer Codigo; // 10, 11 ou 12
    String temp = "";

    public void run(String nome, Integer codigo) {
        this.textoCodigo = nome;
        this.Codigo = codigo;
        if (Codigo == 10) {
            temp = textoCodigo;
            listaColaboradores.put(new Colaborador().getId(), temp);
        }
    }
}
