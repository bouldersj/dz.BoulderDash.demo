package Boulder;

import Boulder.Modele.State;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import Boulder.Modele.Game;
import Boulder.Vue.Display;
/**
 * 
 * @author Ali:liable , Nadjib, Saleh, Issa 
 *
 **/
public class Launcher {

	private static Game jeu;
	private static Display fen;
	private static State state;

	public static void main(String[] args) throws IOException, SQLException {
		
		Connect map = new Connect();
		Launcher.write(map.lvl4());
		Launcher.init();
		Launcher.Application();
		
	}

	private static void init() {
		state = State.MenuPrincipal;
		jeu = new Game();
		fen = new Display();
		fen.setLocationRelativeTo(null);
		fen.setVisible(true);

	}

	

	
	
	private static void Application() {
		while (true) {
			switch (state) {
			case Jeu:
				jeu.gestion();
				break;
			// $CASES-OMITTED$
			default:
				break;
			}

		}
	}

	
	
	public static void write(String lvl) throws IOException, SQLException {
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("res/levels/world.csv")); 
	
		writer.write(lvl);

		writer.close();
	
		
		
	}


	public static Game getJeu() {
		return jeu;
	}


	public static Display getFen() {
		return fen;
	}


	public static void setState(State state) {
		Launcher.state = state;
	}
}
