/**
 *
 *Classe Univers
 *
 * @author Jordi Farran
 */
public class Univers {
    //Atributs
    
    private static int idCounter = 0;
    private int idUnivers;
    private String nomUnivers;
     
    
    //Constructora per defecte
    public Univers(){
      idUnivers = idCounter;
      idCounter = idCounter + 1;
      nomUnivers = "default"+idUnivers;
    }

    public Univers(String nom){
      idUnivers = idCounter;
      idCounter = idCounter + 1;
      nomUnivers = nom;
    }    
    //Consultores
    
   
   public int obtenirIdUnivers(){
     return idUnivers;
   }
   
   public String obtenirNomUnivers(){
     return nomUnivers;
   }
   
   //Modificadores
   
   public void modificarNomUnivers(String nomUnivers){
     this.nomUnivers = nomUnivers;
   }
}

