import java.util.*;
import java.text.DecimalFormat;
import java.io.IOException;
import java.io.Console;

public class Controlador_Presentacio_QAP{
   
    private Controlador_Domini_QAP cq;
    private Controlador_Presentacio cp;
    private VistaQAP v;
    
   
    
    public Controlador_Presentacio_QAP(Controlador_Presentacio_Recurs nou_cdr, Controlador_Presentacio_Univers nou_cdu, Controlador_Presentacio p){
        cp = p;
        cq = new Controlador_Domini_QAP(nou_cdr.getCont(), nou_cdu.getCont());
        v = new VistaQAP(this);
    }
    
    public Controlador_Domini_QAP getCont(){
        return cq;
    }
    
    public void modificarValorDistancies(int i, int j, double valor) throws IOException{
        cq.modificarValorDistancies(i,j,valor);
    }

    public void modificarValorNecessitats(int i, int j, int valor) throws IOException{
        cq.modificarValorNecessitats(i,j,valor);
    }

    public void modificarValorRecursos(int i, int j, int valor) throws IOException{
        cq.modificarValorRecursos(i,j,valor);
    }

    public String obtenirMatDis() throws IOException{
        return cq.obtenirMatDis();
    }
    public String obtenirMatNec() throws IOException{
        return cq.obtenirMatNec();
    }
    public String obtenirMatRec() throws IOException{
        return cq.obtenirMatRec();
    }
    public String obtenirRecu() throws IOException{
        return cq.obtenirRecu();
    }
    public String obtenirPlan() throws IOException{
        return cq.obtenirPlan();
    }
    public void afegirMatrius(String dist, String nec, String rec, String p, String r) {
        cq.afegirMatrius(dist,nec,rec,p,r);
    }

    public void calcularMatrius(String nom_u){
        cq.calcularMatrius(nom_u);
    }

    public String solucioSeguent() throws IOException{
        return cq.solucioSeguent();
    }

    public String solucioAnterior() throws IOException{
        return cq.solucioAnterior();
    }

    public String printTemps() throws IOException{
        return cq.printTemps();
    }

    public String solucioAll() throws IOException{
        return cq.solucioAll();
    }
    
    public void run_algorithm(String algorithm) throws IOException{
        cq.run_algorithm(algorithm);
    }
    

    public void guardar_solucioQAP(String nomFitxer)throws IOException{
        cq.guardar_solucioQAP(nomFitxer);
    }
    
    
}