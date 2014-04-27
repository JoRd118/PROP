import java.util.*;

public class bbNode {
  private int idnode;
	private int idplaneta;
	private double recorregut;
	ArrayList<Integer> cami;
	ArrayList<Integer> necessitatspendents;
	ArrayList<Integer> planetespendents;
			
	public bbNode() {
		idnode=-1;
		idplaneta = -1;
		recorregut = -1;
		cami = new ArrayList<Integer>();
		necessitatspendents = new ArrayList<Integer>();
		planetespendents = new ArrayList<Integer>();
	}

	public bbNode(int idnode, int idplaneta, double recorregut,
								ArrayList<Integer> cami,
								ArrayList<Integer> necessitatspendents,
								ArrayList<Integer> planetespendents) {
		this.idnode = idnode;
		this.idplaneta = idplaneta;
		this.recorregut = recorregut;
		this.cami = new ArrayList<Integer>(cami);
		this.necessitatspendents = new ArrayList<Integer>(necessitatspendents);
		this.planetespendents = new ArrayList<Integer>(planetespendents);
	}
	
	public int obtenirIdNode() { return idnode; }
	public int obtenirIdPlaneta() { return idplaneta; }
	public double obtenirRecorregut() { return recorregut; }
	public ArrayList<Integer> obtenirCami() { return cami; }
	public ArrayList<Integer> obtenirNecessitatsPendents() { return necessitatspendents; }
	public ArrayList<Integer> obtenirPlanetesPendents() { return planetespendents; }
	public void modificarIdPlaneta(int idplaneta) { this.idplaneta = idplaneta; }
	public void modificarRecorregut(double recorregut) { this.recorregut = recorregut; }

};
