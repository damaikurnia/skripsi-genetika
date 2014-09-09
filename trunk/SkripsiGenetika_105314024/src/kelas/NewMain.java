/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kelas;

/**
 *
 * @author Mega
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        String data = "P001-0";
//        System.out.print(data.split("-")[1]);
        Genetika a = new Genetika();
//        System.out.println(a.sercing(12));
        for (int i = 0; i < a.checklist_kk.length; i++) {
            System.out.print(a.checklist_kk[i].split("-")[0]+" ");
        }
        
    }
    
}
