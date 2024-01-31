package View;

import View.ElevadorL2TableModel;
import Model.ElevadorL2Model;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;;

public class ElevadorL2 extends JPanel {
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
    private JPanel containerElevadorL2;
    private JTable tabelaL2 = new JTable();

    public ElevadorL2() {
        this.setSize(200, 200);
        this.setLayout(new FlowLayout());

        containerElevadorL2 = new JPanel(new FlowLayout());
        containerElevadorL2.setPreferredSize(new Dimension(600,800));
        containerJButton = new JPanel();
        containerJButton.setLayout(new BoxLayout(containerJButton, BoxLayout.Y_AXIS));

        containerJButton.add(andarUm = new JButton("1"));
        containerJButton.add(andarDois = new JButton("2"));
        containerJButton.add(andarTres = new JButton("3"));
        containerJButton.add(andarQuatro = new JButton("4"));
        containerJButton.add(andarCinco = new JButton("5"));
        containerJButton.add(andarSeis = new JButton("6"));
        containerJButton.add(andarZero = new JButton("T"));
        containerJButton.add(subSolo1 = new JButton("-1"));
        containerJButton.add(subSolo2 = new JButton("-2"));

        containerElevadorL2.add(containerJButton);
        

        ElevadorL2Model elevadorL2Model = new ElevadorL2Model();
        ElevadorL2TableModel modelL2 = new ElevadorL2TableModel(elevadorL2Model);
        tabelaL2 = new JTable(modelL2);
        tabelaL2.setRowHeight(50);
        containerElevadorL2.add(tabelaL2);

        add(containerElevadorL2);
    }
}
