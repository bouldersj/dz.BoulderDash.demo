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
public class ExitDoor extends Entity {
	private boolean ouverte;
	private boolean persoSortit;

	// private Animation animation;

	/**
	 * cretate an exit
	 * 
	 */
	public ExitDoor(int x, int y) {
		super(x, y);
		Fermer();
		persoSortit = false;
	}

	@Override
	public String ID() {
		return "S";
	}

	/**
	 * check that the exit is open
	 */
	public boolean isOuverte() {
		return ouverte;
	}

	/**
	 * open the exit
	 */
	public void Ouvrir() {
		this.ouverte = true;
	}

	/**
	 * close the exit
	 */
	public void Fermer() {
		this.ouverte = false;
	}

	/**
	 * the player passing if the exit is open
	 */
	@Override
	public boolean IsPlayerWalking(GameState N) {
		if (ouverte) {
			N.echangeCases(N.getPerso().getX(), N.getPerso().getY(), getX(),
					getY());
			N.setFini();
			persoSortit = true;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * object that falls,  interaction function	 
	 * @see MovableItems
	 */
	@Override
	public ItemState IsItemsFalling(GameState N) {
		if ((N.getCase(getX() + 1, getY() - 1).isInBlackDirt()) && (N.getCase(getX() + 1, getY()).isInBlackDirt())) {
			if (((MovableItems) N.getCase(getX(), getY() - 1)).instable()) {
				N.echangeCases(getX() + 1, getY(), getX(), getY() - 1);
				N.remplirUpTable(getX(), getY() - 1);
				return ItemState.Chute;
			} else {
				return ItemState.Instable;
			}
		} else if (N.getCase(getX() - 1, getY()).isInBlackDirt()
				&& N.getCase(getX() - 1, getY() - 1).isInBlackDirt()) {
			if (((MovableItems) N.getCase(getX(), getY() - 1)).instable()) {
				N.echangeCases(getX(), getY() - 1, getX() - 1, getY());
				N.remplirUpTable(getX(), getY() - 1);
				return ItemState.Chute;
			} else {
				return ItemState.Instable;
			}
		} else {
			return ItemState.Stable;
		}
	}

	/**
	 * shows mud if the character is out, 
	 * the exit sprite if the exit is open, 
	 * a wall otherwise
	 */
	@Override
	public Animation getAnimation() {
		if (persoSortit) {
			return AnimationManager.getVide();
		} else if (ouverte) {
			return AnimationManager.getSortie();
		} else {
			return AnimationManager.getMur();
		}
	}
}
