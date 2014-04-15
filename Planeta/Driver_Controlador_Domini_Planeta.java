import java.util.*;
import java.io.IOException;

public class Driver_Controlador_Domini_Planeta {
	private static Controlador_Domini_Planeta p;

	public static void menu() {
		System.out.println("Escoge una opción:");
		System.out.println("\t 00) Salida.");
        System.out.println("\t 01) public Controlador_Domini_Planeta().");
        System.out.println("\t 02) public void altaPlaneta(String nom, Cooordenades coord, boolean classeM).");
        System.out.println("\t 03) public void baixaPlaneta(String nom).");
        System.out.println("\t 04) public void modificarNom(String nom, String new_nom).");
   		System.out.println("\t 05) public void modificarCoordenades(String nom, int x, int y).");
        System.out.println("\t 06) public void modificarClasse(String nom, boolean classeM).");
        System.out.println("\t 07) public String obtenirId(String nom).");
        System.out.println("\t 08) public String obtenirNom(int id).");
        System.out.println("\t 09) public boolean obtenirClasse(String nom).");
		System.out.println("\t 10) public Coordenades obtenirCoordenades(String nom).");
		System.out.println("\t 11) public Planeta obtenirPlaneta(int id).");
		System.out.println("\t 12) public ArrayList<Planeta> llistarPlanetes().");

		System.out.println("\t 13) public assignarPaquet(String nomP, int id)");
		System.out.println("\t 14) public Iterable<String> obtenirRecursosDisponibles(String nomP)");
		System.out.println("\t 15) public assignarPlaneta(String nomP)");
		System.out.println("\t 16) public altaNecessitats(String nomP)");
	}
	public static void main(String[] args) {
		System.out.println("Driver Controlador Planeta");
		Scanner scan = new Scanner(System.in);
		boolean out = false;
		String nom;

		menu();

		while (!out) {
			try {
				String op = scan.nextLine();
				switch (op) {
					case "01":
						p = new Controlador_Domini_Planeta();
						break;
					case "02":
						System.out.println("Escriu nom Planeta: ");
						nom = scan.nextLine();
						System.out.println("Escriu coordenades: ");
						Coordenades c = new Coordenades();
						String x = scan.nextLine();
						int Eix_x = Integer.parseInt(x); 
						String y = scan.nextLine();
						int Eix_y = Integer.parseInt(y);
						c.modificarCoordenades(Eix_x, Eix_y);
						System.out.println("Escriu Si/No és de classe M");
						String resposta = scan.nextLine();
						String Si = "Si";
						if (Si.equals(resposta)) p.altaPlaneta(nom, c, true);
						else p.altaPlaneta(nom, c, false);
						break;
					case "03":	// baixaPlaneta
						String nom_baixa = scan.nextLine();
						p.baixaPlaneta(nom_baixa);
						break;
					case "04":	// modificarNom(nom, nou_nom)
						System.out.println("Escriu el nom del planeta a modificar:");
						String nomp = scan.nextLine();
						System.out.println("Escriu el nou nom per al planeta:");
						String nou_nom = scan.nextLine();
						p.modificarNom(nomp, nou_nom);
						
						break;
					case "05":	// modificarCoordenades(String nom, int x, int y)
						System.out.println("Escriu el nom del planeta a modificar:");
						String nomp_c = scan.nextLine();
						System.out.println("Escriu coordenades noves:");
						Coordenades co = new Coordenades();
						String x2 = scan.nextLine();
						int Eix_x2 = Integer.parseInt(x2); 
						String y2 = scan.nextLine();
						int Eix_y2 = Integer.parseInt(y2);
						co.modificarCoordenades(Eix_x2, Eix_y2);

						break;
					case "06":	// modificarClasse(String nom, boolean classeM) 
						System.out.println("Escriu el nom del planeta a modificar:");
						String nomp_m = scan.nextLine();
						System.out.println("Escriu Si/No és de classe M");
						String resposta2 = scan.nextLine();
						String Si2 = "Si";
						if (Si2.equals(resposta2)) p.modificarClasse(nomp_m, true);
						else p.modificarClasse(nomp_m, false);
						break;
					case "07":	// obtenirId(String nom)
						System.out.println("Escriu el nom del planeta a consultar:");
						String nomp_id = scan.nextLine();
						p.obtenirId(nomp_id);
						break;
					case "08":	// obtenirNom(Int id)
						System.out.println("Escriu el id del planeta a consultar:");
						String id_nom = scan.nextLine();
						int idn = Integer.parseInt(id_nom);
						//p.obtenirNom(idn);
						break;
					case "09":
						System.out.println("Escriu el nom del planeta a consultar:");
						String nom_m = scan.nextLine();
						boolean b = p.obtenirClasse(nom_m);
						if (b) System.out.println("Classe M");
						else System.out.println("No Classe M");
						break;
					case "10":
						System.out.println("Escriu el nom del planeta a consultar:");
						String nom_c = scan.nextLine();
						int x3 = p.obtenirCoordenades(nom_c).obtenirCoordenadesX();
						System.out.println(x3);
						break;
					case "11":	// Planeta obtenirPlaneta(int id)
						


						break;
					case "12":
						String Conj;
						Conj = p.llistarPlanetesDesassignat();
						System.out.println(Conj);
						break;

					case "13":
						System.out.println("Escriu el nom del planeta:");
						String nom1 = scan.nextLine();
						System.out.println("Escriu el id del paquet:");
						String id1 = scan.nextLine();
					    p.assignarPaquet(nom1,Integer.parseInt(id1));
						break;

					case "14":

						break;

					case "15":
						System.out.println("Escriu el nom del planeta:");
						String nom2 = scan.nextLine();
						p.assignarPlaneta(nom2);
						break;

					case "16":

						break;

					case "00":
						out = true;
						break;
				}
			} catch (Exception e) {
                System.out.println(e.getMessage());
            }
		}
		scan.close();





	}        




}