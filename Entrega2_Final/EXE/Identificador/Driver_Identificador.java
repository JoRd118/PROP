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
        System.out.println("\t 02) public int idRecurs().");
        System.out.println("\t 03) public int idPaquet().");
        System.out.println("\t 04) public int idPlaneta().");
        System.out.println("\t 05) public int idUnivers().");
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
                        System.out.println(i.idRecurs());
                        break;
                    case "03":
                        System.out.println(i.idPaquet());
                        break;
                    case "04":
                        System.out.println(i.idPlaneta());
                        break;
                    case "05":
                        System.out.println(i.idUnivers());
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