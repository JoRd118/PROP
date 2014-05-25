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

	public String arbreSolucio(int i) {
		SolucioQAP solucio = new SolucioQAP();
		solucio = sol.get(i);
        String s = new String();
        s = s + solucio.obtenirPlaneta() + "\n";
        Arbre arbre = new Arbre();
        arbre = solucio.obtenirArbre();
        if (arbre == null) {
            s = s + "No te arbre.\n";
            s = s + solucio.obtenirObservacions() + "\n"; 
        } else {
            s = s + "Arbre Solucio planeta " + solucio.obtenirPlaneta()+ "\n";
            String arbrestring = arbre.toString();
            s = s + arbrestring;
        }
    	return s;
	}

    public String printSolucioQAP(int i) {
        SolucioQAP solucio = new SolucioQAP();
        solucio = sol.get(i);
        String s = new String();
        s = s + "PLANETA: " + solucio.obtenirPlaneta() + "\n";
        s = s + "Algoritme: " + solucio.obtenirNomAlgoritme() + "\n";
        s = s + "Terraformat: " + solucio.obtenirTerraformat() + "\n";
        if (solucio.obtenirObservacions() != "") s = s + "Observacions: " + solucio.obtenirObservacions() + "\n";
        if (solucio.obtenirTerraformat()) s = s + "Millor Recorregut: " + solucio.obtenirMillorRecorregut() + "\n";
        s = s + "   Llista de Nodes:\n";
        if (solucio.obtenirLlistaNodes() != null) {
            for (bbNode nn:solucio.obtenirLlistaNodes()) s = s + nn.imprimirNode();
            s = s + "\n";
        }
        s = s + "Nodes solucio millor:\n";
        if(solucio.obtenirLlistaMillors() != null) {
            if(solucio.obtenirLlistaMillors().size() >= 1) {
                for(Integer j:solucio.obtenirLlistaMillors()) {
                    s = s + solucio.obtenirLlistaNodes().get(j).imprimirNode();
                }
                s = s + "\n";
            }
        }
        s = s + "Nodes solucio parcial:\n";
        if (solucio.obtenirLlistaMillors() != null) {
            if (solucio.obtenirLlistaParcials().size() >= 1) {
                for (Integer k: solucio.obtenirLlistaParcials()) {
                    s = s + solucio.obtenirLlistaNodes().get(i).imprimirNode();
                }
            }        
        }
        return s;
    }
}