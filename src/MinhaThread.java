import java.net.Socket;
import java.util.HashMap;

public class MinhaThread extends Thread {

    private static HashMap<Integer, String> listaColaboradores = new HashMap<>();
//    String textoCodigo = new Escritorio().jTextArea1.getText();
    Integer Codigo; // 10, 11 ou 12
    String temp = "";
    Integer id;

    public MinhaThread(int id, int Codigo){this.id = id;this.Codigo = Codigo;}

    public MinhaThread(Socket socket){

    }

    public void run() {
        //this.textoCodigo = nome;

        if (Codigo == 10) {
    //        temp = textoCodigo;
            System.out.println("Codigo: "+this.Codigo);
            System.out.println("ID: "+this.id);
            listaColaboradores.put(this.id, temp);

        }
    }
}
