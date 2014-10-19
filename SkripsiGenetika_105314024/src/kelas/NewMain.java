/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelas;

import javax.swing.JOptionPane;

/**
 *
 * @author Mega
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int data;
        data = JOptionPane.showConfirmDialog(null, "Apakah Mau menghapus?", "MENGHAPUS DATA", 1);
        System.out.println(data);
    }
}
