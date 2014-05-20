import java.io.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @param args the command line arguments
 */
public class VistaPaquet extends SubVista{
    
    private static Controlador_Domini_Paquet cp;
    private static JPanel paquet;
    private VistaGlobal v;
    private JButton buttonPaquetOP1 = new JButton("AltaPaquet");
    private JButton buttonPaquetOP2 = new JButton("BaixaPaquet");
    private JButton buttonPaquetOP3 = new JButton("AssignarRecurs");
    private JButton buttonPaquetOP4 = new JButton("ObtenirPaquet");
    private JButton buttonPaquetOP5 = new JButton("ObtenirIdPaquet");
    private JButton buttonPaquetOP6 = new JButton("ObtenirPaquetAssignar");
    private JButton buttonPaquetOP7 = new JButton("DesassignarPaquet");
    private JButton buttonPaquetOP8 = new JButton("LlistatPaquetsAssignats");
    private JButton buttonPaquetOP9 = new JButton("LlistatPaquetsNoAssignats");
    private JButton buttonPaquetOP10 = new JButton("LlistatRecursosPaquet");
    private JButton buttonPaquetOP11 = new JButton("Guardar");
    private JButton buttonPaquetOP12 = new JButton("Carregar");
    
    
    public VistaPaquet (){
        v = super.getF();
        createVistaPaquet();
    }
    
    public VistaPaquet(Controlador_Domini_Paquet a){
        v = super.getF();
        cp = a;
        createVistaPaquet();
    
    }
    
    public void createVistaPaquet(){
        paquet = new JPanel();
        paquet.setLayout(new GridLayout(3, 2, 5, 5));
        paquet.add(buttonPaquetOP1);
        paquet.add(buttonPaquetOP2);
        paquet.add(buttonPaquetOP3);
        paquet.add(buttonPaquetOP4);
        paquet.add(buttonPaquetOP5);
        paquet.add(buttonPaquetOP6);
        paquet.add(buttonPaquetOP7);
        paquet.add(buttonPaquetOP8);
        paquet.add(buttonPaquetOP9);
        paquet.add(buttonPaquetOP10);
        paquet.add(buttonPaquetOP11);
        paquet.add(buttonPaquetOP12);

        assignar_actionListeners();        
    }
    
    public JPanel construct(){
        return paquet;
    }

    private void assignar_actionListeners(){
        buttonPaquetOP1.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                altaPaquet(event);
            }
        });

        buttonPaquetOP2.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                baixaPaquet(event);
            }
        });

        buttonPaquetOP3.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                assignarRecurs(event);
            }
        });

        buttonPaquetOP4.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirPaquet(event);
            }
        });

        buttonPaquetOP5.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirIdPaquet(event);
            }
        });

        buttonPaquetOP6.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirPaquetAssignar(event);
            }
        });

        buttonPaquetOP7.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                desassignarPaquet(event);
            }
        });

        buttonPaquetOP8.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                llistatPaquetsAssignats(event);
            }
        });

        buttonPaquetOP9.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                llistatPaquetsNoAssignats(event);
            }
        });

        buttonPaquetOP10.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                llistatRecursosPaquet(event);
            }
        });

        buttonPaquetOP11.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                guardar(event);
            }
        });

        buttonPaquetOP12.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                carregar(event);
            }
        });
    }


    private void altaPaquet (ActionEvent event){


    }    
    private void baixaPaquet(ActionEvent event){


    }

    private void assignarRecurs(ActionEvent event){


    }

    private void obtenirPaquet(ActionEvent event){


    }

    private void obtenirIdPaquet(ActionEvent event){


    }

    private void obtenirPaquetAssignar(ActionEvent event){


    }

    private void desassignarPaquet(ActionEvent event){


    }

    private void llistatPaquetsAssignats(ActionEvent event){


    }

    private void llistatPaquetsNoAssignats(ActionEvent event){


    }

    private void llistatRecursosPaquet(ActionEvent event){


    }

    private void guardar(ActionEvent event){


    }

    private void carregar(ActionEvent event){


    }
    
    
    
    
    
    
    
    
    
    public void paint(JPanel p){
        v.revalidatepanel3(p);
    }

}
