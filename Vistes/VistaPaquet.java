import java.io.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @param args the command line arguments
 */
public class VistaPaquet extends Vista{
    
    private static Controlador_Domini_Paquet cp;
    private static JPanel paquet;
    private VistaGlobal v;
    
    private JButton buttonPaquetOP3 = new JButton("AssignarRecurs");
    
    private JButton buttonPaquetOP6 = new JButton("ObtenirPaquetAssignar");
    private JButton buttonPaquetOP7 = new JButton("DesassignarPaquet");
    private JButton buttonPaquetOP8 = new JButton("LlistatPaquetsAssignats");
    private JButton buttonPaquetOP9 = new JButton("LlistatPaquetsNoAssignats");
    private JButton buttonPaquetOP10 = new JButton("LlistatRecursosPaquet");
    
    
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
        paquet.add(buttonAlta = new JButton("AltaPaquet"));
        paquet.add(buttonBaixa = new JButton("BaixaPaquet"));
        paquet.add(buttonPaquetOP3);
        paquet.add(buttonObtenir = new JButton("ObtenirPaquet"));
        paquet.add(buttonObtenirID = new JButton("ObtenirID"));
        paquet.add(buttonPaquetOP6);
        paquet.add(buttonPaquetOP7);
        paquet.add(buttonPaquetOP8);
        paquet.add(buttonPaquetOP9);
        paquet.add(buttonPaquetOP10);
        paquet.add(buttonGuardar = new JButton("Guardar"));
        paquet.add(buttonCarregar = new JButton("Carregar"));

        assignar_actionListeners();        
    }
    
    public JPanel construct(){
        return paquet;
    }

    private void assignar_actionListeners(){
        buttonAlta.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                altaPaquet(event);
            }
        });

        buttonBaixa.addActionListener
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

        buttonObtenir.addActionListener
        (new ActionListener() {
            public void actionPerformed (ActionEvent event) {
                obtenirPaquet(event);
            }
        });

        buttonObtenirID.addActionListener
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
