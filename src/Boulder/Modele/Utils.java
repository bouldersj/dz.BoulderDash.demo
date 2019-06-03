package Boulder.Modele;

import java.awt.Color;

/***
 * 
 * @author liabe
 *
 */
public class Utils {

	public static final int HAUTEUR_PANEL_SCORE = 800;
	public static final int LARGEUR_PANEL_SCORE = 600;



	public static final int TAILLE_CASE = 16;

	public static final int FRAME = 60;
	public static final int CYCLES = 2;
	public static final int DELAI_IDLE = 2;

	public static final int PAS_MVT = TAILLE_CASE / CYCLES;
	public static final int VITESSE_ANIM = 1;
	public static final int VITESSE_IDLE = 1;

	public static final Color COULEUR_TEXTE = Color.decode("#FFFFFF");
	public static final String HELP = "the purpuse of the game is to get the maximum diamonds in a limited time,"
			+ " watch out Diamonds and boulder can fall into your head and you lose the game ";

}
