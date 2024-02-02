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
    private JPanel elevadores;
    private JPanel titulo;
    private JLabel elevadorL1JP;
    private JLabel elevadorL2JP;
    private int andarDeChamada; // Um valor padrão, ou você pode definir de outra forma

    public GUIElevadores() {
        super("Simulador de Elevadores");
        this.setSize(new Dimension(1800, 800));

        Font minhaFonte = new Font("Arial", Font.BOLD, 30);
        titulo = new JPanel();
        titulo.setLayout(new FlowLayout(FlowLayout.CENTER, 10,5));

        ElevadorL1Model elevadorL1Model = new ElevadorL1Model();
        ElevadorL2Model elevadorL2Model = new ElevadorL2Model();

        elevadorL1JP = new JLabel("L1");
        elevadorL2JP = new JLabel("L2");
        elevadorL1JP.setBorder(BorderFactory.createEmptyBorder(5,200,5,300));
        elevadorL2JP.setBorder(BorderFactory.createEmptyBorder(5,300,5,200));
        elevadorL1JP.setFont(minhaFonte);
        elevadorL2JP.setFont(minhaFonte);
        elevadorL1JP.setForeground(corPretoFosco);
        elevadorL2JP.setForeground(corPretoFosco);

        ControllerBotaoChamarELVD controlador = new ControllerBotaoChamarELVD(elevadorL1Model, elevadorL2Model);
        ElevadorL2 elevadorL2 = new ElevadorL2(controlador);
        ElevadorL1 elevadorL1 = new ElevadorL1(controlador);
        BotaoChamarElevador botaoChamar = new BotaoChamarElevador(e -> {
            controlador.chamarElevadorMaisProximo(andarDeChamada);
        });
        titulo.add(elevadorL1);
        titulo.add(elevadorL2);

        
        
      
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
