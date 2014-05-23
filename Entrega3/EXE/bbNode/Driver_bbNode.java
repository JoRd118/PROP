import java.util.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.IOException;
/**
 *
 *Driver Classe bbNode
 *
 *@author Claudi
 */
public class Driver_bbNode{
    
    private static bbNode n;
    
    public static void menu() {
        System.out.println("Escollir opció:");
        System.out.println("\t 00) Salida.");
        System.out.println("\t 01) public bbNode().");
        System.out.println("\t 02) public bbNode(int idnode, int idnodepare, int idplaneta, boolean essolucio, boolean descartat, int nivell, double recorregut, double cotarestant, int ordreprimer, double ordresegon, ArrayList<Integer> cami, ArrayList<Integer> necessitatspendents, ArrayList<Integer> planetespendents, ArbreNode arbrenode)");
        System.out.println("\t 03) public int obtenirIdNode().");
        System.out.println("\t 04) public int obtenirIdNodePare().");
        System.out.println("\t 05) public int obtenirIdPlaneta().");
        System.out.println("\t 06) public boolean obtenirEsSolucio().");
        System.out.println("\t 07) public boolean obtenirDescartat().");
        System.out.println("\t 08) public int obtenirNivell().");
        System.out.println("\t 09) public double obtenirRecorregut().");
        System.out.println("\t 10) public double obtenirCotaRestant().");
        System.out.println("\t 11) public int obtenirOrdrePrimer().");
        System.out.println("\t 12) public double obtenirOrdreSegon().");
        System.out.println("\t 13) public ArrayList<Integer> obtenirCami().");
        System.out.println("\t 14) public ArrayList<Integer> obtenirNecessitatsPendents()");
        System.out.println("\t 15) public ArrayList<Integer> obtenirPlanetesPendents()");
        System.out.println("\t 16) public ArbreNode obtenirArbreNode().");
        System.out.println("\t 17) public void modificarIdNode(int idnode).");
        System.out.println("\t 18) public void modificarCotaRestant(double cotarestant).");
        System.out.println("\t 19) public void modificarOrdreSegon(double ordresegon).");
        System.out.println("\t 20) public void modificarDescartat(boolean descartat)");
    }
    
