package Boulder.Vue;

import java.awt.Color;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

import Boulder.Modele.GameState;
import Boulder.Modele.Utils;
import Boulder.Modele.Animation.AnimationManager;


/***
 * 
 * @author liabe
 *
 */
/**
 * View of the playground where you can move the player
 * 
 */
@SuppressWarnings("serial")
public class GameView extends JPanel {


	/**
	 * Displayed level
	 */
	private GameState niveau;

	/**
	 * Initializing the panel
	 */
	public GameView(GameState niveau) {
		this.niveau = niveau;
		initAireDeJeu();

	}

	/**
	 * Initializing the panel
	 */
	private void initAireDeJeu() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(this.niveau.getLongueur() * Utils.TAILLE_CASE, this.niveau.getHauteur()* Utils.TAILLE_CASE));
		setDoubleBuffered(true);
	}

	/**
	 * Drawing the level
	 */
	private void drawNiveau(Graphics g) {
		int a, b;
		for (a = 0; a < this.niveau.getLongueur(); a++) {
			for (b = 0; b < this.niveau.getHauteur(); b++) {
				try {
					g.drawImage(AnimationManager.getVide().getSprite(), a * Utils.TAILLE_CASE, b * Utils.TAILLE_CASE,
							null);
				} catch (NullPointerException e) {
				}
				if (niveau.getCase(a, b) != niveau.getPerso()) {
					g.drawImage(
							niveau.getCase(a, b).getAnimation().getSprite(), a * Utils.TAILLE_CASE, b * Utils.TAILLE_CASE, null);
				}
				try {
					g.drawImage(niveau.getPerso().getAnimation().getSprite(),
							niveau.getPerso().getX() * Utils.TAILLE_CASE + niveau.getPerso().getoffsetX(), niveau.getPerso().getY()* Utils.TAILLE_CASE + niveau.getPerso().getoffsetY(), null);
				} catch (NullPointerException e) {
				}
			}
		}
		Toolkit.getDefaultToolkit().sync();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawNiveau(g);
	}

	/**
	 * change the displayed level
	 * 
	 * @param niveau
	 *            the level to display
	 */
	public void setNiveau(GameState niveau) {
		this.niveau = niveau;
	}

}
