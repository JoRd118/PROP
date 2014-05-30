import java.io.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFileChooser;
import java.io.File;
import java.awt.Desktop;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * @param args the command line arguments
 */
public class VistaSave extends Vista{
    
    private static Controlador_Presentacio cp;
    private static JPanel save;
    private VistaGlobal v;
    
    
    
    //Content Tools
    
    
    public VistaSave (){
        v = super.getF();
        createVistaSave();
    }
    
    public VistaSave(Controlador_Presentacio a){
        v = super.getF();
        cp = a;
        createVistaSave();
        
    }
    
    private void createVistaSave(){
        save = new JPanel();
         save.setLayout(new GridLayout(3, 2, 5, 5));
        save.add(buttonGuardar = new JButton("Guardar"));
     assignar_actionListeners();
    }
    
    private void assignar_actionListeners(){
        //Alta
        buttonGuardar.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                save(event);
            }
        });
    }
    
    
    public void save(ActionEvent event){
        try{
            content = new JPanel();
            paint(content);
            JFileChooser elegirArchivo = new JFileChooser();
            File archivo = null;
            FileFilter tipo = new FileNameExtensionFilter(".txt", "txt");
            elegirArchivo.addChoosableFileFilter(tipo);
            
            int estado = elegirArchivo.showDialog(null, "Guardar");
            
            if (estado == JFileChooser.APPROVE_OPTION) {
                archivo = elegirArchivo.getSelectedFile();
                String direccion = archivo.toString();
                cp.guardarTot(direccion);
                done();
                
            }
            /*
             else if (estado == JFileChooser.CANCEL_OPTION) {
             JOptionPane.showMessageDialog(null, "No se eligio archivo", "Error", 0);
             }*/
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
        
    }
    
    public JPanel construct(){
        return save;
    }
    
    private void done(){
        
        content = new JPanel();
        label = new JLabel("Fet.");
        content.setLayout( new BorderLayout() );
        content.setPreferredSize( new Dimension( 400, 100 ) );
        content.setMinimumSize( new Dimension( 100, 50 ) );
        content.add(label, BorderLayout.NORTH );
        paint(content);
    }
    
    public void paint(JPanel p){
        v.revalidatepanel3(p);
    }
    
    
}
