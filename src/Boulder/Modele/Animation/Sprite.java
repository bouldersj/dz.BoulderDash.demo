package Boulder.Modele.Animation;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Boulder.Modele.Utils;

/**
 * Classe de Sprite, conserve la feuille des sprites et en retourne chaque
 * élément
 */
/***
 * 
 * @author liabe
 *
 */
public class Sprite {

	/**
	 * Source de la feuille de sprites
	 */
	private String srcImage;

	/**
	 * Feuille de sprites
	 */
	private BufferedImage spriteSheet;

	/**
	 * Stocke la source de la feuille
	 * 
	 * @param src
	 *            source de la feuille de sprites
	 */
	public Sprite(String src) {
		this.srcImage = src;
	}

	/**
	 * Permet de récupérer la feuille de sprites
	 * 
	 * @param src
	 *            source de la feuille de sprites
	 * @return la feuille de sprites
	 */
	private static BufferedImage loadSprite(String file) {

		BufferedImage sprite = null;

		try {
			sprite = ImageIO.read(new File("./res/sprites/" + file + ".png"));
		} catch (IOException e) {
			System.err.println("erreur chargement sprite");
			e.printStackTrace();
		}

		return sprite;
	}

	/**
	 * Permet de récupérer un élément de la feuille de sprites
	 * 
	 * @param xGrid
	 *            coordonnée horizontale de l'élément
	 * @param yGrid
	 *            coordonnée verticale de l'élément
	 * @return un élément de la feuille de sprites
	 */
	public BufferedImage getSprite(int xGrid, int yGrid) {

		if (spriteSheet == null) {
			spriteSheet = loadSprite(this.srcImage);
		}

		return spriteSheet.getSubimage(xGrid * Utils.TAILLE_CASE, yGrid * Utils.TAILLE_CASE,Utils.TAILLE_CASE, Utils.TAILLE_CASE);

	}
	
	

}
