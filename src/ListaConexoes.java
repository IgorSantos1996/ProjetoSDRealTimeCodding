import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ListaConexoes extends JFrame {
    JTable tabela;
    Object[][] dados;

    String[] colunas = new String[]{"Colaborador"};
    List<String> auxiliar;

    public ListaConexoes(List<String> lista) {

        auxiliar = new ArrayList<>();
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

        tabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int linha = tabela.getSelectedRow();
                    for (int i = 0; i < auxiliar.size(); i++) {
                        if (i == linha) {
                            System.out.println("Auxiliar : " + auxiliar.get(i));
                            new Escritorio(auxiliar.get(i)).jFrame.show();
                        }
                    }
                }
            }
        });
        /*tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                if (listSelectionEvent.getValueIsAdjusting())
                    return;
                int selected = listSelectionEvent.getLastIndex();
                //int selected = (int) tabela.getValueAt(tabela.getSelectedRow(), 0);
                System.out.println("selected: " + selected);
                for (int i = 0; i < auxiliar.size(); i++) {
                    if (i == selected) {
                        System.out.println("Auxiliar : " + auxiliar.get(i));
                        new Escritorio(auxiliar.get(i)).jFrame.show();
                    } else
                        System.out.println("entro aqui");
                }
                selected=0;
            }
        });

         */

    }

}
