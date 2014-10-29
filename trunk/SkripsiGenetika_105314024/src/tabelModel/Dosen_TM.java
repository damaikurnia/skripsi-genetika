/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelModel;

import kelas.Dosen;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mich
 */
public class Dosen_TM extends AbstractTableModel {

    private List<Dosen> dosen = new ArrayList<Dosen>();

    public Dosen_TM(List<Dosen> dosen) {
        this.dosen = dosen;
    }

    @Override
    public int getRowCount() {
        return dosen.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Dosen d = dosen.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return d.getIdDosen();
            case 1:
                return d.getNamaDosen();
            case 2:
                return d.getStatus();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "KODE";
            case 1:
                return "NAMA DOSEN";
            case 2:
                return "STATUS";
            default:
                return "";
        }
    }
}
