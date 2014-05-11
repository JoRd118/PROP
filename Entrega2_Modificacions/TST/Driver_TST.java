import java.util.*;
import java.io.IOException;

public class Driver_TST{
    
    private static TST<String> t;
    
    public static void menu() {
        System.out.println("Escollir opció:");
        System.out.println("\t 00) Salida.");
        System.out.println("\t 01) Crea TST<String>.");
        System.out.println("\t 02) public void insert(String s, Value v).");
        System.out.println("\t 03) public Value obtain(String s).");
        System.out.println("\t 04) public boolean contains(String s).");
        System.out.println("\t 05) public Iterable<String> printAllTST().");
        System.out.println("\t 06) public void remove(String s).");
    }
    public static void main(String[] args) {
        String nombreClase = "TST";
        System.out.println("Driver "+nombreClase);
        Scanner scan = new Scanner(System.in);
        boolean out = false;
        String op2;
        menu();
        
        while(!out){
            try{
                String op = scan.nextLine();
                switch (op) {
                    
                    case "00":
                         out = true;
                        break;
                        
                    case "01":
                        t = new TST<String>();
                        break;
                        
                    case "02":
                        op = scan.nextLine();
                        op2 = scan.nextLine();
                        t.insert(op, op2);
                        break;
                        
                    case "03":
                        op = scan.nextLine();
                        if(t.contains(op))System.out.println(op+" value = "+t.obtain(op));
                        else{System.out.println("La clau no esta al TST.");}
                        
                        break;
                        
                    case "04":
                        op = scan.nextLine();
                        if(t.contains(op))System.out.println("yes");
                        else{System.out.println("no");}
                        break;
                        
                    case "05":
                        Iterable<String> s = t.obtainAllTST();
                        for (String a: s) {
                            System.out.println(a);
                        }
                        break;

                    case "06":
                        op = scan.nextLine();
                        t.remove(op);
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