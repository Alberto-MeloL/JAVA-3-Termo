package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import View.BotaoChamarElevador;

public class GUIElevadores extends JFrame {

    private Color corPretoFosco = new Color(54, 54, 54);
    private JPanel elevadores;
    private JPanel titulo;
    private JLabel elevadorL1;
    private JLabel elevadorL2;

    public GUIElevadores() {
        super("Simulador de Elevadores");
        this.setBackground(corPretoFosco);
        this.setSize(new Dimension(1800, 800));

        titulo = new JPanel();
        titulo.setLayout(new FlowLayout());

        elevadorL1 = new JLabel("L1");
        elevadorL2 = new JLabel("L2");

        titulo.add(elevadorL1);
        titulo.add(elevadorL2);

        ElevadorL1 elevadorL1 = new ElevadorL1();
        BotaoChamarElevador botaoChamarElevador = new BotaoChamarElevador();
        ElevadorL2 elevadorL2 = new ElevadorL2();
        elevadores = new JPanel(new FlowLayout());
        elevadores.add(elevadorL1);
        elevadores.add(botaoChamarElevador);
        elevadores.add(elevadorL2);
        elevadores.add(titulo);
        add(elevadores);

    }

    public void run() {
        this.setVisible(true);

    }
}
