import java.util.*;
import java.io.IOException;
/**
 *
 *Driver Controlador Domini Classe Recurs
 *
 *@author Jordi Vilella
 */
public class Driver_Controlador_Dades_Planeta{
    
    private static Controlador_Dades_Planeta t;
    
    public static void menu() {
        System.out.println("Escolllir opción:");
        System.out.println("\t 00) Salida.");
        System.out.println("\t 01) public Controlador_Dades_Planeta().");
        System.out.println("\t 02) public ArrayList<String> readTextFile(String nomFitxer).");
        System.out.println("\t 03) public void writeTextFile(String nomFitxer).");
    }
    
    public static void main(String[] args) {
        String nombreClase = "Controlador_Dades_Planeta";
        System.out.println("Driver "+nombreClase);
        Scanner scan = new Scanner(System.in);
        ArrayList<String> a = new ArrayList<String>();
        boolean out = false;
        t = new Controlador_Dades_Planeta();
        menu();
        
        while(!out){
            try{
                String op = scan.nextLine();
                switch (op) {
                    case "01":
                        
                         t = new Controlador_Dades_Planeta();
                        break;
                        
                    case "02":
                        op = scan.nextLine();
                        a = t.readTextFile(op);
                        break;
                        
                    case "03":
                        op = scan.nextLine();
                        t.writeTextFile(op, a);
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