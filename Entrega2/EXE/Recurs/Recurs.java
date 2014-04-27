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
    public Recurs(){
        id = idCounter;
        idCounter = idCounter + 1;
        nom = "Recurs_"+id;
    }
    public Recurs(String nom){
        id = idCounter;
        idCounter = idCounter + 1;
        this.nom = nom;
    }
    
    
    //Modificadores
    public void modificarNomRecurs(String new_name){
        this.nom = new_name;
    }
    
    
    //Consultores
    public int obtenirId(){
        return this.id;
    }
    
    public String obtenirNom(){
        return nom;
    }

}