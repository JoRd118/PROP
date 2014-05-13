import java.util.*;
import java.io.IOException;

public class Driver_Gilmore {
	private static Gilmore g;

	public static void menu() {
        System.out.println("Escoge una opción:");
        System.out.println("\t 00) Salida.");
        System.out.println("\t 01) public static double Bound(double[][] A, double[][] B, double[][] C).");
    }
public static void main(String[] args) {
		System.out.println("Driver Gilmore");
        Scanner scan = new Scanner(System.in);
        boolean out = false;
        menu();
        String entd;
        String enti;
while(!out){
            try{
                String op = scan.nextLine();
                switch (op) {
                    case "01":
                    g = new Gilmore();
                    int n;
                    //System.out.println("Introdueix el tamany de la matriu A:");
                    enti = scan.nextLine();
                    n = Integer.parseInt(enti);
                    double matriuA[][] = new double[n][n];
                    for (int i = 0; i < n; i++) {
                        String linia = scan.nextLine();
                        String[] elements = linia.split(",");
                        for (int j = 0; j < n; j++) {
                            matriuA[i][j] = Double.valueOf(elements[j]);
                        }
                    }
                    //System.out.println("Introdueix el tamany de la matriu B:");
                    enti = scan.nextLine();
                    n = Integer.parseInt(enti);
                    double matriuB[][] = new double[n][n];
                    for (int i = 0; i < n; i++) {
                        String linia = scan.nextLine();
                        String[] elements = linia.split(",");
                        for (int j = 0; j < n; j++) {
                            matriuB[i][j] = Double.valueOf(elements[j]);
                        }
                    }
                    //System.out.println("Introdueix el tamany de la matriu C:");
                    enti = scan.nextLine();
                    n = Integer.parseInt(enti);
                    double matriuC[][] = new double[n][n];
                    for (int i = 0; i < n; i++) {
                        String linia = scan.nextLine();
                        String[] elements = linia.split(",");
                        for (int j = 0; j < n; j++) {
                            matriuC[i][j] = Double.valueOf(elements[j]);
                        }
                    }
    				double solucio = g.Bound(matriuA, matriuB, matriuC);
    				System.out.println(solucio);
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