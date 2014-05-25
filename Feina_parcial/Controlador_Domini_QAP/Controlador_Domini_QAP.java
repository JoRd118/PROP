import java.util.*;
import java.text.DecimalFormat;
import java.io.IOException;
import java.io.Console;

public class Controlador_Domini_QAP{
    /*
    // private double[][] mDistancies =  { {0.0,1.0,2.0,3.0,4.0},
    // {1.0,0.0,2.0,3.0,4.0},
    // {2.0,2.0,0.0,4.0,1.0},
    // {3.0,3.0,4.0,0.0,1.0},
    // {4.0,4.0,1.0,1.0,0.0}
    // };
    
    // private int[][] mDisponibilitats =  { {1,1,1,1,0,0,1,0,0,0}, //P0
    // {0,0,0,1,0,0,1,0,1,0}, //P1
    // {1,1,0,1,0,0,1,1,1,0}, //P2
    // {0,0,1,1,1,1,0,0,0,1}, //P3
    // {1,0,0,1,0,0,0,0,0,1}  //P4
    // };
    
    
    // private int[][] mNecessitats =      { {0,1,0,0,1,0,0,1,0,0}, //P0
    // {0,0,0,1,0,0,1,0,0,0}, //P1
    // {1,0,1,0,1,0,1,0,1,1}, //P2
    // {0,0,1,0,1,0,0,1,0,0}, //P3
    // {1,1,1,0,1,1,1,0,1,1}  //P4
    // };
    
    // private String[] mPlanetes = {"P0","P1","P2","P3","P4"};
    // private String[] mRecursos = {"r0","r1","r2","r3","r4","r5","r6","r7","r8","r9"};
    /*
     public void run_algorithm(String algorithm, String cota){
     // Preparem dades per calcular la millor solucions per cada planeta
     for(int ipclc = 0;ipclc<mPlanetes.length;ipclc++) {
     //int ipclc = 4;
     if(algorithm == "BBL") {
     BranchBound bb = new BranchBoundLazy();
     SolucioQAP solucions = bb.Calcular(ipclc, mPlanetes, mRecursos, mDistancies, mDisponibilitats, mNecessitats);
     solucions.imprimirSolucio();
     } else if(algorithm == "BBE") {
     BranchBound bb = new BranchBoundEager();
     SolucioQAP solucions = bb.Calcular(ipclc, mPlanetes, mRecursos, mDistancies, mDisponibilitats, mNecessitats);
     solucions.imprimirSolucio();
     } else if(algorithm == "TABU") {
     Tabu tb = new Tabu();
     SolucioQAP solucions = tb.Calcular(ipclc, mPlanetes, mRecursos, mDistancies, mDisponibilitats, mNecessitats);
     //        solucions.imprimirSolucio();
     }
     
     */
    private Solucio solucio;
    private Entrada e;
    private QAP q;
    private Controlador_Dades t;
    private Controlador_Domini_Univers cdu;
    private Controlador_Domini_Recurs cdr;
    //Matrius
    //private double[][] mDistancies;
   // private int[][] mDisponibilitats;
    //private int[][] mNecessitats;
    /*
    // private double [][] mDistancies =  { {0.0,5.0,3.0,10.0},
    // {5.0,0.0,8.0,5.0},
    // {3.0,8.0,0.0,13.0},
    // {10.0,5.0,13.0,0.0}
    // };
    // private int[][]  mNecessitats = {{0,1,0,1,0},
    // {0,1,1,0,0},
    // {1,0,0,0,0},
    // {1,0,0,1,0}
    // };
    // private int[][]  mDisponibilitats = {{1,0,1,0,0},
    // {0,0,1,1,0},
    // {0,0,0,1,0},
    // {0,1,0,0,1}
    // };
    */
    //Vectors
    //private String[] mPlanetes;
   // private String[] mRecursos;
    
    // private String[] mPlanetes = {"A","B","C","E"};
    // private String[]   mRecursos = {"Coure","Diamant", "Metall", "Or", "Plata"};
    
    
    public Controlador_Domini_QAP(){
        e = new Entrada();
    }
    
    public Controlador_Domini_QAP(Controlador_Domini_Recurs nou_cdr, Controlador_Domini_Univers nou_cdu){
        e = new Entrada();
        t = new Controlador_Dades();
        solucio = new Solucio();
        q = new QAP();
        cdu = nou_cdu;
        cdr = nou_cdr;
    }
    
    public void 
    public void modificarValorDistancies(int i, int j, double valor) {
        e.modificarPosDis(i, j, valor);
    }

    public void modificarValorNecessitats(int i, int j, int valor) {
        e.modificarPosNecPlaneta(i, j, valor);
    }

