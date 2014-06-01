import java.util.*;
import java.io.IOException;

public class Driver_BranchBoundLazy {

    static BranchBound bb = new BranchBoundLazy();
	public static void menu() {
        System.out.println("Escoge una opción:");
        System.out.println("\t 00) Salida.");
        System.out.println("\t 01) public SolucioQAP Calcular(int indexPlanetaCalcul, String[] mPlanetes, String[] mRecursos, double[][] mDistancies, int[][] mDisponibilitats, int[][] mNecessitats).");
        System.out.println("\t 02) public String obtenirPlaneta().");
        System.out.println("\t 03) public boolean obtenirTerraformat().");
        System.out.println("\t 04) public String obtenirObservacions().");
        System.out.println("\t 05) public String obtenirNomAlgoritme().");
        System.out.println("\t 06) public double obtenirMillorRecorregut().");
        System.out.println("\t 07) public ArrayList<bbNode> obtenirLlistaNodes().");
        System.out.println("\t 08) public ArrayList<Integer> obtenirLlistaMillors()");
        System.out.println("\t 09) public ArrayList<Integer> obtenirLlistaParcials()");
        System.out.println("\t 10) public void processarSolucions().");
	System.out.println("\t 11) public String arbreSolucio().");
	System.out.println("\t 12) public String printSolucioQAP().");

    }
public static void main(String[] args) {
		System.out.println("Driver Branch & Bound Lazy");
        Scanner scan = new Scanner(System.in);
        boolean out = false;
        menu();
        String entrada;
        int n;
        int i;
        int j;
        int enti;
        double entd;
        int nx;
        int ny;
        SolucioQAP sQAP = new SolucioQAP();
while(!out){
            try{
                String op = scan.nextLine();
                switch (op) {
                    case "01":
                        // index planeta a calcular
                        entrada = scan.nextLine();
                        int indexPlanetaCalcul = Integer.parseInt(entrada);
                        // mPlanetes
                        entrada = scan.nextLine();
                        n = Integer.parseInt(entrada);
                        String[] mPlanetes = new String[n];
                        for (i = 0; i < n; i++) {
                            mPlanetes[i] = scan.nextLine();
                        }

                        // mRecursos
                        entrada = scan.nextLine();
                        n = Integer.parseInt(entrada);
                        String[] mRecursos = new String[n];
                        for (i = 0; i < n; i++) {
                            mRecursos[i] = scan.nextLine();
                        }

                        // mDistancies
                        entrada = scan.nextLine();
                        n = Integer.parseInt(entrada);
                        double mDistancies[][] = new double[n][n];
                        for (i = 0; i < n; i++) {
                            String linia = scan.nextLine();
                            String[] elements = linia.split(",");
                            for (j = 0; j < n; j++) {
                                mDistancies[i][j] = Double.valueOf(elements[j]);
                            }
                        }
                        // mDisponibilitats
                        entrada = scan.nextLine();
                        nx = Integer.parseInt(entrada);
                        entrada = scan.nextLine();
                        ny = Integer.parseInt(entrada);
                        int mDisponibilitats[][] = new int[nx][ny];
                        for (i = 0; i < nx; i++) {
                            String linia = scan.nextLine();
                            String[] elements = linia.split(",");
                            for (j = 0; j < ny; j++) {
                                mDisponibilitats[i][j] = Integer.parseInt(elements[j]);
                            }
                        }


                        // mNecessitats
                        entrada = scan.nextLine();
                        nx = Integer.parseInt(entrada);
                        entrada = scan.nextLine();
                        ny = Integer.parseInt(entrada);
                        int mNecessitats[][] = new int[nx][ny];
                        for (i = 0; i < nx; i++) {
                            String linia = scan.nextLine();
                            String[] elements = linia.split(",");
                            for (j = 0; j < ny; j++) {
                                mNecessitats[i][j] = Integer.parseInt(elements[j]);
                            }
                        }

                        sQAP = bb.Calcular(indexPlanetaCalcul, mPlanetes, mRecursos, mDistancies, mDisponibilitats, mNecessitats);

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
                    case "10":
                        sQAP.processarSolucions();
                        break;
		    case "11":
			System.out.println(sQAP.arbreSolucio());
			break;
		    case "12":
			System.out.println(sQAP.printSolucioQAP());
			break;
                    case "00":
                        out = true;
                        break;
                    default:
                        System.out.println("Opció incorrecte.");
                        break;
                }
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scan.close();
    }
}
