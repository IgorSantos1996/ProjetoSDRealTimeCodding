import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ListaConexoes extends JFrame {
    JTable tabela;
    Object[][] dados;

    String[] colunas = new String[]{"Colaborador"};

    public ListaConexoes(List<String> lista) {

        List<String> auxiliar = new ArrayList<>();
        String registro;
        String concatena = "";
        int pos = 0;
        registro = lista.get(0);//igor;clovis;
        for (int i = 0; i < registro.length(); i++) {
            if (registro.charAt(i) != ';') {
                concatena += registro.charAt(i);
            } else {
                auxiliar.add(pos, concatena);
                //System.out.println(concatena);
                pos += 1;
                concatena = "";
            }


            //auxiliar.add(lista.get(i).split(";"));

        }
        dados = new Object[auxiliar.size()][auxiliar.size()];
        for (int i = 0; i < auxiliar.size(); i++) {
            System.out.println(auxiliar.get(i));
            dados[i][0] = auxiliar.get(i);
        }
        for (int i = 0; i < dados.length; i++) {
            System.out.println("Dados : " + dados[i][0]);
        }
        Iniciar();
    }

    public void Iniciar() {
        setLayout(new FlowLayout());
        setSize(new Dimension(400, 400));
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
        tabela.setPreferredScrollableViewportSize(new Dimension(300, 200));
        tabela.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane);
        setVisible(true);

    }

}
