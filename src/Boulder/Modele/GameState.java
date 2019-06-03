package Boulder.Modele;

import java.io.BufferedReader;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Boulder.Modele.Animation.AnimationManager;
import Boulder.Modele.Cases.Dirt;
import Boulder.Modele.Cases.Entity;
import Boulder.Modele.Cases.MovableItems;
import Boulder.Modele.Cases.Diamonds;
import Boulder.Modele.Cases.IndestructibleWall;
import Boulder.Modele.Cases.Butterfly;
import Boulder.Modele.Cases.Player;
import Boulder.Modele.Cases.Wall;
import Boulder.Modele.Cases.Boulder;
import Boulder.Modele.Cases.ExitDoor;
import Boulder.Modele.Cases.DirtBackGround;


/**
 * *
 * @author liabe
 *
 */
/**
 * Level class, describes a complete level, 

 * the level is made up of a Bidimentional array of Cases, 
 * and a refreshment table
 * 
 * @see Entity
 * 
 */
public class GameState {
	// Variables
	private int hauteur;
	private int longueur;
	private int dscore;
	private int score;
	private float tmax;
	private boolean fini;
	private Player perso;
	private ExitDoor sortie;

	/**
	 * level grid table
	 */
	private Entity[][] tableau;

	/**
	 * update table, 
	 * contains the cases that can be modified in the next cycle
	 */
	private List<Entity> UpTable;

	/**
	 * Creates a Level of 60 * 40 with the character at the top left and the exit at the bottom right
	 * 
	 */
	public GameState() {
		this(60, 40);
	}

	/**
	 * creates a new level from a saved level
	 */
	public GameState(String path) {
		UpTable = new ArrayList<>();
		fini = false;
		score = 0;
		importer(path);
	}

	/**
	 * creates a level of l*h filled with mud and with a border of Wall Indestructible
	 * 
	 * 
	 * @param l
	 *            level length
	 * @param h
	 *            level height
	 * @see Dirt
	 * @see IndestructibleWall
	 * 
	 */
	public GameState(int l, int h) {
		int x, y;

		tableau = new Entity[l][h];
		UpTable = new ArrayList<>();
		hauteur = h;
		longueur = l;
		fini = false;
		dscore = 1;

		/**
		 * 	level filling
		 */
		for (y = 0; y < h; y++) {
			if (y == 0 || y == (h - 1)) {
				for (x = 0; x < l; x++) {
					insereMurIndestructible(x, y);
				}
			} else {
				insereMurIndestructible(0, y);
				for (x = 1; x < (l - 1); x++) {
					insereBoue(x, y);
				}
				insereMurIndestructible(l - 1, y);
			}
		}
	}

	/**
	 * insert the character in the level at the position indicated in argument
	 * if a character is already present then he is exchanged with his new position
	 * 
	 * @param x
	 *            x position of the character
	 * @param y
	 *            y position of the character
	 */
	public void inserePersonage(int x, int y) {
		if (x > 0 && x < longueur - 1 && y > 0 && y < hauteur - 1) {
			if (perso == null) {
				perso = new Player(x, y);
				tableau[x][y] = perso;
			} else {
				echangeCases(perso.getX(), perso.getY(), x, y);
			}

		}
	}

	/**
	 * inserts the exit of the level at the position indicated in argument;
	 * if it already exists, it is transferred to the new position
	 * 
	 * @param x
	 *            x position of the exit
	 * @param y
	 *            y position of the exit
	 */
	public void insereSortie(int x, int y) {
		if (x > 0 && x < longueur - 1 && y > 0 && y < hauteur - 1) {
			if (sortie == null) {
				sortie = new ExitDoor(x, y);
				if (perso != null && tableau[x][y] == perso) {
					perso = null;
				}
				tableau[x][y] = sortie;
			} else {
				echangeCases(sortie.getX(), sortie.getY(), x, y);
			}
		}
	}

	/**
	 * insert black dirt at the position indicated as argument
	 * 
	 * @param x
	 *            position in x
	 * @param y
	 *            position in y
	 */
	public void insereVide(int x, int y) {
		if (x > 0 && x < longueur - 1 && y > 0 && y < hauteur - 1
				&& (tableau[x][y] == null || (tableau[x][y] != perso
						&& tableau[x][y] != sortie))) {
			tableau[x][y] = new DirtBackGround(x, y);
		}
	}

	/**
	 * insert mud at the position indicated as an argument
	 * 
	 * @param x
	 *            position in x
	 * @param y
	 *            position in y
	 */
	public void insereBoue(int x, int y) {
		if (x > 0 && x < longueur - 1 && y > 0 && y < hauteur - 1
				&& (tableau[x][y] == null || (tableau[x][y] != perso
						&& tableau[x][y] != sortie))) {
			tableau[x][y] = new Dirt(x, y);
		}
	}

