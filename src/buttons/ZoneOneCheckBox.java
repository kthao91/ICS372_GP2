package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecurityContext;
import events.ZoneOneEvent;

/**
 * The button for cook request
 * 
 * @author Brahma Dathan
 *
 */
public class ZoneOneCheckBox extends GUICheckBox implements EventHandler<ActionEvent> {
    /**
     * The button for cooking
     * 
     * @param string
     */
    public ZoneOneCheckBox(String string) {
        super(string);
    }

    @Override
    public void handle(ActionEvent event) {
    	SecurityContext.instance().handleEvent(ZoneOneEvent.instance());
    }
}