package states;

import events.NumberButtonEvent;


public class CancelState extends SecurityState{
	private static CancelState instance;
    private String code = "";
    
    /**
     * Private for the singleton pattern
     */
    private CancelState() {
    }

    /**
     * For singleton
     * 
     * @return the object
     */
    public static CancelState instance() {
        if (instance == null) {
            instance = new CancelState();
        }
        return instance;
    }
    
    @Override
   	public void handleEvent(NumberButtonEvent event, int number) {
    	code += number;
    	SecurityContext.instance().showPasscode(number);
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

	@Override
	public void enter() {
		SecurityContext.instance().showPasscodeInfo();
		
	}

	@Override
	public void leave() {
		SecurityContext.instance().showReady();
		
	}
}
