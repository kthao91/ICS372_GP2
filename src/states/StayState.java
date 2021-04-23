package states;

import timer.Notifiable;
import timer.Timer;
import events.CancelRequestEvent;
import events.NumberButtonEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;
import events.ZoneOneEvent;
import events.ZoneThreeEvent;
import events.ZoneTwoEvent;

public class StayState extends SecurityState implements Notifiable {
	private static StayState instance;
	private Timer timer;
	private String code = "";
	private int redoPasswordOne = 1;
	private int redoPasswordTwo = 1;
	private String codeBreached = "";
	private boolean counterBooleanOne = false;
	private boolean counterBooleanTwo = false;

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

	@Override
	public void handleEvent(ZoneOneEvent event) {
		if (timer.getTimeValue() == 0 && counterBooleanOne == false
				&& counterBooleanTwo == false
				&& !SecurityContext.instance().testReady()) {
			SecurityContext.instance().showWarningTimeLeft(0);
			counterBooleanOne = true;
		}
	}

	@Override
	public void handleEvent(ZoneTwoEvent event) {
		if (timer.getTimeValue() == 0 && counterBooleanOne == false
				&& counterBooleanTwo == false
				&& !SecurityContext.instance().testReady()) {
			SecurityContext.instance().showWarningTimeLeft(0);
			counterBooleanOne = true;
		}
	}

	@Override
	public void handleEvent(ZoneThreeEvent event) {
		if (timer.getTimeValue() == 0 && counterBooleanOne == false
				&& counterBooleanTwo == false
				&& !SecurityContext.instance().testReady()) {
			SecurityContext.instance().showWarningTimeLeft(0);
			counterBooleanOne = true;
		}
	}

	@Override
	public void handleEvent(NumberButtonEvent event, int number) {
		if (counterBooleanOne == true) {
			codeBreached += number;
			if (codeBreached.equals("1234")) {
				counterBooleanOne = false;
				redoPasswordOne = 1;
				if (!SecurityContext.instance().testReady()) {
					System.out.println("NotReadyState");
					codeBreached = "";
					SecurityContext.instance().changeState(
							NotReadyState.instance());
				} else {
					System.out.println("ReadyState");
					codeBreached = "";
					SecurityContext.instance().changeState(
							ReadyState.instance());
				}
			}
			if (codeBreached.length() == 4 && !codeBreached.equals("1234")) {
				SecurityContext.instance()
						.showPasscodeStayRedo(redoPasswordOne);
				redoPasswordOne++;
				codeBreached = "";
			}
		} else {
			if (counterBooleanTwo == true) {
				code += number;
				SecurityContext.instance().showPasscode(number);
				if (code.equals("1234")) {
					counterBooleanTwo = false;
					redoPasswordTwo = 1;
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
				if (code.length() == 4 && !code.equals("1234")) {
					SecurityContext.instance().showPasscodeCancelRedo(
							redoPasswordTwo);
					redoPasswordTwo++;
					code = "";
				}
			}
		}
	}

	@Override
	public void handleEvent(CancelRequestEvent event) {
		if (timer.getTimeValue() == 0 && counterBooleanTwo == false) {
			counterBooleanTwo = true;
			SecurityContext.instance().showPasscodeInfo();
		}
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
		if (!SecurityContext.instance().testReady()) {
			SecurityContext.instance().changeState(NotReadyState.instance());
		} else {
			SecurityContext.instance().showAwayTimeLeft(0);
		}
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
	}
}
