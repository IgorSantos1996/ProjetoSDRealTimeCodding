import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class Colaborador extends JFrame implements ActionListener {
    private Boolean temContribuintes = null;
    private Integer id;
    private String colaborador;
    public JFrame jFrameColaborador;
    private JLabel nomeColaborador;
    private JButton okColaborador;
    public JTextField jTextField;

    private boolean c;


    public String getColaborador() {
        return colaborador;
    }

    public void setColaborador(String colaborador) {
        this.colaborador = colaborador;
    }

    public Colaborador(String colaborador, Integer id) {
        this.colaborador = colaborador;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Colaborador(Boolean existe) {
        this.c = existe;
        jFrameColaborador = new JFrame("Credenciais Colaborador");
        //jFrameColaborador.setBounds(100, 100, 100, 100);
        URL path = this.getClass().getResource("programming-flag.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(path);
        jFrameColaborador.setIconImage(iconeTitulo);
        jTextField = new JTextField();
        nomeColaborador = new JLabel("Nome do Colaborador");
        okColaborador = new JButton("OK");
        //this.size = size;
        inicializar_componentes();

    }

    public void inicializar_componentes() {

        jFrameColaborador.add(okColaborador);
        jFrameColaborador.add(jTextField);
        jFrameColaborador.add(nomeColaborador);
        jTextField.setFont(new Font("arial", Font.CENTER_BASELINE, 14));
        nomeColaborador.setFont(new Font("arial", Font.CENTER_BASELINE, 14));
        okColaborador.setBounds(100, 190, 100, 30);
        nomeColaborador.setBounds(70, 50, 190, 30);
        jTextField.setBounds(80, 80, 170, 40);
        okColaborador.addActionListener(this);

        jFrameColaborador.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrameColaborador.getContentPane().setLayout(null);
        jFrameColaborador.setPreferredSize(new java.awt.Dimension(300, 300));
        jFrameColaborador.pack();
        jFrameColaborador.setLocationRelativeTo(null);
        jFrameColaborador.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(okColaborador)) {
            String getTitle = jTextField.getText();
            if(c == false){
                new Escritorio(getTitle).jFrame.show();
                new Comentario(getTitle).JComentario.show();
            }else{
                new Escritorio(getTitle).jFrame.show();
            }


            jFrameColaborador.dispose();

        }
    }
}
