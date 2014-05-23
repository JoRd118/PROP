import java.util.*;
import java.io.IOException;
/**
 *Controlador_Domini_Paquet
 *
 *@author Jordi Vilella
 */

public class Controlador_Domini_Paquet{
    
    private TST<Paquet> p; // Paquets No assignats
    private TST<Paquet> pa; // Paquets assignats
    private Controlador_Domini_Recurs cr;
    private Controlador_Dades cp;
    private Identificador ide;

    private static String msg_paquet_no_exists = "Error de Paquet: Paquet demanat no existeix.";
    private static String msg_paquet_ja_assignat = "Error de Paquet: Paquet demanat ja esta assignat.";
    private static String msg_recurs_ja_assignat = "Error de Recurs: Recurs demanat ja esta assignat en el paquet.";
    private static String msg_recurs_no_esta_assignat = "Error de Recurs: Recurs demanat no esta assignat al paquet.";
    private static String msg_recurs_no_existeix = "Error de Recurs: Recurs demanat no existeix.";
    private static String msg_paquet_no_assignat = "Error de Paquet: Paquet demanat no ha estat assignat.";

    public Controlador_Domini_Paquet() {
        p = new TST<Paquet>();
        pa = new TST<Paquet>();
        cr = new Controlador_Domini_Recurs();
        cp = new Controlador_Dades();
        ide = new Identificador();
    }
    
    public Controlador_Domini_Paquet(Controlador_Domini_Recurs n) {
        p = new TST<Paquet>();
        pa = new TST<Paquet>();
        cp = new Controlador_Dades();
        cr = n;
        ide = new Identificador();
    }

    public void altaPaquet() {
        int id = ide.id();
        Paquet aux = new Paquet(id);
        String id_string = Integer.toString(id);
        p.insert(id_string, aux);
    }
    
    public void baixaPaquet(int id) {
        String id_string = Integer.toString(id);
        if (p.contains(id_string)) {
            p.remove(id_string);
        }
        else if (pa.contains(id_string)){
            pa.remove(id_string);
        }
        else throw new IllegalArgumentException(msg_paquet_no_exists);
    }

    public void assignarRecurs(int id, String nom) {
        String id_string = Integer.toString(id);
        if (p.contains(id_string) || pa.contains(id_string)) {
            Recurs rec = cr.obtenirRecurs(nom);
            Paquet paq;
            if (p.contains(id_string)) paq = p.obtain(id_string);
            else paq = pa.obtain(id_string);
            paq.assignarRecurs(nom,rec);
        }
        else throw new IllegalArgumentException(msg_paquet_no_exists);
        
    }

    public void esborrarRecurs(int id, String nom) {
        String id_string = Integer.toString(id);
        if (p.contains(id_string) || pa.contains(id_string)) {
            Paquet paq;
            if (p.contains(id_string)) paq = p.obtain(id_string);
            else paq = pa.obtain(id_string);
            paq.esborrarRecurs(nom);
        }
        else throw new IllegalArgumentException(msg_paquet_no_exists);
    }

    public Paquet obtenirPaquet(int id) {
        String id_string = Integer.toString(id);
        if (p.contains(id_string)) return p.obtain(id_string);
        else if (pa.contains(id_string)) return pa.obtain(id_string);
        else throw new IllegalArgumentException(msg_paquet_no_exists);
    }

   
    public int obtenirIdPaquet(Paquet pac) {
        return pac.obtenirId();
    }

    public Paquet obtenirPaquetAssignar(int id) {
        String id_string = Integer.toString(id);
        if (p.contains(id_string)) {
            Paquet paq;
            paq = p.obtain(id_string);
            p.remove(id_string);
            pa.insert(id_string,paq);
            return paq;
        }
        else if (pa.contains(id_string)) throw new IllegalArgumentException(msg_paquet_ja_assignat);
        else throw new IllegalArgumentException(msg_paquet_no_exists);
    } 

    public void desassignarPaquet(int id) {
        String id_string = Integer.toString(id);
        if (pa.contains(id_string)) {
            Paquet paq;
            paq = pa.obtain(id_string);
            pa.remove(id_string);
            p.insert(id_string,paq);
        }
        else if (p.contains(id_string)) throw new IllegalArgumentException(msg_paquet_no_assignat);
        else throw new IllegalArgumentException(msg_paquet_no_exists);
    }
    
