package Boulder.Vue;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Boulder.Controlleur.BoutonMenuManager;
import Boulder.Modele.Utils;


/***
 * 
 * @author liabe
 *
 */
@SuppressWarnings("serial")
public class Menue extends JPanel {


	/**
	 * Initializing the main menu
	 */
	public Menue() {
		initMenuPrincipal();
		setFocusable(true);
	}

	/**
	 * Initialisation du menu principal
	 */
	private void initMenuPrincipal() {
		Font fontEntered = new Font(Font.DIALOG, Font.ITALIC, 20);
		//Font fontEnteredliste = new Font(Font.DIALOG, Font.ITALIC, 15);
		//Icon img = new ImageIcon("res/sprites/menu.jpg");
	
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setPreferredSize(new Dimension(Utils.HAUTEUR_PANEL_SCORE, Utils.LARGEUR_PANEL_SCORE));
		setBackground(Color.BLACK);
		setDoubleBuffered(true);

		JLabel logo = new JLabel(new ImageIcon("res/sprites/fond.png"));

		JButton lancerJeu = new JButton("Play");
		
		
		lancerJeu.setBackground(Color.lightGray);
		lancerJeu.setFont(fontEntered);
		
		JButton quiter = new JButton("Exit");
		quiter.setBackground(Color.lightGray);
		quiter.setFont(fontEntered);

		logo.setAlignmentX(CENTER_ALIGNMENT);
		lancerJeu.setAlignmentX(CENTER_ALIGNMENT);
		quiter.setAlignmentX(CENTER_ALIGNMENT);
		//quitter.setAlignmentX(CENTER_ALIGNMENT);

		BoutonMenuManager ctrl;
		ctrl = new BoutonMenuManager(lancerJeu, quiter);
		lancerJeu.addActionListener(ctrl);
		quiter.addActionListener(ctrl);

		add(logo);
		add(Box.createVerticalStrut(15));
		add(lancerJeu);
		add(Box.createVerticalStrut(15));
		add(quiter);
		add(Box.createVerticalStrut(15));
	}
}
