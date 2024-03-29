/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelModel;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author TOSHIBA
 */
public class renderWarnaWarni extends DefaultTableCellRenderer {

    private Color ganjil;
    private Color genap;

    public renderWarnaWarni(Color dikit, Color banyak) {
        this.ganjil = dikit;
        this.genap = banyak;
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (row % 2 == 1) {
            component.setBackground(ganjil);
        } else {
            component.setBackground(genap);
        }
        return component;
    }
}
