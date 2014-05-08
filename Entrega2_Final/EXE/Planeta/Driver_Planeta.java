import java.util.*;
import java.io.IOException;

public class Driver_Planeta{
    
    private static Planeta p;
    private static Coordenades c;
    
    public static void menu() {
        System.out.println("Escoge una opción:");
        System.out.println("\t 00) Salida.");
        System.out.println("\t 01) public Planeta().");
        System.out.println("\t 02) public Planeta(String nom, Coordenades c, boolean classe).");
        System.out.println("\t 03) public obtenirId().");
        System.out.println("\t 04) public obtenirNom().");
        System.out.println("\t 05) public obtenirCoordenades().");
        System.out.println("\t 06) public obtenirClasse().");
        System.out.println("\t 07) public modificacioNom(String nomPlaneta).");
        System.out.println("\t 08) public modificacioCoordenades(int x, int y).");
        System.out.println("\t 09) public modificacioClasse(boolean classeM).");
    }

    public static void main(String[] args) {
        System.out.println("Driver Planeta");
        Scanner scan = new Scanner(System.in);
        boolean out = false;

        menu();

        while(!out){
            try{
                String op = scan.nextLine();
                switch (op) {
                        
                    case "01":
                        p = new Planeta();
                        break;
                        
                    case "02":
                        String name,coordX,coordY,classM;
                        name = scan.nextLine();
                        coordX = scan.nextLine();
                        coordY = scan.nextLine();
                        classM = scan.nextLine();//Yes - No
                        int cx = Integer.parseInt(coordX);
                        int cy = Integer.parseInt(coordY);
                        c = new Coordenades(cx, cy);
                        if(classM.equals("Yes")) p = new Planeta(name, c, true);
                        else{
                            p = new Planeta(name, c, false);
                        }
                        break;
                        
                    case "03":
                        System.out.println(p.obtenirId());
                        break;
                        
                    case "04":
                        System.out.println(p.obtenirNom());
                        break;
                        
                    case "05":
                        c = p.obtenirCoordenades();
                        System.out.println(c.obtenirCoordenadesX());
                        System.out.println(c.obtenirCoordenadesY());
                        break;
                        
                    case "06":
                        if (p.obtenirClasse() == true) {
                            System.out.println("És de classe M");
                        } else {
                            System.out.println("No és de classe M");
                        }
                        break;
                        
                    case "07":
                        String nom = scan.nextLine();
                        p.modificacioNom(nom);
                        break;
                        
                    case "08":
                        String x = scan.nextLine();
                        int Eix_x = Integer.parseInt(x); 
                        String y = scan.nextLine();
                        int Eix_y = Integer.parseInt(y);
                        p.modificacioCoordenades(Eix_x, Eix_y);
                        break;
                        
                    case "09":
                        String resposta = scan.nextLine();//Yes - No
                        if (resposta.equals("Yes")) p.modificacioClasse(true);
                        else{ p.modificacioClasse(false);}
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