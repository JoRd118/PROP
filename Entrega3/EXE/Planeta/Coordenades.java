/**
 *
 * @author Oriolbv
 */
public class Coordenades {
    private int x;
    private int y;
    
    // pre: -
    // post: Es creen unes coordenades per defecte  
    public Coordenades() {
        x = 0;
        y = 0;
    }

    // pre: -
    // post: Es creen unes coordenades x i y
    public Coordenades(int eixx, int eixy) {
       x = eixx;
       y = eixy;
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
    public void modificarCoordenades(int eixx, int eixy) {
        x = eixx;
        y = eixy;
    }
}
