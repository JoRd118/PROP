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
    
    public JPanel construct(){
        return save;
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
            label_Exe = new JLabel();
            content.add(label_Exe);
            paint(content);
            JFileChooser elegirArchivo = new JFileChooser();
            File archivo = null;
            FileFilter tipo = new FileNameExtensionFilter(".txt", "txt");
            elegirArchivo.addChoosableFileFilter(tipo);
            
            int estado = elegirArchivo.showDialog(null, "Guardar");
            
            if (estado == JFileChooser.APPROVE_OPTION) {
                archivo = elegirArchivo.getSelectedFile();
                String direccion = archivo.toString();
                
                String direccion_copy = direccion;
                direccion_copy = direccion_copy.substring((direccion_copy.length())-3,direccion_copy.length());
                
                if(direccion_copy.equals("txt")){
                    cp.guardar_I(direccion);
                    direccion = direccion.replace("txt", "rec");
                    cp.guardar_R(direccion);
                    direccion = direccion.replace("rec","paq");
                    cp.guardar_P(direccion);
                    direccion = direccion.replace("paq","pla");
                    cp.guardar_Pl(direccion);
                    direccion = direccion.replace("pla","uni");
                    cp.guardar_U(direccion);
                    direccion = direccion.replace("uni","qap");
                    cp.guardar_Q(direccion);
                    done();
                }
                else{error_ex("Exception: Extencio del fitxer incorrecte (hauria de ser '.txt') ");}
            }
            /*
             else if (estado == JFileChooser.CANCEL_OPTION) {
             JOptionPane.showMessageDialog(null, "No se eligio archivo", "Error", 0);
             }*/
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    
    public void instruccions(){
        save = new JPanel();
        save.setLayout(new GridLayout(10, 2, 5, 5));
        
        label = new JLabel("Istruccions: OP: Guardar tot.");
        label2 = new JLabel("Indicar l'ubicació on es vol guardar. El nom del fitxer ha de ser: _____.txt ");
        
        save.add(label);
        save.add(label2);
    
    }
    
    
    private void done(){
        
        content = new JPanel();
        label = new JLabel("   Fet.(aka Good!)");
        label.setForeground(Color.blue);
        content.setLayout( new BorderLayout() );
        content.setPreferredSize( new Dimension( 400, 100 ) );
        content.setMinimumSize( new Dimension( 100, 50 ) );
        content.add(label, BorderLayout.NORTH );
        paint(content);
    }
    public void error_ex(String a){
        content = new JPanel();
        label = new JLabel("-> "+a);
        label.setForeground(Color.red);
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
