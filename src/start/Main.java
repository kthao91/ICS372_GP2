package start;

import javafx.application.Application;
import states.SecurityContext;
import timer.Clock;
import display.GUIDisplay;
import display.SecurityDisplay;

/**
 * This Class is to start the security program. This class start application
 * will be up until the display is closed
 * 
 * @author Group 7
 *
 */
public class Main {
	public static void main(String[] args) {
		Clock.instance();
		new Thread() {
			@Override
			public void run() {
				Application.launch(GUIDisplay.class);
			}
		}.start();
		try {
			while (GUIDisplay.getInstance() == null) {
				Thread.sleep(1000);
			}
		} catch (Exception ie) {
		}
		SecurityDisplay display = GUIDisplay.getInstance();
		SecurityContext.instance().setDisplay(display);
	}
}
