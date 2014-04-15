import java.util.*;
import java.io.IOException;
/**
 *
 *Driver Controlador Domini Classe Recurs
 *
 *@author Claudi
 */
public class Controlador_Domini_Solucio{
    
    private Solucio s;
    
    public Controlador_Domini_Solucio(){
        Solucio s = new Solucio();
        this.s = s;
    }
    public Controlador_Domini_Solucio(double m, ArrayList<String> a){
        Solucio s = new Solucio(m, a);
        this.s = s;
    }
    
    public void set_R(double m){
        s.set_millorRecorregut(m);
    }
    
    public void set_S(ArrayList<String> a){
        s.set_millorSolucio(a);
    }
    
    public void modificar_R(double m){
        s.modificar_millorRecorregut(m);
    }
    
    public void modificar_S(ArrayList<String> a){
        s.modificar_millorSolucio(a);
    }
    
    public String printAll(){
      return  s.printsolucio();
    }
    
}