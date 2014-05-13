import java.util.*;
import java.io.IOException;

public class Driver_Coordenades{
    
    private static Coordenades c;
    
    public static void menu() {
        System.out.println("Escoge una opción:");
        System.out.println("\t 00) Salida.");
        System.out.println("\t 01) public Coordenades().");
        System.out.println("\t 02) public Coordenades(int x, int y).");
        System.out.println("\t 03) public int obtenirCoordenadesX().");
        System.out.println("\t 04) public int obtenirCoordenadesY().");
        System.out.println("\t 05) public modificarCoordenades(int x, int y).");
    }
public static void main(String[] args) {
        System.out.println("Driver Coordenades");
        Scanner scan = new Scanner(System.in);
        boolean out = false;

        menu();

        String x, y;
        int coordx, coordy;

        while(!out){
            try{
                String op = scan.nextLine();
                switch (op) {
                        
                    case "01":
                        c = new Coordenades();
                        break;
                    case "02":
                        x = scan.nextLine();
                        coordx = Integer.parseInt(x);
                        y = scan.nextLine();
                        coordy = Integer.parseInt(y);
                        c = new Coordenades(coordx, coordy);
                        break;
                    case "03":
                        coordx = c.obtenirCoordenadesX();
                        System.out.println(coordx);
                        break;
                    case "04":
                        coordy = c.obtenirCoordenadesY();
                        System.out.println(coordy);
                        break;
                    case "05":
                        x = scan.nextLine();
                        coordx = Integer.parseInt(x);
                        y = scan.nextLine();
                        coordy = Integer.parseInt(y);
                        c.modificarCoordenades(coordx, coordy);
                        break;
                    case "00":
                        out = true;
                        break;
                        
                    default:
                        System.out.println("Opció incorrecte.");
                        break;
                }
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scan.close();
    }
}
