import java.util.*;

public class ArbreNode {
  private String nomplaneta;
  private Integer comptador;
  private Integer idnode;
  private List<ArbreNode> fills;
      
  public ArbreNode(String nompla, Integer comp, Integer idn) {
    nomplaneta = nompla;
    comptador = comp;
    idnode = idn;
  }

  public Integer obtenirIdNode() { return idnode; }
  public String obtenirNomPlaneta() { return nomplaneta; }

  public void modificarIdNode(Integer idn) { idnode = idn; }

  public List<ArbreNode> obtenirFills() {
    if (fills == null) {
        return new ArrayList<ArbreNode>();
    }
    return fills;
  }
 
  public void modificarFills(List<ArbreNode> f) {
    fills = f;
  }
 
  public int obtenirNombreDeFlls() {
    if (fills == null) {
        return 0;
    }
    return fills.size();
  }
     
  public void afegirFill(ArbreNode nodefill) {
    if (fills == null) {
      fills = new ArrayList<ArbreNode>();
    }
    fills.add(nodefill);
  }

  private String informacio() {
    String s = comptador.toString() + " " + nomplaneta + " ";
    if(idnode<0) s = s + "-"; else s = s + idnode.toString();
    return s;
  }


  @Override
  public String toString() {
    String sb = "";
    if(idnode>=0) {
      sb = sb + "{" + informacio() + ",[";
      int i = 0;
      for (ArbreNode e : obtenirFills()) {
//        if(e.idnode>=0) {
          if (i > 0) {
            sb = sb + ",";
          }
          sb = sb + e.informacio();
          i++;
//        }
      }
      sb = sb + "]}\n";
    }
    return sb;
  }


/*
  @Override
  public String toString(){
    return comptador.toString() + " " + nomplaneta+" ("+ idnode.toString()+")";
  }
*/
}
