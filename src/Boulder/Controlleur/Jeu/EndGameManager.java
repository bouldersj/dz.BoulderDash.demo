/***
 * 
 */
package Boulder.Controlleur.Jeu;

import javax.swing.JOptionPane;




import Boulder.Launcher;
import Boulder.Modele.State;
import Boulder.Vue.Views;

/**
 * gestionaire de fin de jeu, est appelé par la fenêtre si le jeu est fini
 */

public class EndGameManager {
	public static void finJeu() {
		if (Launcher.getJeu().getNiveau().getPerso().isLife()) {
			popVictoire();
		} else {
			popDefaite();
		}

	}

	/**
	 * gestionaire de victoire, ouvre une popup avec le score et plusieurs
	 * actions possibles à effectuer
	 */
	private static void popVictoire() {
		Object[] options = { "menu", "play again",
				"change level" };
		String message = "TableScore:\n"
				+ "\tDiamonds : "
				+ Launcher.getJeu().getNiveau().getScore()
				+ "\n\tTime Bonus : "
				+ Launcher.getJeu().getNiveau().getTmax()
				+ "\n\tTotal Score : "
				+ (Launcher.getJeu().getScore() + Launcher.getJeu()
						.getNiveau().getTmax());
		int n = JOptionPane.showOptionDialog(Launcher.getFen(), message,
				"You Win !", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[2]);
	
		switch (n) {
		case 0:
			Launcher.getJeu().resetScore();
			Launcher.getFen().changerVue(Views.MENUPRINCIPAL);
		
			break;
		case 1:
			Launcher.getJeu().restartLevel();
			Launcher.getFen().changerVue(Views.TABLEAUJEU);
			Launcher.setState(State.Jeu);
			break;
		case 2:
			Launcher.getFen().changerVue(Views.MENUCHOIXNIVEAU);
			break;
		default:
			break;
		}
	}

	/**
	 * gestionaire de défaite, affiche une popup avec le score et les
	 * différentes options possibles pour l'utilisateur
	 */
	private static void popDefaite() {
		Object[] options = { "menu", "new game", "play again" };
		String message = "your Score : " + Launcher.getJeu().getScore();
		int n = JOptionPane.showOptionDialog(Launcher.getFen(), message,
				"Game Over !", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[2]);
		switch (n) {
		case 0:
			Launcher.getJeu().resetScore();
			Launcher.getFen().changerVue(Views.MENUPRINCIPAL);
			break;
		case 1:
			Launcher.getFen().changerVue(Views.MENUCHOIXNIVEAU);
			break;
		case 2:
			Launcher.getJeu().restartLevel();
			Launcher.getFen().changerVue(Views.TABLEAUJEU);
			Launcher.setState(State.Jeu);
		default:
			break;
		}
	}
}
