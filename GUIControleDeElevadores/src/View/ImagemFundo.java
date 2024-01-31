package View;

import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class ImagemFundo extends JPanel{
    private Image imagemFundo;
 
    public ImagemFundo(String nomeArquivo){
        imagemFundo = new ImageIcon(nomeArquivo).getImage();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagemFundo, 0, 0, this.getWidth(), this.getHeight(), this);

    }
}
