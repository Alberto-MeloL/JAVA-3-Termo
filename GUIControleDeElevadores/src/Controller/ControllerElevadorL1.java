package Controller;

import View.ElevadorL1;
import Model.ElevadorL1Model;
import java.awt.event.ActionListener;
public class ControllerElevadorL1 {

    private ElevadorL1 viewL1;
    private ElevadorL1Model modelL1;

    public ControllerElevadorL1(ElevadorL1 viewL1, ElevadorL1Model modelL1) {

        this.viewL1 = viewL1;
        this.modelL1 = modelL1;
        iniciarL1();
    }

    public void iniciarL1(){
viewL1.getAndarUm().addActionListener(e -> moverPara(1));
viewL1.getAndarDois().addActionListener(e -> moverPara(2));
viewL1.getAndarTres().addActionListener(e -> moverPara(3));
viewL1.getAndarQuatro().addActionListener(e -> moverPara(4));
viewL1.getAndarCinco().addActionListener(e -> moverPara(5));
viewL1.getAndarSeis().addActionListener(e -> moverPara(6));
viewL1.getAndarZero().addActionListener(e -> moverPara(0));
viewL1.getSubSolo1().addActionListener(e -> moverPara(-1));
viewL1.getSubSolo2().addActionListener(e -> moverPara(-2));
    }

    public void moverPara(int mover){
        modelL1.setAndarAtual(mover);
        

    }
}
