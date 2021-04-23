package states;

import events.AwayRequestEvent;
import events.StayRequestEvent;
import events.ZoneOneEvent;
import events.ZoneThreeEvent;
import events.ZoneTwoEvent;

/**
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 
 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - the use is for academic purpose only
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Neither the name of Brahma Dathan or Sarnath Ramnath
 *     may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in this module
 * and are not responsible for any loss or damage resulting from its use.  
 */

/**
 * Represents the cooking state.
 *
 */
public class ReadyState extends SecurityState{
    private static ReadyState instance;

    /**
     * Private for the singleton pattern
     */
    private ReadyState() {
    }

    /**
     * For singleton
     * 
     * @return the object
     */
    public static ReadyState instance() {
        if (instance == null) {
            instance = new ReadyState();
        }
        return instance;
    }
    
    @Override
	public void handleEvent(AwayRequestEvent event) {
    	System.out.println("AwayState");
        SecurityContext.instance().changeState(AwayState.instance());
    }
    
    @Override
	public void handleEvent(StayRequestEvent event) {
    	System.out.println("StayState");
        SecurityContext.instance().changeState(StayState.instance());
    }
    
    @Override
	public void handleEvent(ZoneOneEvent event) {
    	System.out.println("NotReadyState");
        SecurityContext.instance().changeState(NotReadyState.instance());
    }
    
    @Override
	public void handleEvent(ZoneTwoEvent event) {
    	System.out.println("NotReadyState");
        SecurityContext.instance().changeState(NotReadyState.instance());
    }
    
    @Override
	public void handleEvent(ZoneThreeEvent event) {
    	System.out.println("NotReadyState");
        SecurityContext.instance().changeState(NotReadyState.instance());
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