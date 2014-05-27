import java.util.*;
import java.io.IOException;

public class Driver_Controlador_Domini_Planeta {
	private static Controlador_Domini_Planeta cp;
	private static	Controlador_Domini_Recurs cr;
	private static	Controlador_Domini_Paquet cpa;

	public static void menu() {
		System.out.println("Escoge una opción:");
		System.out.println("\t 00) Salida.");
        System.out.println("\t 01) public Controlador_Domini_Planeta(Controlador_Domini_Paquet p, Controlador_Domini_Recurs r).");
        System.out.println("\t 02) public void altaPlaneta(String nom, Coordenades coord, boolean classeM).");
        System.out.println("\t 03) public void baixaPlaneta(String nom).");
        System.out.println("\t 04) public void assignarPlaneta(String nomP).");
        System.out.println("\t 05) public void desassignarPlaneta(String nomP).");
        System.out.println("\t 06) public void modificarNom(String nom, String newnom).");
        System.out.println("\t 07) public void modificarCoordenades(String nom, int x, int y).");
        System.out.println("\t 08) public void modificarClasse(String nom, boolean classeM).");
        System.out.println("\t 09) public int obtenirId(String nom).");
        System.out.println("\t 10) public boolean obtenirClasse(String nom).");
        System.out.println("\t 11) public Coordenades obtenirCoordenades(String nom).");
        System.out.println("\t 12) public Planeta obtenirPlaneta(String nom).");
        System.out.println("\t 13) public String llistarPlanetesDesassignat().");
        System.out.println("\t 14) public String llistarPlanetesAssignat().");
        System.out.println("\t 15) public void altaNecessitats(String nomP, String nomR).");
        System.out.println("\t 16) public void baixaNecessitats(String nomP, String nomR).");
        System.out.println("\t 17) public void assignarPaquet(String nomP, int id).");
        System.out.println("\t 18) public Iterable<String> obtenirRecursosDisponibles(String nomP).");
        System.out.println("\t 19) public Iterable<String> obtenirNecessitats(String nomP).");
        System.out.println("\t 20) public void guardarPlanetes(String nomFitxer).");
        System.out.println("\t 21) public void carregarPlanetes(String nomFitxer).");
        System.out.println("\t 22) public void desassignarPaquet(String nomP)");
        System.out.println("\t 23) public void altaPlanetaVista(String nom, String coorden, boolean classeM)");
        System.out.println("\t 24) public String obtenirCoordenadesVista(String nom)");
        System.out.println("\t 25) public String obtenirRecursosDisponiblesVista(String nomP)");
        System.out.println("\t 26) public String obtenirNecessitatsVista(String nomP)");
        System.out.println("\t 27) public void modificarCoordenadesVista(String nom, String coorden)");


        System.out.println("\t 31) public Controlador_Domini_Paquet(Controlador_Domini_Recurs n).");
        System.out.println("\t 32) public altaPaquet().");
        System.out.println("\t 33) public baixaPaquet(int id).");
        System.out.println("\t 34) public assignarRecurs(int id, String nom).");
        System.out.println("\t 35) public esborrarRecurs(int id, String nom).");
        System.out.println("\t 36) public Paquet obtenirPaquet(int id).");
        System.out.println("\t 37) public Paquet obtenirPaquetAssignar(int id).");
        System.out.println("\t 38) public String llistatPaquetsAssignats().");
        System.out.println("\t 39) public String llistatPaquetsNoAssignats().");
        System.out.println("\t 40) public String llistatRecursosPaquet(int id).");
        System.out.println("\t 41) public void carregarPaquets(String nomFitxer).");
        System.out.println("\t 42) public void guardarPaquets(String nomFitxer).");
        System.out.println("\t 43) public void desassignarPaquet(int id).");
        System.out.println("\t 44) public Iterable<String> llistatRecursosPaquetIterator(Paquet pac).");
        System.out.println("\t 45) public int obtenirIdPaquet(Paquet pac)");
        
        
        System.out.println("\t 51) public Controlador_Domini_Recurs().");
        System.out.println("\t 52) public void altaRecurs(String nom).");
        System.out.println("\t 53) public void baixaRecurs(String nom).");
        System.out.println("\t 54) public void modificarNom(String nom, String new_nom).");
        System.out.println("\t 55) public Recurs obtenirRecurs(String nom).");
        System.out.println("\t 56) public int obtenirId(String nom).");
        System.out.println("\t 57) public String llistatRecurs().");
        System.out.println("\t 58) public String llistatRecurs_2().");
        System.out.println("\t 59) public void carregarRecursos(String nomFitxer).");
        System.out.println("\t 60) public void guardarRecursos(String nomFitxer).");
        
	}
	public static void main(String[] args) {
		System.out.println("Driver Controlador Planeta");
		Scanner scan = new Scanner(System.in);
		boolean out = false;
		String nom;
		String num;
		String nom_planeta;
		String nom_recurs;
		int id;
		int id_paquet;
		Paquet pa;
		String x;
		String y;
		String resposta;
		Coordenades c;
		String new_nom;
		menu();

		while (!out) {
			try {
				String op = scan.nextLine();
				switch (op) {
					case "01":
						cp = new Controlador_Domini_Planeta(cpa, cr);
						break;
					case "02":
						//System.out.println("Escriu nom Planeta: ");
						nom = scan.nextLine();
						//System.out.println("Escriu coordenades: ");
						c = new Coordenades();
						x = scan.nextLine();
						y = scan.nextLine();
						c.modificarCoordenades(Integer.parseInt(x), Integer.parseInt(y));
						//System.out.println("Escriu Si/No és de classe M");
						resposta = scan.nextLine();
						if (resposta.equals("Si")) cp.altaPlaneta(nom, c, true);
						else cp.altaPlaneta(nom, c, false);
						break;
					case "03":	// baixaPlaneta
						nom = scan.nextLine();
						cp.baixaPlaneta(nom);
						break;
					case "04": //assignarPlaneta
						//System.out.println("Escriu el nom del planeta:");
						String nom2 = scan.nextLine();
						cp.assignarPlaneta(nom2);
						break;
					case "05": //desassignarPlaneta
						//System.out.println("Escriu el nom del planeta:");
						nom = scan.nextLine();
						cp.desassignarPlaneta(nom);
						break;		
					case "06":	// modificarNom(nom, nou_nom)
						//System.out.println("Escriu el nom del planeta a modificar:");
						nom = scan.nextLine();
						//System.out.println("Escriu el nou nom per al planeta:");
						String nou_nom = scan.nextLine();
						cp.modificarNom(nom, nou_nom);
						break;
					case "07":	// modificarCoordenades(String nom, int x, int y)
						//System.out.println("Escriu el nom del planeta a modificar:");
						nom = scan.nextLine();
						//System.out.println("Escriu coordenades noves:");
						//Coordenades co = new Coordenades();
						x = scan.nextLine();
						y = scan.nextLine();
						cp.modificarCoordenades(nom, Integer.parseInt(x), Integer.parseInt(y));
						break;
					case "08":	// modificarClasse(String nom, boolean classeM)
						//System.out.println("Escriu el nom del planeta a modificar:");
						nom = scan.nextLine();
						//System.out.println("Escriu Si/No és de classe M");
						resposta = scan.nextLine();
						if (resposta.equals("Si")) cp.modificarClasse(nom, true);
						else cp.modificarClasse(nom, false);
						break;
					case "09":	//obtenirId(String nom)
						//System.out.println("Escriu el nom del planeta a consultar:");
						nom = scan.nextLine();
						System.out.println(cp.obtenirId(nom));
						break;					
					case "10":
						//System.out.println("Escriu el nom del planeta a consultar:");
						String nom_m = scan.nextLine();
						boolean b = cp.obtenirClasse(nom_m);
						if (b) System.out.println("Classe M");
						else System.out.println("No Classe M");
						break;
					case "11":
						//System.out.println("Escriu el nom del planeta a consultar:");
						String nom_c = scan.nextLine();
						int x3 = cp.obtenirCoordenades(nom_c).obtenirCoordenadesX();
						int y3 = cp.obtenirCoordenades(nom_c).obtenirCoordenadesY();
						System.out.println(x3);
						System.out.println(y3);
						break;


					case "12":	// Planeta obtenirPlaneta(String nom)
						//System.out.println("Escriu el nom del planeta a consultar:");
						nom = scan.nextLine();
						Planeta paux = cp.obtenirPlaneta(nom);
						System.out.println("Nom planeta: "+paux.obtenirNom());
						System.out.println("Coordenades X planeta: "+paux.obtenirCoordenades().obtenirCoordenadesX());
						System.out.println("Coordenades Y planeta: "+paux.obtenirCoordenades().obtenirCoordenadesY());
						System.out.println("Classe M: "+paux.obtenirClasse());
						break;
					case "13":
						String Conj;
						Conj = cp.llistarPlanetesDesassignat();
						System.out.println(Conj);
						break;
					case "14":
						String Conj2;
						Conj2 = cp.llistarPlanetesAssignat();
						System.out.println(Conj2);
						break;
					case "15": //altaNecesitats(String nomP, String nomR)
						//System.out.println("Escriu el nom del planeta:");
						nom = scan.nextLine();
						//System.out.println("Escriu el nom del recurs:");
						nom_recurs = scan.nextLine();
						cp.altaNecessitats(nom, nom_recurs);
						break;
					case "16": //baixaNecesitats(String nomP, String nomR)
						//System.out.println("Escriu el nom del planeta:");
						nom = scan.nextLine();
						//System.out.println("Escriu el nom del recurs:");
						nom_recurs = scan.nextLine();
						cp.baixaNecessitats(nom, nom_recurs);
						break;

					case "17":
						//System.out.println("Escriu el nom del planeta:");
						String nom1 = scan.nextLine();
						//System.out.println("Escriu el id del paquet:");
						String id1 = scan.nextLine();
						cp.assignarPaquet(nom1,Integer.parseInt(id1));
						break;
					case "18":
						//System.out.println("Escriu el nom del planeta:");
						nom = scan.nextLine();
						Iterable<String> itaux = cp.obtenirRecursosDisponibles(nom);
						for(String a : itaux){
							System.out.println(a);
						}
						break;
					case "19":
						//System.out.println("Escriu el nom del planeta:");
						nom = scan.nextLine();
						Iterable<String> itaux2 = cp.obtenirNecessitats(nom);
						for(String a : itaux2){
							System.out.println(a);
						}
						break;

					case "20":
                        //System.out.println("Introduir nom del fitxer");
                        nom = scan.nextLine();
                        cp.guardarPlanetes(nom);
                        break;

                    case "21":
                       //System.out.println("Introduir nom del fitxer");
                        nom = scan.nextLine();
                        cp.carregarPlanetes(nom);
                        break;
                    case "22":
						//System.out.println("Escriu el nom del planeta:");
						String nom11 = scan.nextLine();
						cp.desassignarPaquet(nom11);
                    	break;
                    case "23":	// public void altaPlanetaVista(String nom, String coorden, boolean classeM)
                    	nom = scan.nextLine();
                    	String coords = new String();
                    	coords = scan.nextLine();
                    	resposta = scan.nextLine();
						if (resposta.equals("Si")) cp.altaPlanetaVista(nom, coords, true);
						else cp.altaPlanetaVista(nom, coords, false);
                    	break;
                    case "24":	// public String obtenirCoordenadesVista(String nom)
                    	nom = scan.nextLine();
                    	String resp = cp.obtenirCoordenadesVista(nom);
                    	System.out.println(resp);
                    	break;
                    case "25": 	// System.out.println("\t 25) public String obtenirRecursosDisponiblesVista(String nomP)");
						nom = scan.nextLine();
						System.out.println(cp.obtenirRecursosDisponiblesVista(nom));
						break;
        			case "26":	//System.out.println("\t 26) public String obtenirNecessitatsVista(String nomP)");
						nom = scan.nextLine();
						System.out.println(cp.obtenirNecessitatsVista(nom));
						break;
					case "27": // public void modificarCoordenadesVista(String nom, String coorden)
						nom = scan.nextLine();
						String linia = scan.nextLine();
						cp.modificarCoordenadesVista(nom, linia); 
						break;
                    case "31":
                        cpa = new Controlador_Domini_Paquet(cr);
                        break;   
                    case "32":
                        cpa.altaPaquet();
                        break;                        
                    case "33":
                        //System.out.println("Introduir id");
                        num = scan.nextLine();
                        cpa.baixaPaquet(Integer.parseInt(num));
                        break;                        
                    case "34":
                        //System.out.println("Introduir id");
                        num = scan.nextLine();
                        //System.out.println("Introduir nom del recurs");
                        nom = scan.nextLine();
                        cpa.assignarRecurs(Integer.parseInt(num),nom);
                        break;                        
                    case "35":
                        //System.out.println("Introduir id");
                        num = scan.nextLine();
                        //System.out.println("Introduir nom del recurs");
                        nom = scan.nextLine();
                        cpa.esborrarRecurs(Integer.parseInt(num),nom);
                        break;                        
                    case "36":
                        //System.out.println("Introduir id");
                        num = scan.nextLine();
                        pa = cpa.obtenirPaquet(Integer.parseInt(num));
                        System.out.println(Integer.toString(pa.obtenirId()));
                        break;                        
                    case "37":
                        //System.out.println("Introduir id");
                        num = scan.nextLine();
                        pa = cpa.obtenirPaquetAssignar(Integer.parseInt(num));
                        break;                        
                    case "38":
                        System.out.println(cpa.llistatPaquetsAssignats());
                        break;                        
                    case "39":
                        System.out.println(cpa.llistatPaquetsNoAssignats());
                        break;                        
                    case "40":
                        //System.out.println("Introduir id");
                        num = scan.nextLine();
                        System.out.println(cpa.llistatRecursosPaquet(Integer.parseInt(num)));
                        break;                        
                    case "41":
                        //System.out.println("Introduir nom del fitxer");
                        nom = scan.nextLine();
                        cpa.carregarPaquets(nom);
                        break;                        
                    case "42":
                        //System.out.println("Introduir nom del fitxer");
                        nom = scan.nextLine();
                        cpa.guardarPaquets(nom);
                        break;                        
                    case "43":
                        num = scan.nextLine();
                        cpa.desassignarPaquet(Integer.parseInt(num));
                        break;                        
                    case "44":
                        num = scan.nextLine();
                        pa = cpa.obtenirPaquet(Integer.parseInt(num));
                        Iterable<String> s = cpa.llistatRecursosPaquetIterator(cpa.obtenirIdPaquet(pa));
                        String aux = new String();
                        for(String a : s) System.out.println(a);
                        break;                        
                    case "45":
                        num = scan.nextLine();
                        pa = cpa.obtenirPaquet(Integer.parseInt(num));
                        System.out.println(cpa.obtenirIdPaquet(pa));
                        break;                        
                    case "51":
                        cr = new Controlador_Domini_Recurs();
                        break;                        
                    case "52":
                        nom = scan.nextLine();
                        cr.altaRecurs(nom);
                        break;                        
                    case "53":
                        nom = scan.nextLine();
                        cr.baixaRecurs(nom);
                        break;                        
                    case "54":
                        nom = scan.nextLine();
                        new_nom = scan.nextLine();
                        cp.modificar_nom_recurs2(nom,new_nom);
                        break;                        
                    case "55":
                        nom = scan.nextLine();
                        cr.obtenirRecurs(nom);
                        break;                        
                    case "56":
                        nom = scan.nextLine();
                        System.out.println(cr.obtenirId(nom));
                        break;                        
                    case "57":
                        System.out.println(cr.llistatRecurs());
                        break;

                    case "58":
                        System.out.println(cr.llistatRecurs_2());
                        break;
                        
                    case "59":
                        nom = scan.nextLine();
                        cr.carregarRecursos(nom);
                        break;
                        
                    case "60":
                        nom = scan.nextLine();
                        cr.guardarRecursos(nom);
                        break;
                        

					case "00":
						out = true;
						break;
					default:
						System.out.println("Opcio no valida");
						break;
				}
			} catch (Exception e) {
                System.out.println(e.getMessage());
            }
		}
		scan.close();





	}        




}