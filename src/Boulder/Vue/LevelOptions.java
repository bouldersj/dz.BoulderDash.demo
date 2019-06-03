/**
 * 
 */
package Boulder.Vue;

import java.awt.Color;


import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Boulder.Controlleur.Jeu.MenuState;
import Boulder.Modele.Game;
import Boulder.Modele.Utils;


/**
 * 
 * @author liabe
 *
 */
/**
 * View that allow choosing the level
 * 
 */
@SuppressWarnings("serial")
public class LevelOptions extends JPanel {

	/**
	 * Initialization of the menu
	 */
	public LevelOptions() {
		initMenu();
	}

	/**
	 * Initializing the main menu
	 */
	private void initMenu() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setPreferredSize(new Dimension(Utils.HAUTEUR_PANEL_SCORE,Utils.LARGEUR_PANEL_SCORE));
		setDoubleBuffered(true);
		setBackground(Color.black);

		JLabel logo = new JLabel(new ImageIcon("res/sprites/menu.jpg"));

		JComboBox<String> Liste = new JComboBox<>(Game.getListeNiveaux());
		Liste.setMaximumSize(new Dimension(200, 30));

		JButton lancerJeu = new JButton("Play");
		JButton retour = new JButton("Back");

		logo.setAlignmentX(CENTER_ALIGNMENT);
		Liste.setAlignmentX(CENTER_ALIGNMENT);
		lancerJeu.setAlignmentX(CENTER_ALIGNMENT);
		retour.setAlignmentX(CENTER_ALIGNMENT);

		MenuState ctrl = new MenuState(lancerJeu, retour, Liste);
		lancerJeu.addActionListener(ctrl);
		retour.addActionListener(ctrl);

		
	
		add(logo);
		add(Box.createVerticalStrut(15));
		add(Liste);
		add(Box.createVerticalStrut(15));
		add(lancerJeu);
		add(Box.createVerticalStrut(15));
		add(retour);
	}
}
