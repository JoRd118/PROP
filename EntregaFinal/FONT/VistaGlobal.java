import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VistaGlobal extends JFrame {
    
    private     JSplitPane  splitPaneV;
    private     JSplitPane  splitPaneH;
    private     JPanel      panel1;
    private     JPanel      panel2;
    private     JPanel      panel3;
    private     JPanel      panel4;
    
    
    private JButton buttonRecurs = new JButton("Recurs");
    private JButton buttonPaquet = new JButton("Paquet");
    private JButton buttonPlaneta = new JButton("Planeta");
    private JButton buttonUnivers = new JButton("Univers");
    private JButton buttonQAP = new JButton("QAP");
    private JButton buttonSave = new JButton("GuardarTot");
    
    
    public VistaGlobal(){
        
        setTitle( "aPROPvens" );
        setBackground( Color.gray );
        
        JPanel topPanel = new JPanel();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );
        
        // Create the panels
        createPanel1();
        createPanel2();
        createPanel3();
        createPanel4();
        
        // Create a splitter pane
        splitPaneV = new JSplitPane( JSplitPane.VERTICAL_SPLIT );
        topPanel.add( splitPaneV, BorderLayout.CENTER );
        
        splitPaneH = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
        splitPaneH.setLeftComponent( panel1 );
        splitPaneH.setRightComponent( panel2 );

        
        splitPaneV.setLeftComponent( splitPaneH );
        splitPaneV.setRightComponent( panel3 );
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        
        SubVista sv = new SubVista(this);
    }
    
    public void createPanel1(){
        panel1 = new JPanel();
        panel1.setLayout( new GridLayout(6, 1, 5, 5) );
        /*
         JPanel panel = ...;
         JScrollPane scroll = new JScrollPane(panel);
         frame.add(scroll, ...);
         panel1.setLayout( new BorderLayout() );
         */
        // Add some buttons
        panel1.add(buttonRecurs );
        panel1.add(buttonPaquet);
        panel1.add(buttonPlaneta);
        panel1.add(buttonUnivers);
        panel1.add(buttonQAP);
        panel1.add(buttonSave);
        
        assignar_actionListeners();
        
    }
    
    public void createPanel2(){
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3, 2, 5, 5));// 3 rows, 2 col, 5 pixel gap
        
        panel2.add(new JLabel( "<- Escull una opcio" ));
        //panel2.add( new JButton( "Button 1" ) );
        //panel2.add( new JButton( "Button 2" ) );
        //panel2.add( new JButton( "Button 3" ) );
    }
    
    public void createPanel3(){
        panel3 = new JPanel();
        panel3.setLayout( new GridLayout(15, 2, 5, 5) );
        panel3.setPreferredSize( new Dimension( 400, 100 ) );
        panel3.setMinimumSize( new Dimension( 100, 50 ) );
        
        panel3.add( new JLabel( "Welcome to Tatooine." ));
        panel3.add( new JLabel( "Authors: Oriol Burgaya Verdager,Claudi Cervelló Nogués, Jordi Farran Centelles, Jordi Viella Guardia." ));
        panel3.add( new JLabel( "Have fun, and please you do not try to crash this app." ));
        //panel3.add( new JTextArea(), BorderLayout.CENTER );
    }
    
    public void createPanel4(){
        panel4 = new JPanel();
        panel4.setBackground(Color.white);
        panel4.setPreferredSize( new Dimension( 5, 5 ) );
        panel3.setMaximumSize( new Dimension( 1, 1 ) );
    
    }
    
    
    
    //Assignacions actionListeners
    private void assignar_actionListeners(){
        
        buttonRecurs.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                buttonRecursListener(event);
            }
        });
        
        buttonPaquet.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                buttonPaquetListener(event);
            }
        });
        
        buttonPlaneta.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                buttonPlanetaListener(event);
            }
        });
        
        buttonUnivers.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                buttonUniversListener(event);
            }
        });
        
        buttonQAP.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                buttonQAPListener(event);
            }
        });
        
        buttonSave.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                buttonSaveListener(event);
            }
        });
    }
    
    
    
    
    //Listeners
    private void buttonRecursListener(ActionEvent event){
        VistaRecurs vr = new VistaRecurs();
        JPanel p = vr.construct();
        revalidatepanel2(p);
    }
    
    private void buttonPaquetListener( ActionEvent event){
        VistaPaquet vp = new VistaPaquet();
        JPanel p = vp.construct();
        revalidatepanel2(p);
    }
    
    private void buttonPlanetaListener(ActionEvent event){
        VistaPlaneta vp = new VistaPlaneta();
        JPanel p = vp.construct();
        revalidatepanel2(p);
    }
    
    private void buttonUniversListener(ActionEvent event){
        VistaUnivers vu = new VistaUnivers();
        JPanel p = vu.construct();
        revalidatepanel2(p);
    }
    
    private void buttonQAPListener(ActionEvent event){
        VistaQAP vq = new VistaQAP();
        JPanel p = vq.construct();
        revalidatepanel2(p);
        
    }
    
    private void buttonSaveListener(ActionEvent event){
        VistaSave vs = new VistaSave();
        JPanel p = vs.construct();
        revalidatepanel2(p);
        vs.instruccions();
        p = vs.construct();
        revalidatepanel3(p);
        
    }
    
    
    
    
    
    //revalidates
    public void revalidatepanel2(JPanel p){
        panel2 = p;
        splitPaneH.setRightComponent( panel2 );
        panel2.revalidate();
    }
    public void revalidatepanel3(JPanel p){
        panel3 = p;
        splitPaneV.setRightComponent( panel3 );
        panel3.revalidate();
    }
    
    public void revalidatepanel4(JPanel p){
        panel4 = p;
        splitPaneV.setBottomComponent(panel4);
        panel4.revalidate();
    }
    
}

