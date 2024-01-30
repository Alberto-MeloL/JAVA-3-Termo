package Model;

import java.util.List;
import java.util.ArrayList;

public class ElevadorL1 {
     private List<Integer> andarAtual = new ArrayList<>(List.of(6, 5, 4, 3, 2, 1, 0, -1, -2)); /* Lista inalterável*/

    public ElevadorL1(List<Integer> andaresL1) {
        andaresL1 = new ArrayList<>(andarAtual);
    }
}