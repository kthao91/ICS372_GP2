package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecurityContext;
import events.AwayRequestEvent;

/**
 * This
 * 
 * @author Koua
 *
 */
public class AwayButton extends GUIButton implements EventHandler<ActionEvent> {

	public AwayButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		SecurityContext.instance().handleEvent(AwayRequestEvent.instance());
	}
}