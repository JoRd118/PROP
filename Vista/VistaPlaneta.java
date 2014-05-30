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
public class VistaPlaneta extends Vista{
    
    private static Controlador_Domini_Planeta cp;
    private static JPanel planeta;
    private VistaGlobal v;
    
    private JButton buttonPlanetaOP3 = new JButton("AssignarPlaneta");
    private JButton buttonPlanetaOP4 = new JButton("DesassignarPlaneta");
    private JButton buttonPlanetaOP5 = new JButton("ModificarNom");
    private JButton buttonPlanetaOP6 = new JButton("ModificarCoordenades");
    private JButton buttonPlanetaOP7 = new JButton("ModificarClasse");
    private JButton buttonPlanetaOP9 = new JButton("ObtenirClasse");
    private JButton buttonPlanetaOP10 = new JButton("ObtenirCoordenades");
    private JButton buttonPlanetaOP11 = new JButton("ObtenirPlaneta");
    private JButton buttonPlanetaOP13 = new JButton("LlistarAssignat");
    private JButton buttonPlanetaOP14 = new JButton("AltaNecessitats");
    private JButton buttonPlanetaOP15 = new JButton("BaixaNecessitats");
    private JButton buttonPlanetaOP16 = new JButton("AssignarPaquet");
    private JButton buttonPlanetaOP17 = new JButton("DesassignarPaquet");
    private JButton buttonPlanetaOP18 = new JButton("obtenirRecursosDisponibles");
    private JButton buttonPlanetaOP19 = new JButton("ObtenirNecessitats");
    
    
    public VistaPlaneta (){
        v = super.getF();
        createVistaPlaneta();
    }
    
    public VistaPlaneta(Controlador_Domini_Planeta a){
        v = super.getF();
        cp = a;
        createVistaPlaneta();
        
    }
    
    public void createVistaPlaneta(){
        planeta = new JPanel();
        planeta.setLayout(new GridLayout(3, 2, 5, 5));
        planeta.add(buttonAlta = new JButton("AltaPlaneta"));
        planeta.add(buttonBaixa = new JButton("BaixaPlaneta"));
        planeta.add(buttonObtenirID = new JButton("ObtenirID"));
        planeta.add(buttonPlanetaOP5);
        planeta.add(buttonPlanetaOP6);
        planeta.add(buttonPlanetaOP7);
        planeta.add(buttonPlanetaOP9);
        planeta.add(buttonPlanetaOP10);
        planeta.add(buttonPlanetaOP11);
        planeta.add(buttonllistat = new JButton("LlistarDessasignats"));
        planeta.add(buttonPlanetaOP13);
        planeta.add(buttonPlanetaOP14);
        planeta.add(buttonPlanetaOP15);
        planeta.add(buttonPlanetaOP16);
        planeta.add(buttonPlanetaOP17);
        planeta.add(buttonPlanetaOP18);
        planeta.add(buttonPlanetaOP19);
        planeta.add(buttonGuardar = new JButton("Guardar"));
        planeta.add(buttonCarregar = new JButton("Carregar"));
        
        
        
        assignar_actionListeners();
        
    }
    
    public JPanel construct(){
        return planeta;
    }
    
