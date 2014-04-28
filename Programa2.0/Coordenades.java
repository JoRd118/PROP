/**
 *
 * @author Oriolbv
 */
public class Coordenades {
    public int x;
    public int y;
    
  
    public Coordenades() {
        x = 0;
        y = 0;
    }
    public Coordenades(int x, int y) {
       this.x = x;
       this.y = y;
    }

    public int obtenirCoordenadesX() {
        return x;
    }    

    public int obtenirCoordenadesY() {
        return y;
    }   

    public void modificarCoordenades(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
