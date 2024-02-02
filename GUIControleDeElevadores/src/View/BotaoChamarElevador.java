package View;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

public class BotaoChamarElevador extends JButton{
    private Color corPretoFosco = new Color(54, 54, 54);

    private Color corVermelha = new Color(224, 79, 79);
    public BotaoChamarElevador(ActionListener actionListener) {
        Font minhaFonte = new Font("Arial", Font.BOLD, 30);

        this.setText("Chamar Elevador");
        this.setForeground(corPretoFosco);
        this.setFont(minhaFonte);
        this.setBorder(BorderFactory.createLineBorder(corPretoFosco));
        this.setBorder(BorderFactory.createLineBorder(corVermelha,100));
        this.addActionListener(actionListener);
    }
}
