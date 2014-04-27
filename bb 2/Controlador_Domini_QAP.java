import java.util.*;
import java.io.Console;

public class Controlador_Domini_QAP{
    
  private double[][] mDistancies =  { {0.0,1.0,2.0,3.0,4.0},
								                      {1.0,0.0,2.0,3.0,4.0},
								                      {2.0,2.0,0.0,4.0,1.0},
								                      {3.0,3.0,4.0,0.0,1.0},
								                      {4.0,4.0,1.0,1.0,0.0}
								                    };

  private int[][] mDisponibilitats =  { {1,1,1,1,0,0,1,0,0,0}, //P0
								                        {0,0,0,1,0,0,1,0,1,0}, //P1
						          		              {1,1,0,1,0,0,1,1,1,0}, //P2
								                        {0,0,1,1,1,1,0,0,0,1}, //P3
								                        {1,0,0,1,0,0,0,0,0,1}  //P4
								                      };


  private int[][] mNecessitats =      { {0,1,0,0,1,0,0,1,0,0}, //P0
								                        {0,0,0,1,0,0,1,0,0,0}, //P1
								                        {1,0,1,0,1,0,1,0,1,1}, //P2
								                        {0,0,1,0,1,0,0,1,0,0}, //P3
								                        {1,1,1,0,1,1,1,0,1,1}  //P4
								                      };

/*
  private int[][] mDisponibilitats =  { {0,0,0,0,0,0,0,0,0,0}, //P0
								                        {1,1,0,0,0,0,0,0,0,0}, //P1
						          		              {1,1,1,0,0,0,0,0,0,0}, //P2
								                        {1,1,1,1,0,0,0,0,0,0}, //P3
								                        {1,1,1,1,1,1,1,1,1,1}  //P4
								                      };
  private int[][] mNecessitats =      { {1,1,1,1,1,1,1,1,1,1}, //P0
								                        {0,0,0,0,0,0,0,0,0,0}, //P1
								                        {0,0,0,0,0,0,0,0,0,0}, //P2
								                        {0,0,0,0,0,0,0,0,0,0}, //P3
								                        {0,0,0,0,0,0,0,0,0,0}  //P4
								                      };

*/
  private String[] mPlanetes = {"P0","P1","P2","P3","P4"};
  private String[] mRecursos = {"r0","r1","r2","r3","r4","r5","r6","r7","r8","r9"};

  public Controlador_Domini_QAP(){}
    
  public void run_algorithm(String algorithm, String cota){
    // Preparem dades per calcular la millor solució per cada planeta
//    for(int ipclc = 0;ipclc<mPlanetes.length;ipclc++) {
int ipclc = 4;
      if(algorithm == "BBL") {
        BranchBound bb = new BranchBoundLazy();
        if(cota == "H") bb.modificarCotaHungarian(true);
        SolucioQAP solucio = bb.Calcular(ipclc, mPlanetes, mRecursos, mDistancies, mDisponibilitats, mNecessitats);
        solucio.imprimirSolucio();
      } else if(algorithm == "BBE") {
        BranchBound bb = new BranchBoundEager();
        if(cota == "H") bb.modificarCotaHungarian(true);
        SolucioQAP solucio = bb.Calcular(ipclc, mPlanetes, mRecursos, mDistancies, mDisponibilitats, mNecessitats);
        solucio.imprimirSolucio();
      } else if(algorithm == "TABU") {
        Tabu tb = new Tabu();
        SolucioQAP solucio = tb.Calcular(ipclc, mPlanetes, mRecursos, mDistancies, mDisponibilitats, mNecessitats);
//        solucio.imprimirSolucio();
      }
//    }
      
/*
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
*/
  }
}