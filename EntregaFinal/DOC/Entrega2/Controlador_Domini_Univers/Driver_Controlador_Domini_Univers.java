import java.util.*;
import java.io.IOException;

public class Driver_Controlador_Domini_Univers{

	private static Controlador_Domini_Univers u;
	private static Controlador_Domini_Planeta cp;
	private static Controlador_Domini_Paquet cpa;
	private static Controlador_Domini_Recurs cr;
	public static void menu(){
		System.out.println("Escollir opcio:");
		System.out.println("\t 00) Sortida");
		System.out.println("\t 01) public Controlador_Domini_Univers");
		System.out.println("\t 02) public void altaUnivers(String nom)");
		System.out.println("\t 03) public void baixaUnivers(String nom)");
		System.out.println("\t 04) public void modificacioNomUnivers(String nomUnivers, String newnomUnivers)");
		System.out.println("\t 05) public int obtenirIdUnivers(String nom)");
		System.out.println("\t 06) public String llistatUnivers()");
		System.out.println("\t 07) public void afegirPlanetaUnivers(String nomUnivers, String nomPlaneta)");
		System.out.println("\t 08) public int numPlanetesUnivers(String nom");
		System.out.println("\t 10) public double[][] matriuDistanciaPlanetes(String nom_univers)");
		System.out.println("\t 11) public void desafegirPlanetaUnivers(String nomUnivers, String nomPlaneta");
        System.out.println("\t 12) public int[][] matriuNecesitatsPlanetes(String nom_univers)");
        System.out.println("\t 13) public int[][] matriuRecursosPlanetes(String nom_univers)");
        System.out.println("\t 14) public String[] vectorPlanetes(String nomUnivers).");
        System.out.println("\t 15) public void guardarPlanetes(String nomFitxer).");
        System.out.println("\t 16) public void carregarUnivers(String nomFitxer).\n");
   


        System.out.println("\t 21) public Controlador_Domini_Planeta(Controlador_Domini_Paquet p, Controlador_Domini_Recurs r).");
        System.out.println("\t 22) public void altaPlaneta(String nom, Coordenades coord, boolean classeM).");

        //System.out.println("\t 23) public void baixaPlaneta(String nom).");
        System.out.println("\t 23) public void borra_planeta (String nom).");
        

        System.out.println("\t 24) public void assignarPlaneta(String nomP).");
        System.out.println("\t 25) public void desassignarPlaneta(String nomP).");


        //System.out.println("\t 26) public void modificarNom(String nom, String newnom).");
        System.out.println("\t 26) public void modificar_nom_planeta(String oldnom, String newnom).");


        System.out.println("\t 27) public void modificarCoordenades(String nom, int x, int y).");
        System.out.println("\t 28) public void modificarClasse(String nom, boolean classeM).");
        System.out.println("\t 29) public int obtenirId(String nom).");
        System.out.println("\t 30) public boolean obtenirClasse(String nom).");
        System.out.println("\t 31) public Coordenades obtenirCoordenades(String nom).");
        System.out.println("\t 32) public Planeta obtenirPlaneta(String nom).");
        System.out.println("\t 33) public String llistarPlanetesDesassignat().");
        System.out.println("\t 34) public String llistarPlanetesAssignat().");
        System.out.println("\t 35) public void altaNecessitats(String nomP, String nomR).");
        System.out.println("\t 36) public void baixaNecessitats(String nomP, String nomR).");
        System.out.println("\t 37) public void assignarPaquet(String nomP, int id).");
        System.out.println("\t 38) public Iterable<String> obtenirRecursosDisponibles(String nomP).");
        System.out.println("\t 39) public Iterable<String> obtenirNecessitats(String nomP).");
        System.out.println("\t 40) public void guardarPlanetes(String nomFitxer).");
        System.out.println("\t 41) public void carregarPlanetes(String nomFitxer).");
        System.out.println("\t 42) public void desassignarPaquet(String nomP).\n");
        
        

        System.out.println("\t 51) public Controlador_Domini_Paquet(Controlador_Domini_Recurs n).");
        System.out.println("\t 52) public altaPaquet().");


        //System.out.println("\t 53) public baixaPaquet(int id).");
        System.out.println("\t 53) public borrar_paquet(String id).");

        System.out.println("\t 54) public assignarRecurs(int id, String nom).");
        System.out.println("\t 55) public esborrarRecurs(int id, String nom).");
        System.out.println("\t 56) public Paquet obtenirPaquet(int id).");
        System.out.println("\t 57) public Paquet obtenirPaquetAssignar(int id).");
        System.out.println("\t 58) public String llistatPaquetsAssignats().");
        System.out.println("\t 59) public String llistatPaquetsNoAssignats().");
        System.out.println("\t 60) public String llistatRecursosPaquet(int id).");
        System.out.println("\t 61) public void carregarPaquets(String nomFitxer).");
        System.out.println("\t 62) public void guardarPaquets(String nomFitxer).");
        System.out.println("\t 63) public void desassignarPaquet(int id).");
        System.out.println("\t 64) public Iterable<String> llistatRecursosPaquetIterator(Paquet pac).");
        System.out.println("\t 65) public int obtenirIdPaquet(Paquet pac).\n");
        
        
        System.out.println("\t 71) public Controlador_Domini_Recurs().");
        System.out.println("\t 72) public void altaRecurs(String nom).");



       //System.out.println("\t 73) public void baixaRecurs(String nom).");
        System.out.println("\t 73) public void borrar_recurs(String nom).");



        //System.out.println("\t 74) public void modificarNom(String nom, String new_nom).");
        System.out.println("\t 74) public void modificar_nom_recurs (String nom, String new_nom).");


        System.out.println("\t 75) public Recurs obtenirRecurs(String nom).");
        System.out.println("\t 76) public int obtenirId(String nom).");
        System.out.println("\t 77) public String llistatRecurs().");
        System.out.println("\t 78) public String llistatRecurs_2().");
        System.out.println("\t 79) public void carregarRecursos(String nomFitxer).");
        System.out.println("\t 80) public void guardarRecursos(String nomFitxer).");

			
	}

