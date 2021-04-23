package events;

/**
 * Represents the door close operation
 *
 */
public class ZoneThreeEvent {
    private static ZoneThreeEvent instance;

    /**
     * Private for singleton
     * 
     */
    private ZoneThreeEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static ZoneThreeEvent instance() {
        if (instance == null) {
            instance = new ZoneThreeEvent();
        }
        return instance;
    }
}