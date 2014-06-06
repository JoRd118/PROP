import java.util.*;

// Arbre de ArbreNodes
public class Arbre {
 
    private ArbreNode nodearrel;

    /**
     * Default ctor.
     */
    public Arbre() {
        super();
    }

    public Arbre(ArbreNode nodea) {
        nodearrel = nodea;
    }
 
    // Pre: -
    // Post: Retrona l'arrel ArbreNode del arbre.
    public ArbreNode obtenirNodeArrel() {
        return nodearrel;
    }
 

    // Pre: -
    // Post: Modifica l'arrel del arbre.
    public void modificarNodeArrel(ArbreNode nodea) {
        nodearrel = nodea;
    }
    // Pre: -
    // Post: Retorna l'arbre com una llista de nodes.
    public List<ArbreNode> toList() {
        List<ArbreNode> list = new ArrayList<ArbreNode>();
        walk(nodearrel, list);
        return list;
    }


    // Pre: -
    // Post: Retorna l'arbre amb String.    
    public String toString() {
      StringBuilder sb = new StringBuilder();
      ArrayList<ArbreNode> llista = new ArrayList<ArbreNode>(toList());
      for(ArbreNode an:llista) {
        sb.append(an.toString());
      }
      return sb.toString();
    }

    // Pre: -
    // Post: Recorre l'arbre que estem tractant.     
    private void walk(ArbreNode element, List<ArbreNode> list) {
        list.add(element);
        for (ArbreNode data : element.obtenirFills()) {
            walk(data, list);
        }
    }
}
