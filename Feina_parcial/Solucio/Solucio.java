import java.util.*;
/**
 *
 *Driver Solucio
 *
 *@author jordi Vilella
 */

public class Solucio {
	private ArrayList<SolucioQAP> sol;
	private long temps;


	public Solucio() {
        sol = new ArrayList<SolucioQAP>();
    }

	public void afegirSolucioQAP(SolucioQAP s) {
		sol.add(s);
	}

	public void afegirTemps(long tem) {
		temps = tem;
	}

	public long obtenirTemps() {
		return temps;
	}


}