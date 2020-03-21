import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Timer;


public class APP extends JLabel implements ActionListener {

    private JLabel mensagemPorta, mensagemIP;
    private boolean clicked = false;
    //public JTextField campodata;
    private JMenuBar mnBarra;
    public JMenu mnParticipar;
    private Image iconeTitulo;
    private ImageIcon background = new ImageIcon(getClass().getResource("atualizada.jpeg"));
    private JLabel fundo, auxiliar, labelIPhhost;
    private JMenuItem miColaborar;
    private JFrame jFramePrincipal;
    Random random = new Random();
    private Timer timer;
    private int delay = 2000;
    BlinkLabel bl, blIP;
    private Boolean existeColaborador = false;
    private Integer contador = 0;

    public APP() {
        jFramePrincipal = new JFrame("Real time codding");
        mnBarra = new JMenuBar();
        //campodata = new JTextField();
        mnParticipar = new JMenu("Participar");
        mensagemPorta = new JLabel("Porta de acesso");
        mensagemIP = new JLabel("IP da máquina");
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
        mnBarra.add(mnParticipar);
        mnParticipar.add(miColaborar);
        miColaborar.addActionListener(this);
        jFramePrincipal.setJMenuBar(mnBarra);
        jFramePrincipal.add(mensagemPorta);
        jFramePrincipal.add(mensagemIP);
        bl = new BlinkLabel("6000");
        blIP = new BlinkLabel(getIP());
        jFramePrincipal.add(bl);
        jFramePrincipal.add(blIP);
        URL path = this.getClass().getResource("programming-flag.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(path);
        jFramePrincipal.setIconImage(iconeTitulo);
        jFramePrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFramePrincipal.getContentPane().setLayout(null);
        jFramePrincipal.setPreferredSize(new Dimension(900, 650));
        jFramePrincipal.pack();
        jFramePrincipal.setLocationRelativeTo(null);
        jFramePrincipal.setResizable(false);
        //HORA E DATA
        Date data = new Date();
        DateFormat sdf = DateFormat.getDateInstance(DateFormat.DEFAULT);
        //campodata.setText(sdf.format(data));
        //campodata.setBounds(730, 140, 150, 50);
        //campodata.setBorder(new LineBorder(Color.WHITE, 0, false));
        // campodata.setFont(new Font("arial", Font.BOLD, 16));
        // jFramePrincipal.add(campodata);
        //campodata.setEnabled(false);

        bl.setBounds(150, 120, 70, 40);
        bl.setFont(new Font("arial", Font.ITALIC, 14));
        bl.setBorder(new LineBorder(Color.BLUE, 2, true));
        blIP.setBounds(150, 170, 120, 40);
        blIP.setFont(new Font("arial", Font.ITALIC, 14));
        blIP.setBorder(new LineBorder(Color.BLUE, 2, true));
        mensagemPorta.setBounds(20, 117, 140, 50);
        mensagemPorta.setFont(new Font("arial", Font.ITALIC, 14));
        mensagemIP.setBounds(20, 160, 140, 50);
        mensagemIP.setFont(new Font("arial", Font.ITALIC, 14));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(miColaborar)) {
            new Colaborador().jFrameColaborador.show();
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

        new APP().jFramePrincipal.show();

    }

    public static String getIP() {
        String iphost = "";
        try {
            iphost = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {

        }
        return iphost;
    }

}