    public static void main(String[] args) {
        String nombreClase = "bbNode";
        System.out.println("Driver "+nombreClase);
        Scanner scan = new Scanner(System.in);
        boolean out = false;
        boolean create = false;
        double value;
        String new_name;
        String nomplan;
        String compan;
        String idnan;
        int i = 0;
        menu();
        while(!out){
            try{
                String op = scan.nextLine();
                switch (op) {
                        
                    case "00":
                        out = true;
                        break;
                        
                    case "01":
                        n = new bbNode();
                        create = true;
                        break;
                        
                    case "02":
                        new_name = scan.nextLine();
                        int idnode = Integer.parseInt(new_name);
                        
                        new_name = scan.nextLine();
                        int idnodepare = Integer.parseInt(new_name);
                        
                        new_name = scan.nextLine();
                        int idplaneta = Integer.parseInt(new_name);
                        
                        new_name = scan.nextLine();
                        boolean essolucio = false;
                        if(new_name.equals("True")) essolucio = true;
                        else if(new_name.equals("False")) essolucio = false;
                        
                        new_name = scan.nextLine();
                        boolean descartat = false;
                        if(new_name.equals("True")) descartat = true;
                        else if(new_name.equals("False")) descartat = false;
                        
                        new_name = scan.nextLine();
                        int nivell = Integer.parseInt(new_name);
                        
                        new_name = scan.nextLine();
                        double recorregut = Double.parseDouble(new_name);
                        
                        
                        new_name = scan.nextLine();
                        double cotarestant = Double.parseDouble(new_name);
                        
                        
                        new_name = scan.nextLine();
                        int ordreprimer = Integer.parseInt(new_name);
                        
                        
                        new_name = scan.nextLine();
                        double ordresegon = Double.parseDouble(new_name);
                        
                        
                        new_name = scan.nextLine();
                        int camiSize = Integer.parseInt(new_name);
                        ArrayList<Integer> cami = new ArrayList<Integer>();
                        for(int i5 = 0; i5 < camiSize; i5++){
                            new_name = scan.nextLine();
                            cami.add(Integer.parseInt(new_name));
                        }
                        
                        new_name = scan.nextLine();
                        int necessitatspendentsSize = Integer.parseInt(new_name);
                        ArrayList<Integer> necessitatspendents = new ArrayList<Integer>();
                        for(int i6 = 0; i6 < necessitatspendentsSize; i6++){
                            new_name = scan.nextLine();
                            necessitatspendents.add(Integer.parseInt(new_name));
                        }
                        
                        
                        new_name = scan.nextLine();
                        int planetespendentsSize = Integer.parseInt(new_name);
                        ArrayList<Integer> planetespendents = new ArrayList<Integer>();
                        for(int i7 = 0; i7 < planetespendentsSize; i7++){
                            new_name = scan.nextLine();
                            planetespendents.add(Integer.parseInt(new_name));
                        }
                        nomplan = scan.nextLine();
                        compan = scan.nextLine();
                        idnan = scan.nextLine();
                        ArbreNode a = new ArbreNode(nomplan, Integer.parseInt(compan), Integer.parseInt(idnan));
                        n = new bbNode(idnode, idnodepare, idplaneta, essolucio, descartat, nivell, recorregut, cotarestant, ordreprimer, ordresegon, cami, necessitatspendents, planetespendents, a);
                        create = true;
                        
                        break;
                        
                    case "03":
                        if(create){
                            //String new_name = scan.nextLine();
                            System.out.println(n.obtenirIdNode());
                        }
                        else{System.out.println("Cap bbNode creat");}
                        break;
                        
                    case "04":
                        if(create){
                            System.out.println(n.obtenirIdNodePare());
                        }
                        else{System.out.println("Cap bbNode creat");}
                        break;
                        
                    case "05":
                        if(create){
                            System.out.println(n.obtenirIdPlaneta());
                        }
                        else{System.out.println("Cap bbNode creat");}
                        break;
                    case "06":
                        if(create){
                            System.out.println(n.obtenirEsSolucio());
                        }
                        else{System.out.println("Cap bbNode creat");}
                        break;
                    case "07":
                        if(create){
                            System.out.println(n.obtenirDescartat());
                        }
                        else{System.out.println("Cap bbNode creat");}
                        break;
                    case "08":
                        if(create){
                            System.out.println(n.obtenirNivell());
                        }
                        else{System.out.println("Cap bbNode creat");}
                        break;
                    case "09":
                        if(create){
                            System.out.println(n.obtenirRecorregut());
                        }
                        else{System.out.println("Cap bbNode creat");}
                        break;
                    case "10":
                        if(create){
                           System.out.println(n.obtenirCotaRestant());
                        }
                        else{System.out.println("Cap bbNode creat");}
                        break;
                    case "11":
                        if(create){
                            System.out.println(n.obtenirOrdrePrimer());
                        }
                        else{System.out.println("Cap bbNode creat");}
                        break;
                    case "12":
                        if(create){
                           System.out.println(n.obtenirOrdreSegon());
                        }
                        else{System.out.println("Cap bbNode creat");}
                        break;
                    case "13":
                        ArrayList<Integer> auxc = n.obtenirCami();
                        String s_cami = new String();
                        for(i = 0; i < auxc.size(); i++){
                            s_cami = s_cami + auxc.get(i) + " ";
                        }
                        System.out.println(s_cami);
                        break;
                    case "14":
                        ArrayList<Integer> a2 = n.obtenirNecessitatsPendents();
                        String s_need = new String();
                        for(i = 0; i < a2.size(); i++){
                            s_need = s_need + a2.get(i) + " ";
                        }
                        System.out.println(s_need);
                        break;
                    case "15":
                        ArrayList<Integer> a3 = n.obtenirPlanetesPendents();
                        String s_planet = new String();
                        for(i = 0; i < a3.size(); i++){
                            s_planet = s_planet + a3.get(i) + " ";
                        }
                        System.out.println(s_planet);
                        break;
                    case "16":
                        if(create) {
                            // String nompla, Integer comp, Integer idn
                            nomplan = scan.nextLine();
                            compan = scan.nextLine();
                            idnan = scan.nextLine();
                            ArbreNode an = new ArbreNode(nomplan, Integer.parseInt(compan), Integer.parseInt(idnan));
                            String s = an.toString();
                            System.out.println(s);
                        } else System.out.println("Cap bbNode creat");
                        break;
                    case "17":
                        new_name = scan.nextLine();
                        int a4 = Integer.parseInt(new_name);
                        n.modificarIdNode(a4);
                        break;
                    case "18":
                        new_name = scan.nextLine();
                        value = Double.parseDouble(new_name);
                        n.modificarCotaRestant(value);
                        break;
                    case "19":
                        new_name = scan.nextLine();
                        value = Double.parseDouble(new_name);
                        n.modificarOrdreSegon(value);
                        break;
                    case "20":
                        new_name = scan.nextLine();
                        if(new_name.equals("True")) n.modificarDescartat(true);
                        else if(new_name.equals("False")) n.modificarDescartat(false);
                        break;
                        
                    default:
                        System.out.println("Opció no valida.");
                        break;
                }
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
            finally{
                //S'executa sempre passi el q passi;
            }
        }
        scan.close();
    }
}