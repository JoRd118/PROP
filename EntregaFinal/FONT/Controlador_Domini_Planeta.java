import java.util.*;
import java.io.IOException;

public class Controlador_Domini_Planeta {
	private TST<Planeta> Conjunt_Planetes_Assignat;
	private TST<Planeta> Conjunt_Planetes_Desassignat;
	private Controlador_Domini_Recurs cr;
	private Controlador_Domini_Paquet cp;
	private Controlador_Dades cd;
    private Identificador id;
    
    private static String msg_planeta_no_exists = "Error de Planeta: Planeta demanat no existeix.";
    private static String msg_planeta_repetit = "Error de planeta: Ja existeix un planeta amb aquest nom.";
    private static String msg_recurs_repetit = "Error de Recurs: Ja existeix un recurs amb aquest nom.";
    private static String msg_recurs_no_exists = "Error de Recurs: Recurs demanat no existeix.";
    private static String msg_planeta_paquet_assginat = "Error de Planeta: Aquest Planeta ja te un Paquet assignat.";
    private static String msg_planeta_cap_paquet_assginat = "Error de Planeta: Hi ha una Planeta que no te un Paquet assignat.";
    private static String msg_planeta_no_classM = "Error Planeta: el Planeta no es classe M.";
    private static String msg_planeta_classM = "Error Planeta: el Planeta no es classe M.";
    private static String msg_planeta_NOClass = "Error Planeta: el Planeta NO es pot canviar de classe";
    private static String msg_carregar = "Error de Planeta: Carregar no es pot portar a terme perque ja s'han introduit dades.";
    private static String msg_planeta_assignat = "Error de Planeta: Planeta ja assignat";
    
    
	public Controlador_Domini_Planeta(){
		Conjunt_Planetes_Assignat = new TST<Planeta>();
		Conjunt_Planetes_Desassignat = new TST<Planeta>();
		cr = new Controlador_Domini_Recurs();
		cp = new Controlador_Domini_Paquet(cr);
		cd = new Controlador_Dades();
        id = new Identificador();
	}
    
	public Controlador_Domini_Planeta(Controlador_Domini_Paquet p, Controlador_Domini_Recurs r) {
	 	Conjunt_Planetes_Assignat = new TST<Planeta>();
	 	Conjunt_Planetes_Desassignat = new TST<Planeta>();
		cr = r;
	 	cp = p;
		cd = new Controlador_Dades();
        id = new Identificador();
	}
    
    
    //Pre: coord que siguin valides
    //Post: S'haura creat un planeta en el Conjunt_Planetes_Desassignat
	public void altaPlaneta(String nom, Coordenades coord, boolean classeM) {
		if(Conjunt_Planetes_Desassignat.contains(nom)||Conjunt_Planetes_Assignat.contains(nom)) throw new IllegalArgumentException(msg_planeta_repetit);
		else {
			Planeta p = new Planeta(nom, id.id() , coord, classeM);
			Conjunt_Planetes_Desassignat.insert(nom, p);
		}
	}
    
