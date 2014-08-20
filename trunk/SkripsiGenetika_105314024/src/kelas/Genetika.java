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
public class Genetika {
//        public void routleWheelSelection() {
////        for (int i = 0; i < parent.length; i++) {
////            Kromosom kromosom = parent[i];
////            
////        }
//
//        for (int i = 1; i < N_fitness.length; i++) { //sorting routel wheel selection
//            for (int j = 0; j < (N_fitness.length - i); j++) {
//                if (N_fitness[j] > N_fitness[j + 1]) {
//                    Kromosom temp = parent[j];
//                    int temp_n = N_fitness[j];
//                    parent[j] = parent[j + 1];
//                    N_fitness[j] = N_fitness[j + 1];
//                    parent[j + 1] = temp;
//                    N_fitness[j + 1] = temp_n;
//                }
//
//            }
//        }
//    }

    public static Kromosom[] crossover(Kromosom parent1, Kromosom parent2) {
//        routleWheelSelection();
        Kromosom[] popul = new Kromosom[4];
        popul[0] = parent1;//parent 1
        popul[1] = parent2;//parent 2
        popul[2] = parent1;//child 1
        popul[3] = parent2;//child 2
        
        int point = popul[0].getData().length/2;
        for (int i = 0; i < popul[0].getData().length; i++) {
            if (i<point) {
                
            }
            else{
                popul[2].getData()[i].setAllele(popul[1].getData()[i].getAllele());
                popul[3].getData()[i].setAllele(popul[0].getData()[i].getAllele());
            }
            popul[2].getData()[i].setNilaiFitness(0);
            popul[3].getData()[i].setNilaiFitness(0);
        }
        
        return popul;
    }

    public void Mutasi() {
    }

}
