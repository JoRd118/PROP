import java.io.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @param args the command line arguments
 */
public class VistaRecurs extends Vista{
    
    private static Controlador_Domini_Recurs cr;
    private static JPanel recurs;
    private VistaGlobal v;
    
    private JButton buttonRecursOP1 = new JButton("ModificarNom");
    private JButton buttonRecursOP2 = new JButton("NumRecursos");
    
    
    //Content Tools
    
    
    public VistaRecurs (){
        v = super.getF();
        createVistaRecurs();
    }
    
    public VistaRecurs(Controlador_Domini_Recurs a){
        v = super.getF();
        cr = a;
        createVistaRecurs();
        
    }
    
    public void createVistaRecurs(){
        recurs = new JPanel();
        recurs.setLayout(new GridLayout(3, 2, 5, 5));
        recurs.add(buttonAlta = new JButton("AltaRecurs"));
        recurs.add(buttonBaixa = new JButton("BaixaRecurs"));
        recurs.add(buttonRecursOP1);
        recurs.add(buttonObtenir = new JButton("ObtenirRecurs"));
        recurs.add(buttonObtenirID = new JButton("ObtenirID"));
        recurs.add(buttonllistat = new JButton("Llistar"));
        recurs.add(buttonRecursOP2);
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
        
        buttonBaixa.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                baixaRecurs(event);
            }
        });
        
        buttonRecursOP1.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                modificarNom(event);
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
        
        
        
        
        
    }
    
    
    
    private void altaRecurs(ActionEvent event){
        contentSchemaA();
        label = new JLabel("OP:AltaRecurs  Nom Recurs:");
        content.add(label, BorderLayout.NORTH );
        
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
    
    private void modificarNom(ActionEvent event){
        
        
    }
    
    private void obtenirRecurs(ActionEvent event){
        contentSchemaA();
        label = new JLabel("OP:BaixaRecurs  Nom Recurs:");
        content.add(label, BorderLayout.NORTH );
        
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
        label = new JLabel("OP:ObtenirIdRecurs  Nom Recurs:");
        content.add(label, BorderLayout.NORTH );
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doobtenirIdRecurs(event);
            }
        });
        
        paint(content);
        
    }
    
    private void llistatRecurs(ActionEvent event){
        contentSchemaC();
        textarea.setText(cr.llistatRecurs());
        paint(content);
        
    }
    
    private void numRecursos(ActionEvent event){
        
        
    }
    
    private void guardar(ActionEvent event){
        
        
    }
    
    private void carregar(ActionEvent event){
        
        
    }
    
    
    private void doaltaRecurs(ActionEvent event){
        try{
            cr.altaRecurs(text.getText());
            
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
    
    private void dobaixaRecurs(ActionEvent event){
        try{
            cr.baixaRecurs(text.getText());
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
    
    private void doobtenirRecurs(ActionEvent event){
        try{
            String aux = text.getText();
            contentSchemaB();
            label = new JLabel("Nom Recurs: "+ cr.obtenirNom(cr.obtenirRecurs(aux)) + "  Id: " + cr.obtenirId(cr.obtenirNom(cr.obtenirRecurs(aux))));
            content.add(label, BorderLayout.NORTH );
            paint(content);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
    }
    
    private void doobtenirIdRecurs(ActionEvent event){
        try{
            String aux = text.getText();
            contentSchemaB();
            label = new JLabel("Nom Recurs: "+ cr.obtenirNom(cr.obtenirRecurs(aux)) + "  Id: " + cr.obtenirId(cr.obtenirNom(cr.obtenirRecurs(aux))));
            content.add(label, BorderLayout.NORTH );
            paint(content);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Exception: " + ex.getMessage());
        }
        
    }
    
    
    public void paint(JPanel p){
        v.revalidatepanel3(p);
    }
    
    
}
