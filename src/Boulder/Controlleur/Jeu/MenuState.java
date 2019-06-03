/**
 * 
 */
package Boulder.Controlleur.Jeu;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import Boulder.Launcher;
import Boulder.Modele.State;
import Boulder.Vue.Views;
/***
 * 
 * @author liabe
 *
 */
public class MenuState implements ActionListener {
	Font fontEntered = new Font(Font.DIALOG, Font.ITALIC, 20);
	Font fontEnteredliste = new Font(Font.DIALOG, Font.ITALIC, 15);
	private JButton bouton1;
	private JButton bouton2;
	private JComboBox<String> list;

	public MenuState(JButton b1, JButton b2, JComboBox<String> liste2) {
		this.bouton1 = b1;
		
		b1.setBackground(Color.lightGray);
		b1.setFont(fontEntered);
		
		
		
		this.bouton2 = b2;
		this.list = liste2;
		
		b2.setBackground(Color.lightGray);
		b2.setFont(fontEntered);
		
		this.list = liste2;
		
		liste2.setBackground(Color.lightGray);
		liste2.setFont(fontEnteredliste);
		
		
	}

	/**
	 * déclenche les actions associées à chaque bouton
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == this.bouton1) {
			Launcher.getJeu()
					.chargerNiveau((String) list.getSelectedItem());
			Launcher.setState(State.Jeu);
			Launcher.getFen().changerVue(Views.TABLEAUJEU);
		} else if (arg0.getSource() == this.bouton2) {
			Launcher.getFen().changerVue(Views.MENUPRINCIPAL);
		}
	}

}
