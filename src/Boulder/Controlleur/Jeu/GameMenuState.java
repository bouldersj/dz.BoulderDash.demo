package Boulder.Controlleur.Jeu;


import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Boulder.Launcher;
import Boulder.Modele.State;
import Boulder.Modele.Utils;
import Boulder.Vue.Views;
/***
 * 
 * @author liabe
 *
 */
public class GameMenuState implements ActionListener { 
	

	JButton b1;
	JButton b2;

	public GameMenuState(JButton b1, JButton b2) {
		
		this.b1 = b1;
		
		this.b2 = b2;
		
	}

	/**
	 * met le jeu en pause, déclenche les actions associées aux différents
	 * boutons, désactive la pause
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Launcher.getJeu().pauseOn();
		if (arg0.getSource() == b1) {
			menu();
		} else if (arg0.getSource() == b2) {
			aide();
		}

		Launcher.getJeu().pauseOff();
		Launcher.getFen().refocus();
	}

	/**
	 * lorsque l'on clique sur le bouton menu, on affiche une popup avec les
	 * différentes actions possibles
	 * 
	 */
	private static void menu() {
		Object[] options = { "Menu", "another level", "back" };
		int n = JOptionPane.showOptionDialog(Launcher.getFen(),"" + "pause", "", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[3]);
		switch (n) {
		case 0:
			Launcher.getFen().changerVue(Views.MENUPRINCIPAL);
			Launcher.getJeu().interompre();
			break;
		case 1:
			Launcher.getJeu().restartLevel();
			Launcher.setState(State.Jeu);
			Launcher.getFen().changerVue(Views.TABLEAUJEU);
			break;
		case 2:
			Launcher.getJeu().interompre();
			Launcher.getFen().changerVue(Views.MENUCHOIXNIVEAU);
			break;
		default:
			break;
		}
	}

	/**
	 * ouvre une popup avec le message d'aide
	 */
	private static void aide() {
		JOptionPane.showMessageDialog(Launcher.getFen(), Utils.HELP);
	}
}
