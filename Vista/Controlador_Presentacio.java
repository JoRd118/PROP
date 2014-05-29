/**
 *
 *Classe Recurs
 *
 *@author Claudi
 */

public class Controlador_Presentacio{
    private VistaGlobal v;
    private Controlador_Domini_Recurs cr;
    private Controlador_Domini_Paquet cp;
    private Controlador_Domini_Planeta cpl;
    private Controlador_Domini_Univers cu;
    
    public Controlador_Presentacio(){
        v = new VistaGlobal();
        v.pack();
        v.setVisible(true);
        //if(v == null) System.out.println("F");
        //sv = new  SubVista(v);
        //Instencia tots els controladors.
        cr = new Controlador_Domini_Recurs();
        cp = new Controlador_Domini_Paquet(cr);
        cpl = new Controlador_Domini_Planeta(cp, cr);
        cu = new Controlador_Domini_Univers(cpl, cr, cp);
    }
    

}