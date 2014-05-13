/**
 *
 *Classe Recurs
 *
 *@author Claudi
 */

public class Identificador{
    private  int id = -1;
   
    
    public Identificador(){}
    
    public int id(){
        ++id;
        return id;
    }
    //IMPORTANT: al carregar cal reset id's.
    public void reset(){
       id = -1;
        
    }
}