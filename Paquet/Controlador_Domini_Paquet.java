import java.util.*;
import java.io.IOException;

public class Controlador_Domini_Paquet{
    
    private ArrayList<Paquet> p; // Paquet
    private ArrayList<Paquet> pa; // Paquets assignats
    private ArrayList<ArrayList<Recurs>> r; //Relacio Paquet-recurs
    private Controlador_Domini_Recurs cr;

    private static String msg_paquet_no_exists = "Error de Paquet: Paquet demanat no existeix.";
    private static String msg_paquet_no_exists_assignat = "Error de Paquet: Paquet demanat no existeix o ja esta assignat.";
    private static String msg_recurs_no_exists = "Error de Recurs: Recurs demanat no existeix.";

    public Controlador_Domini_Paquet() {
        p = new ArrayList<Paquet>();
        r = new ArrayList<ArrayList<Recurs>>();
        cr = new Controlador_Domini_Recurs();
    }
    
    public Controlador_Domini_Paquet(Controlador_Domini_Recurs n) {
        p = new ArrayList<Paquet>();
        r = new ArrayList<ArrayList<Recurs>>();
        cr = n;

    }

    public void altaPaquet() {
        p.add(new Paquet());
        r.add(new ArrayList<Recurs>());
    }
    
    public void baixaPaquet(int id) {
        int pos = buscar_paquet_id(id);
        if (pos < 0) throw new IllegalArgumentException(msg_paquet_no_exists);
            else {
                p.remove(pos);
                r.remove(pos);
            }
    }
    
    public void assignarRecurs(int id, String nom) {
        int pos = buscar_paquet_id(id);
        if (pos < 0) {
            pos = buscar_paquet_id_a(id);
            if (pos < 0) throw new IllegalArgumentException(msg_paquet_no_exists);
            else {
                r.get(pos).add(cr.obtenirRecurs(nom));
                int aux = pa.get(pos).obtenirOcupacio() + 1;
                pa.get(pos).modificarOcupacio(aux);
            }
        }
        else {
            r.get(pos).add(cr.obtenirRecurs(nom));
            int aux = p.get(pos).obtenirOcupacio() + 1;
            p.get(pos).modificarOcupacio(aux);
        }
    }
    /*
    public String obtneirRecursosPaquet(int id) {
        int pos = buscar_paquet_id(id);
        if (pos < 0) throw new IllegalArgumentException(msg_paquet_no_exists);
        else {
            String recu = new String();
            for (int i = 0; i < r.get(pos).size(); ++i) {
                recu = recu + r.get(pos).get(i).obtenirNom() + ",";
            } 
            return recu;
        }
    }
    */
    public void esborrarRecurs(int id, String nom) {
        int pos = buscar_paquet_id(id);
        if (pos < 0) {
            pos = buscar_paquet_id_a(id);
            if (pos < 0) throw new IllegalArgumentException(msg_paquet_no_exists);
            else {
                int aux = buscar_recurs_nom(pos,nom);
                if (aux < 0) throw new IllegalArgumentException(msg_recurs_no_exists);
                else {
                    r.get(pos).remove(aux);
                    pa.get(pos).modificarOcupacio(pa.get(pos).obtenirOcupacio() + 1);
                }
            }
        }
        else {
            int aux = buscar_recurs_nom(pos,nom);
            if (aux < 0) throw new IllegalArgumentException(msg_recurs_no_exists);
            else {
                r.get(pos).remove(aux);
                p.get(pos).modificarOcupacio(p.get(pos).obtenirOcupacio() + 1);
            }
        }
    }
    
    public Paquet obtenirPaquet(int id) {
        int pos = buscar_paquet_id(id);
        if (pos < 0) throw new IllegalArgumentException(msg_paquet_no_exists_assignat);
        else {
            Paquet aux = p.get(pos);
            pa.add(aux);
            p.remove(pos);
            return aux;
        }
    }
    
    
    private int buscar_paquet_id(int id) {
        for (int i = 0; i < p.size(); ++i) {
            if (p.get(i).obtenirId() == id) return i;
        }
        return -1;
    }

    private int buscar_paquet_id_a(int id) {
        for (int i = 0; i < p.size(); ++i) {
            if (pa.get(i).obtenirId() == id) return i;
        }
        return -1;
    }
    
    private int buscar_recurs_nom(int pos, String nom) {
        for (int i = 0; i < p.get(pos).obtenirOcupacio(); ++i) {
            if (r.get(pos).get(i).obtenirNom().equals(nom)) return i;
        }
        return -1;
    }
    
}