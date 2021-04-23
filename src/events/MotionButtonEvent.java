package events;

public class MotionButtonEvent {
	private static MotionButtonEvent instance;

    /**
     * Private for singleton
     * 
     */
    private MotionButtonEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static MotionButtonEvent instance() {
        if (instance == null) {
            instance = new MotionButtonEvent();
        }
        return instance;
    }
}

