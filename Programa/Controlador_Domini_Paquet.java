import java.util.*;
import java.io.IOException;
/**
 *Controlador_Domini_Paquet
 *
 *@author Jordi Vilella
 */

public class Controlador_Domini_Paquet{
    
    private TST<Paquet> p; // Paquet
    private TST<Paquet> pa; // Paquets assignats
    private TST<TST<Recurs>> r; //Relacio Paquet-recurs
    private Controlador_Domini_Recurs cr;

    private static String msg_paquet_no_exists = "Error de Paquet: Paquet demanat no existeix.";
    private static String msg_paquet_ja_assignat = "Error de Paquet: Paquet demanat ja esta assignat.";
    private static String msg_recurs_ja_assignat = "Error de Recurs: Recurs demanat ja esta assignat en el paquet.";
    private static String msg_recurs_no_esta_assignat = "Error de Recurs: Recurs demanat no esta assignat al paquet o no existeix.";

    /*public Controlador_Domini_Paquet() {
        p = new TST<Paquet>();
        pa = new TST<Paquet>();
        r = new TST<TST<Recurs>>();
        cr = new Controlador_Domini_Recurs();
    }
    */
    public Controlador_Domini_Paquet(Controlador_Domini_Recurs n) {
        p = new TST<Paquet>();
        pa = new TST<Paquet>();
        r = new TST<TST<Recurs>>();
        cr = n;

    }

    public void altaPaquet() {
        Paquet aux = new Paquet();
        int id = aux.obtenirId();
        String id_string = Integer.toString(id);
        p.insert(id_string, aux);
        r.insert(id_string, new TST<Recurs>());
    }
    
    public void baixaPaquet(int id) {
        String id_string = Integer.toString(id);
        if (p.contains(id_string)) {
            p.remove(id_string);
            r.remove(id_string);
        }
        else if (pa.contains(id_string)){
            pa.remove(id_string);
            r.remove(id_string);
        }
        else throw new IllegalArgumentException(msg_paquet_no_exists);
    }
    
    public void assignarRecurs(int id, String nom) {
        String id_string = Integer.toString(id);
        if (p.contains(id_string) || pa.contains(id_string)) {
            Recurs rec = new Recurs();
            TST<Recurs> aux = new TST<Recurs>();
            aux = r.obtain(id_string);
            rec = cr.obtenirRecurs(nom);
            if (aux.contains(nom)) throw new IllegalArgumentException(msg_recurs_ja_assignat);
            else {
                aux.insert(nom,rec);
                Paquet paq = new Paquet();
                if (p.contains(id_string)) {
                    paq = p.obtain(id_string);
                    int o = paq.obtenirOcupacio();
                    paq.modificarOcupacio(o + 1);
                }
                else {
                    paq = pa.obtain(id_string);
                    int o = paq.obtenirOcupacio();
                    paq.modificarOcupacio(o + 1);
                }
            }
        }
        else throw new IllegalArgumentException(msg_paquet_no_exists);
    }

    public void esborrarRecurs(int id, String nom) {
        String id_string = Integer.toString(id);
        if (p.contains(id_string) || pa.contains(id_string)) {
            TST<Recurs> aux = new TST<Recurs>();
            aux = r.obtain(id_string);
            if (aux.contains(nom)) {
                aux.remove(nom);
                Paquet paq = new Paquet();
                if (p.contains(id_string)) {
                    paq = p.obtain(id_string);
                    int o = paq.obtenirOcupacio();
                    paq.modificarOcupacio(o - 1);
                }
                else {
                    paq = pa.obtain(id_string);
                    int o = paq.obtenirOcupacio();
                    paq.modificarOcupacio(o - 1);
                }
            }
            else throw new IllegalArgumentException(msg_recurs_no_esta_assignat);
        }
        else throw new IllegalArgumentException(msg_paquet_no_exists);
    }
    
    public Paquet obtenirPaquet(int id) {
        String id_string = Integer.toString(id);
        if (p.contains(id_string)) return p.obtain(id_string);
        else if (pa.contains(id_string)) return pa.obtain(id_string);
        else throw new IllegalArgumentException(msg_paquet_no_exists);
    }

    public Paquet obtenirPaquetAssignar(int id) {
        String id_string = Integer.toString(id);
        if (p.contains(id_string)) {
            Paquet paq = new Paquet();
            paq = p.obtain(id_string);
            p.remove(id_string);
            pa.insert(id_string,paq);
            return paq;
        }
        else if (pa.contains(id_string)) throw new IllegalArgumentException(msg_paquet_ja_assignat);
        else throw new IllegalArgumentException(msg_paquet_no_exists);
    } 
    
    public String llistatPaquetsAssignats(){
        Iterable<String> s = pa.obtainAllTST();
        String aux = new String();
        for(String a : s){
            aux = aux + a +"\n";
        }
        return aux;
    }

    public String llistatPaquetsNoAssignats(){
        Iterable<String> s = p.obtainAllTST();
        String aux = new String();
        for(String a : s){
            aux = aux + a +"\n";
        }
        return aux;
    }

    public String llistatRecursosPaquet(int id){
        String id_string = Integer.toString(id);
        if (r.contains(id_string)) {
            TST<Recurs> aux = r.obtain(id_string);
            Iterable<String> s = aux.obtainAllTST();
            String llistat = new String();
            for(String a : s){
                llistat = llistat + a + "\n";
            }
            return llistat;
        }
        else throw new IllegalArgumentException(msg_paquet_no_exists);
    }
}