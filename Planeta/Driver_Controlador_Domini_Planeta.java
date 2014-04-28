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
        System.out.println("\t 04) public Planeta assignarPlaneta(String nomP)");
        System.out.println("\t 05) public void desassignarPlaneta(String nomP)");



        System.out.println("\t 06) public void modificarNom(String nom, String new_nom).");
   		System.out.println("\t 07) public void modificarCoordenades(String nom, int x, int y).");
        System.out.println("\t 08) public void modificarClasse(String nom, boolean classeM).");
        System.out.println("\t 09) public String obtenirId(String nom).");
        //System.out.println("\t 08) public String obtenirNom(int id).");
        System.out.println("\t 10) public boolean obtenirClasse(String nom).");
		System.out.println("\t 11) public Coordenades obtenirCoordenades(String nom).");
		System.out.println("\t 12) public Planeta obtenirPlanetes(int id).");
		System.out.println("\t 13) public ArrayList<Planeta> llistarPlanetesDesassignats().");
		System.out.println("\t 14) public ArrayList<Planeta> llistarPlanetesAssignats().");
        System.out.println("\t 15) public altaNecessitats(String nomP, String nomR)");
        System.out.println("\t 16) public baixaNecessitats(String nomP, String nomR)");

		System.out.println("\t 17) public assignarPaquet(String nomP, int id)");
		System.out.println("\t 18) public desassignarPaquet(String nomP, int id)");



		System.out.println("\t 19) public Iterable<String> obtenirRecursosDisponibles(String nomP)");
		System.out.println("\t 20) public Iterable<String> obtenirNecessitats(String nomP)");

		System.out.println("\t 21) public void guardarPlaneta(String nomFitxer).");
		System.out.println("\t 22) public void carregarPlaneta(String nomFitxer).");
        
	}
	public static void main(String[] args) {
		System.out.println("Driver Controlador Planeta");
		Scanner scan = new Scanner(System.in);
		boolean out = false;
		String nom;
		String x;
		String y;
		String resposta;

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
						x = scan.nextLine();
						y = scan.nextLine();
						c.modificarCoordenades(Integer.parseInt(x), Integer.parseInt(y));
						System.out.println("Escriu Si/No és de classe M");
						resposta = scan.nextLine();
						if (resposta.equals("Si")) p.altaPlaneta(nom, c, true);
						else p.altaPlaneta(nom, c, false);
						break;

					case "03":	// baixaPlaneta
						nom = scan.nextLine();
						p.baixaPlaneta(nom);
						break;

					case "04":	// modificarNom(nom, nou_nom)
						System.out.println("Escriu el nom del planeta a modificar:");
						nom = scan.nextLine();
						System.out.println("Escriu el nou nom per al planeta:");
						String nou_nom = scan.nextLine();
						p.modificarNom(nom, nou_nom);
						break;

					case "05":	// modificarCoordenades(String nom, int x, int y)
						System.out.println("Escriu el nom del planeta a modificar:");
						nom = scan.nextLine();
						System.out.println("Escriu coordenades noves:");
						Coordenades co = new Coordenades();
						x = scan.nextLine();
						y = scan.nextLine();
						co.modificarCoordenades(nom, Integer.parseInt(x), Integer.parseInt(y));
						break;

					case "06":	// modificarClasse(String nom, boolean classeM) 
						System.out.println("Escriu el nom del planeta a modificar:");
						nom = scan.nextLine();
						System.out.println("Escriu Si/No és de classe M");
						resposta = scan.nextLine();
						if (resposta.equals("Si")) p.modificarClasse(nomp_m, true);
						else p.modificarClasse(nom, false);
						break;

					case "07":	//obtenirId(String nom)
						System.out.println("Escriu el nom del planeta a consultar:");
						nom = scan.nextLine();
						p.obtenirId(nom);
						break;
					case "08":	// obtenirNom(Int id)
						System.out.println("Escriu el id del planeta a consultar:");
						String id_nom = scan.nextLine();
						int idn = Integer.parseInt(id_nom);
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

					case "17":
                        System.out.println("Introduir nom del fitxer");
                        nom = scan.nextLine();
                        p.carregarPlanetes(nom);
                        break;

                    case "18":
                        System.out.println("Introduir nom del fitxer");
                        nom = scan.nextLine();
                        p.guardarPlanetes(nom);
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