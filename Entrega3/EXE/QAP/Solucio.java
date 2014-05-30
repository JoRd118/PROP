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
    private String algo;
    private String entrada;
    private int print_sol;
    private static String msg_solucions = "Error de Solucio: No hi han mes solucio.";
    private static String msg_temps = "Error de Solucio: No s'ha afegit cap temps.";
	public Solucio() {
        sol = new ArrayList<SolucioQAP>();
        print_sol = 0;
        temps = -1;
    }

    public void algoritme(String nom) {
        algo = nom;
    }

	public void afegirSolucioQAP(SolucioQAP s) {
		sol.add(s);
        //System.out.println(sol.size());
	}

	public void afegirTemps(long tem) {
		temps = tem;
	}

    public void afegirEntrada(String en) {
        entrada = en;
    }

	public long obtenirTemps() {
		if (temps == -1) throw new IllegalArgumentException(msg_temps);
        return temps;
	}


    public String printSolucioSeguent() {
        if (print_sol >= sol.size()) throw new IllegalArgumentException(msg_solucions);
        String aux = new String();
        SolucioQAP aux1 = sol.get(print_sol);
        aux = aux1.printSolucioQAP();
        if (!algo.equals("TABU")) aux += aux1.arbreSolucio();
        ++print_sol;
        return aux;
    }

    public String printSolucioAnterior() {
        if (print_sol < sol.size()) throw new IllegalArgumentException(msg_solucions);
        String aux = new String();
        SolucioQAP aux1 = sol.get(print_sol);
        aux = aux1.printSolucioQAP() + "\n";
        if (!algo.equals("TABU")) aux += aux1.arbreSolucio();
        --print_sol;
        return aux;
    }

    public String printSolucio() {
        String aux = new String();
        aux = entrada + "\n\n";
        aux += "Temps: " + temps + "ms\n";
        for (int i = 0; i < sol.size(); ++i) {
            SolucioQAP aux1 = sol.get(i);
            //System.out.println(aux1.printSolucioQAP());
            aux += aux1.printSolucioQAP()  + "\n";
            if (!algo.equals("TABU")) aux += aux1.arbreSolucio();
        }
        //System.out.println(aux);
        return aux;
    }
}