import java.util.*;

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

  // Nom de l'algotirme
  private String nomalgoritme = "Tabu";

  public Tabu() {}
  
  public SolucioQAP Calcular(int indexPlanetaCalcul, String[] mPlanetes, String[] mRecursos, 
                       double[][] mDistancies, int[][] mDisponibilitats, int[][] mNecessitats) {

    // Comptador per mantenir l'id de cada node nou
    int comptadoridnode = 0;

    // Iniciem dades per fer el calcul.
    SolucioQAP sol = new SolucioQAP();
    sol.modificarPlaneta(mPlanetes[indexPlanetaCalcul]);
    sol.modificarNomAlgoritme(nomalgoritme);
    // IMPORTANT: En aquest cas, cada node que posem a llistanodes de la solucio sera una possible solucio.

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

    // Creem l'ArrayList de nodes
    ArrayList<bbNode> llistaNodes = new ArrayList<bbNode>();

    // Segons les necessitats pendents
    if(necessitatsPendents.size() < 1) {
      // SOLUCIO: El planeta no necessita res
      sol.modificarTerraformat(true);
      sol.modificarMillorRecorregut(0);
      sol.modificarObservacions("El planeta s'ha terraformat tot sol.");
      // Creem un node
      ArrayList<Integer> camiPla = new ArrayList<Integer>();
      camiPla.add(indexPlanetaCalcul);
      bbNode nodebb = new bbNode(comptadoridnode, -1, indexPlanetaCalcul, true, false, 0, 0, 0, 0, 0, 
                                  camiPla, null, null,null);
      llistaNodes.add(nodebb);
    } else {
      // Minim una necessitat per part del planeta de calcul

      // Planetes Pendents amb algun recurs disponible necessari pel planeta de calcul
      // Els ordenarem per distancia / quantitat de recursos que coincideixen amb els necessaris (minim un)
      // I calcularem una primera solucio

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

      // Ara crearem un array amb els planetes pendents ordenats
      ArrayList<infoPla> planetesPendents = new ArrayList<infoPla>();

      while(pqInfoPla.size() > 0) {
        infoPla inpla = new infoPla();
        inpla = pqInfoPla.poll();
        planetesPendents.add(inpla);
      }

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
        sol.modificarTerraformat(true);
        sol.modificarMillorRecorregut(millorRecorregut);
        sol.modificarObservacions("Nomes hi ha un planeta possible: "+planetesPendents.get(0).nom);
        // Creem el node
        ArrayList<Integer> camiPla = new ArrayList<Integer>();
        camiPla.add(indexPlanetaCalcul);
        infoPla infpl = planetesPendents.get(0);
        camiPla.add(infpl.idPlaneta);
        bbNode nodebb = new bbNode(comptadoridnode, -1, infpl.idPlaneta, true, false, 0, infpl.distancia, 0, 0, 0, 
                                   camiPla, null, null,null);
        llistaNodes.add(nodebb);
        
        // Si hi ha solucio i mes d'un planeta pendent continuem per buscar si n'hi ha una de millor
      } else if(hiHaSolucio && (qttPP >= 2)) {
        // Tenim solucio inicial i minim dos planetes

        // Matriu de planetes possibles a la solucio
        infoPla[] planetes = new infoPla[qttPP];
        
        for(int i=0;i<qttPP;i++) {
          planetes[i] = planetesPendents.get(i);
        }

        // ==================================================
        // Iniciem les dades pel calcul Tabu
        // ==================================================
        
        // Quantitat de cicles que aguanta a la llista tabu una vegada hi entra
        int qttCiclesTabu = 4;
        // Quantitat de aspirants
        int qttAsp = 4;

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

        // Matriu de solucio i solucio temporal
        int[] ordVis = new int[qttPP];
        int[] ordVisTmp = new int[qttPP];
        // La primera solucio es: 0 1 2 3 4 ...
        for(int i=0;i<qttPP;i++) {
          ordVis[i] = i;
          ordVisTmp[i] = i;
        }
        
        // Calculem la matriu de veins d'una solucio
        int qttVeins=(qttPP*(qttPP-1))/2;
        // Si la quantitat de aspirants es mes gran que la quantitat de veins el redueixo
        if(qttAsp>qttVeins) qttAsp = qttVeins;
        
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
        
        // Limit d'iteracions
        int limitIteracions = 10000;
        // Nombre maxim d'iteracions
        int qttIteracions = qttVeins;
        if(qttIteracions>limitIteracions) qttIteracions = limitIteracions;
        // Iteracio inici criteri d'aspiracio
        int iterAsp = (qttIteracions / 100) * 25;
        // Valor Aspiracio (Cota)
        double valorAspiracio = millorRecorregut;
        // Iteracio inici memoria llarg termini
        int iterMem = (qttIteracions / 100) * 70;

        int[][] tabu = new int[qttPP][qttPP];
        int[][] frecuencies = new int[qttPP][qttPP];
        
        // Iniciem llista Tabu (memoria a curt termini)
        // Iniciem llista frequencies (memoria a llarg termini)
        for(int i=0;i<qttPP;i++) {
          for(int j=0;j<qttPP;j++) {
            tabu[i][j]=0;
            frecuencies[i][j]=0;
          }
        }

        // Generem node solucio inicial
        bbNode nodSolIni = clcNodeSolucio(comptadoridnode++, indexPlanetaCalcul, qttPP, ordVis, planetes, necessitatsPendents, mDisponibilitats);
        llistaNodes.add(nodSolIni);

        // Fem iteracions fins arribar a qttIteracions
        int iter=1;
        do {
          // Avaluem tots els veins
          for(int fila=0;fila<qttVeins;fila++) {
            for(int j=0;j<qttPP;j++) {
              ordVisTmp[j]=ordVis[j]; // ordVis --> ordVisTmp
            }
            int traspas=ordVisTmp[veins[fila].posicio1];
            ordVisTmp[veins[fila].posicio1]=ordVisTmp[veins[fila].posicio2];
            ordVisTmp[veins[fila].posicio2]=traspas;
            // recorregut si es fa aquest canvi
            veins[fila].recorregut=calculaRecorregut(qttPP, ordVisTmp, planetes, necessitatsPendents, mDisponibilitats);
            
          }
          
          // Ara escollim els millors aspirants
          infoAsp[] aspirants = new infoAsp[qttAsp];
          // Els ordenem
          pqInfoAsp.clear();
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
          if(estat==2) {
            // Hem d'acabar
            break;
          }         
          // Actualitzem la llista tabu (nomes diagonal superior)
          for(int k=0;k<qttPP;k++) {
            for(int j=k+1;j<qttPP;j++) {
              if(tabu[k][j]>0) tabu[k][j]=tabu[k][j]-1;
            }
          }

          // Generem possible node solucio
          bbNode nodSol = clcNodeSolucio(comptadoridnode, indexPlanetaCalcul, qttPP, ordVis, planetes, necessitatsPendents, mDisponibilitats);
          // Si es una solucio possible fins al moment, l'afegim
          double recSol = nodSol.obtenirRecorregut();
          if(millorRecorregut > recSol) {
            millorRecorregut = recSol;
            nodSol.modificarIdNode(comptadoridnode++);
            llistaNodes.add(nodSol);
          } else if(millorRecorregut == recSol) {
            // Si no es una solucio repetida la inserim
            boolean bAfegir=false;
            if(llistaNodes.size() < 1) {
              bAfegir = true;
            } else {
              bAfegir = false;
              ArrayList<Integer> a1 = new ArrayList<Integer>(nodSol.obtenirCami());
              Collections.sort(a1);
              for(bbNode nn:llistaNodes) {
                // Cal que tingui el mateix recorregut
                if(recSol == nn.obtenirRecorregut()) {
                  // Cal que tingui el mateix nombre l'elements
                  if(nodSol.obtenirCami().size() == nn.obtenirCami().size()) {
                    ArrayList<Integer> a2 = new ArrayList<Integer>(nn.obtenirCami());
                    Collections.sort(a2);
                    for(int i=0;i<a1.size();i++) {
                      if(a1.get(i) != a2.get(i)) {
                        bAfegir = true;
                        break;
                      }
                    }
                  }
                }
              }
            }
            if(bAfegir) {
              nodSol.modificarIdNode(comptadoridnode++);
              llistaNodes.add(nodSol);
            }
          }

          // Propera iteracio
          iter=iter+1;
        } while (iter <= qttIteracions);

        // Guardem millor solucio
        sol.modificarTerraformat(true);
        sol.modificarMillorRecorregut(millorRecorregut);

      } else {
        // No hi ha solucio
        sol.modificarObservacions("No hi ha solucio possible !");
      }
    }
    // Si hem creat nodes els informem a la solucio
    if(llistaNodes.size() >= 1) sol.modificarLlistaNodes(llistaNodes);
    return sol;
  }
  
  // Torna el node corresponent a una solucio concreta
  private bbNode clcNodeSolucio(int comptadoridnode, int indexPlanetaCalcul, int qtt, int[] ordVis, infoPla[] planetes, ArrayList<Integer> necessitatsPendents,  int[][] mDisponibilitats) {
    // Cami seguit
    ArrayList<Integer> camiPla = new ArrayList<Integer>();
    camiPla.add(indexPlanetaCalcul);
    // Recorregut
    double recorregut = 0;
    // Fem un arraylist amb les necessitats pendents
    ArrayList<Integer> necPen = new ArrayList<Integer>(necessitatsPendents);
    // Anem recorrent els planetes de la solucio
    int darrerPlaneta = -1;
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
        darrerPlaneta = inpla.idPlaneta;
        camiPla.add(inpla.idPlaneta);
      }
      if(necPen.size() < 1) break;
    }
    // Darreres comprovacions
    boolean esSolucio = true;
    if(necPen.size() >= 1) esSolucio = false;
    if(darrerPlaneta < 0) darrerPlaneta = indexPlanetaCalcul;
    bbNode nodebb = new bbNode(comptadoridnode, -1, darrerPlaneta, esSolucio, false, 0, recorregut, 0, 0, 0, 
                               camiPla, null, null,null);
    return nodebb;
  }
  
  // Calcula el recorregut d'aquesta solucio
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
      }
      if(necPen.size() < 1) break;
    }
    if(necPen.size() >= 1) recorregut = Double.MAX_VALUE;

    return recorregut;
  }

  // Calcula un texte amb la sequencia de planetes visitats d'aquesta solucio
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
        sPlanetes = sPlanetes + " " + inpla.nom;
      }
      if(necPen.size() < 1) break;
    }
    if(necPen.size() >= 1) sPlanetes = "ERROR";

    return sPlanetes;
  }
}
