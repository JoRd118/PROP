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
    public JTextField text3;
    public JScrollPane sp;
    public JScrollPane sp2;
    public JScrollPane sp3;
    public JScrollPane sp4;
    public JScrollPane sp5;
    public JTextArea textarea;
    public JTextArea textarea2;
    public JTextArea textarea3;
    public JTextArea textarea4;
    public JTextArea textarea5;
    public JLabel  label;
    public JLabel  label2;
    public JLabel  label_Exe;
    public JButton b;
    public JCheckBox chinButton;
    public JCheckBox chinButton2;
    
    public abstract void paint(JPanel p);
    
    //Entrada text box + button de confirmació.
    public void contentSchemaA(){
        content = new JPanel();
        text = new JTextField();
        label = new JLabel();
        label_Exe = new JLabel();
        b = new JButton("OK");
        content.setLayout( new GridLayout(4, 2, 5, 5) );
        content.setPreferredSize( new Dimension( 400, 100 ) );
        content.setMinimumSize( new Dimension( 100, 50 ) );
        content.add(label);
        content.add(text);
        content.add(b);
        content.add(label_Exe);
    }
    
    //Sortida resultats en una label.
    public void contentSchemaB(){
        content = new JPanel();
        
        content.setLayout(new GridLayout(6, 2, 5, 5));
        content.setPreferredSize( new Dimension( 400, 100 ) );
        content.setMinimumSize( new Dimension( 100, 50 ) );
        
        
    }
    //llistat + scroll
    public void contentSchemaC(){
        content = new JPanel();
        label_Exe = new JLabel();
        content.setLayout(new GridLayout(6, 2, 5, 5));
        content.setPreferredSize( new Dimension( 400, 100 ) );
        content.setMinimumSize( new Dimension( 100, 50 ) );
        
        textarea = new JTextArea(30,50);
        sp = new JScrollPane(textarea);
        content = new JPanel();
        content.add(sp);
        content.add(label_Exe);
    }
    
    ////Entrada text box(x2) + button de confirmació.
    public void contentSchemaD(){
        
        content = new JPanel();
        text = new JTextField();
        text2 = new JTextField();
        label = new JLabel();
        label2 = new JLabel();
        label_Exe = new JLabel();
        b = new JButton("OK");
        content.setLayout( new GridLayout(7, 2, 5, 5) );
        content.setPreferredSize( new Dimension( 400, 100 ) );
        content.setMinimumSize( new Dimension( 100, 50 ) );
        content.add(label);
        content.add(text);
        content.add(label2);
        content.add(text2);
        content.add(b);
        content.add(label_Exe);
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
        label_Exe = new JLabel();
        label = new JLabel("OP:AltaPlaneta  Nom Planeta:");
        label2 = new JLabel("Coordenades: X,Y");
        b = new JButton("OK");
        content.setLayout( new GridLayout(9, 2, 5, 5) );
        content.setPreferredSize( new Dimension( 400, 100 ) );
        content.setMinimumSize( new Dimension( 100, 50 ) );
        content.add(label);
        content.add(text);
        content.add(label2);
        content.add(text2);
        content.add(chinButton);
        content.add(chinButton2);
        content.add(b);
        content.add(label_Exe);
        
        
        
    }
    //TextBox(x3) + button
    public void contentSchemaF(){
        
        content = new JPanel();
        text = new JTextField();
        text2 = new JTextField();
        text3 = new JTextField();
        label_Exe = new JLabel();
        label = new JLabel("OP:Modificar Valor:");
        label2 = new JLabel("Posició: i,j");
        b = new JButton("OK");
        content.setLayout( new GridLayout(7, 2, 5, 5) );
        content.setPreferredSize( new Dimension( 400, 100 ) );
        content.setMinimumSize( new Dimension( 100, 50 ) );
        content.add(label);
        content.add(text);
        content.add(label2);
        content.add(text2);
        content.add(text3);
        content.add(b);
        content.add(label_Exe);
        
    }
    
    public void contentSchemaG(){
        
        content = new JPanel();
        textarea = new JTextArea();
        textarea2 = new JTextArea();
        textarea3 = new JTextArea();
        textarea4 = new JTextArea();
        textarea5 = new JTextArea();
        label_Exe = new JLabel();
        sp = new JScrollPane(textarea);
        sp2 = new JScrollPane(textarea2);
        sp3 = new JScrollPane(textarea3);
        sp4 = new JScrollPane(textarea4);
        sp5 = new JScrollPane(textarea5);
        label = new JLabel("OP:InseriMatrius MatDistancies, MatNececitats, MatRecursos, VecPlanetes, VecRecursos:");
        b = new JButton("OK");
        content.setLayout( new GridLayout(8, 2, 5, 5) );
        content.setPreferredSize( new Dimension( 400, 100 ) );
        content.setMinimumSize( new Dimension( 100, 50 ) );
        content.add(label);
        content.add(sp);
        content.add(sp2);
        content.add(sp3);
        content.add(sp4);
        content.add(sp5);
        content.add(b);
        content.add(label_Exe);
        
    }
    
}
