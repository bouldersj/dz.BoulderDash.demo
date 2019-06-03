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
public class Boulder extends MovableItems {

	/**
	 * @param pos_x
	 * @param pos_y
	 */
	public Boulder(int pos_x, int pos_y) {
		super(pos_x, pos_y);
	}

	@Override
	public String ID() {
		return "R";
	}

	/**
	 * interaction avec le personnage, pousse le rocher à gauche ou à droite si
	 * il y a de la place
	 */
	@Override
	public boolean IsPlayerWalking(GameState N) {
		if (N.getPerso().getDeplace() == Directions.Gauche) {
			if (N.getCase(getX() - 1, getY()).isInBlackDirt()) {
				N.echangeCases(getX(), getY(), getX() - 1, getY());
				N.addUptable(getX(), getY());
				N.remplirUpTable(getX() + 1, getY());
			}
		} else if (N.getPerso().getDeplace() == Directions.Droite) {
			if (N.getCase(getX() + 1, getY()).isInBlackDirt()) {
				N.echangeCases(getX(), getY(), getX() + 1, getY());
				N.addUptable(getX(), getY());
				N.remplirUpTable(getX() - 1, getY());
			}
		}
		return false;
	}

	/**
	 * retourne le sprite du Rocher
	 */
	@Override
	public Animation getAnimation() {
		return AnimationManager.getRocher();
	}
}
