/**
 *
 *Classe Paquets
 *
 *@author Jordi Vilella
 */

public class Paquet{

	//Atribtus

	private static int idCounter = 0;
	private int id;
	private int ocupacio;

	//Constructores
	
	public Paquet(){
		id = idCounter;
		idCounter = idCounter + 1;
		ocupacio = 0;
	}

	public Paquet(int id) {
		this.id = id; 
		if(idCounter <= id) idCounter = id +  1;
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


