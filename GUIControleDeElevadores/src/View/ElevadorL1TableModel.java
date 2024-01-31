package View;

import Model.ElevadorL1Model;
import javax.swing.table.AbstractTableModel;

public class ElevadorL1TableModel extends AbstractTableModel {

    private final ElevadorL1Model elevadorL1;
    private final String[] colunas = { "Andar" };

    public ElevadorL1TableModel(ElevadorL1Model elevadorL1) {
        this.elevadorL1 = elevadorL1;
    }

    @Override
    public int getRowCount() {
        return elevadorL1.getAndarAtualL1().size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return elevadorL1.getAndarAtualL1().get(rowIndex);
    }

    @Override
    public String getColumnName(int index) {
        return colunas[index];
    }
}
