import java.util.*;
import java.io.IOException;

public class Controlador_Domini_Planeta {
	private TST<Planeta> Conjunt_Planetes_Assignat;
	private TST<Planeta> Conjunt_Planetes_Desassignat;
	private TST<TST<Recurs> > Necessitats_Planetes;
	private TST<Paquet> Conjunt_Paquets;
	private Controlador_Domini_Recurs cr;
	private Controlador_Domini_Paquet cp;
	private Controlador_Dades_Planeta cdp;
    private static String msg_planeta_no_exists = "Error de Planeta: Planeta demanat no existeix.";
    private static String msg_planeta_repetit = "Error de planeta: Ja existeix un planeta amb aquest nom.";
    private static String msg_recurs_repetit = "Error de Recurs: Ja existeix un recurs amb aquest nom.";
    private static String msg_recurs_no_exists = "Error de Recurs: Recurs demanat no existeix.";




	public Controlador_Domini_Planeta(){
		Conjunt_Planetes_Assignat = new TST<Planeta>();
		Conjunt_Planetes_Desassignat = new TST<Planeta>();
		Conjunt_Paquets = new TST<Paquet>();
		Necessitats_Planetes = new TST<TST<Recurs> >();
		cr = new Controlador_Domini_Recurs();
		cp = new Controlador_Domini_Paquet(cr);
		cdp = new Controlador_Dades_Planeta();
	}

	public Controlador_Domini_Planeta(Controlador_Domini_Paquet p, Controlador_Domini_Recurs r) {
	 	Conjunt_Planetes_Assignat = new TST<Planeta>();
	 	Conjunt_Planetes_Desassignat = new TST<Planeta>();
	 	Necessitats_Planetes = new TST<TST<Recurs> >();
	 	Conjunt_Paquets = new TST<Paquet>();
		cr = r;
	 	cp = p;
		cdp = new Controlador_Dades_Planeta();
	}

	
	// public void altaPlaneta() {		// Alta planeta random

	// 	String nomdefault = "default "+

	// }


	public void altaPlaneta(String nom, Coordenades coord, boolean classeM) {
		if(Conjunt_Planetes_Desassignat.contains(nom)) throw new IllegalArgumentException(msg_planeta_repetit);
		else {
			TST<Recurs> aux = new TST<Recurs>();
			Planeta p = new Planeta(nom, coord, classeM);
			Conjunt_Planetes_Desassignat.insert(nom, p);
			Necessitats_Planetes.insert(nom,aux);
		}
	}

	public void baixaPlaneta(String nom) {
        if(Conjunt_Planetes_Desassignat.contains(nom)){
        	Necessitats_Planetes.remove(nom); 
        	Conjunt_Planetes_Desassignat.remove(nom);
       	} else if (Conjunt_Planetes_Assignat.contains(nom)) {
       		Necessitats_Planetes.remove(nom);
       		Conjunt_Planetes_Assignat.remove(nom);
        } else { 
       		throw new IllegalArgumentException(msg_planeta_no_exists);
        }		
	}

	public Planeta assignarPlaneta(String nomP) {
		if (Conjunt_Planetes_Desassignat.contains(nomP)) {
			Planeta p = Conjunt_Planetes_Desassignat.obtain(nomP);
			Conjunt_Planetes_Assignat.insert(nomP, p);
			Conjunt_Planetes_Desassignat.remove(nomP);
			return p;
		} else throw new IllegalArgumentException(msg_planeta_no_exists);
	}

	public void desassignarPlaneta(String nomP) {
		if (Conjunt_Planetes_Assignat.contains(nomP)) {
			Planeta p = Conjunt_Planetes_Assignat.obtain(nomP);
			Conjunt_Planetes_Desassignat.insert(nomP, p);
			Conjunt_Planetes_Assignat.remove(nomP);
		} else throw new IllegalArgumentException(msg_planeta_no_exists);
	}