	/**
	 * inserts an indestructible wall at the position specified as an argument
	 * 
	 * @param x
	 *            position in x
	 * @param y
	 *            position in y
	 */
	public void insereMurIndestructible(int x, int y) {
		if (x >= 0 && x < longueur && y >= 0 && y < hauteur
				&& (tableau[x][y] == null || (tableau[x][y] != perso
						&& tableau[x][y] != sortie))) {
			tableau[x][y] = new IndestructibleWall(x, y);
		}
	}
	public void insereMurNormal(int x, int y) {
		if (x > 0 && x < longueur - 1 && y > 0 && y < hauteur - 1
				&& (tableau[x][y] == null || (tableau[x][y] != perso
						&& tableau[x][y] != sortie))) {
			tableau[x][y] = new Wall(x, y);
		}
	}

	/**
	 * insert a boulder at the position indicated as an argument and add it to
	 * the UpTable
	 * 
	 * @param x
	 *            position in x
	 * @param y
	 *            position in y
	 */
	public void insereRocher(int x, int y) {
		if (x > 0 && x < longueur - 1 && y > 0 && y < hauteur - 1
				&& (tableau[x][y] == null || (tableau[x][y] != perso
						&& tableau[x][y] != sortie))) {
			tableau[x][y] = new Boulder(x, y);
			UpTable.add(tableau[x][y]);
		}
	}

	/**
	 * insert a diamond at the position indicated in the argument and add it in the UpTable
	 * 
	 * @param x
	 *            position in x
	 * @param y
	 *            position in y
	 */
	public void insereDiamant(int x, int y) {
		if (x > 0 && x < longueur - 1 && y > 0 && y < hauteur - 1
				&& (tableau[x][y] == null || (tableau[x][y] != perso
						&& tableau[x][y] != sortie))) {
			tableau[x][y] = new Diamonds(x, y);
			UpTable.add(tableau[x][y]);
		}
	}
	/**
	 * insert a butterfly at the position indicated in argument and add it in the UpTable
	 * 
	 * @param x
	 *            position in x
	 * @param y
	 *            position in y
	 */
	public void inserePapillon(int x, int y) {
		if (x > 0 && x < longueur - 1 && y > 0 && y < hauteur - 1
				&& (tableau[x][y] == null || (tableau[x][y] != perso
						&& tableau[x][y] != sortie))) {
			tableau[x][y] = new Butterfly(x, y);
			UpTable.add(tableau[x][y]);
		}
	}

	/**
	 *	level update function, 
	 *	update all Cases likely to be updated in the level, 
	 * open the exit door if the conditions are met
	 */
	public void refresh() {
		tmax = tmax - Utils.CYCLES * Utils.FRAME / (float) 1000;
		int i = 0;
		perso.refresh(this);
		trieUpTable();
		while (i < UpTable.size()) {
			UpTable.get(i).refresh(this);
			i++;
		}
		cleanUpTable();
		if (!sortie.isOuverte() && dscore <= 0) {
			sortie.Ouvrir();
		}
	}

	/**
	 * show a level in text 
	 *
	public void afficheDebug() {
		int x, y;
		for (y = 0; y < hauteur; y++) {
			for (x = 0; x < longueur; x++) {
				System.out.print(tableau[x][y].ID() + " ");
			}
			System.out.print("\n");
		}
		System.out.print(UpTable.size());
		System.out.println(UpTable.toString());
		System.out.println("diamond :" + dscore);
	} */

	
	/*
	 * 
	 */
	public Entity getCase(int x, int y) {
		if (x >= 0 && x < longueur && y >= 0 && y < hauteur) {
			return tableau[x][y];
		} else {
			return null;
		}
	}

	/**
	 * get the character
	 */
	public Player getPerso() {
		return perso;
	}

	/**
	 * get the exit
	 */
	public ExitDoor getSortie() {
		return sortie;
	}

	/**
	 * Changes the two boxes to the positions that are passed in parameters
	 */
	public void echangeCases(int x1, int y1, int x2, int y2) {
		Entity temp = tableau[x1][y1];
		tableau[x1][y1] = tableau[x2][y2];
		tableau[x2][y2] = temp;
		tableau[x1][y1].setXY(x1, y1);
		tableau[x2][y2].setXY(x2, y2);
	}

	/**
	 * add in the update table the case whose position is transmitted
	 * 
	 * @param x
	 * @param y
	 */
	public void addUptable(int x, int y) {
		if (!UpTable.contains(tableau[x][y]) && tableau[x][y] != perso
				&& tableau[x][y] != sortie) {
			UpTable.add(UpTable.size(), tableau[x][y]);
		}
	}

