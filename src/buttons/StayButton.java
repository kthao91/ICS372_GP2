package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecurityContext;
import events.StayRequestEvent;

public class StayButton extends GUIButton implements EventHandler<ActionEvent> {
    /**
     * The button for cooking
     * 
     * @param string
     */
    public StayButton(String string) {
        super(string);
    }

    @Override
    public void handle(ActionEvent event) {
    	SecurityContext.instance().handleEvent(StayRequestEvent.instance());
    }
}