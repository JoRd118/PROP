import java.util.*;
import java.io.IOException;

public class Driver_HungarianAlgorithm {
	private static HungarianAlgorithm ha;

	public static void menu() {
        System.out.println("Escoge una opción:");
        System.out.println("\t 00) Salida.");
        System.out.println("\t 01) public double computeAssignments(double[][] mat).");
    }
public static void main(String[] args) {
		System.out.println("Driver Hungarian Algorithm");
        Scanner scan = new Scanner(System.in);
        boolean out = false;
        menu();
        String entd;
        String enti;
        int nfiles, ncolumnes;
while(!out){
            try{
                String op = scan.nextLine();
                switch (op) {
                    case "01":
                        ha = new HungarianAlgorithm();

                        enti = scan.nextLine();
                        nfiles = Integer.parseInt(enti);
                        enti = scan.nextLine();
                        ncolumnes = Integer.parseInt(enti);
                        double matriu[][] = new double[nfiles][ncolumnes];
                        for (int i = 0; i < nfiles; i++) {
                            String linia = scan.nextLine();
                            String[] elements = linia.split(",");
                            for (int j = 0; j < ncolumnes; j++) {
                                matriu[i][j] = Double.valueOf(elements[j]);
                            }
                        }
                        double resultat = ha.computeAssignments(matriu);
                        System.out.print(resultat);
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