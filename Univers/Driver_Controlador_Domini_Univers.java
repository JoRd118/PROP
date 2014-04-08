package Univers;
import java.util.*;
import java.io.IOException;

public class Driver_Controlador_Domini_Univers{

	private static Controlador_Domini_Univers u;

	public static void menu(){
		System.out.println("Tria una opcio:\n");
		System.out.println("0 => Sortida\n");
		System.out.println("1 => public Controlador_Domini_Univers\n");
		System.out.println("2 => public void altaUnivers(String nom)\n");
		System.out.println("3 => public void baixaUnivers(String nom)\n");
		System.out.println("4 => void modificacioNomUnivers(String nomUnivers, String newnomUnivers)\n");
		System.out.println("5 => Univers obtenirUnivers(String nom)\n");
		System.out.println("6 => public int obtenirIdUnivers(String nom)\n");
		System.out.println("7 => public String obtenirNomUnivers(int id)\n");
		System.out.println("8 => public String llistatUnivers()\n");
	
	}

	public static void main(String[] args){
		String nomClase = "Controlador Univers";
		System.out.println("Driver "+nomClase);
		Scanner scan = new Scanner(System.in);
		boolean out = false;
		String nom;

		menu();

		while(!out){
			try{
				String op = scan.nextLine();
				switch(op){
					case "0":
						out = true;
						break;
					case "1":
						u = new Controlador_Domini_Univers();
						break;
					case "2":
						System.out.println("Escriu el nom de l'univers\n");
						nom = scan.nextLine();
						u.altaUnivers(nom);
						break;
					case "3":
					    System.out.println("Escriu el nom de l'univers\n");
						nom = scan.nextLine();
						u.baixaUnivers(nom);
					case "4":
						System.out.println("Escriu el nom del univers vell\n");
						nom = scan.nextLine();
						System.out.println("Escriu el nom del nou univers\n");
						String new_nom = scan.nextLine();
						u.modificacioNomUnivers(nom, new_nom);
						break;
					case "5":
						System.out.println("Escriu el nom de l'univers\n");
						nom = scan.nextLine();
						System.out.println(u.obtenirUnivers(nom));
						break;
					case "6":
						System.out.println("Escriu el nom de l'univers\n");
						nom = scan.nextLine();
						System.out.println(u.obtenirIdUnivers(nom));
						break;
					case "7":
						System.out.println("Escriu l'id del univers\n");
						String num = scan.nextLine();
						int id = Integer.parseInt(num); //Pasa a Integer
						System.out.println(u.obtenirNomUnivers(id));
						break;
					case "8":
						System.out.println(u.llistatUnivers());
						break;
					default:
						System.out.println("Opcio no valida\n");
						break;

				}
			}
			catch(Exception e){System.out.println(e.getMessage());}
		}
		scan.close();
	}
}