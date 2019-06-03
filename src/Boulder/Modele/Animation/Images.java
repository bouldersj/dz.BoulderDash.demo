package Boulder.Modele.Animation;

import java.awt.image.BufferedImage;

/**
 * Classe d'animation, permet d'animer un tableau de sprites Peut être lancé ou
 * stoppé
 */
/***
 * 
 * @author liabe
 *
 */
public class Images {

	/**
	 * Image de la frame
	 */
	private BufferedImage frame;

	/**
	 * Durée de la frame
	 */
	private int delay;

	/**
	 * Création de la frame
	 * 
	 * @param frame
	 *            image de la frame
	 * @param delay
	 *            temps durant lequel la frame reste affichée
	 */
	public Images(BufferedImage frame, int delay) {
		this.frame = frame;
		this.delay = delay;
	}

	/**
	 * Permet de récupérer l'image de la frame
	 * 
	 * @return l'image de la frame
	 */
	public BufferedImage getFrame() {
		return frame;
	}

	/**
	 * Permet de modifier l'image de la frame
	 * 
	 * @param frame
	 *            la nouvelle image de la frame
	 */
	public void setFrame(BufferedImage frame) {
		this.frame = frame;
	}

	/**
	 * Permet de récupérer la durée de la frame
	 * 
	 * @return la durée de la frame
	 */
	public int getdelay() {
		return delay;
	}

	/**
	 * Permet de modifier la durée de la frame
	 * 
	 * @param la
	 *            nouvelle durée de la frame
	 */
	public void setdelay(int delay) {
		this.delay = delay;
	}

}