    private void assignar_actionListeners(){
        buttonAlta.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                altaPlaneta(event);
            }
        });
        
        buttonBaixa.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                baixaPlaneta(event);
            }
        });
        
        buttonObtenirID.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirId(event);
            }
        });
        
        buttonPlanetaOP5.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                modnom(event);
            }
        });
        
        buttonPlanetaOP6.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                modcoord(event);
            }
        });
        
        buttonPlanetaOP7.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                modclasse(event);
            }
        });
        
        buttonPlanetaOP9.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirClasse(event);
            }
        });
        
        buttonPlanetaOP10.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirCoordenades(event);
            }
        });
        
        buttonPlanetaOP11.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirPlaneta(event);
            }
        });
        
        buttonllistat.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                llistarPlanetesDesassignat(event);
            }
        });
        
        buttonPlanetaOP13.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                llistarPlanetesAssignat(event);
            }
        });
        
        buttonPlanetaOP14.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                altaNecessitats(event);
            }
        });
        
        buttonPlanetaOP15.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                baixaNecessitats(event);
            }
        });
        
        buttonPlanetaOP16.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                assignarPaquet(event);
            }
        });
        
        buttonPlanetaOP17.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                desassignarPaquet(event);
            }
        });
        
        buttonPlanetaOP18.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirRecursosDisponibles(event);
            }
        });
        
        buttonPlanetaOP19.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirNecessitats(event);
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
    
    
    
    
    
    private void altaPlaneta (ActionEvent event){
        contentSchemaE();
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doaltaPlaneta(event);
            }
        });
        
        
        paint(content);
        
    }
    
    private void baixaPlaneta (ActionEvent event){
        label = new JLabel("OP:BaixaPlaneta  Nom Planeta:");
         contentSchemaA();
        content.add(label, BorderLayout.NORTH );
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                dobaixaPlaneta(event);
            }
        });
        
        paint(content);
        
    }
    
    private void obtenirId (ActionEvent event){
        label = new JLabel("OP:ObtenirIdPlaneta  Nom Planeta:");
        contentSchemaA();
        content.add(label, BorderLayout.NORTH );
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doobtenirIdPlaneta(event);
            }
        });
        
        paint(content);
        
        
    }
    
    private void obtenirClasse (ActionEvent event){
        label = new JLabel("OP:ObtenirClassePlaneta  Nom Planeta:");
        contentSchemaA();
        content.add(label, BorderLayout.NORTH );
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doobtenirclassePlaneta(event);
            }
        });
        
        paint(content);
        
    }
    
    private void obtenirCoordenades (ActionEvent event){
        label = new JLabel("OP:ObtenirCoordPlaneta  Nom Planeta:");
        contentSchemaA();
        content.add(label, BorderLayout.NORTH );
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doobtenirCoordPlaneta(event);
            }
        });
        
        paint(content);
        
    }
    
    private void obtenirPlaneta (ActionEvent event){
        label = new JLabel("OP:ObtenirPlaneta  Nom Planeta:");
        contentSchemaA();
        content.add(label, BorderLayout.NORTH );
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doobtenirPlaneta(event);
            }
        });
        
        paint(content);
        
    }
    
    private void llistarPlanetesDesassignat (ActionEvent event){
        try{
            contentSchemaC();
            textarea.setText(cp.llistarPlanetesDesassignat());
            paint(content);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
        
    }
    
    private void llistarPlanetesAssignat (ActionEvent event){
        try{
            contentSchemaC();
            textarea.setText(cp.llistarPlanetesAssignat());
            paint(content);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
        
    }
    
    private void altaNecessitats(ActionEvent event){
        label = new JLabel("OP:AltaNecessitat  Nom Planeta:");
        label2 = new JLabel("Nom Recurs:");
        contentSchemaD();
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doaltaNecesitat(event);
            }
        });
        paint(content);
        
    }
    
    private void baixaNecessitats (ActionEvent event){
        label = new JLabel("OP:BaixaNecessitat  Nom Planeta:");
        label2 = new JLabel("Nom Recurs:");
        contentSchemaD();
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                dobaixaNecesitat(event);
            }
        });
        paint(content);
        
    }
    
    private void assignarPaquet (ActionEvent event){
        label = new JLabel("OP:AssignarPaquet  Nom Planeta:");
        label2 = new JLabel("ID Paquet:");
        contentSchemaD();
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doassignarPaquet(event);
            }
        });
        paint(content);
        
    }
    
    private void desassignarPaquet (ActionEvent event){
        label = new JLabel("OP:DeassignarPaquet  Nom Planeta:");
        contentSchemaA();
        content.add(label, BorderLayout.NORTH );
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                dodesassignarPaquet(event);
            }
        });
        
        paint(content);
        
    }
    
    private void obtenirRecursosDisponibles (ActionEvent event){
        label = new JLabel("OP:RecursosDisponibles  Nom Planeta:");
        contentSchemaA();
        content.add(label, BorderLayout.NORTH );
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                dorecursosDisponib(event);
            }
        });
        
        paint(content);
        
    }
    
    private void obtenirNecessitats (ActionEvent event){
        label = new JLabel("OP:ObtenirNecesitats  Nom Planeta:");
        contentSchemaA();
        content.add(label, BorderLayout.NORTH );
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doobtenirneed(event);
            }
        });
        
        paint(content);
    }
    
    private void modnom(ActionEvent event){
        label = new JLabel("OP:Mod Nom Planeta  Nom Planeta:");
        label2 = new JLabel("new Nom:");
        contentSchemaD();
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                donomPlaneta(event);
            }
        });
        paint(content);
    
    }
    
    private void modclasse(ActionEvent event){
        label = new JLabel("OP:Mod Classe Planeta  Nom Planeta:");
        label2 = new JLabel("new Classe:");
        chinButton = new JCheckBox("Planeta Tipus M");
        chinButton.setMnemonic(KeyEvent.VK_C);
        chinButton.setSelected(true);
        
        chinButton2 = new JCheckBox(" NO Planeta Tipus M");
        chinButton2.setMnemonic(KeyEvent.VK_C);
        chinButton2.setSelected(false);
        
        text = new JTextField();
        b = new JButton("OK");
        
        content = new JPanel();
        content.setLayout( new GridLayout(6, 2, 5, 5) );
        content.setPreferredSize( new Dimension( 400, 100 ) );
        
        content.add(label);
        content.add(text);
        content.add(label2);
        content.add(chinButton);
        content.add(chinButton2);
        content.add(b);
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doclassePlaneta(event);
            }
        });
        paint(content);
    }
    
    private void modcoord(ActionEvent event){
        label = new JLabel("OP:Mod Coord Planeta  Nom Planeta:");
        label2 = new JLabel("new Coord:");
        contentSchemaD();
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                docoordPlaneta(event);
            }
        });
        paint(content);
    }
    
    private void guardar (ActionEvent event){
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
                cp.guardarPlanetes(direccion);
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
    
    private void carregar (ActionEvent event){
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
                cp.carregarPlanetes(direccion);
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
    private void doaltaPlaneta(ActionEvent event){
        try{
            String nom = text.getText();
            String coords = text2.getText();
            if(chinButton.isSelected()){cp.altaPlanetaVista(nom,coords,true);}
            else if(chinButton2.isSelected()){cp.altaPlanetaVista(nom,coords,false);}
            else{
                throw new IllegalArgumentException("Cal Seleccionar el tipus M");
            }
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
    
    private void dobaixaPlaneta(ActionEvent event){
        try{
            cp.baixaPlanetaVista(text.getText());
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
    
    private void doobtenirIdPlaneta(ActionEvent event){
        try{
            String aux = text.getText();
            contentSchemaB();
            label = new JLabel("ID Planeta: "+ cp.obtenirId(aux));
            content.add(label, BorderLayout.NORTH );
            paint(content);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
    
    }
    
    private void doobtenirclassePlaneta(ActionEvent event){
        try{
            String aux = text.getText();
            contentSchemaB();
            label = new JLabel("Classe Planeta: "+ cp.obtenirClasse(aux));
            content.add(label, BorderLayout.NORTH );
            paint(content);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
    
    }
    private void doobtenirCoordPlaneta(ActionEvent event){
        try{
            String aux = text.getText();
            contentSchemaB();
            label = new JLabel("Coordenades Planeta: "+ cp.obtenirCoordenadesVista(aux));
            content.add(label, BorderLayout.NORTH );
            paint(content);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
    
    }
    
    private void doobtenirPlaneta(ActionEvent event){
        try{
            String aux = text.getText();
            contentSchemaB();
            label = new JLabel("ID Planeta: "+ cp.obtenirId(aux)+" Nom Planeta: "+ aux +" Classe Planeta: "+ cp.obtenirClasse(aux)+ " Coords Planeta: "+ cp.obtenirCoordenadesVista(aux) + " Paquet:" + cp.obtenirPaquetPlaneta(aux));
            content.add(label, BorderLayout.NORTH );
            paint(content);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
    
    }
    
    private void doaltaNecesitat(ActionEvent event){
        try{
            cp.altaNecessitats(text.getText(),text2.getText());
            
            done();
            
            
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
    
    }
    
    private void dobaixaNecesitat(ActionEvent event){
        try{
            cp.baixaNecessitats(text.getText(),text2.getText());
            
            done();
            
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
    }
    
    private void doassignarPaquet(ActionEvent event){
        try{
            cp.assignarPaquet(text.getText(),Integer.parseInt(text2.getText()));
            
            done();
            
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
    
    }
    
    private void dodesassignarPaquet(ActionEvent event){
        try{
            cp.desassignarPaquet(text.getText());
            
            done();
            
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
        
    }
    
    private void doobtenirneed(ActionEvent event){
        try{
            contentSchemaC();
            textarea.setText(cp.obtenirNecessitatsVista(text.getText()));
            
            paint(content);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
        
    }
    
    private void dorecursosDisponib(ActionEvent event){
        try{
            contentSchemaC();
            textarea.setText(cp.obtenirRecursosDisponiblesVista(text.getText()));
            
            paint(content);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
    }
    
    private void donomPlaneta(ActionEvent event){
        try{
            cp.modificarNomPlanetaVista(text.getText(),text2.getText());
            done();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
    }
    
    private void doclassePlaneta(ActionEvent event){
        try{
            if(chinButton.isSelected()){cp.modificarCoordPlanetaVista(text.getText(),true);}
            else if(chinButton2.isSelected()){cp.modificarCoordPlanetaVista(text.getText(),false);}
            else{
                throw new IllegalArgumentException("Cal Seleccionar el tipus M");
            }
            
            done();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
    }
    private void docoordPlaneta(ActionEvent event){
        try{
            String[] aux = text2.getText().split(",");
            cp.modificarCoordPlanetaVista(text.getText(),Integer.parseInt(aux[0]),Integer.parseInt(aux[1]));
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
        
    }
    /*
    private void doguardarPlanetes(ActionEvent event){
        try{
            cp.guardarPlanetes(text.getText());
            
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
    
    private void docarregarPlaneta(ActionEvent event){
        try{
            cp.carregarPlanetes(text.getText());
            
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
