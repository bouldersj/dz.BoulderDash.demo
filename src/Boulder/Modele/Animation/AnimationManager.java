package Boulder.Modele.Animation;

import java.awt.image.BufferedImage;


import java.util.HashMap;
import java.util.Map;

import Boulder.Modele.Utils;

/**
 * Classe d'animation, permet d'animer un tableau de sprites Peut être lancé
 * ou stoppé
 */
/***
 * 
 * @author liabe
 *
 */
public class AnimationManager {

	/**
	 * Liste de toutes les animations du jeu
	 */
	private static Map<Assets, Animation> AnimationManager = new HashMap<>();

	/**
	 * Permet de récupérer l'animation du papillon
	 * 
	 * @return l'animation du papillon
	 */
	public static Animation getPapillon() {

		if (AnimationManager.get(Assets.Papillon) == null) {
			Sprite spritePapillon = new Sprite("world");
			BufferedImage[] papillon = { 
					spritePapillon.getSprite(9, 0),
					spritePapillon.getSprite(9, 1),
					spritePapillon.getSprite(9, 2) };
			AnimationManager.put(Assets.Papillon,
					new Animation(papillon, Utils.VITESSE_ANIM));
		}
		AnimationManager.get(Assets.Papillon).start();
		return AnimationManager.get(Assets.Papillon);
	}

	/**
	 * Permet de récupérer l'animation du personnage marchant vers la droite
	 * 
	 * @return l'animation du personnage marchant vers la droite
	 */
	private static Animation getPersonnageMarcheDroite() {
		if (AnimationManager
				.get(Assets.Personnage_Marche_Droite) == null) {
			Sprite spritePersonnage = new Sprite("player");
			BufferedImage[] walkingRight = {
					spritePersonnage.getSprite(0, 3),
					spritePersonnage.getSprite(1, 3),
					spritePersonnage.getSprite(2, 3)
					};
			AnimationManager.put(Assets.Personnage_Marche_Droite,
					new Animation(walkingRight, Utils.VITESSE_ANIM));
		}
		AnimationManager.get(Assets.Personnage_Marche_Droite).start();
		return AnimationManager.get(Assets.Personnage_Marche_Droite);
	}

	/**
	 * Permet de récupérer l'animation du personnage marchant vers la gauche
	 * 
	 * @return l'animation du personnage marchant vers la gauche
	 */
	private static Animation getPersonnageMarcheGauche() {
		if (AnimationManager
				.get(Assets.Personnage_Marche_Gauche) == null) {
			Sprite spritePersonnage = new Sprite("player");
			BufferedImage[] walkingLeft = { 
					spritePersonnage.getSprite(0, 1),
					spritePersonnage.getSprite(1, 1) ,
					spritePersonnage.getSprite(2, 1) 

					
			};
			AnimationManager.put(Assets.Personnage_Marche_Gauche,
					new Animation(walkingLeft, Utils.VITESSE_ANIM));
		}
		AnimationManager.get(Assets.Personnage_Marche_Gauche).start();
		return AnimationManager.get(Assets.Personnage_Marche_Gauche);
	}

	/**
	 * Permet de récupérer l'animation du personnage marchant vers le haut
	 * 
	 * @return l'animation du personnage marchant vers le haut
	 */
	private static Animation getPersonnageMarcheHaut() {
		if (AnimationManager
				.get(Assets.Personnage_Marche_Haut) == null) {
			Sprite spritePersonnage = new Sprite("player");
			BufferedImage[] walkingUp = { 
					spritePersonnage.getSprite(0, 2),
					spritePersonnage.getSprite(1, 2), 
					spritePersonnage.getSprite(2, 2)
					};
			AnimationManager.put(Assets.Personnage_Marche_Haut,
					new Animation(walkingUp, Utils.VITESSE_ANIM));
		}
		AnimationManager.get(Assets.Personnage_Marche_Haut).start();
		return AnimationManager.get(Assets.Personnage_Marche_Haut);
	}

	/**
	 * Permet de récupérer l'animation du personnage marchant vers le bas
	 * 
	 * @return l'animation du personnage marchant vers le bas
	 */
	private static Animation getPersonnageMarcheBas() {
		if (AnimationManager.get(Assets.Personnage_Marche_Bas) == null) {
			Sprite spritePersonnage = new Sprite("player");
			BufferedImage[] walkingDown = { 
					spritePersonnage.getSprite(0, 4),
					spritePersonnage.getSprite(1, 4), 
					spritePersonnage.getSprite(2, 4)
					};
			AnimationManager.put(Assets.Personnage_Marche_Bas,
					new Animation(walkingDown, Utils.VITESSE_ANIM));
		}
		AnimationManager.get(Assets.Personnage_Marche_Bas).start();
		return AnimationManager.get(Assets.Personnage_Marche_Bas);
	}

