/***

 * 
 *
package Boulder.Modele.Cases;

import Boulder.Modele.GameState;

import Boulder.Modele.Animation.Animation;
import Boulder.Modele.Animation.AnimationManager;

/**
 * 
 * @author liabe
 *
 *
public class MagicWall extends Entity {
	private boolean active;

	public MagicWall(int x, int y) {
		super(x, y);
		active = false;
	}

	/**
	 * fonction servant à activer le mur magique, elle appelera les fonctions
	 * des murs magiques contigus
	 *
	public void activer(GameState N) {
		active = true;
		if (N.getCase(getX() - 1, getY()) instanceof MagicWall
				&& !((MagicWall) N.getCase(getX() - 1, getY())).isActive()) {
			((MagicWall) N.getCase(getX() - 1, getY())).activer(N);
		}

		if (N.getCase(getX() + 1, getY()) instanceof MagicWall
				&& !((MagicWall) N.getCase(getX() + 1, getY())).isActive()) {
			((MagicWall) N.getCase(getX() + 1, getY())).activer(N);
		}
	}

	/**
	 * fonction permettant de voir si le mur est actif ou non
	 *
	public boolean isActive() {
		return active;
	}

	@Override
	public String ID() {

		return "X";

	}

	/**
	 * retourne le sprite du mur si inactif, le sprite du mur magique sinon
	 *
	@Override
	public Animation getAnimation() {
		if (active) {
			return AnimationManager.getMurMagique();
		} else {
			return AnimationManager.getMur();
		}
	}

	/**
	 * fonction d'interaction d'élément chutable : si un élément chutable arrive
	 * et est en état de chute, alors il active le mur et est transmuté, sinon
	 * le mur se comporte comme n'importe quel mur
	 * 
	 *
	@Override
	public ItemState IsItemsFalling(GameState N) {
		if (((MovableItems) N.getCase(getX(), getY() - 1)).chute()) {
			if (!active) {
				activer(N);
			}
			N.remUptable(N.getCase(getX(), getY() - 1));
			if (N.getCase(getX(), getY() + 1).isInBlackDirt()) {
				if (N.getCase(getX(), getY() - 1) instanceof Diamonds) {
					N.insereRocher(getX(), getY() + 1);
				} else {
					N.insereDiamant(getX(), getY() + 1);
				}
				((MovableItems) N.getCase(getX(), getY() + 1)).setChute();
			}
			N.insereVide(getX(), getY() - 1);

			return ItemState.Instable;
		} else {
			return modeMur(N);
		}
	}

	/**
	 * fonction simulant un mur normal ou un élément chutable lorsque le mur
	 * magique est inactif
	 * 
	 * @see MovableItems
	 *
	private ItemState modeMur(GameState N) {
		if ((N.getCase(getX() + 1, getY() - 1).isInBlackDirt())
				&& (N.getCase(getX() + 1, getY()).isInBlackDirt())) {
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
*/