import java.io.IOException;
/**
 *
 *Classe Recurs
 *
 *@author Claudi
 */

public class Controlador_Presentacio{
    private VistaGlobal v;
    private VistaSave s;
    private Controlador_Domini_Recurs cr;
    private Controlador_Domini_Paquet cp;
    private Controlador_Domini_Planeta cpl;
    private Controlador_Domini_Univers cu;
    private Controlador_Domini_QAP q;
    
    public Controlador_Presentacio(){
        v = new VistaGlobal();
        v.pack();
        v.setVisible(true);
        //if(v == null) System.out.println("F");
        //sv = new  SubVista(v);
        //Instencia tots els controladors.
        s = new VistaSave(this);
        cr = new Controlador_Domini_Recurs(this);
        cp = new Controlador_Domini_Paquet(cr,this);
        cpl = new Controlador_Domini_Planeta(cp, cr, this);
        cu = new Controlador_Domini_Univers(cpl, cr, cp, this);
        q = new Controlador_Domini_QAP(cr, cu, this);
    }
    
    public void guardarTot(String a) throws IOException{
        
        cr.guardarRecursos(a);
        System.out.println(a);
    }
    
    public void borrar_planeta(String a){
        cu.borrar_planeta(a);
    }
    
    public void borrar_paquet(int id){
        cu.borrar_paquet(id);
    }
    
    public void borrar_recurs(String nom){
        cu.borrar_recurs(nom);
        
    }
    
    public void modificar_nom_planeta(String old_name, String new_name){
        cu.modificar_nom_planeta(old_name,new_name);
    }
    
    public void modificar_nom_recurs(String old_name, String new_name){
        cu.modificar_nom_recurs(old_name,new_name);
    }
    
    public void modificar_coordenades_planeta(String nom, int x, int y){
        cu.modificar_coordenades_planeta(nom, x, y);
    }
    
    public void modificar_classe_planeta(String nom, boolean classeM){
        cu.modificar_classe_planeta(nom,classeM);
    }
}