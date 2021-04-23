package states;

import timer.Notifiable;
import timer.Timer;
import events.NumberButtonEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;

public class WarningState extends SecurityState implements Notifiable{
	private static WarningState instance;
    private Timer timer;
    private String code = "";
    private String codeBreached = "";
    
    /**
     * Private for the singleton pattern
     */
    private WarningState() {
    }

    /**
     * For singleton
     * 
     * @return the object
     */
    public static WarningState instance() {
        if (instance == null) {
            instance = new WarningState();
        }
        return instance;
    }
    
    @Override
   	public void handleEvent(NumberButtonEvent event, int number) {
    	if(timer.getTimeValue()!=0) {
    		code += number;
    		if(code.equals("1234")) {
    			if(!SecurityContext.instance().testReady()) {
    	    		System.out.println("NotReadyState");
    	    		code = "";
    	    		SecurityContext.instance().changeState(NotReadyState.instance());
    	    	}
    	    	else {
    	    		System.out.println("ReadyState");
    	    		code = "";
    	    		SecurityContext.instance().changeState(ReadyState.instance());
    	    	}
    		}
    	}
    	else {
    		codeBreached += number;
    		if(codeBreached.equals("1234")) {
    			if(!SecurityContext.instance().testReady()) {
    	    		System.out.println("NotReadyState");
    	    		codeBreached = "";
    	    		SecurityContext.instance().changeState(NotReadyState.instance());
    	    	}
    	    	else {
    	    		System.out.println("ReadyState");
    	    		codeBreached = "";
    	    		SecurityContext.instance().changeState(ReadyState.instance());
    	    	}
    		}
    	}
    }
    
    @Override
    public void handleEvent(TimerTickedEvent event) {
        SecurityContext.instance().showWarningTimeLeft(timer.getTimeValue());
    }

    /**
     * Process the timer runs out event
     */
    @Override
    public void handleEvent(TimerRanOutEvent event) {
    	SecurityContext.instance().showWarningTimeLeft(0);
    }
    
	@Override
	public void enter() {
		timer = new Timer(this, 10);
        SecurityContext.instance().showWarningTimeLeft(timer.getTimeValue());
		
	}
	@Override
	public void leave() {
		timer.stop();
        timer = null;
		
	}

}
