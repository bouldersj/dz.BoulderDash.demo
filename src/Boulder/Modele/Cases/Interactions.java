/**
 * 
 */
package Boulder.Modele.Cases;

import Boulder.Modele.GameState;

/***
 * Interface containing all types of interaction
 * 
 */
/**
 * 
 * @author liabe
 *
 */
public interface Interactions {
	/**
	 * function called by the character when moving to a square
	 */
	boolean IsPlayerWalking(GameState gameState);

	/**
	 * function called by an object that falls when it falls
	 */
	ItemState IsItemsFalling(GameState gameState);

	/**
	 * function called by an enemy when it moves
	 */
	boolean IsEnemyComming(GameState gameState);
}
