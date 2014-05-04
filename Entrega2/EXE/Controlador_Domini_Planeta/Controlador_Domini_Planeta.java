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
    private static String msg_planeta_paquet_assginat = "Error de Planeta: Aquest Planeta ja te un Paquet assignat.";
    private static String msg_planeta_cap_paquet_assginat = "Error de Planeta: Aquest Planeta no te un Paquet assignat.";
    private static String msg_planeta_no_classM = "Error Planeta: el Planeta no es classe M.";
    private static String msg_planeta_classM = "Error Planeta: el Planeta no es classe M.";
    
    
    
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
    
    //Pre: coord que siguin valides
    //Post: S'haura creat un planeta en el Conjunt_Planetes_Desassignat 
	public void altaPlaneta(String nom, Coordenades coord, boolean classeM) {
		if(Conjunt_Planetes_Desassignat.contains(nom)||Conjunt_Planetes_Assignat.contains(nom)) throw new IllegalArgumentException(msg_planeta_repetit);
		else {
			TST<Recurs> aux = new TST<Recurs>();
			Planeta p = new Planeta(nom, coord, classeM);
			Conjunt_Planetes_Desassignat.insert(nom, p);
			Necessitats_Planetes.insert(nom,aux);
		}
	}

	//Pre:
	//Post: S'esborra el planeta amb el nom demanat    
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
    
    //Pre: 
    //Post: Si el planeta nomP passar en el vector de Conjunt_Planetes_Assignat 
    //		si es que estava el el vector de Conjunt_Planetes_Desassignat 
	public void assignarPlaneta(String nomP) {
		if (Conjunt_Planetes_Desassignat.contains(nomP)) {
			Planeta p = Conjunt_Planetes_Desassignat.obtain(nomP);
			Conjunt_Planetes_Assignat.insert(nomP, p);
			Conjunt_Planetes_Desassignat.remove(nomP);
		} else throw new IllegalArgumentException(msg_planeta_no_exists);
	}
    
    //Pre:
    //Post: Si el planeta nomp esta el el vector Conjunt_Planetes_Assignat el
    //		el passar en el vector Conjunt_Planetes_Desassignat
	public void desassignarPlaneta(String nomP) {
		if (Conjunt_Planetes_Assignat.contains(nomP)) {
			Planeta p = Conjunt_Planetes_Assignat.obtain(nomP);
			Conjunt_Planetes_Desassignat.insert(nomP, p);
			Conjunt_Planetes_Assignat.remove(nomP);
		} else throw new IllegalArgumentException(msg_planeta_no_exists);
	}
    
    //Pre:
    //Post: El nom de un planeta es canvia per el nou nom
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
	//Pre:
	//Post: Les coordenades de un planeta son modificades per unes noves coordenades x i y
	public void modificarCoordenades(String nom, int x, int y) {
		if(Conjunt_Planetes_Desassignat.contains(nom)){	Conjunt_Planetes_Desassignat.obtain(nom).modificacioCoordenades(x, y); }
        else if(Conjunt_Planetes_Assignat.contains(nom)) { Conjunt_Planetes_Assignat.obtain(nom).modificacioCoordenades(x, y); }
        else {
        	throw new IllegalArgumentException(msg_planeta_no_exists);
        }
	}
    //Pre:
    //Post: La classeM de un planeta passar a ser de classeM si classeM es true
	public void modificarClasse(String nom, boolean classeM) {
        if(Conjunt_Planetes_Assignat.contains(nom) || Conjunt_Paquets.contains(nom))throw new IllegalArgumentException(msg_planeta_classM);
            else{
                if (Conjunt_Planetes_Desassignat.contains(nom)){ Conjunt_Planetes_Desassignat.obtain(nom).modificacioClasse(classeM); }
                else if (Conjunt_Planetes_Assignat.contains(nom)) { Conjunt_Planetes_Assignat.obtain(nom).modificacioClasse(classeM); }
                else {
                    throw new IllegalArgumentException(msg_planeta_no_exists);
                }
            }
    }
    
    //Pre:
    //Post: Retornar id del planeta amb el nom nom
	public int obtenirId(String nom) {
		if (Conjunt_Planetes_Desassignat.contains(nom)) return Conjunt_Planetes_Desassignat.obtain(nom).obtenirId();
		else if (Conjunt_Planetes_Assignat.contains(nom)) return Conjunt_Planetes_Assignat.obtain(nom).obtenirId();
		else throw new IllegalArgumentException(msg_planeta_no_exists);
	}
	
    
	// public String obtenirNom(int id) {
	// 	if (Conjunt_Planetes.contains(id)) return Conjunt_Planetes.obtain(id).obtenirNom();
	// 	else throw new IllegalArgumentException(msg_planeta_no_exists);
	// }
    
    //Pre:
    //Post: Retorna true si el paquet amb el nom nom es de la classe m
    //		Retorna false si el paquet amb el nom nom no es de la classe m
	public boolean obtenirClasse(String nom) {;
		if (Conjunt_Planetes_Desassignat.contains(nom)) return Conjunt_Planetes_Desassignat.obtain(nom).obtenirClasse();
		else if (Conjunt_Planetes_Assignat.contains(nom)) return Conjunt_Planetes_Assignat.obtain(nom).obtenirClasse();
		else throw new IllegalArgumentException(msg_planeta_no_exists);
	}
    
    //Pre:
    //Post: Retornar les coordenades d'un planeta amb el nom nom
	public Coordenades obtenirCoordenades(String nom) {
		if (Conjunt_Planetes_Desassignat.contains(nom)) return Conjunt_Planetes_Desassignat.obtain(nom).obtenirCoordenades();
		else if (Conjunt_Planetes_Assignat.contains(nom)) return Conjunt_Planetes_Assignat.obtain(nom).obtenirCoordenades();
		else throw new IllegalArgumentException(msg_planeta_no_exists);
	}
    
    //Pre:
    //Post: Retornar el planeta amb el nom nom
	public Planeta obtenirPlaneta(String nom) {
		
		if (Conjunt_Planetes_Desassignat.contains(nom)) {return Conjunt_Planetes_Desassignat.obtain(nom); }
		else if (Conjunt_Planetes_Assignat.contains(nom)) return Conjunt_Planetes_Assignat.obtain(nom);
		else { throw new IllegalArgumentException(msg_planeta_no_exists);}
	}
    
    
	// OBTENIR TOTES LES NECESSITATS DE 1 PLANETA
	//public String obtenirNecessitats(Planeta p) {}
    
	// OBTENIR LA ID DEL PAQUET Del PLANETA
	//public int obtenirIdPaquet(Planeta p) {}
    
    
    //Pre:
    //Post: Retornar un String on hi han tots els nom dels planetes no assignats
    public String llistarPlanetesDesassignat() {
		Iterable<String> s = Conjunt_Planetes_Desassignat.obtainAllTST();
		String aux = new String();
		for(String a: s) {
		 	aux = aux + a +"\n";
		}
		return aux;
	}
    
    //Pre:
    //Post: Retornar un String on hi han tots els nom dels planetes assignats
	public String llistarPlanetesAssignat() {
		Iterable<String> s = Conjunt_Planetes_Assignat.obtainAllTST();
		String aux = new String();
		for(String a: s) {
		 	aux = aux + a +"\n";
		}
		return aux;
	}
    
    //Pre:
    //Post: Afegeix una necessitat a un planeta
	public void altaNecessitats(String nomP, String nomR) {
		if (Conjunt_Planetes_Desassignat.contains(nomP) || Conjunt_Planetes_Assignat.contains(nomP)) {
            Planeta p;
            if(Conjunt_Planetes_Assignat.contains(nomP)) p = Conjunt_Planetes_Assignat.obtain(nomP);
            else{
                p = Conjunt_Planetes_Desassignat.obtain(nomP);
            }
			if(p.obtenirClasse()){
                if (cr.validarRecurs(nomR)) {
                    TST<Recurs> aux = Necessitats_Planetes.obtain(nomP);
                    if (aux.contains(nomR)) {
                        throw new IllegalArgumentException(msg_recurs_repetit);
                    }
                    else {
                        Recurs rec = cr.obtenirRecurs(nomR);
                        aux.insert(nomR, rec);
                    }
                }
                else throw new IllegalArgumentException(msg_recurs_no_exists);
            }
            else throw new IllegalArgumentException(msg_planeta_no_classM);
        }
        else {
			throw new IllegalArgumentException(msg_planeta_no_exists);
		}
	}
    
    //Pre:
    //Post: Baixa una necessitat a un planeta amb nom nomP
	public void baixaNecessitats(String nomP, String nomR) {
		if (Conjunt_Planetes_Desassignat.contains(nomP) || Conjunt_Planetes_Assignat.contains(nomP)) {
			TST<Recurs> aux = Necessitats_Planetes.obtain(nomP);
			if (aux.contains(nomR)) {
				aux.remove(nomR);
			} else throw new IllegalArgumentException(msg_recurs_no_exists);
		} else throw new IllegalArgumentException(msg_planeta_no_exists);
	}
    
	// ASSIGNAR PAQUET!!
	//Pre:
	//Post: Assignar un paquet a un planeta amb nom nomP
	public void assignarPaquet(String nomP, int id) {
		if (Conjunt_Planetes_Desassignat.contains(nomP) || Conjunt_Planetes_Assignat.contains(nomP)) {
			if(Conjunt_Paquets.contains(nomP)) throw new IllegalArgumentException(msg_planeta_paquet_assginat);
			else {
                Planeta p;
                if(Conjunt_Planetes_Assignat.contains(nomP)) p = Conjunt_Planetes_Assignat.obtain(nomP);
                else{
                    p = Conjunt_Planetes_Desassignat.obtain(nomP);
                }
                if(p.obtenirClasse()){
                    Conjunt_Paquets.insert(nomP,cp.obtenirPaquetAssignar(id));
                }
                else throw new IllegalArgumentException(msg_planeta_no_classM);
            }
		}
		else throw new IllegalArgumentException(msg_planeta_no_exists);
	}
    
    //Pre:
    //Post: Desassignar un paqueta a un planeta amb nom nomP
	public void desassignarPaquet(String nomP) {
		if (Conjunt_Planetes_Desassignat.contains(nomP) || Conjunt_Planetes_Assignat.contains(nomP)) {
			if(!Conjunt_Paquets.contains(nomP))throw new IllegalArgumentException(msg_planeta_cap_paquet_assginat);
			else {
				Paquet pp = Conjunt_Paquets.obtain(nomP);
				int id_aux = cp.obtenirIdPaquet(pp);
				cp.desassignarPaquet(id_aux);
				Conjunt_Paquets.remove(nomP);
			}
		}
		else throw new IllegalArgumentException(msg_planeta_no_exists);
	}
	
    //Pre:
    //Post: Retornar un un Iterable<String> on hi ha tots els noms dels recursos d'un paquet
	public Iterable<String> obtenirRecursosDisponibles(String nomP) {
		if (Conjunt_Planetes_Desassignat.contains(nomP) || Conjunt_Planetes_Assignat.contains(nomP)) {
			if(Conjunt_Paquets.contains(nomP)){
				Paquet p = Conjunt_Paquets.obtain(nomP);
				return cp.llistatRecursosPaquetIterator(p);
			}
			else throw new IllegalArgumentException(msg_planeta_cap_paquet_assginat);
		}
		else throw new IllegalArgumentException(msg_planeta_no_exists);
	}
    
    //Pre:
    //Post: Retornar un un Iterable<String> on hi ha tots els noms dels recursos d'un planeta
	public Iterable<String> obtenirNecessitats(String nomP) {
		if (Conjunt_Planetes_Desassignat.contains(nomP) || Conjunt_Planetes_Assignat.contains(nomP)) {
			TST<Recurs> aux = Necessitats_Planetes.obtain(nomP);
			return aux.obtainAllTST();
		} else throw new IllegalArgumentException(msg_planeta_no_exists);
	}
    
    //Pre:
    //Post: Guardar en el fitxer nomFitxer totes les dades becessaries pero tornar a carregar i que tot estigui igual
	public void guardarPlanetes(String nomFitxer) throws IOException{
        cdp.writeTextFile(nomFitxer, llistatGuardar());
    }
    
    //Pre:
    //Post: Carregar del fitxer nomFitxer totes les dades i ho restaura tot
    public void carregarPlanetes(String nomFitxer) throws IOException {
    	ArrayList<String> s = cdp.readTextFile(nomFitxer);
    	while (!s.isEmpty()) {
    		String nom = s.get(0);
    		s.remove(0);
    		Coordenades c = new Coordenades();
    		c.modificarCoordenades(Integer.parseInt(s.get(0)), Integer.parseInt(s.get(1)));
    		Planeta plan;
    		if (s.get(2).equals("1")) altaPlaneta(nom,c,true);
    		else altaPlaneta(nom,c,false);
    		s.remove(0);
    		s.remove(0);
    		s.remove(0);
    		assignarPaquet(nom, Integer.parseInt(s.get(0)));
    		s.remove(0);
    		while (!s.get(0).equals("#")) {
    			altaNecessitats(nom,s.get(0));
    			s.remove(0);
    		}
    		s.remove(0);
    	}
    }
    //NOVES FUNCIONS!
   public void borrar_paquet2(String id){
    	if(Conjunt_Paquets.contains(id)){
    		desassignarPaquet(id);
    	}
    	cp.baixaPaquet(Integer.parseInt(id));        
    }

    public void borrar_recurs2(String nom){
    	Iterable<String> planetes = Conjunt_Planetes_Assignat.obtainAllTST();
        for(String a : planetes){
        	Planeta aux = Conjunt_Planetes_Assignat.obtain(a);
        	Iterable<String> necesitats = obtenirNecessitats(aux.obtenirNom());
        	for(String b : necesitats){
        		if(b.equals(nom)) baixaNecessitats(a, b);
        	}
        }
        planetes = Conjunt_Planetes_Desassignat.obtainAllTST();
        for(String a : planetes){
        	Planeta aux = Conjunt_Planetes_Assignat.obtain(a);
        	Iterable<String> necesitats = obtenirNecessitats(aux.obtenirNom());
        	for(String b : necesitats){
        		if(b.equals(nom)) baixaNecessitats(a, b);
        	}
        }
    	cp.borrar_recurs3(nom);
    }
    public void modificar_nom_recurs2(String old_name, String new_name){
    	TST<Planeta> planetes_amb_recurs = new TST<Planeta>();
        Iterable<String> planetes = Conjunt_Planetes_Assignat.obtainAllTST();
        for(String a : planetes){
        	Planeta aux = Conjunt_Planetes_Assignat.obtain(a);
        	Iterable<String> necesitats = obtenirNecessitats(aux.obtenirNom());
        	for(String b : necesitats){
        		if(b.equals(old_name)){
        			planetes_amb_recurs.insert(a, aux);
        			baixaNecessitats(a, b);
        		} 
        	}
        }
       planetes = Conjunt_Planetes_Desassignat.obtainAllTST();
        for(String a : planetes){
        	Planeta aux = Conjunt_Planetes_Assignat.obtain(a);
        	Iterable<String> necesitats = obtenirNecessitats(aux.obtenirNom());
        	for(String b : necesitats){
        		if(b.equals(old_name)){
        			planetes_amb_recurs.insert(a, aux);
        			baixaNecessitats(a, b);
        		} 
        	}
        }

    	cp.modificar_nom_recurs3(old_name, new_name);
    	Iterable<String> planetesrecurs = planetes_amb_recurs.obtainAllTST();
    	for(String a : planetesrecurs){
    		altaNecessitats(a, new_name);
    	}
    }

    
    //Pre:
    //Post: Retornar un ArrayList<String> on hi han totes les dades ben colocades
	private ArrayList<String> llistatGuardar() {
		ArrayList<String> list = new ArrayList<String>();
        Iterable<String> s = Necessitats_Planetes.obtainAllTST();
        for(String a : s){
            list.add(a);
            Planeta p;
            if (Conjunt_Planetes_Desassignat.contains(a)) p = Conjunt_Planetes_Desassignat.obtain(a);
            else p = Conjunt_Planetes_Assignat.obtain(a);
            Coordenades c = p.obtenirCoordenades();
            list.add(Integer.toString(c.obtenirCoordenadesX()));
            list.add(Integer.toString(c.obtenirCoordenadesY()));
            if (p.obtenirClasse()) list.add("1");
            else list.add("0");
            Paquet pac = Conjunt_Paquets.obtain(a);
            list.add(Integer.toString(cp.obtenirIdPaquet(pac)));
            TST<Recurs> aux = Necessitats_Planetes.obtain(a);
            Iterable<String> s1 = aux.obtainAllTST();
            for (String nom : s1) {
                list.add(nom);
            }
            list.add("#");
        }
        return list;
	}
    
}