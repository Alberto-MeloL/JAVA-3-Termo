package View;

import Model.ElevadorL1Model;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.ControllerElevadorL1;;

public class ElevadorL1 extends JPanel {
    private JButton andarUm;
    private JButton andarDois;
    private JButton andarTres;
    private JButton andarQuatro;
    private JButton andarCinco;
    private JButton andarSeis;
    private JButton andarZero;
    private JButton subSolo1;
    private JButton subSolo2;
    private JPanel containerJButton;
    private JPanel containerElevadorL1;
    private JTable tabelaL1 = new JTable();

    public ElevadorL1() {
        this.setSize(200, 200);
        this.setLayout(new FlowLayout());

ElevadorL1Model model = new ElevadorL1Model();
ElevadorL1 l1 = new ElevadorL1();
ControllerElevadorL1 controllerL1 = new ControllerElevadorL1(this, model);
        containerElevadorL1 = new JPanel(new FlowLayout());
        containerElevadorL1.setPreferredSize(new Dimension(300,800));
        containerJButton = new JPanel();
        containerJButton.setLayout(new BoxLayout(containerJButton, BoxLayout.Y_AXIS));

        Dimension tamanhoBotao = new Dimension(100,80);

        containerJButton.add(andarUm = new JButton("1"));
        containerJButton.add(andarDois = new JButton("2"));
        containerJButton.add(andarTres = new JButton("3"));
        containerJButton.add(andarQuatro = new JButton("4"));
        containerJButton.add(andarCinco = new JButton("5"));
        containerJButton.add(andarSeis = new JButton("6"));
        containerJButton.add(andarZero = new JButton("T"));
        containerJButton.add(subSolo1 = new JButton("-1"));
        containerJButton.add(subSolo2 = new JButton("-2"));
        containerElevadorL1.add(containerJButton);
        
//lista,index%2
        ElevadorL1Model elevadorL1Model = new ElevadorL1Model();
        ElevadorL1TableModel modelL1 = new ElevadorL1TableModel(elevadorL1Model);
        tabelaL1.setPreferredSize(new Dimension(600,200));
        tabelaL1 = new JTable(modelL1);
tabelaL1.setRowHeight(50);
        containerElevadorL1.add(tabelaL1);

        add(containerElevadorL1);
    }

    //////////
    public JButton getAndarUm(){
        return andarUm;
    }
    //////////
    public JButton getAndarDois(){
        return andarDois;
    }
    //////////
    public JButton getAndarTres(){
        return andarTres;
    }
    //////////
    public JButton getAndarQuatro(){
        return andarQuatro;
    }
    //////////
    public JButton getAndarCinco(){
        return andarCinco;
    }
    //////////
    public JButton getAndarSeis(){
        return andarSeis;
    }
    //////////
    public JButton getAndarZero(){
        return andarZero;
    }
    //////////
    public JButton getSubSolo1(){
        return subSolo1;
    }
    //////////
    public JButton getSubSolo2(){
        return subSolo2;
    }
}
