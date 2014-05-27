import java.io.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @param args the command line arguments
 */
public class VistaMod extends Vista{
    
    private static Controlador_Domini_Univers cu;
    private static JPanel mod;
    private VistaGlobal v;
    
    
    private JButton buttonModOP1 = new JButton("BaixaUnivers");
    private JButton buttonModOP2 = new JButton("BaixaPlaneta");
    private JButton buttonModOP3 = new JButton("BaixaPaquet");
    private JButton buttonModOP4 = new JButton("BaixaRecurs");
    private JButton buttonModOP5 = new JButton("Mod Nom Univers");
    private JButton buttonModOP6 = new JButton("Mod Nom Planeta");
    private JButton buttonModOP7 = new JButton("Mod Coord Planeta");
    private JButton buttonModOP8 = new JButton("Mod Classe Planeta");
    private JButton buttonModOP9 = new JButton("Mod Nom Recurs");
    
    
    
    public VistaMod (){
        v = super.getF();
        createVistaMod();
    }
    
    public VistaMod(Controlador_Domini_Univers a){
        v = super.getF();
        cu = a;
        createVistaMod();
        
    }
    
    public void createVistaMod(){
        mod = new JPanel();
        mod.setLayout(new GridLayout(3, 2, 5, 5));
        
        mod.add(buttonModOP1);
        mod.add(buttonModOP2);
        mod.add(buttonModOP3);
        mod.add(buttonModOP4);
        mod.add(buttonModOP5);
        mod.add(buttonModOP6);
        mod.add(buttonModOP7);
        mod.add(buttonModOP8);
        mod.add(buttonModOP9);
        assignar_actionListeners();
        
    }
    
    public JPanel construct(){
        return mod;
    }
    
    private void assignar_actionListeners(){
        
        buttonModOP1.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                baixaUnivers(event);
            }
        });
        
        buttonModOP2.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                baixaPlaneta(event);
            }
        });
        
        buttonModOP3.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                baixaPaquet(event);
            }
        });
        
        buttonModOP4.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                baixaRecurs(event);
            }
        });
        
        buttonModOP5.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                nomUnivers(event);
            }
        });
        
        buttonModOP6.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                nomPlaneta(event);
            }
        });
        
        buttonModOP7.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                coordPlaneta(event);
            }
        });
        
        buttonModOP8.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                classePlaneta(event);
            }
        });
        
        buttonModOP9.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                nomRecurs(event);
            }
        });
    }
    
    private void baixaUnivers(ActionEvent event){
        contentSchemaA();
        label = new JLabel("OP:BaixaUnivers  Nom Univers:");
        content.add(label, BorderLayout.NORTH );
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                dobaixaUnivers(event);
            }
        });
        
        paint(content);
        
    }
    
    private void baixaPlaneta(ActionEvent event){
        contentSchemaA();
        label = new JLabel("OP:BaixaPlaneta  Nom Planeta:");
        content.add(label, BorderLayout.NORTH );
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                dobaixaPlaneta(event);
            }
        });
        
        paint(content);
        
    }
    
    private void baixaPaquet(ActionEvent event){
        contentSchemaA();
        label = new JLabel("OP:BaixaPaquet  Nom Paquet:");
        content.add(label, BorderLayout.NORTH );
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                dobaixaPaquet(event);
            }
        });
        
        paint(content);
        
    }
    
    private void baixaRecurs(ActionEvent event){
        contentSchemaA();
        label = new JLabel("OP:BaixaRecurs  Nom Recurs:");
        content.add(label, BorderLayout.NORTH );
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                dobaixaRecurs(event);
            }
        });
        
        paint(content);
        
        
    }
    
    private void nomUnivers(ActionEvent event){
        label = new JLabel("OP:Mod Nom Univers  Nom Univers:");
        label2 = new JLabel("New Nom:");
        contentSchemaD();
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                donomUnivers(event);
            }
        });
        paint(content);
        
    }
    
    private void nomPlaneta(ActionEvent event){
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
    
    private void classePlaneta(ActionEvent event){
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
    
    private void coordPlaneta(ActionEvent event){
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
    
    private void nomRecurs(ActionEvent event){
        label = new JLabel("OP:Mod Nom Recurs  Nom Recurs:");
        label2 = new JLabel("new Nom:");
        contentSchemaD();
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                donomRecurs(event);
            }
        });
        paint(content);
    }
    //do-functions
    
    private void dobaixaUnivers(ActionEvent event){
        try{
            cu.baixaUnivers(text.getText());
            done();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
    }
    
    private void dobaixaPlaneta(ActionEvent event){
        try{
            cu.borrar_planeta(text.getText());
            done();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
    }
    
    private void dobaixaPaquet(ActionEvent event){
        try{
            cu.borrar_paquet(Integer.parseInt(text.getText()));
            done();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
    }
    private void dobaixaRecurs(ActionEvent event){
        try{
            cu.borrar_recurs(text.getText());
            done();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
    }
    private void donomUnivers(ActionEvent event){
        try{
            cu.modificacioNomUnivers(text.getText(),text2.getText());
            done();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
        
    }
    private void donomPlaneta(ActionEvent event){
        try{
            cu.modificar_nom_planeta(text.getText(),text2.getText());
            done();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
    }
    private void doclassePlaneta(ActionEvent event){
        try{
            if(chinButton.isSelected()){cu.modificar_classe_planeta(text.getText(),true);}
            else if(chinButton2.isSelected()){cu.modificar_classe_planeta(text.getText(),false);}
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
            cu.modificar_coordenades_planeta(text.getText(),Integer.parseInt(aux[0]),Integer.parseInt(aux[1]));
            
            System.out.println(Integer.parseInt(aux[0])+Integer.parseInt(aux[1]));
            done();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
        
    }
    private void donomRecurs(ActionEvent event){
        try{
            cu.modificar_nom_recurs(text.getText(),text2.getText());
            done();
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
