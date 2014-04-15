import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Controlador_Dades_Plnaeta {

	final static Charset ENCODING = StandardCharsets.UTF_8;

	public Controlador_Dades_Planeta() {}

	public ArrayList<String> readTextFile(String nomFitxer) throws IOException {
        ArrayList<String> s = new ArrayList<String>();
        Path path = Paths.get(nomFitxer);
        try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)){
            String line = null;
            while ((line = reader.readLine()) != null) {
                s.add(line);
                //log(line);
            }
        }
        return s;
    }

    public void writeTextFile(String nomFitxer, Iterable<String> aLines) throws IOException {
        Path path = Paths.get(nomFitxer);
        try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)){
            for(String line : aLines){
                writer.write(line);
                writer.newLine();
            }
        }
    }

}