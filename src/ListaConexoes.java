import javax.swing.*;
import java.awt.*;

public class ListaConexoes extends JFrame {
    JPanel painelFundo;
    JTable tabela;
    JScrollPane barraRolagem;


    String[] colunas = {"Colaborador", "IP"};

    public ListaConexoes() {
        super("Lista de Colaboradores");
    }
    public void criaJanela(){
        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(1, 1));
       // tabela = new JTable("", colunas);

    }

}
