package events;

public class WarningRequestEvent {
	private static WarningRequestEvent instance;

    /**
     * Private for singleton
     * 
     */
    private WarningRequestEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static WarningRequestEvent instance() {
        if (instance == null) {
            instance = new WarningRequestEvent();
        }
        return instance;
    }
}
