import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Comentario implements ActionListener {

    public JFrame      JComentario;
    public JPanel      JPainel;
    public JTextArea   JTextArea;
    public JScrollPane JBarraDeRolagem;
    public JButton     btnEnviar;

    public Comentario() {
        JComentario = new JFrame("Comentário");
        JTextArea = new JTextArea(15, 50);
        JBarraDeRolagem = new JScrollPane(JTextArea);
        btnEnviar = new JButton("Enviar");
        JPainel = new JPanel();
        inicializarComponentes();
    }

    public void inicializarComponentes() {

        btnEnviar.addActionListener(this);

        JBarraDeRolagem.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        JBarraDeRolagem.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        JPainel.add(JBarraDeRolagem);
        JPainel.add(btnEnviar);
        JComentario.getContentPane().add(JPainel);

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