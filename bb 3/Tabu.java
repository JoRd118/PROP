import java.util.*;
///////////////////////////////////////////////////////////////////
////// FALTA SOLUCIO INICIAL
////// I ANAR-SE QUEDANT LA MILLOR SOLUCIO 
///////////////////////////////////////////////////////////////////


public class Tabu {
  
  // Classe per fer la primera proposta de solucio
  public class infoPla {
    int idPlaneta;
    double distancia;
    int coincidencies;
    double discon; // (distancia / coincidencies)
    String nom;    
  }
  
  // Clase pels veins
  public class infoVei {
    int posicio1;  // intercanviem posicio 1
    int posicio2;  // amb posicio 2
    double recorregut; // Recorregut de la solucio resultant de fer aquest canvi
  }

  // Clase pels aspirants
  public class infoAsp {
    int posicio1;  // intercanviem posicio 1
    int posicio2;  // amb posicio 2
    double recorregut; // Recorregut de la solucio resultant de fer aquest canvi
    int tabu; // tabu
    int frequencia; // Frequencia d'aquest intercanvi
  }

  // Planetes analitzats
  private int planetesanalitzats = 0;
  // Per defecte no calculem la cota Hungarian
  private boolean cotahungarian = false;
  // Nom de l'algotirme
  private String nomalgoritme = "Tabu";

  public Tabu() {}
  
