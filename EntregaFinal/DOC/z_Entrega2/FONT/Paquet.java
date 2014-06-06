import java.util.*;
import java.io.IOException;
/**
 *
 *Classe Paquets
 *
 *@author Jordi Vilella
 */

public class Paquet{

	//Atribtus

	private int id;
	private TST<Recurs> r;
	private static String msg_recurs_ja_assignat = "Error de Paquet: Recurs demanat ja esta assignat en el paquet.";
    private static String msg_recurs_no_esta_assignat = "Error de Paquet: Recurs demanat no esta assignat al paquet.";

	//Constructores
	
	public Paquet(){
	}

	public Paquet(int newid) {
		id = newid;
        r = new TST<Recurs>(); 
	}

	//Consultores
	public int obtenirId(){
		return id;
	}
	
    public void assignarRecurs(String nom, Recurs rec) {
        if(!r.contains(nom)) {
        	r.insert(nom,rec);
        }
        else throw new IllegalArgumentException(msg_recurs_ja_assignat);
    }


    public void esborrarRecurs(String nom) {
        if (r.contains(nom)) {
            r.remove(nom);
        }
        else throw new IllegalArgumentException(msg_recurs_no_esta_assignat);
    }

    public boolean validarrecurs(String nom) {
        if (r.contains(nom)) return true;
        else return false;
    }

    public Iterable<String> llistatRecursosIterator() {
        return r.obtainAllTST();
    }

    public String llistatRecursos(){
        Iterable<String> s = r.obtainAllTST();
        String llistat = new String();
        for(String a : s){
            llistat += a + "\n";
        }
        return llistat;
    }
}


