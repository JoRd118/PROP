/**
 *
 *Classe Univers
 *
 * @author Jordi Farran
 */
public class Univers {
    //Atributs
    private int idUnivers;
    private String nomUnivers;
    private TST<Planeta> planetes;
     
    private static String msg_planeta_no_exists = "Error de Univers: No existeix el planeta en aquest univers.";
    private static String msg_coord_rep = "Error de Univers: Ja hi ha un planeta en aquest univers amb les mateixes coordenades.";

    //Constructora per defecte
    public Univers(int id){
      idUnivers = id;
      nomUnivers = "default"+idUnivers;
      planetes = new TST<Planeta>();
    }

    public Univers(String nom, int id){
      idUnivers = id;
      nomUnivers = nom;
      planetes = new TST<Planeta>();
    }    
   //Consultores
    
   //Pre: True
   //Post:Obté el id del univers
   public int obtenirIdUnivers(){
     return idUnivers;
   }
   //Pre: True
   //Post: Obté el nom del univers
   public String obtenirNomUnivers(){
     return nomUnivers;
   }
   //Pre: True
   //Post: Obté el nombre de planetes que hi ha al unviers
   public int numplanetes(){
      return planetes.nElements();
   }
   //Pre: True
   //Post: Obté el Planeta del univers
   public Planeta obtenirPlaneta(String nom){
      if(planetes.contains(nom)) return planetes.obtain(nom);
      else throw new IllegalArgumentException(msg_planeta_no_exists);
   }
   //Pre: True
   //Post: Obté una Iterable<String> de tots els planetes que hi ha al univers
   public Iterable<String> obtenirPlanetes(){
    return planetes.obtainAllTST();
   }

   //Modificadores


   //Pre: True
   //Post: Afegeix un planeta al Univers
   public void afegirPlaneta(String nom, Planeta planeta){    
    if(pos_ok(planeta)) planetes.insert(nom, planeta);
    else throw new IllegalArgumentException(msg_coord_rep);
   }
   //Pre: True
   //Post: Desafegeix un planeta al Univers
   public void desafegirPlaneta(String nomPlaneta){
    planetes.remove(nomPlaneta);
   }
   //Pre: True
   //Post: Modifica el nom del univers
   public void modificarNomUnivers(String newnomUnivers){
     nomUnivers = newnomUnivers;
   }

   private boolean pos_ok(Planeta planeta){
    Coordenades c = planeta.obtenirCoordenades();
    Iterable<String> planetes2 = planetes.obtainAllTST();
    Planeta aux;
    for(String a : planetes2){
      aux = planetes.obtain(a);
      int x = aux.obtenirCoordenades().obtenirCoordenadesX();
      int y = aux.obtenirCoordenades().obtenirCoordenadesY();
      if(x == c.obtenirCoordenadesX() && y == c.obtenirCoordenadesY()) return false;
    }
    return true;
   }
}

