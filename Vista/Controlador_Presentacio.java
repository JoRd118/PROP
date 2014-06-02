import java.io.IOException;
import java.lang.Thread;
/**
 *
 *Classe Recurs
 *
 *@author Claudi
 */

public class Controlador_Presentacio extends Thread{
    
    private Thread1 t1;
    private Thread2 t2;
    
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
    
    public void guardar_R(String a)throws IOException{
        cr.guardarRecursos(a);
    }
    
    public void guardar_P(String a)throws IOException{
        cp.guardarPaquets(a);
    }
    
    public void guardar_Pl(String a)throws IOException{
        cpl.guardarPlanetes(a);
    }
    
    public void guardar_U(String a)throws IOException{
        cu.guardarUniversos(a);
    }
    
    public void guardar_Q(String a)throws IOException{
        q.guardar_solucioQAP(a);
    }
    
    public void guardar_I(String a)throws IOException{
        cr.guardarInst(a);
    
    }
    
    public void borrar_planeta(String a){
        /*String[] aux = a.split("/");
         String[] aux2 = aux.[aux.length-1].split(".");
         aux2[0] = aux2[0] + "Recurs";*/
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