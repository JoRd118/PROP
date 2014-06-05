import java.util.*;
import java.io.IOException;
/**
 *
 *Controlador Domini Classe Recurs
 *
 *@author Claudi
 */
public class Controlador_Presentacio_Recurs{
    
    //Vista
    private VistaRecurs v;
    private Controlador_Presentacio cp;
    private Controlador_Domini_Recurs cdr;
    
    public Controlador_Presentacio_Recurs(){

        v = new VistaRecurs(this);
    }
    
    public Controlador_Presentacio_Recurs(Controlador_Presentacio p){
        cp = p;
        cdr = new Controlador_Domini_Recurs();
        v = new VistaRecurs(this);
    }
    
    public Controlador_Domini_Recurs getCont(){
        return cdr;
    }
    
    public void altaRecurs(String nom){
        cdr.altaRecurs(nom);
    }
    
    public void baixaRecurs(String nom){
        cdr.baixaRecurs(nom);
    }
    
    public void modificarNom(String nom, String newnom){
        cdr.modificarNom(nom,newnom);
    }
    /*
    public Recurs obtenirRecurs(String nom){
        return cdr.obtenirRecurs(nom);
    }
    */
    public int obtenirId(String nom){
        return cdr.obtenirId(nom);
    }
    
    public String obtenirNom(Recurs rec){
        return cdr.obtenirNom(rec);
    }

    /*
    public boolean validarRecurs(String nom){
        if(r.contains(nom)){
            return true;
        }
        else{ return false;}
    }*/
    
    public String llistatRecurs(){
        return cdr.llistatRecurs();
    }
    /*
    public Iterable<String> llistatRecurs_2(){
        Iterable<String> s = r.obtainAllTST();
        return s;
    }
    */
    
    public int totalRecursos(){
        return cdr.totalRecursos();
    }
    
    public void guardarRecursos(String nomFitxer)throws IOException{
        cdr.guardarRecursos(nomFitxer);
    }
    
    public void guardarInst(String nomFitxer)throws IOException{
        cdr.guardarInst(nomFitxer);
    }
    
    public void carregarRecursos(String nomFitxer)throws IOException{
        cdr.carregarRecursos(nomFitxer);
    }
    
    public void baixaRecursVista(String n){
         cp.borrar_recurs(n);
    }
    
    public void modificar_nom_recursVista(String a,String b){
        cp.modificar_nom_recurs(a,b);
    }
}