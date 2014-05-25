import java.util.*;
/**
 *
 *Driver Solucio
 *
 *@author jordi Vilella
 */

public class Solucio {
	private ArrayList<SolucioQAP> sol;
	private int temps;


	public Solucio() {
        sol = new ArrayList<SolucioQAP>();
    }

	public void afegirSolucioQAP(SolucioQAP s) {
		sol.add(s);
	}

	public void afegirTemps(int tem) {
		temps = tem;
	}

	public int obtenirTemps() {
		return temps;
	}


}