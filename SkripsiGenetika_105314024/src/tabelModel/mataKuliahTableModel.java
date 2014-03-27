/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelModel;

import clas.mata_kuliah;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ADIT
 */
public class mataKuliahTableModel extends AbstractTableModel {

    private List<mata_kuliah> mk = new ArrayList<mata_kuliah>();

    public mataKuliahTableModel(List<mata_kuliah> mk) {
        this.mk = mk;
    }

    @Override
    public int getRowCount() {
        return mk.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        mata_kuliah m = mk.get(rowIndex);
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
            case 5:
                return m.getJenis();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Mata Kuliah";
            case 1:
                return "Nama Mata Kuliah";
            case 2:
                return "Sks";
            case 3:
                return "Semester";
            case 4:
                return "Jam Pelajaran";
            case 5:
                return "Jenis";
            default:
                return "";
        }
    }
}
