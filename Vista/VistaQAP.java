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
public class VistaQAP extends Vista{
    
    private static Controlador_Domini_QAP q;
    private static JPanel qap;
    private VistaGlobal v;
    
    private JButton buttonRecursOP10 = new JButton("calcularMatrius");
    private JButton buttonRecursOP1 = new JButton("modificarValorDistancies");
    private JButton buttonRecursOP2 = new JButton("modificarValorNecessitats");
    private JButton buttonRecursOP3 = new JButton("modificarValorRecursos");
    private JButton buttonRecursOP4 = new JButton("obtenirMatDis");
    private JButton buttonRecursOP5 = new JButton("obtenirMatNec");
    private JButton buttonRecursOP6 = new JButton("obtenirMatRec");
    private JButton buttonRecursOP7 = new JButton("obtenirRecu");
    private JButton buttonRecursOP8 = new JButton("obtenirPlanetes");
    private JButton buttonRecursOP9 = new JButton("afegirMatrius");
    private JButton buttonRecursOP11 = new JButton("solucioSeguent");
    private JButton buttonRecursOP12 = new JButton("solucioAnterior");
    private JButton buttonRecursOP13 = new JButton("printTemps");
    private JButton buttonRecursOP14 = new JButton("solucio(TOT)");
    private JButton buttonRecursOP15 = new JButton("run_algorithm");
    private JButton buttonRecursOP16 = new JButton("guardar_solucioQAP");
    
    
    
    
    
    
    
    //Content Tools
    
    
    public VistaQAP (){
        v = super.getF();
        createVistaQAP();
    }
    
    public VistaQAP(Controlador_Domini_QAP a){
        v = super.getF();
        q = a;
        createVistaQAP();
        
    }
    
    public void createVistaQAP(){
        qap = new JPanel();
        qap.setLayout(new GridLayout(3, 2, 5, 5));
        qap.add(buttonRecursOP10);
        qap.add(buttonRecursOP1);
        qap.add(buttonRecursOP2);
        qap.add(buttonRecursOP3);
        qap.add(buttonRecursOP4);
        qap.add(buttonRecursOP5);
        qap.add(buttonRecursOP6);
        qap.add(buttonRecursOP7);
        qap.add(buttonRecursOP8);
        qap.add(buttonRecursOP9);
        qap.add(buttonRecursOP11);
        qap.add(buttonRecursOP12);
        qap.add(buttonRecursOP13);
        qap.add(buttonRecursOP14);
        qap.add(buttonRecursOP15);
        qap.add(buttonRecursOP16);
        
        assignar_actionListeners();
        
    }
    
    public JPanel construct(){
        return qap;
    }
    
