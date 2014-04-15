import java.util.*;
import java.io.IOException;

public class Driver_Controlador_Domini_QAP{
    private static Controlador_Domini_Univers u;
    
    public static void menu(){
        //NOTA: [U] == Metodes Univers
        //      [QAP] == Metodes QAP
        System.out.println("Tria una opcio:");
        System.out.println("0) => [U] Sortida");
        System.out.println("1) => [U] public Controlador_Domini_Univers");
        System.out.println("2) => [U] public void altaUnivers(String nom)");
        System.out.println("3) => [U] public void baixaUnivers(String nom)");
        System.out.println("4) => [U] public void modificacioNomUnivers(String nomUnivers, String newnomUnivers)");
        System.out.println("5) => [U] public Univers obtenirUnivers(String nom)");
        System.out.println("6) => [U] public int obtenirIdUnivers(String nom)");
        System.out.println("7) => [U] public String llistatUnivers()");
        System.out.println("8) => [U] public void afegirPlanetaUnivers(String nomUnivers, String nomPlaneta)");
        System.out.println("9) => [U] public int numPlanetesUnivers(String nom");
        System.out.println("10) => [U] public void altaPlaneta(String nom, Cooordenades coord, boolean classeM)");
        System.out.println("11) => [U] public double[][] matriuDistanciaPlanetes(String nom_univers)");
        System.out.println("12) => [U] public void desafegirPlanetaUnivers(String nomUnivers, String nomPlaneta");
        
        System.out.println("13) => [U] public void altaRecurs(String nom).");
        System.out.println("14) => [U] public void baixaRecurs(String nom).");
        
        System.out.println("15) => [U] public altaPaquet().");
        System.out.println("16) => [U] public assignarRecurs(int id, String nom).");
        System.out.println("17) => [U] public esborrarRecurs(int id, String nom).");
        
        
        System.out.println("18) => [U] public assginarPaquet(String nomP, int id.");
        System.out.println("19) => [U] public altaNecessetats(String nomP, String nomR).");
        
        System.out.println("20) => [U] public int[][] matriuNecesitatsPlanetes(String nom_univers)");
        System.out.println("21) => [U] public int[][] matriuRecursosPlanetes(String nom_univers)");
        
        System.out.println("22) => [U] public String llistatPaquetsAssignats().");
        System.out.println("23) => [U] public String llistatPaquetsNoAssignats().");
        System.out.println("24) => [QAP] public void get_matriu_distancia(String s).");
        System.out.println("25) => [QAP] public void get_matriu_disponibilitat(String s).");
        System.out.println("26) => [QAP] public void get_matriu_necessitats(String s).");
        System.out.println("27) => [QAP] public void obtenirPlanetes().");
        System.out.println("28) => [QAP] public void obtenirRecursos().");
        System.out.println("29) => [QAP] public void run_algorithm(String algorithm, String cota)");
        
    }
    
