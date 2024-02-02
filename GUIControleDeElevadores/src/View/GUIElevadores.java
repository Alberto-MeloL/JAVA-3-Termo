package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import View.BotaoChamarElevador;
import Controller.ControllerBotaoChamarELVD;
import Model.ElevadorL1Model;
import Model.ElevadorL2Model;

public class GUIElevadores extends JFrame {

    private Color corPretoFosco = new Color(54, 54, 54);
    private Color corAmarela = new Color(255, 251, 20);
    private JPanel elevadores;
    private JPanel titulo;
    private JLabel elevadorL1;
    private JLabel elevadorL2;
    private int andarDeChamada; // Um valor padrão, ou você pode definir de outra forma

    public GUIElevadores() {
        super("Simulador de Elevadores");
        this.setSize(new Dimension(1800, 800));

        Font minhaFonte = new Font("Arial", Font.BOLD, 30);
        titulo = new JPanel();
        titulo.setLayout(new FlowLayout(FlowLayout.CENTER, 10,5));

        ElevadorL1Model elevadorL1Model = new ElevadorL1Model();
        ElevadorL2Model elevadorL2Model = new ElevadorL2Model();

        elevadorL1 = new JLabel("L1");
        elevadorL2 = new JLabel("L2");
        elevadorL1.setBorder(BorderFactory.createEmptyBorder(5,200,5,300));
        elevadorL2.setBorder(BorderFactory.createEmptyBorder(5,300,5,200));
        elevadorL1.setFont(minhaFonte);
        elevadorL2.setFont(minhaFonte);
        elevadorL1.setForeground(corPretoFosco);
        elevadorL2.setForeground(corPretoFosco);

        titulo.add(elevadorL1);
        titulo.add(elevadorL2);

        ElevadorL1 elevadorL1 = new ElevadorL1();
        ControllerBotaoChamarELVD controlador = new ControllerBotaoChamarELVD(elevadorL1Model, elevadorL2Model);
        BotaoChamarElevador botaoChamar = new BotaoChamarElevador(e -> {
            controlador.chamarElevadorMaisProximo(andarDeChamada);
        });
        
        ElevadorL2 elevadorL2 = new ElevadorL2();
        
      
        elevadores = new JPanel(new FlowLayout());
        elevadores.add(elevadorL1);
        elevadores.add(botaoChamar);
        elevadores.add(elevadorL2);
        add(elevadores);
       
    }

    public void run() {
        this.setVisible(true);

    }
}
