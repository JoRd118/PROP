package PROP;
import java.util.*;
import java.io.IOException;

public class Controlador_Domini_Paquet{
    
    private ArrayList<Paquet> p; // Paquet
    private ArrayList<ArrayList<Recurs>> r; //Relacio Paquet-recurs
    private List<Integer> o; //Ocupacio del paquet
    
    public Controlador_Domini_Paquet() {
        p = new ArrayList<Paquet>();
        r = new ArrayList<ArrayList<Recurs>>();
        o = new ArrayList<Integer>();
    }
    
    public void altaPaquet() {
        p.add(new Paquet());
        r.add(new ArrayList<Recurs>());
        o.add(0);
    }
    
   /* public void baixaPaquet(int id) {
        int pos = buscar_paquet_id(id);
        if (pos < 0)
            else {
                p.remove(pos);
                r.remove(pos);
            }
    }*/
    
    public void assignarRecurs(int id, String nom) {
        int pos = buscar_paquet_id(id);
        if (pos < 0) throw new IllegalArgumentException("aaaaa");
            else {
                Controlador_Domini_Recurs n = new Controlador_Domini_Recurs();
                r.get(pos).add(n.obtenirRecurs(nom));
                int a  = o.get(pos);
                o.add(pos,a+1);
            }
    }
    
    /*
    public void esborrarRecurs(int id, String nom) {
        int pos = buscar_paquet_id(id);
        if (pos < 0)
            else {
                int aux = buscar_recurs_nom(pos,nom);
                if (aux < 0)
                    else {
                        p.get(pos).remove(aux);
                        --o.get(pos);
                    }
            }
    }*/
    /*
    public Paquet obtenirPaquet(int id) {
        int pos = buscar_paquet_id(id);
        if (pos < 0) throw new IllegalArgumentException("aaaaa");
            else return p.get(pos);
    }
    */
    
    private int buscar_paquet_id(int id) {
        for (int i = 0; i < p.size(); ++i) {
            if (p.get(i).obtenirId() == id) return i;
        }
        return -1;
    }
    /*
    private int buscar_recurs_nom(int pos, String nom) {
        for (int i = 0; i < o.get(pos); ++i) {
            if (p.get(pos).get(i).equals(nom)) return i;
        }
        return -1;
    } */
    
    
}