    public void altaPlanetaVista(String nom, String coorden, boolean classeM) {
        if(Conjunt_Planetes_Desassignat.contains(nom)||Conjunt_Planetes_Assignat.contains(nom)) throw new IllegalArgumentException(msg_planeta_repetit);
        else {
            String[] aux = coorden.split(",");
            Coordenades coord = new Coordenades(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]));
            Planeta p = new Planeta(nom, id.id() , coord, classeM);
            Conjunt_Planetes_Desassignat.insert(nom, p);
        }
    }
    
	//Pre:
	//Post: S'esborra el planeta amb el nom demanat
	public void baixaPlaneta(String nom) {
        if(Conjunt_Planetes_Desassignat.contains(nom)){
            Planeta aux = Conjunt_Planetes_Desassignat.obtain(nom);
            Paquet aux2 = aux.obtenirPaquet();
            if(aux2 != null){
                cp.desassignarPaquet(cp.obtenirIdPaquet(aux2));
            }
            Conjunt_Planetes_Desassignat.remove(nom);
        } else if (Conjunt_Planetes_Assignat.contains(nom)) {
            Planeta aux = Conjunt_Planetes_Assignat.obtain(nom);
            Paquet aux2 = aux.obtenirPaquet();
            if(aux2 != null){
                cp.desassignarPaquet(cp.obtenirIdPaquet(aux2));
            }
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
		} else throw new IllegalArgumentException(msg_planeta_assignat);
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
		if (Conjunt_Planetes_Desassignat.contains(newnom)|| Conjunt_Planetes_Assignat.contains(newnom)) throw new IllegalArgumentException(msg_planeta_repetit);
		else {
			if (Conjunt_Planetes_Desassignat.contains(nom)) {
				Planeta pl = Conjunt_Planetes_Desassignat.obtain(nom);
				Conjunt_Planetes_Desassignat.remove(nom);
				pl.modificacioNom(newnom);
				Conjunt_Planetes_Desassignat.insert(newnom, pl);
			} else if (Conjunt_Planetes_Assignat.contains(nom)) {
				Planeta pl = Conjunt_Planetes_Assignat.obtain(nom);
				Conjunt_Planetes_Assignat.remove(nom);
				pl.modificacioNom(newnom);
				Conjunt_Planetes_Assignat.insert(newnom, pl);
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
    
    public void modificarCoordenadesVista(String nom, String coorden) {
        String[] aux = coorden.split(",");
        int x = Integer.parseInt(aux[0]);
        int y = Integer.parseInt(aux[1]);
        if(Conjunt_Planetes_Desassignat.contains(nom)){
            Conjunt_Planetes_Desassignat.obtain(nom).modificacioCoordenades(x, y);
        } else if(Conjunt_Planetes_Assignat.contains(nom)) {
            Conjunt_Planetes_Assignat.obtain(nom).modificacioCoordenades(x, y);
        } else throw new IllegalArgumentException(msg_planeta_no_exists);
    }
    
    //Pre:
    //Post: La classeM de un planeta passar a ser de classeM si classeM es true
	public void modificarClasse(String nom, boolean classeM) {
        if(Conjunt_Planetes_Assignat.contains(nom) || Conjunt_Planetes_Desassignat.contains(nom)) {
            if (Conjunt_Planetes_Desassignat.contains(nom)){ 
                Planeta aux = Conjunt_Planetes_Desassignat.obtain(nom);
                if ((aux.obtenirPaquet() == null)) aux.modificacioClasse(classeM);
                else throw new IllegalArgumentException(msg_planeta_NOClass);
            } else throw new IllegalArgumentException(msg_planeta_NOClass);
        } else throw new IllegalArgumentException(msg_planeta_no_exists);
    }
    
    //Pre:
    //Post: Retornar id del planeta amb el nom nom
	public int obtenirId(String nom) {
		if (Conjunt_Planetes_Desassignat.contains(nom)) return Conjunt_Planetes_Desassignat.obtain(nom).obtenirId();
		else if (Conjunt_Planetes_Assignat.contains(nom)) return Conjunt_Planetes_Assignat.obtain(nom).obtenirId();
		else throw new IllegalArgumentException(msg_planeta_no_exists);
	}
    
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
    
    public String obtenirCoordenadesVista(String nom) {
        Coordenades c = new Coordenades();
        if (Conjunt_Planetes_Desassignat.contains(nom)) {
            c = Conjunt_Planetes_Desassignat.obtain(nom).obtenirCoordenades();
            int xd = c.obtenirCoordenadesX();
            int yd = c.obtenirCoordenadesY();
            String sd = xd + "," + yd;
            return sd;
        }
        else if (Conjunt_Planetes_Assignat.contains(nom)) {
            c = Conjunt_Planetes_Assignat.obtain(nom).obtenirCoordenades();
            int xa = c.obtenirCoordenadesX();
            int ya = c.obtenirCoordenadesY();
            String sa = xa + "," + ya;
            return sa;
        }
        else throw new IllegalArgumentException(msg_planeta_no_exists);
    }
    
    //Pre:
    //Post: Retornar el planeta amb el nom nom
	public Planeta obtenirPlaneta(String nom) {
		if (Conjunt_Planetes_Desassignat.contains(nom)) {return Conjunt_Planetes_Desassignat.obtain(nom); }
		else if (Conjunt_Planetes_Assignat.contains(nom)) return Conjunt_Planetes_Assignat.obtain(nom);
		else { throw new IllegalArgumentException(msg_planeta_no_exists);}
	}
    
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
           		Recurs r = cr.obtenirRecurs(nomR);
           		p.afegirNecessitat(r);
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
			Planeta p;
			if(Conjunt_Planetes_Assignat.contains(nomP)) p = Conjunt_Planetes_Assignat.obtain(nomP);
			else p = Conjunt_Planetes_Desassignat.obtain(nomP);
			if (p.obtenirClasse()) {
				p.eliminarNecessitat(nomR);
			}
		} else throw new IllegalArgumentException(msg_planeta_no_exists);
	}
    
	// ASSIGNAR PAQUET!!
	//Pre:
	//Post: Assignar un paquet a un planeta amb nom nomP
	public void assignarPaquet(String nomP, int id) {
		if (Conjunt_Planetes_Desassignat.contains(nomP) || Conjunt_Planetes_Assignat.contains(nomP)) {
            Planeta p;
            if(Conjunt_Planetes_Assignat.contains(nomP)) p = Conjunt_Planetes_Assignat.obtain(nomP);
            else p = Conjunt_Planetes_Desassignat.obtain(nomP);
            if(p.obtenirClasse()){
             	if(p.obtenirPaquet() == null){
                    Paquet pq = cp.obtenirPaquetAssignar(id);
                    p.assignarPaquet(pq);
                }
                else{ throw new IllegalArgumentException(msg_planeta_paquet_assginat);}
            } else throw new IllegalArgumentException(msg_planeta_no_classM);
		} else throw new IllegalArgumentException(msg_planeta_no_exists);
	}
    
    //Pre:
    //Post: Desassignar un paqueta a un planeta amb nom nomP
	public void desassignarPaquet(String nomP) {
		if (Conjunt_Planetes_Desassignat.contains(nomP) || Conjunt_Planetes_Assignat.contains(nomP)) {
			Planeta p;
            if (Conjunt_Planetes_Assignat.contains(nomP)) p = Conjunt_Planetes_Assignat.obtain(nomP);
            else p = Conjunt_Planetes_Desassignat.obtain(nomP);
			if (p.obtenirClasse()) {
                Paquet aux = p.obtenirPaquet();
                cp.desassignarPaquet(aux.obtenirId());
                p.desassignarPaquet();
            }
		} else throw new IllegalArgumentException(msg_planeta_no_exists);
	}
	
    //Pre:nomP
    //Post: Retornar un Iterable<String> on hi ha tots els noms dels recursos d'un paquet
	public Iterable<String> obtenirRecursosDisponibles(String nomP) {
		if (Conjunt_Planetes_Desassignat.contains(nomP) || Conjunt_Planetes_Assignat.contains(nomP)) {
			Planeta p;
			if (Conjunt_Planetes_Assignat.contains(nomP)) p = Conjunt_Planetes_Assignat.obtain(nomP);
			else p = Conjunt_Planetes_Desassignat.obtain(nomP);
			if (p.obtenirClasse() && p.obtenirPaquet() != null) {
				Paquet pq = p.obtenirPaquet();
                
				return cp.llistatRecursosPaquetIterator(cp.obtenirIdPaquet(pq));
			}
			else throw new IllegalArgumentException(msg_planeta_cap_paquet_assginat);
		}
		else throw new IllegalArgumentException(msg_planeta_no_exists);
	}
    
    public String obtenirRecursosDisponiblesVista(String nomP) throws IOException{
        if (Conjunt_Planetes_Desassignat.contains(nomP) || Conjunt_Planetes_Assignat.contains(nomP)) {
            Planeta p;
            if (Conjunt_Planetes_Assignat.contains(nomP)) p = Conjunt_Planetes_Assignat.obtain(nomP);
            else p = Conjunt_Planetes_Desassignat.obtain(nomP);
            if (p.obtenirClasse()) {
                Paquet pq = p.obtenirPaquet();
                
                return cp.llistatRecursosPaquet(cp.obtenirIdPaquet(pq));
            }
            else throw new IllegalArgumentException(msg_planeta_cap_paquet_assginat);
        }
        else throw new IllegalArgumentException(msg_planeta_no_exists);
    }
    
    //Pre:
    //Post: Retornar un un Iterable<String> on hi ha tots els noms dels recursos d'un planeta
	public Iterable<String> obtenirNecessitats(String nomP) {
		if (Conjunt_Planetes_Desassignat.contains(nomP) || Conjunt_Planetes_Assignat.contains(nomP)) {
			Planeta p;
			if (Conjunt_Planetes_Assignat.contains(nomP)) p = Conjunt_Planetes_Assignat.obtain(nomP);
			else p = Conjunt_Planetes_Desassignat.obtain(nomP);
			TST<Recurs> aux = p.obtenirNecessitats();
			return aux.obtainAllTST();
		} else throw new IllegalArgumentException(msg_planeta_no_exists);
	}
    
    public String obtenirNecessitatsVista(String nomP) {
        if (Conjunt_Planetes_Desassignat.contains(nomP) || Conjunt_Planetes_Assignat.contains(nomP)) {
            Planeta p;
            if (Conjunt_Planetes_Assignat.contains(nomP)) p = Conjunt_Planetes_Assignat.obtain(nomP);
            else{
                p = Conjunt_Planetes_Desassignat.obtain(nomP); }
            TST<Recurs> aux = p.obtenirNecessitats();
            Iterable<String> aux1 = aux.obtainAllTST();
            String llistat = new String();
            for (String nom : aux1) {
                llistat += nom + "\n";
            }
            return llistat;
        }
        else{
            throw new IllegalArgumentException(msg_planeta_no_exists);}
    }
    
    public void borrar_paquet2(int id){
        Iterable<String> planetes = Conjunt_Planetes_Assignat.obtainAllTST();
        for(String a : planetes){
            Planeta aux = Conjunt_Planetes_Assignat.obtain(a);
            Paquet p = aux.obtenirPaquet();
            if(p != null && id == p.obtenirId()) desassignarPaquet(aux.obtenirNom());
        }
        planetes = Conjunt_Planetes_Desassignat.obtainAllTST();
        for(String a : planetes){
            Planeta aux = Conjunt_Planetes_Desassignat.obtain(a);
            Paquet p = aux.obtenirPaquet();
            if(p != null && id == p.obtenirId()) desassignarPaquet(aux.obtenirNom());
        }
    	cp.baixaPaquet(id);
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
        	Planeta aux = Conjunt_Planetes_Desassignat.obtain(a);
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
        	Planeta aux = Conjunt_Planetes_Desassignat.obtain(a);
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
    //Post: Guardar en el fitxer nomFitxer totes les dades becessaries pero tornar a carregar i que tot estigui igual
    public void guardarPlanetes(String nomFitxer) throws IOException{
        cd.obrirFitxer(nomFitxer);
        cd.deleteFile();
        guardar();
        cd.tancarFitxer();
    }
    
    //Pre:
    //Post: Carregar del fitxer nomFitxer totes les dades i ho restaura tot
    public void carregarPlanetes(String nomFitxer) throws IOException {
        id.reset();
        if (Conjunt_Planetes_Assignat.nElements() > 0 || Conjunt_Planetes_Desassignat.nElements() > 0) throw new IllegalArgumentException(msg_carregar);
        cd.obrirFitxer(nomFitxer);
        String d = cd.readTextFile();
        String[] dades = d.split("#");
        for(int i = 0; i < dades.length - 1; ++i) {
            String[] aux = dades[i].split("\n");
            Coordenades aux1 = new Coordenades(Integer.parseInt(aux[1]), Integer.parseInt(aux[2]));
            if(aux[3].equals("1")) {
                altaPlaneta(aux[0], aux1, true);
                if(!aux[4].equals("NULL")) assignarPaquet(aux[0], Integer.parseInt(aux[4]));
                for(int j = 5; j < aux.length; ++j) {
                    altaNecessitats(aux[0],aux[j]);
                }
            }
            else altaPlaneta(aux[0], aux1, false);
        }
        cd.tancarFitxer();
    }
    
    //Pre:
    //Post: Retornar un ArrayList<String> on hi han totes les dades ben colocades
    private void guardar() throws IOException {
        Iterable<String> s = Conjunt_Planetes_Desassignat.obtainAllTST();
        for(String id : s){
            String list = new String();
            list += id + "\n";
            Planeta p;
            p = Conjunt_Planetes_Desassignat.obtain(id);
            Coordenades c = p.obtenirCoordenades();
            list += Integer.toString(c.obtenirCoordenadesX()) + "\n";
            list += Integer.toString(c.obtenirCoordenadesY()) + "\n";
            if (p.obtenirClasse()) {
                list += "1\n";
                Paquet pac = p.obtenirPaquet();
                if (pac == null) list += "NULL\n";
                else list += Integer.toString(cp.obtenirIdPaquet(pac)) + "\n";
                TST<Recurs> aux = p.obtenirNecessitats();
                Iterable<String> s1 = aux.obtainAllTST();
                for (String nom : s1) {
                    list += nom + "\n";
                }
            }
            else list += "0\n";
            list += "#";
            cd.writeTextFile(list);
        }
        Iterable<String> s1 = Conjunt_Planetes_Assignat.obtainAllTST();
        for(String nom : s1){
            String list = new String();
            list += nom + "\n";
            Planeta p;
            p = Conjunt_Planetes_Assignat.obtain(nom);
            Coordenades c = p.obtenirCoordenades();
            list += Integer.toString(c.obtenirCoordenadesX()) + "\n";
            list += Integer.toString(c.obtenirCoordenadesY()) + "\n";
            if (p.obtenirClasse()) {
                list += "1\n";
                Paquet pac = p.obtenirPaquet();
                if (pac == null) list += "NULL\n";
                else list += Integer.toString(cp.obtenirIdPaquet(pac)) + "\n";
                TST<Recurs> aux = p.obtenirNecessitats();
                Iterable<String> s2 = aux.obtainAllTST();
                for (String nom1 : s2) {
                    list += nom1 + "\n";
                }
            }
            else list += "0\n";
            list += "#";
            cd.writeTextFile(list);
        }
    }
    
    public int obtenirPaquetPlaneta(String a){
        int aux = -1;
        if (Conjunt_Planetes_Desassignat.contains(a) || Conjunt_Planetes_Assignat.contains(a)) {
			Planeta p;
            if (Conjunt_Planetes_Assignat.contains(a)) p = Conjunt_Planetes_Assignat.obtain(a);
            else p = Conjunt_Planetes_Desassignat.obtain(a);
			
            if (p.obtenirClasse()) {
                Paquet aux2 = p.obtenirPaquet();
                if(aux2 != null){
                    aux = cp.obtenirIdPaquet(aux2);
                }
            }
		}
        else throw new IllegalArgumentException(msg_planeta_no_exists);
        return aux;
    }

}