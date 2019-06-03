package Boulder.Modele.Cases;


import Boulder.Modele.Animation.Animation;
import Boulder.Modele.Animation.AnimationManager;

/***
 * 
 * @author liabe
 *
 */
public class IndestructibleWall extends Entity {

	public IndestructibleWall(int x, int y) {
		super(x, y);
	}

	/**
	 * get the sprite of indestructible wall
	 */
	@Override
	public Animation getAnimation() {
		return AnimationManager.getMur();
	}

	@Override
	public String ID() {
		return "M";
	}

}
