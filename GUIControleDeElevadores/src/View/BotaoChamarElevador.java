package View;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;

public class BotaoChamarElevador extends JButton{
    
    private Color corVermelha = new Color(255,0,0);
    public BotaoChamarElevador() {
        this.setText("Chamar Elevador");
        this.setBorder(BorderFactory.createLineBorder(corVermelha,100));
    }
}
