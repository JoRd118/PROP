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
    private Controlador_Dades t;
    private Controlador_Presentacio cp;
    private Identificador i;
    private static String msg_recurs_no_exists = "Error de Recurs: Recurs demanat no existeix.";
    private static String msg_recurs_repetit = "Error de Recurs: Ja existeix un recurs amb aquest nom.";
    private static String msg_carregar = "Error de Recurs: Carregar no es pot portar a terme perque ja s'han introduit dades.";
    
    //Vista
    private VistaRecurs v;
    
    public Controlador_Domini_Recurs(){
        r = new TST<Recurs>();
        t = new Controlador_Dades();
        i = new Identificador();
        v = new VistaRecurs(this);
    }
    
    public Controlador_Domini_Recurs(Controlador_Presentacio p){
        r = new TST<Recurs>();
        t = new Controlador_Dades();
        i = new Identificador();
        cp = p;
        v = new VistaRecurs(this);
    }
    
    
    public void altaRecurs(String nom){
        //Buscar REPETITS
        if(r.contains(nom))throw new IllegalArgumentException(msg_recurs_repetit);
        else{
            Recurs aux = new Recurs(nom, i.id());
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
    
    public String obtenirNom(Recurs rec){
        return rec.obtenirNom();
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
    
    public Iterable<String> llistatRecurs_2(){
        Iterable<String> s = r.obtainAllTST();
        return s;
    }
    
    public int totalRecursos(){
        return r.nElements();
    }
    
    public void guardarRecursos(String nomFitxer)throws IOException{
        Iterable<String> aux = llistatRecurs_2();
        String substring = new String();
        int aux_count = 0;
        
        t.obrirFitxer(nomFitxer);
        t.deleteFile();
        
        for(String a : aux){
            //System.out.println("R = "+a);
            substring = substring + r.obtain(a).obtenirNom() + "\n";
            ++aux_count;
            //System.out.println("SUBSTRING = "+substring);
            if(aux_count >= 3){
                //System.out.println(substring);
                t.writeTextFile(substring);
                substring = "";
                aux_count = 0;
            }
        }
        if(aux_count < 3){
            //System.out.println(substring);
            t.writeTextFile(substring);
        }
        t.tancarFitxer();
    }
    
    public void carregarRecursos(String nomFitxer)throws IOException{
        i.reset();
        if (r.nElements() > 0) throw new IllegalArgumentException(msg_carregar);
        t.obrirFitxer(nomFitxer);
        String s = t.readTextFile();
        String[] elements = s.split("\n");
        for(int i = 0; i < elements.length; ++i){
            altaRecurs(elements[i]);
        }
        t.tancarFitxer();
    }
    
    public void baixaRecursVista(String n){
        cp.borrar_recurs(n);
    }
    
    public void modificar_nom_recursVista(String a,String b){
        cp.modificar_nom_recurs(a,b);
        
        
        
        
    }
}