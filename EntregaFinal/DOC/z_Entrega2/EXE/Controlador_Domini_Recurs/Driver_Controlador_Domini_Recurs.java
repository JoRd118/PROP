import java.util.*;
import java.io.IOException;
/**
 *
 *Driver Controlador Domini Classe Recurs
 *
 *@author Claudi
 */
public class Driver_Controlador_Domini_Recurs{
    
    private static Controlador_Domini_Recurs r;
    private static Controlador_Dades t;
    
    public static void menu() {
        System.out.println("Escollir opció:");
        System.out.println("\t 00) Salida.");
        System.out.println("\t 01) public Controlador_Domini_Recurs().");
        System.out.println("\t 02) public void altaRecurs(String nom).");
        System.out.println("\t 03) public void baixaRecurs(String nom).");
        System.out.println("\t 04) public void modificarNom(String nom, String new_nom).");
        System.out.println("\t 05) public Recurs obtenirRecurs(String nom).");
        System.out.println("\t 06) public int obtenirId(String nom).");
        System.out.println("\t 07) (OPTION DOWN) public String obtenirNom(int id).");
        System.out.println("\t 08) public String llistatRecurs().");
        System.out.println("\t 09) public String llistatRecurs_2().");
        System.out.println("\t 10) public void carregarRecursos(String nomFitxer).");
        System.out.println("\t 11) public void guardarRecursos(String nomFitxer).");
    }
    
    public static void main(String[] args) {
        String nombreClase = "Controlador_Domini_Recurs";
        System.out.println("Driver "+nombreClase);
        Scanner scan = new Scanner(System.in);
        boolean out = false;
        String nom;
        t = new Controlador_Dades();
        
        menu();
        
        while(!out){
            try{
                String op = scan.nextLine();
                switch (op) {
                        
                    case "01":
                        r = new Controlador_Domini_Recurs();
                        break;
                        
                    case "02":
                        nom = scan.nextLine();
                        r.altaRecurs(nom);
                        break;
                        
                    case "03":
                        nom = scan.nextLine();
                        r.baixaRecurs(nom);
                        break;
                        
                    case "04":
                        nom = scan.nextLine();
                        String new_nom = scan.nextLine();
                        r.modificarNom(nom,new_nom);
                        break;
                        
                    case "05":
                        nom = scan.nextLine();
                       Recurs rec = r.obtenirRecurs(nom);
                        System.out.println("NomRecurs:" + rec.obtenirNom() + "\n" + "IdRecurs:" + rec.obtenirId());
                        break;
                        
                    case "06":
                        nom = scan.nextLine();
                        System.out.println(r.obtenirId(nom));
                        break;
                        
                   case "07":                                                    System.out.println("Opció no utilitzada, ni necesaria.");
                        /*nom = scan.nextLine();
                        int foo = Integer.parseInt(nom);
                        System.out.println(r.obtenirNom(foo));*/
                        break;
                        
                    case "08":
                        System.out.println(r.llistatRecurs());
                        break;
                    
                    case "09":
                        System.out.println(r.llistatRecurs_2());
                        break;
                        
                    case "10":
                        nom = scan.nextLine();
                        r.carregarRecursos(nom);
                        break;
                        
                    case "11":
                        nom = scan.nextLine();
                        r.guardarRecursos(nom);
                        break;
                        
                    case "00":
                        out = true;
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