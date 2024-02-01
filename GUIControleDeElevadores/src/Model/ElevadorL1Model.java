package Model;

import java.util.List;
import java.util.ArrayList;

public class ElevadorL1Model {
    private List<Integer> andaresDisponiveis;
    private int andarAtual;


    public ElevadorL1Model() {
        andaresDisponiveis = new ArrayList<>(List.of(6, 5, 4, 3, 2, 1, 0, -1, -2)); /* Lista inalterável */
    andarAtual = 0;
    }

    public List<Integer> getAndarAtualL1(){
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