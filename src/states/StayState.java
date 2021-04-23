package states;

import timer.Notifiable;
import timer.Timer;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;

public class StayState extends SecurityState implements Notifiable{
	private static StayState instance;
    private Timer timer;
    
    /**
     * Private for the singleton pattern
     */
    private StayState() {
    }

    /**
     * For singleton
     * 
     * @return the object
     */
    public static StayState instance() {
        if (instance == null) {
            instance = new StayState();
        }
        return instance;
    }
    
    /**
     * Process clock tick event
     */
    @Override
    public void handleEvent(TimerTickedEvent event) {
        SecurityContext.instance().showStayTimeLeft(timer.getTimeValue());
    }

    /**
     * Process the timer runs out event
     */
    @Override
    public void handleEvent(TimerRanOutEvent event) {
        SecurityContext.instance().showStayTimeLeft(0);
    }

	@Override
	public void enter() {
        timer = new Timer(this, 10);
        SecurityContext.instance().showStayTimeLeft(timer.getTimeValue());
    }

	@Override
	public void leave() {
		timer.stop();
        timer = null;
		SecurityContext.instance().showReady();
		
	}
}
