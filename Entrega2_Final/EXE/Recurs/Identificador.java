/**
 *
 *Classe Recurs
 *
 *@author Claudi
 */

public class Identificador{
    private static int idRecurs = -1;
    private static int idPaquet = -1;
    private static int idPlaneta = -1;
    private static int idUnivers = -1;
    
    public Identificador(){}
    
    public int idRecurs(){
        ++idRecurs;
        return idRecurs;
    }
    
    public int idPaquet(){
        ++idPaquet;
        return idPaquet;
    }
    
    public int idPlaneta(){
        ++idPlaneta;
        return idPlaneta;
    }
    
    public int idUnivers(){
        ++idUnivers;
        return idUnivers;
    }
    //IMPORTANT: al carregar cal reset id's.
    public void reset(){
        idRecurs = -1;
        idPaquet = -1;
        idPlaneta = -1;
        idUnivers = -1;
        
    }
}