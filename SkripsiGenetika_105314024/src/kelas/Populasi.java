/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kelas;

/**
 *
 * @author Adhi
 */
public class Populasi {
    private Kromosom[] parent = new Kromosom[2];//satu populasi terdiri dari 2 kromosom
    private int iterasi = 0;
    
    public void HitungFitness(){
        for (int i = 0; i < getParent().length; i++) {
            parent[i] = Pelanggaran.eksekusiAturan(parent[i]);
        }
    }
    public void Crossover(){}
    public void Mutasi(){}

    /**
     * @return the parent
     */
    public Kromosom[] getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Kromosom[] parent) {
        this.parent = parent;
    }

    /**
     * @return the iterasi
     */
    public int getIterasi() {
        return iterasi;
    }

    /**
     * @param iterasi the iterasi to set
     */
    public void setIterasi(int iterasi) {
        this.iterasi = iterasi;
    }
}
