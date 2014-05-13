/**
 *
 *Classe Recurs
 *
 *@author Claudi
 */

public class Recurs{
    
    //Class atributes
    private int id;
    private String nom;

    //Constructores
    
    //Pre: True.
    //Post: Default.
    public Recurs(int i){
        id = i;
        nom = "Recurs_"+i;
    }
    
    //Pre: True.
    //Post: Instancia de Recurs.
    public Recurs(String n, int i){
        id = i;
        nom = n;
    }
    
    
    //Modificadores
    
    //Pre: True.
    //Post: El nom del recurs queda modificat a que es passa per paramatre.
    public void modificarNomRecurs(String new_name){
        nom = new_name;
    }
    
    
    //Consultores
    
    //Pre: True.
    //Post: Retorna el id del Recurs.
    public int obtenirId(){
        return id;
    }
    
    //Pre: True.
    //Post: Retorna el nom del Recurs.
    public String obtenirNom(){
        return nom;
    }

}