    private void assignar_actionListeners(){
        
        buttonRecursOP10.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                calcularMatrius(event);
            }
        });
        
        buttonRecursOP1.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                modificarValorDistancies(event);
            }
        });
        
        buttonRecursOP2.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                modificarValorNecessitats(event);
            }
        });
        
        buttonRecursOP3.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                modificarValorRecursos(event);
            }
        });
        
        buttonRecursOP4.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirMatDis(event);
            }
        });
        
        buttonRecursOP5.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirMatNec(event);
            }
        });
        
        buttonRecursOP6.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirMatRec(event);
            }
        });
        
        buttonRecursOP7.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirRecu(event);
            }
        });
        
        buttonRecursOP8.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirPlanetes(event);
            }
        });
        
        buttonRecursOP9.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                afegirMatrius(event);
            }
        });
        
        buttonRecursOP11.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                solucioSeguent(event);
            }
        });
        
        buttonRecursOP12.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                solucioAnterior(event);
            }
        });
        
        buttonRecursOP13.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                printTemps(event);
            }
        });
        
        buttonRecursOP14.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                solucio(event);
            }
        });
        
        buttonRecursOP15.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                run_algorithm(event);
            }
        });
        
        buttonRecursOP16.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                guardar_solucioQAP(event);
            }
        });
    }
    
    private void calcularMatrius(ActionEvent event){
        
        contentSchemaA();
        label.setText("OP:CalcularMatrius  Nom Univers:");
        
        
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                docalcularMatrius(event);
            }
        });
        
        paint(content);
        
        
    }
    
    private void run_algorithm(ActionEvent event){
        JButton buttonBBL = new JButton("Lazy");
        JButton buttonBBE = new JButton("Eager");
        JButton buttonTabu = new JButton("Tabu");
        content = new JPanel();
        content.add(buttonBBL);
        content.add(buttonBBE);
        content.add(buttonTabu);
        paint(content);
        
        buttonBBL.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                dorun(event, "BBL");
            }
        });
        
        buttonBBE.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                dorun(event, "BBE");
            }
        });
        
        buttonTabu.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                dorun(event, "TABU");
            }
        });
        
        
    }
    
    private void modificarValorDistancies(ActionEvent event){
        contentSchemaF();
        label.setText("OP:modificarValorDistancies Valor:");
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                domodificarValorDistancies(event);
            }
        });
        paint(content);
        
    }
    
    private void modificarValorNecessitats(ActionEvent event){
        contentSchemaF();
        label.setText("OP:modificarValorNecessitats Valor:");
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                domodificarValorNecessitats(event);
            }
        });
        paint(content);
    }
    
    private void modificarValorRecursos(ActionEvent event){
        contentSchemaF();
        label.setText("OP:modificarValorRecursos Valor:");
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                domodificarValorRecursos(event);
            }
        });
        paint(content);
    }
    
    private void obtenirMatDis(ActionEvent event){
        try{
            contentSchemaC();
            textarea.setText(q.obtenirMatDis());
            paint(content);
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
    }
    
    private void obtenirMatNec(ActionEvent event){
        try{
            contentSchemaC();
            textarea.setText(q.obtenirMatNec());
            paint(content);
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    
    private void obtenirMatRec(ActionEvent event){
        try{
            contentSchemaC();
            textarea.setText(q.obtenirMatRec());
            paint(content);
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
    }
    
    private void obtenirRecu(ActionEvent event){
        try{
            contentSchemaC();
            textarea.setText(q.obtenirRecu());
            paint(content);
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    
    private void obtenirPlanetes(ActionEvent event){
        try{
            contentSchemaC();
            textarea.setText(q.obtenirPlan());
            paint(content);
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    
    private void afegirMatrius(ActionEvent event){
        contentSchemaG();
        b.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                doafegirMatrius(event);
            }
        });
        paint(content);
    }
    
    private void solucioSeguent(ActionEvent event){
        try{
            contentSchemaC();
            textarea.setText(q.solucioSeguent());
            paint(content);
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    
    private void solucioAnterior(ActionEvent event){
        try{
            contentSchemaC();
            textarea.setText(q.solucioAnterior());
            paint(content);
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
    }
    
    private void printTemps(ActionEvent event){
        try{
            contentSchemaC();
            textarea.setText(q.printTemps());
            paint(content);
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
    }
    
    private void solucio(ActionEvent event){
        try{
            contentSchemaC();
            textarea.setText(q.solucioAll());
            paint(content);
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
    }
    
    private void guardar_solucioQAP(ActionEvent event){
        try{
            content = new JPanel();
            label_Exe = new JLabel();
            content.add(label_Exe);
            paint(content);
            JFileChooser elegirArchivo = new JFileChooser();
            File archivo = null;
            FileFilter tipo = new FileNameExtensionFilter(".qap", "qap");
            elegirArchivo.addChoosableFileFilter(tipo);
            
            int estado = elegirArchivo.showDialog(null, "Guardar");
            
            if (estado == JFileChooser.APPROVE_OPTION) {
                archivo = elegirArchivo.getSelectedFile();
                String direccion = archivo.toString();
                String direccion_copy = direccion;
                direccion_copy = direccion_copy.substring((direccion_copy.length())-3,direccion_copy.length());
                if(direccion.contains(".")){
                    if(direccion_copy.equals("qap")){
                        q.guardar_solucioQAP(direccion);
                        done();
                    }
                    else{error_ex("Exception: Extencio del fitxer incorrecte (hauria de ser '.qap') ");}
                }
                else{error_ex("Exception: Fitxer sense extenció (hauria de ser '.qap') ");}
                
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
    private void dorun(ActionEvent event, String a){
        try{
            q.run_algorithm(a);
            content = new JPanel();
            label = new JLabel(q.printTemps());
            content.setLayout( new BorderLayout() );
            content.setPreferredSize( new Dimension( 400, 100 ) );
            content.setMinimumSize( new Dimension( 100, 50 ) );
            content.add(label, BorderLayout.NORTH );
            paint(content);
            
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
    }
    
    private void domodificarValorDistancies(ActionEvent event){
        try{
            double valor = Double.parseDouble(text.getText());
            int i = Integer.parseInt(text2.getText());
            int j = Integer.parseInt(text3.getText());
            q.modificarValorDistancies(i,j,valor);
            done();
            
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    
    private void domodificarValorNecessitats(ActionEvent event){
        try{
            int valor = Integer.parseInt(text.getText());
            int i = Integer.parseInt(text2.getText());
            int j = Integer.parseInt(text3.getText());
            q.modificarValorNecessitats(i,j,valor);
            done();
            
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
    }
    
    private void domodificarValorRecursos(ActionEvent event){
        try{
            int valor = Integer.parseInt(text.getText());
            int i = Integer.parseInt(text2.getText());
            int j = Integer.parseInt(text3.getText());
            q.modificarValorRecursos(i,j,valor);
            done();
            
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
    }
    
    private void doafegirMatrius(ActionEvent event){
        try{
            //System.out.println(textarea.getText());
            q.afegirMatrius(textarea.getText(),textarea2.getText(),textarea3.getText(),textarea4.getText(),textarea5.getText());
            done();
            
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
    }
    
    private void docalcularMatrius(ActionEvent event){
        try{
            q.calcularMatrius(text.getText());
            done();
        }
        catch (Exception ex){
            error_ex("Exception: " + ex.getMessage());
        }
        
    }
    
    
    
    
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
