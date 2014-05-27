import java.io.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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
        //planeta.add(buttonBaixa = new JButton("BaixaPlaneta"));
        planeta.add(buttonObtenirID = new JButton("ObtenirID"));
        planeta.add(buttonPlanetaOP9);
        planeta.add(buttonPlanetaOP10);
        planeta.add(buttonPlanetaOP11);
        planeta.add(buttonllistat = new JButton("Llistar"));
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
        /*
        buttonBaixa.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                baixaPlaneta(event);
            }
        });
        */
        buttonObtenirID.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirId(event);
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
        contentSchemaA();
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
    
    private void guardar (ActionEvent event){
        label = new JLabel("OP:Guardar - ABSOLUTE PATH - :");
        contentSchemaA();
        content.add(label, BorderLayout.NORTH );
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doguardarPlanetes(event);
            }
        });
        
        paint(content);
        
    }
    
    private void carregar (ActionEvent event){
        label = new JLabel("OP:Carregar - ABSOLUTE PATH - :");
        contentSchemaA();
        content.add(label, BorderLayout.NORTH );
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                docarregarPlaneta(event);
            }
        });
        
        paint(content);
        
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
            cp.baixaPlaneta(text.getText());
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
            label = new JLabel("ID Planeta: "+ cp.obtenirId(aux)+" Nom Planeta: "+ aux +" Classe Planeta: "+ cp.obtenirClasse(aux)+ " Coords Planeta: "+ cp.obtenirCoordenadesVista(aux));
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
            
            textarea.setText(cp.obtenirNecessitatsVista(text.getText()));
            contentSchemaC();
            paint(content);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
        
    }
    
    private void dorecursosDisponib(ActionEvent event){
        try{

            textarea.setText(cp.obtenirRecursosDisponiblesVista(text.getText()));
                        contentSchemaC();
            paint(content);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
    
    
    
    }
    
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
