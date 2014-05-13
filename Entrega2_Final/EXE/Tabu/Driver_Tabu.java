import java.util.*;
import java.io.IOException;
/*
 *
 *Driver Tabu Search
 *@author Claudi
 */
public class Driver_Tabu {
	private static Tabu t;
    private static SolucioQAP sQAP;
	public static void menu() {
        System.out.println("Escoge una opción:");
        System.out.println("\t 00) Salida.");
        System.out.println("\t 01) public Tabu().");
        System.out.println("\t 02) public SolucioQAP Calcular(int indexPlanetaCalcul, String[] mPlanetes, String[] mRecursos, double[][] mDistancies, int[][] mDisponibilitats, int[][] mNecessitats)");
        System.out.println("\t 03) public String obtenirPlaneta().");
        System.out.println("\t 04) public boolean obtenirTerraformat().");
        System.out.println("\t 05) public String obtenirObservacions().");
        System.out.println("\t 06) public String obtenirNomAlgoritme().");
        System.out.println("\t 07) public double obtenirMillorRecorregut().");
        System.out.println("\t 08) public ArrayList<bbNode> obtenirLlistaNodes().");
        System.out.println("\t 09) public ArrayList<Integer> obtenirLlistaMillors()");
        System.out.println("\t 10) public ArrayList<Integer> obtenirLlistaParcials()");
        System.out.println("\t 11) public void processarSolucions().");
    }
    
    
    public static void main(String[] args) {
		System.out.println("Driver Tabu");
        Scanner scan = new Scanner(System.in);
        boolean out = false;
        menu();
        //String entd;
        //String enti;
        //int nfiles, ncolumnes;
        String entrada;
        sQAP = new SolucioQAP();
        int n = 0;
        int i = 0;
        int j = 0;
        int enti = 0;
        double entd = 0;
        int nx = 0;
        int ny = 0;
        while(!out){
            try{
                String op = scan.nextLine();
                switch (op) {
                    case "01":
                        t = new Tabu();
                        break;
                        
                    case "02":
                        /*
                        String aux = scan.nextLine();
                        int indexPlanetaCalcul = Integer.parseInt(aux);
                        
                        aux = scan.nextLine();
                        int auxSize = Integer.parseInt(aux);
                        String[] mPlanetes = new String[auxSize];
                        for(i = 0; i < auxSize; ++i){
                            mPlanetes[i] = scan.nextLine();
                        }
                        
                        aux = scan.nextLine();
                        int auxSize2 = Integer.parseInt(aux);
                        String[] mRecursos = new String[auxSize2];
                        for(int i2 = 0; i2 < auxSize2; ++i2){
                            mRecursos[i2] = scan.nextLine();
                        }
                        
                        
                        
                        enti = scan.nextLine();
                        nfiles = Integer.parseInt(enti);
                        enti = scan.nextLine();
                        ncolumnes = Integer.parseInt(enti);
                        double mDistancies[][] = new double[nfiles][ncolumnes];
                        for (int i3 = 0; i3 < nfiles; i3++) {
                            String linia = scan.nextLine();
                            String[] elements = linia.split(",");
                            for (int j = 0; j < ncolumnes; j++) {
                                mDistancies[i3][j] = Double.valueOf(elements[j]);
                            }
                        }
                        
                        enti = scan.nextLine();
                        nfiles = Integer.parseInt(enti);
                        enti = scan.nextLine();
                        ncolumnes = Integer.parseInt(enti);
                        int mDisponibilitats[][] = new int[nfiles][ncolumnes];
                        for (int i4 = 0; i4 < nfiles; i4++) {
                            String linia = scan.nextLine();
                            String[] elements = linia.split(",");
                            for (int j = 0; j < ncolumnes; j++) {
                                mDisponibilitats[i4][j] = Integer.parseInt(elements[j]);
                            }
                        }
                        
                        enti = scan.nextLine();
                        nfiles = Integer.parseInt(enti);
                        enti = scan.nextLine();
                        ncolumnes = Integer.parseInt(enti);
                        int mNecessitats[][] = new int[nfiles][ncolumnes];
                        for (int i5 = 0; i5 < nfiles; i5++) {
                            String linia = scan.nextLine();
                            String[] elements = linia.split(",");
                            for (int j = 0; j < ncolumnes; j++) {
                                mNecessitats[i5][j] = Integer.parseInt(elements[j]);
                            }
                        }
                         */
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
                        sQAP = t.Calcular(indexPlanetaCalcul, mPlanetes, mRecursos, mDistancies, mDisponibilitats, mNecessitats);
                        break;
                        
                    case "03":
                        System.out.println(sQAP.obtenirPlaneta());
                        break;
                    case "04":
                        System.out.println(sQAP.obtenirTerraformat());
                        break;
                    case "05":
                        String obs = sQAP.obtenirObservacions();
                        if (obs.equals("")) System.out.println("No hi ha observacions");
                        else System.out.println(sQAP.obtenirObservacions());
                        break;
                    case "06":
                        System.out.println(sQAP.obtenirNomAlgoritme());
                        break;
                    case "07":
                        System.out.println(sQAP.obtenirMillorRecorregut());
                        break;
                    case "08":
                        ArrayList<bbNode> l = new ArrayList<bbNode>();
                        l = sQAP.obtenirLlistaNodes();
                        for (i=0; i < l.size(); i++) {
                            System.out.println(l.get(i).obtenirIdNode());
                        }
                        break;
                    case "09":
                        ArrayList<Integer> lm = new ArrayList<Integer>();
                        lm = sQAP.obtenirLlistaMillors();
                        for (i=0; i < lm.size(); i++) {
                            System.out.println(lm.get(i));
                        }
                        break;
                    case "10":
                        ArrayList<Integer> lp = new ArrayList<Integer>();
                        lp = sQAP.obtenirLlistaParcials();
                        for (i=0; i < lp.size(); i++) {
                            System.out.println(lp.get(i));
                        }
                    case "11":
                        sQAP.processarSolucions();
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