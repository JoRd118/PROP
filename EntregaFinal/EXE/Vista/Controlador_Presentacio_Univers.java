
import java.util.*;
import java.io.IOException;
import java.lang.Math;
/**
 *
 *@author Jordi Farran
 */


public class Controlador_Presentacio_Univers{
    
	
    private Controlador_Domini_Univers cu;
    private Controlador_Presentacio cpp;
    private VistaUnivers v;
    
	//Instanciacio de la estructura de dades
    
	
	public Controlador_Presentacio_Univers(Controlador_Presentacio_Planeta cp1, Controlador_Presentacio_Recurs cr1, Controlador_Presentacio_Paquet cpa1, Controlador_Presentacio p){
		cu = new Controlador_Domini_Univers(cp1.getCont(), cr1.getCont(), cpa1.getCont());
        cpp = p;
        v = new VistaUnivers(this);
	}
    
    //Creadora per defecte
    
    
    public Controlador_Domini_Univers getCont(){
        return cu;
    }
    
	//Pre: True
    //Post: Crea un univers amb el nom escollit
	public void altaUnivers(String nom){
		cu.altaUnivers(nom);
	}
    
    //Pre: True
    //Post: Dona de baixa l'univers amb el nom escollit
	public void baixaUnivers(String nom){
        cu.baixaUnivers(nom);
	}
    
    //Pre: True
    //Post: Modifica el nom del univers seleccionat pel nou nom escollit
	public void modificacioNomUnivers(String nomUnivers, String newnomUnivers){
		cu.modificacioNomUnivers(nomUnivers, newnomUnivers);
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
		return cu.obtenirIdUnivers(nom);
	}
    
	//Pre: True
    //Post: Et retorna el llistat del tots els noms dels universos
	public String llistatUnivers(){
		return cu.llistatUnivers();
	}
    
    
    //Pre: True;
    //Post: Et retorna el numero de plantes que hi ha al univers escollit
	public int numPlanetesUnivers(String nom){
		return cu.numPlanetesUnivers(nom);
	}
    
    public String matriuDistanciaPlanetes2(String nom)  throws IOException{
        return cu.numPlanetesUnivers2(nom);
    }
    
    /*
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
    */
    
    public String matriuNecesitatsPlanetes2(String nom) throws IOException{
        return cu.matriuNecesitatsPlanetes2(nom);
    }
    
    /*
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
     */
    
    public String matriuRecursosPlanetes2(String nom) throws IOException{
        return cu.matriuRecursosPlanetes2(nom);
    }
    /*
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
    */
    
    //Pre: True
    //Post: Afegeix el Planeta seleccionat al Univers seleccionat
    public void afegirPlanetaUnivers(String nomUnivers, String nomPlaneta){
    	cu.afegirPlanetaUnivers(nomUnivers,nomPlaneta);
    }
    
    //Pre: True
    //Post: Desassigna el Planeta seleccionat del Univers seleccionat
    public void desafegirPlanetaUnivers(String nomUnivers, String nomPlaneta){
    	cu.desafegirPlanetaUnivers(nomUnivers,nomPlaneta);
    }
    
    
    public String numPlanetesUnivers2(String nom)  throws IOException{
        return cu.numPlanetesUnivers2(nom);
    }
    
    /*
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
*/
    public String vectorPlanetesVista(String nomUnivers) throws IOException{
        return cu.vectorPlanetesVista(nomUnivers);
    }
    
    
    public void borrar_planeta(String nom){
        cu.borrar_planeta(nom);
    }
    
    public void borrar_paquet(int id){
        cu.borrar_paquet(id);
    }
    
    public void borrar_recurs(String nom){
        cu.borrar_recurs(nom);
    }
    
    public void modificar_nom_planeta(String old_name, String new_name){
        cu.modificar_nom_planeta(old_name, new_name);
    }
    
    public void modificar_nom_recurs(String old_name, String new_name){
        cu.modificar_nom_recurs(old_name, new_name);
    }
    
    public void modificar_coordenades_planeta(String nom, int x, int y){
        cu.modificar_coordenades_planeta(nom,x,y);
    }
    
    public void modificar_classe_planeta(String nom, boolean classeM){
        cu.modificar_classe_planeta(nom,classeM);
    }
    //Pre: True
    //Post: Guarda en un fitxer les dades dels unviersos
    public void guardarUniversos(String nomFitxer) throws IOException{
        cu.guardarUniversos(nomFitxer);
    }
    
    //Pre: True
    //Post: Carrega les dades d'un fitxer
    public void carregarUniversos(String nomFitxer) throws IOException {
        cu.carregarUniversos(nomFitxer);
    }
    
}
