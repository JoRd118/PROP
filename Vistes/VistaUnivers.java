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
    private JButton buttonUniversOP1 = new JButton("Alta");
    private JButton buttonUniversOP2 = new JButton("Baixa");
    private JButton buttonUniversOP3 = new JButton("ModificarNom");
    private JButton buttonUniversOP4 = new JButton("ObtenirId");
    private JButton buttonUniversOP5 = new JButton("LlistatUniversos");
    private JButton buttonUniversOP6 = new JButton("NumPlanetes");
    private JButton buttonUniversOP7 = new JButton("AfegirPlaneta");
    private JButton buttonUniversOP8 = new JButton("DesafegirPlaneta");
    private JButton buttonUniversOP9 = new JButton("VectorPlanetes");
    private JButton buttonUniversOP10 = new JButton("MatriuDistanciaPlanetes");
    private JButton buttonUniversOP11 = new JButton("MatriuNecessitatsPlanetes");
    private JButton buttonUniversOP12 = new JButton("MatriuRecursosPlanetes");
    private JButton buttonUniversOP13 = new JButton("Guardar");
    private JButton buttonUniversOP14 = new JButton("Carregar");   
    
    
    
    
    //Content Tools
    private static JPanel  content;
    private JTextField text;
    private JLabel  label;
    private JButton b;
    
    public VistaUnivers (){
        createVistaUnivers();
    }
    
    public VistaUnivers(Controlador_Domini_Univers a){
        cu = a;
        createVistaUnivers();
        
    }
    
    public void createVistaUnivers(){
        univers = new JPanel();
        univers.setLayout(new GridLayout(3, 2, 5, 5));
        univers.add(buttonUniversOP1);
        univers.add(buttonUniversOP2);
        univers.add(buttonUniversOP3);
        univers.add(buttonUniversOP4);
        univers.add(buttonUniversOP5);
        univers.add(buttonUniversOP6);
        univers.add(buttonUniversOP7);
        univers.add(buttonUniversOP8);
        univers.add(buttonUniversOP9);
        univers.add(buttonUniversOP10);
        univers.add(buttonUniversOP11);
        univers.add(buttonUniversOP12);
        univers.add(buttonUniversOP13);
        univers.add(buttonUniversOP14);

        
        assignar_actionListeners();
        
    }

    public JPanel construct(){
        return univers;
    }

    private void assignar_actionListeners(){
        buttonUniversOP1.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                altaUnivers(event);
            }
        });

        buttonUniversOP2.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                baixaUnivers(event);
            }
        });

        buttonUniversOP3.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                modificarNom(event);
            }
        });

        buttonUniversOP4.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirId(event);
            }
        });

        buttonUniversOP5.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                llistatUniversos(event);
            }
        });

        buttonUniversOP6.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                numPlanetes(event);
            }
        });

        buttonUniversOP7.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                afegirPlaneta(event);
            }
        });

        buttonUniversOP8.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                desafegirPlaneta(event);
            }
        });

        buttonUniversOP9.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                vectorPlanetes(event);
            }
        });

        buttonUniversOP10.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                matriuDistanciaPlanetes(event);
            }
        });

        buttonUniversOP11.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                matriuNecessitatsPlanetes(event);
            }
        });

        buttonUniversOP12.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                matriusRecursosPlanetes(event);
            }
        });

        buttonUniversOP13.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                guardar(event);
            }
        });

        buttonUniversOP14.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                carregar(event);
            }
        });



    }

    private void altaUnivers(ActionEvent event){


    }

    private void baixaUnivers(ActionEvent event){


    }

    private void modificarNom(ActionEvent event){


    }

    private void obtenirId(ActionEvent event){


    }

    private void llistatUniversos(ActionEvent event){


    }

    private void numPlanetes(ActionEvent event){


    }

    private void afegirPlaneta(ActionEvent event){


    }

    private void desafegirPlaneta(ActionEvent event){


    }

    private void vectorPlanetes(ActionEvent event){


    }

    private void matriuDistanciaPlanetes(ActionEvent event){


    }

    private void matriuNecessitatsPlanetes(ActionEvent event){


    }

    private void matriusRecursosPlanetes(ActionEvent event){


    }

    private void guardar(ActionEvent event){


    }

    private void carregar(ActionEvent event){


    }
    public void paint(JPanel p){
        v.revalidatepanel3(p);
    }
}
