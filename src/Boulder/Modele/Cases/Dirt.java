package Boulder.Modele.Cases;

import Boulder.Modele.GameState;


import Boulder.Modele.Animation.Animation;
import Boulder.Modele.Animation.AnimationManager;

/***
 * 
 * @author liabe
 *
 */
public class Dirt extends Entity {

	public Dirt(int x, int y) {
		super(x, y);
	}

	/**
	 * retourne le sprite de la boue
	 */
	@Override
	public Animation getAnimation() {
		return AnimationManager.getBoue();
	}

	@Override
	public String ID() {
		return "D";
	}

	/**
	 * lorsque le personnage arrive, on échange les cases du personage et de la
	 * boue, on insère du vide sur l'ancienne position du personnage (écrasement
	 * de la boue), on déclenche l'insertion en uptable de cases potentielement
	 * affectées par le changement
	 */
	@Override
	public boolean IsPlayerWalking(GameState N) {
		N.echangeCases(N.getPerso().getX(), N.getPerso().getY(), this.getX(),
				this.getY());
		N.insereVide(getX(), getY());
		N.remplirUpTable(this.getX(), this.getY());
		return true;
	}
}
