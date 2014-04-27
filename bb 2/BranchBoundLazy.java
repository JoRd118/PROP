import java.util.*;

public class BranchBoundLazy extends BranchBound {

  public BranchBoundLazy() {
    super();
    super.modificarNomAlgoritme(super.obtenirNomAlgoritme()+" lazy");
  }

  protected boolean calAfegirPlaneta(int ip, int idPlanetaVisitat, ArrayList<Integer> novesNecessitatsPendents, int[][] mDisponibilitats) {
    return (ip != idPlanetaVisitat);
  }
  

}