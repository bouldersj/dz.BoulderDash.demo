/**
 * 
 */
package Boulder.Modele.Cases;


import Boulder.Modele.GameState;

import Boulder.Modele.Animation.Animation;
import Boulder.Modele.Animation.AnimationManager;
/***
 * 
 * @author liabe
 *
 */
public class Diamonds extends MovableItems {

	/**
	 * @param pos_x
	 * @param pos_y
	 */
	public Diamonds(int pos_x, int pos_y) {
		super(pos_x, pos_y);
	}

	@Override
	public String ID() {
		return "D";
	}

	/**
	 * fonction d'interaction personnage, lorsque le personnage arrive on
	 * échange les cases, on insère du vide, on incrémente le score de 25 et on
	 * décrémente le nombre de diamants à trouver
	 */
	@Override
	public boolean IsPlayerWalking(GameState N) {
		N.echangeCases(N.getPerso().getX(), N.getPerso().getY(), getX(), getY());
		N.insereVide(getX(), getY());
		N.remplirUpTable(N.getPerso().getX(), N.getPerso().getY());
		N.AddDscore();
		N.addToScore(25);
		N.remUptable(this);
		return true;
	}

	/**
	 * renvoie le sprite de diamant
	 */
	@Override
	public Animation getAnimation() {
		return AnimationManager.getDiamant();
	}

}