	public void modificarNom(String nom, String newnom) {
		if (Conjunt_Planetes_Desassignat.contains(newnom)) throw new IllegalArgumentException(msg_planeta_repetit);
		else {
			if (Conjunt_Planetes_Desassignat.contains(nom)) {
				Planeta pl = Conjunt_Planetes_Desassignat.obtain(nom);
				TST<Recurs> aux = new TST<Recurs>();
				Necessitats_Planetes.remove(nom);
				Conjunt_Planetes_Desassignat.remove(nom);				
				pl.modificacioNom(newnom);
				Conjunt_Planetes_Desassignat.insert(newnom, pl);
				Necessitats_Planetes.insert(newnom, aux);
			} else if (Conjunt_Planetes_Assignat.contains(nom)) {
				Planeta pl = Conjunt_Planetes_Assignat.obtain(nom);
				TST<Recurs> aux = new TST<Recurs>();
				Necessitats_Planetes.remove(nom);
				Conjunt_Planetes_Assignat.remove(nom);
				pl.modificacioNom(newnom);
				Conjunt_Planetes_Assignat.insert(newnom, pl);
				Necessitats_Planetes.insert(newnom, aux);
			} else { throw new IllegalArgumentException(msg_planeta_no_exists); }
		}
	}
	public void modificarCoordenades(String nom, int x, int y) {
		if(Conjunt_Planetes_Desassignat.contains(nom)){	Conjunt_Planetes_Desassignat.obtain(nom).modificacioCoordenades(x, y); }
        else if(Conjunt_Planetes_Assignat.contains(nom)) { Conjunt_Planetes_Assignat.obtain(nom).modificacioCoordenades(x, y); }
        else { 
        	throw new IllegalArgumentException(msg_planeta_no_exists);	
        }		
	}

	public void modificarClasse(String nom, boolean classeM) {
		if (Conjunt_Planetes_Desassignat.contains(nom)){ Conjunt_Planetes_Desassignat.obtain(nom).modificacioClasse(classeM); }
        else if (Conjunt_Planetes_Assignat.contains(nom)) { Conjunt_Planetes_Assignat.obtain(nom).modificacioClasse(classeM); }
        else { 
        	throw new IllegalArgumentException(msg_planeta_no_exists);
        }
	}

	public int obtenirId(String nom) {
		if (Conjunt_Planetes_Desassignat.contains(nom)) return Conjunt_Planetes_Desassignat.obtain(nom).obtenirId();
		else if (Conjunt_Planetes_Assignat.contains(nom)) return Conjunt_Planetes_Assignat.obtain(nom).obtenirId();
		else throw new IllegalArgumentException(msg_planeta_no_exists);
	}
	

	// public String obtenirNom(int id) {
	// 	if (Conjunt_Planetes.contains(id)) return Conjunt_Planetes.obtain(id).obtenirNom();
	// 	else throw new IllegalArgumentException(msg_planeta_no_exists);
	// }

	public boolean obtenirClasse(String nom) {;
		if (Conjunt_Planetes_Desassignat.contains(nom)) return Conjunt_Planetes_Desassignat.obtain(nom).obtenirClasse();
		else if (Conjunt_Planetes_Assignat.contains(nom)) return Conjunt_Planetes_Assignat.obtain(nom).obtenirClasse();
		else throw new IllegalArgumentException(msg_planeta_no_exists);
	}


	public Coordenades obtenirCoordenades(String nom) {
		if (Conjunt_Planetes_Desassignat.contains(nom)) return Conjunt_Planetes_Desassignat.obtain(nom).obtenirCoordenades();
		else if (Conjunt_Planetes_Assignat.contains(nom)) return Conjunt_Planetes_Assignat.obtain(nom).obtenirCoordenades();
		else throw new IllegalArgumentException(msg_planeta_no_exists);
	}


	public Planeta obtenirPlaneta(String nom) {
		
		if (Conjunt_Planetes_Desassignat.contains(nom)) {return Conjunt_Planetes_Desassignat.obtain(nom); }
		else if (Conjunt_Planetes_Assignat.contains(nom)) return Conjunt_Planetes_Assignat.obtain(nom);
		else { throw new IllegalArgumentException(msg_planeta_no_exists);}
	}


	// OBTENIR TOTES LES NECESSITATS DE 1 PLANETA
	//public String obtenirNecessitats(Planeta p) {}

	// OBTENIR LA ID DEL PAQUET Del PLANETA 
	//public int obtenirIdPaquet(Planeta p) {}
/*
    public void guardarPlanetes(String nomFitxer) throws IOException{
        cdp.writeTextFile(nomFitxer, llistatGuardar());
    }
    public void carregarPlanetes(){
    	ArrayList s = cdp.readTextFile(nomFitxer);
    	while (!s.empty()) {
    		String id = s.get(0);
    		Planeta plan = new Planeta(Integer.parseInt(id));
    		s.remove(0);
    		if (s.get(0).equals("0")) Conjunt_Planetes_Desassignat.insert(id, plan);
    		else Conjunt_Planetes_Assignat.insert(id, plan);
    		s.remove(0);
    		if (s.get(0).equals("*"))
    	}
    }
*/
    public String llistarPlanetesDesassignat() {
		Iterable<String> s = Conjunt_Planetes_Desassignat.obtainAllTST();
		String aux = new String();
		for(String a: s) {
		 	aux = aux + a +"\n";
		}
		return aux;
	}

