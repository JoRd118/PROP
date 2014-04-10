
import java.util.*;
import java.io.IOException;
import java.lang.Math;
/**
 *
 *@author Jordi Farran
 */


public class Controlador_Domini_Univers{
		
		

	//Atributs
	private ArrayList<Univers> u;
	private ArrayList<ArrayList<Planeta> > p;
	private Controlador_Domini_Planeta cp;

	private String msg_univers_no_exists = "Error de Univers: Univers demanat no existeix";
	private String msg_univers_repetit = "Error de Univers: Ja existei un univers amb aquest nom";
	//Instanciacio de la estructura de dades
	/*public Controlador_Domini_Univers(Controlador_Domini_Planeta cp1){
		u = new ArrayList<Univers>();
		p = new ArrayList<ArrayList<Planeta>>();
		cp = cp1;
	}*/

	public Controlador_Domini_Univers(){
		u = new ArrayList<Univers>();
		p = new ArrayList<ArrayList<Planeta>>();
		//cp = new Controlador_Domini_Planeta;
	}
	//Constructor
	public void altaUnivers(String nom){
		//Busca repetits
		if(buscar_univers(nom) >= 0)throw new IllegalArgumentException(msg_univers_repetit);
		else{
			Univers aux = new Univers(nom);
			u.add(aux);
		}
	}

	public void baixaUnivers(String nom){
		int pos = buscar_univers(nom);
		if(pos < 0) throw new IllegalArgumentException(msg_univers_no_exists);
		else u.remove(pos);
	}

	public void modificacioNomUnivers(String nomUnivers, String newnomUnivers){
		int pos = buscar_univers(newnomUnivers);
		if(pos >= 0)throw new IllegalArgumentException(msg_univers_repetit);
		else{
			pos = buscar_univers(nomUnivers);
			if(pos < 0)throw new IllegalArgumentException(msg_univers_no_exists);
			else u.get(pos).modificarNomUnivers(newnomUnivers);
		}
	}

	public Univers obtenirUnivers(String nom){
		int pos = buscar_univers(nom);
		if(pos < 0) throw new IllegalArgumentException(msg_univers_no_exists);
		else return u.get(pos);
	}

	public int obtenirIdUnivers(String nom){
		int pos = buscar_univers(nom);
		if(pos < 0) throw new IllegalArgumentException(msg_univers_no_exists);
		else return u.get(pos).obtenirIdUnivers();
	}

	public String obtenirNomUnivers(int id){
		int pos = buscar_univers_nom(id);
		if (pos < 0)throw new IllegalArgumentException(msg_univers_no_exists);
		else return u.get(pos).obtenirNomUnivers();
	}
	
	public String llistatUnivers(){
		String llistatUniversos = new String();
		llistatUniversos = llistatUniversos+"-------------------\n";
		for(int i = 0; i < u.size();++i){
			llistatUniversos = llistatUniversos + u.get(i).obtenirIdUnivers()+" "+u.get(i).obtenirNomUnivers()+"\n";			
		}
		llistatUniversos = llistatUniversos+"-------------------";
		return llistatUniversos;
	}
	//NEED THIS!//

	public int numPlanetesUnivers(int id){
		int pos = buscar_univers_nom(id);
		if(pos < 0)throw new IllegalArgumentException(msg_univers_no_exists);
		else return p.get(id).size();
	}


    public ArrayList<Planeta> dadesPlanetesUnivers(int id){
    	int pos = buscar_univers_nom(id);
		if(pos < 0)throw new IllegalArgumentException(msg_univers_no_exists);
    	return p.get(id);

    }

  	public double[][] matriuDistanciaPlanetes(int id_univers){
  		double[][] distancies = new double[p.get(id_univers).size()][p.get(id_univers).size()];
  		for(int i = 0; i < p.get(id_univers).size(); ++i){
  			for(int j = 0; j < p.get(id_univers).size(); ++j){
  				if(i == j)distancies[i][j] = -1;
  				else{

  					double p1x = (double) p.get(id_univers).get(i).obtenirCoordenades().obtenirCoordenadesX();
  					double p1y = (double) p.get(id_univers).get(i).obtenirCoordenades().obtenirCoordenadesY();
  					double p2x = (double) p.get(id_univers).get(j).obtenirCoordenades().obtenirCoordenadesX();
  					double p2y = (double) p.get(id_univers).get(j).obtenirCoordenades().obtenirCoordenadesY();
  					distancies[i][j] = Math.sqrt(Math.pow((p2x-p1x),2)+Math.pow((p2y-p1y),2));	
  				} 
  			}
  		}
  		return distancies;
  	}
    
    public void afegirPlanetaUnivers(int idUnivers, int id){
    	/*Planeta aux = new Planeta();
    	aux = cp.obtenirPlaneta(id);
    	p.get(idUnivers).add(aux);*/
    }

    

	private int buscar_univers(String nom){
		for(int i = 0; i < u.size(); ++i){
			if(u.get(i).obtenirNomUnivers().equals(nom)) return i;
		}
		return -1;
	}

	private int buscar_univers_nom(int id){
		for(int i = 0; i < u.size(); ++i){
			if(u.get(i).obtenirIdUnivers() == id)return i;
		}
		return -1;
	}


}
