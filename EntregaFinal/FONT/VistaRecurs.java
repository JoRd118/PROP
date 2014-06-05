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
public class VistaRecurs extends Vista{
    
    private static Controlador_Presentacio_Recurs cr;
    private static JPanel recurs;
    private VistaGlobal v;
    
    private JButton buttonRecursOP2 = new JButton("NumRecursos");
    
    
    //Content Tools
    
    
    public VistaRecurs (){
        v = super.getF();
        createVistaRecurs();
    }
    
    public VistaRecurs(Controlador_Presentacio_Recurs a){
        v = super.getF();
        cr = a;
        createVistaRecurs();
        
    }
    
    public void createVistaRecurs(){
        recurs = new JPanel();
        recurs.setLayout(new GridLayout(3, 2, 5, 5));
        recurs.add(buttonAlta = new JButton("AltaRecurs"));
        recurs.add(buttonBaixa = new JButton("BaixaRecurs"));
        recurs.add(buttonObtenir = new JButton("ObtenirRecurs"));
        recurs.add(buttonObtenirID = new JButton("ObtenirID"));
        recurs.add(buttonllistat = new JButton("Llistar"));
        recurs.add(buttonRecursOP2);
        recurs.add(buttonModNom = new JButton("ModificarNom"));
        recurs.add(buttonGuardar = new JButton("Guardar"));
        recurs.add(buttonCarregar = new JButton("Carregar"));
        
        
        assignar_actionListeners();
        
    }
    
    public JPanel construct(){
        return recurs;
    }
    
