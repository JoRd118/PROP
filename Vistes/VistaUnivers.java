import java.io.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @param args the command line arguments
 */
public class VistaUnivers extends Vista{
    
    private static Controlador_Domini_Univers cu;
    private static JPanel univers;
    private VistaGlobal v;


   // private JButton buttonUniversOP8 = new JButton("<Down>ModificarNom");

    private JButton buttonUniversOP1 = new JButton("NumPlanetes");    
    private JButton buttonUniversOP2 = new JButton("AfegirPlaneta");
    private JButton buttonUniversOP3 = new JButton("DesafegirPlaneta");
    private JButton buttonUniversOP4 = new JButton("VectorPlanetes");
    private JButton buttonUniversOP5 = new JButton("MatriuDistanciaPlanetes");
    private JButton buttonUniversOP6 = new JButton("MatriuNecessitatsPlanetes");
    private JButton buttonUniversOP7 = new JButton("MatriuRecursosPlanetes");  
    
    
    

    
    public VistaUnivers (){
        v = super.getF();
        createVistaUnivers();
    }
    
    public VistaUnivers(Controlador_Domini_Univers a){
        v = super.getF();
        cu = a;
        createVistaUnivers();
        
    }
    
    public void createVistaUnivers(){
        univers = new JPanel();
        univers.setLayout(new GridLayout(3, 2, 5, 5));
        univers.add(buttonAlta = new JButton("AltaUnivers"));
        //univers.add(buttonBaixa = new JButton("BaixaUnivers"));
        univers.add(buttonObtenirID = new JButton("ObtenirID"));
        univers.add(buttonllistat = new JButton("Llistar"));
        univers.add(buttonUniversOP1);
        univers.add(buttonUniversOP2);
        univers.add(buttonUniversOP3);
        univers.add(buttonUniversOP4);
        univers.add(buttonUniversOP5);
        univers.add(buttonUniversOP6);
        univers.add(buttonUniversOP7);
        univers.add(buttonGuardar = new JButton("Guardar"));
        univers.add(buttonCarregar = new JButton("Carregar"));
        
        assignar_actionListeners();
        
    }

    public JPanel construct(){
        return univers;
    }