	public String llistarPlanetesAssignat() {
		Iterable<String> s = Conjunt_Planetes_Assignat.obtainAllTST();
		String aux = new String();
		for(String a: s) {
		 	aux = aux + a +"\n";
		}
		return aux;
	}

	public void altaNecessitats(String nomP, String nomR) {
		if (Conjunt_Planetes_Desassignat.contains(nomP) || Conjunt_Planetes_Assignat.contains(nomP)) {
			if (cr.validarRecurs(nomR)) {
				TST<Recurs> aux = Necessitats_Planetes.obtain(nomP);
				if (aux.contains(nomR)) {
					throw new IllegalArgumentException(msg_recurs_repetit);
				} else {
					Recurs rec = cr.obtenirRecurs(nomR);
					aux.insert(nomR, rec);
				}
			}
		} else {
			throw new IllegalArgumentException(msg_planeta_no_exists);
		}
	}

	public void baixaNecessitats(String nomP, String nomR) {
		if (Conjunt_Planetes_Desassignat.contains(nomP) || Conjunt_Planetes_Assignat.contains(nomP)) {
			TST<Recurs> aux = Necessitats_Planetes.obtain(nomP);
			if (aux.contains(nomR)) {
				aux.remove(nomR);
			} else throw new IllegalArgumentException(msg_recurs_no_exists);
		} else throw new IllegalArgumentException(msg_planeta_no_exists);
	}

	// ASSIGNAR PAQUET!!
	public void assignarPaquet(String nomP, int id) {
		if (Conjunt_Planetes_Desassignat.contains(nomP) || Conjunt_Planetes_Assignat.contains(nomP)) {
			Conjunt_Paquets.insert(nomP,cp.obtenirPaquet(id));
		}
		else throw new IllegalArgumentException(msg_planeta_no_exists);
	}


	public Iterable<String> obtenirRecursosDisponibles(String nomP) {
		if (Conjunt_Planetes_Desassignat.contains(nomP) || Conjunt_Planetes_Assignat.contains(nomP)) {
			Paquet p = Conjunt_Paquets.obtain(nomP);
			return cp.llistatRecursosPaquetIterator(p);
		}
		else throw new IllegalArgumentException(msg_planeta_no_exists);
	}

	public Iterable<String> obtenirNecessitats(String nomP) {
		if (Conjunt_Planetes_Desassignat.contains(nomP) || Conjunt_Planetes_Assignat.contains(nomP)) {
			TST<Recurs> aux = Necessitats_Planetes.obtain(nomP);
			return aux.obtainAllTST();		
		} else throw new IllegalArgumentException(msg_planeta_no_exists);
	}
/*
	private ArrayList<String> llistatGuardar() {
		ArrayList<String> list = new ArrayList<String>();
        Iterable<String> s = Necessitats_Planetes.obtainAllTST();
        for(String a : s){
            list.add(a);
            Planeta p;
            if (Conjunt_Planetes_Desassignat.contains(a)) {
            	list.add("0");
            	p = Conjunt_Planetes_Desassignat.obtain(a);
            }
            else {		// Conjunt_Planetes_Assignat
            	list.add("1");		
            	p = Conjunt_Planetes_Assignat.obtain(a); 
            }
           	if (p.teCoordenades()) {	// Té coordenades 
            	list.add(Integer.toString(p.obtenirCoordenadesX()));
            	list.add(Integer.toString(p.obtenirCoordenadesY()));
            else {
            	list.add("*");
            }
            TST<Recurs> aux = Necessitats_Planetes.obtain(a);
            Iterable<String> s1 = aux.obtainAllTST();
            for (String nom : s1) {
                list.add(nom);
            }
            list.add("#");

            Planeta aux1 = Conjunt_Paquets.obtain(a);
            list.add(cp.obtenirIdPaquet());
        }
        cp.guardarPaquets();
        return list;
	}
*/
}