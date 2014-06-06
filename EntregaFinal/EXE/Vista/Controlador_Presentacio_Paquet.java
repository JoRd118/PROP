import java.util.*;
import java.io.IOException;
/**
 *Controlador_Domini_Paquet
 *
 *@author Jordi Vilella
 */

public class Controlador_Presentacio_Paquet{
    
    private Controlador_Domini_Paquet cp;
    private Controlador_Presentacio cpp;
    private VistaPaquet v;
    
    public Controlador_Presentacio_Paquet() {
        v = new VistaPaquet(this);
        cp = new Controlador_Domini_Paquet();
    }

    public Controlador_Presentacio_Paquet(Controlador_Presentacio_Recurs n) {
        cp = new Controlador_Domini_Paquet(n.getCont());
        v = new VistaPaquet(this);
    }
    
    public Controlador_Presentacio_Paquet(Controlador_Presentacio_Recurs n, Controlador_Presentacio p1) {
        cpp = p1;
        cp = new Controlador_Domini_Paquet(n.getCont());
        v = new VistaPaquet(this);
    }
    
    public Controlador_Domini_Paquet getCont(){
        return cp;
    
    }
    
    
    public void altaPaquet() {
        cp.altaPaquet();
    }
    
    public void baixaPaquet(int id) {
        cp.baixaPaquet(id);
    }

    public void assignarRecurs(int id, String nom) {
        cp.assignarRecurs(id,nom);
    }

    public void esborrarRecurs(int id, String nom) {
        cp.esborrarRecurs(id,nom);
    }

    public Paquet obtenirPaquet(int id) {
        return cp.obtenirPaquet(id);
    }

   
    public int obtenirIdPaquet(Paquet pac) {
        return cp.obtenirIdPaquet(pac);
    }

/*    public Paquet obtenirPaquetAssignar(int id) {

    } 
*/
    public void desassignarPaquet(int id) {
        cp.desassignarPaquet(id);
    }
    
    public String llistatPaquetsAssignats(){
        return cp.llistatPaquetsAssignats();
    }

    public String llistatPaquetsNoAssignats(){
        return cp.llistatPaquetsNoAssignats();
    }

    /*public Iterable<String> llistatRecursosPaquetIterator(Paquet pac) {
        if (r.contains(Integer.toString(pac.obtenirId()))) {
            TST<Recurs> aux = r.obtain(Integer.toString(pac.obtenirId()));
            return aux.obtainAllTST();
        }
        else throw new IllegalArgumentException(msg_paquet_no_exists);
    }
    
    public Iterable<String> llistatRecursosPaquetIterator(int id) {
        String id_string = Integer.toString(id);
        if (p.contains(id_string)) {
            Paquet paq = p.obtain(id_string);
            return paq.llistatRecursosIterator();
        }
        else if (pa.contains(id_string)) {
            Paquet paq = pa.obtain(id_string);
            return paq.llistatRecursosIterator();
        }
        else throw new IllegalArgumentException(msg_paquet_no_exists);
    }
     */

    public String llistatRecursosPaquet(int id) throws IOException{
        return cp.llistatRecursosPaquet(id);
    }

    /*
    public void borrar_recurs3(String nom){
        cp.borrar_recurs3(nom);
    }

    public void modificar_nom_recurs3(String old_name, String new_name){
        cp.modificar_nom_recurs3(old_name, new_name);
    }
     */

    public void guardarPaquets(String nomFitxer) throws IOException{
        cp.guardarPaquets(nomFitxer);
    }

    public void carregarPaquets(String nomFitxer) throws IOException {
        cp.carregarPaquets(nomFitxer);
    }
    
    public void baixaPaquetVista(int id){
        cpp.borrar_paquet(id);
    }
    
    
    
}