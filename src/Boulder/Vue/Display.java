package Boulder.Vue;

import javax.swing.JFrame;
import javax.swing.JPanel;


/***
 * 
 * @author liabe
 *
 */

/**
 * Main window
 */
public class Display extends JFrame {
	private static final long serialVersionUID = 3393452907097178193L;


	/**
	 * Displayed panel
	 */
	private JPanel display;

	/**
	 * Initializing the window
	 */
	public Display() {
		super("Boulder Dash");
		display = new Menue();
		add(display);
		setLocationRelativeTo(null);
		display.grabFocus();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();

	}

	/**
	 * Allow to change the view by editing the displayed panel
	 * 
	 * @param vue
	 *            the new displayed panel
	 * @param delaiFrame
	 *            frame loading time
	 */
	public void changerVue(Views vue) {
		remove(display);

		switch (vue) {
		case MENUPRINCIPAL:
			display = new Menue();

			break;
		case MENUCHOIXNIVEAU:
			display = new LevelOptions();

			break;
		case TABLEAUJEU:
			display = new GameArea();

			break;
		default:
			display = new Menue();

			break;
		}
		add(display);
		display.grabFocus();
		pack();
	}

	/**
	 * Current view recovering the focus
	 */
	public void refocus() {
		display.grabFocus();
	}

}
