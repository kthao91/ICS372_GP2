package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;

/**
 * The abstract GUI JButton object. Helps to get rid of conditionals
 *
 */
public abstract class GUICheckBox extends CheckBox implements EventHandler<ActionEvent> {
    /**
     * Create the button with the proper text. Makes the button a listener to
     * clicks on itself.
     * 
     * @param string
     *            the text
     */

    public GUICheckBox(String string) {
        super(string);
        setOnAction(this);
    }

}