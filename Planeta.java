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
    
    // Constructora per defecte
    public Planeta() {
        id = idCounter;
        idCounter = idCounter + 1;
        nomPlaneta = "";
        coord = new Coordenades();
        coord.modificarCoordenades(0, 0);
        classeM = false;
    }
    
    // Constructora per copia
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
    
    // Metodes

    // Consultores
    public int obtenirId() {
        return id;
    }
    
    public String obtenirNom(){
        return nomPlaneta;
    }
    
    public Coordenades obtenirCoordenades() {
        return coord;
    }
    
    public boolean obtenirClasse() {
        return classeM;
    }
    
    // Modificadores
    public void modificacioNom(String nomPlaneta) {
        this.nomPlaneta = nomPlaneta;
    }
    
    public void modificacioCoordenades(int x, int y) {
        coord.modificarCoordenades(x, y);
    }
    
    public void modificacioClasse(boolean classeM) {
        this.classeM = classeM;
    }
}
