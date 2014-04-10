import java.util.*;
import java.io.IOException;

public class Controlador_Domini_Planeta {
	private ArrayList<Planeta> Conjunt_Planetes;
	//private ArrayList<ArrayList<Recurs> > Necessitats_Planetes;
	//private ArrayList<Paquet> Paquets_Assignats;
    private static String msg_planeta_no_exists = "Error de Planeta: Planeta demanat no existeix.";
    private static String msg_planeta_repetit = "Error de planeta: Ja existeix un planeta amb aquest nom.";





	public Controlador_Domini_Planeta(){
		Conjunt_Planetes = new ArrayList<Planeta>();
	}

	public void altaPlaneta(String nom, Coordenades coord, boolean classeM) {
		if(buscarPlaneta(nom) >= 0)throw new IllegalArgumentException(msg_planeta_repetit);
		else {
			Planeta p = new Planeta(nom, coord, classeM);
			Conjunt_Planetes.add(p);
		}
	}

	public void baixaPlaneta(String nom) {
        int pos = buscarPlaneta(nom);
        if(pos < 0){ throw new IllegalArgumentException(msg_planeta_no_exists);}
        else { 
        	Conjunt_Planetes.remove(pos);
        }		
	}

	public void modificarNom(String nom, String newnom) {
		int pos = buscarPlaneta(newnom);
		if (pos >= 0) throw new IllegalArgumentException(msg_planeta_repetit);
		else {
			pos = buscarPlaneta(nom);
			if (pos < 0) throw new IllegalArgumentException(msg_planeta_no_exists);
			else Conjunt_Planetes.get(pos).modificacioNom(newnom);
		}

	}

	public void modificarCoordenades(String nom, int x, int y) {
		int pos = buscarPlaneta(nom);
		if(pos < 0){ throw new IllegalArgumentException(msg_planeta_no_exists);}
        else { 
        	Conjunt_Planetes.get(pos).modificacioCoordenades(x, y);
        }		
	}

	public void modificarClasse(String nom, boolean classeM) {
		int pos = buscarPlaneta(nom);
		if(pos < 0){ throw new IllegalArgumentException(msg_planeta_no_exists);}
        else { 
        	Conjunt_Planetes.get(pos).modificacioClasse(classeM);
        }
	}

	
	public int obtenirId(String nom) {
		int pos = buscarPlaneta(nom);
		if (pos < 0) throw new IllegalArgumentException(msg_planeta_no_exists);
		else return Conjunt_Planetes.get(pos).obtenirId();
	}


	public String obtenirNom(int id) {
		int pos = buscarPlaneta(id);
		if (pos < 0) throw new IllegalArgumentException(msg_planeta_no_exists);
		else return Conjunt_Planetes.get(pos).obtenirNom();
	}

	public boolean obtenirClasse(String nom) {
		int pos = buscarPlaneta(nom);
		if (pos < 0) throw new IllegalArgumentException(msg_planeta_no_exists);
		else return Conjunt_Planetes.get(pos).obtenirClasse();
	}

	public Coordenades obtenirCoordenades(String nom) {
		int pos = buscarPlaneta(nom);
		if (pos < 0) throw new IllegalArgumentException(msg_planeta_no_exists);
		else return Conjunt_Planetes.get(pos).obtenirCoordenades();
	}
	public Planeta obtenirPlaneta(int id) {
		int pos = buscarPlaneta(id);
		if (pos < 0) throw new IllegalArgumentException(msg_planeta_no_exists);
		else {
			return Conjunt_Planetes.get(pos);
		}
	}



	// OBTENIR LA DISTANCIA ENTRE 2 planetes
	// public double obtenirDistancia(Planeta p1, Planeta p2) {
	// 	double distancia = 0;
	// 	String nomp1 = p1.obtenirNom();
	// 	int pos1 = buscarPlaneta(nomp1);
	// 	String nomp2 = p2.obtenirNom();
	// 	int pos2 = buscarPlaneta(nomp2);
	// 	if (pos1 < 0 || pos2 < 0) throw new IllegalArgumentException(msg_planeta_no_exists);
	// 	else {
			
	// 		// sqrt((x1 - x2)² + (y1 - y2)²)
	// 		// Math.pow(2, 3)	Math.sqrt(***)
	// 	double x1 = Conjunt_Planetes.get(pos1).obtenirCoordenades().obtenirCoordenadesX();
	// 	double x2 = Conjunt_Planetes.get(pos2).obtenirCoordenades().obtenirCoordenadesX();
	// 	double y1 = Conjunt_Planetes.get(pos1).obtenirCoordenades().obtenirCoordenadesY();
	// 	double y2 = Conjunt_Planetes.get(pos2).obtenirCoordenades().obtenirCoordenadesY();
		
	// 	}
	// 	return distancia;
	// }
	


	// OBTENIR TOTES LES NECESSITATS DE 1 PLANETA
	//public String obtenirNecessitats(Planeta p) {}

	// OBTENIR LA ID DEL PAQUET Del PLANETA 
	//public int obtenirIdPaquet(Planeta p) {}

	public ArrayList<Planeta> llistarPlanetes() {
		return Conjunt_Planetes;
	}

    public void guardarPlanetes(){}
    public void carregarPlanetes(){}

    private int buscarPlaneta(String nom){
        for(int i = 0; i < Conjunt_Planetes.size(); ++i){
            if(Conjunt_Planetes.get(i).obtenirNom().equals(nom)) return i;
        }
        return -1;
    }

    private int buscarPlaneta(int id){
        for(int i = 0; i < Conjunt_Planetes.size(); ++i){
            if(Conjunt_Planetes.get(i).obtenirId() == id) return i;
        }
        return -1;
    }


}