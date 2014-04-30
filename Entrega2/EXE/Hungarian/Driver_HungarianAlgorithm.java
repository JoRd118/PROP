import java.util.*;
import java.io.IOException;

public class Driver_HungarianAlgorithm {
	private static HungarianAlgorithm ha;

	public static void menu() {
        System.out.println("Escoge una opción:");
        System.out.println("\t 00) Salida.");
        System.out.println("\t 01) public int[][] computeAssignments(double[][] matrix).");
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
                        double matriuorig[][] = new double[nfiles][ncolumnes];
                            for (int x=0; x < matriu.length; x++) {
                                for (int y=0; y < matriu[x].length; y++) {
                                    entd = scan.nextLine();
                                    matriu[x][y] = Double.parseDouble(entd);
                                    matriuorig[x][y] = Double.parseDouble(entd);
                                }
                            }

                        int resultat[][] = ha.computeAssignments(matriu);
                        for (int z=0; z < resultat.length; z++) {
                            for (int w=0; w < resultat[z].length; w++) {
                                System.out.print(resultat[z][w]+ " ");
                            }
                            System.out.println();
                        }
                        double suma = 0;
                        for (int i = 0; i < resultat.length; i++) {
                            suma = suma + matriuorig[resultat[i][0]][resultat[i][1]];
                        }
                        System.out.println(suma);
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