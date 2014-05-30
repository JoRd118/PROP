import java.util.*;
import java.io.IOException;
/**
 *
 *Driver Entrada
 *
 *@author jordi Vilella
 */
public class Driver_Entrada{
    
    private static Entrada en;

    public static void menu() {
        System.out.println("Escollir opcio:");
        System.out.println("\t 01) public Entrada().");
        System.out.println("\t 02) public Entrada(double[][] dis, int[][] nec, int[][] rec, String[] pl, String[] re).");
        System.out.println("\t 03) public void modificarMatrius(double[][] dis, int[][] nec, int[][] rec, String[] pl, String[] re).");
        System.out.println("\t 04) public void modificarMatriusString(String dist, String nec, String rec, String p, String r).");
        System.out.println("\t 05) public double obtenirPosDis(int i, int j).");
        System.out.println("\t 06) public int obtenirPosNecPlaneta(int i, int j).");
        System.out.println("\t 07) public int obtenirPosRecPlaneta(int i, int j).");
        System.out.println("\t 08) public String obtenirPosRecu(int i).");
        System.out.println("\t 09) public String obtenirPosPlan(int i).");
        System.out.println("\t 10) public void modificarPosDis(int i, int j, double valor).");
        System.out.println("\t 11) public void modificarPosNecPlaneta(int i, int j, int valor)");
        System.out.println("\t 12) public void modificarPosRecPlaneta(int i, int j, int valor).");
        System.out.println("\t 13) public void modificarPosRecu(int i, String valor).");
        System.out.println("\t 14) public void modificarPosPlan(int i, String valor).");
        System.out.println("\t 15) public double[][] obtenirMatriuDisPla().");
        System.out.println("\t 16) public int[][] obtenirMatriuNecPla().");
        System.out.println("\t 17) public int[][] obtenirMatriuRecPla().");
        System.out.println("\t 18) public String[] obtenirVectorRecu().");
        System.out.println("\t 19) public String[] obtenirVectorPlan().");
        System.out.println("\t 20) public String obtenirMatriuDisString().");
        System.out.println("\t 21) public String obtenirMatriuNecString().");
        System.out.println("\t 22) public String obtenirMatriuRecString().");
        System.out.println("\t 23) public String obtenirRecursosString()");
        System.out.println("\t 24) public String obtenirPlanetesString()");
        System.out.println("\t 25) public String obtenirMatrius()");
        System.out.println("\t 00) Salida.");
    }
    
