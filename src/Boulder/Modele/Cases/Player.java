package Boulder.Modele.Cases;

import Boulder.Modele.GameState;


import Boulder.Modele.Utils;
import Boulder.Modele.Animation.Animation;
import Boulder.Modele.Animation.AnimationManager;
import Boulder.Modele.Animation.Assets;

/***
 * 
 * @author liabe
 *
 */
public class Player extends Entity {
	private int xOffset;
	private int yOffset;
	Directions move;
	Directions Last;
	private Assets animation;
	boolean isLife;
	private int IDLE;

	public Player(int x, int y) {
		super(x, y);
		isLife = true;
		move = Directions.Null;
		Last = Directions.Null;

		IDLE = 0;

		animation = Assets.Personnage_Idle;
	}

	/**
	 *allows you to choose the next move that will be made during the next cycle
	 */
	public void setDeplace(Directions D) {
		move = D;
	}

	/**
	 * recover the direction
	 */
	public Directions getDeplace() {
		return move;
	}

	/**
	 * updating the movement
	 * will move the player in the selected direction in movement situation
	 */
	@Override
	public void refresh(GameState N) {
		int xdest = getX();
		int ydest = getY();
		switch (move) {
		case Bas:
			ydest++;
			AnimationManager.Personnage(animation).stop();
			animation = Assets.Personnage_Marche_Bas;
			break;
		case Droite:
			xdest++;
			AnimationManager.Personnage(animation).stop();
			animation = Assets.Personnage_Marche_Droite;
			break;
		case Gauche:
			AnimationManager.Personnage(animation).stop();
			animation = Assets.Personnage_Marche_Gauche;
			xdest--;
			break;
		case Haut:
			ydest--;
			AnimationManager.Personnage(animation).stop();
			animation = Assets.Personnage_Marche_Haut;
			break;
		case Null:
			arret();
			return;
		default:
			return;
		}
		Last = move;
		Entity C = N.getCase(xdest, ydest);

		if (!C.IsPlayerWalking(N)) {
			Last = Directions.Null;
		}
	}

	/**
	 * function that manages the character's idle, chooses the right sprite for the stop
	 */
	private void arret() {
		try {
			AnimationManager.Personnage(animation).stop();
		} catch (NullPointerException e) {
		}

		switch (Last) {
		case Bas:
			animation = Assets.Personnage_Debout_Bas;
			IDLE = 0;
			break;
		case Droite:
			animation = Assets.Personnage_Debout_Droite;
			IDLE = 0;
			break;
		case Gauche:
			animation = Assets.Personnage_Debout_Gauche;
			IDLE = 0;
			break;
		case Haut:
			animation = Assets.Personnage_Debout_Haut;
			IDLE = 0;
			break;
		case Null:
			if (IDLE < Utils.DELAI_IDLE) {
				IDLE++;
			} else {
				animation = Assets.Personnage_Idle;
			}
			break;
		default:
			break;
		}
		Last = Directions.Null;
	}

	@Override
	public String ID() {
		return "P";
	}

	/**
	 * fuction that updates the animation
	 * add an offset to smooth the animation
	 */
	@Override
	public void refreshAnim() {
		switch (Last) {
		case Bas:
			setoffsetY((getoffsetY() - Utils.PAS_MVT) % Utils.TAILLE_CASE);
			break;
		case Droite:
			setoffsetX((getoffsetX() - Utils.PAS_MVT) % Utils.TAILLE_CASE);
			break;
		case Gauche:
			setoffsetX((getoffsetX() + Utils.PAS_MVT) % Utils.TAILLE_CASE);
			break;
		case Haut:
			setoffsetY((getoffsetY() + Utils.PAS_MVT) % Utils.TAILLE_CASE);
			break;
		// $CASES-OMITTED$
		default:
			setoffsetX(0);
			setoffsetY(0);
			break;
		}
	}


	/** 
	 * interaction function with an element that falls down
	 * kills the character if the object is falling
	 */
	@Override
	public ItemState IsItemsFalling(GameState N) {
		if (((MovableItems) N.getCase(getX(), getY() - 1)).chute()) {
			isLife = false;
			N.setFini();
			animation = Assets.Personnage_Mort;
			for (int y = getY() - 1; y <= getY() + 1; y++) {
				for (int x = getX() - 1; x <= getX() + 1; x++) {
					N.remUptable(N.getCase(x, y));
					N.insereVide(x, y);
				}
			}
		}
		return ItemState.Stable;
	}

	/**
	 * interaction function with an enemy
	 * kills the character 
	 */
	@Override
	public boolean IsEnemyComming(GameState N) {
		isLife = false;
		N.setFini();
		animation = Assets.Personnage_Mort;
		for (int y = getY() - 1; y <= getY() + 1; y++) {
			for (int x = getX() - 1; x <= getX() + 1; x++) {
				N.remUptable(N.getCase(x, y));
				N.insereVide(x, y);
			}
		}
		return false;
	}

	/**
	 * return the sprite of the character
	 */
	@Override
	public Animation getAnimation() {
		return AnimationManager.Personnage(animation);
	}
	/**
	 * function checking if the character is still alive
	 */
	public boolean isLife() {
		return isLife;
	}

	/**
	 * function to retrieve the x offset of the character
	 */
	public int getoffsetX() {
		return xOffset;
	}

	/**
	 * function to retrieve the offset in y of the character
	 */
	public int getoffsetY() {
		return yOffset;
	}

	/**
	 * x offset setter
	 */
	public void setoffsetX(int x) {
		xOffset = x;
	}
	/**
	 * y offset setter
	 */
	public void setoffsetY(int y) {
		yOffset = y;
	}
}
