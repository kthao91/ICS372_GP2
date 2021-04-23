package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecurityContext;
import events.CancelRequestEvent;

public class CancelButton extends GUIButton implements EventHandler<ActionEvent> {
    /**
     * The button for cooking
     * 
     * @param string
     */
    public CancelButton(String string) {
        super(string);
    }

    @Override
    public void handle(ActionEvent event) {
    	SecurityContext.instance().handleEvent(CancelRequestEvent.instance());
    }
}