	/**
	 * 
	 *add in the update table the boxes in the rectangle of 2 * 3 above the transmitted position
	 *
	 */
	public void remplirUpTable(int x, int y) {
		addUptable(x, y - 1);
		addUptable(x + 1, y - 1);
		addUptable(x - 1, y - 1);
		addUptable(x + 1, y);
		addUptable(x - 1, y);
	}

	/**
	 * sorts the update table, the lower boxes take precedence over the highest ones
	 */
	public void trieUpTable() {
		int i = 0;
		int j, pmin;
		Entity temp;

		while (i < UpTable.size() - 1) {
			pmin = i;
			j = i + 1;
			while (j < UpTable.size()) {
				if (UpTable.get(j).isSuperior(UpTable.get(pmin))) {
					pmin = j;
				}
				j++;
			}
			temp = UpTable.set(i, UpTable.get(pmin));
			UpTable.set(pmin, temp);
			i++;
		}
	}

	/**
	 * clean up the Updatetable of the elements that do not move 
	 */
	public void cleanUpTable() {
		int i = 0;
		while (i < UpTable.size()) {
			if ((UpTable.get(i).stayInUpTable())
					&& !((MovableItems) UpTable.get(i)).instable()) {
				UpTable.remove(i);
			} else {
				i++;
			}
		}
	}

	/**
	 * remove from the update table the box passed in parameter
	 */
	public void remUptable(Entity C) {
		UpTable.remove(C);
	}

	/**
	 * retrieves the update table in a table
	 */
	public Entity[] getUpTable() {
		return (Entity[]) UpTable.toArray();
	}

	/**
	 * retrieve if the level is finished
	 */
	public boolean isFini() {
		return fini;
	}

	/**
	 * puts the level to the finished state , end game
	 */
	public void setFini() {
		fini = true;
	}
	/**
	 * Decreases the number of diamonds to find
	 */
	public void AddDscore() {
		dscore--;
	}

	/**
	 * 
	 * get the height of the level
	 * @return height
	 */
	public int getHauteur() {
		return hauteur;
	}
	/**
	 * set the height of the level
	 */
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	/**
	 * retrieves the length of the level
	 */
	public int getLongueur() {
		return longueur;
	}

	/**
	 * set the length of the level
	 */
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	/**
	 * set the number of diamonds needed to finish the level
	 */
	public void setDscore(int dscore) {
		this.dscore = dscore;
	}

	/**
	 * recovers the number of diamonds needed to finish the level,
	 *  returns 0 if negative
	 */
	public int getDscore() {
		if (dscore < 0) {
			return 0;
		}
		return dscore;
	}

	/**
	 * import the level in csv which is at the specified path
	 */
	@SuppressWarnings("resource")
	public void importer(String niveau) {
		String ligne = "";
		String separateur = ",";
		BufferedReader br = null;

		try {
			int x, y;
			br = new BufferedReader(new FileReader(niveau));

			if ((ligne = br.readLine()) != null) {
				String[] propriete = ligne.split(separateur);

				longueur = Integer.parseInt(propriete[1]);
				hauteur = Integer.parseInt(propriete[2]);

				tableau = new Entity[longueur][hauteur];

				for (y = 0; y < hauteur; y++) {
					ligne = br.readLine();
					String[] cases = ligne.split(separateur);

					for (x = 0; x < longueur; x++) {
						switch (cases[x]) {
						case "M":
							insereMurIndestructible(x, y);
							break;
						case "N":
							insereMurNormal(x, y);
							break;
						case "P":
							inserePersonage(x, y);
							break;
						case "S":
							insereSortie(x, y);
							break;
						case "B":
							insereBoue(x, y);
							break;
						case "D":
							insereDiamant(x, y);
							break;
						case "R":
							insereRocher(x, y);
							break;
						case "E":
							inserePapillon(x, y);
							break;
						default:
							insereVide(x, y);
							break;
						}
					}
				}
				try {
					ligne = br.readLine();
					propriete = ligne.split(separateur);
					dscore = Integer.parseInt(propriete[1]);
				} catch (NullPointerException e) {
					dscore = 0;
				}
				try {
					ligne = br.readLine();
					propriete = ligne.split(separateur);
					tmax = Float.parseFloat(propriete[1]);
				} catch (NullPointerException e) {
					tmax = 120;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * update the animation table and the type of animation of the character
	 */
	public void refreshAnim() {
		perso.refreshAnim();
		AnimationManager.refreshAnim();
	}

	/**
	 * Retrieves the player's remaining bonus time, returns 0 if negative
	 */
	public int getTmax() {
		if (tmax < 0) {
			return 0;
		}
		return (int) tmax;
	}
	/**
	 * set the bonus time of the level
	 */
	public void setTmax(int tmax) {
		this.tmax = tmax;
	}

	/**
	 * add the value passed as a parameter to the score
	 */
	public void addToScore(int value) {
		score += value;
	}


	/**
	 * retrieves the level score
	 */
	public int getScore() {
		return score;
	}

}
