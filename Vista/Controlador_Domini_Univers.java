
import java.util.*;
import java.io.IOException;
import java.lang.Math;
/**
 *
 *@author Jordi Farran
 */


public class Controlador_Domini_Univers{
    
	
    //Atributs
	private TST<Univers> u;
	private Controlador_Domini_Planeta cp;
	private Controlador_Domini_Recurs cr;
	private Controlador_Domini_Paquet cpa;
    private Controlador_Presentacio cpp;
    private Controlador_Dades cdu;
    private Identificador ide;
	private String msg_univers_no_exists = "Error de Univers: Univers demanat no existeix";
	private String msg_univers_repetit = "Error de Univers: Ja existeix un univers amb aquest nom";
	private static String msg_carregar = "Error de Univers: Carregar no es pot portar a terme perque ja s'han introduit dades.";
    private static String msg_univers_coords = "Error de Univers: Ja existeix un planeta amb les mateixes coorenades en aquest univers";
    private static String msg_univers_no_planeta = "Error de Univers: El planeta demanat no es troba dins d'aquest univers";
    //Instanciacio de la estructura de dades
	
    private VistaUnivers v;
    
	//Instanciacio de la estructura de dades
	
	public Controlador_Domini_Univers(Controlador_Domini_Planeta cp1, Controlador_Domini_Recurs cr1, Controlador_Domini_Paquet cpa1, Controlador_Presentacio p){
		u = new TST<Univers>();
        cdu = new Controlador_Dades();
		cp = cp1;
		cr = cr1;
		cpa = cpa1;
        ide = new Identificador();
        cpp = p;
        v = new VistaUnivers(this);
	}
    
    //Creadora per defecte
    
    //Pre: True
    //Post: Crea el TST de universos buit
	public Controlador_Domini_Univers(){
		u = new TST<Univers>();
        cdu = new Controlador_Dades();
        ide = new Identificador();
        v = new VistaUnivers(this);
	}
	//Pre: True
    //Post: Crea un univers amb el nom escollit
	public void altaUnivers(String nom){
		if(u.contains(nom)) throw new IllegalArgumentException(msg_univers_repetit);
		else{
			Univers aux = new Univers(nom, ide.id());
			u.insert(nom,aux);
		}
	}
    
    //Pre: True
    //Post: Dona de baixa l'univers amb el nom escollit
	public void baixaUnivers(String nom){
		if(u.contains(nom) == false) throw new IllegalArgumentException(msg_univers_no_exists);
		else{
			u.remove(nom);
		}
	}
    
    //Pre: True
    //Post: Modifica el nom del univers seleccionat pel nou nom escollit
	public void modificacioNomUnivers(String nomUnivers, String newnomUnivers){
		if(u.contains(nomUnivers) == false) throw new IllegalArgumentException(msg_univers_no_exists);
		else{
			Univers aux = u.obtain(nomUnivers);
            aux.modificarNomUnivers(newnomUnivers);
            u.remove(nomUnivers);
            u.insert(newnomUnivers, aux);
		}
	}
    /*
     //Pre: True
     //Post: Et retorna l'Univers amb el nom escollit
     public Univers obtenirUnivers(String nom){
     if(u.contains(nom) == false) throw new IllegalArgumentException(msg_univers_no_exists);
     else return u.obtain(nom);
     }*/
    
    //Pre: True
    //Post: Et retorna l'Id de l'univers amb el nom escollit
	public int obtenirIdUnivers(String nom){
		if(u.contains(nom) == false) throw new IllegalArgumentException(msg_univers_no_exists);
		else return u.obtain(nom).obtenirIdUnivers();
	}
    
	//Pre: True
    //Post: Et retorna el llistat del tots els noms dels universos
	public String llistatUnivers(){
		Iterable<String> s = u.obtainAllTST();
		String aux = new String();
        for(String a : s){
            aux = aux + a +"\n";
        }
        return aux;
	}
    
    
    //Pre: True;
    //Post: Et retorna el numero de plantes que hi ha al univers escollit
	public int numPlanetesUnivers(String nom){
		if(u.contains(nom) == false) throw new IllegalArgumentException(msg_univers_no_exists);
		else{
            Univers aux = u.obtain(nom);
			return aux.numplanetes();
		}
	}
    
