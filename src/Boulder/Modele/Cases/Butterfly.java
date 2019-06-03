/**
 * 
 */
package Boulder.Modele.Cases;

import Boulder.Modele.GameState;


import Boulder.Modele.Animation.Animation;
import Boulder.Modele.Animation.AnimationManager;

/***
 * 
 * @author liabe
 *
 */
public class Butterfly extends Entity {
	Directions dirNav;
	boolean tempo;

	/**
	 * crée un papillon, initialise sa temporisation et sa direction de
	 * navigation
	 */
	public Butterfly(int x, int y) {
		super(x, y);
		dirNav = Directions.Haut;
		tempo = true;
	}

	/**
	 * mise à jour du papillon, gère les déplacements du papillon
	 */
	@Override
	public void refresh(GameState N) {
		if (!tempo) {
			switch (dirNav) {
			case Haut:
				navHaut(N);
				break;
			case Bas:
				navBas(N);
				break;
			case Gauche:
				navGauche(N);
				break;
			case Droite:
				navDroite(N);
				break;
			// $CASES-OMITTED$
			default:
				break;
			}
			tempo = true;
		} else {
			tempo = false;
		}
	}

	// fonctions de vérification de déplacement
	private boolean verifierHaut(GameState N) {
		return N.getCase(getX(), getY() - 1).IsEnemyComming(N);
	}

	private boolean verifierBas(GameState N) {
		return N.getCase(getX(), getY() + 1).IsEnemyComming(N);
	}

	private boolean verifierGauche(GameState N) {
		return N.getCase(getX() - 1, getY()).IsEnemyComming(N);
	}

	private boolean verifierDroite(GameState N) {
		return N.getCase(getX() + 1, getY()).IsEnemyComming(N);
	}

	// fonction de déplacement
	private void allerHaut(GameState N) {
		N.echangeCases(getX(), getY() - 1, getX(), getY());
		dirNav = Directions.Haut;
	}

	private void allerBas(GameState N) {
		N.echangeCases(getX(), getY() + 1, getX(), getY());
		dirNav = Directions.Bas;
	}

	private void allerGauche(GameState N) {
		N.echangeCases(getX(), getY(), getX() - 1, getY());
		dirNav = Directions.Gauche;
	}

	private void allerDroite(GameState N) {
		N.echangeCases(getX(), getY(), getX() + 1, getY());
		dirNav = Directions.Droite;
	}

	// gestion des ordres de vérification pour chaque direction de navigation
	private void navHaut(GameState N) {
		if (verifierGauche(N)) {
			allerGauche(N);
		} else if (verifierHaut(N)) {
			allerHaut(N);
		} else if (verifierDroite(N)) {
			allerDroite(N);
		} else {
			dirNav = Directions.Bas;
		}
	}

	private void navBas(GameState N) {

		if (verifierDroite(N)) {
			allerDroite(N);
		} else if (verifierBas(N)) {
			allerBas(N);
		} else if (verifierGauche(N)) {
			allerGauche(N);
		} else {
			dirNav = Directions.Haut;
		}
	}

	private void navGauche(GameState N) {

		if (verifierBas(N)) {
			allerBas(N);
		} else if (verifierGauche(N)) {
			allerGauche(N);
		} else if (verifierHaut(N)) {
			allerHaut(N);
		} else {
			dirNav = Directions.Droite;
		}
	}

	private void navDroite(GameState N) {
		if (verifierHaut(N)) {
			allerHaut(N);
		} else if (verifierDroite(N)) {
			allerDroite(N);
		} else if (verifierBas(N)) {
			allerBas(N);
		} else {
			dirNav = Directions.Gauche;
		}
	}

	/**
	 * retourne le sprite de papillon
	 */
	@Override
	public Animation getAnimation() {
		return AnimationManager.getPapillon();
	}

	/**
	 * écrase le papillon et fait apparaître des diamants autour de lui si le
	 * chutable est en état de chute
	 */
	@Override
	public ItemState IsItemsFalling(GameState N) {
		if (((MovableItems) N.getCase(getX(), getY() - 1)).chute()) {
			N.addToScore(100);
			for (int y = getY() - 1; y <= getY() + 1; y++) {
				for (int x = getX() - 1; x <= getX() + 1; x++) {
					N.remUptable(N.getCase(x, y));
					N.insereDiamant(x, y);
				}
			}
		}
		return ItemState.Stable;
	}

	@Override
	public String ID() {
		return "E";
	}

}
