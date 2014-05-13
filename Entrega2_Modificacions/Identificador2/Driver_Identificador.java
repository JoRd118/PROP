import java.util.*;
import java.io.IOException;
/**
 *
 *Driver Classe Identificador
 *
 *@author Claudi
 */
public class Driver_Identificador{

    private static Identificador i;
    
    public static void menu(){
        System.out.println("Escollir opció:");
        System.out.println("\t 00) Salida.");
        System.out.println("\t 01) public Identificador().");
        System.out.println("\t 02) public int id().");
        System.out.println("\t 06) public void reset().");
    }
    public static void main(String[] args) {
        String nombreClase = "Identificador";
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
                        i = new Identificador();
                        create = true;
                        break;
                    case "02":
                        System.out.println(i.id());
                        break;
                    case "06":
                       i.reset();
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