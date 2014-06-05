import java.io.*;
import java.io.IOException;
/**
 * @param args the command line arguments
 */
public class main{
    public static void main(String args[]) {
        try {
            wrapper();
        }
        catch (Exception ex) {
            java.util.logging.Logger.getLogger(VistaGlobal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public static void wrapper(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Controlador_Presentacio();
                //new VistaPrincipal().setVisible(true);
            }
        });
    }
    
    
}