    private void assignar_actionListeners(){
        //Alta
        buttonAlta.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                altaUnivers(event);
            }
        });
        /*
        buttonBaixa.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                baixaUnivers(event);
            }
        });
         */
        /*
        buttonUniversOP3.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                modificarNom(event);
            }
        });*/
        //ObtenirID
        buttonObtenirID.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirId(event);
            }
        });
        //llistat
        buttonllistat.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                llistatUniversos(event);
            }
        });
        //NumPlanetesUnivers
        buttonUniversOP1.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                numPlanetes(event);
            }
        });
        //afegirPlaneta
        buttonUniversOP2.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                afegirPlaneta(event);
            }
        });
        //desafegirPlaneta
        buttonUniversOP3.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                desafegirPlaneta(event);
            }
        });
        //vectorPlanetes
        buttonUniversOP4.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                vectorPlanetes(event);
            }
        });
        //Mat Distancies
        buttonUniversOP5.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                matriuDistanciaPlanetes(event);
            }
        });
        //Mat Necesitats
        buttonUniversOP6.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                matriuNecessitatsPlanetes(event);
            }
        });
        //Mat Recursos 
        buttonUniversOP7.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                matriusRecursosPlanetes(event);
            }
        });
        //Guardar
        buttonGuardar.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                guardar(event);
            }
        });
        //Carregar
        buttonCarregar.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                carregar(event);
            }
        });
    }

    private void altaUnivers(ActionEvent event){
        contentSchemaA();
        label = new JLabel("OP:AltaUnivers  Nom Univers:");
        content.add(label, BorderLayout.NORTH );
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doaltaUnivers(event);
            }
        });
        
        paint(content);

    }

    private void baixaUnivers(ActionEvent event){
        label = new JLabel("OP:BaixaUnivers  Nom Univers:");
        contentSchemaA();
        content.add(label, BorderLayout.NORTH );
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                dobaixaUnivers(event);
            }
        });
        
        paint(content);

    }
    
    private void obtenirId(ActionEvent event){
        label = new JLabel("OP:ObtenirIdUnivers  Nom Univers:");
        contentSchemaA();
        content.add(label, BorderLayout.NORTH );
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doobtenirIdUnivers(event);
            }
        });
        
        paint(content);

    }

    private void llistatUniversos(ActionEvent event){
        try{
            contentSchemaC();
            textarea.setText(cu.llistatUnivers());
            paint(content);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }

    }

    private void numPlanetes(ActionEvent event){
        label = new JLabel("OP:ObtenirNumPlanetesUnivers  Nom Univers:");
        contentSchemaA();
        content.add(label, BorderLayout.NORTH );

        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doobtenirNumPlanetes(event);
            }
        });
        
        paint(content);
    }

    private void afegirPlaneta(ActionEvent event){
        label = new JLabel("OP:Assignar Univers-Planeta  Nom Univers:");
        label2 = new JLabel("Nom Planeta:");
        contentSchemaD();
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doassignarPlaneta(event);
            }
        });
        paint(content);
    }

    private void desafegirPlaneta(ActionEvent event){
        label = new JLabel("OP:Assignar Univers-Planeta  Nom Univers:");
        label2 = new JLabel("Nom Planeta:");
        contentSchemaD();
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                dodesassignarPlaneta(event);
            }
        });
        paint(content);
    }

    private void vectorPlanetes(ActionEvent event){
        label = new JLabel("OP:ObtenirPlanetesUnivers  Nom Univers:");
        contentSchemaA();
        content.add(label, BorderLayout.NORTH );

        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doobtenirPlanetes(event);
            }
        });
        
        paint(content);
    }

    private void matriuDistanciaPlanetes(ActionEvent event){
        label = new JLabel("OP:ObtenirDistanciaPlanetes Nom Univers:");
        contentSchemaA();
        content.add(label, BorderLayout.NORTH );

        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doobtenirDistanciaPlanetes(event);
            }
        });
        
        paint(content);
    }

    private void matriuNecessitatsPlanetes(ActionEvent event){
        label = new JLabel("OP:ObtenirNecessitatsPlanetes Nom Univers:");
        contentSchemaA();
        content.add(label, BorderLayout.NORTH );

        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doobtenirNecessitatsPlanetes(event);
            }
        });
        
        paint(content);

    }

    private void matriusRecursosPlanetes(ActionEvent event){
        label = new JLabel("OP:ObtenirRecursosPlanetes  Nom Univers:");
        contentSchemaA();
        content.add(label, BorderLayout.NORTH );

        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doobtenirRecursosPlanetes(event);
            }
        });
        
        paint(content);

    }

    private void guardar(ActionEvent event){
        label = new JLabel("OP:Guardar - ABSOLUTE PATH - :");
        contentSchemaA();
        
        content.add(label, BorderLayout.NORTH );
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doguardarUnivers(event);
            }
        });
        
        paint(content);

    }

    private void carregar(ActionEvent event){
        label = new JLabel("OP:Carregar - ABSOLUTE PATH - :");
        contentSchemaA();

        content.add(label, BorderLayout.NORTH );
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                docarregarUnivers(event);
            }
        });
        
        paint(content);


    }
    public void paint(JPanel p){
        v.revalidatepanel3(p);
    }





    private void doaltaUnivers(ActionEvent event){
        try{
            cu.altaUnivers(text.getText());
            
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
    private void dobaixaUnivers(ActionEvent event){
        try{
            cu.baixaUnivers(text.getText());
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

    private void doobtenirIdUnivers(ActionEvent event){
        try{
            String aux = text.getText();
            contentSchemaB();
            label = new JLabel("Nom Univers: "+ aux + "  Id: " + cu.obtenirIdUnivers(aux));
            content.add(label, BorderLayout.NORTH );
            paint(content);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }        
    }

    private void doobtenirNumPlanetes(ActionEvent event){
        try{
            String aux = text.getText();
            contentSchemaB();
            label = new JLabel("Nom Univers: "+ aux + "  Conte: " + cu.numPlanetesUnivers(aux) + " Planetes");
            content.add(label, BorderLayout.NORTH );
            paint(content);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }        
    }

    private void doassignarPlaneta(ActionEvent event){
        try{
            cu.afegirPlanetaUnivers(text.getText(),text2.getText());
        
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

    private void dodesassignarPlaneta(ActionEvent event){
        try{
            cu.desafegirPlanetaUnivers(text.getText(),text2.getText());
        
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

    private void doobtenirPlanetes(ActionEvent event){
        try{
            String aux = text.getText();
            contentSchemaC();
            textarea.setText(cu.numPlanetesUnivers2(aux));
            paint(content);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }        
    }

    private void doobtenirDistanciaPlanetes(ActionEvent event){
        try{
            String aux = text.getText();
            contentSchemaC();
            textarea.setText(cu.matriuDistanciaPlanetes2(aux));
            paint(content);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }        
    }

    private void doobtenirNecessitatsPlanetes(ActionEvent event){
        try{
            String aux = text.getText();
            contentSchemaC();
            textarea.setText(cu.matriuNecesitatsPlanetes2(aux));
            paint(content);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }        
    }

    private void doobtenirRecursosPlanetes(ActionEvent event){
        try{
            String aux = text.getText();
            contentSchemaC();
            textarea.setText(cu.matriuRecursosPlanetes2(aux));
            paint(content);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }        
    }

    private void doguardarUnivers(ActionEvent event){
        try{
            cu.guardarUniversos(text.getText());
            
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
    
    private void docarregarUnivers(ActionEvent event){
        try{
            cu.carregarUniversos(text.getText());
            
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
    
    
}
