import java.util.*;

public class SolucioQAP {

  private String planeta;
  private boolean terraformat;
  private String observacions;
  private String nomalgoritme;
  private double cotainicial;
  private double millorrecorregut;
  private String planetessolucio;
  private int planetesanalitzats;
  private int nodesutilitzats;
  

  public SolucioQAP() {
    planeta = "No definit";
    terraformat = false;
    observacions = "";
    nomalgoritme = "No definit";
    cotainicial = 0;
    millorrecorregut = 0;
    planetessolucio = "";
    planetesanalitzats = 0;
    nodesutilitzats = 0;
  }

  public void imprimirSolucio() {
    System.out.println("==========================");
    System.out.println("PLANETA.......: "+planeta);
    System.out.println("--------------------------");
    System.out.println("  Algoritme...: "+nomalgoritme);
    System.out.println("  TerraFormat.: "+terraformat);
    if(observacions != "") System.out.println("  Observacions: "+observacions);
    System.out.println("    Cota inicial.......: "+cotainicial);
    System.out.println("    Planetes analitzats: "+planetesanalitzats);
    System.out.println("    Nodes utilitzats...: "+nodesutilitzats);
    if(terraformat) {
      System.out.println("    Millor recorregut..: "+millorrecorregut);
      System.out.println("    Planetes solucio...: "+planetessolucio);
    }
    System.out.println("==========================");
    System.out.println();
  }
  
  
  public String obtenirPlaneta() { return planeta; }
  public boolean obtenirTerraformat() { return terraformat; }
  public String obtenirObservacions() { return observacions; }
  public String obtenirNomAlgoritme() { return nomalgoritme; }
  public double obtenirCotaInicial() { return cotainicial; }
  public double obtenirMillorRecorregut() { return millorrecorregut; }
  public String obtenirPlanetesSolucio() { return planetessolucio; }
  public int obtenirPlanetesAnalitzats() { return planetesanalitzats; }
  public int obtenirNodesUtilitzats() { return nodesutilitzats; }


  public void modificarPlaneta(String planeta) { this.planeta = planeta; }
  public void modificarTerraformat(boolean terraformat) { this.terraformat = terraformat; }
  public void modificarObservacions(String observacions) { this.observacions = observacions; }
  public void modificarNomAlgoritme(String nomalgoritme) { this.nomalgoritme = nomalgoritme; }
  public void modificarCotaInicial(double cotainicial) { this.cotainicial = cotainicial; }
  public void modificarMillorRecorregut(double millorrecorregut) { this.millorrecorregut = millorrecorregut; }
  public void modificarPlanetesSolucio(String planetessolucio) { this.planetessolucio = planetessolucio; }
  public void modificarPlanetesAnalitzats(int planetesanalitzats) { this.planetesanalitzats = planetesanalitzats; }
  public void modificarNodesUtilitzats(int nodesutilitzats) { this.nodesutilitzats = nodesutilitzats; }


}