	/**
	 * Permet de récupérer l'animation du personnage debout vers la droite
	 * 
	 * @return l'animation du personnage debout vers la droite
	 */
	private static Animation getPersonnageDeboutDroite() {
		if (AnimationManager
				.get(Assets.Personnage_Debout_Droite) == null) {
			Sprite spritePersonnage = new Sprite("player");
			BufferedImage[] standingRight = {
					spritePersonnage.getSprite(3,0) };
			AnimationManager.put(Assets.Personnage_Debout_Droite,
					new Animation(standingRight, Utils.VITESSE_ANIM));
		}
		return AnimationManager.get(Assets.Personnage_Debout_Droite);
	}

	/**
	 * Permet de récupérer l'animation du personnage debout vers la gauche
	 * 
	 * @return l'animation du personnage debout vers la gauche
	 */
	private static Animation getPersonnageDeboutGauche() {
		if (AnimationManager
				.get(Assets.Personnage_Debout_Gauche) == null) {
			Sprite spritePersonnage = new Sprite("player");
			BufferedImage[] standingLeft = { spritePersonnage.getSprite(3,0) };
			AnimationManager.put(Assets.Personnage_Debout_Gauche,
					new Animation(standingLeft, Utils.VITESSE_ANIM));
		}
		return AnimationManager.get(Assets.Personnage_Debout_Gauche);
	}

	/**
	 * Permet de récupérer l'animation du personnage debout vers le haut
	 * 
	 * @return l'animation du personnage debout vers le haut
	 */
	private static Animation getPersonnageDeboutHaut() {
		if (AnimationManager
				.get(Assets.Personnage_Debout_Haut) == null) {
			Sprite spritePersonnage = new Sprite("player");
			BufferedImage[] standingUp = { spritePersonnage.getSprite(3,0) };
			AnimationManager.put(Assets.Personnage_Debout_Haut,
					new Animation(standingUp, Utils.VITESSE_ANIM));
		}
		return AnimationManager.get(Assets.Personnage_Debout_Haut);
	}

	/**
	 * Permet de récupérer l'animation du personnage debout vers le bas
	 * 
	 * @return l'animation du personnage debout vers le bas
	 */
	private static Animation getPersonnageDeboutBas() {
		if (AnimationManager.get(Assets.Personnage_Debout_Bas) == null) {
			Sprite spritePersonnage = new Sprite("player");
			BufferedImage[] standingDown = { spritePersonnage.getSprite(3,0) };
			AnimationManager.put(Assets.Personnage_Debout_Bas,
					new Animation(standingDown, Utils.VITESSE_ANIM));
		}
		return AnimationManager.get(Assets.Personnage_Debout_Bas);
	}

	/**
	 * Permet de récupérer l'animation du personnage patientant
	 * 
	 * @return l'animation du personnage patientant
	 */
	private static Animation getPersonnageIdle() {
		if (AnimationManager.get(Assets.Personnage_Idle) == null) {
			Sprite spritePersonnage = new Sprite("player");
			BufferedImage[] idling = { 
					spritePersonnage.getSprite(0, 0),
					spritePersonnage.getSprite(1, 0)
					
					
			};
			AnimationManager.put(Assets.Personnage_Idle,
					new Animation(idling, Utils.VITESSE_IDLE));
		}
		AnimationManager.get(Assets.Personnage_Idle).start();
		return AnimationManager.get(Assets.Personnage_Idle);
	}

	/**
	 * Permet de récupérer l'animation du personnage mort
	 * 
	 * @return l'animation du personnage mort
	 */
	private static Animation getPersonnageMort() {
		if (AnimationManager.get(Assets.Personnage_Mort) == null) {
			Sprite spritePersonnage = new Sprite("player");
			BufferedImage[] mort = { 
					spritePersonnage.getSprite(4, 5),
				
					};
			AnimationManager.put(Assets.Personnage_Mort,
					new Animation(mort, Utils.VITESSE_ANIM));
		}
		return AnimationManager.get(Assets.Personnage_Mort);
	}

	/**
	 * Permet de récupérer l'animation de la boue
	 * 
	 * @return l'animation de la boue
	 */
	public static Animation getBoue() {
		if (AnimationManager.get(Assets.Boue) == null) {
			Sprite spriteBoue = new Sprite("world");
			BufferedImage[] dirt = { spriteBoue.getSprite(1,0) };
			AnimationManager.put(Assets.Boue,
					new Animation(dirt, Utils.VITESSE_ANIM));
		}
		return AnimationManager.get(Assets.Boue);
	}

	/**
	 * Permet de récupérer l'animation du diamant
	 * 
	 * @return l'animation du diamant
	 */
	public static Animation getDiamant() {
		if (AnimationManager.get(Assets.Diamant) == null) {
			Sprite spriteDiamant = new Sprite("world");
			BufferedImage[] diamond = { 
					spriteDiamant.getSprite(4, 0),
					spriteDiamant.getSprite(4, 0),
					spriteDiamant.getSprite(4, 0),
					spriteDiamant.getSprite(4, 0) };
			AnimationManager.put(Assets.Diamant,
					new Animation(diamond, Utils.VITESSE_ANIM));
		}
		AnimationManager.get(Assets.Diamant).start();
		return AnimationManager.get(Assets.Diamant);
	}

