/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelModel;

import kelas.MataKuliah;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mich
 */
public class MataKuliah_TM extends AbstractTableModel {

    private List<MataKuliah> mk = new ArrayList<MataKuliah>();

    public MataKuliah_TM(List<MataKuliah> mk) {
        this.mk = mk;
    }

    @Override
    public int getRowCount() {
        return mk.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MataKuliah m = mk.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return m.getIdMK();
            case 1:
                return m.getNamaMK();
            case 2:
                return m.getSks();
            case 3:
                return m.getSemester();
            case 4:
                return m.getJP();
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
                return "NAMA MATKUL";
            case 2:
                return "SKS";
            case 3:
                return "SMSTR";
            case 4:
                return "JP";
            default:
                return "";
        }
    }
}
