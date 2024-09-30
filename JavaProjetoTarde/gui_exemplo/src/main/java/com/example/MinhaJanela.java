package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MinhaJanela extends JFrame{
public MinhaJanela() {
    super("Exemplo Swing");
    this.setSize(400, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JPanel panel = new JPanel();
this.add(panel);

JButton button = new JButton("Clique aqui");

panel.add(button);

button.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(null, "Botão clicado");
    }
});
this.setVisible(true);
}

}
