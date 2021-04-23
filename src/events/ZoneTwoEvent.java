package events;

/**
 * Represents the door open operation
 *
 */
public class ZoneTwoEvent {
    private static ZoneTwoEvent instance;

    /**
     * Private for singleton
     * 
     */
    private ZoneTwoEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static ZoneTwoEvent instance() {
        if (instance == null) {
            instance = new ZoneTwoEvent();
        }
        return instance;
    }
}