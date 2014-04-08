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
		System.out.println("Tria una opcio:\n");
		System.out.println("0 => Sortida\n");
		System.out.println("1 => Univers()\n");
		System.out.println("2 => Univers(nom)\n");
		System.out.println("3 => modificarNomUnivers(nom)\n");
		System.out.println("4 => obtenirIdUnivers\n");
		System.out.println("5 => obtenirNomUnivers\n");
	}

	public static void main(String[] args){
		String nomClase = "Univers";
		System.out.println("Driver "+nomClase);
		Scanner scan = new Scanner(System.in);
		boolean out = false;
		
		menu();

		while(!out){
			String num = scan.nextLine();
			switch(num){
				case "0":
					out = true;
					break;
				case "1":
					u = new Univers();
					break;
				case "2":
					String nom = scan.nextLine();
					u = new Univers(nom);
					break;
				case "3":
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
					System.out.println("Opcio no valida\n");
					break;
				
			}
		}
		scan.close();
	}
}

