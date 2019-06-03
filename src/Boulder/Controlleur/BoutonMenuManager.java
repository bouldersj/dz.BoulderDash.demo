package Boulder.Controlleur;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;

import javax.swing.JButton;

import Boulder.Launcher;
import Boulder.Vue.Views;
/***
 * 
 * @author liabe
 *
 */
public class BoutonMenuManager implements ActionListener {
/**
 * 
 */
	private JButton bouton1;
	private JButton bouton2;


	/**
	 * constructeur du gestionaire de menu
	 * 
	 * @param b1
	 *            bouton Jouer
	 * @param b3
	 *            bouton Quitter
	 */
	public BoutonMenuManager(JButton b1, JButton b2 ) {

		
		this.bouton1 = b1;
		this.bouton2 = b2;
		
	}

	/**
	 * déclenche les bonnes actions en fonction des boutons appuyés
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.bouton1) {
			Launcher.getFen().changerVue(Views.MENUCHOIXNIVEAU);
			Launcher.getJeu().resetScore();
		} else if (arg0.getSource() == this.bouton2) {
			System.exit(0);
		} 
	}
}