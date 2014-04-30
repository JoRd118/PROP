/**
 *
 *Classe Recurs
 *
 *@author Claudi
 */

public class Recurs{
    
    //Class atributes
    private static int idCounter = 0;
    private int id;
    private String nom;

    //Constructores
    
    //Pre: True.
    //Post: Instancia de Recurs.
    public Recurs(){
        id = idCounter;
        idCounter = idCounter + 1;
        nom = "Recurs_"+id;
    }
    
    //Pre: True.
    //Post: Instancia de Recurs.
    public Recurs(String nom){
        id = idCounter;
        idCounter = idCounter + 1;
        this.nom = nom;
    }
    
    
    //Modificadores
    
    //Pre: True.
    //Post: El nom del recurs queda modificat a que es passa per paramatre.
    public void modificarNomRecurs(String new_name){
        this.nom = new_name;
    }
    
    
    //Consultores
    
    //Pre: True.
    //Post: Retorna el id del Recurs.
    public int obtenirId(){
        return this.id;
    }
    
    //Pre: True.
    //Post: Retorna el nom del Recurs.
    public String obtenirNom(){
        return nom;
    }

}