/**
 *
 * @author Oriolbv
 */
public class Planeta {
   
    // Atributs
    private int id;
    private String nomPlaneta;
    private Coordenades coord;
    private boolean classeM;
    private TST<Recurs> Necessitats;
    private Paquet p;
    private static String msg_recurs_repetit = "Error de Recurs: Ja existeix un recurs amb aquest nom.";
    private static String msg_recurs_no_exists = "Error de Recurs: Recurs demanat no existeix.";
        private static String msg_paquet_assginat = "Error de Planeta: Aquest Planeta ja te un Paquet assignat.";
    private static String msg_cap_paquet_assginat = "Error de Planeta: Aquest Planeta no te un Paquet assignat.";
    // Constructores
    
    // pre: -
    // post: Es crea un planeta per defecte
    public Planeta(int i) {
        id = i;
        nomPlaneta = "default "+id;
        coord = new Coordenades();
        coord.modificarCoordenades(0, 0);
        classeM = false;
        Necessitats = new TST<Recurs>();
        p = new Paquet();
        p = null;
        
    }
    
    // pre: -
    // post: Es crea un planeta amb nom nom, coordenades c i classe classe.
    public Planeta(String nom, int i, Coordenades c, boolean classe) {
         id = i;
         nomPlaneta = nom;
         coord = new Coordenades();
         int x = c.obtenirCoordenadesX();
         int y = c.obtenirCoordenadesY();
         coord.modificarCoordenades(x, y);
         classeM = classe;
        Necessitats = new TST<Recurs>();
        p = new Paquet();
        p = null;
    }

    // Consultores

    // pre: -
    // post: Retorna el id del planeta
    public int obtenirId() {
        return id;
    }
    
    // pre: -
    // post: Retrona el nom del planeta
    public String obtenirNom(){
        return nomPlaneta;
    }
    
    // pre: -
    // post: Retorna les coordenades del planeta
    public Coordenades obtenirCoordenades() {
        return coord;
    }
    
    // pre: -
    // post: Retorna la classe del planeta
    public boolean obtenirClasse() {
        return classeM;
    }
    
    // Modificadores

    // pre: -
    // post: Modifica el nom del planeta per nomPlaneta
    public void modificacioNom(String nom) {
        nomPlaneta = nom;
    }
    
    // pre: -
    // post: Modifica les coordenades del planeta per x i y
    public void modificacioCoordenades(int x, int y) {
        coord.modificarCoordenades(x, y);
    }
    
    // pre: -
    // post: Modifica la classe del planeta per classeM
    public void modificacioClasse(boolean classe) {
        classeM = classe;
    }

    // pre: -
    // post: Afegeix una necessitat al planeta
    public void afegirNecessitat(Recurs r) {
        if (Necessitats.contains(r.obtenirNom())) {
            throw new IllegalArgumentException(msg_recurs_repetit);
        }
        else {
             Necessitats.insert(r.obtenirNom(), r);
        }
    }

    // pre: -
    // post : Elimina una necessitat del planeta
    public void eliminarNecessitat(String nomR) {
        if (Necessitats.contains(nomR)) Necessitats.remove(nomR);
        else throw new IllegalArgumentException(msg_recurs_no_exists);
    }

    // pre: -
    // post : Assigna un paquet al planeta
    public void assignarPaquet(Paquet pq) {
        if (p != null) {
            throw new IllegalArgumentException(msg_paquet_assginat);
        } else {
            p = pq;
        }
    }
    public void desassignarPaquet() {
        if (p == null) {
            throw new IllegalArgumentException(msg_cap_paquet_assginat);
        } else {
            p = null;
        }
    }

    public Paquet obtenirPaquet() {
        return p;    
    }

    public TST<Recurs> obtenirNecessitats() {
        return Necessitats;
    }
}
