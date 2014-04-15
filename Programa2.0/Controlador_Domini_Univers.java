
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
	private Controlador_Domini_Recurs cr;
	private Controlador_Domini_Paquet cpa;

	private String msg_univers_no_exists = "Error de Univers: Univers demanat no existeix";
	private String msg_univers_repetit = "Error de Univers: Ja existei un univers amb aquest nom";
	//Instanciacio de la estructura de dades
	
	public Controlador_Domini_Univers(Controlador_Domini_Planeta cp1, Controlador_Domini_Recurs cr1, Controlador_Domini_Paquet cpa1){ 
		u = new TST<Univers>();
		p = new TST<TST<Planeta>>();
		cp = cp1;
		cr = cr1;
		cpa = cpa1;
	}

	public Controlador_Domini_Univers(){
		u = new TST<Univers>();
		p = new TST<TST<Planeta>>();
	}
	//Constructor
	public void altaUnivers(String nom){
		if(u.contains(nom)) throw new IllegalArgumentException(msg_univers_repetit);
		else{
			TST<Planeta> p1 = new TST<Planeta>();
			Univers aux = new Univers(nom);
			u.insert(nom,aux);
			p.insert(nom,p1);
		}
	}

	public void baixaUnivers(String nom){	
		if(u.contains(nom) == false) throw new IllegalArgumentException(msg_univers_no_exists);
		else{
			u.remove(nom);
			p.remove(nom);
		} 
	}

	public void modificacioNomUnivers(String nomUnivers, String newnomUnivers){
		if(u.contains(nomUnivers) == false) throw new IllegalArgumentException(msg_univers_no_exists);
		else{
			u.obtain(nomUnivers).modificarNomUnivers(newnomUnivers);
			TST<Planeta> aux = p.obtain(nomUnivers);
			p.remove(nomUnivers);
			p.insert(newnomUnivers, aux);
		}	
	}

	public Univers obtenirUnivers(String nom){
		if(u.contains(nom) == false) throw new IllegalArgumentException(msg_univers_no_exists);
		else return u.obtain(nom);
	}

	public int obtenirIdUnivers(String nom){
		if(u.contains(nom) == false) throw new IllegalArgumentException(msg_univers_no_exists);
		else return u.obtain(nom).obtenirIdUnivers();
	}

	
	public String llistatUnivers(){
		Iterable<String> s = u.obtainAllTST();
		String aux = new String();
        for(String a : s){
            aux = aux + a +"\n";
        }
        return aux;
	}

	public int numPlanetesUnivers(String nom){
		if(u.contains(nom) == false) throw new IllegalArgumentException(msg_univers_no_exists);
		else{
			TST<Planeta> p1 = new TST<Planeta>();
			p1 = p.obtain(nom);
			return p1.nElements();
		}
	}



  	public double[][] matriuDistanciaPlanetes(String nom_univers){
  		if(u.contains(nom_univers) == false) throw new IllegalArgumentException(msg_univers_no_exists);
  		else{
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
  	}


	public int[][] matriuNecesitatsPlanetes(String nom_univers){
  		if(u.contains(nom_univers) == false) throw new IllegalArgumentException(msg_univers_no_exists);
  		else{
  			TST<Planeta> p1 = new TST<Planeta>();
  			p1 = p.obtain(nom_univers);
        System.out.println("Numero de recursos:   "+cr.totalRecursos());
  			int[][] necesitats_planetes = new int[p1.nElements()][cr.totalRecursos()];
  			for(int i = 0; i < p1.nElements(); ++i){
  				for(int j = 0; j < cr.totalRecursos();++j){
  					necesitats_planetes[i][j] = 0;
  				}
  			}
  			Iterable<String> s = p1.obtainAllTST();
  			int i = 0;
  			for(String a : s){
  				int j = 0;
  				Planeta auxi = p1.obtain(a);
  				Iterable<String> rec = cr.llistatRecurs_2();
  				Iterable<String> necesitats = cp.obtenirNecessitats(auxi.obtenirNom());
  				for(String b : rec){ 
  					for(String c : necesitats){
  						if(c.equals(b)) necesitats_planetes[i][j] = 1;
  					} 
  				++j;
  				}
  			++i;
  			}
  			return necesitats_planetes;
  		}
  	}

  	public int[][] matriuRecursosPlanetes(String nom_univers){
  		if(u.contains(nom_univers) == false) throw new IllegalArgumentException(msg_univers_no_exists);
  		else{
  			TST<Planeta> p1 = new TST<Planeta>();
  			p1 = p.obtain(nom_univers);
  			int[][] recursos_planetes = new int[p1.nElements()][cr.totalRecursos()];
  			for(int i = 0; i < p1.nElements(); ++i){
  				for(int j = 0; j < cr.totalRecursos();++j){
  					recursos_planetes[i][j] = 0;
  				}
  			}
  			Iterable<String> s = p1.obtainAllTST();
  			int i = 0;
  			for(String a : s){
  				int j = 0;
  				Planeta auxi = p1.obtain(a);
  				Iterable<String> rec = cr.llistatRecurs_2();
  				Iterable<String> recursos = cp.obtenirRecursosDisponibles(auxi.obtenirNom());
  				for(String b : rec){ 
  					for(String c : recursos){
  						if(c.equals(b)) recursos_planetes[i][j] = 1;
  					} 
  				++j;
  				}
  			++i;
  			}
  			return recursos_planetes;
  		}
  	}


    
    public void afegirPlanetaUnivers(String nomUnivers, String nomPlaneta){
    	if(u.contains(nomUnivers) == false) throw new IllegalArgumentException(msg_univers_no_exists);
    	else{
    		TST<Planeta> p1 = new TST<Planeta>();
    		Planeta aux = new Planeta();
    		p1 = p.obtain(nomUnivers);
    		aux = cp.obtenirPlaneta(nomPlaneta);
    		p1.insert(aux.obtenirNom(),aux);
    		cp.assignarPlaneta(aux.obtenirNom());
    	}
    }


    public void desafegirPlanetaUnivers(String nomUnivers, String nomPlaneta){
    	if(u.contains(nomUnivers) == false) throw new IllegalArgumentException(msg_univers_no_exists);
    	else{
    		TST<Planeta> p1 = new TST<Planeta>();
    		Planeta aux = new Planeta();
    		p1 = p.obtain(nomUnivers); 
    		p1.remove(nomPlaneta);
    		cp.desassignarPlaneta(aux.obtenirNom());
    	}
    }

}
