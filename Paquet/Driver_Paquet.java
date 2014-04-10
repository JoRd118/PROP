import java.util.*;
import java.io.IOException;

public class Driver_Paquet {

	private static Paquet p;

	public static void menu() {
		System.out.println("Escoge una opción:");
        System.out.println("\t 00) Salida.");
        System.out.println("\t 01) public Paquet().");
        System.out.println("\t 02) public int obtenirId().");
        System.out.println("\t 03) public int obtenirOcupacio().");
        System.out.println("\t 04) public int modificarOcupacio(int ocupacio).");
	}

	public static void main(String[] args) {
		System.out.println("Driver Paquet");
		Scanner scan = new Scanner(System.in);
		boolean out = false;

		menu();

		while(!out){
            try{
                String op = scan.nextLine();
                switch (op) {
                        
                    case "01":
                        p = new Paquet();
                        break;
                        
                    case "02":
                        System.out.println(p.obtenirId());
                        break;
                        
                    case "03":
                        System.out.println(p.obtenirOcupacio());
                        break;
                        
                    case "04":
                        String num = scan.nextLine();
                        p.modificarOcupacio(Integer.parseInt(num));
                        break;
                        
                    case "00":
                        out = true;
                        break;
                        
                    default:
                        out = true;
                        break;
                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scan.close();
	}
}