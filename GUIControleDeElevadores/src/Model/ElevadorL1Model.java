package Model;

import java.util.List;
import java.util.ArrayList;

public class ElevadorL1Model {
    private List<Integer> andarAtual;

    public ElevadorL1Model() {
        andarAtual = new ArrayList<>(List.of(6, 5, 4, 3, 2, 1, 0, -1, -2)); /* Lista inalterável */
    }

    public List<Integer> getAndarAtualL1(){
        return andarAtual;
    }
}