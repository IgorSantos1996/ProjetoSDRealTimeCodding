import javax.swing.*;

public class Escritorio {

    private JScrollPane jScrollPane1;
    private JTextArea   jTextArea1;
    public  JFrame      jFrame;

    LinhasNoJTextArea numeroLinhas;

    public Escritorio() {
        initComponents();
        numeroLinhas = new LinhasNoJTextArea(jTextArea1);
        jScrollPane1.setRowHeaderView(numeroLinhas);
    }

    @SuppressWarnings("unchecked")
    public void initComponents() {

        jScrollPane1 = new JScrollPane();
        jTextArea1   = new JTextArea();
        jFrame       = new JFrame();

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

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


}
