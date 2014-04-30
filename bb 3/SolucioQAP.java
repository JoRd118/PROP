import java.util.*;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;


public class SolucioQAP {

  private String planeta;
  private boolean terraformat;
  private String observacions;
  private String nomalgoritme;
  private double millorrecorregut;
  private ArrayList<bbNode> llistanodes;
  private JTree arbre;
  
  public SolucioQAP() {
    planeta = "No definit";
    terraformat = false;
    observacions = "";
    nomalgoritme = "No definit";
    millorrecorregut = 0;
		llistanodes = new ArrayList<bbNode>();
    arbre = null;
  }

  public void imprimirSolucio() {
    System.out.println("==========================");
    System.out.println("PLANETA.......: "+planeta);
    System.out.println("--------------------------");
    System.out.println("  Algoritme...: "+nomalgoritme);
    System.out.println("  TerraFormat.: "+terraformat);
    if(observacions != "") System.out.println("  Observacions: "+observacions);
    if(terraformat) {
      System.out.println("    Millor recorregut..: "+millorrecorregut);
      //System.out.println("    Planetes solucio...: "+planetessolucio);
    }
    if(arbre != null) {
      System.out.println("--------------------------");
      System.out.println("Arbre:");
    }
    // Pintem els nodes
    if(llistanodes != null) {
      for(bbNode nn:llistanodes) nn.imprimirNode();
    }
    System.out.println("==========================");
    System.out.println();
    
    if(arbre != null) {
      // Construccio i visualitzacio de la finestra
      JFrame v = new JFrame();
      JScrollPane scroll = new JScrollPane(arbre);
      v.getContentPane().add(scroll);
      v.pack();
      v.setVisible(true);
      v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    // Si volem accedir al contingut
    if(arbre != null) {
      DefaultMutableTreeNode node = (DefaultMutableTreeNode) arbre.getModel().getRoot();
      if(node != null) {
        NodeArbre nnn = (NodeArbre) node.getUserObject();
//        System.out.println(nnn.obtenirIdNode());
      }
    }

    

  }
  
  
  public String obtenirPlaneta() { return planeta; }
  public boolean obtenirTerraformat() { return terraformat; }
  public String obtenirObservacions() { return observacions; }
  public String obtenirNomAlgoritme() { return nomalgoritme; }
  public double obtenirMillorRecorregut() { return millorrecorregut; }
	public ArrayList<bbNode> obtenirLlistaNodes() { return llistanodes; }

  public void modificarPlaneta(String planeta) { this.planeta = planeta; }
  public void modificarTerraformat(boolean terraformat) { this.terraformat = terraformat; }
  public void modificarObservacions(String observacions) { this.observacions = observacions; }
  public void modificarNomAlgoritme(String nomalgoritme) { this.nomalgoritme = nomalgoritme; }
  public void modificarMillorRecorregut(double millorrecorregut) { this.millorrecorregut = millorrecorregut; }
  public void modificarLlistaNodes(ArrayList<bbNode> llistanodes) { this.llistanodes = new ArrayList<bbNode>(llistanodes); }
  public void assignarArbre(DefaultMutableTreeNode mutarrel) { 
    DefaultTreeModel model = new DefaultTreeModel(mutarrel);
    this.arbre = new JTree(model);
  }

}
