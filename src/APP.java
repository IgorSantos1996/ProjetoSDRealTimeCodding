import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Timer;


public class APP extends JLabel implements ActionListener {

    private JLabel contribuintes, mensagemPorta;
    private JTextField campodata, numeroContribuintes;
    private JMenuBar mnBarra;
    private JMenu mnSobre, mnParticipar;
    private Image iconeTitulo;
    private ImageIcon background = new ImageIcon(getClass().getResource("programming-flag.png"));
    private JLabel fundo, auxiliar;
    private JMenuItem miAutores, miColaborar;
    private JFrame jFramePrincipal;
    private JButton botaoIniciar, feito;
    Random random = new Random();
    Integer numberAcesso = random.nextInt(10000);
    private Timer timer;
    private int delay = 2000;
    BlinkLabel bl;

    public APP() {
        jFramePrincipal = new JFrame("Real time codding");
        mnBarra = new JMenuBar();
        //miSair = new JMenu("Sair");
        contribuintes = new JLabel("Quantidade de participantes");
        numeroContribuintes = new JTextField();
        campodata = new JTextField();
        mnSobre = new JMenu("Sobre");
        mnParticipar = new JMenu("Participar");
        feito = new JButton("Feito");
        //mnExportar  = new JMenu("Exportar Classe java");
        botaoIniciar = new JButton("Iniciar");
        miAutores = new JMenuItem("Info autores");
        mensagemPorta = new JLabel("Porta de acesso");
        miColaborar = new JMenuItem("Colaborar");
        inicializarComponentes();

    }

    public void inicializarComponentes() {

        Image img = background.getImage();
        Image temp = img.getScaledInstance(900, 650, Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        fundo = new JLabel(background);
        fundo.setLayout(null);
        auxiliar = new JLabel(background);
        jFramePrincipal.setContentPane(auxiliar);
        mnBarra.add(mnSobre);
        botaoIniciar.addActionListener(this);
        mnSobre.add(miAutores);
        mnParticipar.add(miColaborar);
        mnBarra.add(mnParticipar);

        miAutores.addActionListener(this);
        miColaborar.addActionListener(this);
        feito.addActionListener(this);
        jFramePrincipal.setJMenuBar(mnBarra);
        jFramePrincipal.add(numeroContribuintes);
        jFramePrincipal.add(contribuintes);
        jFramePrincipal.add(feito);
        jFramePrincipal.add(mensagemPorta);

        /*Gerando numero de acesso*/

        bl = new BlinkLabel(numberAcesso.toString());
        //System.out.println("TesteOK: "+numberAcesso.toString());

        jFramePrincipal.add(bl);

        jFramePrincipal.add(botaoIniciar);
        URL path = this.getClass().getResource("programming-flag.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(path);

        jFramePrincipal.setIconImage(iconeTitulo);

        botaoIniciar.setBounds(380, 520, 100, 30);

        botaoIniciar.setEnabled(false);
        numeroContribuintes.setBounds(380, 470, 150, 30);
        contribuintes.setBounds(180, 470, 200, 30);
        feito.setBounds(540, 470, 100, 30);
        jFramePrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFramePrincipal.getContentPane().setLayout(null);
        jFramePrincipal.setPreferredSize(new java.awt.Dimension(900, 650));
        jFramePrincipal.pack();
        jFramePrincipal.setLocationRelativeTo(null);
        jFramePrincipal.setResizable(false);
        //HORA E DATA
        Date data = new Date();
        DateFormat sdf = DateFormat.getDateInstance(DateFormat.DEFAULT);
        //System.out.println(formatador.format(data));
        campodata.setText(sdf.format(data));
        campodata.setBounds(730, 10, 150, 50);
        campodata.setBorder(new LineBorder(Color.WHITE, 0, false));
        campodata.setFont(new Font("arial", Font.BOLD, 16));
        jFramePrincipal.add(campodata);
        campodata.setEnabled(false);
        //feito.setEnabled(false);
        contribuintes.setFont(new Font("arial", Font.CENTER_BASELINE, 14));
        numeroContribuintes.setFont(new Font("arial", Font.CENTER_BASELINE, 14));
        jFramePrincipal.getRootPane().setDefaultButton(botaoIniciar);
        bl.setBounds(150, 5, 70, 40);
        bl.setFont(new Font("arial", Font.ITALIC, 14));
        bl.setBorder(new LineBorder(Color.BLUE, 5, true));
        mensagemPorta.setBounds(20, 3, 140, 50);
        mensagemPorta.setFont(new Font("arial", Font.ITALIC, 14));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ((!numeroContribuintes.getText().trim().isEmpty()) && (e.getSource().equals(feito))) {
            System.out.println(numeroContribuintes.getText());
            botaoIniciar.setEnabled(true);
            feito.setEnabled(false);
            numeroContribuintes.setEditable(false);

        }

        if (e.getSource().equals(botaoIniciar)) {


        } else if (e.getSource().equals(miAutores)) {
            JOptionPane.showMessageDialog(null, "Ainda não implementado");
        } else if (e.getSource().equals(miColaborar)) {
            JOptionPane.showMessageDialog(null, "Ainda não implementado");
        }
    }

    public static void main(String[] args) {
        try {

            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new APP().jFramePrincipal.show();
            }
        });

    }
}