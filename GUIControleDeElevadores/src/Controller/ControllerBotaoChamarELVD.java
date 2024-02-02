package Controller;

import javax.swing.JOptionPane;

import Model.ElevadorL1Model;
import Model.ElevadorL2Model;
import View.ElevadorL1;
import View.ElevadorL2;
public class ControllerBotaoChamarELVD {

    private ElevadorL1Model elevadorL1Model;
    private ElevadorL2Model elevadorL2Model;
    public ControllerBotaoChamarELVD(ElevadorL1Model elevadorL1Model, ElevadorL2Model elevadorL2Model) {
this.elevadorL1Model = elevadorL1Model;        
this.elevadorL2Model = elevadorL2Model;        
    }

    public void chamarElevadorMaisProximo(int andarDeChamada) {
        // Obtenha o estado atual de ambos os elevadores, por exemplo, seus andares atuais.
        int andarAtualL1 = elevadorL1Model.getAndarAtual();
        int andarAtualL2 = elevadorL2Model.getAndarAtual();
        
        // Calcule qual elevador está mais próximo ao andar de chamada.
        int distanciaL1 = Math.abs(andarDeChamada - andarAtualL1);
        int distanciaL2 = Math.abs(andarDeChamada - andarAtualL2);
        
        if (distanciaL1 < distanciaL2) {
JOptionPane.showConfirmDialog(null, "O elevador L1 esta disponivel");
        } else if(distanciaL2 > distanciaL1) JOptionPane.showConfirmDialog(null, "O elevador L2 esta disponivel");if (distanciaL2 < distanciaL1) {
            // Chame o Elevador L2
        } else {
            JOptionPane.showConfirmDialog(null, "Os dois elevadores estão disponiveis");
        }
    }
    
}
