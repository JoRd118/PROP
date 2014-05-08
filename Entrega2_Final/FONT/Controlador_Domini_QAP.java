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
    private ArrayList<SolucioQAP> solucions;
    private Entrada e;
    private Controlador_Dades_QAP t;
    //Matrius
    private double[][] mDistancies;
    private int[][] mDisponibilitats;
    private int[][] mNecessitats;
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
    private String[] mPlanetes;
    private String[] mRecursos;
    
    // private String[] mPlanetes = {"A","B","C","E"};
    // private String[]   mRecursos = {"Coure","Diamant", "Metall", "Or", "Plata"};
    
    
    
    
    private static String msg_QAP = "Error de QAP: Algorisme no trobat";
    
    
    public Controlador_Domini_QAP(){
        e = new Entrada();
    }
    
    public Controlador_Domini_QAP(Entrada e){
        this.e = e;
        t = new Controlador_Dades_QAP();
    }
    
    public void calcularMatrius(String nom_u){
        e.calcularMatrius(nom_u);
    }
    
    public void run_algorithm(String algorithm){
        mDistancies = e.obtenirMatriuDisPla();
        mDisponibilitats = e.obtenirMatriuRecPla();
        mNecessitats = e.obtenirMatriuNecPla();
        
        mPlanetes = e.obtenirVectorPlan();
        mRecursos = e.obtenirVectorRecu();
        
        solucions = new ArrayList<SolucioQAP>();
        
        //SolucioQAP s_aux;
        for(int ipclc = 0;ipclc<mPlanetes.length;ipclc++) {
            if(algorithm.equals("BBL")) {
                BranchBound bb = new BranchBoundLazy();
                
                SolucioQAP s_aux = bb.Calcular(ipclc, mPlanetes, mRecursos, mDistancies, mDisponibilitats, mNecessitats);
                s_aux.processarSolucions();
                // s_aux.imprimirSolucio();
                solucions.add(s_aux);
                // System.out.println("BB DONE!");
            } else if(algorithm.equals("BBE")) {
                BranchBound bb = new BranchBoundEager();
                SolucioQAP s_aux = bb.Calcular(ipclc, mPlanetes, mRecursos, mDistancies, mDisponibilitats, mNecessitats);
                s_aux.processarSolucions();
                // s_aux.imprimirSolucio();
                solucions.add(s_aux);
                // System.out.println("BB DONE!");
            } else if(algorithm.equals("TABU")) {
                Tabu t = new Tabu();
                SolucioQAP s_aux = t.Calcular(ipclc, mPlanetes, mRecursos, mDistancies, mDisponibilitats, mNecessitats);
                s_aux.processarSolucions();
                // s_aux.imprimirSolucio();
                solucions.add(s_aux);
                // System.out.println("TABU DONE!");
            }
            else{throw new IllegalArgumentException(msg_QAP);}
        }
    }
    
    public String printSolucioQAP(){
        String sol_text1 = new String();
        String sol_text2 = new String();
        sol_text1 = sol_text1 + "SolucioQAP: \nPlanetes: \n";
        for(int i = 0; i < solucions.size(); ++i){
            SolucioQAP solucio = solucions.get(i);
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
        }
        return sol_text1 + "\n" + sol_text2;
    }
    /*
     public void guardar_matrius(String nomFitxer)throws IOException{
     t.writeTextFile(nomFitxer, printSolucioQAP());
     }
     */
    public void guardar_solucioQAP(String nomFitxer)throws IOException{
        ArrayList<String> sol_text1 = new ArrayList<String>();
        sol_text1.add(printSolucioQAP());
        t.writeTextFile(nomFitxer, sol_text1);
    }
    
    
}