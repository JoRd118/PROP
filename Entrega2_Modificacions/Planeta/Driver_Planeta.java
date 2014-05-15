import java.util.*;
import java.io.IOException;

public class Driver_Planeta{
    
    private static Planeta p;
    private static Coordenades c;
    private static Recurs r;
    private static Paquet pq;
    
    public static void menu() {
        System.out.println("Escoge una opción:");
        System.out.println("\t 00) Salida.");
        System.out.println("\t 01) public Planeta(int i).");
        System.out.println("\t 02) public Planeta(String nom, int i, Coordenades c, boolean classe).");
        System.out.println("\t 03) public obtenirId().");
        System.out.println("\t 04) public obtenirNom().");
        System.out.println("\t 05) public obtenirCoordenades().");
        System.out.println("\t 06) public obtenirClasse().");
        System.out.println("\t 07) public modificacioNom(String nomPlaneta).");
        System.out.println("\t 08) public modificacioCoordenades(int x, int y).");
        System.out.println("\t 09) public modificacioClasse(boolean classeM).");
        System.out.println("\t 10) public void afegirNecessitat(Recurs r).");
        System.out.println("\t 11) public void eliminarNecessitat(String nomR).");
        System.out.println("\t 12) public void assignarPaquet(Paquet pq).");
        System.out.println("\t 13) public void desassignarPaquet().");
        System.out.println("\t 14) public Paquet obtenirPaquet().");
        System.out.println("\t 15) public TST<Recurs> obtenirNecessitats().");
        
        
    }
    
    public static void main(String[] args) {
        System.out.println("Driver Planeta");
        Scanner scan = new Scanner(System.in);
        boolean out = false;
        String nomR;
        int i;
        Iterable<String> Nec;
        pq = new Paquet();
        
        menu();
        
        while(!out){
            try{
                String op = scan.nextLine();
                switch (op) {
                        
                    case "01":
                        op = scan.nextLine();
                        int i1 = Integer.parseInt(op);
                        p = new Planeta(i1);
                        break;
                        
                    case "02":
                        String name,coordX,coordY,classM;
                        name = scan.nextLine();
                        String i3 = scan.nextLine();
                        coordX = scan.nextLine();
                        coordY = scan.nextLine();
                        classM = scan.nextLine();//Yes - No
                        int cx = Integer.parseInt(coordX);
                        int cy = Integer.parseInt(coordY);
                        int i2 = Integer.parseInt(i3);
                        c = new Coordenades(cx, cy);
                        if(classM.equals("Yes")) p = new Planeta(name, i2, c, true);
                        else{
                            p = new Planeta(name, i2, c, false);
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
                    case "10":  // public void afegirNecessitat(Recurs r)
                        nomR = scan.nextLine();
                        String idraux = scan.nextLine();
                        int idr = Integer.parseInt(idraux);
                        r = new Recurs(nomR, idr);
                        p.afegirNecessitat(r);
                        break;
                    case "11":  // public void eliminarNecessitat(String nomR)
                        nomR = scan.nextLine();
                        p.eliminarNecessitat(nomR);
                        break;
                    case "12":  // public void assignarPaquet(Paquet pq)
                        p.assignarPaquet(pq);
                        break;
                    case "13":  // public void desassignarPaquet()
                        p.desassignarPaquet();
                        break;
                    case "14":  // public Paquet obtenirPaquet()
                        pq = p.obtenirPaquet();
                        int identi = pq.obtenirId();
                        System.out.println("Paquet del planeta:");
                        System.out.println(identi);
                        break;
                    case "15":  // public TST<Recurs> obtenirNecessitats()
                        System.out.println("Llistat Necessitats:");
                        TST<Recurs> aux = p.obtenirNecessitats();
                        Nec = aux.obtainAllTST();
                        for(String s : Nec){
                            System.out.println(s);
                        }
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