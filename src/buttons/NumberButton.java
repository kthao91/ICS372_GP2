package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecurityContext;
import events.NumberButtonEvent;

public class NumberButton extends GUIButton implements EventHandler<ActionEvent> {
	
	String number = "";
    /**
     * The button for cooking
     * 
     * @param string
     */
    public NumberButton(String string) {
        super(string);
        number = string;
    }

    @Override
    public void handle(ActionEvent event) {
    	SecurityContext.instance().handleEvent(NumberButtonEvent.instance(), Integer.parseInt(number));
    }
}