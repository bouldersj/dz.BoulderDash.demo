package Boulder.Vue;

import java.awt.Color;


import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import Boulder.Launcher;
import Boulder.Controlleur.Jeu.KeyManager;
import Boulder.Controlleur.Jeu.EndGameManager;



/***
 * 
 * @author liabe
 *
 */

/**
 * Game panel,group the game views
 * 
 * 
*/
@SuppressWarnings("serial")
public class GameArea extends JPanel implements Observer {

	/**
	 * Playground
	 */
	private GameView aireJeu;

	/**
	 * Game's information zone
	 */
	private GameInfo aireInfo;

	/**
	 * Keyboard interaction manager
	 */
	private KeyManager listen;

	/**
	 * Initializing the panel
	 */
	public GameArea() {
		setBackground(Color.black);
		aireJeu = new GameView(Launcher.getJeu().getNiveau());
		add(aireJeu);
		aireInfo = new GameInfo();
	//	add(aireInfo);
		

		listen = new KeyManager(Launcher.getJeu().getNiveau());
		addKeyListener(listen);
		Launcher.getJeu().addObserver(this);
	}

	/**
	 * Updating the view
	 */
	@Override
	public void update(Observable o, Object arg) {
		aireJeu.repaint();
		aireInfo.majinfos();
		if (Launcher.getJeu().isFini()) {
			EndGameManager.finJeu();
		}
	}
}
