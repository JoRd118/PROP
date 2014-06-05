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
public class VistaPaquet extends Vista{
    
    private static Controlador_Presentacio_Paquet cp;
    private static JPanel paquet;
    private VistaGlobal v;
    
    private JButton buttonPaquetOP3 = new JButton("AssignarRecurs");
    private JButton buttonPaquetOP8 = new JButton("LlistatPaquetsAssignats");
    private JButton buttonPaquetOP9 = new JButton("LlistatPaquetsNoAssignats");
    
    
    public VistaPaquet (){
        v = super.getF();
        createVistaPaquet();
    }
    
    public VistaPaquet(Controlador_Presentacio_Paquet a){
        v = super.getF();
        cp = a;
        createVistaPaquet();
        
    }
    
    public void createVistaPaquet(){
        paquet = new JPanel();
        paquet.setLayout(new GridLayout(3, 2, 5, 5));
        paquet.add(buttonAlta = new JButton("AltaPaquet"));
        paquet.add(buttonBaixa = new JButton("BaixaPaquet"));
        paquet.add(buttonPaquetOP3);
        paquet.add(buttonObtenir = new JButton("ObtenirPaquet"));
        paquet.add(buttonPaquetOP8);
        paquet.add(buttonPaquetOP9);
        paquet.add(buttonGuardar = new JButton("Guardar"));
        paquet.add(buttonCarregar = new JButton("Carregar"));
        
        assignar_actionListeners();
    }
    
    public JPanel construct(){
        return paquet;
    }
    
    private void assignar_actionListeners(){
        buttonAlta.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                altaPaquet(event);
            }
        });
        
        
        buttonBaixa.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                baixaPaquet(event);
            }
        });
        
        
        buttonPaquetOP3.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                assignarRecurs(event);
            }
        });
        
        buttonObtenir.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirPaquet(event);
            }
        });
        
        buttonPaquetOP8.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                llistatPaquetsAssignats(event);
            }
        });
        
        buttonPaquetOP9.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                llistatPaquetsNoAssignats(event);
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
    }
    
    
    private void altaPaquet (ActionEvent event){
        try{
            cp.altaPaquet();
            llistatPaquetsNoAssignats(event);
            
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    private void baixaPaquet(ActionEvent event){
        contentSchemaA();
        label.setText("OP:BaixaPaquet  Nom Paquet:");
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                dobaixaRecurs(event);
            }
        });
        
        paint(content);
        
    }
    
    private void assignarRecurs(ActionEvent event){
        contentSchemaD();
        label.setText("OP:Assignar Paquet-Recurs  Nom Paquet:");
        label2.setText("Nom Recurs:");
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doassignarRecurs(event);
            }
        });
        paint(content);
    }
    
    private void obtenirPaquet(ActionEvent event){
        contentSchemaA();
        label.setText("OP:ObtenirPaquet  ID Paquet:");
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doobtenirPaquet(event);
            }
        });
        
        paint(content);
        
    }
    
    private void llistatPaquetsAssignats(ActionEvent event){
        try{
            contentSchemaC();
            textarea.setText(cp.llistatPaquetsAssignats());
            paint(content);
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    
    private void llistatPaquetsNoAssignats(ActionEvent event){
        try{
            contentSchemaC();
            textarea.setText(cp.llistatPaquetsNoAssignats());
            paint(content);
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    
    private void guardar(ActionEvent event){
        try{
            content = new JPanel();
            label_Exe = new JLabel();
            content.add(label_Exe);
            paint(content);
            JFileChooser elegirArchivo = new JFileChooser();
            File archivo = null;
            FileFilter tipo = new FileNameExtensionFilter(".paq", "paq");
            elegirArchivo.addChoosableFileFilter(tipo);
            
            int estado = elegirArchivo.showDialog(null, "Guardar");
            
            if (estado == JFileChooser.APPROVE_OPTION) {
                archivo = elegirArchivo.getSelectedFile();
                String direccion = archivo.toString();
                String direccion_copy = direccion;
                direccion_copy = direccion_copy.substring((direccion_copy.length())-3,direccion_copy.length());
                if(direccion.contains(".")){
                    if(direccion_copy.equals("paq")){
                        cp.guardarPaquets(direccion);
                        done();
                    }
                    else{error_ex("Exception: Extencio del fitxer incorrecte (hauria de ser '.paq') ");}
                }
                else{error_ex("Exception: Fitxer sense extenció (hauria de ser '.paq') ");}
                
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
            FileFilter tipo = new FileNameExtensionFilter(".paq", "paq");
            elegirArchivo.addChoosableFileFilter(tipo);
            
            int estado = elegirArchivo.showDialog(null, "Carregar");
            
            if (estado == JFileChooser.APPROVE_OPTION) {
                archivo = elegirArchivo.getSelectedFile();
                String direccion = archivo.toString();
                String direccion_copy = direccion;
                direccion_copy = direccion_copy.substring((direccion_copy.length())-3,direccion_copy.length());
                if(direccion.contains(".")){
                    if(direccion_copy.equals("paq")){
                        cp.carregarPaquets(direccion);
                        done();
                    }
                    else{error_ex("Exception: Extencio del fitxer incorrecte (hauria de ser '.paq') ");}
                }
                else{error_ex("Exception: Fitxer sense extenció (hauria de ser '.paq') ");}
                
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
    
    //do-functions
    private void dobaixaRecurs(ActionEvent event){
        try{
            cp.baixaPaquetVista(Integer.parseInt(text.getText()));
            String a = cp.llistatPaquetsAssignats();
            String b = cp.llistatPaquetsNoAssignats();
            contentSchemaC();
            textarea.setText("Assignats: \n"+ a +"Desassignats: \n"+b);
            paint(content);
            
            
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    
    
    private void doassignarRecurs(ActionEvent event){
        try{
            cp.assignarRecurs(Integer.parseInt(text.getText()),text2.getText());
            
            done();
            
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    
    private void doobtenirPaquet(ActionEvent event){
        contentSchemaC();
        paint(content);
        try{
            String aux = text.getText();
            String aux2 = cp.llistatRecursosPaquet(cp.obtenirIdPaquet(cp.obtenirPaquet(Integer.parseInt(aux))));
            textarea.setText(aux2);
            //label = new JLabel("ID Paquet: "+ cp.obtenirIdPaquet(cp.obtenirPaquet(Integer.parseInt(aux))));
            //content.add(label, BorderLayout.NORTH );

        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
        
    }
    /*
     private void doguardarPaquets(ActionEvent event){
     try{
     cp.guardarPaquets(text.getText());
     
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
     
     private void docarregarPaquet(ActionEvent event){
     try{
     cp.carregarPaquets(text.getText());
     
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
