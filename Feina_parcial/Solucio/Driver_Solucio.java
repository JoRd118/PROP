import java.util.*;
import java.io.IOException;
/**
 *
 *Driver Solucio
 *
 *@author jordi Vilella
 */

public class Driver_Solucio{
    
    private static Solucio s;

    public static void menu() {
        System.out.println("Escollir opcio:");
        System.out.println("\t 01) public Solucio().");
        System.out.println("\t 02) public void afegirSolucioQAP(SolucioQAP s).");
        System.out.println("\t 03) public void afegirTemps(double tem).");
        System.out.println("\t 04) public double obtenirTemps().");
        System.out.println("\t 00) Salida.");
    }
    
    public static void main(String[] args) {
        String nombreClase = "Solucio";
        System.out.println("Driver " + nombreClase);
        Scanner scan = new Scanner(System.in);
        boolean out = false;
        int in;

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
                        SolucioQAP aux = new SolucioQAP();
                        s.afegirSolucioQAP(aux);
                        break;
                        
                    case "03":
                        in = Integer.parseInt(scan.nextLine());
                        s.afegirTemps(in);
                        break;

                    case "04":
                        System.out.println(s.obtenirTemps());
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