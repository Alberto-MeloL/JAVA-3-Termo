package Model;

import java.util.List;
import java.util.ArrayList;

public class ElevadorL2 {
     private List<Integer> andarAtual = new ArrayList<>(List.of(6, 5, 4, 3, 2, 1, 0, -1, -2)); /* Lista inalterável*/

    public ElevadorL2(List<Integer> andaresL2) {
        andaresL2 = new ArrayList<>(andarAtual);
    }
}
