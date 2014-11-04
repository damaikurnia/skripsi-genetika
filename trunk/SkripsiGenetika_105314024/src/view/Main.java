

package view;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            LaunchProgressBar pb = new LaunchProgressBar();
            pb.setVisible(true);
            for(int i=0;i<=100;i++){
                try {
                    pb.getProgressBar().setValue(i);
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(LaunchProgressBar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
             pb.dispose();
                new Home().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
