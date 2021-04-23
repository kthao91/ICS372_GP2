package states;

import events.ZoneOneEvent;
import events.ZoneThreeEvent;
import events.ZoneTwoEvent;

public class NotReadyState extends SecurityState{
	private static NotReadyState instance;
	
	 /**
     * Private for the singleton pattern
     */
    private NotReadyState() {
    }

    /**
     * For singleton
     * 
     * @return the object
     */
    public static NotReadyState instance() {
        if (instance == null) {
            instance = new NotReadyState();
        }
        return instance;
    }
    
    @Override
	public void handleEvent(ZoneOneEvent event) {
    	if(!SecurityContext.instance().testReady()) {
    		System.out.println("NotReadyState");
    		SecurityContext.instance().changeState(NotReadyState.instance());
    	}
    	else {
    		System.out.println("ReadyState");
    		SecurityContext.instance().changeState(ReadyState.instance());
    	}
    }
    
    @Override
	public void handleEvent(ZoneTwoEvent event) {
    	if(!SecurityContext.instance().testReady()) {
    		System.out.println("NotReadyState");
    		SecurityContext.instance().changeState(NotReadyState.instance());
    	}
    	else {
    		System.out.println("ReadyState");
    		SecurityContext.instance().changeState(ReadyState.instance());
    	}
    }
    
    @Override
	public void handleEvent(ZoneThreeEvent event) {
    	if(!SecurityContext.instance().testReady()) {
    		System.out.println("NotReadyState");
    		SecurityContext.instance().changeState(NotReadyState.instance());
    	}
    	else {
    		System.out.println("ReadyState");
    		SecurityContext.instance().changeState(ReadyState.instance());
    	}
    }

	@Override
	public void enter() {
		SecurityContext.instance().showReady();
		
	}

	@Override
	public void leave() {
		SecurityContext.instance().showReady();
		
	}

}
