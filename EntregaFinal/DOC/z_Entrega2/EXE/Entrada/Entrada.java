/**
*
*Classe Entrada
*
*@author Jordi Vilella
*/

public class Entrada {
	private double[][] mat_dis_plan;
	private int[][] mat_nec_plan;
	private int[][] mat_rec_plan;
	private String[] recu;
	private String[] plan;
	private static String msg_pos = "Error Entrada: la posicio demanada no es correcta.";
	private static String msg_inv = "Error Entrada: matrius inserides invalides";

	public Entrada() {}

	public Entrada(double[][] dis, int[][] nec, int[][] rec, String[] pl, String[] re) {
		mat_dis_plan = dis;
		mat_nec_plan = nec;
		mat_rec_plan = rec;
		plan = pl;
		recu = re;
	}

	//Consultores
	public double obtenirPosDis(int i, int j) {
		if(validarPos(mat_dis_plan, i, j)) return mat_dis_plan[i][j];
		return -1;
	}

	public int obtenirPosNecPlaneta(int i, int j) {
		if(validarPos(mat_nec_plan, i, j)) return mat_nec_plan[i][j];
		return -1;
	}

	public int obtenirPosRecPlaneta(int i, int j) {
		if(validarPos(mat_rec_plan, i, j)) return mat_rec_plan[i][j];
		return -1;
	}

	public String obtenirPosRecu(int i) {
		if(validarPos(recu, i)) return recu[i];
		return null;
	}

	public String obtenirPosPlan(int i) {
		if(validarPos(plan, i)) return plan[i];
		return null;
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

	public String obtenirMatriuDisString() {
		String aux = new String();
		for(int i = 0; i < mat_dis_plan.length; ++i) {
			for (int j = 0; j < mat_dis_plan[0].length; ++j) {
				if (j > 0) aux += ",";
				aux += mat_dis_plan[i][j];
			}
			aux += "\n";
		}
		return aux;
	}

	public String obtenirMatriuNecString() {
		String aux = new String();
		for(int i = 0; i < mat_nec_plan.length; ++i) {
			for (int j = 0; j < mat_nec_plan[0].length; ++j) {
				if (j > 0) aux += ",";
				aux += mat_nec_plan[i][j];
			}
			aux += "\n";
		}
		return aux;
	}

	public String obtenirMatriuRecString() {
		String aux = new String();
		for(int i = 0; i < mat_rec_plan.length; ++i) {
			for (int j = 0; j < mat_rec_plan[0].length; ++j) {
				if (j > 0) aux += ",";
				aux += mat_rec_plan[i][j];
			}
			aux += "\n";
		}
		return aux;
	}

	public String obtenirRecursosString() {
		String aux = new String();
		for(int i = 0; i < recu.length; ++i) {
			if (i > 0) aux += ",";
			aux += recu[i];
		}
		aux += "\n";
		return aux;
	}

	public String obtenirPlanetesString() {
		String aux = new String();
		for(int i = 0; i < plan.length; ++i) {
			if (i > 0) aux += ",";
			aux += plan[i];
		}
		aux += "\n";
		return aux;
	}

	public String obtenirMatrius() {
		String aux = new String();
		aux = "Matrius distancies\n";
		aux += obtenirMatriuDisString();
		aux += "Matrius necessitats\n";
		aux += obtenirMatriuNecString();
		aux += "Matrius recursos\n";
		aux += obtenirMatriuRecString();
		aux += "Vector recursos\n";
		aux += obtenirRecursosString();
		aux += "Matrius Planetes\n";
		aux += obtenirPlanetesString();
		return aux;
	}

	//Modificadores 
	public void modificarMatrius(double[][] dis, int[][] nec, int[][] rec, String[] pl, String[] re) {
		mat_dis_plan = dis;
		mat_nec_plan = nec;
		mat_rec_plan = rec;
		plan = pl;
		recu = re;
	}

	public void modificarMatriusString(String dist, String nec, String rec, String p, String r) {
		String[] linia;
		String[] col;

		int nplant;
		int nrec;
        linia = p.split("\n");
        nplant = Integer.parseInt(linia[0]);
        plan = new String[nplant];
        plan = linia[1].split(",");
        if (plan.length != nplant) throw new IllegalArgumentException(msg_inv);
        
        linia = r.split("\n");
        nrec = Integer.parseInt(linia[0]);
        recu = new String[nrec];
        recu = linia[1].split(",");
        if (recu.length != nrec) throw new IllegalArgumentException(msg_inv);

        		//System.out.println(nplant);
        		//System.out.println(nrec);
        linia = rec.split("\n");
        if(nplant != Integer.parseInt(linia[0]) && nrec != Integer.parseInt(linia[1])) throw new IllegalArgumentException(msg_inv);
        mat_rec_plan = new int[nplant][nrec];
        for(int i = 0; i < nplant; ++i) {
        	col = linia[i + 2].split(",");
        	for(int j = 0; j < nrec; ++j) {
        		mat_rec_plan[i][j] = Integer.parseInt(col[j]);
        	}
        }

        linia = nec.split("\n");
        if(nplant != Integer.parseInt(linia[0]) && nrec != Integer.parseInt(linia[1])) throw new IllegalArgumentException(msg_inv);
        mat_nec_plan = new int[nplant][nrec];
        for(int i = 0; i < nplant; ++i) {
        	col = linia[i + 2].split(",");
        	for(int j = 0; j < nrec; ++j) {
        		mat_nec_plan[i][j] = Integer.parseInt(col[j]);
        	}
        }

        linia = dist.split("\n");
        if(nplant != Integer.parseInt(linia[0]) && nplant != Integer.parseInt(linia[1])) throw new IllegalArgumentException(msg_inv);
        mat_dis_plan = new double[nplant][nplant];
        for(int i = 0; i < nplant; ++i) {
        	col = linia[i + 2].split(",");
        	for(int j = 0; j < nplant; ++j) {
        		mat_dis_plan[i][j] = Double.parseDouble(col[j]);
        	}
        }
	}

	public void modificarPosDis(int i, int j, double valor) {
		if(validarPos(mat_dis_plan, i, j)) mat_dis_plan[i][j] = valor;
	}

	public void modificarPosNecPlaneta(int i, int j, int valor) {
		if(validarPos(mat_nec_plan, i, j)) mat_nec_plan[i][j] = valor;
	}

	public void modificarPosRecPlaneta(int i, int j, int valor) {
		if(validarPos(mat_rec_plan, i, j)) mat_rec_plan[i][j] = valor;
	}

	public void modificarPosRecu(int i, String valor) {
		if(validarPos(recu, i)) recu[i] = valor;
	}

	public void modificarPosPlan(int i, String valor) {
		if(validarPos(plan, i)) plan[i] = valor;
	}


	private boolean validarPos(double[][] aux, int i, int j) {
		if (i < aux.length && j < aux[0].length && i >= 0 && j >= 0) return true;
		else throw new IllegalArgumentException(msg_pos);
	}

	private boolean validarPos(int[][] aux, int i, int j) {
		if (i < aux.length && j < aux[0].length && j >= 0 && i >= 0) return true;
		else throw new IllegalArgumentException(msg_pos);
	}

	private boolean validarPos(String[] aux, int i) {
		if (i < aux.length && i >= 0) return true;
		else throw new IllegalArgumentException(msg_pos);
	}
}	
