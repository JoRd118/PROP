package Univers;

import java.util.*;
import java.io.IOException;

/**
 *
 *@author Jordi Farran
 */


public class Controlador_Domini_Univers{
		
		

	//Atributs
	private static ArrayList<Univers> u;
	private static ArrayList<ArrayList<Planeta>> p;

	private static String msg_univers_no_exists = "Error de Univers: Univers demanat no existeix";
	private static String msg_univers_repetit = "Error de Univers: Ja existei un univers amb aquest nom";
	//Instanciacio de la estructura de dades
	public Controlador_Domini_Univers(){
		u = new ArrayList<Univers>();
		p = new ArrayList<ArrayList<Planeta>>();
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
	

	public int planetesUnivers(int id){
		return p.get(id).size();
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
