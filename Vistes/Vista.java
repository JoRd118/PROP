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
    
    //Common Content
    public JPanel  content;
    public JTextField text;
    public JScrollPane sp;
    public JTextArea textarea;
    public JLabel  label;
    public JButton b;
    
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
}
