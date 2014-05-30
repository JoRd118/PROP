import java.util.*;
import java.text.DecimalFormat;
import java.io.IOException;
import java.io.Console;

public class Controlador_Domini_QAP{
    private Solucio solucio;
    private Entrada e;
    private QAP q;
    private Controlador_Dades t;
    private Controlador_Domini_Univers cdu;
    private Controlador_Domini_Recurs cdr;
    private Controlador_Presentacio cp;
    private boolean entrada_val;
    private static String msg_entrada = "Error QAP: L'entrda no s'ha introduit o no s'ha calculat abans de l'algoritme.";
    
    private VistaQAP v;
    
    public Controlador_Domini_QAP(){
        e = new Entrada();
        t = new Controlador_Dades();
        solucio = new Solucio();
        q = new QAP();
        cdr = new Controlador_Domini_Recurs();
        cdu = new Controlador_Domini_Univers();
        entrada_val = false;
    }
    
    public Controlador_Domini_QAP(Controlador_Domini_Recurs nou_cdr, Controlador_Domini_Univers nou_cdu){
        e = new Entrada();
        t = new Controlador_Dades();
        solucio = new Solucio();
        q = new QAP();
        cdu = nou_cdu;
        cdr = nou_cdr;
        entrada_val = false;
    }
    
    public Controlador_Domini_QAP(Controlador_Domini_Recurs nou_cdr, Controlador_Domini_Univers nou_cdu, Controlador_Presentacio p){
        e = new Entrada();
        t = new Controlador_Dades();
        solucio = new Solucio();
        q = new QAP();
        cdu = nou_cdu;
        cdr = nou_cdr;
        cp = p;
        entrada_val = false;
        v = new VistaQAP(this);
    }

    public void modificarValorDistancies(int i, int j, double valor) {
        if (entrada_val) {
        e.modificarPosDis(i, j, valor);
        }
        else throw new IllegalArgumentException(msg_entrada);
    }

    public void modificarValorNecessitats(int i, int j, int valor) {
        if (entrada_val) {
        e.modificarPosNecPlaneta(i, j, valor);
        }
        else throw new IllegalArgumentException(msg_entrada);
    }

    public void modificarValorRecursos(int i, int j, int valor) {
        if (entrada_val) {
        e.modificarPosRecPlaneta(i, j, valor);
        }
        else throw new IllegalArgumentException(msg_entrada);
    }

    public String obtenirMatDis() {
        if (entrada_val) {
        return e.obtenirMatriuDisString();
        }
        else throw new IllegalArgumentException(msg_entrada);
    }
    public String obtenirMatNec() {
        if (entrada_val) {
        return e.obtenirMatriuNecString();
        }
        else throw new IllegalArgumentException(msg_entrada);
    }
    public String obtenirMatRec() {
        if (entrada_val) {
        return e.obtenirMatriuRecString();
        }
        else throw new IllegalArgumentException(msg_entrada);
    }
    public String obtenirRecu() {
        if (entrada_val) {
        return e.obtenirRecursosString();
        }
        else throw new IllegalArgumentException(msg_entrada);
    }
    public String obtenirPlan() {
        if (entrada_val) {
        return e.obtenirPlanetesString();
        }
        else throw new IllegalArgumentException(msg_entrada);
    }
    public void afegirMatrius(String dist, String nec, String rec, String p, String r) {
        e.modificarMatriusString(dist, nec, rec, p, r);
        entrada_val = true;
    }

    public void calcularMatrius(String nom_u){
        entrada_val = true;
        String[] recu = new String[cdr.totalRecursos()];
        Iterable<String> s = cdr.llistatRecurs_2();
        String aux = new String();
        int i = 0;
        for (String a : s) {
            recu[i] = a;
            ++i;
        }
        e.modificarMatrius(cdu.matriuDistanciaPlanetes(nom_u), cdu.matriuNecesitatsPlanetes(nom_u), cdu.matriuRecursosPlanetes(nom_u), cdu.vectorPlanetes(nom_u), recu);  
    }

    public String solucioSeguent() {
        return solucio.printSolucioSeguent();
    }

    public String solucioAnterior() {
        return solucio.printSolucioAnterior();
    }

    public String printTemps() {
        return Long.toString(solucio.obtenirTemps());
    }

    public String solucioAll() {
        return solucio.printSolucio();
    }
    
    public void run_algorithm(String algorithm) throws IOException{
        if (entrada_val) {
            solucio = new Solucio();
            solucio.afegirEntrada(e.obtenirMatrius());
            q.run_algorithm(e,solucio,algorithm);
            solucio.printSolucio();
        }
        else throw new IllegalArgumentException(msg_entrada);
    }
    

    public void guardar_solucioQAP(String nomFitxer)throws IOException{
        String sol_text1 = new String();
        t.obrirFitxer(nomFitxer);
        t.deleteFile();
        t.writeTextFile(solucio.printSolucio());
        t.tancarFitxer();
    }
    
    
}