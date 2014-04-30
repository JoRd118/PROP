import java.util.*;
import javax.swing.tree.DefaultMutableTreeNode;

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
  private DefaultMutableTreeNode mutnode;
			
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
    mutnode = null;
	}

	public bbNode(int idnode, int idnodepare, int idplaneta, boolean essolucio, boolean descartat, int nivell,
	              double recorregut, double cotarestant, int ordreprimer, double ordresegon,
								ArrayList<Integer> cami,
								ArrayList<Integer> necessitatspendents,
								ArrayList<Integer> planetespendents,
								DefaultMutableTreeNode mutnode) {
		this.idnode = idnode;
		this.idnodepare = idnodepare;
		this.idplaneta = idplaneta;
		this.essolucio = essolucio;
		this.descartat = descartat;
		this.nivell = nivell;
		this.recorregut = recorregut;
		this.cotarestant = cotarestant;
		this.ordreprimer = ordreprimer;
		this.ordresegon = ordresegon;
		this.cami = new ArrayList<Integer>(cami);
		if(necessitatspendents == null) this.necessitatspendents = null;
		else this.necessitatspendents = new ArrayList<Integer>(necessitatspendents);
		if(planetespendents == null) this.planetespendents = null;
		else this.planetespendents = new ArrayList<Integer>(planetespendents);
    this.mutnode = mutnode;
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
	public DefaultMutableTreeNode obtenirMutNode() { return mutnode; }

//  public void modificarEsSolucio(boolean essolucio) { this.essolucio = essolucio; }
//  public void modificarIdPlaneta(int idplaneta) { this.idplaneta = idplaneta; }
  public void modificarCotaRestant(double cotarestant) { this.cotarestant = cotarestant; }
  public void modificarOrdreSegon(double ordresegon) { this.ordresegon = ordresegon; }
  public void modificarDescartat(boolean descartat) { this.descartat = descartat; }


  public void imprimirNode() {
		System.out.println();
    System.out.println("Node: "+this.idnode+" (pare: "+this.idnodepare+")");
		System.out.println("  idplaneta.. "+this.idplaneta);
    if(cami != null) {
      System.out.print("  visitats..:");
      for(int ip:this.cami) System.out.print(" "+ip);
		  System.out.println();
		}
		System.out.println("  es solucio. "+this.essolucio);
		System.out.println("  descartat.. "+this.descartat);
		System.out.println("  nivell..... "+this.nivell);
		System.out.println("  recorregut. "+this.recorregut);
		System.out.println("  cotarestant "+this.cotarestant);
		System.out.println("  ordreprimer "+this.ordreprimer);
		System.out.println("  ordresegon. "+this.ordresegon);
    if(necessitatspendents != null) {
      System.out.print("  necessitats pendents:");
      for(int ir:this.necessitatspendents) System.out.print(" "+ir);
		  System.out.println();
		}
    if(planetespendents != null) {
  		System.out.print("  planetes pendents...:");
      for(int ip:this.planetespendents) System.out.print(" "+ip);
		  System.out.println();
		}
	  System.out.println();
  }

};
