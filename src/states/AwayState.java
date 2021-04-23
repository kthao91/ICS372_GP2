package states;

import timer.Notifiable;
import timer.Timer;
import events.CancelRequestEvent;
import events.MotionButtonEvent;
import events.NumberButtonEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;
import events.ZoneOneEvent;
import events.ZoneThreeEvent;
import events.ZoneTwoEvent;

public class AwayState extends SecurityState implements Notifiable {
	private static AwayState instance;
	private Timer timer;
	private int redoPassword = 1;
	private String code = "";
	private boolean counterBoolean = false;

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
	public void handleEvent(NumberButtonEvent event, int number) {
		if (counterBoolean == true) {
			code += number;
			SecurityContext.instance().showPasscode(number);
			if (code.equals("1234")) {
				counterBoolean = false;
				redoPassword = 1;
				if (!SecurityContext.instance().testReady()) {
					System.out.println("NotReadyState");
					code = "";
					SecurityContext.instance().changeState(
							NotReadyState.instance());
				} else {
					System.out.println("ReadyState");
					code = "";
					SecurityContext.instance().changeState(
							ReadyState.instance());
				}
			}
		}
		if (code.length() == 4 && !code.equals("1234")) {
			SecurityContext.instance().showPasscodeCancelRedo(redoPassword);
			redoPassword++;
			code = "";
		}

	}

	@Override
	public void handleEvent(ZoneOneEvent event) {
		if (timer.getTimeValue() == 0 && counterBoolean == false
				&& !SecurityContext.instance().testReady()) {
			SecurityContext.instance().changeState(WarningState.instance());
		}
	}

	@Override
	public void handleEvent(ZoneTwoEvent event) {
		if (timer.getTimeValue() == 0 && counterBoolean == false
				&& !SecurityContext.instance().testReady()) {
			SecurityContext.instance().changeState(WarningState.instance());
		}
	}

	@Override
	public void handleEvent(ZoneThreeEvent event) {
		if (timer.getTimeValue() == 0 && counterBoolean == false
				&& !SecurityContext.instance().testReady()) {
			SecurityContext.instance().changeState(WarningState.instance());
		}
	}

	@Override
	public void handleEvent(MotionButtonEvent event) {
		if (timer.getTimeValue() == 0 && counterBoolean == false
				&& SecurityContext.instance().testReady()) {
			System.out.println("WarningState");
			SecurityContext.instance().changeState(WarningState.instance());
		}
	}

	@Override
	public void handleEvent(CancelRequestEvent event) {
		if (timer.getTimeValue() == 0 && counterBoolean == false) {
			counterBoolean = true;
			SecurityContext.instance().showPasscodeInfo();
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
		if (!SecurityContext.instance().testReady()) {
			SecurityContext.instance().changeState(NotReadyState.instance());
		} else {
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
