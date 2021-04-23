package events;

public class NumberButtonEvent {
	private static NumberButtonEvent instance;

    /**
     * Private for singleton
     * 
     */
    private NumberButtonEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static NumberButtonEvent instance() {
        if (instance == null) {
            instance = new NumberButtonEvent();
        }
        return instance;
    }
}