    private void assignar_actionListeners(){
        buttonAlta.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                altaRecurs(event);
            }
        });
        
        buttonObtenir.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirRecurs(event);
            }
        });
        
        buttonObtenirID.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirId(event);
            }
        });
        
        buttonllistat.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                llistatRecurs(event);
            }
        });
        
        buttonRecursOP2.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                numRecursos(event);
            }
        });
        
        buttonGuardar.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                guardar(event);
            }
        });
        
        buttonCarregar.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                carregar(event);
            }
        });
        
        buttonModNom.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                modnom(event);
            }
        });
        
        buttonBaixa.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                baixaRecurs(event);
            }
        });
        
        
    }
    
    
    
    private void altaRecurs(ActionEvent event){
        contentSchemaA();
        label.setText("OP:AltaRecurs  Nom Recurs:");
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doaltaRecurs(event);
            }
        });
        
        paint(content);
    }
    
    private void baixaRecurs(ActionEvent event){
        contentSchemaA();
        label.setText("OP:BaixaRecurs  Nom Recurs:");
        
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                dobaixaRecurs(event);
            }
        });
        
        paint(content);
        
        
    }
    
    private void obtenirRecurs(ActionEvent event){
        contentSchemaA();
        label.setText("OP:ObtenirRecurs  Nom Recurs:");
        
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doobtenirRecurs(event);
            }
        });
        
        paint(content);
        
    }
    
    private void obtenirId(ActionEvent event){
        contentSchemaA();
        label.setText("OP:ObtenirIdRecurs  Nom Recurs:");
        
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doobtenirIdRecurs(event);
            }
        });
        
        paint(content);
        
    }
    
    private void llistatRecurs(ActionEvent event){
        try{
            String aux = cr.llistatRecurs();
            contentSchemaC();
            if(aux != null){textarea.setText(aux);}
            paint(content);
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    
    private void numRecursos(ActionEvent event){
        contentSchemaC();
        textarea.setText(String.valueOf(cr.totalRecursos()));
        paint(content);
        
    }
    
    private void guardar(ActionEvent event){
        try{
            content = new JPanel();
            label_Exe = new JLabel();
            content.add(label_Exe);
            paint(content);
            JFileChooser elegirArchivo = new JFileChooser();
            File archivo = null;
            FileFilter tipo = new FileNameExtensionFilter(".rec", "rec");
            elegirArchivo.addChoosableFileFilter(tipo);
            
            int estado = elegirArchivo.showDialog(null, "Guardar");
            
            if (estado == JFileChooser.APPROVE_OPTION) {
                archivo = elegirArchivo.getSelectedFile();
                String direccion = archivo.toString();
                
                String direccion_copy = direccion;
                direccion_copy = direccion_copy.substring((direccion_copy.length())-3,direccion_copy.length());
                if(direccion.contains(".")){
                    if(direccion_copy.equals("rec")){
                        cr.guardarRecursos(direccion);
                        done();
                    }
                    else{error_ex("Exception: Extencio del fitxer incorrecte (hauria de ser '.rec') ");}
                }
                else{error_ex("Exception: Fitxer sense extenció (hauria de ser '.rec') ");}
                
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
    
    private void carregar(ActionEvent event){
        try{
            content = new JPanel();
            label_Exe = new JLabel();
            content.add(label_Exe);
            paint(content);
            JFileChooser elegirArchivo = new JFileChooser();
            File archivo = null;
            FileFilter tipo = new FileNameExtensionFilter(".rec", "rec");
            elegirArchivo.addChoosableFileFilter(tipo);
            
            int estado = elegirArchivo.showDialog(null, "Carregar");
            
            if (estado == JFileChooser.APPROVE_OPTION) {
                archivo = elegirArchivo.getSelectedFile();
                String direccion = archivo.toString();
                String direccion_copy = direccion;
                direccion_copy = direccion_copy.substring((direccion_copy.length())-3,direccion_copy.length());
                if(direccion.contains(".")){
                    if(direccion_copy.equals("rec")){
                        cr.carregarRecursos(direccion);
                        done();
                    }
                    
                    else{error_ex("Exception: Extencio del fitxer incorrecte (hauria de ser '.rec') ");}
                }
                else{error_ex("Exception: Fitxer sense extenció (hauria de ser '.rec') ");}
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
    
    private void modnom(ActionEvent event){
        contentSchemaD();
        label.setText("OP:Mod Nom Recurs  Nom Recurs:");
        label2.setText("New Nom:");
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                donomRecurs(event);
            }
        });
        paint(content);
        
        
    }
    
    //do-functions
    private void doaltaRecurs(ActionEvent event){
        try{
            cr.altaRecurs(text.getText());
            llistatRecurs(event);
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    
    private void dobaixaRecurs(ActionEvent event){
        try{
            cr.baixaRecursVista(text.getText());
            llistatRecurs(event);
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    
    private void doobtenirRecurs(ActionEvent event){
                    contentSchemaB();
                    paint(content);
        try{
            String aux = text.getText();
            label = new JLabel("Nom Recurs: "+ aux + "  Id: " + cr.obtenirId(aux));
            content.add(label, BorderLayout.NORTH );
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
    }
    
    private void doobtenirIdRecurs(ActionEvent event){
        try{
            String aux = text.getText();
            contentSchemaB();
            label = new JLabel("Nom Recurs: "+ aux + "  Id: " + cr.obtenirId(aux));
            content.add(label, BorderLayout.NORTH );
            paint(content);
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    /*
     private void doguardarRecurs(ActionEvent event){
     try{
     cr.guardarRecursos(text.getText());
     
     content = new JPanel();
     label = new JLabel("Exit al Guardar.");
     content.setLayout( new BorderLayout() );
     content.setPreferredSize( new Dimension( 400, 100 ) );
     content.setMinimumSize( new Dimension( 100, 50 ) );
     content.add(label, BorderLayout.NORTH );
     paint(content);
     }
     catch (Exception ex){
     JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
     }
     }
     
     private void docarregarRecurs(ActionEvent event){
     try{
     cr.carregarRecursos(text.getText());
     
     content = new JPanel();
     label = new JLabel("Exit al Carregar.");
     content.setLayout( new BorderLayout() );
     content.setPreferredSize( new Dimension( 400, 100 ) );
     content.setMinimumSize( new Dimension( 100, 50 ) );
     content.add(label, BorderLayout.NORTH );
     paint(content);
     }
     catch (Exception ex){
     JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
     }
     
     }
     */
    private void donomRecurs(ActionEvent event){
        try{
            cr.modificar_nom_recursVista(text.getText(),text2.getText());
            llistatRecurs(event);
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
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
        label_Exe.setText("-> "+a);
        label_Exe.setForeground(Color.red);
    }
    
    public void paint(JPanel p){
        v.revalidatepanel3(p);
    }
    
    
}
