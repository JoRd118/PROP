/**
 *
 *Classe Recurs
 *
 *@author Claudi
 */

public class Controlador_Presentacio{
    private VistaGlobal v;
    private SubVista sv;
    private Controlador_Domini_Recurs cr;
    private Controlador_Domini_Paquet cp;
    
    
    public Controlador_Presentacio(){
        v = new VistaGlobal();
        v.pack();
        v.setVisible(true);
        if(v == null) System.out.println("F");
        sv = new  SubVista(v);
        //Instencia tots els controladors.
        cr = new Controlador_Domini_Recurs();
        cp = new Controlador_Domini_Paquet();
    }
    
    

}