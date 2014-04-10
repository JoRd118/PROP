import java.util.*;
import java.io.IOException;
/**
 *
 *Controlador Domini Classe Recurs
 *
 *@author Claudi
 */
public class Controlador_Domini_Recurs{
    
    private TST<Recurs> r;
    private static String msg_recurs_no_exists = "Error de Recurs: Recurs demanat no existeix.";
    private static String msg_recurs_repetit = "Error de Recurs: Ja existeix un recurs amb aquest nom.";
    
    
    public Controlador_Domini_Recurs(){
        r = new TST<Recurs>();
    }
    
    public void altaRecurs(String nom){
        //Buscar REPETITS
        if(r.contains(nom))throw new IllegalArgumentException(msg_recurs_repetit);
        else{
        Recurs aux = new Recurs(nom);
        r.insert(nom,aux);
        }
    }
    
    public void baixaRecurs(String nom){
        if(r.contains(nom)){ r.remove(nom);}
        else{ throw new IllegalArgumentException(msg_recurs_no_exists);}
    }
    
    public void modificarNom(String nom, String newnom){
        if(r.contains(newnom)){ throw new IllegalArgumentException(msg_recurs_repetit);}
        else{
            if(r.contains(nom)){
                Recurs rec = r.obtain(nom);
                r.remove(nom);
                rec.modificarNomRecurs(newnom);
                r.insert(newnom, rec);
            }
            else{ throw new IllegalArgumentException(msg_recurs_no_exists);}
        }
    }
    
    public Recurs obtenirRecurs(String nom){
        if(r.contains(nom)){return r.obtain(nom); }
        else{ throw new IllegalArgumentException(msg_recurs_no_exists);}
    }
    
    public int obtenirId(String nom){
        if(r.contains(nom)){
            Recurs rec = r.obtain(nom);
            return rec.obtenirId();
        }
        else{ throw new IllegalArgumentException(msg_recurs_no_exists);}
    }
    /*
    public String obtenirNom(int id){
        int pos = busca_recurs_num(id);
        if(pos < 0){ throw new IllegalArgumentException(msg_recurs_no_exists);}
        else{ return r.get(pos).obtenirNom();}
        
    }*/
    
    public boolean validarRecurs(String nom){
        if(r.contains(nom)){
            return true;
        }
        else{ return false;}
    }
    
    public String llistatRecurs(){
        Iterable<String> s = r.obtainAllTST();
        String aux = new String();
        for(String a : s){
            aux = aux + a +"\n";
        }
        return aux;
    }
    
    
    public void guardarRecursos(){}
    public void carregarRecursos(){}
    
}