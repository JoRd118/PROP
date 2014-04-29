/**
 *
 * @author Oriolbv
 */
public class Planeta {
   
    // Atributs
    private static int idCounter = 0;
    private int id;
    private String nomPlaneta;
    private Coordenades coord;
    private boolean classeM;

    
    // Constructores
    
    // pre: -
    // post: Es crea un planeta per defecte
    public Planeta() {
        id = idCounter;
        idCounter = idCounter + 1;
        nomPlaneta = "default "+idCounter;
        coord = new Coordenades();
        coord.modificarCoordenades(0, 0);
        classeM = false;
    }
    
    // pre: -
    // post: Es crea un planeta amb nom nom, coordenades c i classe classe.
    public Planeta(String nom, Coordenades c, boolean classe) {
         id = idCounter;
         idCounter = idCounter + 1;
         nomPlaneta = nom;
         coord = new Coordenades();
         int x = c.obtenirCoordenadesX();
         int y = c.obtenirCoordenadesY();
         coord.modificarCoordenades(x, y);
         classeM = classe;
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
    public void modificacioNom(String nomPlaneta) {
        this.nomPlaneta = nomPlaneta;
    }
    
    // pre: -
    // post: Modifica les coordenades del planeta per x i y
    public void modificacioCoordenades(int x, int y) {
        coord.modificarCoordenades(x, y);
    }
    
    // pre: -
    // post: Modifica la classe del planeta per classeM
    public void modificacioClasse(boolean classeM) {
        this.classeM = classeM;
    }
}
