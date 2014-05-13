/**
 *
 *Classe Recurs
 *
 *@author Claudi
 */

public class Recurs{
    
    //Class atributes
    private Identificador i;
    private int id;
    private String nom;

    //Constructores
    
    //Pre: True.
    //Post: Instancia de Recurs.
    public Recurs(){
        i = new Identificador();
        id = i.idRecurs();
        nom = "Recurs_"+id;
    }
    
    //Pre: True.
    //Post: Instancia de Recurs.
    public Recurs(String n){
        i = new Identificador();
        id = i.idRecurs();
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