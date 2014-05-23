import java.util.*;

public class Driver_Univers{
 
	private static Univers u;
	private static Planeta p;
	private static TST<Planeta> planets = new TST<Planeta>();

	public static void menu(){
		System.out.println("Escollir opcio:");
		System.out.println("\t 00) Sortida");
		System.out.println("\t 01) public Univers(int id)");
		System.out.println("\t 02) public Univers(String nom, int id)");
		System.out.println("\t 03) public void modificarNomUnivers(String nom)");
		System.out.println("\t 04) public int obtenirIdUnivers");
		System.out.println("\t 05) public String obtenirNomUnivers");
		System.out.println("\t 06) public int numplanetes()");
		System.out.println("\t 07) public Planeta obtenirPlaneta(String nom)");
        System.out.println("\t 08) public Iterable<String> obtenirPlanetes()");
        System.out.println("\t 09) public Planeta(String nom, int i, Coordenades c, boolean classe)");
        System.out.println("\t 10) public void afegirPlaneta(String nom, Planeta planeta)");
        System.out.println("\t 11) public void desafegirPlaneta(String nomPlaneta)");
	}

	public static void main(String[] args){
		String nomClase = "Univers";
		System.out.println("Driver "+nomClase);
		Scanner scan = new Scanner(System.in);
		boolean out = false;
		boolean creat = false;
		int id;
		String aux;
		menu();

		while(!out){
			try{
				String num = scan.nextLine();
				switch(num){
					case "00":
						out = true;
						break;
					case "01":
					    aux = scan.nextLine();
					    id = Integer.parseInt(aux);
						u = new Univers(id);
						if(!creat) creat = true;
						break;
					case "02":
						//System.out.println("Escriu el nom de l'univers");
						String nom = scan.nextLine();
						aux = scan.nextLine();
					    id = Integer.parseInt(aux);
						u = new Univers(nom,id);
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
					case "06":
						System.out.println(u.numplanetes());
						break;
					case "07":
						aux = scan.nextLine();
						Planeta paux = u.obtenirPlaneta(aux);
						System.out.println("Nom planeta: "+paux.obtenirNom());
						System.out.println("Coordenades X planeta: "+paux.obtenirCoordenades().obtenirCoordenadesX());
						System.out.println("Coordenades Y planeta: "+paux.obtenirCoordenades().obtenirCoordenadesY());
						System.out.println("Classe M: "+paux.obtenirClasse());
						break;
					case "08":
						Iterable<String> planetes = u.obtenirPlanetes();
						for(String a : planetes){
							System.out.println(a);
						}
						break;
					case "09":					
						Planeta plan;
					    String name,coordX,coordY,classM;
					    System.out.println("Escriu el nom del planeta");
                        name = scan.nextLine();
                        System.out.println("Escriu el identifiacor planeta");
                        String i3 = scan.nextLine();
                        System.out.println("Escriu les coords del plaenta");
                        coordX = scan.nextLine();
                        coordY = scan.nextLine();
                        System.out.println("Planeta classe M?");
                        classM = scan.nextLine();//Yes - No
                        int cx = Integer.parseInt(coordX);
                        int cy = Integer.parseInt(coordY);
                        int i2 = Integer.parseInt(i3);
                        Coordenades c = new Coordenades(cx, cy);
                        if(classM.equals("Yes")) plan = new Planeta(name, i2, c, true);
                        else{
                            plan = new Planeta(name, i2, c, false);
                        }
                        planets.insert(name, plan);
                        break;
                    case "10":
                    	System.out.println("Escriu el nom del planeta");
                    	aux = scan.nextLine();
                    	if(planets.contains(aux)){
                    	  	Planeta paux2 = planets.obtain(aux);
                    		u.afegirPlaneta(aux, paux2);
                    	}
                    	else System.out.println("No existeix el Planeta");
                    	break;
                    case "11":
                    	System.out.println("Escriu el nom del planeta");
                    	aux = scan.nextLine();
                    	u.desafegirPlaneta(aux);
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

