import java.util.*;
import java.io.IOException;
/**
 *
 *Driver Classe Recurs
 *
 *@author Claudi
 */
public class Driver_Recurs{
    
    private static Recurs r;
    
    public static void menu() {
        System.out.println("Escoge una opción:");
        System.out.println("\t 00) Salida.");
        System.out.println("\t 01) public Recurs().");
        System.out.println("\t 02) public Recurs(String nom).");
        System.out.println("\t 03) public void modificarNomRecurs(String new_name).");
        System.out.println("\t 04) public int obtenirId().");
        System.out.println("\t 05) public String obtenirNom().");
    }
    
    public static void main(String[] args) {
        String nombreClase = "Recurs";
        System.out.println("Driver "+nombreClase);
        Scanner scan = new Scanner(System.in);
        boolean out = false;
        
        menu();
        
        while(!out){
            try{
                String op = scan.nextLine();
                switch (op) {
                        
                    case "01":
                        r = new Recurs();
                        break;
                        
                    case "02":
                        String nom = scan.nextLine();
                        r = new Recurs(nom);
                        break;
                        
                    case "03":
                        String new_name = scan.nextLine();
                        r.modificarNomRecurs(new_name);
                        break;
                        
                    case "04":
                        System.out.println(r.obtenirId());
                        break;
                        
                    case "05":
                        System.out.println(r.obtenirNom());
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
                //S'executa sempre passi el q passi;
            }
        }
        scan.close();
    }
}