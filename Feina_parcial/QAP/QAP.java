import java.util.*;
import java.io.IOException;

public class QAP {
	private static String msg_QAP = "Error de QAP: Algorisme no trobat";

	public QAP() {}

	public void run_algorithm(Entrada e, Solucio sol, String opcio) {
        sol = new Solucio();
        long time_start, time_end;
        time_start = System.currentTimeMillis();
		double[][] mDistancies = e.obtenirMatriuDisPla();
        int[][] mDisponibilitats = e.obtenirMatriuRecPla();
        int[][] mNecessitats = e.obtenirMatriuNecPla();
        String[] mPlanetes = e.obtenirVectorPlan();
        String[] mRecursos = e.obtenirVectorRecu();
        for(int ipclc = 0; ipclc < mPlanetes.length; ipclc++) {
            SolucioQAP s = new SolucioQAP(); 
            if(opcio.equals("BBL")) {
                BranchBound bb = new BranchBoundLazy();
                s = bb.Calcular(ipclc, mPlanetes, mRecursos, mDistancies, mDisponibilitats, mNecessitats);
            } else if(opcio.equals("BBE")) {
                BranchBound bb = new BranchBoundEager();
                s = bb.Calcular(ipclc, mPlanetes, mRecursos, mDistancies, mDisponibilitats, mNecessitats);
            } else if(opcio.equals("TABU")) {
                Tabu t = new Tabu();
                s = t.Calcular(ipclc, mPlanetes, mRecursos, mDistancies, mDisponibilitats, mNecessitats);
            }
            else throw new IllegalArgumentException(msg_QAP);
            s.processarSolucions();
            sol.afegirSolucioQAP(s);
        }
        time_end = System.currentTimeMillis();
        sol.afegirTemps(time_end - time_start);
    }
}
