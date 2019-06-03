package Boulder.Modele;

import java.io.File;




import java.util.Observable;

import javax.swing.JOptionPane;

import Boulder.Launcher;
import Boulder.Vue.Views;
/***
 * 
 * @author liabe
 *
 */
public class Game extends Observable {

	private GameState level;
	private String levelPath;
	private int score;
	private boolean pause;
	private boolean interuption;
	private boolean niveauFini;

	/**
	 * create a new game, with its score at 0 and level information at
	 * null
	 */
	public Game() {
		score = 0;
		levelPath = null;
		level = null;
	}
	/**
	 * loads a level located at the path path, initializes the game level data
	 * 
	 * @param path
	 *            way to the level
	 */
	public void chargerNiveau(String path) {
		deleteObservers();
		niveauFini = false;
		interuption = false;
		levelPath = path;
		level = new GameState(path);
	}
	/**
	 * allows you to recover the level of the game
	 * 
	 * @return level in the game
	 */
	public GameState getNiveau() {
		return level;
	}
	/**
	 * retrieve the list of levels
	 * 
	 * @return String[] list of levels
	 */
	public static String[] getListeNiveaux() {
		File f = new File("res/levels");
		File[] paths;

		String[] S = null;

		paths = f.listFiles();

		S = new String[paths.length];

		for (int i = 0; i < paths.length; i++) {
			S[i] = paths[i].toString();
		}
		return S;
	}

	/**
	 * Loop game, manage the game's progress
	 */
	public void gestion() {
		int i = 0;
		long time = System.currentTimeMillis();

		if (level == null) {
			return;
		}

		while (!level.isFini() && !interuption) {
			/*
			 *  measure the last run time and calculate the time waiting for this cycle
			 */
			time = Utils.FRAME + System.currentTimeMillis() - time;
			if (time <= 0) {
				time = 1;
			}
			/*
			 * cycle waiting time
			 */
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			time = System.currentTimeMillis();
			/*
			 * pause management
			 */
			if (!pause) {
				/*
				 * 	game update cycle management, run all X cycles
				 */
				if (i == 0) {
					try {
						level.refresh();
					} catch (NullPointerException e) {
						corruptedLevel();
						return;
					}
				}
				/*
				 * efresh animations of the game
				 */
				level.refreshAnim();

				i = (i + 1) % Utils.CYCLES;
				
				/*
				 * notification of changes to the window
				 */

				setChanged();
				notifyObservers();
			}
		}
		/*
		 * end game management
		 */
		Launcher.setState(State.MenuPrincipal);
		
		/*
		 * check if the game has been broken
		 */
		if (!interuption) {
			/*
			 *  	if the game has not been broken then we increment the score
			 */
			try {
				Thread.sleep(Utils.FRAME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			level.refreshAnim();
			niveauFini = true;
			int nScore = level.getTmax() + level.getScore();
			setChanged();
			notifyObservers();
			if (level.getPerso().isLife()) {
				score += nScore;
			} else {
				score = 0;
			}
		}
	}

	/**
	 * pause the game
	 */
	public void pauseOn() {
		pause = true;
	}

	/**
	 * break the pause
	 */
	public void pauseOff() {
		pause = false;
	}

	/**
	 * error message during a level crash
	 */
	private static void corruptedLevel() {
		JOptionPane.showMessageDialog(Launcher.getFen(), "Level Corumpt", "ERROR", JOptionPane.ERROR_MESSAGE);
		Launcher.getFen().changerVue(Views.MENUPRINCIPAL);
		Launcher.setState(State.MenuPrincipal);
	}

	/**
	 * redraw the current level, loss of the score on the current level
	 */
	public void restartLevel() {
		chargerNiveau(levelPath);
	}

	/**
	 * give the score to 0
	 */
	public void resetScore() {
		score = 0;
	}

	/**
	 * recovers the score of the level added to that of the game
	 */
	public int getScore() {
		return score + level.getScore();
	}

	/**
	 * interrupts the game (called by the menus when restarting or exiting the level)
	 */
	public void interompre() {
		interuption = true;
	}

	/**
	 * retrieve if level is finished
	 */
	public boolean isFini() {
		return niveauFini;
	}
}