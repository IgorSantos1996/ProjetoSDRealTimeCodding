import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Comentario implements ActionListener {

    public JFrame      JComentario;
    public JTextArea   JTextArea1, JTextArea2;
    public JScrollPane JBarraDeRolagem1, JBarraDeRolagem2;
    public JButton     btnEnviar;

    public Comentario() {
        JComentario = new JFrame("Chat");
        JTextArea1  = new JTextArea(15, 50);
        JTextArea2  = new JTextArea(15,50);
        JBarraDeRolagem1 = new JScrollPane(JTextArea1);
        JBarraDeRolagem2 = new JScrollPane(JTextArea2);
        btnEnviar   = new JButton("Enviar");
        inicializarComponentes();
    }

    public void inicializarComponentes() {

        btnEnviar.addActionListener(this);

        JComentario.add(btnEnviar);
        JComentario.getContentPane().add(JBarraDeRolagem1);
        JComentario.getContentPane().add(JBarraDeRolagem2);

        btnEnviar.setBounds(270,569,100,30);
        JBarraDeRolagem1.setBounds(15,15, 600, 400);
        JBarraDeRolagem2.setBounds(15,450, 600, 100);

        JComentario.getContentPane().setLayout(null);
        JComentario.setPreferredSize(new Dimension(640, 650));

        JComentario.pack();
        JComentario.setLocationRelativeTo(null);
        JComentario.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnEnviar)) {
            System.out.print("OK");
        }
    }

}