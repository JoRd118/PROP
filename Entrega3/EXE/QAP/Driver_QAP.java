import java.util.*;
import java.io.IOException;
/**
 *
 *Driver Solucio
 *
 *@author jordi Vilella
 */

public class Driver_QAP{
    
    private static QAP q;
    private static Entrada en;
    private static Solucio s;

    public static void menu() {
        System.out.println("Escollir opcio:");
        System.out.println("\n QAP:");
        System.out.println("\t 01) public QAP().");
        System.out.println("\t 02) public void run_algorithm(Entrada e, Solucio sol, String opcio).");
        
        System.out.println("Solucio:");
        System.out.println("\t 101) public Solucio().");
        System.out.println("\t 102) public void algoritme(String nom).");
        System.out.println("\t 104) public void afegirTemps(long tem).");
        System.out.println("\t 105) public void afegirEntrada(String en).");
        System.out.println("\t 106) public long obtenirTemps().");
        System.out.println("\t 107) public String printSolucioSeguent().");
        System.out.println("\t 108) public String printSolucioAnterior().");
        System.out.println("\t 109) public String printSolucio().");


        System.out.println("\n Entrada:");
        System.out.println("\t 201) public Entrada().");
        System.out.println("\t 202) public Entrada(double[][] dis, int[][] nec, int[][] rec, String[] pl, String[] re).");
        System.out.println("\t 203) public void modificarMatrius(double[][] dis, int[][] nec, int[][] rec, String[] pl, String[] re).");
        System.out.println("\t 204) public void modificarMatriusString(String dist, String nec, String rec, String p, String r).");
        System.out.println("\t 205) public double obtenirPosDis(int i, int j).");
        System.out.println("\t 206) public int obtenirPosNecPlaneta(int i, int j).");
        System.out.println("\t 207) public int obtenirPosRecPlaneta(int i, int j).");
        System.out.println("\t 208) public String obtenirPosRecu(int i).");
        System.out.println("\t 209) public String obtenirPosPlan(int i).");
        System.out.println("\t 210) public void modificarPosDis(int i, int j, double valor).");
        System.out.println("\t 211) public void modificarPosNecPlaneta(int i, int j, int valor)");
        System.out.println("\t 212) public void modificarPosRecPlaneta(int i, int j, int valor).");
        System.out.println("\t 213) public void modificarPosRecu(int i, String valor).");
        System.out.println("\t 214) public void modificarPosPlan(int i, String valor).");
        System.out.println("\t 215) public double[][] obtenirMatriuDisPla().");
        System.out.println("\t 216) public int[][] obtenirMatriuNecPla().");
        System.out.println("\t 217) public int[][] obtenirMatriuRecPla().");
        System.out.println("\t 218) public String[] obtenirVectorRecu().");
        System.out.println("\t 219) public String[] obtenirVectorPlan().");
        System.out.println("\t 220) public String obtenirMatriuDisString().");
        System.out.println("\t 221) public String obtenirMatriuNecString().");
        System.out.println("\t 222) public String obtenirMatriuRecString().");
        System.out.println("\t 223) public String obtenirRecursosString()");
        System.out.println("\t 224) public String obtenirPlanetesString()");
        System.out.println("\t 225) public String obtenirMatrius()");
        System.out.println("\t 00) Salida.");
    }
    