  public SolucioQAP Calcular(int indexPlanetaCalcul, String[] mPlanetes, String[] mRecursos, 
                       double[][] mDistancies, int[][] mDisponibilitats, int[][] mNecessitats) {

    // Iniciem dades per fer el calcul.
    SolucioQAP sol = new SolucioQAP();
    sol.modificarPlaneta(mPlanetes[indexPlanetaCalcul]);
    sol.modificarNomAlgoritme(nomalgoritme);

    // Variables de calculs de solucio
    boolean hiHaSolucio = false;
    double millorRecorregut = 0;
    ArrayList<Integer> millorSolucio = new ArrayList<Integer>();
    
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
      sol.modificarMillorRecorregut(0);
//      sol.modificarPlanetesSolucio(mPlanetes[indexPlanetaCalcul]);

    } else {
      // Minim una necessitat per part del planeta de calcul

      // Planetes Pendents amb algun recurs disponible necessari pel planeta de calcul
      // Els ordenarem per distancia / quantitat de recursos que coincideixen amb els necessaris

      // Preparem la cua amb prioritat
      PriorityQueue<infoPla> pqInfoPla = new PriorityQueue<infoPla>(10,  new Comparator<infoPla>() {
        public int compare(infoPla n1, infoPla n2) {
          double c = n1.discon - n2.discon;
          int r = 0;
          if(c > 0) r = 1;
          else if(c<0) r = -1; 
          return (r);
        }
      });

      for(int ip=0;ip<mPlanetes.length;ip++) {
        // Saltem Planeta Calcul
        if(ip != indexPlanetaCalcul) {
          int coincidents = 0;
          for(Integer ir: necessitatsPendents){
            if(mDisponibilitats[ip][ir] == 1) coincidents++;
          }
          // Si hi ha coincidencies passo a planeta pendent
          if(coincidents >= 1) {
            infoPla inpla = new infoPla();
            inpla.idPlaneta = ip;
            inpla.distancia = mDistancies[indexPlanetaCalcul][ip];
            inpla.coincidencies = coincidents;
            inpla.discon = inpla.distancia / inpla.coincidencies;
            inpla.nom = mPlanetes[ip];
            pqInfoPla.add(inpla);
          }
        }
      }

      // Ara crearem un array amb els planetes ordenats
      ArrayList<infoPla> planetesPendents = new ArrayList<infoPla>();

//*-----------------------------------------------------------------------------------
      System.out.println("  InfoPlanetes:");
//-----------------------------------------------------------------------------------*/

      while(pqInfoPla.size() > 0) {
        infoPla inpla = new infoPla();
        inpla = pqInfoPla.poll();
        planetesPendents.add(inpla);

//*-----------------------------------------------------------------------------------
        System.out.println("    idPlaneta.... "+inpla.idPlaneta);
        System.out.println("    distancia.... "+inpla.distancia);
        System.out.println("    coincidencies "+inpla.coincidencies);
        System.out.println("    discon....... "+inpla.discon);
        System.out.println("    nom.......... "+inpla.nom);
        System.out.println();
//-----------------------------------------------------------------------------------*/
      }


//*-----------------------------------------------------------------------------------
      System.out.println();
      System.out.print("  Plan Pend "+planetesPendents.size()+":");
      for(infoPla ip: planetesPendents) System.out.print(" ["+ip.idPlaneta+"]: "+mPlanetes[ip.idPlaneta]);
      System.out.println();
//-----------------------------------------------------------------------------------*/


      // Ara comprovem si hi haura solucio
      // Si n'hi ha, ens la quedarem i la posarem com a solucio inicial

      // Afegim a la possible millor solucio el planeta de calcul
      millorSolucio.add(indexPlanetaCalcul);

      // Ara mirarem si hi pot haver solucio i ens quedarem la primera que trobem
      // Fem un arraylist amb les necessitats pendents
      ArrayList<Integer> necPen = new ArrayList<Integer>(necessitatsPendents);
      // Anem recorrent els planetes pendents fins que no quedi cap necessitat per satisfer
      for(infoPla inpla: planetesPendents){
        boolean esSolucio = false;
        // Fem servir un ListIterator per poder fer remove si cal
        ListIterator<Integer> listIterator = necPen.listIterator();
        while(listIterator.hasNext()) {
          int ir = listIterator.next();
          if(mDisponibilitats[inpla.idPlaneta][ir] == 1) {
            esSolucio = true;
            listIterator.remove();
          }
        }
        if(esSolucio) {
          millorRecorregut = millorRecorregut + inpla.distancia;
          millorSolucio.add(inpla.idPlaneta);
        }
      }

      // Si hem satisfet totes les necessitats pendents, es una possible solucio
      if(necPen.size() == 0) hiHaSolucio = true;
      // Quantitat de planetes pendents
      int qttPP = planetesPendents.size();
      // Si nomes hi ha un planeta pendent es la millor solucio
      if(hiHaSolucio && (qttPP == 1)) {
        // SOLUCIO: Nomes hi ha un altre planeta i te solucio
        planetesanalitzats = 1;
        sol.modificarTerraformat(true);
        sol.modificarMillorRecorregut(millorRecorregut);
//        sol.modificarPlanetesSolucio(mPlanetes[indexPlanetaCalcul]+" "+mPlanetes[planetesPendents.get(0).idPlaneta]);
        sol.modificarObservacions("Nomes hi ha un planeta possible.");

        // Si hi ha solucio continuem per buscar si n'hi ha una de millor
      } else if(hiHaSolucio) {
        // Tenim solucio inicial i minim dos planetes
//        System.out.println("qttPP: " + qttPP);

        // Matriu de planetes possibles a la solucio
        infoPla[] planetes = new infoPla[qttPP];
        
//        System.out.println("Matriu planetes");
        for(int i=0;i<qttPP;i++) {
          planetes[i] = planetesPendents.get(i);
//          System.out.println(planetes[i].idPlaneta + " " + planetes[i].distancia + " " + planetes[i].nom);
        }

        // ==================================================
        // Iniciem les dades pel calcul Tabu
        // ==================================================
        
        // Preparem la cua amb prioritat pels aspirants
        PriorityQueue<infoAsp> pqInfoAsp = new PriorityQueue<infoAsp>(10,  new Comparator<infoAsp>() {
          public int compare(infoAsp n1, infoAsp n2) {
            double c = n1.recorregut - n2.recorregut;
            int r = 0;
            if(c > 0) r = 1;
            else if(c<0) r = -1; 
            return (r);
          }
        });

        // Quantitat de cicles tabu
        int qttCiclesTabu = 4;
        // Quantitat de aspirants
        int qttAsp = 4;
        // Iteracio inici criteri d'aspiracio
        int iterAsp = 25;
        // Valor Aspiracio (Cota)
        double valorAspiracio = millorRecorregut;
        // Iteracio inici memoria llarg termini
        int iterMem = 40;
        // Nombre maxim d'iteracions
        int qttIteracions = 50;
        // Imprimim cada pas
        boolean imp = true;
        
        // Matriu de solucio i solucio temporal
        int[] ordVis = new int[qttPP];
        int[] ordVisTmp = new int[qttPP];
        int[] ordVisMillor = new int[qttPP];
        // La primera solucio es: 0 1 2 3 4 ...
        for(int i=0;i<qttPP;i++) {
          ordVis[i] = i;
          ordVisTmp[i] = i;
        }

        // Calculem la matriu de veins d'una solucio
        int qttVeins=(qttPP*(qttPP-1))/2;
        // Si la quantitat de aspirants es mes gran que la quantitat de veins el redueixo
        if(qttAsp>qttVeins) qttAsp = qttVeins;
        
        System.out.println("Quantitat de veins: "+qttVeins);
        // Construim tots els possibles intercanvis
        infoVei[] veins = new infoVei[qttVeins];
        int kVeins=0;
        for(int i=0;i<qttPP-1;i++) {
          for(int j=i+1;j<qttPP;j++) {
            infoVei iv = new infoVei();
            iv.posicio1=i;
            iv.posicio2=j;
            iv.recorregut=0;
            veins[kVeins]=iv;
            kVeins=kVeins+1;
          }
        }
        
/*-----------------------------------------------------------------------------------
        for(infoVei iv:veins) {
          System.out.println(" "+iv.posicio1+" "+iv.posicio2+" "+iv.recorregut);
        }
//-----------------------------------------------------------------------------------*/

        int[][] tabu = new int[qttPP][qttPP];
        int[][] frecuencies = new int[qttPP][qttPP];
        
        // Iniciem llista Tabu (memoria a curt termini)
        // Iniciem llista frequents (memoria a llarg termini)
        for(int i=0;i<qttPP;i++) {
          for(int j=0;j<qttPP;j++) {
            tabu[i][j]=0;
            frecuencies[i][j]=0;
          }
        }

        double recoSol = millorRecorregut;
        
        System.out.println("  recorregut: "+recoSol);
        
        recoSol=calculaRecorregut(qttPP, ordVisTmp, planetes, necessitatsPendents, mDisponibilitats);

        System.out.println("  recorregut: "+recoSol);

        // Pinto solucio
        System.out.print("Solucio actual:");
        for(int i=0;i<qttPP;i++) {
          System.out.print(" "+ordVis[i]);
        }
        System.out.println("  recorregut: "+recoSol);




        // Fem iteracions fins arribar a qttIteracions
        int iter=1;
        do {
          // Avaluem tots els veins
          System.out.println(" Avaluacio de tots els veins:");
          for(int fila=0;fila<qttVeins;fila++) {
            for(int j=0;j<qttPP;j++) {
              ordVisTmp[j]=ordVis[j]; // ordVis --> ordVisTmp
            }
            int traspas=ordVisTmp[veins[fila].posicio1];
            ordVisTmp[veins[fila].posicio1]=ordVisTmp[veins[fila].posicio2];
            ordVisTmp[veins[fila].posicio2]=traspas;
            recoSol = calculaRecorregut(qttPP, ordVisTmp, planetes, necessitatsPendents, mDisponibilitats);
            // recorregut si es fa aqeust canvi
            veins[fila].recorregut=recoSol;
            if(imp){
              System.out.println(fila+" "+veins[fila].posicio1+" "+veins[fila].posicio2+" "+veins[fila].recorregut);
            }
          }
          
          // Ara escollim els millors aspirants
          infoAsp[] aspirants = new infoAsp[qttAsp];
          // Els ordenem
          pqInfoAsp.clear();
          System.out.println(" Millors aspirants:");
          for(int fila=0;fila<qttVeins;fila++) {
            infoAsp ic = new infoAsp();
            ic.posicio1 = veins[fila].posicio1;
            ic.posicio2 = veins[fila].posicio2;
            ic.recorregut = veins[fila].recorregut;
            ic.tabu = 0;
            ic.frequencia = frecuencies[veins[fila].posicio2][veins[fila].posicio1];
            pqInfoAsp.add(ic);
          }
          for(int fila=0;fila<qttAsp;fila++) {
            infoAsp ic = pqInfoAsp.poll();
            aspirants[fila]=new infoAsp();
            aspirants[fila].posicio1=ic.posicio1;
            aspirants[fila].posicio2=ic.posicio2;
            aspirants[fila].recorregut=ic.recorregut;
            aspirants[fila].tabu=ic.tabu;
            aspirants[fila].frequencia=ic.frequencia;
            // Comprovem tabu
            if(tabu[aspirants[fila].posicio1][aspirants[fila].posicio2]>0 ) {
              aspirants[fila].tabu=1;
              // Criteri d'aspiracio (cota aspiracio)
              if ((aspirants[fila].recorregut==valorAspiracio) && (iter>=iterAsp)) {
                aspirants[fila].tabu=0;
              }
            }

            if(imp){
              System.out.println(fila+" "+aspirants[fila].posicio1+" "+aspirants[fila].posicio2+" "+aspirants[fila].recorregut+" "+aspirants[fila].tabu+" "+aspirants[fila].frequencia);
            }

          }

          // Seleccionem la propera solucio
          int estat=0;
          int iAsp=0;
          do {
            if(aspirants[iAsp].tabu == 0) {
              // No es tabu
              estat=1;
              // Comprovem frequencia si cal
              if(iter>=iterMem) {
                int freq=aspirants[iAsp].frequencia;
                // Si trobem un altre aspirant no tabu amb menys frequencia no el seleccionarem
                for(int k=0;k<qttAsp;k++) {
                  if((freq>aspirants[k].frequencia) && (aspirants[k].tabu==0)) {
                    estat=0;
                  }
                }
              }
              // Si he trobat aspirant el faig propera solucio
              if(estat==1) {
                int traspas=ordVis[aspirants[iAsp].posicio1];
                ordVis[aspirants[iAsp].posicio1]=ordVis[aspirants[iAsp].posicio2];
                ordVis[aspirants[iAsp].posicio2]=traspas;
                recoSol=aspirants[iAsp].recorregut;
                
                tabu[aspirants[iAsp].posicio1][aspirants[iAsp].posicio2]=qttCiclesTabu;
                frecuencies[aspirants[iAsp].posicio2][aspirants[iAsp].posicio1]++;
              }
            }
            // Proper aspirant si no trobat
            iAsp=iAsp+1;
            if(iAsp>=qttAsp && estat==0) {
              // S'han acabat els aspirants
              estat=2;
            }
          } while(estat==0);

          // !!!!!!!!!!!!!!!!!!!!!
          if(estat==2) {
            // Hem d'acabar
            break;
          }         
          // !!!!!!!!!!!!!!!!!!!!!

          // Actualitzem la llista tabu (nomes diagonal superior)
          for(int k=0;k<qttPP;k++) {
            for(int j=k+1;j<qttPP;j++) {
              if(tabu[k][j]>0) tabu[k][j]=tabu[k][j]-1;
            }
          }


          // Pinto solucio
          System.out.print("Solucio actual:");
          for(int i=0;i<qttPP;i++) {
            System.out.print(" "+ordVis[i]);
          }
          System.out.println("  recorregut: "+recoSol);



          // Propera iteracio
          iter=iter+1;
        } while (iter <= qttIteracions);








        // Guardem millor solucio
//        sol.modificarNodesUtilitzats(comptadoridnode);
        sol.modificarTerraformat(true);
        sol.modificarMillorRecorregut(millorRecorregut);
        String s = mPlanetes[indexPlanetaCalcul];
        s = s + planetesRecorregut(qttPP, ordVis, planetes, necessitatsPendents, mDisponibilitats);

//        sol.modificarPlanetesSolucio(s);
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
  
  
  public double calculaRecorregut(int qtt, int[] ordVis, infoPla[] planetes, ArrayList<Integer> necessitatsPendents,  int[][] mDisponibilitats) {
    double recorregut = 0;
    // Fem un arraylist amb les necessitats pendents
    ArrayList<Integer> necPen = new ArrayList<Integer>(necessitatsPendents);
    // Anem recorrent els planetes de la solucio
    for(int i=0;i<qtt;i++) {
      infoPla inpla = planetes[ordVis[i]];
      boolean esSolucio = false;
      // Fem servir un ListIterator per poder fer remove si cal
      ListIterator<Integer> listIterator = necPen.listIterator();
      while(listIterator.hasNext()) {
        int ir = listIterator.next();
        if(mDisponibilitats[inpla.idPlaneta][ir] == 1) {
          esSolucio = true;
          listIterator.remove();
        }
      }
      if(esSolucio) {
        recorregut = recorregut + inpla.distancia;
//        millorSolucio.add(inpla.idPlaneta);
      }
      if(necPen.size() < 1) break;
    }
    if(necPen.size() >= 1) recorregut = Double.MAX_VALUE;

    return recorregut;
  }

  public String planetesRecorregut(int qtt, int[] ordVis, infoPla[] planetes, ArrayList<Integer> necessitatsPendents,  int[][] mDisponibilitats) {
    String sPlanetes = "";
    // Fem un arraylist amb les necessitats pendents
    ArrayList<Integer> necPen = new ArrayList<Integer>(necessitatsPendents);
    // Anem recorrent els planetes de la solucio
    for(int i=0;i<qtt;i++) {
      infoPla inpla = planetes[ordVis[i]];
      boolean esSolucio = false;
      // Fem servir un ListIterator per poder fer remove si cal
      ListIterator<Integer> listIterator = necPen.listIterator();
      while(listIterator.hasNext()) {
        int ir = listIterator.next();
        if(mDisponibilitats[inpla.idPlaneta][ir] == 1) {
          esSolucio = true;
          listIterator.remove();
        }
      }
      if(esSolucio) {
//        recorregut = recorregut + inpla.distancia;
        sPlanetes = sPlanetes + " " + inpla.nom;
      }
      if(necPen.size() < 1) break;
    }
    if(necPen.size() >= 1) sPlanetes = "ERROR";

    return sPlanetes;
  }
  
//  public int obtenirComptadorIdNode() { return comptadoridnode; }

//  public boolean obtenirCotaHungarian() { return cotahungarian; }
  public String obtenirNomAlgoritme() { return nomalgoritme; }

  public void modificarCotaHungarian(boolean cotahungarian) { this.cotahungarian = cotahungarian; }
  public void modificarNomAlgoritme(String nomalgoritme) { this.nomalgoritme = nomalgoritme; }
  
}
