package events;

public class StayRequestEvent {
    private static StayRequestEvent instance;

    /**
     * Private for singleton
     * 
     */
    private StayRequestEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static StayRequestEvent instance() {
        if (instance == null) {
            instance = new StayRequestEvent();
        }
        return instance;
    }
}