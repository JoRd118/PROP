import java.util.*;
import java.io.Console;

public class programa {

	public static void main(String[] args) {
		
		// Crear controlador de domini QAP
		Controlador_Domini_QAP cdqap = new Controlador_Domini_QAP();
		// Carregar les dades
		// Engegar algoritme
//		cdqap.run_algorithm("BBL", "");

//		cdqap.run_algorithm("BBE", "");

//		cdqap.run_algorithm("BBL", "H");

//		cdqap.run_algorithm("BBE", "H");

		cdqap.run_algorithm("TABU", "");

//*		
		Console console = System.console();
		String xintro = console.readLine("<intro>");
//*/
	}
}