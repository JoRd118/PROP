import java.util.*;
import java.io.IOException;
/**
 *
 *Controlador Domini Classe Recurs
 *
 *@author Claudi
 */
public class Controlador_Domini_Recurs{
    
    private ArrayList<Recurs> r;
    private static String msg_recurs_no_exists = "Error de Recurs: Recurs demanat no existeix.";
    private static String msg_recurs_repetit = "Error de Recurs: Ja existeix un recurs amb aquest nom.";
    
    
    public Controlador_Domini_Recurs(){
        r = new ArrayList<Recurs>();
    }
    
    public void altaRecurs(String nom){
        //Buscar REPETITS
        if(busca_recurs(nom) >= 0)throw new IllegalArgumentException(msg_recurs_repetit);
        else{
        Recurs aux = new Recurs(nom);
        r.add(aux);
        }
    }
    
    public void baixaRecurs(String nom){
        int pos = busca_recurs(nom);
        if(pos < 0){ throw new IllegalArgumentException(msg_recurs_no_exists);}
        else{ r.remove(pos);}
    }
    
    public void modificarNom(String nom, String newnom){
        int pos = busca_recurs(newnom);
        if(pos >= 0){ throw new IllegalArgumentException(msg_recurs_repetit);}
        else{
            pos = busca_recurs(nom);
            if(pos < 0){ throw new IllegalArgumentException(msg_recurs_no_exists);}
            else{ r.get(pos).modificarNomRecurs(newnom);}
        }
    }
    
    public Recurs obtenirRecurs(String nom){
        int pos = busca_recurs(nom);
        if(pos < 0){ throw new IllegalArgumentException(msg_recurs_no_exists);}
        else{ return r.get(pos);}
    }
    
    public int obtenirId(String nom){
        int pos = busca_recurs(nom);
        if(pos < 0){ throw new IllegalArgumentException(msg_recurs_no_exists);}
        else{ return r.get(pos).obtenirId();}
    }
    
    public String obtenirNom(int id){
        int pos = busca_recurs_num(id);
        if(pos < 0){ throw new IllegalArgumentException(msg_recurs_no_exists);}
        else{ return r.get(pos).obtenirNom();}
        
    }
    public boolean validarRecurs(String nom){
        int pos = busca_recurs(nom);
        if(pos > 0) return false;
        else{
            return true;
        }
    
    }
    
    public String llistatRecurs(){
        String llistatRecursos = new String();
        llistatRecursos = llistatRecursos + "-------------\n";
        for(int i = 0; i < r.size(); ++i){
            llistatRecursos = llistatRecursos + r.get(i).obtenirId()+" "+r.get(i).obtenirNom()+"\n";
        }
        llistatRecursos = llistatRecursos + "-------------";
        return llistatRecursos;
    }
    
    
    public void guardarRecursos(){}
    public void carregarRecursos(){}
    
    private int busca_recurs(String nom){
        for(int i = 0; i < r.size(); ++i){
            if(r.get(i).obtenirNom().equals(nom))return i;
        }
        return -1;
    }
    
    private int busca_recurs_num(int id){
        for(int i = 0; i < r.size(); ++i){
            if(r.get(i).obtenirId() == id)return i;
        }
        return -1;
    }
}