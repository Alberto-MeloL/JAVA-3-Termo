package Controller;

import View.ElevadorL2;
import Model.ElevadorL2Model;

public class ControllerElevadorL2 {
    private ElevadorL2 viewL2;
    private ElevadorL2Model modelL2;

    public ControllerElevadorL2(ElevadorL2 viewL2, ElevadorL2Model modelL2) {
        this.viewL2 = viewL2;
        this.modelL2 = modelL2;
        this.iniciarL2();
    }

    private void iniciarL2(){
        viewL2.getAndarUm().addActionListener(e -> moverPara(1));
        viewL2.getAndarDois().addActionListener(e -> moverPara(2));  
        viewL2.getAndarUm().addActionListener(e -> moverPara(3));
        viewL2.getAndarDois().addActionListener(e -> moverPara(4));  
        viewL2.getAndarUm().addActionListener(e -> moverPara(5));
        viewL2.getAndarDois().addActionListener(e -> moverPara(6));  
        viewL2.getAndarUm().addActionListener(e -> moverPara(0));
        viewL2.getAndarDois().addActionListener(e -> moverPara(-1));  
        viewL2.getAndarUm().addActionListener(e -> moverPara(-2));
    }

    public void moverPara(int mover){
modelL2.setAndarAtual(mover);
    }
}
