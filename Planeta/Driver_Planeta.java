import java.util.*;
import java.io.IOException;

public class Driver_Planeta{
    
    private static Planeta p;
    
    public static void menu() {
        System.out.println("Escoge una opción:");
        System.out.println("\t 00) Salida.");
        System.out.println("\t 01) public Planeta().");
        System.out.println("\t 02) public obtenirId().");
        System.out.println("\t 03) public obtenirNom().");
        System.out.println("\t 04) public obtenirCoordenades().");
        System.out.println("\t 05) public obtenirClasse().");
        System.out.println("\t 06) public modificacioNom(String nomPlaneta).");
        System.out.println("\t 07) public modificacioCoordenades(int x, int y).");
        System.out.println("\t 08) public modificacioClasse(boolean classeM).");
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
                        
                    case "01":      // public Planeta()
                        p = new Planeta();
                        Coordenades c = new Coordenades();
                        break;
                        
                    case "02":      // public obtenirId()
                        System.out.println(p.obtenirId());
                        // String nom = scan.nextLine();
                        // r = new Recurs(nom);
                        // break;
                        
                    case "03":      // public obtenirNom()
                        System.out.println(p.obtenirNom());
                        break;
                    case "04":      // public obtenirCoordenades()
                        c = p.obtenirCoordenades();
                        System.out.println(c.obtenirCoordenadesX());
                        System.out.println(c.obtenirCoordenadesY());
                        break;
                        
                    case "05":      // public obtenirClasse()
                        if (p.obtenirClasse() == true) {
                            System.out.println("És de classe M");
                        } else {
                            System.out.println("No és de classe M");
                        }
                        break;
                    case "06":      // public modificacioNom(String nomPlaneta)
                        String nom = scan.nextLine();
                        p.modificacioNom(nom);
                        break;
                    case "07":      // public modificacioCoordenades(int x, int y)
                        String x = scan.nextLine();
                        int Eix_x = Integer.parseInt(x); 
                        String y = scan.nextLine();
                        int Eix_y = Integer.parseInt(y);
                        p.modificacioCoordenades(Eix_x, Eix_y);
                        break;
                    case "08":      // public modificacioClasse(boolean classeM)
                        System.out.println("El planeta es de classe M ??");
                        String resposta = scan.nextLine();
                        boolean classe;
                        String Si = "Si";
                        if (Si.equals(resposta)) classe = true;
                        else classe = false;
                        p.modificacioClasse(classe);
                        break;
                    case "00":
                        out = true;
                        break;
                        
                    default:
                        out = true;
                        break;
                }
            }catch (Exception e) {
                //System.out.println(e.getMessage());
            }
        }
        scan.close();
    }
}