    public String matriuDistanciaPlanetes2(String nom){
        String aux = new String();
        double[][] matriu = matriuDistanciaPlanetes(nom);
        for(int i = 0; i < matriu.length; ++i){
            for(int j = 0; j < matriu.length; ++j){
                aux = aux + matriu[i][j] +" ";
            }
            aux = aux + "\n";
        }
        return aux;
    }
    
    
    //Pre: True
    //Post: Et retorna la matriu de distancies entre els planetes del univers escollit
  	public double[][] matriuDistanciaPlanetes(String nom_univers){
  		if(u.contains(nom_univers) == false) throw new IllegalArgumentException(msg_univers_no_exists);
  		else{
            int planetesm = 0;
  			Univers a1 = u.obtain(nom_univers);
            Iterable<String> planm = a1.obtenirPlanetes();
            for(String a : planm){ //contar quans planetes M hi ha
                Planeta p = a1.obtenirPlaneta(a);
                if(p.obtenirClasse()) ++planetesm;
            }
            //System.out.println("EL num de planetes m es: "+planetesm);
  			double[][] distancies = new double[planetesm][planetesm];
  			Iterable<String> s = a1.obtenirPlanetes();
  			int i = 0;
  			for(String a : s){
  				int j = 0;
                Planeta auxi = a1.obtenirPlaneta(a);
                if(auxi.obtenirClasse()){ //Si no es M no fer re
                    for(String b : s){
                        Planeta auxj = a1.obtenirPlaneta(b);
                        if(auxj.obtenirClasse()){ //Si no es M no fer re
                            if(auxi.obtenirId() == auxj.obtenirId())distancies[i][j] = 0;
                            else{
                                double p1x = (double) auxi.obtenirCoordenades().obtenirCoordenadesX();
                                double p1y = (double) auxi.obtenirCoordenades().obtenirCoordenadesY();
                                double p2x = (double) auxj.obtenirCoordenades().obtenirCoordenadesX();
                                double p2y = (double) auxj.obtenirCoordenades().obtenirCoordenadesY();
                                distancies[i][j] = Math.sqrt(Math.pow((p2x-p1x),2)+Math.pow((p2y-p1y),2));
                            }
                            ++j;
                        }
                    }
                    ++i;
                }
  			}
  			return distancies;
  		}
  	}
    
    public String matriuNecesitatsPlanetes2(String nom){
        String aux = new String();
        int[][] matriu = matriuNecesitatsPlanetes(nom);
        for(int i = 0; i < matriu.length; ++i){
            for(int j = 0; j < matriu[i].length; ++j){
                aux = aux + matriu[i][j] +" ";
            }
            aux = aux + "\n";
        }
        return aux;
    }
    
    //Pre: True
    //Post: Et retorna la matriu de Necesitas dels planetes del univers escollit
	public int[][] matriuNecesitatsPlanetes(String nom_univers){
  		if(u.contains(nom_univers) == false) throw new IllegalArgumentException(msg_univers_no_exists);
  		else{
            int planetesm = 0;
  			Univers a1 = u.obtain(nom_univers);
            Iterable<String> planm = a1.obtenirPlanetes();
            for(String a : planm){ //contar quans planetes M hi ha
                Planeta p = a1.obtenirPlaneta(a);
                if(p.obtenirClasse()) ++planetesm;
            }
            //System.out.println("Numero de recursos:   "+cr.totalRecursos());
  			int[][] necesitats_planetes = new int[planetesm][cr.totalRecursos()];
  			for(int i = 0; i < planetesm; ++i){
  				for(int j = 0; j < cr.totalRecursos();++j){
  					necesitats_planetes[i][j] = 0;
  				}
  			}
  			Iterable<String> s = a1.obtenirPlanetes();
  			int i = 0;
  			for(String a : s){
  				int j = 0;
  				Planeta auxi = a1.obtenirPlaneta(a);
                if(auxi.obtenirClasse()){ //Si no es M no fer re
                    Iterable<String> rec = cr.llistatRecurs_2();
                    Iterable<String> necesitats = cp.obtenirNecessitats(auxi.obtenirNom());
                    for(String b : rec){
                        for(String c : necesitats){
                            if(c.equals(b)) necesitats_planetes[i][j] = 1;
                        }
                        ++j;
                    }
                    ++i;
                }
  			}
  			return necesitats_planetes;
  		}
  	}
    
