/**
 *
 *Classe Paquets
 *
 *@author Jordi Vilella
 */

public class Entrada{
	private double[][] mat_dis_plan;
	private int[][] mat_nec_plan;
	private int[][] mat_rec_plan;
	private String[] recu;
	private String[] plan;
	private Controlador_Domini_Univers cdu;
	private Controlador_Domini_Recurs cdr;
	
	public Entrada() {}
	public Entrada(Controlador_Domini_Recurs cdr, Controlador_Domini_Univers cdu) {
		this.cdr = cdr;
		this.cdu = cdu;
	}
	public void calcularMatrius(String nom_univers) {
        //System.out.println("yolo1");
		mat_dis_plan = cdu.matriuDistanciaPlanetes(nom_univers);
		mat_nec_plan = cdu.matriuNecesitatsPlanetes(nom_univers);
		mat_rec_plan = cdu.matriuRecursosPlanetes(nom_univers);
		plan = cdu.vectorPlanetes(nom_univers);
		recu = new String[cdr.totalRecursos()];
		Iterable<String> s = cdr.llistatRecurs_2();
		String aux = new String();
		int i = 0;
		for (String a : s) {
			recu[i] = a;
			++i;
		}
	}

	public double[][] obtenirMatriuDisPla() {
		return mat_dis_plan;
	}

	public int[][] obtenirMatriuNecPla() {
		return mat_nec_plan;
	}

	public int[][] obtenirMatriuRecPla() {
		return mat_rec_plan;
	}

	public String[] obtenirVectorRecu() {
		return recu;
	}
	
	public String[] obtenirVectorPlan() {
		return plan;
	}

}


