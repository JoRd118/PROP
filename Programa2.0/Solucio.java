import java.util.*;
import java.io.IOException;
/*
 *
 *Class Solucio
 *
 *@author Claudi
 */
public class Solucio{
    private static double millorRecorregut;
    private static ArrayList<String> millorSolucio;
    
    private static double m_millorRecorregut;
    private static boolean f_millorRecorregut = false;
    
    private static ArrayList<String> m_millorSolucio;
    private static boolean f_millorSolucio = false;
    
    public Solucio(){}
    
    public Solucio(double m, ArrayList<String> a){
        millorRecorregut = m;
        millorSolucio = a;
    }
    
    public void set_millorRecorregut(double m){
        millorRecorregut = m;
    }
    
    public void set_millorSolucio(ArrayList<String> a){
        millorSolucio = a;
    }
    
    public void modificar_millorRecorregut(double m){
        m_millorRecorregut = m;
        f_millorRecorregut = true;
    }
    
    public void modificar_millorSolucio(ArrayList<String> a){
        m_millorSolucio = a;
        f_millorSolucio = true;
    }
    
    public String printsolucio(){
        String sol = "Millor Recoregut = "+millorRecorregut + "\n" + "Recorregut: \n";
        for(int i = 0; i < millorSolucio.size(); ++i){
            sol = sol + millorSolucio.get(i) + " ";
        }
        sol = sol +"\n";
        if(f_millorRecorregut || f_millorSolucio){
            sol = sol + "Modificacions: \n";
            
            if(f_millorRecorregut){
                sol = sol + "Millor Recoregut [Modificacio] = "+m_millorRecorregut + "\n";
            }
            if(f_millorRecorregut){
                sol = sol + "Recorregut [Modificacio]: \n";
                for(int i = 0; i < m_millorSolucio.size(); ++i){
                    sol = sol + m_millorSolucio.get(i) + " ";
                }
                sol = sol + "\n";
            }
        }
        return sol;
    }
}