	/**
	 * Permet de récupérer l'animation du rocher
	 * 
	 * @return l'animation du rocher
	 */
	public static Animation getRocher() {
		if (AnimationManager.get(Assets.Rocher) == null) {
			Sprite spriteRocher = new Sprite("world");
			BufferedImage[] rocher = { 
					spriteRocher.getSprite(3, 0),
					spriteRocher.getSprite(3, 0), 
					spriteRocher.getSprite(3, 0),
					spriteRocher.getSprite(3, 0) };
			AnimationManager.put(Assets.Rocher,
					new Animation(rocher, Utils.VITESSE_ANIM));
		}
		AnimationManager.get(Assets.Rocher).start();
		return AnimationManager.get(Assets.Rocher);
	}

	/**
	 * Permet de récupérer l'animation du mur
	 * 
	 * @return l'animation du mur
	 */
	public static Animation getMur() {
		if (AnimationManager.get(Assets.Mur) == null) {
			Sprite spriteMur = new Sprite("world");
			BufferedImage[] wall = { spriteMur.getSprite(0, 0) };
			AnimationManager.put(Assets.Mur,
					new Animation(wall, Utils.VITESSE_ANIM));
		}
		return AnimationManager.get(Assets.Mur);
	}

	/**
	 * Permet de récupérer l'animation du mur magique
	 * 
	 * @return l'animation du mur magique
	 */
	public static Animation getMurMagique() {
		if (AnimationManager.get(Assets.Mur_Magique) == null) {
			Sprite spriteMurMagique = new Sprite("world");
			BufferedImage[] wall = { 
					spriteMurMagique.getSprite(8, 0),
					spriteMurMagique.getSprite(8, 1),
					spriteMurMagique.getSprite(8, 2),
					spriteMurMagique.getSprite(8, 3) };
			AnimationManager.put(Assets.Mur_Magique,
					new Animation(wall, Utils.VITESSE_ANIM));
		}
		AnimationManager.get(Assets.Mur_Magique).start();
		return AnimationManager.get(Assets.Mur_Magique);
	}

	/**
	 * Permet de récupérer l'animation de la sortie
	 * 
	 * @return l'animation de la sortie
	 */
	public static Animation getSortie() {
		if (AnimationManager.get(Assets.Sortie) == null) {
			Sprite spriteSortieO = new Sprite("world");
			BufferedImage[] sortieO = { 
					spriteSortieO.getSprite(6, 0),
					spriteSortieO.getSprite(6, 1),
					spriteSortieO.getSprite(6, 2),
					spriteSortieO.getSprite(6, 3) };
			AnimationManager.put(Assets.Sortie,
					new Animation(sortieO, Utils.VITESSE_ANIM));
		}
		AnimationManager.get(Assets.Sortie).start();
		return AnimationManager.get(Assets.Sortie);
	}

	/**
	 * Permet de récupérer l'animation du vide
	 * 
	 * @return l'animation du vide
	 */
	public static Animation getVide() {
		if (AnimationManager.get(Assets.Vide) == null) {
			Sprite spriteVide = new Sprite("world");
			BufferedImage[] dirtBack = { spriteVide.getSprite(2,0) };
			AnimationManager.put(Assets.Vide,
					new Animation(dirtBack, Utils.VITESSE_ANIM));
		}
		return AnimationManager.get(Assets.Vide);
	}

	/**
	 * Permet de récupérer l'animation du personnage
	 * 
	 * @param animation
	 *            choix de l'animation
	 * @return l'animation voulue du personnage
	 */
	public static Animation Personnage(Assets animation) {
		switch (animation) {
		case Personnage_Marche_Haut:
			return getPersonnageMarcheHaut();
		case Personnage_Marche_Bas:
			return getPersonnageMarcheBas();
		case Personnage_Marche_Gauche:
			return getPersonnageMarcheGauche();
		case Personnage_Marche_Droite:
			return getPersonnageMarcheDroite();
		case Personnage_Mort:
			return getPersonnageMort();
		case Personnage_Debout_Bas:
			return getPersonnageDeboutBas();
		case Personnage_Debout_Droite:
			return getPersonnageDeboutDroite();
		case Personnage_Debout_Gauche:
			return getPersonnageDeboutGauche();
		case Personnage_Debout_Haut:
			return getPersonnageDeboutHaut();
		// $CASES-OMITTED$
		default:
			return getPersonnageIdle();
		}
	}

	/**
	 * Met à jour toutes les animations du jeu
	 */
	public static void refreshAnim() {
		for (Assets anim : Assets.values()) {
			if (AnimationManager.get(anim) != null) {
				AnimationManager.get(anim).update();
			}
		}
	}
}