	public static void main(String[] args){
		String nomClase = "Controlador Univers";
		System.out.println("Driver "+nomClase);
		Scanner scan = new Scanner(System.in);
		boolean out = false;
		String nom;
		String num;
		String nom_univers;
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

		while(!out){
			try{
				String op = scan.nextLine();
				switch(op){
					case "00":
						out = true;
						break;
					case "01":
						u = new Controlador_Domini_Univers(cp, cr, cpa);
						break;
					case "02":
						//System.out.println("Escriu el nom de l'univers");
						nom = scan.nextLine();
						u.altaUnivers(nom);
						break;
					case "03":
					  //  System.out.println("Escriu el nom de l'univers");
						nom = scan.nextLine();
						u.baixaUnivers(nom);
						break;
					case "04":
						//System.out.println("Escriu el nom del univers vell");
						nom = scan.nextLine();
						//System.out.println("Escriu el nom del nou univers");
						new_nom = scan.nextLine();
						u.modificacioNomUnivers(nom, new_nom);
						break;
					case "05":
						//System.out.println("Escriu el nom de l'univers");
						nom = scan.nextLine();
						System.out.println(u.obtenirIdUnivers(nom));
						break;					
					case "06":
						//System.out.println("-----------------");
						System.out.print(u.llistatUnivers());
						//System.out.println("-----------------");
						break;
					case "07":
						//System.out.println("Escriu el nom del univers");
						nom_univers = scan.nextLine();
						//System.out.println("Escriu el nom del planeta");
						nom_planeta = scan.nextLine();
						u.afegirPlanetaUnivers(nom_univers,nom_planeta);
						break;	
					case "08":
						//System.out.println("Escriu el nom del univers");
						num = scan.nextLine();
						System.out.println(u.numPlanetesUnivers(num));
						break;
					case "10":
						//System.out.println("Escriu el nom del univers");
						nom_univers = scan.nextLine();
						//System.out.println("entra a la func");
						double[][] distances = u.matriuDistanciaPlanetes(nom_univers);
						//System.out.println("surt de la func");
						for(int i = 0; i < distances.length; ++i){
							for(int j = 0; j < distances.length; ++j){
								System.out.print(distances[i][j]+" ");
						    }
						    System.out.println("");
						}
						break;
					case "11":
						//System.out.println("Escriu el nom del univers");
						nom_univers = scan.nextLine();
						//System.out.println("Escriu el nom del planeta");
						nom_planeta = scan.nextLine();
						u.desafegirPlanetaUnivers(nom_univers,nom_planeta);
						break;
					case "12":
						//System.out.println("Escriu el nom del univers");
						nom_univers = scan.nextLine();
						//System.out.println("entra a la func");
						int[][] necesitats = u.matriuNecesitatsPlanetes(nom_univers);
						//System.out.println("surt de la func");
						for(int i = 0; i < necesitats.length; ++i){
							for(int j = 0; j < necesitats[i].length; ++j){
								System.out.print(necesitats[i][j]+" ");
						    }
						    System.out.println("");
						}
						break;
					case "13":
						//System.out.println("Escriu el nom del univers");
						nom_univers = scan.nextLine();
						int[][] recursos = u.matriuRecursosPlanetes(nom_univers);
						for(int i = 0; i < recursos.length; ++i){
							for(int j = 0; j < recursos[i].length; ++j){
								System.out.print(recursos[i][j]+" ");
						    }
						    System.out.println("");
						}
						break;
					case "14":
						//System.out.println("Escriu el nom del univers");
						nom_univers = scan.nextLine();
						String[] planetes = u.vectorPlanetes(nom_univers);
						for(int i = 0; i < planetes.length; ++i){
							System.out.println(planetes[i]);
						}
						break;
					case "15":
						nom = scan.nextLine();
                        u.guardarUniversos(nom);
						break;
					case "16":
						nom = scan.nextLine();
                        u.carregarUniversos(nom);
						break;
					case "21":
						cp = new Controlador_Domini_Planeta(cpa, cr);
						break;
					case "22":
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
					case "23":	// baixaPlaneta
						nom = scan.nextLine();

						u.borrar_planeta(nom);

						//cp.baixaPlaneta(nom);
						break;
					case "24": //assignarPlaneta
						//System.out.println("Escriu el nom del planeta:");
						String nom2 = scan.nextLine();
						cp.assignarPlaneta(nom2);
						break;
					case "25": //desassignarPlaneta
						//System.out.println("Escriu el nom del planeta:");
						nom = scan.nextLine();
						cp.desassignarPlaneta(nom);
						break;		
					case "26":	// modificarNom(nom, nou_nom)
						//System.out.println("Escriu el nom del planeta a modificar:");
						nom = scan.nextLine();
						//System.out.println("Escriu el nou nom per al planeta:");
						String nou_nom = scan.nextLine();


						u.modificar_nom_planeta(nom, nou_nom);
						//cp.modificarNom(nom, nou_nom);
						break;
					case "27":	// modificarCoordenades(String nom, int x, int y)
						//System.out.println("Escriu el nom del planeta a modificar:");
						nom = scan.nextLine();
						//System.out.println("Escriu coordenades noves:");
						//Coordenades co = new Coordenades();
						x = scan.nextLine();
						y = scan.nextLine();
						cp.modificarCoordenades(nom, Integer.parseInt(x), Integer.parseInt(y));
						break;
					case "28":	// modificarClasse(String nom, boolean classeM)
						//System.out.println("Escriu el nom del planeta a modificar:");
						nom = scan.nextLine();
						//System.out.println("Escriu Si/No és de classe M");
						resposta = scan.nextLine();
						if (resposta.equals("Si")) cp.modificarClasse(nom, true);
						else cp.modificarClasse(nom, false);
						break;
					case "29":	//obtenirId(String nom)
						//System.out.println("Escriu el nom del planeta a consultar:");
						nom = scan.nextLine();
						System.out.println(cp.obtenirId(nom));
						break;					
					case "30":
						//System.out.println("Escriu el nom del planeta a consultar:");
						String nom_m = scan.nextLine();
						boolean b = cp.obtenirClasse(nom_m);
						if (b) System.out.println("Classe M");
						else System.out.println("No Classe M");
						break;
					case "31":
						//System.out.println("Escriu el nom del planeta a consultar:");
						String nom_c = scan.nextLine();
						int x3 = cp.obtenirCoordenades(nom_c).obtenirCoordenadesX();
						int y3 = cp.obtenirCoordenades(nom_c).obtenirCoordenadesY();
						System.out.println(x3);
						System.out.println(y3);
						break;


					case "32":	// Planeta obtenirPlaneta(String nom)
						//System.out.println("Escriu el nom del planeta a consultar:");
						nom = scan.nextLine();
						Planeta paux = cp.obtenirPlaneta(nom);
						System.out.println("Nom planeta: "+paux.obtenirNom());
						System.out.println("Coordenades X planeta: "+paux.obtenirCoordenades().obtenirCoordenadesX());
						System.out.println("Coordenades Y planeta: "+paux.obtenirCoordenades().obtenirCoordenadesY());
						System.out.println("Classe M: "+paux.obtenirClasse());
						break;
					case "33":
						String Conj;
						Conj = cp.llistarPlanetesDesassignat();
						System.out.println(Conj);
						break;
					case "34":
						String Conj2;
						Conj2 = cp.llistarPlanetesAssignat();
						System.out.println(Conj2);
						break;
					case "35": //altaNecesitats(String nomP, String nomR)
						//System.out.println("Escriu el nom del planeta:");
						nom = scan.nextLine();
						//System.out.println("Escriu el nom del recurs:");
						nom_recurs = scan.nextLine();
						cp.altaNecessitats(nom, nom_recurs);
						break;
					case "36": //baixaNecesitats(String nomP, String nomR)
						//System.out.println("Escriu el nom del planeta:");
						nom = scan.nextLine();
						//System.out.println("Escriu el nom del recurs:");
						nom_recurs = scan.nextLine();
						cp.baixaNecessitats(nom, nom_recurs);
						break;

					case "37":
						//System.out.println("Escriu el nom del planeta:");
						String nom1 = scan.nextLine();
						//System.out.println("Escriu el id del paquet:");
						String id1 = scan.nextLine();
						cp.assignarPaquet(nom1,Integer.parseInt(id1));
						break;
					case "38":
						//System.out.println("Escriu el nom del planeta:");
						nom = scan.nextLine();
						Iterable<String> itaux = cp.obtenirRecursosDisponibles(nom);
						for(String a : itaux){
							System.out.println(a);
						}
						break;
					case "39":
						//System.out.println("Escriu el nom del planeta:");
						nom = scan.nextLine();
						Iterable<String> itaux2 = cp.obtenirNecessitats(nom);
						for(String a : itaux2){
							System.out.println(a);
						}
						break;

					case "40":
                       // System.out.println("Introduir nom del fitxer");
                        nom = scan.nextLine();
                        cp.guardarPlanetes(nom);
                        break;

                    case "41":
                        //System.out.println("Introduir nom del fitxer");
                        nom = scan.nextLine();
                        cp.carregarPlanetes(nom);
                        break;
                    case "42":
						//System.out.println("Escriu el nom del planeta:");
						String nom11 = scan.nextLine();
						cp.desassignarPaquet(nom11);
                    	break;
                    case "51":
                        cpa = new Controlador_Domini_Paquet(cr);
                        break;   
                    case "52":
                        cpa.altaPaquet();
                        break;                        
                    case "53":
                        //System.out.println("Introduir id");
                        num = scan.nextLine();
                        
                        u.borrar_paquet(Integer.parseInt(num));
                        //cpa.baixaPaquet(Integer.parseInt(num));
                        break;                        
                    case "54":
                        //System.out.println("Introduir id");
                        num = scan.nextLine();
                        //System.out.println("Introduir nom del recurs");
                        nom = scan.nextLine();
                        cpa.assignarRecurs(Integer.parseInt(num),nom);
                        break;                        
                    case "55":
                        //System.out.println("Introduir id");
                        num = scan.nextLine();
                        //System.out.println("Introduir nom del recurs");
                        nom = scan.nextLine();
                        cpa.esborrarRecurs(Integer.parseInt(num),nom);
                        break;                        
                    case "56":
                        //System.out.println("Introduir id");
                        num = scan.nextLine();
                        pa = cpa.obtenirPaquet(Integer.parseInt(num));
                        System.out.println(Integer.toString(pa.obtenirId()));
                        break;                        
                    case "57":
                        //System.out.println("Introduir id");
                        num = scan.nextLine();
                        pa = cpa.obtenirPaquetAssignar(Integer.parseInt(num));
                        break;                        
                    case "58":
                        System.out.println(cpa.llistatPaquetsAssignats());
                        break;                        
                    case "59":
                        System.out.println(cpa.llistatPaquetsNoAssignats());
                        break;                        
                    case "60":
                        //System.out.println("Introduir id");
                        num = scan.nextLine();
                        System.out.println(cpa.llistatRecursosPaquet(Integer.parseInt(num)));
                        break;                        
                    case "61":
                        //System.out.println("Introduir nom del fitxer");
                        nom = scan.nextLine();
                        cpa.carregarPaquets(nom);
                        break;                        
                    case "62":
                        //System.out.println("Introduir nom del fitxer");
                        nom = scan.nextLine();
                        cpa.guardarPaquets(nom);
                        break;                        
                    case "63":
                        num = scan.nextLine();
                        cpa.desassignarPaquet(Integer.parseInt(num));
                        break;                        
                    case "64":
                        num = scan.nextLine();
                        pa = cpa.obtenirPaquet(Integer.parseInt(num));
                        Iterable<String> s = cpa.llistatRecursosPaquetIterator(cpa.obtenirIdPaquet(pa));
                        String aux = new String();
                        for(String a : s) System.out.println(a);
                        break;                        
                    case "65":
                        num = scan.nextLine();
                        pa = cpa.obtenirPaquet(Integer.parseInt(num));
                        System.out.println(cpa.obtenirIdPaquet(pa));
                        break;                        
                    case "71":
                        cr = new Controlador_Domini_Recurs();
                        break;                        
                    case "72":
                        nom = scan.nextLine();
                        cr.altaRecurs(nom);
                        break;                        
                    case "73":
                        nom = scan.nextLine();

                        u.borrar_recurs(nom);
                        //cr.baixaRecurs(nom);
                        break;                        
                    case "74":
                        nom = scan.nextLine();
                        new_nom = scan.nextLine();
                        
                        u.modificar_nom_recurs(nom, new_nom);
                        //cr.modificarNom(nom,new_nom);
                        break;                        
                    case "75":
                        nom = scan.nextLine();
                        cr.obtenirRecurs(nom);
                        break;                        
                    case "76":
                        nom = scan.nextLine();
                        System.out.println(cr.obtenirId(nom));
                        break;                        
                    case "77":
                        System.out.println(cr.llistatRecurs());
                        break;
                    case "78":
                        System.out.println(cr.llistatRecurs_2());
                        break;
                        
                    case "79":
                        nom = scan.nextLine();
                        cr.carregarRecursos(nom);
                        break;
                        
                    case "80":
                        nom = scan.nextLine();
                        cr.guardarRecursos(nom);
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