package Model;

import java.util.List;
import java.util.ArrayList;

public class ElevadorL2Model {
    private List<Integer> andaresDisponiveis;
    private int andarAtual;

    public ElevadorL2Model() {
       andaresDisponiveis = new ArrayList<>(List.of(6, 5, 4, 3, 2, 1, 0, -1, -2));
    andarAtual = 0;
    }

    public List<Integer> getAndarAtualL2(){
        return andaresDisponiveis;
    }

    public int getAndarAtual(){
        return andarAtual;
    }

    public void setAndarAtual(int andarAtual){
        if (andaresDisponiveis.contains(andarAtual)) {
            this.andarAtual = andarAtual;
        }else{
            System.out.println("Andar Inválido.");
        }
    }
}
