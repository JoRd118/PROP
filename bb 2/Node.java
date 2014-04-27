/*
 * Node.java
 * @desc Classe per a definir un node amb 0 o 1 pare, n fills i el seu valor
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oriolbv
 */
public class Node<T> {
    
    private Node<T> pare;
    private T valor;
    private List<Node<T>> fills;
    
    /**
     * Construeix un node assignat a un pare amb valor
     * @param pare
     * @param valor 
     */
    public Node(Node<T> pare, T valor) {
        this.pare = pare;
        this.valor = valor;
        fills = new ArrayList<>();
    }
    
    /**
     * Modifica el valor del node
     * @param valor 
     */
    public void modificarValor(T valor) {
        this.valor = valor;
    }
    
    /**
     * Retorna el valor del node
     * @return 
     */
    public T obtenirValor() {
        return valor;
    }    
    
    /**
     * Agrega un fill
     * @param fill 
     */
    public void agregarFill(Node<T> fill) {
        fills.add(fill);
    }    
    
    /**
     * Retrona la llista de fills
     * @return 
     */
    public List<Node<T>> obtenirFills() {
        return this.fills;
    }
    
    /**
     * Indica si el node te fills
     * @return fals si la llista de fills es buida
     */
    public boolean esPare() {
        return !fills.isEmpty();
    }
    
    /**
     * Retorna el node pare
     * @return 
     */
    public Node<T> obtenirPare() {
        return this.pare;
    }
    
    /**
     * Converteix el valor del node a String
     * @return 
     */
    public String convertirNode() {
        StringBuilder bString = new StringBuilder();
        bString.append(this.obtenirValor());
        if (this.esPare()) {
            bString.append("(");
            for (Node<T> n: this.obtenirFills()) {
                bString.append(n.convertirNode());
                bString.append(", ");
            }
            bString.delete(bString.length()-2, bString.length());
            bString.append(")");
        }
        return bString.toString();
    }
}