    public String matriuRecursosPlanetes2(String nom){
        String aux = new String();
        int[][] matriu = matriuRecursosPlanetes(nom);
        for(int i = 0; i < matriu.length; ++i){
            for(int j = 0; j < matriu[i].length; ++j){
                aux = aux + matriu[i][j] +" ";
            }
            aux = aux + "\n";
        }
        return aux;
    }
    
    //Pre: True
    //Post: Et retorna la matriu dels Recursos que tenen els planetas del univers escollit
  	public int[][] matriuRecursosPlanetes(String nom_univers){
  		if(u.contains(nom_univers) == false) throw new IllegalArgumentException(msg_univers_no_exists);
  		else{
            int planetesm = 0;
  			Univers a1 = u.obtain(nom_univers);
            Iterable<String> planm = a1.obtenirPlanetes();
            for(String a : planm){ //contar quans planetes M hi ha
                Planeta p = a1.obtenirPlaneta(a);
                if(p.obtenirClasse()) ++planetesm;
            }
  			int[][] recursos_planetes = new int[planetesm][cr.totalRecursos()];
  			for(int i = 0; i < planetesm; ++i){
  				for(int j = 0; j < cr.totalRecursos();++j){
  					recursos_planetes[i][j] = 0;
  				}
  			}
  			Iterable<String> s = a1.obtenirPlanetes();
  			int i = 0;
  			for(String a : s){
  				int j = 0;
  				Planeta auxi = a1.obtenirPlaneta(a);
                if(auxi.obtenirClasse()){ //Si no es M no fer re
                    Iterable<String> rec = cr.llistatRecurs_2();
                    Iterable<String> recursos = cp.obtenirRecursosDisponibles(auxi.obtenirNom());
                    for(String b : rec){
                        for(String c : recursos){
                            if(c.equals(b)) recursos_planetes[i][j] = 1;
                        }
                        ++j;
                    }
                    ++i;
                }
            }
  			return recursos_planetes;
  		}
  	}
    
    
    //Pre: True
    //Post: Afegeix el Planeta seleccionat al Univers seleccionat
    public void afegirPlanetaUnivers(String nomUnivers, String nomPlaneta){
    	if(u.contains(nomUnivers) == false) throw new IllegalArgumentException(msg_univers_no_exists);
    	else{
    		Univers aux;
    		aux = u.obtain(nomUnivers);
            Planeta aux2 = cp.obtenirPlaneta(nomPlaneta);
            cp.assignarPlaneta(nomPlaneta);
            aux.afegirPlaneta(nomPlaneta, aux2);
    	}
    }
    
    //Pre: True
    //Post: Desassigna el Planeta seleccionat del Univers seleccionat
    public void desafegirPlanetaUnivers(String nomUnivers, String nomPlaneta){
    	if(u.contains(nomUnivers) == false) throw new IllegalArgumentException(msg_univers_no_exists);
    	else{
            Univers aux;
            aux = u.obtain(nomUnivers);
            if(!aux.hihaPlaneta(nomPlaneta))throw new IllegalArgumentException(msg_univers_no_planeta);
            else{
                cp.desassignarPlaneta(nomPlaneta);
                aux.desafegirPlaneta(nomPlaneta);
            }
    	}
    }
    
    
    public String numPlanetesUnivers2(String nom){
        String aux = new String();
        String[] vector = vectorPlanetes(nom);
        for(int i = 0; i < vector.length; ++i){
            aux = aux + vector[i] +"\n";
        }
        return aux;
    }
    
    
    public String[] vectorPlanetes(String nomUnivers){
        int planetesm = 0;
        Univers aux = u.obtain(nomUnivers);
        Iterable<String> aux1 = aux.obtenirPlanetes();
        Iterable<String> planm = aux.obtenirPlanetes();
        for(String a : planm){ //contar quans planetes M hi ha
            Planeta p = aux.obtenirPlaneta(a);
            if(p.obtenirClasse()) ++planetesm;
        }
        String[] planetes = new String[planetesm];
        int i = 0;
        
        for(String a : aux1){
            Planeta p = aux.obtenirPlaneta(a);
            if(p.obtenirClasse()){
                planetes[i] = a;
                ++i;
            }
        }
        return planetes;
    }
    
