package Boulder.Modele.Animation;

import java.awt.image.BufferedImage;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe d'animation, permet d'animer un tableau de sprites Peut être lancé ou
 * stoppé
 * 
 * @see Sprite, Frame
 */
/**
 * *
 * @author liabe
 *
 */
public class Animation {

	/*
	 * @counter the counter of frames 
	 * @delayFrame delay before change a frame 
	 * @thisFrame the actual image frame 
	 * @TotalFrames the total of frame on an animation 
	 * @inpause whether or not the game is in pause 
	 */
	/**
	 * Compteur pour le changement de frame
	 */
	private int counter;

	/**
	 * Délai avant changement de frame
	 */
	private int delayFrame;

	/**
	 * Animation actuelle
	 */
	private int thisFrame;

	/**
	 * Nombre total de frame pour l'animation
	 */
	private int totalFrames;

	/**
	 * Indique si l'animation est stoppée
	 */
	private boolean inPause;
	/**
	 * make a list of Images Frames
	 */
	private List<Images> frames = new ArrayList<>();

	/**
	 * Crée une animation en stockant les frames dans une liste et en
	 * initialisant le délai
	 * 
	 * @param frames
	 *            tableau des images que l'on veut animer
	 * @param delayFrame
	 *            délai du changement de frame
	 */
	public Animation(BufferedImage[] frames, int delayFrame) {
		this.delayFrame = delayFrame;
		this.inPause = true;

		for (int i = 0; i < frames.length; i++) {
			addFrame(frames[i], delayFrame);
		}

		this.counter = 0;
		this.delayFrame = delayFrame;
		this.thisFrame = 0;
		this.totalFrames = this.frames.size();

	}

	/**
	 * Lance l'animation
	 */
	public void start() {
		if (!inPause) {
			return;
		}

		if (frames.size() == 0) {
			return;
		}

		inPause = false;
	}

	/**
	 * Arrête l'animation
	 */
	public void stop() {
		if (frames.size() == 0) {
			return;
		}

		inPause = true;
	}

	/**
	 * Transforme une image en frame grâce à sa durée puis la stocke dans une
	 * liste
	 * 
	 * @param frame
	 *            une des images de l'animation
	 * @param delayFrame
	 *            délai du changement de frame
	 */
	private void addFrame(BufferedImage frame, int delayFrame) {
		if (delayFrame <= 0) {
			System.err.println("Invalid duration: " + delayFrame);
			throw new RuntimeException("Invalid duration: " + delayFrame);
		}

		frames.add(new Images(frame, delayFrame));
		thisFrame = 0;
	}

	/**
	 * Permet de récupérer l'image actuelle
	 * 
	 * @return l'image de la frame courante
	 */
	public BufferedImage getSprite() {
		return frames.get(thisFrame).getFrame();
	}

	/**
	 * Permet de récupérer l'image statique de l'animation
	 * 
	 * @return une image statique
	 */
	public BufferedImage getSpriteImmobile() {
		return frames.get(0).getFrame();
	}

	/**
	 * Met à jour l'animation grâce au compteur qui modifie la frame actuelle
	 * une fois le délai passé
	 */
	public void update() {
		if (!inPause) {
			counter++;
			if (counter > delayFrame) {
				counter = 0;
				thisFrame += 1;

				if (thisFrame > totalFrames - 1) {
					thisFrame = 0;
				} else if (thisFrame < 0) {
					thisFrame = totalFrames - 1;
				}
			}
		}

	}

}
