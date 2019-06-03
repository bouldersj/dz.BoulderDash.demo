package Boulder.Vue;


import java.awt.Color;


import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Boulder.Launcher;
import Boulder.Controlleur.Jeu.GameMenuState;
import Boulder.Modele.Utils;


/***
 * 
 * @author liabe
 *
 */

/**
 * View of the game's information area showing the time remaining, the number of diamonds remaining and the score
 * 
 */
@SuppressWarnings("serial")
public class GameInfo extends JPanel {
	/**
	 * remaining diamonds
	 */
	private JLabel Drestant;

	/**
	 * remaining Time
	 */
	private JLabel Trestant;

	/**
	 * Score
	 */
	private JLabel score;

	/**
	 * Initializing the panel
	 */
	public GameInfo() {
		initAireInformation();
	}

	/**
	 * Initializing the panel
	 */
	private void initAireInformation() {
		setBackground(Color.BLACK);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setPreferredSize(new Dimension(Utils.HAUTEUR_PANEL_SCORE,Utils.LARGEUR_PANEL_SCORE));
		setDoubleBuffered(true);

		Drestant = new JLabel("remaining dimaonds : "+ Launcher.getJeu().getNiveau().getDscore());
		Drestant.setForeground(Utils.COULEUR_TEXTE);
		
		Trestant = new JLabel("remaining time : "+ Launcher.getJeu().getNiveau().getTmax());
		Trestant.setForeground(Utils.COULEUR_TEXTE);
		
		score = new JLabel("Score : " + Launcher.getJeu().getScore());
		score.setForeground(Utils.COULEUR_TEXTE);


		JButton retour = new JButton("Menu");
		JButton aide = new JButton("help");

		Drestant.setAlignmentX(CENTER_ALIGNMENT);
		Trestant.setAlignmentX(CENTER_ALIGNMENT);
		score.setAlignmentX(Component.CENTER_ALIGNMENT);
		retour.setAlignmentX(Component.CENTER_ALIGNMENT);
		aide.setAlignmentX(Component.CENTER_ALIGNMENT);

		GameMenuState ctrl = new GameMenuState(retour, aide);

		retour.addActionListener(ctrl);
		aide.addActionListener(ctrl);

		add(Drestant);
		add(Box.createVerticalStrut(15));
		add(Trestant);
		add(Box.createVerticalStrut(15));
		add(score);
		add(Box.createVerticalStrut(15));
		add(retour);
		add(Box.createVerticalStrut(15));
		add(aide);
	}


	/**
	 * Updating the displayed informations
	 */
	public void majinfos() {
		Drestant.setText("remaining dimaonds : "
				+ Launcher.getJeu().getNiveau().getDscore());
		Trestant.setText("remaining time  : "
				+ Launcher.getJeu().getNiveau().getTmax());
		score.setText("Score : " + Launcher.getJeu().getScore());
	}
}