    public static void main(String[] args) {
        String nombreClase = "QAP";
        System.out.println("Driver " + nombreClase);
        Scanner scan = new Scanner(System.in);
        boolean out = false;
        long lo;
        long tem;
        String opcio;
        String nom;

        double[][] dis;
        int[][] nec;
        int[][] rec;
        String[] recu;
        String[] plan;

        int n;
        int nx;
        int ny;
        String entrada;
        
        int i;
        int j;
        double valor_dou;
        int valor_int;
        String valor_str;
        double[][] dou;
        int[][] in;
        String[] str;


        menu();

        
        while(!out){
            try{
                String op = scan.nextLine();
                switch (op) {
                    case "00":
                        out = true;
                        break;

                    case "01":
                        q = new QAP();
                        break;
                        
                    case "02":
                        opcio = scan.nextLine();
                        q.run_algorithm(en,s,opcio);
                        break;
                        
                    case "101":
                        s = new Solucio();
                        break;

                    case "102":
                        nom = scan.nextLine();
                        s.algoritme(nom);
                        break;

                    case "104":
                        tem = Long.parseLong(scan.nextLine());
                        s.afegirTemps(tem);
                        break;

                    case "105":
                        nom = scan.nextLine();
                        s.afegirEntrada(nom);
                        break;

                    case "106":
                        System.out.println(s.obtenirTemps());
                        break;

                    case "107":
                        System.out.println(s.printSolucioSeguent());
                        break;

                    case "108":
                        System.out.println(s.printSolucioAnterior());
                        break;

                    case "109":
                        System.out.println(s.printSolucio());
                        break;
                        
                    case "201":
                        en = new Entrada();
                        break;
                        
                    case "202":
                        // mDistancies
                        entrada = scan.nextLine();
                        n = Integer.parseInt(entrada);
                        dis = new double[n][n];
                        for (i = 0; i < n; i++) {
                            String linia = scan.nextLine();
                            String[] elements = linia.split(",");
                            for (j = 0; j < n; j++) {
                                dis[i][j] = Double.valueOf(elements[j]);
                            }
                        }

                        // mNecessitats
                        entrada = scan.nextLine();
                        nx = Integer.parseInt(entrada);
                        entrada = scan.nextLine();
                        ny = Integer.parseInt(entrada);
                        nec = new int[nx][ny];
                        for (i = 0; i < nx; i++) {
                            String linia = scan.nextLine();
                            String[] elements = linia.split(",");
                            for (j = 0; j < ny; j++) {
                                nec[i][j] = Integer.parseInt(elements[j]);
                            }
                        }

                        // mDisponibilitats
                        entrada = scan.nextLine();
                        nx = Integer.parseInt(entrada);
                        entrada = scan.nextLine();
                        ny = Integer.parseInt(entrada);
                        rec = new int[nx][ny];
                        for (i = 0; i < nx; i++) {
                            String linia = scan.nextLine();
                            String[] elements = linia.split(",");
                            for (j = 0; j < ny; j++) {
                                rec[i][j] = Integer.parseInt(elements[j]);
                            }
                        }

                        // mPlanetes
                        entrada = scan.nextLine();
                        n = Integer.parseInt(entrada);
                        plan = new String[n];
                        for (i = 0; i < n; i++) {
                            plan[i] = scan.nextLine();
                        }
                                    
                        // mRecursos
                        entrada = scan.nextLine();
                        n = Integer.parseInt(entrada);
                        recu = new String[n];
                        for (i = 0; i < n; i++) {
                            recu[i] = scan.nextLine();
                        }
                        
                        en = new Entrada(dis, nec, rec, plan, recu);
                        break;
                        
                    case "203":
                        // mDistancies
                        entrada = scan.nextLine();
                        n = Integer.parseInt(entrada);
                        dis = new double[n][n];
                        for (i = 0; i < n; i++) {
                            String linia = scan.nextLine();
                            String[] elements = linia.split(",");
                            for (j = 0; j < n; j++) {
                                dis[i][j] = Double.valueOf(elements[j]);
                            }
                        }

                        // mNecessitats
                        entrada = scan.nextLine();
                        nx = Integer.parseInt(entrada);
                        entrada = scan.nextLine();
                        ny = Integer.parseInt(entrada);
                        nec = new int[nx][ny];
                        for (i = 0; i < nx; i++) {
                            String linia = scan.nextLine();
                            String[] elements = linia.split(",");
                            for (j = 0; j < ny; j++) {
                                nec[i][j] = Integer.parseInt(elements[j]);
                            }
                        }

                        // mDisponibilitats
                        entrada = scan.nextLine();
                        nx = Integer.parseInt(entrada);
                        entrada = scan.nextLine();
                        ny = Integer.parseInt(entrada);
                        rec = new int[nx][ny];
                        for (i = 0; i < nx; i++) {
                            String linia = scan.nextLine();
                            String[] elements = linia.split(",");
                            for (j = 0; j < ny; j++) {
                                rec[i][j] = Integer.parseInt(elements[j]);
                            }
                        }

                        // mPlanetes
                        entrada = scan.nextLine();
                        n = Integer.parseInt(entrada);
                        plan = new String[n];
                        for (i = 0; i < n; i++) {
                            plan[i] = scan.nextLine();
                        }
                                    
                        // mRecursos
                        entrada = scan.nextLine();
                        n = Integer.parseInt(entrada);
                        recu = new String[n];
                        for (i = 0; i < n; i++) {
                            recu[i] = scan.nextLine();
                        }
                                    
                        en.modificarMatrius(dis, nec, rec, plan, recu);
                        break;

                    case "204":
                        String distan;
                        String nece;
                        String recur;
                        String p;
                        String r;
                        int aux1;
                        distan = scan.nextLine();
                        aux1 = Integer.parseInt(distan);
                        distan += "\n" + scan.nextLine();
                        for(i = 0; i < aux1; ++i) {
                            distan += "\n" + scan.nextLine();
                        }
                        
                        nece = scan.nextLine();
                        aux1 = Integer.parseInt(nece);
                        nece += "\n" + scan.nextLine();
                        for(i = 0; i < aux1; ++i) {
                            nece += "\n" + scan.nextLine();
                        }

                        recur = scan.nextLine();
                        aux1 = Integer.parseInt(recur);
                        recur += "\n" + scan.nextLine();
                        for(i = 0; i < aux1; ++i) {
                            recur += "\n" + scan.nextLine();
                        }

                        p = scan.nextLine();
                        p += "\n" + scan.nextLine();

                        r = scan.nextLine();
                        r += "\n" + scan.nextLine();
                        en.modificarMatriusString(distan, nece, recur, p, r);
                        break;

                    case "205":
                        i = Integer.parseInt(scan.nextLine());
                        j = Integer.parseInt(scan.nextLine());
                        System.out.println(en.obtenirPosDis(i,j));
                        break;

                    case "206":
                        i = Integer.parseInt(scan.nextLine());
                        j = Integer.parseInt(scan.nextLine());
                        System.out.println(en.obtenirPosNecPlaneta(i,j));
                        break;

                    case "207":
                        i = Integer.parseInt(scan.nextLine());
                        j = Integer.parseInt(scan.nextLine());
                        System.out.println(en.obtenirPosRecPlaneta(i,j));
                        break;

                    case "208":
                        i = Integer.parseInt(scan.nextLine());
                        System.out.println(en.obtenirPosRecu(i));
                        break;

                    case "209":
                        i = Integer.parseInt(scan.nextLine());
                        System.out.println(en.obtenirPosPlan(i));
                        break;

                    case "210":
                        i = Integer.parseInt(scan.nextLine());
                        j = Integer.parseInt(scan.nextLine());
                        valor_dou = Double.parseDouble(scan.nextLine());
                        en.modificarPosDis(i,j,valor_dou);
                        break;

                    case "211":
                        i = Integer.parseInt(scan.nextLine());
                        j = Integer.parseInt(scan.nextLine());
                        valor_int = Integer.parseInt(scan.nextLine());
                        en.modificarPosNecPlaneta(i,j,valor_int);
                        break;

                    case "212":
                        i = Integer.parseInt(scan.nextLine());
                        j = Integer.parseInt(scan.nextLine());
                        valor_int = Integer.parseInt(scan.nextLine());
                        en.modificarPosRecPlaneta(i,j,valor_int);
                        break;

                    case "213":
                        i = Integer.parseInt(scan.nextLine());
                        valor_str = scan.nextLine();
                        en.modificarPosRecu(i, valor_str);
                        break;

                    case "214":
                        i = Integer.parseInt(scan.nextLine());
                        valor_str = scan.nextLine();
                        en.modificarPosPlan(i,valor_str);
                        break;

                    case "215":
                        dou = en.obtenirMatriuDisPla();
                        for (i = 0; i < dou.length; ++i) {
                            for (j = 0; j < dou[0].length; ++j) {
                                System.out.print(dou[i][j]+ "\t");
                            }
                            System.out.println();
                        }
                        System.out.println();
                        break;

                    case "216":
                        in = en.obtenirMatriuNecPla();
                        for (i = 0; i < in.length; ++i) {
                            for (j = 0; j < in[0].length; ++j) {
                                System.out.print(in[i][j] + "\t");
                            }
                            System.out.println();
                        }
                        System.out.println();
                        break;

                    case "217":
                        in = en.obtenirMatriuRecPla();
                        for (i = 0; i < in.length; ++i) {
                            for (j = 0; j < in[0].length; ++j) {
                                System.out.print(in[i][j] + "\t");
                            }
                            System.out.println();
                        }
                        System.out.println();
                        break;

                    case "218":
                        str = en.obtenirVectorRecu();
                        for (i = 0; i < str.length; ++i) {
                            System.out.print(str[i] + "\t");
                        }
                        System.out.println();
                        break;

                    case "219":
                        str = en.obtenirVectorPlan();
                        for (i = 0; i < str.length; ++i) {
                            System.out.print(str[i] + "\t");
                        }
                        System.out.println();
                        break;

                    case "220":
                        System.out.println(en.obtenirMatriuDisString());
                        break;

                    case "221":
                        System.out.println(en.obtenirMatriuNecString());
                        break;

                    case "222":
                        System.out.println(en.obtenirMatriuRecString());
                        break;

                    case "223":
                        System.out.println(en.obtenirRecursosString());
                        break;

                    case "224":
                        System.out.println(en.obtenirPlanetesString());
                        break;
            
                    case "225":
                        System.out.println(en.obtenirMatrius());
                        break;

                    default:
                        System.out.println("Opció no valida.");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            finally{
                //S'executa SEMPRE.
            }
        }
        scan.close();
    }
    
}