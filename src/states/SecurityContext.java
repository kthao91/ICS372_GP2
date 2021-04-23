package states;

import display.SecurityDisplay;
import events.AwayRequestEvent;
import events.CancelRequestEvent;
import events.MotionButtonEvent;
import events.NumberButtonEvent;
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
 * The context is an observer for the clock and stores the context info for
 * states
 *
 */
public class SecurityContext {
    private SecurityDisplay display;
    private SecurityState currentState;
    private static SecurityContext instance;

    /**
     * Make it a singleton
     */
    private SecurityContext() {
        instance = this;
        currentState = ReadyState.instance();
    }

    /**
     * Return the instance
     * 
     * @return the object
     */
    public static SecurityContext instance() {
        if (instance == null) {
            instance = new SecurityContext();
        }
        return instance;
    }

    /**
     * The display could change. So we have to get its refrence.
     * 
     * @param display
     *            The current display object
     */
    public void setDisplay(SecurityDisplay display) {
        this.display = display;
    }

    /**
     * Lets door closed state be the starting state adds the object as an
     * observable for clock
     */
    public void initialize() {
        instance.changeState(ReadyState.instance());
    }

    /**
     * Called from the states to change the current state
     * 
     * @param nextState
     *            the next state
     */
    public void changeState(SecurityState nextState) {
        currentState.leave();
        currentState = nextState;
        currentState.enter();
    }
    
    public void handleEvent(AwayRequestEvent event) {
    	currentState.handleEvent(event);
    }
    
    public void handleEvent(StayRequestEvent event) {
    	currentState.handleEvent(event);
    }

    public void handleEvent(ZoneOneEvent event) {
        currentState.handleEvent(event);
    }
    
    public void handleEvent(ZoneTwoEvent event) {
        currentState.handleEvent(event);
    }
    
    public void handleEvent(ZoneThreeEvent event) {
        currentState.handleEvent(event);
    }
    
    public void handleEvent(MotionButtonEvent event) {
        currentState.handleEvent(event);
    }
    
    public void handleEvent(CancelRequestEvent event) {
        currentState.handleEvent(event);
    }
    
    public void handleEvent(NumberButtonEvent event, int number) {
        currentState.handleEvent(event, number);
    }
    
    public void showAwayTimeLeft(int time) {
    	display.showAwayTimeLeft(time);
    }
    
    public void showStayTimeLeft(int time) {
    	display.showStayTimeLeft(time);
    }
    
    public void showWarningTimeLeft(int time) {
    	display.showWarningTimeLeft(time);
    }
    
    public void showPasscodeInfo() {
    	display.showPasscodeInfo();
    }
    
    public void showPasscode(int time) {
    	display.showPasscode(time);
    }
    
    public void showReady() {
    	display.showReady();
    }
    
    public boolean testReady() {
    	return display.testReady();
    }
}