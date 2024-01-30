package View;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

public class GUIElevadores extends JFrame{

    private Color corPretoFosco = new Color(54, 54, 54);
    private JPanel elevadores;

    public GUIElevadores() {
        super("Simulador de Elevadores");
        this.setBackground(corPretoFosco);
        this.setSize(new Dimension(1800, 800));


    }

    public void run(){
        this.setVisible(true);

    }
}

