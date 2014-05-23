import java.io.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @param args the command line arguments
 */
public class VistaPlaneta extends Vista{
    
    private static Controlador_Domini_Planeta cp;
    private static JPanel planeta;
    private VistaGlobal v;
    private JButton buttonPlanetaOP1 = new JButton("AltaPlaneta");
    private JButton buttonPlanetaOP2 = new JButton("BaixaPlaneta");
    private JButton buttonPlanetaOP3 = new JButton("AssignarPlaneta");
    private JButton buttonPlanetaOP4 = new JButton("DesassignarPlaneta");
    private JButton buttonPlanetaOP5 = new JButton("ModificarNom");
    private JButton buttonPlanetaOP6 = new JButton("ModificarCoordenades");
    private JButton buttonPlanetaOP7 = new JButton("ModificarClasse");
    private JButton buttonPlanetaOP8 = new JButton("ObtenirId");
    private JButton buttonPlanetaOP9 = new JButton("ObtenirClasse");
    private JButton buttonPlanetaOP10 = new JButton("ObtenirCoordenades");
    private JButton buttonPlanetaOP11 = new JButton("ObtenirPlaneta");
    private JButton buttonPlanetaOP12 = new JButton("LlistarDesassignat");
    private JButton buttonPlanetaOP13 = new JButton("LlistarAssignat");
    private JButton buttonPlanetaOP14 = new JButton("AltaNecessitats");
    private JButton buttonPlanetaOP15 = new JButton("BaixaNecessitats");
    private JButton buttonPlanetaOP16 = new JButton("AssignarPaquet");
    private JButton buttonPlanetaOP17 = new JButton("DesassignarPaquet");
    private JButton buttonPlanetaOP18 = new JButton("obtenirRecursosDisponibles");
    private JButton buttonPlanetaOP19 = new JButton("ObtenirNecessitats");
    private JButton buttonPlanetaOP20 = new JButton("Guardar");
    private JButton buttonPlanetaOP21 = new JButton("Carregar");
    
    
    
    
    
    
    //Content Tools
    private static JPanel  content;
    private JTextField text;
    private JLabel  label;
    private JButton b;
    
    public VistaPlaneta (){
        v = super.getF();
        createVistaPlaneta();
    }
    
    public VistaPlaneta(Controlador_Domini_Planeta a){
        v = super.getF();
        cp = a;
        createVistaPlaneta();
        
    }
    
    public void createVistaPlaneta(){
        planeta = new JPanel();
        planeta.setLayout(new GridLayout(3, 2, 5, 5));
        planeta.add(buttonPlanetaOP1);
        planeta.add(buttonPlanetaOP2);
        planeta.add(buttonPlanetaOP3);
        planeta.add(buttonPlanetaOP4);
        planeta.add(buttonPlanetaOP5);
        planeta.add(buttonPlanetaOP6);
        planeta.add(buttonPlanetaOP7);
        planeta.add(buttonPlanetaOP8);
        planeta.add(buttonPlanetaOP9);
        planeta.add(buttonPlanetaOP10);
        planeta.add(buttonPlanetaOP11);
        planeta.add(buttonPlanetaOP12);
        planeta.add(buttonPlanetaOP13);
        planeta.add(buttonPlanetaOP14);
        planeta.add(buttonPlanetaOP15);
        planeta.add(buttonPlanetaOP16);
        planeta.add(buttonPlanetaOP17);
        planeta.add(buttonPlanetaOP18);
        planeta.add(buttonPlanetaOP19);
        planeta.add(buttonPlanetaOP20);
        planeta.add(buttonPlanetaOP21);
        
        
        assignar_actionListeners();
        
    }
    
    public JPanel construct(){
        return planeta;
    }
    
    private void assignar_actionListeners(){
        buttonPlanetaOP1.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                altaPlaneta(event);
            }
        });   

        buttonPlanetaOP2.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                baixaPlaneta(event);
            }
        });

        buttonPlanetaOP3.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                assignarPlaneta(event);
            }
        });

        buttonPlanetaOP4.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                desassignarPlaneta(event);
            }
        });

        buttonPlanetaOP5.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                modificarNom(event);
            }
        }); 

        buttonPlanetaOP6.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                modificarCoordenades(event);
            }
        });

        buttonPlanetaOP7.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                modificarClasse(event);
            }
        });

        buttonPlanetaOP8.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirId(event);
            }
        });

        buttonPlanetaOP9.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirClasse(event);
            }
        });

        buttonPlanetaOP10.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirCoordenades(event);
            }
        });

        buttonPlanetaOP11.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirPlaneta(event);
            }
        });

        buttonPlanetaOP12.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                llistarPlanetesDesassignat(event);
            }
        });

        buttonPlanetaOP13.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                llistarPlanetesAssignat(event);
            }
        }); 

        buttonPlanetaOP14.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                altaNecessitats(event);
            }
        });

        buttonPlanetaOP15.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                baixaNecessitats(event);
            }
        }); 

        buttonPlanetaOP16.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                assignarPaquet(event);
            }
        });

        buttonPlanetaOP17.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                desassignarPaquet(event);
            }
        });

        buttonPlanetaOP18.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirRecursosDisponibles(event);
            }
        });

        buttonPlanetaOP19.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirNecessitats(event);
            }
        });

        buttonPlanetaOP20.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                guardar(event);
            }
        });

        buttonPlanetaOP21.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                carregar(event);
            }
        });


        
        
    }

    private void altaPlaneta (ActionEvent event){


    } 

    private void baixaPlaneta (ActionEvent event){


    } 

    private void assignarPlaneta (ActionEvent event){


    } 

    private void desassignarPlaneta (ActionEvent event){


    } 

    private void modificarNom (ActionEvent event){


    } 

    private void modificarCoordenades (ActionEvent event){


    } 

    private void modificarClasse (ActionEvent event){


    } 

    private void obtenirId (ActionEvent event){


    } 

    private void obtenirClasse (ActionEvent event){


    } 

    private void obtenirCoordenades (ActionEvent event){


    } 

    private void obtenirPlaneta (ActionEvent event){


    } 

    private void llistarPlanetesDesassignat (ActionEvent event){


    } 

    private void llistarPlanetesAssignat (ActionEvent event){


    } 

    private void altaNecessitats(ActionEvent event){


    } 

    private void baixaNecessitats (ActionEvent event){


    } 

    private void assignarPaquet (ActionEvent event){


    } 

    private void desassignarPaquet (ActionEvent event){


    } 

    private void obtenirRecursosDisponibles (ActionEvent event){


    } 

    private void obtenirNecessitats (ActionEvent event){


    } 

    private void guardar (ActionEvent event){


    } 

    private void carregar (ActionEvent event){


    } 
    public void paint(JPanel p){
        v.revalidatepanel3(p);
    }
}
