import java.util.*;
import java.io.Console;

public class bb {
	
		public static class bbNode {
			private int idnode;
			private int idplaneta;
			private double recorregut;
			private int coincidents;
			ArrayList<Integer> cami;
			ArrayList<Integer> necessitatspendents;
			ArrayList<Integer> planetespendents;
			
			public bbNode() {
				idnode=-1;
				idplaneta = -1;
				recorregut = -1;
				coincidents = -1;				
				cami = new ArrayList<Integer>();
				necessitatspendents = new ArrayList<Integer>();
				planetespendents = new ArrayList<Integer>();
			}

			public bbNode(int idnode, int idplaneta, double recorregut, int coincidents,
										ArrayList<Integer> cami,
										ArrayList<Integer> necessitatspendents,
										ArrayList<Integer> planetespendents) {
				this.idnode = idnode;
				this.idplaneta = idplaneta;
				this.recorregut = recorregut;
				this.coincidents = coincidents;				
				this.cami = new ArrayList<Integer>(cami);
				this.necessitatspendents = new ArrayList<Integer>(necessitatspendents);
				this.planetespendents = new ArrayList<Integer>(planetespendents);
			}
			
			public int obtenirIdNode() { return idnode; }
			public int obtenirIdPlaneta() { return idplaneta; }
			public double obtenirRecorregut() { return recorregut; }
			public int obtenirCoincidents() { return coincidents; }
			public ArrayList<Integer> obtenirCami() { return cami; }
			public ArrayList<Integer> obtenirNecessitatsPendents() { return necessitatspendents; }
			public ArrayList<Integer> obtenirPlanetesPendents() { return planetespendents; }

			public void modificarIdPlaneta(int idplaneta) { this.idplaneta = idplaneta; }
			public void modificarRecorregut(double recorregut) { this.recorregut = recorregut; }
			public void modificarCoincidents(int coincidents) { this.coincidents = coincidents; }
			
		};

	public static void main(String[] args) {
		
		int cmpIdNode = 0;
		
		
		// Constants per infoPlaneta
		final int IFPL_ID = 0;
		final int IFPL_COINCIDENTS = 1;
		final int IFPL_DISTANCIA = 2;

		System.out.println("----- BB -----");
		
		int qttPlanetes = 5;		// size() ArrayList Planetes
		String mPlanetes[] = {"P0","P1","P2","P3","P4"};

		int qttRecursos = 10;		// size() ArrayList Recursos
		String mRecursos[] = {"r0","r1","r2","r3","r4","r5","r6","r7","r8","r9"};

		int mDistancies[][] =			{	{0,1,2,3,4},
											{1,0,2,3,4},
											{2,2,0,4,1},
											{3,3,4,0,1},
											{4,4,1,1,0}
										};

		int mDisponibilitats[][] =	{	{1,1,1,1,0,0,1,0,0,0}, //P0
										{0,0,0,1,0,0,1,0,1,0}, //P1
										{1,1,0,1,0,0,1,1,1,0}, //P2
										{0,0,1,1,1,1,0,0,0,1}, //P3
										{1,0,0,1,0,0,0,0,0,1}  //P4
									};


		int mNecessitats[][] =		{	{0,1,0,0,1,0,0,1,0,0}, //P0
										{0,0,0,1,0,0,1,0,0,0}, //P1
										{1,0,1,0,1,0,1,0,1,1}, //P2
										{0,0,1,0,1,0,0,1,0,0}, //P3
										{1,1,1,0,1,1,1,0,1,1}  //P4
									};

/*
		System.out.println("Planetes:");
		for(int ip=0;ip<qttPlanetes;ip++) {
			System.out.print(" ["+ip+"]: "+mPlanetes[ip]);
		}
		System.out.println();
		System.out.println("Recursos:");
		for(int ir=0;ir<qttRecursos;ir++) {
			System.out.print(" ["+ir+"]: "+mRecursos[ir]);
		}
		System.out.println();
*/

		
		// Farem el planeta idPlanetaActual
		int idPlanetaActual = 2; // P3

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
					infoPlaneta[IFPL_DISTANCIA] = mDistancies[idPlanetaActual][ip];					
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
		
		if(hiHaSolucio == 1) {
			System.out.println("Solucio final:");
			System.out.println("  Millor Recorregut "+millorRecorregut);
			System.out.print("  Planetes:");
			for(Integer ip: millorSolucio) System.out.print(" "+mPlanetes[ip]);
			System.out.println();
		} else {
			System.out.println("No hi ha Solucio !!!");
		}
		
		
		Console console = System.console();
		String xintro = console.readLine("<intro>");
	}
}