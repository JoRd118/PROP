import java.util.*;
import java.io.IOException;
/**
 *
 *Driver Controlador Domini Classe Recurs
 *
 *@author Claudi
 */
public class Driver_Controlador_Dades_Recurs{

    private static Controlador_Dades_Recurs t;
    private static Controlador_Domini_Recurs r;

    public static void menu() {
        System.out.println("Escoge una opción:");
        System.out.println("\t 00) Salida.");
        System.out.println("\t 01) public Controlador_Domini_Recurs().");
        System.out.println("\t 02) public void altaRecurs(String nom).");
        System.out.println("\t 03) public void baixaRecurs(String nom).");
        System.out.println("\t 04) public String llistatRecurs().");
        System.out.println("\t 05) public void carregarRecursos(String nomFitxer).");
        System.out.println("\t 06) public void guardarRecursos(String nomFitxer).");
        System.out.println("\t 07) .");
        System.out.println("\t 08) .");
    }

    public static void main(String[] args) {
        String nombreClase = "Recurs";
        System.out.println("Driver "+nombreClase);
        Scanner scan = new Scanner(System.in);
        boolean out = false;
        String nom;
        t = new Controlador_Dades_Recurs();
        menu();

        while(!out){
            try{
                String op = scan.nextLine();
                switch (op) {
                    case "01":
                        r = new Controlador_Domini_Recurs(t);
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
                        System.out.println(r.llistatRecurs());
                        break;
                        
                    case "05":
                        nom = scan.nextLine();
                        r.carregarRecursos(nom);
                        break;
                        
                    case "06":
                        nom = scan.nextLine();
                        r.guardarRecursos(nom);
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