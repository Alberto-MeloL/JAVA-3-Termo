package View;

import View.ElevadorL2TableModel;
import Model.ElevadorL2Model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Controller.ControllerBotaoChamarELVD;;

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
    private int andarAtualL2;
    private JPanel containerJButton;
    private JPanel containerElevadorL2;
    private JTable tabelaL2 = new JTable();
    private ControllerBotaoChamarELVD controlador;

      public ElevadorL2(ControllerBotaoChamarELVD controlador) {
        this.controlador = controlador;
        this.setSize(200, 200);
        this.setLayout(new FlowLayout());

        containerElevadorL2 = new JPanel(new FlowLayout());
        containerElevadorL2.setPreferredSize(new Dimension(300,800));
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

        andarUm.addActionListener(e -> {
            selecionarAndarNaTabela(5);
            controlador.chamarElevadorMaisProximo(1); // Exemplo de chamada ao controlador
        });
        andarDois.addActionListener(e -> {
            selecionarAndarNaTabela(4);
            controlador.chamarElevadorMaisProximo(2); // Exemplo de chamada ao controlador
        });
        andarTres.addActionListener(e -> {
            selecionarAndarNaTabela(3);
            controlador.chamarElevadorMaisProximo(3); // Exemplo de chamada ao controlador
        });
        andarQuatro.addActionListener(e -> {
            selecionarAndarNaTabela(2);
            controlador.chamarElevadorMaisProximo(4); // Exemplo de chamada ao controlador
        });
        andarCinco.addActionListener(e -> {
            selecionarAndarNaTabela(1);
            controlador.chamarElevadorMaisProximo(5); // Exemplo de chamada ao controlador
        });
        andarSeis.addActionListener(e -> {
            selecionarAndarNaTabela(0);
            controlador.chamarElevadorMaisProximo(6); // Exemplo de chamada ao controlador
        });
        andarZero.addActionListener(e -> {
            selecionarAndarNaTabela(6);
            controlador.chamarElevadorMaisProximo(7); // Exemplo de chamada ao controlador
        });
        subSolo1.addActionListener(e -> {
            selecionarAndarNaTabela(7);
            controlador.chamarElevadorMaisProximo(8); // Exemplo de chamada ao controlador
        });
        subSolo2.addActionListener(e -> {
            selecionarAndarNaTabela(8);
            controlador.chamarElevadorMaisProximo(5); // Exemplo de chamada ao controlador
        });

        containerElevadorL2.add(containerJButton);
        

        ElevadorL2Model elevadorL2Model = new ElevadorL2Model();
        ElevadorL2TableModel modelL2 = new ElevadorL2TableModel(elevadorL2Model);
        tabelaL2 = new JTable(modelL2);
        tabelaL2.setRowHeight(50);
        tabelaL2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        containerElevadorL2.add(tabelaL2);

        add(containerElevadorL2);
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
    public void selecionarAndarNaTabela(int andar) {
        // Considerando que o andar "1" está na linha 0, "2" na linha 1, e assim por diante.
        // Ajuste a lógica conforme necessário para corresponder à sua organização de dados.
        int linhaDoAndar = andar; // Isso supõe uma correspondência direta e simples.
    
        // Certifique-se de que o índice está dentro do intervalo válido para a tabela.
        if (linhaDoAndar >= 0 && linhaDoAndar < tabelaL2.getRowCount()) {
            tabelaL2.setRowSelectionInterval(linhaDoAndar, linhaDoAndar);
            // Isso garante que a linha selecionada seja visível ao usuário.
            tabelaL2.scrollRectToVisible(tabelaL2.getCellRect(linhaDoAndar, 0, true));
        }
    }

    public int andarAtual(){
return this.andarAtualL2 = andarAtual();
    }
}