import java.util.*;
import java.io.IOException;
/**
 *
 *Driver Solucio
 *
 *@author Jordi Vilella
 */
public class Driver_Solucio{
    
    private static Solucio s;
    private static SolucioQAP sQAP;
    
    
    public static void menu() {
        System.out.println("Escollir opcio:");
        
        //---Solucio---
        System.out.println("Solucio:");
        System.out.println("\t 01) public Solucio().");
        System.out.println("\t 02) public void algoritme(String nom).");
        System.out.println("\t 03) public void afegirSolucioQAP(SolucioQAP s).");
        System.out.println("\t 04) public void afegirTemps(long tem).");
        System.out.println("\t 05) public void afegirEntrada(String en).");
        System.out.println("\t 06) public long obtenirTemps().");
        System.out.println("\t 07) public String printSolucioSeguent().");
        System.out.println("\t 08) public String printSolucioAnterior().");
        System.out.println("\t 09) public String printSolucio().");
        
        //---SolucioQAP---
        System.out.println("SolucioQAP:");
        System.out.println("\t 101) public SolucioQAP().");
        System.out.println("\t 102) public String obtenirPlaneta().");
        System.out.println("\t 103) public boolean obtenirTerraformat().");
        System.out.println("\t 104) public String obtenirObservacions().");
        System.out.println("\t 105) public String obtenirNomAlgoritme().");
        System.out.println("\t 106) public double obtenirMillorRecorregut().");
        System.out.println("\t 107) public ArrayList<bbNode> obtenirLlistaNodes().");
        System.out.println("\t 108) public ArrayList<Integer> obtenirLlistaMillors()");
        System.out.println("\t 109) public ArrayList<Integer> obtenirLlistaParcials()");
        System.out.println("\t 110) public void modificarPlaneta(String planeta).");
        System.out.println("\t 111) public void modificarTerraformat(boolean terraformat).");
        System.out.println("\t 112) public void modificarObservacions(String observacions).");
        System.out.println("\t 113) public void modificarNomAlgoritme(String nomalgoritme).");
        System.out.println("\t 114) public void modificarMillorRecorregut(double millorrecorregut).");
        System.out.println("\t 115) public void modificarLlistaNodes(ArrayList<bbNode> llistanodes).");
        System.out.println("\t 116) public void assignarArbre(ArbreNode nodea).");
        System.out.println("\t 117) public void processarSolucions().");
        
        
        System.out.println("\t 00) Salida.");
    }
    
    public static void main(String[] args) {
        String nombreClase = "Solucio";
        System.out.println("Driver " + nombreClase);
        Scanner scan = new Scanner(System.in);
        boolean out = false;
        String nom;
        Long tem;
        int i;
        int n;

        menu();
        
        while(!out){
            try{
                String op = scan.nextLine();
                switch (op) {
                    case "00":
                        out = true;
                        break;
                        
                    case "01":
                        s = new Solucio();
                        break;

                    case "02":
                        nom = scan.nextLine();
                        s.algoritme(nom);
                        break;

                    case "03":
                        s.afegirSolucioQAP(sQAP);
                        break;

                    case "04":
                        tem = Long.parseLong(scan.nextLine());
                        s.afegirTemps(tem);
                        break;

                    case "05":
                        nom = scan.nextLine();
                        s.afegirEntrada(nom);
                        break;

                    case "06":
                        System.out.println(s.obtenirTemps());
                        break;

                    case "07":
                        System.out.println(s.printSolucioSeguent());
                        break;

                    case "08":
                        System.out.println(s.printSolucioAnterior());
                        break;

                    case "09":
                        System.out.println(s.printSolucio());
                        break;
                    
                    case "101":
                        sQAP = new SolucioQAP();
                        break;
                    case "102":
                        System.out.println(sQAP.obtenirPlaneta());
                        break;
                    case "103":
                        System.out.println(sQAP.obtenirTerraformat());
                        break;
                    case "104":
                        String obs = sQAP.obtenirObservacions();
                        if (obs.equals("")) System.out.println("No hi ha observacions");
                        else System.out.println(sQAP.obtenirObservacions());
                        break;
                    case "105":
                        System.out.println(sQAP.obtenirNomAlgoritme());
                        break;
                    case "106":
                        System.out.println(sQAP.obtenirMillorRecorregut());
                        break;
                    case "107":
                        ArrayList<bbNode> l = new ArrayList<bbNode>();
                        l = sQAP.obtenirLlistaNodes();
                        for (i=0; i < l.size(); i++) {
                            System.out.println(l.get(i).obtenirIdNode());
                        }
                        break;
                    case "108":
                        ArrayList<Integer> lm = new ArrayList<Integer>();
                        lm = sQAP.obtenirLlistaMillors();
                        for (i=0; i < lm.size(); i++) {
                          System.out.println(lm.get(i));
                        }
                        break;
                    case "109":
                      ArrayList<Integer> lp = new ArrayList<Integer>();
                      lp = sQAP.obtenirLlistaParcials();
                      for (i=0; i < lp.size(); i++) {
                        System.out.println(lp.get(i));
                      }
                      break;
                    case "110":
                        String planeta;
                        //System.out.println("Introdueix el nom del planeta: ");
                        planeta = scan.nextLine();
                        sQAP.modificarPlaneta(planeta);
                        break;
                    case "111":
                        //System.out.println("Ha estat terraformat? Si/No");
                        if (scan.nextLine().equals("Si")) sQAP.modificarTerraformat(true);
                        else sQAP.modificarTerraformat(false);
                        break;
                    case "112":
                        String observacions;
                        //System.out.println("Entra les observacions: ");
                        observacions = scan.nextLine();
                        sQAP.modificarObservacions(observacions);
                        break;
                    case "113":
                        //System.out.println("Introdueix el nom de l'algoritme: ");
                        sQAP.modificarNomAlgoritme(scan.nextLine());
                        break;
                    case "114":
                        String millorrecorregut;
                        //System.out.println("Introdueix el millor recorregut: ");
                        millorrecorregut = scan.nextLine();
                        double mr = Double.parseDouble(millorrecorregut);
                        sQAP.modificarMillorRecorregut(mr);
                        break;
                    case "115":
                        ArrayList<bbNode> al = new ArrayList<bbNode>();
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

                    case "116":
                        String nomplan = scan.nextLine();
                        String compan = scan.nextLine();
                        String idnan = scan.nextLine();
                        ArbreNode nar = new ArbreNode(nomplan, Integer.parseInt(compan), Integer.parseInt(idnan));
                        sQAP.assignarArbre(nar);
                        break;

                    case "117":
                        sQAP.processarSolucions();
                        break;

                    default:
                        System.out.println("Opció no valida.");
                        break;

                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            finally{
                //S'executa SEMPRE.
            }
        }
        scan.close();
    }
    
}