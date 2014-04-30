import java.util.*;
import java.io.IOException;
/**
 *
 *Driver Entrada
 *
 *@author jordi Vilella
 */
public class Driver_Entrada{
    
    private static Entrada en;
    private static Controlador_Domini_Recurs cr;
    private static Controlador_Domini_Paquet cpa;
    private static Controlador_Domini_Planeta cp;
    private static Controlador_Domini_Univers u;
    
    public static void menu() {
        System.out.println("Escollir opcio:");
        System.out.println("\t 01) public Entrada(Controlador_Domini_Recurs cdr, Controlador_Domini_Univers cdu).");
        System.out.println("\t 02) public void calcularMatrius(String nom_univers).");
        System.out.println("\t 03) public double[][] obtenirMatriuDisPla().");
        System.out.println("\t 04) public int[][] obtenirMatriuNecPla().");
        System.out.println("\t 05) public int[][] obtenirMatriuRecPla().");
        System.out.println("\t 06) public String[] obtenirVectorRecu().");
        System.out.println("\t 07) public String[] obtenirVectorPlan().");

        System.out.println("\t 11) public Controlador_Domini_Univers");
        System.out.println("\t 12) public void altaUnivers(String nom)");
        System.out.println("\t 13) public void baixaUnivers(String nom)");
        System.out.println("\t 14) public void modificacioNomUnivers(String nomUnivers, String newnomUnivers)");
        System.out.println("\t 15) public int obtenirIdUnivers(String nom)");
        System.out.println("\t 16) public String llistatUnivers()");
        System.out.println("\t 17) public void afegirPlanetaUnivers(String nomUnivers, String nomPlaneta)");
        System.out.println("\t 18) public int numPlanetesUnivers(String nom");
        System.out.println("\t 19) public void altaPlaneta(String nom, Cooordenades coord, boolean classeM)");
        System.out.println("\t 20) public double[][] matriuDistanciaPlanetes(String nom_univers)");
        System.out.println("\t 21) public void desafegirPlanetaUnivers(String nomUnivers, String nomPlaneta");
        System.out.println("\t 22) public int[][] matriuNecesitatsPlanetes(String nom_univers)");
        System.out.println("\t 23) public int[][] matriuRecursosPlanetes(String nom_univers)");
        System.out.println("\t 24) public String[] vectorPlanetes(String nomUnivers).");
        System.out.println("\t 25) public void guardarPlanetes(String nomFitxer).");
        System.out.println("\t 26) public void carregarUnivers(String nomFitxer).\n");
   


        System.out.println("\t 31) public Controlador_Domini_Planeta(Controlador_Domini_Paquet p, Controlador_Domini_Recurs r).");
        System.out.println("\t 32) public void altaPlaneta(String nom, Coordenades coord, boolean classeM).");
        System.out.println("\t 33) public void baixaPlaneta(String nom).");
        System.out.println("\t 34) public void assignarPlaneta(String nomP).");
        System.out.println("\t 35) public void desassignarPlaneta(String nomP).");
        System.out.println("\t 36) public void modificarNom(String nom, String newnom).");
        System.out.println("\t 37) public void modificarCoordenades(String nom, int x, int y).");
        System.out.println("\t 38) public void modificarClasse(String nom, boolean classeM).");
        System.out.println("\t 39) public int obtenirId(String nom).");
        System.out.println("\t 40) public boolean obtenirClasse(String nom).");
        System.out.println("\t 41) public Coordenades obtenirCoordenades(String nom).");
        System.out.println("\t 42) public Planeta obtenirPlaneta(String nom).");
        System.out.println("\t 43) public String llistarPlanetesDesassignat().");
        System.out.println("\t 44) public String llistarPlanetesAssignat().");
        System.out.println("\t 45) public void altaNecessitats(String nomP, String nomR).");
        System.out.println("\t 46) public void baixaNecessitats(String nomP, String nomR).");
        System.out.println("\t 47) public void assignarPaquet(String nomP, int id).");
        System.out.println("\t 48) public Iterable<String> obtenirRecursosDisponibles(String nomP).");
        System.out.println("\t 49) public Iterable<String> obtenirNecessitats(String nomP).");
        System.out.println("\t 50) public void guardarPlanetes(String nomFitxer).");
        System.out.println("\t 51) public void carregarPlanetes(String nomFitxer).");
        System.out.println("\t 52) public void desassignarPaquet(String nomP).\n");
        
        

        System.out.println("\t 61) public Controlador_Domini_Paquet(Controlador_Domini_Recurs n).");
        System.out.println("\t 62) public altaPaquet().");
        System.out.println("\t 63) public baixaPaquet(int id).");
        System.out.println("\t 64) public assignarRecurs(int id, String nom).");
        System.out.println("\t 65) public esborrarRecurs(int id, String nom).");
        System.out.println("\t 66) public Paquet obtenirPaquet(int id).");
        System.out.println("\t 67) public Paquet obtenirPaquetAssignar(int id).");
        System.out.println("\t 68) public String llistatPaquetsAssignats().");
        System.out.println("\t 69) public String llistatPaquetsNoAssignats().");
        System.out.println("\t 70) public String llistatRecursosPaquet(int id).");
        System.out.println("\t 71) public void carregarPaquets(String nomFitxer).");
        System.out.println("\t 72) public void guardarPaquets(String nomFitxer).");
        System.out.println("\t 73) public void desassignarPaquet(int id).");
        System.out.println("\t 74) public Iterable<String> llistatRecursosPaquetIterator(Paquet pac).");
        System.out.println("\t 75) public int obtenirIdPaquet(Paquet pac).\n");
        
        
        System.out.println("\t 81) public Controlador_Domini_Recurs().");
        System.out.println("\t 82) public void altaRecurs(String nom).");
        System.out.println("\t 83) public void baixaRecurs(String nom).");
        System.out.println("\t 84) public void modificarNom(String nom, String new_nom).");
        System.out.println("\t 85) public Recurs obtenirRecurs(String nom).");
        System.out.println("\t 86) public int obtenirId(String nom).");
        System.out.println("\t 87) public String llistatRecurs().");





        System.out.println("\t 00) Salida.");
    }
    
