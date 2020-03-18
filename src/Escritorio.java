import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Escritorio extends WindowAdapter implements ActionListener {
    private ClienteTCP1 clienteTCP2, clienteTCP3;

    private JScrollPane jScrollPane1;
    public JTextArea jTextArea1;
    public JFrame jFrame;
    public JLabel jlabelnome;
    //public JButton jbuttonAtualizar;
    private JMenuBar menuColaborador;
    public JMenu atualizar, enviar, listar;
    private JMenuItem atualizarArea, enviar_codigo, ListarTodosColaboradores;
    LinhasNoJTextArea numeroLinhas;
    int id;
    String nome;
    ArrayList<String> aux = new ArrayList<String>();
    String textoCodigo;

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
        ListarTodosColaboradores = new JMenuItem("Listar Todos os Colaboradores");
        jFrame.setJMenuBar(menuColaborador);
        atualizar = new JMenu("Atualizar Janela");
        listar = new JMenu("Listar colaboradores");
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
        menuColaborador.add(listar);
        atualizar.add(atualizarArea);
        atualizarArea.addActionListener(this);
        enviar.add(enviar_codigo);
        enviar_codigo.addActionListener(this);
        listar.add(ListarTodosColaboradores);
        ListarTodosColaboradores.addActionListener(this);

        this.nome = nome;

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


        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (clienteTCP2 != null)
                    clienteTCP2.teste();

            }
        });
        jFrame.dispose();
        jFrame.pack();

    }//initComponents


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(enviar_codigo)) {
            textoCodigo = jTextArea1.getText();

            ClienteTCP1 clienteTCP1 = new ClienteTCP1(this.nome, textoCodigo, "10");
            clienteTCP1.start();
        } else if (e.getSource().equals(atualizarArea)) {
            clienteTCP2 = new ClienteTCP1(jTextArea1, this.nome, "11");
            clienteTCP2.start();
            System.out.println("Clicou em enviar");
        } else if (e.getSource().equals(ListarTodosColaboradores)) {
            clienteTCP3 = new ClienteTCP1("12");
            clienteTCP3.start();
        }
    }


}