import java.util.*;
import java.io.IOException;
/**
 *
 *Driver Controlador Dades
 *
 *@author Claudi
 */
public class Driver_Controlador_Dades{
    
    private static Controlador_Dades t;
    
    public static void menu() {
        System.out.println("Escolllir opción:");
        System.out.println("\t 00) Salida.");
        System.out.println("\t 01) public Controlador_Dades_Recurs()");
        System.out.println("\t 02) public void obrirFitxer(String nomFitxer).");
        System.out.println("\t 03) public void tancarFitxer().");
        System.out.println("\t 04) public String readTextFile().");
        System.out.println("\t 05) public void writeTextFile(String aLines).");
        System.out.println("\t 06) public void deleteFile().");
    }
    
    public static void main(String[] args) {
        String nombreClase = "Controlador_Dades";
        System.out.println("Driver "+nombreClase);
        Scanner scan = new Scanner(System.in);
        boolean out = false;
        menu();
        
        while(!out){
            try{
                String op = scan.nextLine();
                switch (op) {
                    case "01":
                        
                        t = new Controlador_Dades();
                        break;
                        
                    case "02":
                        op = scan.nextLine();
                        t.obrirFitxer(op);
                        break;
                        
                    case "03":
                        t.tancarFitxer();
                        break;
                    case "04":
                        System.out.println(t.readTextFile());
                        break;
                    case "05":
                        op = scan.nextLine();
                        t.writeTextFile(op);
                        break;
                    case "06":
                        t.deleteFile();
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