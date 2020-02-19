import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Comentario implements ActionListener {

    public JFrame      JComentario;
    public JPanel      JPainel;
    public JTextArea   JTextArea1, JTextArea2;
    public JScrollPane JBarraDeRolagem;
    public JButton     btnEnviar;

    public Comentario() {
        JComentario = new JFrame("Comentário");
        JTextArea1  = new JTextArea(15, 50);
        JBarraDeRolagem = new JScrollPane(JTextArea1);
      //  btnEnviar   = new JButton("Enviar");
        //JTextArea2  = new JTextArea(15,50);
        //JPainel     = new JPanel();
        inicializarComponentes();
    }

    public void inicializarComponentes() {

        //btnEnviar.addActionListener(this);

//        JBarraDeRolagem.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
  //      JBarraDeRolagem.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        //JBarraDeRolagem.add(JTextArea1);
        //JComentario.add(btnEnviar);
        JComentario.getContentPane().add(JBarraDeRolagem);
        //JComentario.add(JTextArea1);



    //    btnEnviar.setBounds(50,50,100,100);
        JTextArea1.setBounds(15,15, 850, 300);

        JComentario.getContentPane().setLayout(null);
        JComentario.setPreferredSize(new Dimension(900, 650));

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