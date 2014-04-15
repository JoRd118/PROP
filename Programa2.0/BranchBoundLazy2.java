import java.util.*;
import java.io.IOException;
/*
 *
 *Algorisme B&B
 *Tecnica -> Lazy
 *Cota ->
 */
public class BranchBoundLazy2{
    
    private double[][] mDistancies;
    private int[][] mDisponibilitats;
    private int[][] mNecessitats;
    private String[] mPlanetes;
    private String[] mRecursos;
    
    private Solucio solBB;//un cop tenim la solucio usem l'obejecte per enviar-ho a la classe Solucio.
    
    final int IFPL_ID = 0;
    final int IFPL_COINCIDENTS = 1;
    final int IFPL_DISTANCIA = 2;
    
    public BranchBoundLazy2(double[][] mDistancies, int[][] mDisponibilitats, int[][] mNecessitats, String[] mPlanetes, String[] mRecursos){
        this.mDistancies = mDistancies;
        this.mDisponibilitats = mDisponibilitats;
        this.mNecessitats = mNecessitats;
        this.mPlanetes = mPlanetes;
        this.mRecursos = mRecursos;
    }
    
    public void codi(){
        int idPlanetaActual;
        int cmpIdNode = 0;
        int qttRecursos = mNecessitats[0].length;
        int qttPlanetes = mDistancies[0].length;
        for(int i = 0; i < mDistancies[0].length; ++i){
            idPlanetaActual = i;
            System.out.println("=======================");
            System.out.println("Planeta Actual ["+idPlanetaActual+"]: "+mPlanetes[idPlanetaActual]);
            
            // Necessitats Pendents
            ArrayList<Integer> necessitatsPendents = new ArrayList<Integer>();
            
            // Si el recurs te un 1 a la matriu de Recursos Necessitats(mNecessitats) l'afegim
            // a l'arrayList necessitatsPendents.
            for(int ir=0;ir<qttRecursos;ir++) {
                if(mNecessitats[idPlanetaActual][ir] == 1) necessitatsPendents.add(ir);
            }
            // Numero de necessitats pendents del planeta actual
            System.out.print("  Necessitats Pendents "+necessitatsPendents.size()+":");
            for(Integer ir: necessitatsPendents){
                System.out.print(" ["+ir+"]: "+mRecursos[ir]);
            }
            System.out.println();
            
            // Planetes Pendents
            ArrayList<Integer[]> planetesPendents = new ArrayList<Integer[]>();
            
            // Mirem si haurem de mirar algun planeta o no --> si el planeta te algun recurs a oferir
            // que es necessitat pel planeta actual
            for(int ip=0;ip<qttPlanetes;ip++) {
                // Saltem Planeta Actual
                if(ip != idPlanetaActual) {
                    int coincidents = 0;
                    for(Integer ir: necessitatsPendents){
                        if(mDisponibilitats[ip][ir] == 1) coincidents++;
                    }
                    if(coincidents >= 1) {		// Si el planeta te 0 coincidents no l'afegirem
                        // Passo a planeta pendent
                        Integer[] infoPlaneta = new Integer[3];
                        infoPlaneta[IFPL_ID] = ip;
                        infoPlaneta[IFPL_COINCIDENTS] = coincidents;
                        infoPlaneta[IFPL_DISTANCIA] = (int) mDistancies[idPlanetaActual][ip];
                        planetesPendents.add(infoPlaneta);		// Afegim el planeta (id, nombre rec. coincidents, distancia)
                    }
                }
            }
            
            System.out.print("  Planetes Pendents "+planetesPendents.size()+":");	// Nombre de planetes pendents
            for(Integer[] infoPlaneta: planetesPendents){
                System.out.print(" {"+infoPlaneta[IFPL_ID]+":"+mPlanetes[infoPlaneta[IFPL_ID]]
                                 +"("+infoPlaneta[IFPL_COINCIDENTS]+")["+infoPlaneta[IFPL_DISTANCIA]+"]}");
            }
            System.out.println();
            
            // Millor Solucio Actual
            // Busquem una primera solucio
            int hiHaSolucio = 0;
            double millorRecorregut = 0;
            ArrayList<Integer> millorSolucio = new ArrayList<Integer>();
            ArrayList<Integer> necPen = new ArrayList<Integer>(necessitatsPendents);
            
            for(Integer[] infoPlaneta: planetesPendents){
                int ip = infoPlaneta[IFPL_ID];
                int esSolucio = 0;
                ListIterator<Integer> listIterator = necPen.listIterator();
                while(listIterator.hasNext()) {
                    int ir = listIterator.next();
                    if(mDisponibilitats[ip][ir] == 1) {
                        esSolucio = 1;
                        listIterator.remove();
                    }
                }
                if(esSolucio == 1) {
                    millorRecorregut = millorRecorregut + infoPlaneta[IFPL_DISTANCIA];
                    millorSolucio.add(ip);
                }
            }
            
            // Si hem satisfet totes les necessitats pendents, es una possible solucio
            if(necPen.size() == 0) hiHaSolucio = 1;
            
            if(hiHaSolucio == 1) {
                System.out.println("Solucio inicial:");
                System.out.println("  Millor Recorregut "+millorRecorregut);
                System.out.print("  Planetes:");
                
                for(Integer ip: millorSolucio) System.out.print(" "+mPlanetes[ip]);
                
                System.out.println();
            } else {
                System.out.println("No hi ha Solucio !!!");
            }
            
            /*
             // Proves amb PriorityQueue ordenada
             
             PriorityQueue<bbNode> pqNodes = new PriorityQueue<bbNode>(20,
             new Comparator<bbNode>() {
             // overriding the compare method
             public int compare(bbNode i, bbNode j) {
             double c = (i.obtenirRecorregut()*i.obtenirCoincidents())-(j.obtenirRecorregut()*j.obtenirCoincidents());
             if(c == 0) c = i.obtenirCoincidents() - j.obtenirCoincidents();
             int r = 0;
             if(c > 0) r = 1;
             else if(c<0) r = -1;
             return (r);
             }
             }
             );
             
             ArrayList<Integer> a = new ArrayList<Integer>();
             
             pqNodes.add(new bbNode(9, 20, 1, a, a));
             pqNodes.add(new bbNode(8, 24, 1, a, a));
             pqNodes.add(new bbNode(7, 20, 2, a, a));
             pqNodes.add(new bbNode(6, 21, 1, a, a));
             pqNodes.add(new bbNode(5, 99, 1, a, a));
             pqNodes.add(new bbNode(4, 25, 1, a, a));
             pqNodes.add(new bbNode(3, 77, 1, a, a));
             pqNodes.add(new bbNode(2,  0, 1, a, a));
             pqNodes.add(new bbNode(1,  1, 1000, a, a));
             
             while(pqNodes.size() > 0) {
             System.out.print("idPlaneta: "+pqNodes.peek().obtenirIdPlaneta());
             System.out.print(" Distancia: "+pqNodes.peek().obtenirRecorregut());
             System.out.println(" Coincidents: "+pqNodes.poll().obtenirCoincidents());
             }
             */
            
            /* ==========================================================================
             planetaActual				= Planeta que volem terraformar.
             millorSolucio				= ArrayList dels idPlaneta de la millor solucio.
             millorRecorregut		= Recorregut de la millor solucio.
             planetesPendents		= ArrayList d'infoPlaneta dels planetes que poden
             formar part de la solucio.
             necessitatsPendents	= ArrayList dels idRecurs pendents per satisfer de cara
             a terraformar el planeta actual.
             
             pqNodes							= PriorityQueue ordenada amb els nodes pendents.
             Classe bbNode:
             idPlaneta
             Distancia
             qttRecursos utils si "ara" vaig a aquest planeta.
             necessitatsPendents si he anat al planeta.
             planetesPendents que encara tenen algun recurs necessari.
             
             */
            
            // CUA DE PRIORITAT
            PriorityQueue<bbNode> pqNodes = new PriorityQueue<bbNode>(20,
                                                                      new Comparator<bbNode>() {
                                                                          // overriding the compare method
                                                                          public int compare(bbNode i, bbNode j) {
                                                                              //					double c = (i.obtenirRecorregut()/i.obtenirCoincidents())-(j.obtenirRecorregut()/j.obtenirCoincidents());
                                                                              double c = i.obtenirRecorregut()-j.obtenirRecorregut();
                                                                              if(c == 0) c = i.obtenirCoincidents() - j.obtenirCoincidents();
                                                                              int r = 0;
                                                                              if(c > 0) r = 1;
                                                                              else if(c<0) r = -1;
                                                                              return (r);
                                                                          }
                                                                      }
                                                                      );
            
            // Nomes si hi ha solucio
            
            // FALTA !!!!! Comprovar que hi ha solucio i que no es ell mateix
            
//->Codi a camviar#######################################################
            if(hiHaSolucio == 1) {
                // Planetes amb algun recurs disponible necessari
                ArrayList<Integer> planetesPendentsInicials = new ArrayList<Integer>();
                for(Integer[] infoPlaneta: planetesPendents) planetesPendentsInicials.add(infoPlaneta[IFPL_ID]);
                // Cami inicial = Planeta Actual
                ArrayList<Integer> camiInicial = new ArrayList<Integer>();
                camiInicial.add(idPlanetaActual);
                
                bbNode nodeSel = new bbNode(cmpIdNode++, idPlanetaActual, 0, 0, camiInicial, necessitatsPendents, planetesPendentsInicials);
                
                do {
                    // Ramifico totes les possibilitats de nodeSel i els poso en cua o els podo
                    for(Integer idPlanetaPendent: nodeSel.obtenirPlanetesPendents()){
                        // Actualitzo recorregut
                        double recorregut = nodeSel.obtenirRecorregut() + mDistancies[idPlanetaActual][idPlanetaPendent];
                        // Si el recorregut ja es pitjor que l'actual millor solucio el descarto (podo)
                        if(recorregut < millorRecorregut) {
                            // Actualitzo necessitats pendents
                            ArrayList<Integer> novesNecessitatsPendents = new ArrayList<Integer>();
                            for(Integer idNecessitatPendent: nodeSel.obtenirNecessitatsPendents()){
                                if(mDisponibilitats[idPlanetaPendent][idNecessitatPendent] != 1) {
                                    novesNecessitatsPendents.add(idNecessitatPendent);
                                }
                            }
                            // Si no hi ha mes necessitats, es una millor solucio perque el seu recorregut
                            // es mes petit.
                            if(novesNecessitatsPendents.size() == 0) { // Millor solucio fins al moment (no podat)(no en cua)
                                millorRecorregut = recorregut;
                                millorSolucio.clear();
                                millorSolucio = new ArrayList<Integer>(nodeSel.obtenirCami());
                                millorSolucio.add(idPlanetaPendent); // !!!!!!!!!!!!!!!!!!!!! Cami recorregut
                            } else {
                                // Comprovem si quedaran planetes pendents
                                ArrayList<Integer> nousPlanetesPendents = new ArrayList<Integer>();
                                for(Integer ip: nodeSel.obtenirPlanetesPendents()){
                                    // Saltem planeta actual
                                    if(ip != idPlanetaPendent) {
                                        int disp = 0;
                                        for(Integer ir: novesNecessitatsPendents){
                                            if(mDisponibilitats[ip][ir] == 1) disp++;
                                        }
                                        // Si hi ha algun recurs disponible necessari el poso a planetes pendents
                                        if(disp >= 1) nousPlanetesPendents.add(ip);
                                    }
                                }
                                // Nomes continuo si hi ha nous planetes pendents
                                // !!!!!!!!!!!! FALTA COMPROVAR QUE AMB ELS PLANETES PENDENTS HI HAURA SOLUCIO
                                if(nousPlanetesPendents.size() >= 1) {
                                    // Si queden planetes pendents guardo el node per ramificar quan toqui
                                    // Afegim el planeta al cami seguit
                                    ArrayList<Integer> nouCami = new ArrayList<Integer>(nodeSel.obtenirCami());
                                    nouCami.add(idPlanetaPendent);
                                    // Afegim node a la cua de prioritat de possibles nodes pendents
                                    bbNode nodeNou = new bbNode(cmpIdNode++, idPlanetaPendent, recorregut, 0, nouCami, novesNecessitatsPendents, nousPlanetesPendents);
                                    pqNodes.add(nodeNou); // Posat en cua (no podat)
                                    // ===========================================================================
                                    // ===========================================================================
                                    System.out.println("===============");
                                    System.out.println("Posat en cua: "+nodeNou.obtenirIdNode());
                                    ArrayList<bbNode> lll = new ArrayList<bbNode>();
                                    while(pqNodes.size() > 0) {
                                        bbNode nnn = new bbNode();
                                        nnn = pqNodes.poll();
                                        lll.add(nnn);
                                        System.out.print("["+nnn.obtenirIdNode()+"]");
                                        System.out.print("idPlaneta: "+nnn.obtenirIdPlaneta());
                                        System.out.print(" Distancia: "+nnn.obtenirRecorregut());
                                        System.out.print(" Cami:");
                                        for(Integer ncip: nnn.obtenirCami())System.out.print(" "+ncip);
                                        //System.out.print(" Coincidents: "+nnn.obtenirCoincidents());
                                        if(nodeNou.obtenirIdNode() == nnn.obtenirIdNode()) {
                                            System.out.println(" <");
                                        } else {
                                            System.out.println();
                                        }
                                    }
                                    System.out.println("---");
                                    for(bbNode bbn: lll) pqNodes.add(bbn);
                                    // ===========================================================================
                                    // ===========================================================================
                                }
                            }
                        } else {
                            System.out.println("...................");
                            System.out.println("Descarto per recorregut: "+recorregut+" >= "+millorRecorregut);
                            System.out.print("["+nodeSel.obtenirIdNode()+"]");
                            System.out.print("idPlaneta: "+nodeSel.obtenirIdPlaneta()+ " --> " + idPlanetaPendent);
                            System.out.println(" Distancia: "+nodeSel.obtenirRecorregut());
                            System.out.print("Cami:");
                            for(Integer ncip: nodeSel.obtenirCami())System.out.print(" "+ncip);
                            //System.out.print(" Coincidents: "+nodeSel.obtenirCoincidents());
                            System.out.println();
                            System.out.println("...................");
                        }
                    }
                    // Agafo proper node segons la prioritat de la PriorityQueue (COMPARE !!!!)
                    nodeSel = pqNodes.poll();
                } while ((nodeSel != null) && (nodeSel.obtenirRecorregut() < millorRecorregut));
            }
            //->Codi a camviar END
            if(hiHaSolucio == 1) {
                System.out.println("Solucio final:");
                System.out.println("  Millor Recorregut "+millorRecorregut);
                System.out.print("  Planetes:");
                for(Integer ip: millorSolucio) System.out.print(" "+mPlanetes[ip]);
                System.out.println();
            } else {
                System.out.println("No hi ha Solucio !!!");
            }
            
            
            
        }
        
    }

}