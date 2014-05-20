import java.io.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @param args the command line arguments
 */
public class SubVista extends Vista{
    
    private static VistaGlobal f;
    
    public SubVista(){
        
        
    }
    
    public SubVista(VistaGlobal a){
        f = a;
    
    }
    
    public VistaGlobal getF(){
        
        return f;
    }
    
}
