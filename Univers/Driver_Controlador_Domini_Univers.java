import java.util.*;
import java.io.IOException;

public class Driver_Controlador_Domini_Univers{

	private static Controlador_Domini_Univers u;

	public static void menu(){
		System.out.println("Tria una opcio:");
		System.out.println("0 => Sortida");
		System.out.println("1 => public Controlador_Domini_Univers");
		System.out.println("2 => public void altaUnivers(String nom)");
		System.out.println("3 => public void baixaUnivers(String nom)");
		System.out.println("4 => public void modificacioNomUnivers(String nomUnivers, String newnomUnivers)");
		System.out.println("5 => public Univers obtenirUnivers(String nom)");
		System.out.println("6 => public int obtenirIdUnivers(String nom)");
		System.out.println("7 => public String obtenirNomUnivers(int id)");
		System.out.println("8 => public String llistatUnivers()");
		System.out.println("9 => public void afegirPlanetaUnivers(int idUnivers, int id)");
		System.out.println("10 => public int numPlanetesUnivers(int id");
	
	}

	public static void main(String[] args){
		String nomClase = "Controlador Univers";
		System.out.println("Driver "+nomClase);
		Scanner scan = new Scanner(System.in);
		boolean out = false;
		String nom;
		String num;
		int id;

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
						System.out.println("Escriu el nom de l'univers");
						nom = scan.nextLine();
						u.altaUnivers(nom);
						break;
					case "3":
					    System.out.println("Escriu el nom de l'univers");
						nom = scan.nextLine();
						u.baixaUnivers(nom);
						break;
					case "4":
						System.out.println("Escriu el nom del univers vell");
						nom = scan.nextLine();
						System.out.println("Escriu el nom del nou univers");
						String new_nom = scan.nextLine();
						u.modificacioNomUnivers(nom, new_nom);
						break;
					case "5":
						System.out.println("Escriu el nom de l'univers");
						nom = scan.nextLine();
						System.out.println(u.obtenirUnivers(nom));
						break;
					case "6":
						System.out.println("Escriu el nom de l'univers");
						nom = scan.nextLine();
						System.out.println(u.obtenirIdUnivers(nom));
						break;
					case "7":
						System.out.println("Escriu l'id del univers");
						num = scan.nextLine();
						id = Integer.parseInt(num); //Pasa a Integer
						System.out.println(u.obtenirNomUnivers(id));
						break;
					case "8":
						System.out.println(u.llistatUnivers());
						break;
					case "9":
						System.out.println("Escriu l'id del univers");
						num = scan.nextLine();
						int id_univers = Integer.parseInt(num); //Pasa a Integer
						System.out.println("Escriu l'id del univers");
						num = scan.nextLine();
						int id_planeta = Integer.parseInt(num); //Pasa a Integer
						//NEED THIS!//afegirPlanetaUnivers(id_univers,id_planeta);
						break;	
					case "10":
						System.out.println("Escriu l'id del univers");
						num = scan.nextLine();
						id = Integer.parseInt(num); //Pasa a Integer
						System.out.println(u.numPlanetesUnivers(id));
						break;
					default:
						System.out.println("Opcio no valida");
						break;

				}
			}
			catch(Exception e){System.out.println(e.getMessage());}
		}
		scan.close();
	}
}