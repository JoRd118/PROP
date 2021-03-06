import java.util.*;
import java.io.IOException;
import java.util.*;
import java.io.Console;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Driver_SolucioQAP {

	private static SolucioQAP sQAP;

	public static void menu(){
		System.out.println("Escoge una opción:");
 		System.out.println("\t 00) Salida.");
        System.out.println("\t 01) public SolucioQAP().");
        System.out.println("\t 02) public String obtenirPlaneta().");
        System.out.println("\t 03) public boolean obtenirTerraformat().");
        System.out.println("\t 04) public String obtenirObservacions().");
        System.out.println("\t 05) public String obtenirNomAlgoritme().");
        System.out.println("\t 06) public double obtenirMillorRecorregut().");
        System.out.println("\t 07) public ArrayList<bbNode> obtenirLlistaNodes().");
        System.out.println("\t 08) public ArrayList<Integer> obtenirLlistaMillors()");
        System.out.println("\t 09) public ArrayList<Integer> obtenirLlistaParcials()");
        System.out.println("\t 10) public void modificarPlaneta(String planeta).");
        System.out.println("\t 11) public void modificarTerraformat(boolean terraformat).");
        System.out.println("\t 12) public void modificarObservacions(String observacions).");
        System.out.println("\t 13) public void modificarNomAlgoritme(String nomalgoritme).");
        System.out.println("\t 14) public void modificarMillorRecorregut(double millorrecorregut).");
        System.out.println("\t 15) public void modificarLlistaNodes(ArrayList<bbNode> llistanodes).");
        System.out.println("\t 16) public void assignarArbre(DefaultMutableTreeNode mutarrel).");
        System.out.println("\t 17) public void processarSolucions().");
			
	}

	public static void main(String[] args){
		String nomClase = "SolucioQAP";
		System.out.println("Driver "+nomClase);
		Scanner scan = new Scanner(System.in);
		boolean out = false;
    int n;
    int i;
		menu();

		while(!out){
			try{
				String op = scan.nextLine();
				switch(op){
					case "00":
						out = true;
						break;
					case "01":
						sQAP = new SolucioQAP();
  						break;
  					case "02":
  						System.out.println(sQAP.obtenirPlaneta());
  						break;
  					case "03":
  						System.out.println(sQAP.obtenirTerraformat());
  						break;
  					case "04":
              String obs = sQAP.obtenirObservacions();
              if (obs.equals("")) System.out.println("No hi ha observacions");
  						else System.out.println(sQAP.obtenirObservacions());
  						break;
  					case "05":
  						System.out.println(sQAP.obtenirNomAlgoritme());
  						break;
  					case "06":
  						System.out.println(sQAP.obtenirMillorRecorregut());
  						break;
  					case "07":
  						ArrayList<bbNode> l = new ArrayList<bbNode>();
  						l = sQAP.obtenirLlistaNodes();
              for (i=0; i < l.size(); i++) {
                System.out.println(l.get(i).obtenirIdNode());
              }
  						break;
            case "08":
              ArrayList<Integer> lm = new ArrayList<Integer>();
              lm = sQAP.obtenirLlistaMillors();
              for (i=0; i < lm.size(); i++) {
                System.out.println(lm.get(i));
              }
              break;
            case "09":
              ArrayList<Integer> lp = new ArrayList<Integer>();
              lp = sQAP.obtenirLlistaParcials();
              for (i=0; i < lp.size(); i++) {
                System.out.println(lp.get(i));
              }
              break;
  					case "10":
  						String planeta;
  						//System.out.println("Introdueix el nom del planeta: ");
  						planeta = scan.nextLine();
  						sQAP.modificarPlaneta(planeta);
   						break;
  					case "11":
  						//System.out.println("Ha estat terraformat? Si/No");
  						if (scan.nextLine().equals("Si")) sQAP.modificarTerraformat(true);
  						else sQAP.modificarTerraformat(false);
  						break;
  					case "12":
  						String observacions;
  						//System.out.println("Entra les observacions: ");
  						observacions = scan.nextLine();
  						sQAP.modificarObservacions(observacions);
  						break;
  					case "13":
  						//System.out.println("Introdueix el nom de l'algoritme: ");
  						sQAP.modificarNomAlgoritme(scan.nextLine());
  						break;
  					case "14":
  						String millorrecorregut;
  						//System.out.println("Introdueix el millor recorregut: ");
  						millorrecorregut = scan.nextLine();
  						double mr = Double.parseDouble(millorrecorregut);
  						sQAP.modificarMillorRecorregut(mr);
  						break;
  					case "15":
  						ArrayList<bbNode> al = new ArrayList<bbNode>();
              // public bbNode(int idnode, int idnodepare, int idplaneta, boolean essolucio, boolean descartat, int nivell,
              //                double recorregut, double cotarestant, int ordreprimer, double ordresegon,
              //                ArrayList<Integer> cami,
              //                ArrayList<Integer> necessitatspendents,
              //                ArrayList<Integer> planetespendents,
              //                DefaultMutableTreeNode mutnode)
              ArrayList<Integer> cami1 = new ArrayList<Integer>();
              ArrayList<Integer> cami2 = new ArrayList<Integer>();
              ArrayList<Integer> cami3 = new ArrayList<Integer>();
              ArrayList<Integer> necpen1 = new ArrayList<Integer>();
              ArrayList<Integer> necpen2 = new ArrayList<Integer>();
              ArrayList<Integer> necpen3 = new ArrayList<Integer>();
              ArrayList<Integer> plapen1 = new ArrayList<Integer>(); 
              ArrayList<Integer> plapen2 = new ArrayList<Integer>();
              ArrayList<Integer> plapen3 = new ArrayList<Integer>();
  						bbNode bbn1 = new bbNode(3, 2, 1, true, false, 0, 34.5, 0, 0, 0, cami1, necpen1, plapen1, null);
              bbNode bbn2 = new bbNode(6, 8, 2, false, true, 2, 5, 0, 0, 0, cami2, necpen2, plapen2, null);
              bbNode bbn3 = new bbNode(7, 9, 3, true, false, 3, 43.5, 0, 0, 0, cami3, necpen3, plapen3, null);
              al.add(bbn1);
              al.add(bbn2);
              al.add(bbn3);
              sQAP.modificarLlistaNodes(al);
  						break;
            case "16":
              /*
              X,Y,Z
              X = id
              Y = nom
              Z = Valor
              - = pujar al nivell superior
              ----------------------------
              Ex:
              0,nom0,100    
              1,nom1,101    
              2,nom2,102
              -
              3,nom3,103
              -
              -
              4,nom4,104
              -
              -
              */
              DefaultMutableTreeNode mutarrel = null;
              DefaultMutableTreeNode mutnode = null;
              NodeArbre nar;

              boolean vesfent = true;
              while(vesfent) {
                String linia = scan.nextLine();
                String[] dades = linia.split(",");
                String sg = "";
                String s0 = ""; String s1 = ""; String s2 = "";
                if(dades.length == 1) {
                  sg = dades[0];
                } else if(dades.length == 3) {
                  s0 = dades[0]; s1 = dades[1]; s2 = dades[2];
                }
                if(mutarrel == null) {
                  if(!sg.equals("-")) {
                    nar = new NodeArbre(s1, Integer.valueOf(s0), Integer.valueOf(s2));
                    mutnode = new DefaultMutableTreeNode(nar);
                    mutarrel = mutnode;
                  }
                } else {
                  if(sg.equals("-")) {
                    if(mutnode.getParent() != null) {
                      mutnode = (DefaultMutableTreeNode) mutnode.getParent();
                  } else vesfent = false;
                } else {
                  nar = new NodeArbre(s1, Integer.valueOf(s0), Integer.valueOf(s2));
                  DefaultMutableTreeNode mutnounode = new DefaultMutableTreeNode(nar);
                  mutnode.add(mutnounode);
                  mutnode = mutnounode;
                }
              }
            }
            sQAP.assignarArbre(mutarrel);
            Enumeration e = mutarrel.preorderEnumeration();
            while(e.hasMoreElements()){
              DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) e.nextElement();
              for(i=0;i<dmtn.getLevel();i++) System.out.print("..");
              System.out.println(dmtn);
            }
            break;
            case "17":
              sQAP.processarSolucions();
              break;
					default:
						System.out.println("Opcio no valida");
						break;

				}
			}
			catch(Exception e){System.out.println(e.getMessage());}
		}
		scan.close();
	}
}