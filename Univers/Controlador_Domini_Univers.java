
import java.util.*;
import java.io.IOException;
import java.lang.Math;
/**
 *
 *@author Jordi Farran
 */


public class Controlador_Domini_Univers{
		
		

	//Atributs
	private TST<Univers> u;
	private TST<TST<Planeta> > p;
	private Controlador_Domini_Planeta cp;


	private String msg_univers_no_exists = "Error de Univers: Univers demanat no existeix";
	private String msg_univers_repetit = "Error de Univers: Ja existei un univers amb aquest nom";
	//Instanciacio de la estructura de dades
	
	public Controlador_Domini_Univers(Controlador_Domini_Planeta cp1){
		u = new TST<Univers>();
		p = new TST<TST<Planeta>>();
		cp = cp1;
	}

	public Controlador_Domini_Univers(){
		u = new TST<Univers>();
		p = new TST<TST<Planeta>>();
		//cp = new Controlador_Domini_Planeta;
		//ArrayList<Planeta> p1 = new ArrayList<Planeta>();
	}
	//Constructor
	public void altaUnivers(String nom){
		TST<Planeta> p1 = new TST<Planeta>();
		Univers aux = new Univers(nom);
		u.insert(nom,aux);
		p.insert(nom,p1);//COMPROBAR-HO
	}

	public void baixaUnivers(String nom){	
		u.remove(nom);
		p.remove(nom);
		 
	}

	public void modificacioNomUnivers(String nomUnivers, String newnomUnivers){
		u.obtain(nomUnivers).modificarNomUnivers(newnomUnivers);
		TST<Planeta> aux = p.obtain(nomUnivers);
		p.remove(nomUnivers);
		p.insert(newnomUnivers, aux);
	}

	public Univers obtenirUnivers(String nom){
		return u.obtain(nom);
	}

	public int obtenirIdUnivers(String nom){
		return u.obtain(nom).obtenirIdUnivers();
	}

	/*public String obtenirNomUnivers(int id){
		int pos = buscar_univers_nom(id);
		if (pos < 0)throw new IllegalArgumentException(msg_univers_no_exists);
		else return u.get(pos).obtenirNomUnivers();
	}*/
	
	public String llistatUnivers(){

		Iterable<String> s = u.obtainAllTST();
		String aux = new String();
        for(String a : s){
            aux = aux + a +"\n";
        }
        return aux;
		/*String llistatUniversos = new String();
		llistatUniversos = llistatUniversos+"-------------------\n";
		for(int i = 0; i < u.size();++i){
			llistatUniversos = llistatUniversos + u.get(i).obtenirIdUnivers()+" "+u.get(i).obtenirNomUnivers()+"\n";			
		}
		llistatUniversos = llistatUniversos+"-------------------";
		return llistatUniversos;*/
	}

	public int numPlanetesUnivers(String nom){
		TST<Planeta> p1 = new TST<Planeta>();
		p1 = p.obtain(nom);
		return p1.nElements();
	}


    /*public ArrayList<Planeta> dadesPlanetesUnivers(int id){
    	int pos = buscar_univers_nom(id);
		if(pos < 0)throw new IllegalArgumentException(msg_univers_no_exists);
    	return p.get(id);

    }*/

  	public double[][] matriuDistanciaPlanetes(String nom_univers){
  		TST<Planeta> p1 = new TST<Planeta>();
  		p1 = p.obtain(nom_univers);
  		double[][] distancies = new double[p1.nElements()][p1.nElements()];
  		Iterable<String> s = p1.obtainAllTST();
  		int i = 0;
  		for(String a : s){
  			int j = 0;
  			for(String b : s){ 
  				Planeta auxi = p1.obtain(a);
  				Planeta auxj = p1.obtain(b);
  				if(auxi.obtenirId() == auxj.obtenirId())distancies[i][j] = 0;
  				else{

  					double p1x = (double) auxi.obtenirCoordenades().obtenirCoordenadesX();
  					double p1y = (double) auxi.obtenirCoordenades().obtenirCoordenadesY();
  					double p2x = (double) auxj.obtenirCoordenades().obtenirCoordenadesX();
  					double p2y = (double) auxj.obtenirCoordenades().obtenirCoordenadesY();
  					distancies[i][j] = Math.sqrt(Math.pow((p2x-p1x),2)+Math.pow((p2y-p1y),2));	
  				} 
  				++j;
  			}
  			++i;
  		}
  		return distancies;
  	}

    
    public void afegirPlanetaUnivers(String nomUnivers, String nomPlaneta){
    	TST<Planeta> p1 = new TST<Planeta>();
    	Planeta aux = new Planeta();
    	p1 = p.obtain(nomUnivers);
    	aux = cp.obtenirPlaneta(nomPlaneta);
    	p1.insert(aux.obtenirNom(),aux);
    }


    public void desafegirPlanetaUnivers(String nomUnivers, String nomPlaneta){
    	TST<Planeta> p1 = new TST<Planeta>();
    	Planeta aux = new Planeta();
    	p1 = p.obtain(nomUnivers); 
    	p1.remove(nomPlaneta);
    }

}
