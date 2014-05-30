import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @param args the command line arguments
 */
public abstract class Vista extends SubVista{
    
    //Common Menu
    public JButton buttonAlta;
    public JButton buttonBaixa;
    public JButton buttonllistat;
    public JButton buttonCarregar;
    public JButton buttonGuardar;
    public JButton buttonObtenir;
    public JButton buttonObtenirID;
    public JButton buttonModNom;
    
    //Common Content
    public JPanel  content;
    public JTextField text;
    public JTextField text2;
    public JScrollPane sp;
    public JTextArea textarea;
    public JLabel  label;
    public JLabel  label2;
    public JButton b;
    public JCheckBox chinButton;
    public JCheckBox chinButton2;
    
    public abstract void paint(JPanel p);
    
    //Entrada text box + button de confirmació.
    public void contentSchemaA(){
        content = new JPanel();
        text = new JTextField();
        b = new JButton("OK");
        content.setLayout( new BorderLayout() );
        content.setPreferredSize( new Dimension( 400, 100 ) );
        content.setMinimumSize( new Dimension( 100, 50 ) );
        
        content.add(text, BorderLayout.CENTER );
        content.add(b, BorderLayout.EAST);
    }
    
    //Sortida resultats en una label.
    public void contentSchemaB(){
        content = new JPanel();
        
        content.setLayout( new BorderLayout() );
        content.setPreferredSize( new Dimension( 400, 100 ) );
        content.setMinimumSize( new Dimension( 100, 50 ) );
        
    }
    //llistat + scroll
    public void contentSchemaC(){
        content = new JPanel();
        
        content.setLayout( new BorderLayout() );
        content.setPreferredSize( new Dimension( 400, 100 ) );
        content.setMinimumSize( new Dimension( 100, 50 ) );
        
        textarea = new JTextArea(10,50);
        sp = new JScrollPane(textarea);
        content = new JPanel();
        content.add(sp, BorderLayout.CENTER);
    }
    
    ////Entrada text box(x2) + button de confirmació.
    public void contentSchemaD(){

        content = new JPanel();
        text = new JTextField();
        text2 = new JTextField();
        b = new JButton("OK");
        content.setLayout( new GridLayout(6, 2, 5, 5) );
        content.setPreferredSize( new Dimension( 400, 100 ) );
        content.setMinimumSize( new Dimension( 100, 50 ) );
        content.add(label);
        content.add(text);
        content.add(label2);
        content.add(text2);
        content.add(b);
    }
    
    public void contentSchemaE(){
        chinButton = new JCheckBox("Planeta Tipus M");
        chinButton.setMnemonic(KeyEvent.VK_C);
        chinButton.setSelected(false);
        
        chinButton2 = new JCheckBox(" NO Planeta Tipus M");
        chinButton2.setMnemonic(KeyEvent.VK_C);
        chinButton2.setSelected(false);
        
        content = new JPanel();
        text = new JTextField();
        text2 = new JTextField();
        label = new JLabel("OP:AltaPlaneta  Nom Planeta:");
        label2 = new JLabel("Coordenades: X,Y");
        b = new JButton("OK");
        content.setLayout( new GridLayout(6, 2, 5, 5) );
        content.setPreferredSize( new Dimension( 400, 100 ) );
        content.setMinimumSize( new Dimension( 100, 50 ) );
        content.add(label);
        content.add(text);
        content.add(label2);
        content.add(text2);
        content.add(chinButton);
        content.add(chinButton2);
        content.add(b);
    
    
    }
    
    
}
