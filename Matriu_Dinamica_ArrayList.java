import java.util.*;
/**
 *Matrius dinamiques bidimensionals amb ArrayList
 *
 *@author Claudi
 */
public class Matriu_Dinamica_ArrayList{
    
    private static ArrayList<ArrayList<Integer>> p;
    
    public static void main(String[] args){
        //Declaració
        p = new ArrayList<ArrayList<Integer>>();
        
        //Declaració: FILA 0
        ArrayList<Integer> p1 = new ArrayList<Integer>();
        p.add(p1);//IMPORTANT un cop creada la fila cal ubicar-la a la matriu.
        
        //Omplir fila 0
        p1.add(0);
        p1.add(2);
        
        //Declaració: FILA 1
        ArrayList<Integer> p2 = new ArrayList<Integer>();
        p.add(p2);
        
        //Omplir fila 0
        p2.add(0);
        p2.add(2);
        p2.add(3);
        
        //Print Fila
        System.out.println(p.get(0));
        System.out.println(p.get(1));
        
        //Print Posicio
        System.out.println("Pos [0][0] = "+p.get(0).get(0));
        System.out.println("Pos [1][2] = "+p.get(1).get(2));
    }
}