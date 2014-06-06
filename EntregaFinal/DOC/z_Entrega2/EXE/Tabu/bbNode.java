import java.util.*;

public class bbNode {
  private int idnode;
	private int idnodepare;
	private int idplaneta;
  private boolean essolucio;
  private boolean descartat;
  private int nivell;
  private int ordreprimer; // Primer nivell d'ordenacio: Lazy = nivell / Eager = 0
  private double ordresegon; // Segon nivell d'ordenacio: recorregut + cotarestant
	private double recorregut; // Cami recorregut
  private double cotarestant; // Gilmore restant. Eager abans d'entrar en cua de prioritat
                              // Lazy quan extraiem de la cua de prioritat.
	private ArrayList<Integer> cami;
	private ArrayList<Integer> necessitatspendents;
	private ArrayList<Integer> planetespendents;
  private ArbreNode arbrenode;
			
	public bbNode() {
		idnode=-1;
		idnodepare=-1;
		idplaneta = -1;
		essolucio = false;
    descartat = false;
    nivell = -1;
		recorregut = -1;
    cotarestant = -1;
    ordreprimer = -1;
    ordresegon = -1;
		cami = new ArrayList<Integer>();
		necessitatspendents = new ArrayList<Integer>();
		planetespendents = new ArrayList<Integer>();
    arbrenode = null;
	}

	public bbNode(int idn, int idnp, int idpl, boolean essol, boolean desc, int niv,
	              double rec, double cotarest, int ordreprim, double ordreseg,
								ArrayList<Integer> c,
								ArrayList<Integer> necpend,
								ArrayList<Integer> plapend,
								ArbreNode arbren) {
		idnode = idn;
		idnodepare = idnp;
		idplaneta = idpl;
		essolucio = essol;
		descartat = desc;
		nivell = niv;
		recorregut = rec;
		cotarestant = cotarest;
		ordreprimer = ordreprim;
		ordresegon = ordreseg;
		cami = new ArrayList<Integer>(c);
		if(necpend == null) necessitatspendents = null;
		else necessitatspendents = new ArrayList<Integer>(necpend);
		if(plapend == null) planetespendents = null;
		else planetespendents = new ArrayList<Integer>(plapend);
    	arbrenode = arbren;
	}
	
	public int obtenirIdNode() { return idnode; }
	public int obtenirIdNodePare() { return idnodepare; }
	public int obtenirIdPlaneta() { return idplaneta; }
	public boolean obtenirEsSolucio() { return essolucio; }
	public boolean obtenirDescartat() { return descartat; }
	public int obtenirNivell() { return nivell; }
	public double obtenirRecorregut() { return recorregut; }
	public double obtenirCotaRestant() { return cotarestant; }
	public int obtenirOrdrePrimer() { return ordreprimer; }
	public double obtenirOrdreSegon() { return ordresegon; }
	public ArrayList<Integer> obtenirCami() { return cami; }
	public ArrayList<Integer> obtenirNecessitatsPendents() { return necessitatspendents; }
	public ArrayList<Integer> obtenirPlanetesPendents() { return planetespendents; }
	public ArbreNode obtenirArbreNode() { return arbrenode; }

  public void modificarIdNode(int idn) { idnode = idn; }
  public void modificarCotaRestant(double cotarest) { cotarestant = cotarest; }
  public void modificarOrdreSegon(double ordreseg) { ordresegon = ordreseg; }
  public void modificarDescartat(boolean desc) { descartat = desc; }


  	public String imprimirNode() {
  		String s = new String();
		s = s + "\n";
		s = s + "Node: " +idnode+" (pare: " +idnodepare+ ")\n";
		s = s + "\tidplaneta: " + idplaneta + "\n";
    	if(cami != null) {
    		s = s + "\tVisitats:";
      		for(int ip:cami) s = s +" "+ip;
		  	s= s + "\n";
		}
		s = s + "\tes solucio: " + essolucio + "\n";
		s = s + "\tnivell: " + nivell + "\n";
		s = s + "\trecorregut: " + recorregut + "\n";
		s = s + "\tcotarestant: " + cotarestant + "\n";
    	if(necessitatspendents != null) {
    		s = s + "\tnecessitats pendents:";
      		for(int ir:necessitatspendents) s = s + " " + ir;
		 	s = s + "\n";
			}
    	if(planetespendents != null) {
    		s = s + "	planetes pendents";
      		for(int ip:planetespendents) s = s + " " + ip;
			s = s + "\n";
  		}
  		return s;
	}
}
