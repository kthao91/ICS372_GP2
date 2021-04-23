package events;

/**
 * Represents the cook request
 *
 */
public class ZoneOneEvent{
    private static ZoneOneEvent instance;

    /**
     * Private for singleton
     * 
     */
    private ZoneOneEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static ZoneOneEvent instance() {
        if (instance == null) {
            instance = new ZoneOneEvent();
        }
        return instance;
    }
}