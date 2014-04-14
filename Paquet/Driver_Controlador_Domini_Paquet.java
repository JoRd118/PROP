import java.util.*;
import java.io.IOException;

public class Driver_Controlador_Domini_Paquet {

	private static Controlador_Domini_Paquet p;
    private static Controlador_Domini_Recurs r;

	public static void menu() {
		System.out.println("Escoge una opción:");
        System.out.println("\t 00) Salida.");
        //System.out.println("\t 01) public Controlador_Domini_Paquet().");
        System.out.println("\t 02) public Controlador_Domini_Paquet(Controlador_Domini_Recurs n).");
        System.out.println("\t 03) public altaPaquet().");
        System.out.println("\t 04) public baixaPaquet(int id).");
        System.out.println("\t 05) public assignarRecurs(int id, String nom).");
        System.out.println("\t 06) public esborrarRecurs(int id, String nom).");
        System.out.println("\t 07) public Paquet obtenirPaquet(int id).");
        System.out.println("\t 08) public Paquet obtenirPaquetAssignar(int id).");
        System.out.println("\t 09) public String llistatPaquetsAssignats().");
        System.out.println("\t 10) public String llistatPaquetsNoAssignats().");
        System.out.println("\t 11) public String llistatRecursosPaquet(int id).\n");

        System.out.println("\t 21) public Controlador_Domini_Recurs().");
        System.out.println("\t 22) public void altaRecurs(String nom).");
        System.out.println("\t 23) public void baixaRecurs(String nom).");
        System.out.println("\t 24) public void modificarNom(String nom, String new_nom).");
        System.out.println("\t 25) public Recurs obtenirRecurs(String nom).");
        System.out.println("\t 26) public int obtenirId(String nom).");
        System.out.println("\t 28) public String llistatRecurs().");
	}

	public static void main(String[] args) {
		System.out.println("Driver Controlador_Domini_Paquet");
		Scanner scan = new Scanner(System.in);
		boolean out = false;

		menu();

		while(!out){
            try{
                System.out.println("Elegiu una opcio del menu:");
                String op = scan.nextLine();
                String num;
                String nom;
                Paquet pa;
                switch (op) {
                        
                    case "02":
                        p = new Controlador_Domini_Paquet(r);
                        break;
                        
                    case "03":
                        p.altaPaquet();
                        break;
                     
                    case "04":
                        System.out.println("Introduir id");
                        num = scan.nextLine();
                        p.baixaPaquet(Integer.parseInt(num));
                        break;

                    case "05":
                        System.out.println("Introduir id");
                        num = scan.nextLine();
                        System.out.println("Introduir nom del recurs");
                        nom = scan.nextLine();
                        p.assignarRecurs(Integer.parseInt(num),nom);
                        break;

                    case "06":
                        System.out.println("Introduir id");
                        num = scan.nextLine();
                        System.out.println("Introduir nom del recurs");
                        nom = scan.nextLine();
                        p.esborrarRecurs(Integer.parseInt(num),nom);
                        break;
                        
                    case "07":
                        System.out.println("Introduir id");
                        num = scan.nextLine();
                        pa = p.obtenirPaquet(Integer.parseInt(num));
                        System.out.println(Integer.toString(pa.obtenirId()));
                        break;

                    case "08":
                        System.out.println("Introduir id");
                        num = scan.nextLine();
                        pa = p.obtenirPaquetAssignar(Integer.parseInt(num));
                        System.out.println(Integer.toString(pa.obtenirId()));
                        break;

                    case "09":
                        System.out.println(p.llistatPaquetsAssignats());
                        break;

                    case "10":
                        System.out.println(p.llistatPaquetsNoAssignats());
                        break;

                    case "11":
                        System.out.println("Introduir id");
                        num = scan.nextLine();
                        System.out.println(p.llistatRecursosPaquet(Integer.parseInt(num)));
                        break;

                    case "21":
                        r = new Controlador_Domini_Recurs();
                        break;

                    case "22":
                        nom = scan.nextLine();
                        r.altaRecurs(nom);
                        break;
                        
                    case "23":
                        nom = scan.nextLine();
                        r.baixaRecurs(nom);
                        break;
                        
                    case "24":
                        nom = scan.nextLine();
                        String new_nom = scan.nextLine();
                        r.modificarNom(nom,new_nom);
                        break;
                        
                    case "25":
                        nom = scan.nextLine();
                        r.obtenirRecurs(nom);
                        break;
                        
                    case "26":
                        nom = scan.nextLine();
                        System.out.println(r.obtenirId(nom));
                        break;
                        
                    case "28":
                        System.out.println(r.llistatRecurs());
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