import java.util.*;
import java.io.IOException;
/**
 *
 *Driver Controlador Domini Classe Recurs
 *
 *@author Claudi
 */
public class Controlador_Domini_QAP{
    
    private Controlador_Domini_Univers u;
    private Controlador_Domini_Planeta p;
    private Controlador_Domini_Recurs r;
    private double[][] mDistancies;
    private int[][] mDisponibilitats;
    private int[][] mNecessitats;
    private String[] mPlanetes;
    private String[] mRecursos;
    private String msg_QAP_void_argument = "Error QAP: Argument ha de tenir length > 0.";
    
    
    public Controlador_Domini_QAP(){}
    
    
    public Controlador_Domini_QAP(Controlador_Domini_Univers u, Controlador_Domini_Planeta p, Controlador_Domini_Recurs r){
        this.u = u;
        this.p = p;
        this.r = r;
    }
    
    //Contolador_donini_univers
    public void get_matriu_distancia(String s){
        if (s == null) throw new NullPointerException();
        if (s.length() == 0) throw new IllegalArgumentException(msg_QAP_void_argument);
        mDistancies = u.matriuDistanciaPlanetes(s);
    }
    
    public void get_matriu_disponibilitat(String s){
        if (s == null) throw new NullPointerException();
        if (s.length() == 0) throw new IllegalArgumentException(msg_QAP_void_argument);
        mDisponibilitats = u.matriuRecursosPlanetes(s);
    }
    
    public void get_matriu_necessitats(String s){
        if (s == null) throw new NullPointerException();
        if (s.length() == 0) throw new IllegalArgumentException(msg_QAP_void_argument);
        mNecessitats = u.matriuNecesitatsPlanetes(s);
    }
    
    public void obtenirPlanetes(){
        mPlanetes = p.llistarPlanetesDesassignat_v2();
    
    }
    
    public void obtenirRecursos(){
        mRecursos = r.llistatRecurs_3();
        
    }
    
    public void run_algorithm(String algorithm, String cota){
        if(algorithm.equals("bb")){
            if(cota.equals("e-01")){BranchBoundEager1 b = new BranchBoundEager1(mDistancies,mDisponibilitats, mNecessitats, mPlanetes, mRecursos);
                b.codi();
            }
            else if(cota.equals("e-02")){BranchBoundEager2 b2 = new BranchBoundEager2(mDistancies,mDisponibilitats, mNecessitats, mPlanetes, mRecursos);
                b2.codi();}
            else if(cota.equals("l-01")){BranchBoundLazy1 b = new BranchBoundLazy1(mDistancies,mDisponibilitats, mNecessitats, mPlanetes, mRecursos);
                b.codi();}
            else{BranchBoundLazy2 b2 = new BranchBoundLazy2(mDistancies,mDisponibilitats, mNecessitats, mPlanetes, mRecursos);
                b2.codi();}
        }
        else{
        //Tabu search option
            
        }
    }
}