package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecurityContext;
import events.MotionButtonEvent;

public class MotionButton extends GUIButton implements EventHandler<ActionEvent> {
	
	String number = "";
    /**
     * The button for cooking
     * 
     * @param string
     */
    public MotionButton(String string) {
        super(string);
        number = string;
    }

    @Override
    public void handle(ActionEvent event) {
    	SecurityContext.instance().handleEvent(MotionButtonEvent.instance());
    }
}