package Paquet;

import java.util.*;
import Recurs.Controlador_Domini_Recurs;

public class Controlador_Domini_Recurs {
  private ArrayList<Paquet> p; // Paquet
  private ArrayList<ArrayList<Recurs>> r; //Relacio Paquet-recurs
  private ArrayList<int> o; //Ocupacio del paquet
    
  public Controlador_Domini_Recurs() {
    p = new ArrayList<Paquet>();
    r = new ArrayList<ArrayList<Recurs>>();
    o = new ArrayList<Int>();
  }
    
  public void altaPaquet() {
    p.add(new Paquet());
    r.add(new ArrayList<Integer>());
    o.add(0);
  }
    
  public void baixaPaquet(int id) {
    int pos = buscar_paquet_id(id);
    if (pos < 0) 
    else {
	     p.remove(pos);
	     r.remove(pos);
    }
  }
    
  public void assignarRecurs(int id, String nom) {
    int pos = buscar_paquet_id();
    Controlador_Domini_Recurs n;
    if (pos < 0)
    else {
	     r.get(pos).add(n.obtenirRecurs(nom));
	     ++o.get(pos);
    }
  } 
    
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
  }
    
    public int obtenirOcupacio(int id) {
      int pos = buscar_paquet_id(id);
      if (pos < 0) 
      else return o.get(pos);
    }
    
    public Paquet obtenirPaquet(ind id) {
      int pos = buscar_paquet_id(id);
      if (pos < 0) 
      else return p.get(pos);
    }
    
    public String llistarPaquet() {
      String llistatPaquets = new String();
      llistatPaquets +=  "-------------\n";
      for(int i = 0; i < p.paquet) {
        llistatPaquets += p.get(i).obtenirId() + " " + o.get(i) + "\n";
      }
      llistatPaquets = llistatPaquets + "-------------";
      return llistatPaquets;  
    }
    
    public void guardarRecursos(){}
    public void carregarRecursos(){}
    
    private int buscar_paquet_id(int id) {
      for (int i = 0; i < p.size(); ++i) {
	       if (p.get(i).obtenirID() == id) return i;
      }
      return -1;
    }
    
    private int buscar_recurs_nom(int pos, String nom) {
      for (int i = 0; i < o.get(pos); ++i) {
	       if (p.get(pos).get(i).equals(nom)) return i;
      }
      return -1;
    } 
    
  
}