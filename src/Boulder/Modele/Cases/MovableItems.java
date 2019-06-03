/**
 * 
 */
package Boulder.Modele.Cases;

import Boulder.Modele.GameState;

/***
 * 
 * @author liabe
 *
 */
public abstract class MovableItems extends Entity {
	private ItemState etat;

	/**
	 * creating an object that falls to the stable state by default
	 */
	public MovableItems(int pos_x, int pos_y) {
		super(pos_x, pos_y);
		etat = ItemState.Stable;
	}

	/**
	 * update the falling element by interacting before the box below
	 */
	@Override
	public void refresh(GameState N) {
		Entity C = N.getCase(getX(), getY() + 1);
		etat = C.IsItemsFalling(N);
	}
	/**
	 * puts the object in a state of falling
	 */
	public void setChute() {
		etat = ItemState.Chute;
	}

	/**
	 * check if the object is in a state of falling
	 * 
	 */
	public boolean chute() {
		return etat == ItemState.Chute;
	}

	/**
	 * puts the object in an unstable state
	 */
	public void setInstable() {
		etat = ItemState.Instable;
	}

	/**
	 * check if the object is unstable
	 * the fall is considered unstable by nature
	 */
	public boolean instable() {
		return etat != ItemState.Stable;
	}

	/**
	 * puts the object in a stable state
	 */
	public void setStable() {
		etat = ItemState.Stable;
	}

	/**
	 * check if the object is stable
	 */
	public boolean stable() {
		return etat == ItemState.Stable;
	}


	/**
	 * function of interaction with an object that falls
	 * it is checked that the boxes on the left at the level of the object arriving and the object of arrival are empty
	 * if then the object is exchanged with the latter one carries out the same right thing
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
}
