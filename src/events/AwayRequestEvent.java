package events;

public class AwayRequestEvent {
    private static AwayRequestEvent instance;

    /**
     * Private for singleton
     * 
     */
    private AwayRequestEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static AwayRequestEvent instance() {
        if (instance == null) {
            instance = new AwayRequestEvent();
        }
        return instance;
    }
}