import java.util.*;

public abstract class BranchBound {
  
  // Comptador per mantenir l'id de cada node nou
  private int comptadoridnode = 0;
  // Planetes analitzats
  private int planetesanalitzats = 0;
  // Per defecte no calculem la cota Hungarian
  private boolean cotahungarian = false;
  // Nom de l'algotirme
  private String nomalgoritme = "Branch and bound";

  public BranchBound() {}
  
  public SolucioQAP Calcular(int indexPlanetaCalcul, String[] mPlanetes, String[] mRecursos, 
                       double[][] mDistancies, int[][] mDisponibilitats, int[][] mNecessitats) {

    // Iniciem dades per fer el calcul.
    SolucioQAP sol = new SolucioQAP();
    sol.modificarPlaneta(mPlanetes[indexPlanetaCalcul]);
    if(cotahungarian) {
      sol.modificarNomAlgoritme(nomalgoritme+" cota hungarian");
    } else {
      sol.modificarNomAlgoritme(nomalgoritme+" cota normal");
    }

    // Variables de calculs de solucio
    boolean hiHaSolucio = false;
    boolean solucioValida = false;
    boolean cotaTrobada = false;
    double millorRecorregut = 0;
    ArrayList<Integer> millorSolucio = new ArrayList<Integer>();
    
/*-----------------------------------------------------------------------------------
    System.out.println("=======================");
    System.out.println("BranchBound: Planeta  ["+indexPlanetaCalcul+"]: "+mPlanetes[indexPlanetaCalcul]);
//-----------------------------------------------------------------------------------*/

    // Creem la matriu de necessitats pendents del planeta de calcul
    // tenint en compte que si te la necessitat d'un recurs
    // que ell mateix te disponible NO l'afegim.
    ArrayList<Integer> necessitatsPendents = new ArrayList<Integer>();
    
    for(int ir=0;ir<mRecursos.length;ir++) {
      if((mNecessitats[indexPlanetaCalcul][ir] == 1) && (mDisponibilitats[indexPlanetaCalcul][ir] != 1)) necessitatsPendents.add(ir);
    }

/*-----------------------------------------------------------------------------------
    System.out.print("  Nece Pend "+necessitatsPendents.size()+":");
    for(Integer ir: necessitatsPendents) System.out.print(" ["+ir+"]: "+mRecursos[ir]);
    System.out.println();
//-----------------------------------------------------------------------------------*/

    // Segons les necessitats pendents
    if(necessitatsPendents.size() < 1) {
      // SOLUCIO: El planeta no necessita res
      planetesanalitzats = 0;
      sol.modificarTerraformat(true);
      sol.modificarCotaInicial(0);
      sol.modificarMillorRecorregut(0);
      sol.modificarPlanetesAnalitzats(planetesanalitzats);
      sol.modificarNodesUtilitzats(0);
      sol.modificarPlanetesSolucio(mPlanetes[indexPlanetaCalcul]);

//      hiHaSolucio = true;
//      millorRecorregut = 0;
//      millorSolucio.add(indexPlanetaCalcul);
/*-----------------------------------------------------------------------------------
      System.out.println("SOLUCIO:");
      System.out.println("  Recorregut "+millorRecorregut);
      System.out.print("  Planetes:");
      for(Integer ip: millorSolucio) System.out.print(" "+mPlanetes[ip]);
      System.out.println();
//-----------------------------------------------------------------------------------*/

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

/*-----------------------------------------------------------------------------------
      System.out.print("  Plan Pend "+planetesPendents.size()+":");
      for(Integer ip: planetesPendents) System.out.print(" ["+ip+"]: "+mPlanetes[ip]);
      System.out.println();
//-----------------------------------------------------------------------------------*/

      // Ara comprovem si hi haura solucio
      // Si n'hi ha, ens la quedarem i la posarem com a millor solucio
      // El recorregut d'aquesta solucio sera la cota per podar fins que no en trobem una de millor.

      // Afegim a la possible millor solucio el planeta de calcul
      millorSolucio.add(indexPlanetaCalcul);

      // Ara mirarem si hi pot haver solucio i ens quedarem la primera que trobem
      // no sabem si sera la millor pero sera la primera "cota" que utilitzarem.
      // Fem un arraylist amb les necessitats pendents
      ArrayList<Integer> necPen = new ArrayList<Integer>(necessitatsPendents);
      // Anem recorrent els planetes pendents fins que no quedi cap necessitat per satisfer
      for(Integer ip: planetesPendents){
        boolean esSolucio = false;
        // Fem servir un ListIterator per poder fer remove si cal
        ListIterator<Integer> listIterator = necPen.listIterator();
        while(listIterator.hasNext()) {
          int ir = listIterator.next();
          if(mDisponibilitats[ip][ir] == 1) {
            esSolucio = true;
            listIterator.remove();
          }
        }
        if(esSolucio) {
          millorRecorregut = millorRecorregut + mDistancies[indexPlanetaCalcul][ip];
          millorSolucio.add(ip);
        }
      }
      // Si hem satisfet totes les necessitats pendents, es una possible solucio
      if(necPen.size() == 0) hiHaSolucio = true;
      
      // Si nomes hi ha un planeta pendent es la millor solucio
      if(hiHaSolucio && (planetesPendents.size() == 1)) {
        // SOLUCIO: Nomes hi ha un altre planeta i te solucio
        planetesanalitzats = 1;
        sol.modificarTerraformat(true);
        sol.modificarCotaInicial(millorRecorregut);
        sol.modificarMillorRecorregut(millorRecorregut);
        sol.modificarPlanetesAnalitzats(planetesanalitzats);
        sol.modificarNodesUtilitzats(0);
        sol.modificarPlanetesSolucio(mPlanetes[indexPlanetaCalcul]+" "+mPlanetes[planetesPendents.get(0)]);
        sol.modificarObservacions("Nomes hi ha un possible planeta.");

        // Si hi ha solucio continuem per buscar si n'hi ha una de millor
      } else if(hiHaSolucio) {
        // Tenim solucio inicial i cota inicial.
        solucioValida = true;
        cotaTrobada = true;
        
/*-----------------------------------------------------------------------------------
        System.out.println("Solucio inicial:");
        System.out.println("  Millor Recorregut "+millorRecorregut);
        System.out.print("  Planetes:");
        for(Integer ip: millorSolucio) System.out.print(" "+mPlanetes[ip]);
        System.out.println();
//-----------------------------------------------------------------------------------*/

        // Si hem demanat Hungarian ara es el moment d'aplicar-lo per calcular la cota
        if(cotahungarian) {
          // Invalidem solucio.
          // Sabem que n'hi ha, pero no si n'hi haura fent servir la cota hungarian.
          solucioValida = false;
          cotaTrobada = false;
/*-----------------------------------------------------------------------------------
          System.out.println("Cota HUNGARIAN: ");
//-----------------------------------------------------------------------------------*/
          // Muntem la matriu de la manera seguent
          // Les files correspondran a cadascun dels planetes pendents
          // Les columnes correspondran a cadascun dels recursos pendents
          // Els valors seran:
          //   [infinit] : Si el planeta(fila) no disposa dels recurs(columna).
          //         [D] : Si el planeta(fila) disposa dels recurs(columna). En aquest cas
          //               el valor D es la distancia entre el planeta actual i el planeta(fila).

          int nRangPlanetes = planetesPendents.size();
          int nRangNecessitats = necessitatsPendents.size();

          // La matriu ha de ser n x n
          int nRang = nRangPlanetes;
          if(nRang < nRangNecessitats) nRang = nRangNecessitats;
          // Minim 2x2
          if(nRang >= 2) {
            double[][] mHunga = new double[nRang][nRang];
            for(int f=0;f<nRang;f++) {
              for(int c=0; c<nRang; c++) {
                double valor = 0;
                if((f<nRangPlanetes) && (c<nRangNecessitats)) {
                  int iPlaPen = planetesPendents.get(f);
                  // Si no hi ha disponibilitat posem similar a infinit
                  if(mDisponibilitats[iPlaPen][necessitatsPendents.get(c)] == 0) {
                    valor = Double.MAX_VALUE;
                  } else {
                    valor = mDistancies[indexPlanetaCalcul][iPlaPen];
                  }
                }
                mHunga[f][c] = valor;
              }
            }

/*-----------------------------------------------------------------------------------
            System.out.println("Matriu HUNGARIAN: ");
            for(int f=0;f<nRang;f++) {
              System.out.printf("[%2d]:",f);
              for(int c=0; c<nRang; c++) {
                if(mHunga[f][c] == Double.MAX_VALUE) {
                  System.out.print(" infin");
                } else {
                  System.out.printf(" %5.1f",mHunga[f][c]);
                }
              }
              System.out.println();
            }
            System.out.println();
//---------------------------------------------------------------------------------*/

            // Calculem la cota a l'estil hungarian
            double resHunga = clcCotaHungarian(mHunga);
            millorRecorregut = resHunga;
            cotaTrobada = true;

/*-----------------------------------------------------------------------------------
            System.out.println("--------------------------------");
            System.out.println("Resultat cota Hungarian: "+resHunga);
            System.out.println("--------------------------------");
//-----------------------------------------------------------------------------------*/
          }
        }

        // Nomes continuem si hem trobat una cota
        if(cotaTrobada) {
          // Ho informem a la solucio
          sol.modificarCotaInicial(millorRecorregut);
          
          // Preparem la cua amb prioritat
          PriorityQueue<bbNode> pqNodes = new PriorityQueue<bbNode>(10,  new Comparator<bbNode>() {
            public int compare(bbNode n1, bbNode n2) {
              double c = n1.obtenirRecorregut()-n2.obtenirRecorregut();
              int r = 0;
              if(c > 0) r = 1;
              else if(c<0) r = -1; 
              return (r);
            }
          });
  
          // Creem el primer node

          // Cami inicial = Planeta de Calcul
          ArrayList<Integer> camiInicial = new ArrayList<Integer>();
          camiInicial.add(indexPlanetaCalcul);      
  
          bbNode nodeSel = new bbNode(comptadoridnode++, indexPlanetaCalcul, 0, camiInicial, necessitatsPendents, planetesPendents);

          // Iniciem bucle fins que no quedi cap mes node
          boolean bContinuem = false;
          do {
            // Ramifico totes les possibilitats de nodeSel i els poso en cua o els podo
            for(Integer idPlanetaVisitat: nodeSel.obtenirPlanetesPendents()){
              planetesanalitzats++;
              // Actualitzo recorregut
              double recorregut = nodeSel.obtenirRecorregut() + mDistancies[indexPlanetaCalcul][idPlanetaVisitat];
              // Si el recorregut ja es pitjor que l'actual millor solucio el descarto (podo)
              // Si es igual i ja hi havia solucio tambe el podo
              if((recorregut < millorRecorregut) || ((recorregut <= millorRecorregut) && (! solucioValida))) {
                // Actualitzo necessitats pendents despres de visitar idPlanetaVisitat
                ArrayList<Integer> novesNecessitatsPendents = new ArrayList<Integer>();
                for(Integer idNecessitatPendent: nodeSel.obtenirNecessitatsPendents()){
                  if(mDisponibilitats[idPlanetaVisitat][idNecessitatPendent] != 1) {
                    novesNecessitatsPendents.add(idNecessitatPendent);
                  }
                }
                // Si no hi ha mes necessitats, es una millor solucio perque el seu recorregut
                // es mes petit o es igual que la cota pero no hi havia solucio.
                if(novesNecessitatsPendents.size() == 0) {
                  // Millor solucio fins al moment (no podat)(no en cua)
                  solucioValida = true;
                  millorRecorregut = recorregut;
                  millorSolucio.clear();
                  millorSolucio = new ArrayList<Integer>(nodeSel.obtenirCami());
                  millorSolucio.add(idPlanetaVisitat);

                } else {
  
                  // Refem planetes pendents segons Lazy o Eager
                  ArrayList<Integer> nousPlanetesPendents = new ArrayList<Integer>();
                  for(Integer ip: nodeSel.obtenirPlanetesPendents()){
                    if(calAfegirPlaneta(ip, idPlanetaVisitat, novesNecessitatsPendents, mDisponibilitats)) {
                      nousPlanetesPendents.add(ip);
                    }
                  }
                
                  // Només continuem si hi ha planetes pendents amb alguna disponibilitat necessaria
                  if(nousPlanetesPendents.size() >= 1) {

                    // Si queden planetes pendents guardo el node per ramificar quan toqui
                    // Afegim el planeta al cami seguit
                    ArrayList<Integer> nouCami = new ArrayList<Integer>(nodeSel.obtenirCami());
                    nouCami.add(idPlanetaVisitat);
                    // Afegim node a la cua de prioritat de possibles nodes pendents
                    bbNode nodeNou = new bbNode(comptadoridnode++, idPlanetaVisitat, recorregut, nouCami, novesNecessitatsPendents, nousPlanetesPendents);
                    pqNodes.add(nodeNou); // Posat en cua (no podat)

/*-----------------------------------------------------------------------------------
                    System.out.println("===============");
                    System.out.println("Posat en cua: "+nodeNou.obtenirIdNode());
                    ArrayList<bbNode> lll = new ArrayList<bbNode>();

                    // INICI: Pinto la cua de prioritat per fer comprovacions
                     while(pqNodes.size() > 0) {
                      bbNode nnn = new bbNode();
                      nnn = pqNodes.poll();
                      lll.add(nnn);
                      System.out.print("["+nnn.obtenirIdNode()+"]");
                      System.out.print("idPlaneta: "+nnn.obtenirIdPlaneta());
                      System.out.print(" Distancia: "+nnn.obtenirRecorregut());
                      System.out.print(" Cami:");
                      for(Integer ncip: nnn.obtenirCami())System.out.print(" "+ncip); 
                       if(nodeNou.obtenirIdNode() == nnn.obtenirIdNode()) {
                        System.out.println(" <");
                      } else {
                        System.out.println();
                      }                  
                    }
                    System.out.println("---");
                    for(bbNode bbn: lll) pqNodes.add(bbn);
                    // FI: Pinto la cua de prioritat per fer comprovacions
//-----------------------------------------------------------------------------------*/

                  }
                }
              } else {
                // Aqui marcarem al node d'arbre correponent que l'hem descartat per cota

/*-----------------------------------------------------------------------------------
                System.out.println("...................");
                System.out.println("Descarto per recorregut: "+recorregut+" >= "+millorRecorregut);
                System.out.print("["+nodeSel.obtenirIdNode()+"]");
                System.out.print("idPlaneta: "+nodeSel.obtenirIdPlaneta()+ " --> " + idPlanetaVisitat);
                System.out.println(" Distancia: "+nodeSel.obtenirRecorregut());
                System.out.print("Cami:");
                for(Integer ncip: nodeSel.obtenirCami())System.out.print(" "+ncip); 
                //System.out.print(" Coincidents: "+nodeSel.obtenirCoincidents());
                System.out.println();
                System.out.println("...................");
//-----------------------------------------------------------------------------------*/
              }
            }
            // Agafo proper node segons la prioritat de la PriorityQueue
            nodeSel = pqNodes.poll();
            // Comprovem que no s'hagin acabat els nodes ( = null perque hem fet poll )
            bContinuem = false;
            if (nodeSel != null) {
              // Com que la prioritat es el recorregut, nomes continuem si el node te un
              // recorregut mes petit que millorRecorregut. En cas contrari ja podem 
              // descartar tambe la resta de nodes de la PriorityQueue
              if (nodeSel.obtenirRecorregut() < millorRecorregut) bContinuem = true;
            }
          } while (bContinuem);
          // Guardem solucio si n'hi ha
          sol.modificarPlanetesAnalitzats(planetesanalitzats);
          sol.modificarNodesUtilitzats(comptadoridnode);
          if(solucioValida) {
            sol.modificarTerraformat(true);
            sol.modificarMillorRecorregut(millorRecorregut);
            String s = "";
            for(Integer ip: millorSolucio) {
              if(s != "") s = s + " ";
              s = s + mPlanetes[ip];
            }
            sol.modificarPlanetesSolucio(s);
          } else {
            sol.modificarObservacions("No hem trobat solucio");
          }
        } else {
          // No hem trobat cota
          sol.modificarObservacions("No hem trobat cota !");
        }
        
      } else {
        // No hi ha solucio
        sol.modificarObservacions("No hi ha solucio possible !");
      }
    }
    return sol;
  }
  
