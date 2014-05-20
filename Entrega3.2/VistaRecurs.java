import java.io.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @param args the command line arguments
 */
public class VistaRecurs extends SubVista{
    
    private static Controlador_Domini_Recurs cr;
    private static JPanel recurs;
    private VistaGlobal v;
    private JButton buttonRecursOP1 = new JButton("AltaRecurs");
    private JButton buttonRecursOP2 = new JButton("BaixaRecurs");
    private JButton buttonRecursOP3 = new JButton("ModificarNom");
    private JButton buttonRecursOP4 = new JButton("ObtenirRecurs");
    private JButton buttonRecursOP5 = new JButton("ObtenirID");
    private JButton buttonRecursOP6 = new JButton("ObtenirNom");
    private JButton buttonRecursOP7 = new JButton("LlistatRecurs");
    private JButton buttonRecursOP8 = new JButton("NumRecursos");
    private JButton buttonRecursOP9 = new JButton("Guardar");
    private JButton buttonRecursOP10 = new JButton("Carregar");
    
    
    
    //Content Tools
    private static JPanel  content;
    private JTextField text;
    private JScrollPane sp;
    private JTextArea textarea;
    private JLabel  label;
    private JButton b;
    
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
        recurs.add(buttonRecursOP1);
        recurs.add(buttonRecursOP2);
        recurs.add(buttonRecursOP3);
        recurs.add(buttonRecursOP4);
        recurs.add(buttonRecursOP5);
        recurs.add(buttonRecursOP6);
        recurs.add(buttonRecursOP7);
        recurs.add(buttonRecursOP8);
        recurs.add(buttonRecursOP9);
        recurs.add(buttonRecursOP10);
        
        
        assignar_actionListeners();
        
    }
    
    public JPanel construct(){
        return recurs;
    }
    
    private void assignar_actionListeners(){
        buttonRecursOP1.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                altaRecurs(event);
            }
        });
        
        buttonRecursOP2.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                baixaRecurs(event);
            }
        });
        
        buttonRecursOP3.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                modificarNom(event);
            }
        });
        
        buttonRecursOP4.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirRecurs(event);
            }
        });
        
        buttonRecursOP5.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirId(event);
            }
        });
        
        buttonRecursOP6.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirNom(event);
            }
        });
        
        buttonRecursOP7.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                llistatRecurs(event);
            }
        });
        
        buttonRecursOP8.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                numRecursos(event);
            }
        });
        
        buttonRecursOP9.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                guardar(event);
            }
        });
        
        buttonRecursOP10.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                carregar(event);
            }
        });
        
        
        
        
        
    }
    
    
    
    private void altaRecurs(ActionEvent event){
        content = new JPanel();
        text = new JTextField();
        label = new JLabel("Nom Recurs:");
        b = new JButton("OK");
        content.setLayout( new BorderLayout() );
        content.setPreferredSize( new Dimension( 400, 100 ) );
        content.setMinimumSize( new Dimension( 100, 50 ) );
        content.add(label, BorderLayout.NORTH );
        content.add(text, BorderLayout.CENTER );
        content.add(b, BorderLayout.EAST);
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doaltaRecurs(event);
            }
        });
        
        paint(content);
    }
    
    
    private void baixaRecurs(ActionEvent event){
        content = new JPanel();
        text = new JTextField();
        label = new JLabel("Nom Recurs:");
        b = new JButton("OK");
        content.setLayout( new BorderLayout() );
        content.setPreferredSize( new Dimension( 400, 100 ) );
        content.setMinimumSize( new Dimension( 100, 50 ) );
        content.add(label, BorderLayout.NORTH );
        content.add(text, BorderLayout.CENTER );
        content.add(b, BorderLayout.EAST);
        
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
        
        
    }
    
    private void obtenirId(ActionEvent event){
        
        
    }
    
    private void obtenirNom(ActionEvent event){
        
        
    }
    
    private void llistatRecurs(ActionEvent event){
        textarea = new JTextArea();
        sp = new JScrollPane(textarea);
        content = new JPanel();
        textarea.setText(cr.llistatRecurs());
        content.add(sp, BorderLayout.CENTER);
        paint(content);
        
        
    }
    
    private void numRecursos(ActionEvent event){
        
        
    }
    
    private void guardar(ActionEvent event){
        
        
    }
    
    private void carregar(ActionEvent event){
        
        
    }
    
    
    private void doaltaRecurs(ActionEvent event){
        cr.altaRecurs(text.getText());
        
        
        content = new JPanel();
        label = new JLabel("Fet.");
        content.setLayout( new BorderLayout() );
        content.setPreferredSize( new Dimension( 400, 100 ) );
        content.setMinimumSize( new Dimension( 100, 50 ) );
        content.add(label, BorderLayout.NORTH );
        paint(content);
        
        
    }
    
    private void dobaixaRecurs(ActionEvent event){
        cr.baixaRecurs(text.getText());
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