    public String llistatPaquetsAssignats(){
        Iterable<String> s = pa.obtainAllTST();
        String aux = new String();
        for(String a : s){
            aux = aux + a +"\n";
        }
        return aux;
    }

    public String llistatPaquetsNoAssignats(){
        Iterable<String> s = p.obtainAllTST();
        String aux = new String();
        for(String a : s){
            aux = aux + a +"\n";
        }
        return aux;
    }

    /*public Iterable<String> llistatRecursosPaquetIterator(Paquet pac) {
        if (r.contains(Integer.toString(pac.obtenirId()))) {
            TST<Recurs> aux = r.obtain(Integer.toString(pac.obtenirId()));
            return aux.obtainAllTST();
        }
        else throw new IllegalArgumentException(msg_paquet_no_exists);
    }
    */
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

    public String llistatRecursosPaquet(int id){
        String id_string = Integer.toString(id);
        if (p.contains(id_string)) {
            Paquet paq = p.obtain(id_string);
            return paq.llistatRecursos();
        }
        else if (pa.contains(id_string)) {
            Paquet paq = pa.obtain(id_string);
            return paq.llistatRecursos();
        }
        else throw new IllegalArgumentException(msg_paquet_no_exists);
    }



    //NOVES FUNCS!!
    public void borrar_recurs3(String nom){
        Iterable<String> paquets;
        paquets = p.obtainAllTST();
        for(String a : paquets){
            Paquet aux = p.obtain(a);
            if(aux.validarrecurs(nom)) aux.esborrarRecurs(nom);
        }
        paquets = pa.obtainAllTST();
        for(String a : paquets){
            Paquet aux = pa.obtain(a);
            if(aux.validarrecurs(nom)) aux.esborrarRecurs(nom);
        }
    }

    public void modificar_nom_recurs3(String old_name, String new_name){
        cr.modificarNom(old_name, new_name);
        Iterable<String> paquets;
        paquets = p.obtainAllTST();
        for(String a : paquets){
            Paquet aux = p.obtain(a);
            if(aux.validarrecurs(old_name)) {
                aux.esborrarRecurs(old_name);
                aux.assignarRecurs(new_name, cr.obtenirRecurs(new_name));
            }
        }
        paquets = pa.obtainAllTST();
        for(String a : paquets){
            Paquet aux = pa.obtain(a);
            if(aux.validarrecurs(old_name)) {
                aux.esborrarRecurs(old_name);
                aux.assignarRecurs(new_name, cr.obtenirRecurs(new_name));
            }
        }
    }

    public void guardarPaquets(String nomFitxer) throws IOException{
        cp.obrirFitxer(nomFitxer);
        cp.deleteFile();
        guardar();
        //cp.writeTextFile(llistatGuardar());
        cp.tancarFitxer();
    }

    public void carregarPaquets(String nomFitxer) throws IOException {
        ide.reset();
        cp.obrirFitxer(nomFitxer);
        String d = cp.readTextFile();
        String[] dades = d.split("#");
        for (int i = 0; i < dades.length;++i) {
            String[] aux = dades[i].split("\n");
            Paquet pac = new Paquet(Integer.parseInt(aux[0]));
            p.insert(aux[0],pac);
            for(int j = 1; j < aux.length; ++j) {
                pac.assignarRecurs(aux[j],cr.obtenirRecurs(aux[j]));
            }
        }
        cp.tancarFitxer();
    }

    private void guardar() throws IOException{
        Iterable<String> s;
        s = p.obtainAllTST();
        for(String id : s){
            String list = new String();
            list += id + "\n";
            Paquet aux = p.obtain(id);
            list += aux.llistatRecursos();
            list += "#";
            cp.writeTextFile(list);
        }
        s = pa.obtainAllTST();
        for(String id : s){
            String list = new String();
            list += id + "\n";
            Paquet aux = pa.obtain(id);
            list += aux.llistatRecursos();
            list += "#";
            cp.writeTextFile(list);
        }
    }
}