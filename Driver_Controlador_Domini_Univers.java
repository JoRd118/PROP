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


	}
	




}