    //NOVES FUNCIONS!
    public void borrar_planeta(String nom){
        String aux = existeixplanetaunivers(nom);
        if(!aux.equals("none")){
            //System.out.println("Entra al if");
            desafegirPlanetaUnivers(aux, nom);
        }
        cp.baixaPlaneta(nom);
        
    }
    
    public void borrar_paquet(int id){
        cp.borrar_paquet2(id);
    }
    
    public void borrar_recurs(String nom){
        cp.borrar_recurs2(nom);
    }
    
    public void modificar_nom_planeta(String old_name, String new_name){
        String aux = existeixplanetaunivers(old_name);
        if(!aux.equals("none")){
            desafegirPlanetaUnivers(aux, old_name);
            cp.modificarNom(old_name, new_name);
            afegirPlanetaUnivers(aux, new_name);
        }
    }
    
    public void modificar_nom_recurs(String old_name, String new_name){
        cp.modificar_nom_recurs2(old_name, new_name);
    }
    
    public void modificar_coordenades_planeta(String nom, int x, int y){
        Iterable<String> aux = u.obtainAllTST();
        for(String a : aux){
            Univers uni = u.obtain(a);
            Iterable<String> aux2 = uni.obtenirPlanetes();
            for(String b : aux2){
                if(b.equals(nom)){
                    Planeta p;
                    for(String c : aux2){
                        p = uni.obtenirPlaneta(c);
                        int x2 = p.obtenirCoordenades().obtenirCoordenadesX();
                        int y2 = p.obtenirCoordenades().obtenirCoordenadesY();
                        if(x == x2 && y == y2) throw new IllegalArgumentException(msg_univers_coords);
                    }
                    cp.modificarCoordenades(nom,x,y);
                }
            }
        }
    }
    
    public void modificar_classe_planeta(String nom, boolean classeM){
        cp.modificarClasse(nom,classeM);
    }
    //Pre: True
    //Post: Guarda en un fitxer les dades dels unviersos
    public void guardarUniversos(String nomFitxer) throws IOException{
        cdu.obrirFitxer(nomFitxer);
        cdu.deleteFile();
        guardar();
        cdu.tancarFitxer();
    }
    
    //Pre: True
    //Post: Carrega les dades d'un fitxer
    public void carregarUniversos(String nomFitxer) throws IOException {
        ide.reset();
        if (u.nElements() > 0) throw new IllegalArgumentException(msg_carregar);
        cdu.obrirFitxer(nomFitxer);
        String s = cdu.readTextFile();
        String[] dades = s.split("#");
        for(int i = 0; i < dades.length - 1; ++i) {
            String[] aux = dades[i].split("\n");
            altaUnivers(aux[0]);
            for(int j = 1; j < aux.length; ++j) {
                afegirPlanetaUnivers(aux[0],aux[j]);
            }
        }
        cdu.tancarFitxer();
    }
    
    //Pre: True
    //Post: Retorna la llista que guarda les dades
    private void guardar() throws IOException{
        Iterable<String> s = u.obtainAllTST();
        for(String a : s){
            String list = new String();
            list += a + "\n";
            Univers aux = u.obtain(a);
            Iterable<String> s1 = aux.obtenirPlanetes();
            for(String b : s1){
                list += b + "\n";        
            }
            list += "#";
            cdu.writeTextFile(list);
        }   
    }
    
    
    //NOVA FUNCIO!
    private String existeixplanetaunivers(String nom){
        Iterable<String> universos = u.obtainAllTST();
        //System.out.println("Entra al for");
        for(String nom_univers : universos){
            Univers aux = u.obtain(nom_univers);
            Iterable<String> planetesunivers = aux.obtenirPlanetes();
            //System.out.println("Entra al for2");
            for(String planeta : planetesunivers){
                //System.out.println("Entra al if2");
                if(planeta.equals(nom)) return nom_univers;
                //System.out.println("Surt al if");
            }
        }
        return "none";
    }
    
}
