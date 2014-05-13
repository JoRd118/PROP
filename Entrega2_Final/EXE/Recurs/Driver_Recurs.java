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
        System.out.println("Escollir opció:");
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
        boolean create = false;
        
        menu();
        
        while(!out){
            try{
                String op = scan.nextLine();
                switch (op) {
                        
                    case "00":
                        out = true;
                        break;
                        
                    case "01":
                        r = new Recurs();
                        create = true;
                        break;
                        
                    case "02":
                        String nom = scan.nextLine();
                        r = new Recurs(nom);
                        create = true;
                        break;
                        
                    case "03":
                        if(create){
                            String new_name = scan.nextLine();
                            r.modificarNomRecurs(new_name);
                        }
                        else{System.out.println("Cap recurs creat");}
                        break;
                        
                    case "04":
                        if(create)System.out.println(r.obtenirId());
                        else{System.out.println("Cap recurs creat");}
                        break;
                        
                    case "05":
                        if(create)System.out.println(r.obtenirNom());
                        else{System.out.println("Cap recurs creat");}
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