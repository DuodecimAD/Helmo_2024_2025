package FeuTricolore;

import javax.swing.*;

import FeuTricolore.FeuTricoloreMecanisme.Etat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeuTricoloreFSM extends JPanel {

    private static final long serialVersionUID = 1L;

    // Définition des états du feu tricolore
    enum Etat {
        VERT, ORANGE, ROUGE, CLIGNOTANT, ETEINT
    }

    private Etat etat;
    private Timer timer;


    /**
	 * Default constructor.
	 * 
	 * Initializes the FSM (Finite States Machine) instance.
	 */
    public FeuTricoloreFSM() {
    	
        this.etat = Etat.ETEINT; // L'état initial est l'état 5

        // Créer un timer pour changer l'état tous les 2 secondes
        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changerEtat();
                repaint(); // Redessiner le panneau après chaque changement d'état
            }
        });
        timer.start(); // Démarrer le timer
    }

    /**
	 * Change l'état du feu (input = 't' -> timer défini ci-dessus)
	 * 
	 */
    public void changerEtat() {
		// TODO
    	switch (etat) {
		case Etat.VERT 	 -> etat = Etat.ORANGE;
		case Etat.ORANGE -> etat = Etat.ROUGE;
		case Etat.ROUGE  -> etat = Etat.VERT;
		case Etat.ETEINT  -> etat = Etat.CLIGNOTANT;
		case Etat.CLIGNOTANT  -> etat = Etat.ETEINT;

		default -> throw new IllegalArgumentException("Unexpected value: " + etat);
		}
    }
    
    /**
   	 * Bascule entre le mode normal et le mode maintenance (input = 'm' -> bouton "Mode maintenance").
   	 * 
   	 */
    public void basculerMaintenance() {
    	// TODO
    	switch (etat) {
		case VERT, ORANGE, ROUGE -> etat = Etat.ETEINT;
		case ETEINT, CLIGNOTANT  -> etat = Etat.VERT;

		default -> throw new IllegalArgumentException("Unexpected value: " + etat);
		}
    }

    /**
	 * Dessine l'état actuel du feu.
	 * 
	 */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Définir la taille du panneau
        int width = getWidth();
        int height = getHeight();

        // Dessiner le fond du feu tricolore
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);

        // Définir les cercles pour les couleurs des feux
        int taille = 100;
        int x = (width - taille) / 2;
        int y = (height - taille * 3) / 2;

        // Dessiner les cercles de couleur selon l'état actuel
        
        for (int i = 0; i < 3; i++) {  // Définir la couleur pour chacun des trois cercles        	
        	
        	if (etat == Etat.CLIGNOTANT && i == 1) { 
                g.setColor(Color.ORANGE);            
            } else if (etat == Etat.VERT && i == 2) {
                g.setColor(Color.GREEN);
            } else if (etat == Etat.ORANGE && i == 1) {
                g.setColor(Color.ORANGE);
            } else if (etat == Etat.ROUGE && i == 0) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.DARK_GRAY); // Les autres feux sont éteints
            }
            g.fillOval(x, y + i * (taille + 10), taille, taille); // Dessiner les cercles
        }
    }

    /**
   	 * Méthode principale.
   	 * 
   	 */
    public static void main(String[] args) {
        // Créer une fenêtre JFrame
        JFrame frame = new JFrame("Feu Tricolore");
        // Créer un feu tricolore
        final FeuTricoloreFSM panneau = new FeuTricoloreFSM();

        // Ajouter un bouton  -> mode maintenance on/off
        JButton btnMaintenance = new JButton("Mode maintenance");
        btnMaintenance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panneau.basculerMaintenance();
                panneau.repaint();
            }
        });

        // Configurer la fenêtre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 600); // Taille de la fenêtre
        
        // Ajouter le panneau et le bouton
        frame.setLayout(new BorderLayout());
        frame.add(panneau, BorderLayout.CENTER);
        frame.add(btnMaintenance, BorderLayout.SOUTH);
        
        frame.setVisible(true);
    }
}