    public static void main(String[] args) {
        String nombreClase = "Controlador_Entrada";
        System.out.println("Driver "+nombreClase);
        Scanner scan = new Scanner(System.in);
        double[][] dou;
        int[][] in;
        String[] str;
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
        boolean out = false;
        //Entrada en;


        menu();
        
        while(!out){
            try{
                String op = scan.nextLine();
                switch (op) {
                    case "00":
                        out = true;
                        break;

                    case "01":
                        en = new Entrada(cr, u);
                        break;
                        
                    case "02":
                        nom = scan.nextLine();
                        en.calcularMatrius(nom);
                        break;
                        
                    case "03":
                        dou = en.obtenirMatriuDisPla();
                        for (int i = 0; i < dou.length; ++i) {
                            for (int j = 0; j < dou[0].length; ++j) {
                                System.out.println(dou[i][j]);
                            }
                            System.out.println();
                        }
                        System.out.println("\n");
                        break;

                    case "04":
                        in = en.obtenirMatriuNecPla();
                        for (int i = 0; i < in.length; ++i) {
                            for (int j = 0; j < in[0].length; ++j) {
                                System.out.println(in[i][j]);
                            }
                            System.out.println();
                        }
                        System.out.println("\n");
                        break;

                    case "05":
                        in = en.obtenirMatriuRecPla();
                        for (int i = 0; i < in.length; ++i) {
                            for (int j = 0; j < in[0].length; ++j) {
                                System.out.println(in[i][j]);
                            }
                            System.out.println();
                        }
                        System.out.println("\n");
                        break;

                    case "06":
                        str = en.obtenirVectorRecu();
                        for (int i = 0; i < str.length; ++i) {
                            System.out.println(str[i]);
                        }
                        System.out.println("\n");
                        break;

                    case "07":
                        str = en.obtenirVectorPlan();
                        for (int i = 0; i < str.length; ++i) {
                            System.out.println(str[i]);
                        }
                        System.out.println("\n");
                        break;


                    case "11":
                        u = new Controlador_Domini_Univers(cp, cr, cpa);
                        break;

                    case "12":
                        //System.out.println("Escriu el nom de l'univers");
                        nom = scan.nextLine();
                        u.altaUnivers(nom);
                        break;
                    case "13":
                      //  System.out.println("Escriu el nom de l'univers");
                        nom = scan.nextLine();
                        u.baixaUnivers(nom);
                        break;
                    case "14":
                        //System.out.println("Escriu el nom del univers vell");
                        nom = scan.nextLine();
                        //System.out.println("Escriu el nom del nou univers");
                        new_nom = scan.nextLine();
                        u.modificacioNomUnivers(nom, new_nom);
                        break;
                    case "15":
                        //System.out.println("Escriu el nom de l'univers");
                        nom = scan.nextLine();
                        System.out.println(u.obtenirIdUnivers(nom));
                        break;                  
                    case "16":
                        //System.out.println("-----------------");
                        System.out.print(u.llistatUnivers());
                        //System.out.println("-----------------");
                        break;
                    case "17":
                        //System.out.println("Escriu el nom del univers");
                        nom_univers = scan.nextLine();
                        //System.out.println("Escriu el nom del planeta");
                        nom_planeta = scan.nextLine();
                        u.afegirPlanetaUnivers(nom_univers,nom_planeta);
                        break;  
                    case "18":
                        //System.out.println("Escriu el nom del univers");
                        num = scan.nextLine();
                        //System.out.println(u.numPlanetesUnivers(num));
                        break;
                    case "19":
                        //System.out.println("Escriu nom Planeta: ");
                        nom = scan.nextLine();
                        //System.out.println("Escriu coordenades: ");
                        c = new Coordenades();
                        x = scan.nextLine();
                        int Eix_x = Integer.parseInt(x); 
                        y = scan.nextLine();
                        int Eix_y = Integer.parseInt(y);
                        c.modificarCoordenades(Eix_x, Eix_y);
                        //System.out.println("Escriu Si/No és de classe M");
                        resposta = scan.nextLine();
                        String Si = "Si";
                        if (Si.equals(resposta)) cp.altaPlaneta(nom, c, true);
                        else cp.altaPlaneta(nom, c, false);
                        break;
                    case "20":
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
                    case "21":
                        //System.out.println("Escriu el nom del univers");
                        nom_univers = scan.nextLine();
                        //System.out.println("Escriu el nom del planeta");
                        nom_planeta = scan.nextLine();
                        u.desafegirPlanetaUnivers(nom_univers,nom_planeta);
                        break;
                    case "22":
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
                    case "23":
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
                    case "24":
                        //System.out.println("Escriu el nom del univers");
                        nom_univers = scan.nextLine();
                        String[] planetes = u.vectorPlanetes(nom_univers);
                        for(int i = 0; i < planetes.length; ++i){
                            System.out.println(planetes[i]);
                        }
                        break;
                    case "25":
                        nom = scan.nextLine();
                        u.guardarUniversos(nom);
                        break;
                    case "26":
                        nom = scan.nextLine();
                        u.carregarUniversos(nom);
                        break;
                    case "31":
                        cp = new Controlador_Domini_Planeta(cpa, cr);
                        break;
                    case "32":
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
                    case "33":  // baixaPlaneta
                        nom = scan.nextLine();
                        cp.baixaPlaneta(nom);
                        break;
                    case "34": //assignarPlaneta
                        //System.out.println("Escriu el nom del planeta:");
                        String nom2 = scan.nextLine();
                        cp.assignarPlaneta(nom2);
                        break;
                    case "35": //desassignarPlaneta
                        //System.out.println("Escriu el nom del planeta:");
                        nom = scan.nextLine();
                        cp.desassignarPlaneta(nom);
                        break;      
                    case "36":  // modificarNom(nom, nou_nom)
                        //System.out.println("Escriu el nom del planeta a modificar:");
                        nom = scan.nextLine();
                        //System.out.println("Escriu el nou nom per al planeta:");
                        String nou_nom = scan.nextLine();
                        cp.modificarNom(nom, nou_nom);
                        break;
                    case "37":  // modificarCoordenades(String nom, int x, int y)
                        //System.out.println("Escriu el nom del planeta a modificar:");
                        nom = scan.nextLine();
                        //System.out.println("Escriu coordenades noves:");
                        //Coordenades co = new Coordenades();
                        x = scan.nextLine();
                        y = scan.nextLine();
                        cp.modificarCoordenades(nom, Integer.parseInt(x), Integer.parseInt(y));
                        break;
                    case "38":  // modificarClasse(String nom, boolean classeM)
                        //System.out.println("Escriu el nom del planeta a modificar:");
                        nom = scan.nextLine();
                        //System.out.println("Escriu Si/No és de classe M");
                        resposta = scan.nextLine();
                        if (resposta.equals("Si")) cp.modificarClasse(nom, true);
                        else cp.modificarClasse(nom, false);
                        break;
                    case "39":  //obtenirId(String nom)
                        //System.out.println("Escriu el nom del planeta a consultar:");
                        nom = scan.nextLine();
                        System.out.println(cp.obtenirId(nom));
                        break;                  
                    case "40":
                        //System.out.println("Escriu el nom del planeta a consultar:");
                        String nom_m = scan.nextLine();
                        boolean b = cp.obtenirClasse(nom_m);
                        if (b) System.out.println("Classe M");
                        else System.out.println("No Classe M");
                        break;
                    case "41":
                        //System.out.println("Escriu el nom del planeta a consultar:");
                        String nom_c = scan.nextLine();
                        int x3 = cp.obtenirCoordenades(nom_c).obtenirCoordenadesX();
                        int y3 = cp.obtenirCoordenades(nom_c).obtenirCoordenadesY();
                        System.out.println(x3);
                        System.out.println(y3);
                        break;


                    case "42":  // Planeta obtenirPlaneta(String nom)
                        //System.out.println("Escriu el nom del planeta a consultar:");
                        nom = scan.nextLine();
                        Planeta paux = cp.obtenirPlaneta(nom);
                        System.out.println("Nom planeta: "+paux.obtenirNom());
                        System.out.println("Coordenades X planeta: "+paux.obtenirCoordenades().obtenirCoordenadesX());
                        System.out.println("Coordenades Y planeta: "+paux.obtenirCoordenades().obtenirCoordenadesY());
                        System.out.println("Classe M: "+paux.obtenirClasse());
                        break;
                    case "43":
                        String Conj;
                        Conj = cp.llistarPlanetesDesassignat();
                        System.out.println(Conj);
                        break;
                    case "44":
                        String Conj2;
                        Conj2 = cp.llistarPlanetesAssignat();
                        System.out.println(Conj2);
                        break;
                    case "45": //altaNecesitats(String nomP, String nomR)
                        //System.out.println("Escriu el nom del planeta:");
                        nom = scan.nextLine();
                        //System.out.println("Escriu el nom del recurs:");
                        nom_recurs = scan.nextLine();
                        cp.altaNecessitats(nom, nom_recurs);
                        break;
                    case "46": //baixaNecesitats(String nomP, String nomR)
                        //System.out.println("Escriu el nom del planeta:");
                        nom = scan.nextLine();
                        //System.out.println("Escriu el nom del recurs:");
                        nom_recurs = scan.nextLine();
                        cp.baixaNecessitats(nom, nom_recurs);
                        break;

                    case "47":
                        //System.out.println("Escriu el nom del planeta:");
                        String nom1 = scan.nextLine();
                        //System.out.println("Escriu el id del paquet:");
                        String id1 = scan.nextLine();
                        cp.assignarPaquet(nom1,Integer.parseInt(id1));
                        break;
                    case "48":
                        //System.out.println("Escriu el nom del planeta:");
                        nom = scan.nextLine();
                        Iterable<String> itaux = cp.obtenirRecursosDisponibles(nom);
                        for(String a : itaux){
                            System.out.println(a);
                        }
                        break;
                    case "49":
                        //System.out.println("Escriu el nom del planeta:");
                        nom = scan.nextLine();
                        Iterable<String> itaux2 = cp.obtenirNecessitats(nom);
                        for(String a : itaux2){
                            System.out.println(a);
                        }
                        break;

                    case "50":
                       // System.out.println("Introduir nom del fitxer");
                        nom = scan.nextLine();
                        cp.guardarPlanetes(nom);
                        break;

                    case "51":
                        //System.out.println("Introduir nom del fitxer");
                        nom = scan.nextLine();
                        cp.carregarPlanetes(nom);
                        break;
                    case "52":
                        //System.out.println("Escriu el nom del planeta:");
                        nom = scan.nextLine();
                        cp.desassignarPaquet(nom);
                        break;
                    case "61":
                        cpa = new Controlador_Domini_Paquet(cr);
                        break;   
                    case "62":
                        cpa.altaPaquet();
                        break;                        
                    case "63":
                        //System.out.println("Introduir id");
                        num = scan.nextLine();
                        cpa.baixaPaquet(Integer.parseInt(num));
                        break;                        
                    case "64":
                        //System.out.println("Introduir id");
                        num = scan.nextLine();
                        //System.out.println("Introduir nom del recurs");
                        nom = scan.nextLine();
                        cpa.assignarRecurs(Integer.parseInt(num),nom);
                        break;                        
                    case "65":
                        //System.out.println("Introduir id");
                        num = scan.nextLine();
                        //System.out.println("Introduir nom del recurs");
                        nom = scan.nextLine();
                        cpa.esborrarRecurs(Integer.parseInt(num),nom);
                        break;                        
                    case "66":
                        //System.out.println("Introduir id");
                        num = scan.nextLine();
                        pa = cpa.obtenirPaquet(Integer.parseInt(num));
                        System.out.println(Integer.toString(pa.obtenirId()));
                        break;                        
                    case "67":
                        //System.out.println("Introduir id");
                        num = scan.nextLine();
                        pa = cpa.obtenirPaquetAssignar(Integer.parseInt(num));
                        break;                        
                    case "68":
                        System.out.println(cpa.llistatPaquetsAssignats());
                        break;                        
                    case "69":
                        System.out.println(cpa.llistatPaquetsNoAssignats());
                        break;                        
                    case "70":
                        //System.out.println("Introduir id");
                        num = scan.nextLine();
                        System.out.println(cpa.llistatRecursosPaquet(Integer.parseInt(num)));
                        break;                        
                    case "71":
                        //System.out.println("Introduir nom del fitxer");
                        nom = scan.nextLine();
                        cpa.carregarPaquets(nom);
                        break;                        
                    case "72":
                        //System.out.println("Introduir nom del fitxer");
                        nom = scan.nextLine();
                        cpa.guardarPaquets(nom);
                        break;                        
                    case "73":
                        num = scan.nextLine();
                        cpa.desassignarPaquet(Integer.parseInt(num));
                        break;                        
                    case "74":
                        num = scan.nextLine();
                        pa = cpa.obtenirPaquet(Integer.parseInt(num));
                        Iterable<String> s = cpa.llistatRecursosPaquetIterator(pa);
                        String aux = new String();
                        for(String a : s) System.out.println(a);
                        break;                        
                    case "75":
                        num = scan.nextLine();
                        pa = cpa.obtenirPaquet(Integer.parseInt(num));
                        System.out.println(cpa.obtenirIdPaquet(pa));
                        break;                        
                    case "81":
                        cr = new Controlador_Domini_Recurs();
                        break;                        
                    case "82":
                        nom = scan.nextLine();
                        cr.altaRecurs(nom);
                        break;                        
                    case "83":
                        nom = scan.nextLine();
                        cr.baixaRecurs(nom);
                        break;                        
                    case "84":
                        nom = scan.nextLine();
                        new_nom = scan.nextLine();
                        cr.modificarNom(nom,new_nom);
                        break;                        
                    case "85":
                        nom = scan.nextLine();
                        cr.obtenirRecurs(nom);
                        break;                        
                    case "86":
                        nom = scan.nextLine();
                        System.out.println(cr.obtenirId(nom));
                        break;                        
                    case "87":
                        System.out.println(cr.llistatRecurs());
                        break;
                        
                    default:
                        System.out.println("Opció no valida.");
                        break;
                }
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
            finally{
                //S'executa SEMPRE.
            }
        }
        scan.close();
    }
    
}