    public static void main(String[] args){
		String nomClase = "Controlador QAP";
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
		
		Controlador_Domini_Recurs cr = new Controlador_Domini_Recurs();
		Controlador_Domini_Paquet cpa = new Controlador_Domini_Paquet(cr);
		Controlador_Domini_Planeta cp = new Controlador_Domini_Planeta(cpa, cr);
        Controlador_Domini_QAP cq = new Controlador_Domini_QAP( u, cp, cr);
        
        
		menu();
        
		while(!out){
			try{
				String op = scan.nextLine();
				switch(op){
					case "0":
						out = true;
						break;
					case "1":
						u = new Controlador_Domini_Univers(cp, cr, cpa);
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
						System.out.println("-----------------");
						System.out.print(u.llistatUnivers());
						System.out.println("-----------------");
						break;
					case "8":
						System.out.println("Escriu el nom del univers");
						nom_univers = scan.nextLine();
						System.out.println("Escriu el nom del planeta");
						nom_planeta = scan.nextLine();
						u.afegirPlanetaUnivers(nom_univers,nom_planeta);
						break;
					case "9":
						System.out.println("Escriu el nom del univers");
						num = scan.nextLine();
						System.out.println(u.numPlanetesUnivers(num));
						break;
					case "10":
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
						if (Si.equals(resposta)) cp.altaPlaneta(nom, c, true);
						else cp.altaPlaneta(nom, c, false);
						break;
					case "11":
						System.out.println("Escriu el nom del univers");
						nom_univers = scan.nextLine();
						System.out.println("entra a la func");
						double[][] distances = u.matriuDistanciaPlanetes(nom_univers);
						System.out.println("surt de la func");
						for(int i = 0; i < distances.length; ++i){
							for(int j = 0; j < distances.length; ++j){
								System.out.print(distances[i][j]+" ");
						    }
						    System.out.println("");
						}
						break;
					case "12":
						System.out.println("Escriu el nom del univers");
						nom_univers = scan.nextLine();
						System.out.println("Escriu el nom del planeta");
						nom_planeta = scan.nextLine();
						u.desafegirPlanetaUnivers(nom_univers,nom_planeta);
						break;
					case "13":
						System.out.println("Escriu el nom del recurs");
                        nom = scan.nextLine();
                        cr.altaRecurs(nom);
                        break;
                    case "14":
                        nom = scan.nextLine();
                        cr.baixaRecurs(nom);
                        break;
                    case "15":
                        cpa.altaPaquet();
                        break;
                    case "16":
                    	System.out.println("Introduir id");
                        num = scan.nextLine();
                        System.out.println("Introduir nom del recurs");
                        nom = scan.nextLine();
                        cpa.assignarRecurs(Integer.parseInt(num),nom);
                        break;
                    case "17":
                    	System.out.println("Introduir id");
                        num = scan.nextLine();
                        System.out.println("Introduir nom del recurs");
                        nom = scan.nextLine();
                        cpa.esborrarRecurs(Integer.parseInt(num),nom);
                        break;
                    case "18":
                    	System.out.println("Escriu el nom del Planeta");
						nom_planeta = scan.nextLine();
						System.out.println("Escriu el id del paquet");
						nom = scan.nextLine();
						id_paquet = Integer.parseInt(nom);
                    	cp.assignarPaquet(nom_planeta, id_paquet);
                    	break;
                    case "19":
                    	System.out.println("Escriu el nom del Planeta");
						nom_planeta = scan.nextLine();
						System.out.println("Escriu el nom del recurs");
						nom_recurs = scan.nextLine();
						cp.altaNecessitats(nom_planeta, nom_recurs);
						break;
					case "20":
						System.out.println("Escriu el nom del univers");
						nom_univers = scan.nextLine();
						System.out.println("entra a la func");
						int[][] necesitats = u.matriuNecesitatsPlanetes(nom_univers);
						System.out.println("surt de la func");
						for(int i = 0; i < necesitats.length; ++i){
							for(int j = 0; j < necesitats[i].length; ++j){
								System.out.print(necesitats[i][j]+" ");
						    }
						    System.out.println("");
						}
						break;
					case "21":
						System.out.println("Escriu el nom del univers");
						nom_univers = scan.nextLine();
						System.out.println("entra a la func");
						int[][] recursos = u.matriuRecursosPlanetes(nom_univers);
						System.out.println("surt de la func");
						for(int i = 0; i < recursos.length; ++i){
							for(int j = 0; j < recursos[i].length; ++j){
								System.out.print(recursos[i][j]+" ");
						    }
						    System.out.println("");
						}
						break;
					case "22":
                        System.out.println(cpa.llistatPaquetsAssignats());
                        break;
                        
                    case "23":
                        System.out.println(cpa.llistatPaquetsNoAssignats());
                        break;
                        
                    case "24":
                        System.out.println("Escriu el nom del univers");
						nom_univers = scan.nextLine();
                        cq.get_matriu_distancia(nom_univers);
                        break;
                        
                    case "25":
                        System.out.println("Escriu el nom del univers");
						nom_univers = scan.nextLine();
                        cq.get_matriu_disponibilitat(nom_univers);
                        break;
                        
                    case "26":
                        System.out.println("Escriu el nom del univers");
						nom_univers = scan.nextLine();
                        cq.get_matriu_necessitats(nom_univers);
                        break;
                        
                    case "27":
                        cq.obtenirPlanetes();
                        break;
                        
                    case "28":
                        cq.obtenirRecursos();
                        break;
                        
                    case "29":
                        System.out.println("BB or Tabu");
						String algo = scan.nextLine();
                        System.out.println("BB or Tabu");
						String cota = scan.nextLine();
                        cq.run_algorithm(algo, cota);
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