    public static void main(String[] args) {
        String nombreClase = "Entrada";
        System.out.println("Driver " + nombreClase);
        Scanner scan = new Scanner(System.in);


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
        boolean out = false;
        //Entrada en;


        menu();

        
        while(!out){
            try{
                String op = scan.nextLine();
                switch (op) {
                    case "00":
                        out = true;
                        break;

                    case "01":
                        en = new Entrada();
                        break;
                        
                    case "02":
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
                        
                    case "03":
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

                    case "04":
                        String distan;
                        String nece;
                        String recur;
                        String p;
                        String r;
                        int aux1;
                        distan = scan.nextLine();
                        aux1 = Integer.parseInt(distan);
                        distan += "\n";
                        for(i = 0; i < aux1 + 1; ++i) {
                            distan += scan.nextLine() + "\n";
                        }
                        
                        nece = scan.nextLine();
                        aux1 = Integer.parseInt(nece);
                        nece += "\n";
                        for(i = 0; i < aux1 + 1; ++i) {
                            nece += scan.nextLine() + "\n";
                        }

                        recur = scan.nextLine();
                        aux1 = Integer.parseInt(recur);
                        recur += "\n";
                        for(i = 0; i < aux1 + 1; ++i) {
                            recur += scan.nextLine() + "\n";
                        }

                        p = scan.nextLine();
                        p += "\n" + scan.nextLine();

                        r = scan.nextLine();
                        r += "\n" + scan.nextLine();
                        en.modificarMatriusString(distan, nece, recur, p, r);
                        break;

                    case "05":
                        i = Integer.parseInt(scan.nextLine());
                        j = Integer.parseInt(scan.nextLine());
                        System.out.println(en.obtenirPosDis(i,j));
                        break;

                    case "06":
                        i = Integer.parseInt(scan.nextLine());
                        j = Integer.parseInt(scan.nextLine());
                        System.out.println(en.obtenirPosNecPlaneta(i,j));
                        break;

                    case "07":
                        i = Integer.parseInt(scan.nextLine());
                        j = Integer.parseInt(scan.nextLine());
                        System.out.println(en.obtenirPosRecPlaneta(i,j));
                        break;

                    case "08":
                        i = Integer.parseInt(scan.nextLine());
                        System.out.println(en.obtenirPosRecu(i));
                        break;

                    case "09":
                        i = Integer.parseInt(scan.nextLine());
                        System.out.println(en.obtenirPosPlan(i));
                        break;

                    case "10":
                        i = Integer.parseInt(scan.nextLine());
                        j = Integer.parseInt(scan.nextLine());
                        valor_dou = Double.parseDouble(scan.nextLine());
                        en.modificarPosDis(i,j,valor_dou);
                        break;

                    case "11":
                        i = Integer.parseInt(scan.nextLine());
                        j = Integer.parseInt(scan.nextLine());
                        valor_int = Integer.parseInt(scan.nextLine());
                        en.modificarPosNecPlaneta(i,j,valor_int);
                        break;

                    case "12":
                        i = Integer.parseInt(scan.nextLine());
                        j = Integer.parseInt(scan.nextLine());
                        valor_int = Integer.parseInt(scan.nextLine());
                        en.modificarPosRecPlaneta(i,j,valor_int);
                        break;

                    case "13":
                        i = Integer.parseInt(scan.nextLine());
                        valor_str = scan.nextLine();
                        en.modificarPosRecu(i, valor_str);
                        break;

                    case "14":
                        i = Integer.parseInt(scan.nextLine());
                        valor_str = scan.nextLine();
                        en.modificarPosPlan(i,valor_str);
                        break;

                    case "15":
                        dou = en.obtenirMatriuDisPla();
                        for (i = 0; i < dou.length; ++i) {
                            for (j = 0; j < dou[0].length; ++j) {
                                System.out.print(dou[i][j]+ "\t");
                            }
                            System.out.println();
                        }
                        System.out.println();
                        break;

                    case "16":
                        in = en.obtenirMatriuNecPla();
                        for (i = 0; i < in.length; ++i) {
                            for (j = 0; j < in[0].length; ++j) {
                                System.out.print(in[i][j] + "\t");
                            }
                            System.out.println();
                        }
                        System.out.println();
                        break;

                    case "17":
                        in = en.obtenirMatriuRecPla();
                        for (i = 0; i < in.length; ++i) {
                            for (j = 0; j < in[0].length; ++j) {
                                System.out.print(in[i][j] + "\t");
                            }
                            System.out.println();
                        }
                        System.out.println();
                        break;

                    case "18":
                        str = en.obtenirVectorRecu();
                        for (i = 0; i < str.length; ++i) {
                            System.out.print(str[i] + "\t");
                        }
                        System.out.println();
                        break;

                    case "19":
                        str = en.obtenirVectorPlan();
                        for (i = 0; i < str.length; ++i) {
                            System.out.print(str[i] + "\t");
                        }
                        System.out.println();
                        break;

                    case "20":
                        System.out.println(en.obtenirMatriuDisString());
                        break;

                    case "21":
                        System.out.println(en.obtenirMatriuNecString());
                        break;

                    case "22":
                        System.out.println(en.obtenirMatriuRecString());
                        break;

                    case "23":
                        System.out.println(en.obtenirRecursosString());
                        break;

                    case "24":
                        System.out.println(en.obtenirPlanetesString());
                        break;
            
                    case "25":
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