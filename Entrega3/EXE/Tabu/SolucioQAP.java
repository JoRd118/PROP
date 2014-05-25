import java.util.*;

public class SolucioQAP {

  private String planeta;
  private boolean terraformat;
  private String observacions;
  private String nomalgoritme;
  private double millorrecorregut;
  private ArrayList<bbNode> llistanodes;
  private Arbre arbre;
  private ArrayList<Integer> llistamillors;
  private ArrayList<Integer> llistaparcials;

  // pre: -
  // post: Creadora per defecte
  public SolucioQAP() {
    planeta = "No definit";
    terraformat = false;
    observacions = "";
    nomalgoritme = "No definit";
    millorrecorregut = 0;
		llistamillors = new ArrayList<Integer>();
		llistaparcials = new ArrayList<Integer>();
    arbre = null;
  }

//   public void imprimirSolucio() {
//     System.out.println("==========================");
//     System.out.println("PLANETA.......: "+planeta);
//     System.out.println("--------------------------");
//     System.out.println("  Algoritme...: "+nomalgoritme);
//     System.out.println("  TerraFormat.: "+terraformat);
//     if(observacions != "") System.out.println("  Observacions: "+observacions);
//     if(terraformat) {
//       System.out.println("    Millor recorregut..: "+millorrecorregut);
//       //System.out.println("    Planetes solucio...: "+planetessolucio);
//     }
//     String s = new String();
//     System.out.println("--------------------------");
//     System.out.println("Llista de Nodes      -----");
//     System.out.println("--------------------------");
//     // Pintem els nodes
//     if(llistanodes != null) {
//       for(bbNode nn:llistanodes) s = nn.imprimirNode();
//     }
//     System.out.println("--------------------------");
//     System.out.println("Nodes solucio millor -----");
//     System.out.println("--------------------------");
//     if(llistamillors != null) {
//       if(llistamillors.size() >= 1) for(Integer i:llistamillors) s = llistanodes.get(i).imprimirNode();
//     }
//     System.out.println("--------------------------");
//     System.out.println("Nodes solucio parcial ----");
//     System.out.println("--------------------------");
//     if(llistamillors != null) {
//       if(llistaparcials.size() >= 1) for(Integer i:llistaparcials) s = llistanodes.get(i).imprimirNode();
//     }
//     System.out.println("==========================");
//     System.out.println();

// //-------------------------------------------------------------------
//   //  if(arbre != null) {
//       // Construccio i visualitzacio de la finestra
//     //  JFrame v = new JFrame();
//       //JScrollPane scroll = new JScrollPane(arbre);
//       //v.getContentPane().add(scroll);
//       //v.pack();
//       //v.setVisible(true);
//       //v.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//     //}
// //-------------------------------------------------------------------
    
//     // Si volem accedir al contingut
//     if(arbre != null) {
//       System.out.println("--------------------------");
//       System.out.println("Arbre                -----");
//       System.out.println("--------------------------");
// /*
//       ArbreNode node = arbre.obtenirNodeArrel();
//       if(node != null) {
//         System.out.println("Node Arrel[" + node.obtenirIdNode() + "]: " + node.obtenirNomPlaneta());
//       }
//       // Recorrem els nodes de l'arbre
//       ArrayList<ArbreNode> llista = new ArrayList<ArbreNode>(arbre.toList());
//       for(ArbreNode an:llista) {
//         int id = an.obtenirIdNode();
//         if((id>=0)&&(id<llistanodes.size())) {
//           llistanodes.get(an.obtenirIdNode()).imprimirNode();
//         }
//       }
// */
//       System.out.println();
//       System.out.println(arbre.toString());
 
      
//     }

//   }
  
  // pre: -
  // post: Retorna el nom del planeta de la solucio
  public String obtenirPlaneta() { return planeta; }

  // pre: -
  // post: Retorna si el planeta ha estat terraformat o no
  public boolean obtenirTerraformat() { return terraformat; }