    public void modificarValorRecursos(int i, int j, int valor) {
        e.modificarPosRecPlaneta(i, j, valor);
    }

    public String obtenirMatDis() {
        return e.obtenirMatriuDisString();
    }
    public String obtenirMatNec() {
        return e.obtenirMatriuNecString();
    }
    public String obtenirMatRec() {
        return e.obtenirMatriuRecString();
    }

    public void afegirMatrius(String dist, String nec, String rec, String p, String r) {
        e.modificarMatrius(dist, nec, rec, p, r);
    }

    public void modificarMatrius(String nom_u){
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
    
    public void run_algorithm(String algorithm) throws IOException{
        q.run_algorithm(e,solucio,algorithm);
        solucio.imprimirSolucio();
    }
    
    /*public String printSolucioQAP(){

        String[] mPlanetes = e.obtenirVectorPlan();
        String sol_text1 = new String();
        String sol_text2 = new String();
        sol_text1 = sol_text1 + "SolucioQAP: \nPlanetes: \n";
        //for(int i = 0; i < solucions.size(); ++i){
          //  SolucioQAP solucio = solucions.get(i);
            sol_text1 = sol_text1 + solucio.obtenirPlaneta() + ": ";
            if(solucio.obtenirTerraformat()) sol_text1 = sol_text1 + "Té SolucióQAP" + "\n" +"\t Observacions:"+solucio.obtenirObservacions()+"\n";
             else{sol_text1 = sol_text1 +"No SolucióQAP" + "\n" +"\t Observacions:"+solucio.obtenirObservacions()+"\n";}
            if(solucio.obtenirTerraformat()){
                ArrayList<bbNode> llNodes = solucio.obtenirLlistaNodes();
                if(llNodes != null){
                    if(llNodes.size() >=1){
                        ArrayList<Integer> llMillors = solucio.obtenirLlistaMillors();
                        if(llMillors != null){
                            if(llMillors.size() >= 1){
                                sol_text2 = sol_text2 +"Millor solucio(ns) del planeta " + solucio.obtenirPlaneta() + ": ";
                                for(int i2 = 0; i2 < llMillors.size(); ++i2){
                                    bbNode nn = llNodes.get(llMillors.get(i2));
                                    ArrayList<Integer> cami = nn.obtenirCami();
                                    sol_text2 = sol_text2 + "\n\tSol"+ (i2+1) +") Els planeta(es) ";
                                    for(int i3 = 1; i3 < cami.size(); ++i3){
                                        sol_text2 = sol_text2+ mPlanetes[cami.get(i3)] +", ";
                                    }

                                    sol_text2 = sol_text2 + "envien el su paquet a "+solucio.obtenirPlaneta()+".\n";
                                    sol_text2 = sol_text2 + "\tDistancia de tots els enviament "+ nn.obtenirRecorregut() + "\n"+"\n";
                                }
                                ArrayList<Integer> parcials = solucio.obtenirLlistaParcials();
                                if(parcials != null){
                                    if(parcials.size() >= 1){
                                        sol_text2 = sol_text2 + "\t\tSol. Parcials de " + solucio.obtenirPlaneta();

                                        for(int i4 = 0; i4 < parcials.size(); ++i4){
                                            bbNode nn = llNodes.get(parcials.get(i4));
                                            ArrayList<Integer> cami = nn.obtenirCami();
                                            sol_text2 = sol_text2 + "\n\t\t\tSol"+ (i4+1) +") Els planeta(es) ";
                                            for(int i5 = 1; i5 < cami.size(); ++i5){
                                                sol_text2 = sol_text2+ mPlanetes[cami.get(i5)]+", ";
                                            }
                                            sol_text2 = sol_text2 + "envien el su paquet a "+solucio.obtenirPlaneta()+".\n";
                                        sol_text2 = sol_text2 + "\t\t\tDistancia de tots els enviament "+ nn.obtenirRecorregut() + "\n"+"\n";
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        //} 
        return sol_text1 + "\n" + sol_text2;
    }
    */
    /*
     public void guardar_matrius(String nomFitxer)throws IOException{
     t.writeTextFile(nomFitxer, printSolucioQAP());
     }
     */
    /*public void guardar_solucioQAP(String nomFitxer)throws IOException{
        String sol_text1 = new String();
        sol_text1 = printSolucioQAP();
        t.obrirFitxer(nomFitxer);
        t.deleteFile();
        t.writeTextFile(sol_text1);
        t.tancarFitxer();
        //ArrayList<String> sol_text1 = new ArrayList<String>();
        //sol_text1.add(printSolucioQAP());
        //t.writeTextFile(nomFitxer, sol_text1);
    }*/
    
    
}