import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class Colaborador extends JFrame implements ActionListener {

    private Boolean   temContribuintes = null;
    public  Integer   id;
    private String    colaborador;
    public  JFrame    jFrameColaborador;
    private JLabel    nomeColaborador;
    private JButton   okColaborador;
    public JTextField jTextField;

    //referente ao id
    //private JLabel idColaborador;
    private JTextField JTextFieldColaborador;

    public String getColaborador() {
        return colaborador;
    }

    public void setColaborador(String colaborador) {
        this.colaborador = colaborador;
    }

    public Colaborador() {

        jFrameColaborador = new JFrame("Credenciais Colaborador");

        URL path = this.getClass().getResource("programming-flag.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(path);
        jFrameColaborador.setIconImage(iconeTitulo);
        jTextField = new JTextField();
        nomeColaborador = new JLabel("Nome do Colaborador");
        okColaborador = new JButton("OK");
        //idColaborador = new JLabel("Id do Colaborador");
        JTextFieldColaborador = new JTextField();
        inicializar_componentes();

    }

    public void inicializar_componentes() {

        jFrameColaborador.add(okColaborador);
        jFrameColaborador.add(jTextField);
        jFrameColaborador.add(nomeColaborador);
        //jFrameColaborador.add(JTextFieldColaborador);
        //jFrameColaborador.add(idColaborador);

        jTextField.setFont(new Font("arial", Font.CENTER_BASELINE, 14));
        //JTextFieldColaborador.setFont(new Font("arial", Font.CENTER_BASELINE, 14));
        nomeColaborador.setFont(new Font("arial", Font.CENTER_BASELINE, 14));
        //idColaborador.setFont(new Font("arial", Font.CENTER_BASELINE, 14));

        okColaborador.setBounds(100, 190, 100, 30);
        nomeColaborador.setBounds(70, 20, 190, 30);
        //idColaborador.setBounds(70, 100, 190, 30);

        jTextField.setBounds(80, 50, 170, 40);
        //JTextFieldColaborador.setBounds(80, 130, 170, 40);
        okColaborador.addActionListener(this);

        jFrameColaborador.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrameColaborador.getContentPane().setLayout(null);
        jFrameColaborador.setPreferredSize(new Dimension(300, 300));
        jFrameColaborador.pack();
        jFrameColaborador.setLocationRelativeTo(null);
        jFrameColaborador.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(okColaborador)) {
            String getTitle = jTextField.getText();
          //  this.id = Integer.parseInt(JTextFieldColaborador.getText());
            new Escritorio(getTitle).jFrame.show();
        }

        jFrameColaborador.dispose();

    }

}

