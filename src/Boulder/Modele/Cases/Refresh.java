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
public interface Refresh {

	public void refresh(GameState N);

	public void refreshAnim();

	public boolean stayInUpTable();
}
