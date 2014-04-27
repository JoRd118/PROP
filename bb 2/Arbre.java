/*
 * Arbre.java
 * @desc Arbre generic amb una arrel.
 */

/**
 *
 * @author oriolbv
 */
public class Arbre<T> {
    Node<T> arrel;
    
    /**
     * Constructor de l'arbre amb arrel
     * @param arrel 
     */
    public Arbre(Node<T> arrel) {
        this.arrel = arrel;
    }
    
    /**
     * Convierte a texto l'arbre
     * @return 
     */
    public String convertirNode() {
        return arrel.convertirNode();
    }    
}