  private double clcCotaHungarian(double[][] mMatriu) {
    double resultat = 0;
    int nRangfil = mMatriu.length;
    int nRangcol = mMatriu[0].length;
/*-----------------------------------------------------------------------------------
    System.out.println("RANG: "+nRangfil+"x"+nRangcol);
//-----------------------------------------------------------------------------------*/

    double[][] mMat = new double[nRangfil][nRangcol];
    for(int f=0;f<nRangfil;f++) for(int c=0;c<nRangcol;c++) mMat[f][c] = mMatriu[f][c];

    HungarianAlgorithm ha = new HungarianAlgorithm();
    int[][] haResultat = ha.computeAssignments(mMat);
    for(int f=0;f<nRangfil;f++) {
      int haf = haResultat[f][0];
      int hac = haResultat[f][1];
      double suma = mMatriu[haf][hac];
/*-----------------------------------------------------------------------------------
      System.out.printf("%2d [%2d][%2d]: %f\n",f,haf,hac,suma);
//-----------------------------------------------------------------------------------*/
      resultat = resultat + suma;
    }
    return resultat;
  }
  
  protected abstract boolean calAfegirPlaneta(int ip, int idPlanetaVisitat, ArrayList<Integer> novesNecessitatsPendents, int[][] mDisponibilitats);

//  public int obtenirComptadorIdNode() { return comptadoridnode; }

//  public boolean obtenirCotaHungarian() { return cotahungarian; }
  public String obtenirNomAlgoritme() { return nomalgoritme; }

  public void modificarCotaHungarian(boolean cotahungarian) { this.cotahungarian = cotahungarian; }
  public void modificarNomAlgoritme(String nomalgoritme) { this.nomalgoritme = nomalgoritme; }
  
}
