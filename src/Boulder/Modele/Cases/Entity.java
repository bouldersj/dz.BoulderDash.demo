package Boulder.Modele.Cases;

import Boulder.Modele.GameState;

import Boulder.Modele.Animation.Animation;

/***
 * 
 * @author liabe
 *
 */
public abstract class Entity implements Interactions, Refresh {

	private int x;
	private int y;
	boolean inBlackDirt;

	/**
	 * constructor
	 * 
	 * create a non-empty box with its internal position at x, y
	 * 
	 * @param x
	 * @param y
	 */
	public Entity(int x, int y) {
		this(x, y, false);
	}

	/**
	 * constructor, 
	 * create an empty box with its internal position at x, y and if it black dirt or something else 
	 * 
	 * @param x
	 * @param y
	 */
	public Entity(int x, int y, boolean vide) {
		this.x = x;
		this.y = y;
		this.inBlackDirt = vide;
	}


	/**
	 * Returns the identifier of the box
	 */
	@SuppressWarnings("static-method")
	public String ID() {
		return "C";
	}

	/**
	 * sprite the sprite of a case 
	 */
	public abstract Animation getAnimation();

	/**
	 * function to check if the box is empty
	 */
	public boolean isInBlackDirt() {
		return inBlackDirt;
	}
	/**
	 * function to know if the priority of the box is higher than that of another the lowest boxes in the table are the highest priority
	 */
	public boolean isSuperior(Entity C) {
		return getY() > C.getY();
	}

	/**
	 * interaction with a movable object , called when
	 * a movable object move, return a Stable object by default 
	 */
	@Override
	public ItemState IsItemsFalling(GameState N) {
		return ItemState.Stable;
	}

	/**
	 * interaction function with a character, 
	 * is called when a character comes to a box, 
	 * returns false by default	 
	 */
	@Override
	public boolean IsPlayerWalking(GameState N) {
		return false;
	}
	/**
	 * 
	 * interaction function with an enemy, 
	 * is called when an enemy arrives at a box, 
	 * returns false by default
	 */
	@Override
	public boolean IsEnemyComming(GameState N) {
		return false;
	}
	/**
	 * 
	 * update function of the box, 
	 * does not do anything by default
	 */
	@Override
	public void refresh(GameState N) {
	}
	/**
	 * animation update function, allows you to change animation 
	 * for objects whose animation changes	 
	 */
	@Override
	public void refreshAnim() {
	}

	/**
	 * function to know if the object should remain in the update table or not
	 */
	@Override
	public boolean stayInUpTable() {
		return false;
	}

	/**
	 * 
	 * @return x  getter of the position in x of the box
	 */
	public int getX() {
		return x;
	}
	/**
	 * 
	 * @param x set x 
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * set y 
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * set x y 
	 * @param x
	 * @param y
	 */
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
