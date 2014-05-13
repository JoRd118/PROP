import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.io.File;
import java.util.*;
/**
 *
 *Controlador Dades
 *
 *@author Claudi
 */
public class Controlador_Dades{
    
    final static Charset ENCODING = StandardCharsets.UTF_8;
    private Path path;
    private File f;
    
    
    public Controlador_Dades(){}
    
    public void obrirFitxer(String nomFitxer) throws IOException {
        path = Paths.get(nomFitxer);
        f = new File(nomFitxer);
        //String path = f.getAbsolutePath();
    }
    
    public void tancarFitxer(){
        path = null;
        f = null;
        
    }
    
    public String readTextFile()  throws IOException{
        String aux = new String();
        String line = null;
        try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)){
            while ((line = reader.readLine()) != null) {
                aux = aux + line + "\n";
                //log(line);
            }
        }
        return aux;
    }
    
    public void deleteFile(){
            f.delete();
    }
    
    public void writeTextFile(String line)  throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(f,true))){
            writer.write(line);
            //writer.newLine();
            writer.close();
        }
    }
    
    
    private static void log(Object aMsg){
        System.out.println(String.valueOf(aMsg));
    }
    
}