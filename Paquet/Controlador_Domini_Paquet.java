import java.util.*;
import java.io.IOException;

public class Controlador_Domini_Paquet{
    
    private ArrayList<Paquet> p; // Paquet
    private ArrayList<ArrayList<Recurs>> r; //Relacio Paquet-recurs
   // private List<Integer> o; //Ocupacio del paquet

    private static String msg_paquet_no_exists = "Error de Paquet: Paquet demanat no existeix.";
    private static String msg_recurs_no_exists = "Error de Recurs: Recurs demanat no existeix.";

    public Controlador_Domini_Paquet() {
        p = new ArrayList<Paquet>();
        r = new ArrayList<ArrayList<Recurs>>();
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
        if (pos < 0) throw new IllegalArgumentException(msg_paquet_no_exists);
            else {
                Controlador_Domini_Recurs n = new Controlador_Domini_Recurs();
                r.get(pos).add(n.obtenirRecurs(nom));
                int aux = p.get(pos).obtenirOcupacio() + 1;
                p.get(pos).modificarOcupacio(aux);
            }
    }
    
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
    
    public void esborrarRecurs(int id, String nom) {
        int pos = buscar_paquet_id(id);
        if (pos < 0) throw new IllegalArgumentException(msg_paquet_no_exists);
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
        if (pos < 0) throw new IllegalArgumentException(msg_paquet_no_exists);
        else return p.get(pos);
    }
    
    
    private int buscar_paquet_id(int id) {
        for (int i = 0; i < p.size(); ++i) {
            if (p.get(i).obtenirId() == id) return i;
        }
        return -1;
    }
    
    public int buscar_recurs_nom(int pos, String nom) {
        for (int i = 0; i < p.get(pos).obtenirOcupacio(); ++i) {
            if (r.get(pos).get(i).obtenirNom().equals(nom)) return i;
        }
        return -1;
    } 
    
    
}