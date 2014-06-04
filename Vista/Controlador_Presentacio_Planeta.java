import java.util.*;
import java.io.IOException;

public class Controlador_Presentacio_Planeta {

    private Controlador_Domini_Planeta cp;
    private Controlador_Presentacio cpp;
    private VistaPlaneta v;
    
	public Controlador_Presentacio_Planeta(){
        v = new VistaPlaneta(this);
        cp = new Controlador_Domini_Planeta();
	}
    
	public Controlador_Presentacio_Planeta(Controlador_Presentacio_Paquet p, Controlador_Presentacio_Recurs r, Controlador_Presentacio p1) {
	 	cp = new Controlador_Domini_Planeta(p.getCont(),r.getCont());
        cpp = p1;
        v = new VistaPlaneta(this);
	}
    
    
    public void altaPlanetaVista(String nom, String coorden, boolean classeM) {
        cp.altaPlanetaVista(nom,coorden,classeM);
    }
    
    public Controlador_Domini_Planeta getCont(){
        return cp;
    }
    
    
	//Pre:
	//Post: S'esborra el planeta amb el nom demanat
	public void baixaPlaneta(String nom) {
        cp.baixaPlaneta(nom);
    
    }
    
    //Pre:
    //Post: Si el planeta nomP passar en el vector de Conjunt_Planetes_Assignat
    //		si es que estava el el vector de Conjunt_Planetes_Desassignat
	public void assignarPlaneta(String nomP) {
		cp.assignarPlaneta(nomP);
	}
    
    //Pre:
    //Post: Si el planeta nomp esta el el vector Conjunt_Planetes_Assignat el
    //		el passar en el vector Conjunt_Planetes_Desassignat
	public void desassignarPlaneta(String nomP) {
		cp.desassignarPlaneta(nomP);
	}
    
    //Pre:
    //Post: El nom de un planeta es canvia per el nou nom
	public void modificarNom(String nom, String newnom) {
		cp.modificarNom(nom, newnom);
	}
    /*
	//Pre:
	//Post: Les coordenades de un planeta son modificades per unes noves coordenades x i y
	public void modificarCoordenades(String nom, int x, int y) {
		cp.modificarCoordenades
	}
    */
    
    public void modificarCoordenadesVista(String nom, String coorden) {
        cp.modificarCoordenadesVista(nom,coorden);
    }
    
    //Pre:
    //Post: La classeM de un planeta passar a ser de classeM si classeM es true
	public void modificarClasse(String nom, boolean classeM) {
        cp.modificarClasse(nom,classeM);
    }
    
    //Pre:
    //Post: Retornar id del planeta amb el nom nom
	public int obtenirId(String nom) {
		return cp.obtenirId(nom);
	}
    
    //Pre:
    //Post: Retorna true si el paquet amb el nom nom es de la classe m
    //		Retorna false si el paquet amb el nom nom no es de la classe m
	public boolean obtenirClasse(String nom) {;
		return cp.obtenirClasse(nom);
	}
    
    /*
    //Pre:
    //Post: Retornar les coordenades d'un planeta amb el nom nom
	public Coordenades obtenirCoordenades(String nom) {
       return cp.obtenirCoordenades(nom);
	}
    */
    
    public String obtenirCoordenadesVista(String nom) {
        return cp.obtenirCoordenadesVista(nom);
    }
    
    /*
    public Planeta obtenirPlaneta(String nom) {

	}
    */
    
    //Pre:
    //Post: Retornar un String on hi han tots els nom dels planetes no assignats
    public String llistarPlanetesDesassignat() {
        return cp.llistarPlanetesDesassignat();
	}
    
    //Pre:
    //Post: Retornar un String on hi han tots els nom dels planetes assignats
	public String llistarPlanetesAssignat() {
        return cp.llistarPlanetesAssignat();
	}
    
    //Pre:
    //Post: Afegeix una necessitat a un planeta
	public void altaNecessitats(String nomP, String nomR) {
		cp.altaNecessitats(nomP,nomR);
	}
    
    //Pre:
    //Post: Baixa una necessitat a un planeta amb nom nomP
	public void baixaNecessitats(String nomP, String nomR) {
        cp.baixaNecessitats(nomP,nomR);
	}
    
	// ASSIGNAR PAQUET!!
	//Pre:
	//Post: Assignar un paquet a un planeta amb nom nomP
	public void assignarPaquet(String nomP, int id) {
        cp.assignarPaquet(nomP, id);
	
    }
    
    //Pre:
    //Post: Desassignar un paqueta a un planeta amb nom nomP
	public void desassignarPaquet(String nomP) {
        cp.desassignarPaquet(nomP);
    }
	
    /*
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
    */
    
    public String obtenirRecursosDisponiblesVista(String nomP) throws IOException{
       return cp.obtenirRecursosDisponiblesVista(nomP);
    
    }
    
    /*
	public Iterable<String> obtenirNecessitats(String nomP) {
		if (Conjunt_Planetes_Desassignat.contains(nomP) || Conjunt_Planetes_Assignat.contains(nomP)) {
			Planeta p;
			if (Conjunt_Planetes_Assignat.contains(nomP)) p = Conjunt_Planetes_Assignat.obtain(nomP);
			else p = Conjunt_Planetes_Desassignat.obtain(nomP);
			TST<Recurs> aux = p.obtenirNecessitats();
			return aux.obtainAllTST();
		} else throw new IllegalArgumentException(msg_planeta_no_exists);
	}
    */
    
    public String obtenirNecessitatsVista(String nomP) {
        return cp.obtenirNecessitatsVista(nomP);
    }
    
    /*
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
*/
    
    //Pre:
    //Post: Guardar en el fitxer nomFitxer totes les dades becessaries pero tornar a carregar i que tot estigui igual
    public void guardarPlanetes(String nomFitxer) throws IOException{
        cp.guardarPlanetes(nomFitxer);
    }
    
    //Pre:
    //Post: Carregar del fitxer nomFitxer totes les dades i ho restaura tot
    public void carregarPlanetes(String nomFitxer) throws IOException {
        cp.carregarPlanetes(nomFitxer);
    }
    
    public int obtenirPaquetPlaneta(String a){
        return cp.obtenirPaquetPlaneta(a);
    }

    public void baixaPlanetaVista(String a){
        cpp.borrar_planeta(a);
    }
    
    public void modificarNomPlanetaVista(String old_name, String new_name){
        cpp.modificar_nom_planeta(old_name, new_name);
    
    }
    
    public void modificarCoordPlanetaVista(String nom, int x, int y){
        cpp.modificar_coordenades_planeta(nom,x,y);
    }
    
    public void modificarClassePlanetaVista(String nom, boolean classeM){
        cpp.modificar_classe_planeta(nom,classeM);
    
    }
}