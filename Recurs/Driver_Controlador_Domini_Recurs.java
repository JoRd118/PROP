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
    
    public static void menu() {
        System.out.println("Escoge una opción:");
        System.out.println("\t 00) Salida.");
        System.out.println("\t 01) public Controlador_Domini_Recurs().");
        System.out.println("\t 02) public void altaRecurs(String nom).");
        System.out.println("\t 03) public void baixaRecurs(String nom).");
        System.out.println("\t 04) public void modificarNom(String nom, String new_nom).");
        System.out.println("\t 05) public Recurs obtenirRecurs(String nom).");
        System.out.println("\t 06) public int obtenirId(String nom).");
        System.out.println("\t 07) (OPTION DOWN) public String obtenirNom(int id).");
        System.out.println("\t 08) public String llistatRecurs().");
    }
    
    public static void main(String[] args) {
        String nombreClase = "Recurs";
        System.out.println("Driver "+nombreClase);
        Scanner scan = new Scanner(System.in);
        boolean out = false;
        String nom;
        
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
                        r.obtenirRecurs(nom);
                        break;
                        
                    case "06":
                        nom = scan.nextLine();
                        System.out.println(r.obtenirId(nom));
                        break;
                        
                   /* case "07":
                        nom = scan.nextLine();
                        int foo = Integer.parseInt(nom);
                        System.out.println(r.obtenirNom(foo));
                        break;
                     */
                    case "08":
                        System.out.println(r.llistatRecurs());
                        break;
                        
                    case "00":
                        out = true;
                        break;
                        
                    default:
                        out = true;
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