import java.util.*;

public class BranchBoundEager extends BranchBound {

  public BranchBoundEager() {
    super();
    super.modificarNomAlgoritme(super.obtenirNomAlgoritme()+" eager");
  }

  protected void gesBranch(int indexPlanetaCalcul, ArrayList<Integer> planetesPendents, ArrayList<Integer> necessitatsPendents,
                           String[] mPlanetes, double[][] mDistancies, int[][] mDisponibilitats, SolucioQAP sol) {

    // Variables per controlar la solucio
    boolean solucioTrobada = false;
    double millorRecorregut = 0;
    // Comptador per mantenir l'id de cada node nou
    int comptadoridnode = 0;
//-----------------------------------------------------------------------------------
    // Comptador de nodes de l'arbre
    int comptadornodesarbre = 0;
//-----------------------------------------------------------------------------------

    // Preparem la cua amb prioritat: Primer ordena per OrdrePrimer Invers.
    // Si son iguals, llavors desempata per OrdreSegon.
    PriorityQueue<bbNode> pqNodes = new PriorityQueue<bbNode>(10,  new Comparator<bbNode>() {
      public int compare(bbNode n1, bbNode n2) {
        int r = n2.obtenirOrdrePrimer()-n1.obtenirOrdrePrimer();
        if(r == 0) {
          double c = n1.obtenirOrdreSegon()-n2.obtenirOrdreSegon();
          if(c > 0) r = 1;
          else if(c<0) r = -1;
        } 
        return (r);
      }
    });

    // Creem l'ArrayList de nodes
    ArrayList<bbNode> llistaNodes = new ArrayList<bbNode>();
    // Creem el primer node
    ArrayList<Integer> iniCami = new ArrayList<Integer>();
    iniCami.add(indexPlanetaCalcul);
//-----------------------------------------------------------------------------------
    // Creem el node arrel
    double cotarestantarrel = clcGilmore(planetesPendents, necessitatsPendents, 
                                  mDisponibilitats, mDistancies[indexPlanetaCalcul]);
    ArbreNode mutArrel = new ArbreNode(mPlanetes[indexPlanetaCalcul],comptadornodesarbre++,comptadoridnode);
    bbNode nodeSel = new bbNode(comptadoridnode++, -1, indexPlanetaCalcul, false, false, 0, 0, cotarestantarrel, 0, 0, 
                                iniCami, necessitatsPendents, planetesPendents,mutArrel);
//-----------------------------------------------------------------------------------
    // Afegim a la llista
    llistaNodes.add(nodeSel);
   
    // Iniciem bucle fins que no quedi cap mes node
    boolean bContinuem = false;
    do {
      // Definim nivell per tots els seus fills
      int nivell = nodeSel.obtenirNivell()+1;
      // Agafem pare per tots els seus fills
      int idpare = nodeSel.obtenirIdNode();
//-----------------------------------------------------------------------------------
      // Node arbre
      ArbreNode mutNodePare = nodeSel.obtenirArbreNode();
//-----------------------------------------------------------------------------------
      // Ramifico totes les possibilitats de nodeSel i els poso en cua o els podo
      for(Integer idPlanetaVisitat: nodeSel.obtenirPlanetesPendents()){
//-----------------------------------------------------------------------------------
        // Afegeixo el node fill al node pare
        ArbreNode mutNodeFill = new ArbreNode(mPlanetes[idPlanetaVisitat],comptadornodesarbre++,-1);
        if(mutNodePare!=null) mutNodePare.afegirFill(mutNodeFill);
//-----------------------------------------------------------------------------------
        // Actualitzo recorregut
        double recorregut = nodeSel.obtenirRecorregut() + mDistancies[indexPlanetaCalcul][idPlanetaVisitat];
        // Actualitzo necessitats pendents despres de visitar idPlanetaVisitat
        ArrayList<Integer> novesNecessitatsPendents = new ArrayList<Integer>();
        for(Integer idNecessitatPendent: nodeSel.obtenirNecessitatsPendents()){
          if(mDisponibilitats[idPlanetaVisitat][idNecessitatPendent] != 1) {
            novesNecessitatsPendents.add(idNecessitatPendent);
          }
        }
        // Si no hi ha mes necessitats, es una solucio (o solucio parcial)
        if(novesNecessitatsPendents.size() == 0) {
          // Si ja hi havia solucio mirem si es millor
          if(solucioTrobada) {
            if(recorregut < millorRecorregut) millorRecorregut = recorregut;
          } else {
            solucioTrobada = true;
            millorRecorregut = recorregut;
          }
          // Nomes la guardem si es igual o millor que el millor recorregut
          if(recorregut<=millorRecorregut) {
            ArrayList<Integer> nouCami = new ArrayList<Integer>(nodeSel.obtenirCami());
            nouCami.add(idPlanetaVisitat);
//-----------------------------------------------------------------------------------
            mutNodeFill.modificarIdNode(comptadoridnode);
//-----------------------------------------------------------------------------------
            bbNode nodeNou = new bbNode(comptadoridnode++, idpare, idPlanetaVisitat, true, false, nivell, 
                                        recorregut, 0, 0, 0, nouCami, null, null, mutNodeFill);
//-----------------------------------------------------------------------------------
            llistaNodes.add(nodeNou);
          }
        } else {
          // Si no hi ha solucio trobada o n'hi ha pero el recorregut es
          // millor que l'actual continuo
          if((!solucioTrobada) || ((solucioTrobada) && (recorregut <= millorRecorregut))) {
            // Refem planetes pendents
            ArrayList<Integer> nousPlanetesPendents = new ArrayList<Integer>();
            for(Integer ip: nodeSel.obtenirPlanetesPendents()){
              // Saltem planeta actual
            	if(ip != idPlanetaVisitat) {
                // Nomes ens quedem planetes amb disponibilitats necessaries
          		  for(Integer ir: novesNecessitatsPendents){
	                if(mDisponibilitats[ip][ir] == 1) {
                    nousPlanetesPendents.add(ip);
	                  break; 
	                }
                }
              }
            }
          
            // Nomes continuem si hi ha planetes pendents amb alguna disponibilitat necessaria
            if(nousPlanetesPendents.size() >= 1) {
              // Afegim el planeta al cami seguit
              ArrayList<Integer> nouCami = new ArrayList<Integer>(nodeSel.obtenirCami());
              nouCami.add(idPlanetaVisitat);

              // Calculo la cota restant despres de visitar el planeta visitat
              double cotarestant = 0;
              double total = recorregut;
              // Cal que hi hagi com a minim dos planetes pendents
              if(nousPlanetesPendents.size() >= 2){
                // Calculem la cota dels que queden
                cotarestant = clcGilmore(nousPlanetesPendents, novesNecessitatsPendents, 
                             mDisponibilitats, mDistancies[indexPlanetaCalcul]);
              } else if(nousPlanetesPendents.size() == 1) {
                // En aquest cas es la distancia
                cotarestant = mDistancies[indexPlanetaCalcul][nousPlanetesPendents.get(0)];
              }
              // Calculem el total
              total = total + cotarestant;
              // Si no hi ha solucio trobada o n'hi ha pero el total es
              // millor que l'actual continuo
              if((!solucioTrobada) || ((solucioTrobada) && (total <= millorRecorregut))) {
//-----------------------------------------------------------------------------------
                mutNodeFill.modificarIdNode(comptadoridnode);
//-----------------------------------------------------------------------------------
                // Ordre Primer = 0
                // Ordre Segon = recorregut + cotarestant
                bbNode nodeNou = new bbNode(comptadoridnode++, idpare, idPlanetaVisitat, false, false, nivell, 
                                 recorregut, cotarestant, 0, total, nouCami, novesNecessitatsPendents, 
                                 nousPlanetesPendents, mutNodeFill);
//-----------------------------------------------------------------------------------
                llistaNodes.add(nodeNou);
                pqNodes.add(nodeNou);
              }
            }
          }
        }
      }
      // Inicialment no continuem
      bContinuem = false;
      // Agafo proper node segons la prioritat de la PriorityQueue
      nodeSel = pqNodes.poll();
      if(nodeSel != null) {
        double total = nodeSel.obtenirOrdreSegon();
        // Si no hi ha solucio trobada o n'hi ha pero el total es
        // millor que l'actual continuo
        // En cas contrari acabarem del tot
        if((!solucioTrobada) || ((solucioTrobada) && (total <= millorRecorregut))) bContinuem = true;
      }
    } while (bContinuem);

    if(solucioTrobada) {
      sol.modificarTerraformat(true);
      sol.modificarMillorRecorregut(millorRecorregut);
      sol.modificarObservacions("");
      sol.modificarLlistaNodes(llistaNodes);
//-----------------------------------------------------------------------------------
      sol.assignarArbre(mutArrel);
//-----------------------------------------------------------------------------------
    }
  }        
  

}