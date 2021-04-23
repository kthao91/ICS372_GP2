package states;

import events.AwayRequestEvent;
import events.CancelRequestEvent;
import events.MotionButtonEvent;
import events.NumberButtonEvent;
import events.StayRequestEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;
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
 * Super class for all states
 * 
 *
 */
public abstract class SecurityState {

    /**
     * Initializes the state
     */
    public abstract void enter();

    /**
     * Performs any necessary clean up while leaving the state
     */
    public abstract void leave();

    public void handleEvent(AwayRequestEvent event) {
    	
    }
    
    public void handleEvent(StayRequestEvent event) {
    	
    }
    
    public void handleEvent(NumberButtonEvent event, int number) {
    	
    }
    
    /**
     * Specifies the actions to be taken when the Cook button is pressed.
     */
    public void handleEvent(ZoneOneEvent event) {

    }

    /**
     * Process door open request
     */
    public void handleEvent(ZoneTwoEvent event) {

    }

    /**
     * Process door close request
     */
    public void handleEvent(ZoneThreeEvent event) {

    }

    public void handleEvent(MotionButtonEvent event) {
    	
    }
    
    public void handleEvent(CancelRequestEvent event) {
    	
    }
    
    /**
     * Process clock tick Generates the timer runs out event
     */
    public void handleEvent(TimerTickedEvent event) {

    }

    /**
     * Process clock ticks Generates the timer runs out event
     */
    public void handleEvent(TimerRanOutEvent event) {

    }

}