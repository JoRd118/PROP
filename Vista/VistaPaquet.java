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
    
    private static Controlador_Domini_Paquet cp;
    private static JPanel paquet;
    private VistaGlobal v;
    
    private JButton buttonPaquetOP3 = new JButton("AssignarRecurs");
    private JButton buttonPaquetOP8 = new JButton("LlistatPaquetsAssignats");
    private JButton buttonPaquetOP9 = new JButton("LlistatPaquetsNoAssignats");
    
    
    public VistaPaquet (){
        v = super.getF();
        createVistaPaquet();
    }
    
    public VistaPaquet(Controlador_Domini_Paquet a){
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
            
            content = new JPanel();
            label = new JLabel("Paquet creat.");
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
    private void baixaPaquet(ActionEvent event){
        contentSchemaA();
        label = new JLabel("OP:BaixaPaquet  Nom Paquet:");
        content.add(label, BorderLayout.NORTH );
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                dobaixaRecurs(event);
            }
        });
        
        paint(content);

    }

    private void assignarRecurs(ActionEvent event){
        label = new JLabel("OP:Assignar Paquet-Recurs  Nom Paquet:");
        label2 = new JLabel("Nom Recurs:");
        contentSchemaD();

        
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
        label = new JLabel("OP:ObtenirPaquet  ID Paquet:");
        content.add(label, BorderLayout.NORTH );
        
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
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }

    }

    private void llistatPaquetsNoAssignats(ActionEvent event){
        try{
            contentSchemaC();
            textarea.setText(cp.llistatPaquetsNoAssignats());
            paint(content);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }

    }

    private void guardar(ActionEvent event){
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
                cp.guardarPaquets(direccion);
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

    private void carregar(ActionEvent event){
        try{
            content = new JPanel();
            paint(content);
            JFileChooser elegirArchivo = new JFileChooser();
            File archivo = null;
            FileFilter tipo = new FileNameExtensionFilter(".txt", "txt");
            elegirArchivo.addChoosableFileFilter(tipo);
            
            int estado = elegirArchivo.showDialog(null, "Carregar");
            
            if (estado == JFileChooser.APPROVE_OPTION) {
                archivo = elegirArchivo.getSelectedFile();
                String direccion = archivo.toString();
                cp.carregarPaquets(direccion);
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
    
//do-functions
    private void dobaixaRecurs(ActionEvent event){
        try{
            cp.baixaPaquetVista(Integer.parseInt(text.getText()));
            content = new JPanel();
            label = new JLabel("Fet.");
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
    
    
    private void doassignarRecurs(ActionEvent event){
        try{
            cp.assignarRecurs(Integer.parseInt(text.getText()),text2.getText());
        
            content = new JPanel();
            label = new JLabel("Fet.");
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
    
    private void doobtenirPaquet(ActionEvent event){
        try{
            String aux = text.getText();
            contentSchemaC();
            textarea.setText(cp.llistatRecursosPaquet(cp.obtenirIdPaquet(cp.obtenirPaquet(Integer.parseInt(aux)))));
                             label = new JLabel("ID Paquet: "+ cp.obtenirIdPaquet(cp.obtenirPaquet(Integer.parseInt(aux))));
            content.add(label, BorderLayout.NORTH );
            paint(content);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
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
