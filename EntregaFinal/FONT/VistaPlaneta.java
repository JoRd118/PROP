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
    
    private static Controlador_Presentacio_Planeta cp;
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
    
    public VistaPlaneta(Controlador_Presentacio_Planeta a){
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
        contentSchemaA();
        label.setText("OP:BaixaPlaneta  Nom Planeta:");
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                dobaixaPlaneta(event);
            }
        });
        
        paint(content);
        
    }
    
    private void obtenirId (ActionEvent event){
        contentSchemaA();
        label.setText("OP:ObtenirIdPlaneta  Nom Planeta:");
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doobtenirIdPlaneta(event);
            }
        });
        
        paint(content);
        
        
    }
    
    private void obtenirClasse (ActionEvent event){
        contentSchemaA();
        label.setText("OP:ObtenirClassePlaneta  Nom Planeta:");
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doobtenirclassePlaneta(event);
            }
        });
        
        paint(content);
        
    }
    
    private void obtenirCoordenades (ActionEvent event){
        contentSchemaA();
        label.setText("OP:ObtenirCoordPlaneta  Nom Planeta:");
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doobtenirCoordPlaneta(event);
            }
        });
        
        paint(content);
        
    }
    
    private void obtenirPlaneta (ActionEvent event){
        contentSchemaA();
        label.setText("OP:ObtenirPlaneta  Nom Planeta:");
        
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
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    
    private void llistarPlanetesAssignat (ActionEvent event){
        try{
            contentSchemaC();
            textarea.setText(cp.llistarPlanetesAssignat());
            paint(content);
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    
    private void altaNecessitats(ActionEvent event){
        contentSchemaD();
        label.setText("OP:AltaNecessitat  Nom Planeta:");
        label2.setText("Nom Recurs:");
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doaltaNecesitat(event);
            }
        });
        paint(content);
        
    }
    
    private void baixaNecessitats (ActionEvent event){
        contentSchemaD();
        label.setText("OP:BaixaNecessitat  Nom Planeta:");
        label2.setText("Nom Recurs:");
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                dobaixaNecesitat(event);
            }
        });
        paint(content);
        
    }
    
    private void assignarPaquet (ActionEvent event){
        contentSchemaD();
        label.setText("OP:AssignarPaquet  Nom Planeta:");
        label2.setText("ID Paquet:");
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doassignarPaquet(event);
            }
        });
        paint(content);
        
    }
    
    private void desassignarPaquet (ActionEvent event){
        contentSchemaA();
        label.setText("OP:DeassignarPaquet  Nom Planeta:");
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                dodesassignarPaquet(event);
            }
        });
        
        paint(content);
        
    }
    
    private void obtenirRecursosDisponibles (ActionEvent event){
        contentSchemaA();
        label.setText("OP:RecursosDisponibles  Nom Planeta:");
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                dorecursosDisponib(event);
            }
        });
        
        paint(content);
        
    }
    
    private void obtenirNecessitats (ActionEvent event){
        contentSchemaA();
        label.setText("OP:ObtenirNecesitats  Nom Planeta:");
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doobtenirneed(event);
            }
        });
        
        paint(content);
    }
    
    private void modnom(ActionEvent event){
        contentSchemaD();
        label.setText("OP:Mod Nom Planeta  Nom Planeta:");
        label2.setText("new Nom:");
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
        chinButton.setSelected(false);
        
        chinButton2 = new JCheckBox(" NO Planeta Tipus M");
        chinButton2.setMnemonic(KeyEvent.VK_C);
        chinButton2.setSelected(false);
        
        text = new JTextField();
        label_Exe = new JLabel();
        b = new JButton("OK");
        
        content = new JPanel();
        content.setLayout( new GridLayout(9, 2, 5, 5) );
        content.setPreferredSize( new Dimension( 400, 100 ) );
        
        content.add(label);
        content.add(text);
        content.add(label2);
        content.add(chinButton);
        content.add(chinButton2);
        content.add(b);
        content.add(label_Exe);
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doclassePlaneta(event);
            }
        });
        paint(content);
    }
    
    private void modcoord(ActionEvent event){
        contentSchemaD();
        label.setText("OP:Mod Coord Planeta  Nom Planeta:");
        label2.setText("new Coord:");
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
            label_Exe = new JLabel();
            content.add(label_Exe);
            paint(content);
            JFileChooser elegirArchivo = new JFileChooser();
            File archivo = null;
            FileFilter tipo = new FileNameExtensionFilter(".pla", "pla");
            elegirArchivo.addChoosableFileFilter(tipo);
            
            int estado = elegirArchivo.showDialog(null, "Guardar");
            
            if (estado == JFileChooser.APPROVE_OPTION) {
                archivo = elegirArchivo.getSelectedFile();
                String direccion = archivo.toString();
                String direccion_copy = direccion;
                direccion_copy = direccion_copy.substring((direccion_copy.length())-3,direccion_copy.length());
                if(direccion.contains(".")){
                    if(direccion_copy.equals("pla")){
                        cp.guardarPlanetes(direccion);
                        done();
                    }
                    else{error_ex("Exception: Extencio del fitxer incorrecte (hauria de ser '.pla') ");}
                }
                else{error_ex("Exception: Fitxer sense extenció (hauria de ser '.pla') ");}
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
    
    private void carregar (ActionEvent event){
        try{
            content = new JPanel();
            label_Exe = new JLabel();
            content.add(label_Exe);
            paint(content);
            JFileChooser elegirArchivo = new JFileChooser();
            File archivo = null;
            FileFilter tipo = new FileNameExtensionFilter(".pla", "pla");
            elegirArchivo.addChoosableFileFilter(tipo);
            
            int estado = elegirArchivo.showDialog(null, "Carregar");
            
            if (estado == JFileChooser.APPROVE_OPTION) {
                archivo = elegirArchivo.getSelectedFile();
                String direccion = archivo.toString();
                String direccion_copy = direccion;
                direccion_copy = direccion_copy.substring((direccion_copy.length())-3,direccion_copy.length());
                if(direccion.contains(".")){
                    if(direccion_copy.equals("pla")){
                        cp.carregarPlanetes(direccion);
                        done();
                    }
                    else{error_ex("Exception: Extencio del fitxer incorrecte (hauria de ser '.pla') ");}
                }
                else{error_ex("Exception: Fitxer sense extenció (hauria de ser '.pla') ");}
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
    private void doaltaPlaneta(ActionEvent event){
        try{
            String nom = text.getText();
            String coords = text2.getText();
            if(chinButton.isSelected()){cp.altaPlanetaVista(nom,coords,true);}
            else if(chinButton2.isSelected()){cp.altaPlanetaVista(nom,coords,false);}
            else{
                throw new IllegalArgumentException("Cal Seleccionar el tipus M");
            }
            String a = cp.llistarPlanetesAssignat();
            String b = cp.llistarPlanetesDesassignat();
            contentSchemaC();
            textarea.setText("Assignats: \n"+ a +"Desassignats: \n"+b);
            paint(content);
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
    }
    
    private void dobaixaPlaneta(ActionEvent event){
        try{
            cp.baixaPlanetaVista(text.getText());
            
            String a = cp.llistarPlanetesAssignat();
            String b = cp.llistarPlanetesDesassignat();
            contentSchemaC();
            textarea.setText("Assignats: \n"+ a +"Desassignats: \n"+b);
            paint(content);
            
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
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
            error_ex("Exception: " + ex.getMessage());
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
            error_ex("Exception: " + ex.getMessage());
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
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    
    private void doobtenirPlaneta(ActionEvent event){
        try{
            String aux = text.getText();
            contentSchemaB();
            int aux3 = cp.obtenirPaquetPlaneta(aux);
            
            String aux4 = "No te paquet";
            if(aux3 >= 0) aux4 = " " + aux3;
            
            label = new JLabel("ID Planeta: "+ cp.obtenirId(aux)+" Nom Planeta: "+ aux +" Classe Planeta: "+ cp.obtenirClasse(aux)+ " Coords Planeta: "+ cp.obtenirCoordenadesVista(aux) + " Paquet:" + aux4);
            /*System.out.println("HERE");
             System.out.println(cp.obtenirId(aux));
             System.out.println(cp.obtenirClasse(aux));
             System.out.println(cp.obtenirCoordenadesVista(aux));
             label = new JLabel("ID Planeta: "+ cp.obtenirId(aux)+" Nom Planeta: "+ aux +" Classe Planeta: "+ cp.obtenirClasse(aux)+ " Coords Planeta: "+ cp.obtenirCoordenadesVista(aux));*/
            content.add(label, BorderLayout.NORTH);
            paint(content);
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    
    private void doaltaNecesitat(ActionEvent event){
        try{
            cp.altaNecessitats(text.getText(),text2.getText());
            
            done();
            
            
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    
    private void dobaixaNecesitat(ActionEvent event){
        try{
            cp.baixaNecessitats(text.getText(),text2.getText());
            
            done();
            
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
    }
    
    private void doassignarPaquet(ActionEvent event){
        try{
            cp.assignarPaquet(text.getText(),Integer.parseInt(text2.getText()));
            
            done();
            
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    
    private void dodesassignarPaquet(ActionEvent event){
        try{
            cp.desassignarPaquet(text.getText());
            
            done();
            
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    
    private void doobtenirneed(ActionEvent event){
        try{
            contentSchemaC();
            textarea.setText(cp.obtenirNecessitatsVista(text.getText()));
            
            paint(content);
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    
    private void dorecursosDisponib(ActionEvent event){
        try{
            contentSchemaC();
            textarea.setText(cp.obtenirRecursosDisponiblesVista(text.getText()));
            
            paint(content);
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
    }
    
    private void donomPlaneta(ActionEvent event){
        try{
            cp.modificarNomPlanetaVista(text.getText(),text2.getText());
            String a = cp.llistarPlanetesAssignat();
            String b = cp.llistarPlanetesDesassignat();
            contentSchemaC();
            textarea.setText("Assignats: \n"+ a +"Desassignats: \n"+b);
            paint(content);
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
    }
    
    private void doclassePlaneta(ActionEvent event){
        try{
            if(chinButton.isSelected()){cp.modificarClassePlanetaVista(text.getText(),true);}
            else if(chinButton2.isSelected()){cp.modificarClassePlanetaVista(text.getText(),false);}
            else{
                throw new IllegalArgumentException("Cal Seleccionar el tipus M");
            }
            
            doobtenirPlaneta2(text.getText());
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
    }
    private void docoordPlaneta(ActionEvent event){
        try{
            String[] aux = text2.getText().split(",");
            cp.modificarCoordPlanetaVista(text.getText(),Integer.parseInt(aux[0]),Integer.parseInt(aux[1]));
            doobtenirPlaneta2(text.getText());
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    private void doobtenirPlaneta2(String a){
        try{
            String aux = a;
            contentSchemaB();
            int aux3 = cp.obtenirPaquetPlaneta(aux);
            
            String aux4 = "No te paquet";
            if(aux3 >= 0) aux4 = " " + aux3;
            
            label = new JLabel("ID Planeta: "+ cp.obtenirId(aux)+" Nom Planeta: "+ aux +" Classe Planeta: "+ cp.obtenirClasse(aux)+ " Coords Planeta: "+ cp.obtenirCoordenadesVista(aux) + " Paquet:" + aux4);
            /*System.out.println("HERE");
             System.out.println(cp.obtenirId(aux));
             System.out.println(cp.obtenirClasse(aux));
             System.out.println(cp.obtenirCoordenadesVista(aux));
             label = new JLabel("ID Planeta: "+ cp.obtenirId(aux)+" Nom Planeta: "+ aux +" Classe Planeta: "+ cp.obtenirClasse(aux)+ " Coords Planeta: "+ cp.obtenirCoordenadesVista(aux));*/
            content.add(label, BorderLayout.NORTH);
            paint(content);
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
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
