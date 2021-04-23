package states;

import timer.Notifiable;
import timer.Timer;
import events.NumberButtonEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;

public class WarningState extends SecurityState implements Notifiable {
	private static WarningState instance;
	private Timer timer;
	private int incorrectAttempts = 0;
	private String code = "";

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
	public void handleEvent(NumberButtonEvent event, int inputCode) {
		code += inputCode;
		if (code.equals("1234")) {
			incorrectAttempts = 0;
			if (!SecurityContext.instance().testReady()) {
				System.out.println("NotReadyState");
				code = "";
				SecurityContext.instance().changeState(NotReadyState.instance());
			} else {
				System.out.println("ReadyState");
				code = "";
				SecurityContext.instance().changeState(ReadyState.instance());
			}
		}
		if (code.length() == 4 && !code.equals("1234")) {
			incorrectAttempts++;
			SecurityContext.instance().showWarningTimeLeft(timer.getTimeValue(), incorrectAttempts);
			code = "";
		}
	}

	@Override
	public void handleEvent(TimerTickedEvent event) {
		SecurityContext.instance().showWarningTimeLeft(timer.getTimeValue(), incorrectAttempts);
	}

	/**
	 * Process the timer runs out event
	 */
	@Override
	public void handleEvent(TimerRanOutEvent event) {
		incorrectAttempts = 0;
		SecurityContext.instance().showWarningTimeLeft(0);
	}

	@Override
	public void enter() {
		timer = new Timer(this, 15);
		SecurityContext.instance().showWarningTimeLeft(timer.getTimeValue(), incorrectAttempts);

	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}
}
