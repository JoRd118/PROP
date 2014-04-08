package Univers;
import java.util.*;


/*import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
*/
public class Driver_Univers{

	private static Univers u;

	public static void menu(){
		System.out.println("Tria una opcio:");
		System.out.println("0 => Sortida");
		System.out.println("1 => Univers()");
		System.out.println("2 => Univers(nom)");
		System.out.println("3 => modificarNomUnivers(nom)");
		System.out.println("4 => obtenirIdUnivers");
		System.out.println("5 => obtenirNomUnivers");
	}

	public static void main(String[] args){
		String nomClase = "Univers";
		System.out.println("Driver "+nomClase);
		Scanner scan = new Scanner(System.in);
		boolean out = false;
		
		menu();

		while(!out){
			try{
				String num = scan.nextLine();
				switch(num){
					case "0":
						out = true;
						break;
					case "1":
						u = new Univers();
						break;
					case "2":
						System.out.println("Escriu el nom de l'univers");
						String nom = scan.nextLine();
						u = new Univers(nom);
						break;
					case "3":
						System.out.println("Escriu el nom nou de l'univers");
						String nou_nom = scan.nextLine();
						u.modificarNomUnivers(nou_nom);
						break;
					case "4":
						System.out.println(u.obtenirIdUnivers());
						break;
					case "5":
						System.out.println(u.obtenirNomUnivers());
						break;
					default:
						System.out.println("Opcio no valida");
						break;				
				}
			}
			catch(Exception e) {System.out.println(e.getMessage());}
		}
		scan.close();
	}
}
