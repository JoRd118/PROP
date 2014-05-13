import java.util.*;

public class Driver_Univers{
 
	private static Univers u;

	public static void menu(){
		System.out.println("Escollir opcio:");
		System.out.println("\t 00) Sortida");
		System.out.println("\t 01) public Univers()");
		System.out.println("\t 02) public Univers(String nom)");
		System.out.println("\t 03) public void modificarNomUnivers(String nom)");
		System.out.println("\t 04) public int obtenirIdUnivers");
		System.out.println("\t 05) public String obtenirNomUnivers");
	}

	public static void main(String[] args){
		String nomClase = "Univers";
		System.out.println("Driver "+nomClase);
		Scanner scan = new Scanner(System.in);
		boolean out = false;
		boolean creat = false;
		
		menu();

		while(!out){
			try{
				String num = scan.nextLine();
				switch(num){
					case "00":
						out = true;
						break;
					case "01":
						u = new Univers();
						if(!creat) creat = true;
						break;
					case "02":
						//System.out.println("Escriu el nom de l'univers");
						String nom = scan.nextLine();
						u = new Univers(nom);
						if(!creat) creat = true;
						break;
					case "03":
						if(creat){ 
						//	System.out.println("Escriu el nom nou de l'univers");
							String nou_nom = scan.nextLine();
							u.modificarNomUnivers(nou_nom);
						}
						else System.out.println("Univers no creat");
						break;
					case "04":
						if(creat) System.out.println(u.obtenirIdUnivers());
						else System.out.println("Univers no creat");
						break;
					case "05":
						if(creat) System.out.println(u.obtenirNomUnivers());
						else System.out.println("Univers no creat");
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

