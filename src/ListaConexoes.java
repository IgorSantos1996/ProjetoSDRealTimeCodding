import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ListaConexoes extends JFrame {
    JTable tabela;


    String[] colunas = new String[]{"Colaborador"};
    Object[][] dados = {
            {}
    };




    public ListaConexoes() {

        Iniciar();
    }

    public void Iniciar() {
        setLayout(new FlowLayout());
        setSize(new Dimension(300, 300));
        setLocationRelativeTo(null);
        setTitle("Lista Colaboradores");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


        tabela = new JTable();
        DefaultTableModel model = new DefaultTableModel(dados, colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabela.setModel(model);
        tabela.setPreferredScrollableViewportSize(new Dimension(200, 100));
        tabela.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane);
        setVisible(true);

    }

}
