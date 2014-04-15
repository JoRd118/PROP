import java.util.*;
import java.io.IOException;

public class Driver_Controlador_Domini_Univers{

	private static Controlador_Domini_Univers u;

	public static void menu(){
		System.out.println("Tria una opcio:");
		System.out.println("0 => Sortida");
		System.out.println("1 => public Controlador_Domini_Univers");
		System.out.println("2 => public void altaUnivers(String nom)");
		System.out.println("3 => public void baixaUnivers(String nom)");
		System.out.println("4 => public void modificacioNomUnivers(String nomUnivers, String newnomUnivers)");
		System.out.println("5 => public Univers obtenirUnivers(String nom)");
		System.out.println("6 => public int obtenirIdUnivers(String nom)");
		System.out.println("7 => public String llistatUnivers()");
		System.out.println("8 => public void afegirPlanetaUnivers(String nomUnivers, String nomPlaneta)");
		System.out.println("9 => public int numPlanetesUnivers(String nom");
		System.out.println("10 => public void altaPlaneta(String nom, Cooordenades coord, boolean classeM)");
		System.out.println("11 => public double[][] matriuDistanciaPlanetes(String nom_univers)");
		System.out.println("12 => public void desafegirPlanetaUnivers(String nomUnivers, String nomPlaneta");

		System.out.println("13) public void altaRecurs(String nom).");
        System.out.println("14) public void baixaRecurs(String nom).");

        System.out.println("15) public altaPaquet().");
        System.out.println("16) public assignarRecurs(int id, String nom).");
        System.out.println("17) public esborrarRecurs(int id, String nom).");


        System.out.println("18) public assginarPaquet(String nomP, int id.");
        System.out.println("19) public altaNecessetats(String nomP, String nomR).");

        System.out.println("20 => public int[][] matriuNecesitatsPlanetes(String nom_univers)");
        System.out.println("21 => public int[][] matriuRecursosPlanetes(String nom_univers)");

        System.out.println("\t 22) public String llistatPaquetsAssignats().");
        System.out.println("\t 23) public String llistatPaquetsNoAssignats().");
   

			
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
		
		Controlador_Domini_Recurs cr = new Controlador_Domini_Recurs();
		Controlador_Domini_Paquet cpa = new Controlador_Domini_Paquet(cr);
		Controlador_Domini_Planeta cp = new Controlador_Domini_Planeta(cpa, cr);



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