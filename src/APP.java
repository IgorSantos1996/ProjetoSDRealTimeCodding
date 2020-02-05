import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;


public class APP implements ActionListener {
    private JLabel numeroContribuintes;
    private JMenuBar mnBarra;
    private JMenu mnSobre;
    private Image iconeTitulo;
    private ImageIcon background = new ImageIcon(getClass().getResource("programming-flag.png"));
    private JLabel fundo, auxiliar;

    private JMenuItem miAutores;
    //private JMenu mnExportar;
    //private JMenu miSair;
    private JFrame jFramePrincipal;
    private JButton botaoIniciar;


    public APP() {
        jFramePrincipal = new JFrame("Real time codding");
        mnBarra = new JMenuBar();
        //miSair = new JMenu("Sair");
        numeroContribuintes = new JLabel();
        mnSobre = new JMenu("Sobre");
        //mnExportar  = new JMenu("Exportar Classe java");
        botaoIniciar = new JButton("Iniciar");
        miAutores = new JMenuItem("Info autores");

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
        //mnBarra.add(mnExportar);
        //miSair.addActionListener(this);
        botaoIniciar.addActionListener(this);
        mnSobre.add(miAutores);
        miAutores.addActionListener(this);
        jFramePrincipal.setJMenuBar(mnBarra);
        jFramePrincipal.add(numeroContribuintes);

        jFramePrincipal.add(botaoIniciar);
        URL path = this.getClass().getResource("programming-flag.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(path);

        jFramePrincipal.setIconImage(iconeTitulo);

        botaoIniciar.setBounds(380, 500, 150, 30);
        numeroContribuintes.setBounds(70, 70, 200, 30);
        jFramePrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFramePrincipal.getContentPane().setLayout(null);
        jFramePrincipal.setPreferredSize(new java.awt.Dimension(900, 650));
        jFramePrincipal.pack();
        jFramePrincipal.setLocationRelativeTo(null);
        jFramePrincipal.setResizable(false);



    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(botaoIniciar)) {

        } else if (e.getSource().equals(miAutores)) {
            JOptionPane.showMessageDialog(null, "Ainda não implementado");
        }

    }


    public static void main(String[] args) {
        try {

            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        APP principal = new APP();
        principal.jFramePrincipal.setVisible(true);

    }


}
