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
        int[] data = {1,2,3,4,5,6};
        
        for (int i = 0; i < data.length; i++) {
            System.out.println(i);
            if(data[i]==4){
                break;
            }
        }
    }
}