  // pre: -
  // post: Retorna les possibles observacions que es poden fer
  //       de la terraformacio del planeta
  public String obtenirObservacions() { return observacions; }

  // pre: -
  // post: Retorna el nom de l'algorisme, del qual ha sortit
  //       la solucio
  public String obtenirNomAlgoritme() { return nomalgoritme; }

  // pre: -
  // post: Retorna el millor recorregut de la solucio, es a dir, 
  //       la suma de les distancies recorregudes pels paquets per
  //       arribar al planeta
  public double obtenirMillorRecorregut() { return millorrecorregut; }

  // pre: -
  // post: Retorna la llista dels nodes 
	public ArrayList<bbNode> obtenirLlistaNodes() { return llistanodes; }

  public Arbre obtenirArbre() { return arbre; }

  // pre: -
  // post: Retorna la llista de les millors solucions
	public ArrayList<Integer> obtenirLlistaMillors() { return llistamillors; }

  // pre: -
  // post: Retorna la llista de les solucions parcials
	public ArrayList<Integer> obtenirLlistaParcials() { return llistaparcials; }

  // pre: -
  // post: Modifica el nom del planeta per planeta
  public void modificarPlaneta(String p) { planeta = p; }

  // pre: -
  // post: Modifica si el planeta ha estat terraformat o no
  public void modificarTerraformat(boolean t) { terraformat = t; }

  // pre: -
  // post: Modifica les observacions possibles per observacions
  public void modificarObservacions(String obs) { observacions = obs; }

  // pre: -
  // post: Modifica el nom de l'algorisme utilitzat per nomalgorisme
  public void modificarNomAlgoritme(String nomalg) { nomalgoritme = nomalg; }

  // pre: -
  // post: Modifica el millor recorregut de la solucio per millorrecorregut
  public void modificarMillorRecorregut(double millorrec) { millorrecorregut = millorrec; }

  // pre: -
  // post: Modifica la llista de nodes per llistanodes
  public void modificarLlistaNodes(ArrayList<bbNode> ll) { llistanodes = new ArrayList<bbNode>(ll); }

  // pre: -
  // post: Crea l'arbre a partir del model de dades
  public void assignarArbre(ArbreNode nodea) {
    arbre = new Arbre(nodea);
  }

  // Clase per ordenar les nodes solucio
  private class infoNode {
    int posicio = 0;
    double recorregut = 0;
    private infoNode(int pos, double rec) {
      posicio = pos;
      recorregut = rec;
    }
  }

  // pre: -
  // post: Es genera la llista de les millors solucions i la de les solucions parcials ordenada
  public void processarSolucions() {
    // Preparem la cua amb prioritat ordenada per recorregut.
    PriorityQueue<infoNode> pqInfos = new PriorityQueue<infoNode>(10,  new Comparator<infoNode>() {
      public int compare(infoNode n1, infoNode n2) {
        int r = 0;
        double c = n1.recorregut-n2.recorregut;
        if(c > 0) r = 1;
        else if(c < 0) r = -1;
        return (r);
      }
    });
    // Comprovem que hi hagi nodes
    if(llistanodes != null) {
      if(llistanodes.size() >= 1) {
        // Ara hi posem els nodes
        for(int i=0;i<llistanodes.size();i++) {
          bbNode nn = llistanodes.get(i);
          // Nomes agafem si es solucio
          if(nn.obtenirEsSolucio()) pqInfos.add(new infoNode(i, nn.obtenirRecorregut()));
        }
        // Ara anirem posant l'ordre
        if (pqInfos != null) {
          if (pqInfos.size() >= 1) {
            infoNode info = pqInfos.poll();
            while(info != null) {
              if(info.recorregut == millorrecorregut) {
                llistamillors.add(info.posicio);
              } else {
                llistaparcials.add(info.posicio);
              }
              // Agafem el proper
              info = pqInfos.poll();
            }
          }
        }
      }
    }
  }

}
