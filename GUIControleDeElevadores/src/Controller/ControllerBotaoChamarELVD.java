package Controller;

import javax.swing.JOptionPane;

import Model.ElevadorL1Model;
import Model.ElevadorL2Model;


public class ControllerBotaoChamarELVD {

    private ElevadorL1Model elevadorL1Model;
    private ElevadorL2Model elevadorL2Model;

    public ControllerBotaoChamarELVD(ElevadorL1Model elevadorL1Model2, ElevadorL2Model elevadorL2Model2) {
        this.elevadorL1Model = elevadorL1Model2;
        this.elevadorL2Model = elevadorL2Model2;
    }

    public void chamarElevadorMaisProximo(int andarDeChamada) {
      
      
        int andarAtualL1 = elevadorL1Model.getAndarAtual();
        int andarAtualL2 = elevadorL2Model.getAndarAtual();

        
        int distanciaL1 = Math.abs(andarDeChamada - andarAtualL1);
        int distanciaL2 = Math.abs(andarDeChamada - andarAtualL2);

        if (distanciaL1 < distanciaL2) {
            JOptionPane.showConfirmDialog(null, "O elevador L1 esta disponivel");
        } else if (distanciaL2 > distanciaL1) {
            JOptionPane.showMessageDialog(null, "O Elevador L2 esta disponivel");
        } else if (distanciaL1 == distanciaL2) {

            JOptionPane.showConfirmDialog(null, "Os dois elevadores estão disponiveis");
        }

    }

}
