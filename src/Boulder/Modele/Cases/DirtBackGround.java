package Boulder.Modele.Cases;

import Boulder.Modele.GameState;

import Boulder.Modele.Animation.Animation;
import Boulder.Modele.Animation.AnimationManager;

/***
 * 
 * @author liabe
 *
 */
public class DirtBackGround extends Entity {

	public DirtBackGround(int x, int y) {
		super(x, y, true);
	}

	/**
	 * retourne le sprite du Vide
	 */
	@Override
	public Animation getAnimation() {
		return AnimationManager.getVide();
	}

	@Override
	public String ID() {
		return "V";
	}

	/**
	 * interaction personnage, échange le personnage et le vide
	 */
	@Override
	public boolean IsPlayerWalking(GameState N) {
		N.echangeCases(N.getPerso().getX(), N.getPerso().getY(), getX(), getY());
		N.remplirUpTable(getX(), getY());
		return true;

	}

	/**
	 * interaction chutable, fait tomber l'objet chutable si il est instable, le
	 * met en état instable sinon
	 */
	@Override
	public ItemState IsItemsFalling(GameState N) {
		if (((MovableItems) N.getCase(getX(), getY() - 1)).instable()) {
			N.echangeCases(getX(), getY(), getX(), getY() - 1);
			N.remplirUpTable(getX(), getY());
			return ItemState.Chute;
		} else {
			return ItemState.Instable;
		}
	}

	/**
	 * autorise l'arrivée d'un ennemi
	 */
	@Override
	public boolean IsEnemyComming(GameState N) {
		return true;
	}
}
