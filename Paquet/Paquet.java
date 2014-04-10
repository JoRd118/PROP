/**
 *
 *Clase Paquets
 *
 *@author Jordi Vilella
 */

public class Paquet{

	//Atribtus

	private static int idCounter = 0;
	private int id;
	private int ocupacio;
	//private int capacitat;

	//Constructores
	
	public Paquet(){
		id = idCounter;
		idCounter = idCounter + 1;
		ocupacio = 0;
	}

	//Metodes


	//Consultores
	public int obtenirId(){
		return id;
	}
	
	public int obtenirOcupacio(){
		return ocupacio;
	}
	

	//Modificadores

	public void modificarOcupacio(int ocupacio){
		this.ocupacio = ocupacio;
	}
}


