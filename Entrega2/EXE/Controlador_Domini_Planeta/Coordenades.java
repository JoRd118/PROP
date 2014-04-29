/**
 *
 * @author Oriolbv
 */
public class Coordenades {
    public int x;
    public int y;
    
    // pre: -
    // post: Es creen unes coordenades per defecte  
    public Coordenades() {
        x = 0;
        y = 0;
    }

    // pre: -
    // post: Es creen unes coordenades x i y
    public Coordenades(int x, int y) {
       this.x = x;
       this.y = y;
    }

    // pre: -
    // post: Retorna la coordenada x d'unes coordenades
    public int obtenirCoordenadesX() {
        return x;
    }    

    // pre: -
    // post: Retorna la coordenada y d'unes coordenades
    public int obtenirCoordenadesY() {
        return y;
    }   

    // pre: -
    // post: Modifica les coordenades per x i y
    public void modificarCoordenades(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
