
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
	private TST<TST<Planeta> > p;
	private Controlador_Domini_Planeta cp;
	private Controlador_Domini_Recurs cr;
	private Controlador_Domini_Paquet cpa;
  private Controlador_Dades_Univers cdu;

	private String msg_univers_no_exists = "Error de Univers: Univers demanat no existeix";
	private String msg_univers_repetit = "Error de Univers: Ja existeix un univers amb aquest nom";
	//Instanciacio de la estructura de dades
	
	public Controlador_Domini_Univers(Controlador_Domini_Planeta cp1, Controlador_Domini_Recurs cr1, Controlador_Domini_Paquet cpa1){ 
		u = new TST<Univers>();
		p = new TST<TST<Planeta>>();
    cdu = new Controlador_Dades_Univers();
		cp = cp1;
		cr = cr1;
		cpa = cpa1;
	}

  //Creadora per defecte

  //Pre: True
  //Post: Crea el TST de universos buit
	public Controlador_Domini_Univers(){
		u = new TST<Univers>();
		p = new TST<TST<Planeta>>();
    cdu = new Controlador_Dades_Univers();
	}

	//Pre: True
  //Post: Crea un univers amb el nom escollit
	public void altaUnivers(String nom){
		if(u.contains(nom)) throw new IllegalArgumentException(msg_univers_repetit);
		else{
			TST<Planeta> p1 = new TST<Planeta>();
			Univers aux = new Univers(nom);
			u.insert(nom,aux);
			p.insert(nom,p1);
		}
	}

  //Pre: True
  //Post: Dona de baixa l'univers amb el nom escollit
	public void baixaUnivers(String nom){	
		if(u.contains(nom) == false) throw new IllegalArgumentException(msg_univers_no_exists);
		else{
			u.remove(nom);
			p.remove(nom);
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
			TST<Planeta> aux2 = p.obtain(nomUnivers);
			p.remove(nomUnivers);
			p.insert(newnomUnivers, aux2);
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
			TST<Planeta> p1 = new TST<Planeta>();
			p1 = p.obtain(nom);
			return p1.nElements();
		}
	}


    //Pre: True
    //Post: Et retorna la matriu de distancies entre els planetes del univers escollit
  	public double[][] matriuDistanciaPlanetes(String nom_univers){
  		if(u.contains(nom_univers) == false) throw new IllegalArgumentException(msg_univers_no_exists);
  		else{
        int planetesm = 0;        
  			TST<Planeta> p1 = new TST<Planeta>();
  			p1 = p.obtain(nom_univers);
        Iterable<String> planm = p1.obtainAllTST();
        for(String a : planm){ //contar quans planetes M hi ha
          Planeta p = p1.obtain(a);
          if(p.obtenirClasse()) ++planetesm;
        }
        //System.out.println("EL num de planetes m es: "+planetesm);
  			double[][] distancies = new double[planetesm][planetesm];
  			Iterable<String> s = p1.obtainAllTST();
  			int i = 0;
  			for(String a : s){
  				int j = 0;
          Planeta auxi = p1.obtain(a);
          if(auxi.obtenirClasse()){ //Si no es M no fer re
  				  for(String b : s){   					
  					 Planeta auxj = p1.obtain(b);
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

  //Pre: True
  //Post: Et retorna la matriu de Necesitas dels planetes del univers escollit
	public int[][] matriuNecesitatsPlanetes(String nom_univers){
  		if(u.contains(nom_univers) == false) throw new IllegalArgumentException(msg_univers_no_exists);
  		else{
        int planetesm = 0;
  			TST<Planeta> p1 = new TST<Planeta>();
  			p1 = p.obtain(nom_univers);
        Iterable<String> planm = p1.obtainAllTST();
        for(String a : planm){ //contar quans planetes M hi ha
          Planeta p = p1.obtain(a);
          if(p.obtenirClasse()) ++planetesm;
        }
        //System.out.println("Numero de recursos:   "+cr.totalRecursos());
  			int[][] necesitats_planetes = new int[planetesm][cr.totalRecursos()];
  			for(int i = 0; i < planetesm; ++i){
  				for(int j = 0; j < cr.totalRecursos();++j){
  					necesitats_planetes[i][j] = 0;
  				}
  			}
  			Iterable<String> s = p1.obtainAllTST();
  			int i = 0;
  			for(String a : s){
  				int j = 0;
  				Planeta auxi = p1.obtain(a);
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

    //Pre: True
    //Post: Et retorna la matriu dels Recursos que tenen els planetas del univers escollit
  	public int[][] matriuRecursosPlanetes(String nom_univers){
  		if(u.contains(nom_univers) == false) throw new IllegalArgumentException(msg_univers_no_exists);
  		else{
         int planetesm = 0;
  			TST<Planeta> p1 = new TST<Planeta>();
  			p1 = p.obtain(nom_univers);
        Iterable<String> planm = p1.obtainAllTST();
        for(String a : planm){ //contar quans planetes M hi ha
          Planeta p = p1.obtain(a);
          if(p.obtenirClasse()) ++planetesm;
        }
  			int[][] recursos_planetes = new int[planetesm][cr.totalRecursos()];
  			for(int i = 0; i < planetesm; ++i){
  				for(int j = 0; j < cr.totalRecursos();++j){
  					recursos_planetes[i][j] = 0;
  				}
  			}
  			Iterable<String> s = p1.obtainAllTST();
  			int i = 0;
  			for(String a : s){
  				int j = 0;
  				Planeta auxi = p1.obtain(a);
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
    		TST<Planeta> p1 = new TST<Planeta>();
    		Planeta aux = new Planeta();
    		p1 = p.obtain(nomUnivers);
    		aux = cp.obtenirPlaneta(nomPlaneta);
    		p1.insert(aux.obtenirNom(),aux);
    		cp.assignarPlaneta(aux.obtenirNom());
    	}
    }

    //Pre: True
    //Post: Desassigna el Planeta seleccionat del Univers seleccionat
    public void desafegirPlanetaUnivers(String nomUnivers, String nomPlaneta){
    	if(u.contains(nomUnivers) == false) throw new IllegalArgumentException(msg_univers_no_exists);
    	else{

    		TST<Planeta> p1 = new TST<Planeta>();
        p1 = p.obtain(nomUnivers);
    		Planeta aux = p1.obtain(nomPlaneta);    		
    		p1.remove(nomPlaneta);
    		cp.desassignarPlaneta(aux.obtenirNom());
    	}
    }

    public String[] vectorPlanetes(String nomUnivers){
      int planetesm = 0;
      TST<Planeta> aux = p.obtain(nomUnivers);
      Iterable<String> aux1= aux.obtainAllTST();
      Iterable<String> planm = aux.obtainAllTST();
      for(String a : planm){ //contar quans planetes M hi ha
        Planeta p = aux.obtain(a);
        if(p.obtenirClasse()) ++planetesm;
       }
      String[] planetes = new String[planetesm];
      int i = 0;
      
      for(String a : aux1){
        Planeta p = aux.obtain(a);
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
        System.out.println("Entra al if");
        desafegirPlanetaUnivers(aux, nom);
      }
      cp.baixaPlaneta(nom);

    }

   public void borrar_paquet(String id){
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

    //Pre: True
    //Post: Guarda en un fitxer les dades dels unviersos
    public void guardarUniversos(String nomFitxer) throws IOException{
        cdu.writeTextFile(nomFitxer, llistatGuardar());

    }

    //Pre: True
    //Post: Carrega les dades d'un fitxer
    public void carregarUniversos(String nomFitxer) throws IOException {
      ArrayList<String> s = cdu.readTextFile(nomFitxer);
      while(s.size() > 0) {
        String nom = s.get(0);
        altaUnivers(nom);
        s.remove(0);
        while (!s.get(0).equals("#")) {
          afegirPlanetaUnivers(nom,s.get(0));
          s.remove(0);
        }
        s.remove(0);
      }
    }

    //Pre: True
    //Post: Retorna la llista que guarda les dades
    private ArrayList<String> llistatGuardar(){
      ArrayList<String> list = new ArrayList<String>();
      Iterable<String> s = p.obtainAllTST();
      for(String a : s){
        list.add(a);
        TST<Planeta> aux = p.obtain(a);
        Iterable<String> s1 = aux.obtainAllTST();
        for(String b : s1){
                  System.out.println(b);
            list.add(b);          
        }
        list.add("#");
      }   
      return list;
    }


    //NOVA FUNCIO!
    private String existeixplanetaunivers(String nom){
      TST<Planeta> p1 = new TST<Planeta>();
      Iterable<String> universos = u.obtainAllTST();
      //System.out.println("Entra al for");
      for(String nom_univers : universos){
        p1 = p.obtain(nom_univers);
        Iterable<String> planetesunivers = p1.obtainAllTST();
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
