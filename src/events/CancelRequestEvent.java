package events;

public class CancelRequestEvent {
	private static CancelRequestEvent instance;

    /**
     * Private for singleton
     * 
     */
    private CancelRequestEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static CancelRequestEvent instance() {
        if (instance == null) {
            instance = new CancelRequestEvent();
        }
        return instance;
    }
}