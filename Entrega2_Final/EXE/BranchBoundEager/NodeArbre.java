

public class NodeArbre {
  private String nomplaneta;
  private Integer comptador;
  private Integer idnode;
      
  public NodeArbre(String nomplaneta, Integer comptador, Integer idnode) {
    this.nomplaneta = nomplaneta;
    this.comptador = comptador;
    this.idnode = idnode;
  }

  public Integer obtenirIdNode() { return this.idnode; }

  public void modificarIdNode(Integer idnode) { this.idnode = idnode; }
      
  @Override
  public String toString(){
    return comptador.toString() + " " + nomplaneta+" ("+ idnode.toString()+")";
  }

}
