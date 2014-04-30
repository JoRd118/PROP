import java.util.*;

public abstract class BranchBound {
  
  // Nom de l'algotirme
  private String nomalgoritme = "Branch and bound";

  public BranchBound() {}
  
  public SolucioQAP Calcular(int indexPlanetaCalcul, String[] mPlanetes, String[] mRecursos, 
                       double[][] mDistancies, int[][] mDisponibilitats, int[][] mNecessitats) {

    // Iniciem dades per fer el calcul.
    SolucioQAP sol = new SolucioQAP();
    sol.modificarPlaneta(mPlanetes[indexPlanetaCalcul]);
    sol.modificarNomAlgoritme(nomalgoritme);

    // Variables de calculs de solucio
    boolean hiHaSolucio = false;

    // Creem la matriu de necessitats pendents del planeta de calcul
    // tenint en compte que si te la necessitat d'un recurs
    // que ell mateix te disponible NO l'afegim.
    ArrayList<Integer> necessitatsPendents = new ArrayList<Integer>();
    
    for(int ir=0;ir<mRecursos.length;ir++) {
      if((mNecessitats[indexPlanetaCalcul][ir] == 1) && (mDisponibilitats[indexPlanetaCalcul][ir] != 1)) necessitatsPendents.add(ir);
    }

    // Si no hi ha necessitats pendents: SOLUCIO(No necessita res mes)
    if(necessitatsPendents.size() < 1) {
      // SOLUCIO: El planeta no necessita res
      sol.modificarTerraformat(true);
      sol.modificarMillorRecorregut(0);
      sol.modificarObservacions("El planeta s'ha terraformat tot sol.");

    } else {
      // Continuem buscant ...

      // Planetes Pendents amb algun recurs disponible necessari pel
      // planeta de calcul
      ArrayList<Integer> planetesPendents = new ArrayList<Integer>();
    
      for(int ip=0;ip<mPlanetes.length;ip++) {
        // Saltem Planeta Calcul
        if(ip != indexPlanetaCalcul) {
          int coincidents = 0;
          for(Integer ir: necessitatsPendents){
            if(mDisponibilitats[ip][ir] == 1) coincidents++;
          }
          // Si hi ha coincidencies passo a planeta pendent
          if(coincidents >= 1) planetesPendents.add(ip);
        }
      }

      // Ara comprovem si hi podra haver solucio

      // Fem un arraylist amb les necessitats pendents
      ArrayList<Integer> necPen = new ArrayList<Integer>(necessitatsPendents);
      // Anem recorrent els planetes pendents fins que no quedi cap necessitat per satisfer
      for(Integer ip: planetesPendents){
        // Fem servir un ListIterator per poder fer remove si cal
        ListIterator<Integer> listIterator = necPen.listIterator();
        while(listIterator.hasNext()) {
          int ir = listIterator.next();
          if(mDisponibilitats[ip][ir] == 1) listIterator.remove();
        }
      }
      // Si hem satisfet totes les necessitats pendents, hi haura solucio.
      if(necPen.size() == 0) hiHaSolucio = true;

      // Si nomes hi ha un planeta pendent es l'unica solucio.
      if(hiHaSolucio && (planetesPendents.size() == 1)) {
        // SOLUCIO(Nomes hi ha un possible planeta)
        sol.modificarTerraformat(true);
        sol.modificarMillorRecorregut(mDistancies[indexPlanetaCalcul][planetesPendents.get(0)]);
        sol.modificarObservacions("Nomes hi ha un possible planeta.");
      } else if(hiHaSolucio && (planetesPendents.size() >= 2)) {

        gesBranch(indexPlanetaCalcul, planetesPendents, necessitatsPendents, mPlanetes, mDistancies, mDisponibilitats, sol);
          
      } else {
        // No hi ha solucio
        sol.modificarObservacions("No hi ha solucio possible !");
      }
    }
    return sol;
  }


  // Calcul de la cota Gilmore-Lawler
  protected double clcGilmore(ArrayList<Integer> planetes, ArrayList<Integer> necessitats, int[][] disponibilitats, double[] distancies) {
    // Valor inicial no valid
    double solucio = -1;
    // Planetes i disponibilitats ([1]: Planeta [2]: Recurs)
    // Agafem el maxim que pot ser
    int n = (planetes.size()+1) * necessitats.size();
    int [][] planec = new int[n][2];
    int nRang = 0;
    for(int ip:planetes) {
      for(int ir:necessitats) {
        // Nomes ens quedem les disponibilitats
        if(disponibilitats[ip][ir] == 1) {
          planec[nRang][0]=ip;
          planec[nRang][1]=ir;
          nRang++;
        }
      }
    }
    // Planeta de calcul, te totes les necessitats.
    for(int ir:necessitats) {
      planec[nRang][0]=-1;
      planec[nRang][1]=ir;
      nRang++;
    }
    // Ara muntem les matrius
    if(nRang >= 2) {
      // [A] Matriu de fluxes i --> j
      double[][] A = new double[nRang][nRang];
      // [B] Matriu de distancies (distancia o infinit)
      double[][] B = new double[nRang][nRang];
      // [C] Matriu de cost fix = 0
      double[][] C = new double[nRang][nRang];
      for(int i=0;i<nRang;i++) {
        int ipo = planec[i][0];
        int iro = planec[i][1];
        for(int j=0;j<nRang;j++) {
          int ipd = planec[j][0];
          int ird = planec[j][1];
          if(ipo >= 0) {
            if(ipd >= 0) {
              A[i][j] = 0;
              if(i == j) B[i][j] = 0; else B[i][j] = Double.MAX_VALUE;
            } else {
              if(iro == ird) A[i][j] = 1; else A[i][j] = 0;
              B[i][j] = distancies[ipo];
            }
          } else {
            if(ipd >= 0) {
              A[i][j] = 0;
              B[i][j] = distancies[ipd];              
            } else {
              A[i][j] = 0;
              if(i == j) B[i][j] = 0; else B[i][j] = Double.MAX_VALUE;
            }
          }
          C[i][j] = 0;
        }
      }
      
/*-----------------------------------------------------------------------------------
      System.out.println("...................");
      System.out.println("Pla Nec");
      for(int i=0;i<nRang;i++) {
        System.out.print(planec[i][0]);
        System.out.println(" " + planec[i][1]);
      }
      System.out.println("[A]");
      for(int i=0;i<nRang;i++) {
        for(int j=0;j<nRang;j++) {
          System.out.print(" " + A[i][j]);
        }
        System.out.println();
      }
      System.out.println("[B]");
      for(int i=0;i<nRang;i++) {
        for(int j=0;j<nRang;j++) {
          if(B[i][j] == Double.MAX_VALUE) System.out.print(" INF"); else System.out.print(" " + B[i][j]);
        }
        System.out.println();
      }
//-----------------------------------------------------------------------------------*/
      Gilmore gl = new Gilmore();
      solucio = gl.Bound(A, B, C);

//      System.out.println("Solucio: "+solucio);      
      
      
    }
    return solucio;          
  }

  protected abstract void gesBranch(int indexPlanetaCalcul, ArrayList<Integer> planetesPendents,
                                    ArrayList<Integer> necessitatsPendents,
                                    String[] mPlanetes, double[][] mDistancies, int[][] mDisponibilitats, SolucioQAP sol);


  public String obtenirNomAlgoritme() { return nomalgoritme; }

  public void modificarNomAlgoritme(String nomalgoritme) { this.nomalgoritme = nomalgoritme; }
  
}
