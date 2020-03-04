import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Escritorio implements ActionListener {

    private JScrollPane jScrollPane1;
    public JTextArea jTextArea1;
    public JFrame jFrame;
    public JLabel jlabelnome;
    //public JButton jbuttonAtualizar;
    private JMenuBar menuColaborador;
    public JMenu atualizar, enviar;
    private JMenuItem atualizarArea, enviar_codigo;

    LinhasNoJTextArea numeroLinhas;

    public Escritorio() {
    }

    public Escritorio(String nome) {
        initComponents(nome);
        numeroLinhas = new LinhasNoJTextArea(jTextArea1);
        jScrollPane1.setRowHeaderView(numeroLinhas);

    }

    @SuppressWarnings("unchecked")
    public void initComponents(String nome) {
        //Colaborador c = new Colaborador();
        //System.out.println("teste: "+c.jTextField.toString());
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jFrame = new JFrame(nome);
        // jbuttonAtualizar = new JButton("Atualizar");
        //jFrame.add(jbuttonAtualizar);

        /*Menu*/
        menuColaborador = new JMenuBar();
        atualizarArea = new JMenuItem("Atualizar area");
        enviar_codigo = new JMenuItem("Enviar Codigo");
        jFrame.setJMenuBar(menuColaborador);
        atualizar = new JMenu("Atualizar Janela");
        enviar = new JMenu("Enviar Codigo colaborado");

        //jFrame.setTitle(c.jTextField.toString());
        jlabelnome = new JLabel();
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Ubuntu", 0, 24));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        jFrame.setPreferredSize(new java.awt.Dimension(900, 650));
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);

        menuColaborador.add(atualizar);
        menuColaborador.add(enviar);
        atualizar.add(atualizarArea);
        atualizarArea.addActionListener(this);
        enviar.add(enviar_codigo);
        enviar_codigo.addActionListener(this);


        GroupLayout layout = new GroupLayout(jFrame.getContentPane());
        jFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        jFrame.pack();
    }//initComponents


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(atualizarArea)) {
            System.out.println("Clicou em atualizar");
        } else if (e.getSource().equals(enviar_codigo)) {
            System.out.println("Clicou em enviar");
        }
    }
}
