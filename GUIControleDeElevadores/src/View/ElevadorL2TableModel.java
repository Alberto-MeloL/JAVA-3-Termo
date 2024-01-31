package View;

import Model.ElevadorL2Model;
import javax.swing.table.AbstractTableModel;

public class ElevadorL2TableModel extends AbstractTableModel{
   
    private final ElevadorL2Model elevadorL2;
    private final String[] colunas = {"Andar"};

public ElevadorL2TableModel(ElevadorL2Model elevadorL2) {
    this.elevadorL2 = elevadorL2;
}

@Override
public int getRowCount(){
    return elevadorL2.getAndarAtualL2().size();
}

@Override
public int getColumnCount(){
    return colunas.length;
}

@Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return elevadorL2.getAndarAtualL2().get(rowIndex);
    }

    @Override
    public String getColumnName(int index) {
        return colunas[index];
    }
}
