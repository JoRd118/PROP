import java.util.*;
import java.io.IOException;

public class Driver_Paquet {

	private static Paquet p;

	public static void menu() {
        System.out.println("Escollir una opcio del menu:");
        System.out.println("\t 00) Sortida.");
        System.out.println("\t 01) public void Paquet().");
        System.out.println("\t 02) public void Paquet(int id)");
        System.out.println("\t 03) public int obtenirId().");
        System.out.println("\t 04) public int obtenirOcupacio().");
        System.out.println("\t 05) public int modificarOcupacio(int ocupacio).");
	}

	public static void main(String[] args) {
		System.out.println("Driver Paquet");
		Scanner scan = new Scanner(System.in);
		boolean out = false;

		menu();

		while(!out){
            try{
                String op = scan.nextLine();
                String num;
                switch (op) {
                        
                    case "01":
                        p = new Paquet();
                        break;
                        
                    case "02":
                        num = scan.nextLine();
                        p = new Paquet(Integer.parseInt(num));
                        break;
                        
                    case "03":
                        System.out.println("El id es: " + p.obtenirId());
                        break;

                    case "04":
                        System.out.println("L'ocupacio es: " + p.obtenirOcupacio());
                        break;
                        
                    case "05":
                        num = scan.nextLine();
                        p.modificarOcupacio(Integer.parseInt(num));
                        break;
                        
                    case "00":
                        out = true;
                        break;
                        
                    default:
                        System.out.println("Opcio no valida");
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