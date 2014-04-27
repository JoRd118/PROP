import java.util.*;

public class BranchBoundEager extends BranchBound {

  public BranchBoundEager() {
    super();
    super.modificarNomAlgoritme(super.obtenirNomAlgoritme()+" eager");
  }

  protected boolean calAfegirPlaneta(int ip, int idPlanetaVisitat, ArrayList<Integer> novesNecessitatsPendents, int[][] mDisponibilitats) {
    boolean calAfegir = false;
    // Saltem planeta actual
  	if(ip != idPlanetaVisitat) {
      // Nomes ens quedem planetes amb disponibilitats necessaries
  		for(Integer ir: novesNecessitatsPendents){
	  		if(mDisponibilitats[ip][ir] == 1) { calAfegir = true; break; }
		  }
		}
    return calAfegir;
  }
  

}