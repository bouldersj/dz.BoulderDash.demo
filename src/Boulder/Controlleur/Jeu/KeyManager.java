/**
 * 
 */
package Boulder.Controlleur.Jeu;

import java.awt.event.KeyEvent;


import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import Boulder.Modele.GameState;
import Boulder.Modele.Cases.Directions;
/***
 * 
 * @author liabe
 *
 */
public class KeyManager implements KeyListener {
	/**
	 * map des touches enfoncées, toutes les touches sont à faux par défaut
	 */
	private Map<Integer, Boolean> keys;
	private GameState gameState;

	public KeyManager(GameState gameState) {
		this.gameState = gameState;
		keys = new HashMap<>();
		keys.put(KeyEvent.VK_D, false);
		keys.put(KeyEvent.VK_Q, false);
		keys.put(KeyEvent.VK_Z, false);
		keys.put(KeyEvent.VK_S, false);

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	/**
	 * passe à faux la variable de la touche relachée,
	 * si une autre touche était appuyée, alors celle-ci prend le devant
	 */
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_Z:
			keys.put(KeyEvent.VK_Z, false);
			break;
		case KeyEvent.VK_Q:
			keys.put(KeyEvent.VK_Q, false);
			break;
		case KeyEvent.VK_S:
			keys.put(KeyEvent.VK_S, false);
			break;
		case KeyEvent.VK_D:
			keys.put(KeyEvent.VK_D, false);
			break;
		default:
			break;
		}
		if (keys.get(KeyEvent.VK_D)) {
			droite();
		} else if (keys.get(KeyEvent.VK_Q)) {
			gauche();
		} else if (keys.get(KeyEvent.VK_Z)) {
			haut();
		} else if (keys.get(KeyEvent.VK_S)) {
			bas();
		} else {
			gameState.getPerso().setDeplace(Directions.Null);
		}
	}

	/**
	 * lance la fonction associée à la touche appuyée
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_Z:
			haut();
			break;
		case KeyEvent.VK_Q:
			gauche();
			break;
		case KeyEvent.VK_S:
			bas();
			break;
		case KeyEvent.VK_D:
			droite();
			break;
		default:
			break;
		}
	}

	/**
	 * traitement de l'appui sur la touche droite
	 */
	private void droite() {
		keys.put(KeyEvent.VK_D, true);
		gameState.getPerso().setDeplace(Directions.Droite);
	}

	/**
	 * traitement de l'appui sur la touche bas
	 */
	private void bas() {
		keys.put(KeyEvent.VK_S, true);
		gameState.getPerso().setDeplace(Directions.Bas);
	}

	/**
	 * traitement de l'appui sur la touche gauche
	 */
	private void gauche() {
		keys.put(KeyEvent.VK_Q, true);
		gameState.getPerso().setDeplace(Directions.Gauche);
	}

	/**
	 * traitement de l'appui sur la touche haut
	 */
	private void haut() {
		keys.put(KeyEvent.VK_Z, true);
		gameState.getPerso().setDeplace(Directions.Haut);
	}

}
