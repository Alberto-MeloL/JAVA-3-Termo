package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import View.BotaoChamarElevador;

public class GUIElevadores extends JFrame {
    private ImagemFundo imagemFundo;

    private Color corPretoFosco = new Color(54, 54, 54);
    private Color corAmarela = new Color(255, 251, 20);
    private JPanel elevadores;
    private JPanel titulo;
    private JLabel elevadorL1;
    private JLabel elevadorL2;

    public GUIElevadores() {
        super("Simulador de Elevadores");
        this.setBackground(corPretoFosco);
        this.setSize(new Dimension(1800, 800));
        imagemFundo = new ImagemFundo("src/imagem/fundo-preto.png");
        imagemFundo.setLayout(new BorderLayout());
        this.setContentPane(imagemFundo);

        Font minhaFonte = new Font("Arial", Font.BOLD, 30);
        titulo = new JPanel();
        titulo.setLayout(new FlowLayout(FlowLayout.CENTER, 10,5));

        elevadorL1 = new JLabel("L1");
        elevadorL2 = new JLabel("L2");
        elevadorL1.setBorder(BorderFactory.createEmptyBorder(5,400,5,300));
        elevadorL2.setBorder(BorderFactory.createEmptyBorder(5,400,5,400));
        elevadorL1.setFont(minhaFonte);
        elevadorL2.setFont(minhaFonte);
        elevadorL1.setForeground(corAmarela);
        elevadorL2.setForeground(corAmarela);

        titulo.add(elevadorL1);
        titulo.add(elevadorL2);

        ElevadorL1 elevadorL1 = new ElevadorL1();
        BotaoChamarElevador botaoChamarElevador = new BotaoChamarElevador();
        ElevadorL2 elevadorL2 = new ElevadorL2();
        elevadores = new JPanel(new FlowLayout());
        elevadores.add(elevadorL1);
        elevadores.add(botaoChamarElevador);
        elevadores.add(elevadorL2);
        imagemFundo.add(elevadores, BorderLayout.CENTER);
        imagemFundo.add(titulo, BorderLayout.NORTH);
        add(elevadores);

        

    }

    public void run() {
        this.setVisible(true);

    }
}
