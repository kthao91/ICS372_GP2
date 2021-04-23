package states;

import timer.Notifiable;
import timer.Timer;
import events.CancelRequestEvent;
import events.MotionButtonEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;
import events.ZoneOneEvent;
import events.ZoneThreeEvent;
import events.ZoneTwoEvent;

public class AwayState extends SecurityState implements Notifiable {
	private static AwayState instance;
    private Timer timer;
    private int counterOne = 0;
    private int counterTwo = 0;
    private int counterThree = 0;
    
    /**
     * Private for the singleton pattern
     */
    private AwayState() {
    }

    /**
     * For singleton
     * 
     * @return the object
     */
    public static AwayState instance() {
        if (instance == null) {
            instance = new AwayState();
        }
        return instance;
    }
    
    @Override
	public void handleEvent(ZoneOneEvent event) {
    	counterOne++;
    	if(timer.getTimeValue()==0) {
    		SecurityContext.instance().changeState(WarningState.instance());
    	}
    }
    
    @Override
	public void handleEvent(ZoneTwoEvent event) {
    	counterTwo++;
    	if(timer.getTimeValue()==0) {
    		SecurityContext.instance().changeState(WarningState.instance());
    	}
    }
    
    @Override
	public void handleEvent(ZoneThreeEvent event) {
    	counterThree++;
    	if(timer.getTimeValue()==0) {
    		System.out.println("WarningState");
    		SecurityContext.instance().changeState(WarningState.instance());
    	}
    }
    
    @Override
	public void handleEvent(MotionButtonEvent event) {
    	if(timer.getTimeValue()==0) {
    		System.out.println("WarningState");
    		SecurityContext.instance().changeState(WarningState.instance());
    	}
    }
    
    @Override
    public void handleEvent(CancelRequestEvent event) {
    	if(timer.getTimeValue()==0) {
    		System.out.println("CancelState");
    		SecurityContext.instance().changeState(CancelState.instance());
    	}
    }
    
    /**
     * Process clock tick event
     */
    @Override
    public void handleEvent(TimerTickedEvent event) {
        SecurityContext.instance().showAwayTimeLeft(timer.getTimeValue());
    }

    /**
     * Process the timer runs out event
     */
    @Override
    public void handleEvent(TimerRanOutEvent event) {
    	if(counterOne%2!=0 || counterTwo%2!=0 || counterThree%2!=0) {
    		counterOne = 0;
    		counterTwo = 0;
    		counterThree = 0;
    		System.out.println("NotReadyState");
    		SecurityContext.instance().changeState(NotReadyState.instance());
    	}
    	else {
    		counterOne = 0;
    		counterTwo = 0;
    		counterThree = 0;
    		SecurityContext.instance().showAwayTimeLeft(0);
    	}
    }

	@Override
	public void enter() {
        timer = new Timer(this, 10);
        SecurityContext.instance().showAwayTimeLeft(timer.getTimeValue());
    }

	@Override
	public void leave() {
		timer.stop();
        timer = null;
	}

}
