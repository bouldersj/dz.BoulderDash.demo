package Boulder.Modele.Cases;

import Boulder.Modele.GameState;

import Boulder.Modele.Animation.Animation;
import Boulder.Modele.Animation.AnimationManager;

/***
 * 
 * @author liabe
 *
 */
public class Wall extends Entity {

	/**
	 * @param x
	 * @param y
	 */
	public Wall(int x, int y) {
		super(x, y);
	}

	@Override
	public Animation getAnimation() {
		return AnimationManager.getMur();
	}

	@Override
	public String ID() {
		return "N";
	}

	/**
	 * object falling function 
	 * 
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
}
