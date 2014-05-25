import java.util.*;
import java.io.IOException;

public class programa{
    
    public static void main(String[] args) {
        Controlador_Domini_QAP cdqap = new Controlador_Domini_QAP();
        Solucio s = new Solucio();
        cdqap.run_algorithm("BBE", s);
        String arbre = s.arbreSolucio(0);
        String sSol = s.printSolucioQAP(0);
        System.out.println("-------------------------------");
        System.out.println(arbre);
        System.out.println("-------------------------------");
        System.out.println(sSol);
        System.out.println("-------------------------------");

    }
}
