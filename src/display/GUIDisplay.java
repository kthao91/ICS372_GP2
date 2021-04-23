package display;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import states.SecurityContext;
import buttons.AwayButton;
import buttons.CancelButton;
import buttons.GUIButton;
import buttons.GUICheckBox;
import buttons.MotionButton;
import buttons.NumberButton;
import buttons.StayButton;
import buttons.ZoneOneCheckBox;
import buttons.ZoneThreeCheckBox;
import buttons.ZoneTwoCheckBox;

/**
 * This Class will start the GUI, It will add 10 button for numbers, stay and
 * away to set alarm to stay or away, montionDetector to detect motion, cancel
 * to cancel alarm, zone1 zone2 zone3 which are checkboxs to make sure they
 * zones are good before alarming.
 * 
 * @author Group 7
 *
 */
public class GUIDisplay extends Application implements SecurityDisplay {
	private GUIButton button1;
	private GUIButton button2;
	private GUIButton button3;
	private GUIButton button4;
	private GUIButton button5;
	private GUIButton button6;
	private GUIButton button7;
	private GUIButton button8;
	private GUIButton button9;
	private GUIButton button0;
	private GUIButton stay;
	private GUIButton away;
	private GUIButton motionDetector;
	private GUIButton cancel;
	private GUICheckBox zone1;
	private GUICheckBox zone2;
	private GUICheckBox zone3;
	private static SecurityDisplay display;
	private SecurityContext securityContext;
	private TextField text = new TextField("Ready");
	private Label readyStatus = new Label("Ready Status");

	public static SecurityDisplay getInstance() {
		return display;
	}

	/**
	 * This will setup the GUI
	 */
	@Override
	public void start(Stage primaryStage) {
		securityContext = SecurityContext.instance();
		securityContext.setDisplay(this);
		display = this;

		Pane pane = new Pane();
		Scene scene = new Scene(pane, 700, 300);
		primaryStage.setTitle("Security System");
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		Image icon = new Image(getClass().getResourceAsStream("/images/Camera.png"));
		primaryStage.getIcons().add(icon);

		text = new TextField("Ready");
		text.setPrefWidth(520);
		text.setPrefHeight(150);
		text.setLayoutX(150);
		text.setLayoutY(20);
		text.setFocusTraversable(false);
		text.setAlignment(Pos.TOP_LEFT);

		button1 = new NumberButton("1");
		button1.setLayoutX(30);
		button1.setLayoutY(20);
		button1.setPrefWidth(30);
		button1.setPrefHeight(30);

		button2 = new NumberButton("2");
		button2.setLayoutX(60);
		button2.setLayoutY(20);
		button2.setPrefWidth(30);
		button2.setPrefHeight(30);

		button3 = new NumberButton("3");
		button3.setLayoutX(90);
		button3.setLayoutY(20);
		button3.setPrefWidth(30);
		button3.setPrefHeight(30);

		button4 = new NumberButton("4");
		button4.setLayoutX(30);
		button4.setLayoutY(50);
		button4.setPrefWidth(30);
		button4.setPrefHeight(30);

		button5 = new NumberButton("5");
		button5.setLayoutX(60);
		button5.setLayoutY(50);
		button5.setPrefWidth(30);
		button5.setPrefHeight(30);

		button6 = new NumberButton("6");
		button6.setLayoutX(90);
		button6.setLayoutY(50);
		button6.setPrefWidth(30);
		button6.setPrefHeight(30);

		button7 = new NumberButton("7");
		button7.setLayoutX(30);
		button7.setLayoutY(80);
		button7.setPrefWidth(30);
		button7.setPrefHeight(30);

		button8 = new NumberButton("8");
		button8.setLayoutX(60);
		button8.setLayoutY(80);
		button8.setPrefWidth(30);
		button8.setPrefHeight(30);

		button9 = new NumberButton("9");
		button9.setLayoutX(90);
		button9.setLayoutY(80);
		button9.setPrefWidth(30);
		button9.setPrefHeight(30);

		button0 = new NumberButton("0");
		button0.setLayoutX(60);
		button0.setLayoutY(110);
		button0.setPrefWidth(30);
		button0.setPrefHeight(30);

		zone1 = new ZoneOneCheckBox("Zone 1");
		zone1.setLayoutX(30);
		zone1.setLayoutY(200);
		zone1.setSelected(true);

		zone2 = new ZoneTwoCheckBox("Zone 2");
		zone2.setLayoutX(130);
		zone2.setLayoutY(200);
		zone2.setSelected(true);

		zone3 = new ZoneThreeCheckBox("Zone 3");
		zone3.setLayoutX(230);
		zone3.setLayoutY(200);
		zone3.setSelected(true);

		readyStatus.setLayoutX(130);
		readyStatus.setLayoutY(230);

		motionDetector = new MotionButton("Motion Detector");
		motionDetector.setLayoutX(105);
		motionDetector.setLayoutY(260);
		motionDetector.setPrefWidth(120);

		stay = new StayButton("Stay");
		stay.setLayoutX(350);
		stay.setLayoutY(200);
		stay.setPrefWidth(80);

		away = new AwayButton("Away");
		away.setLayoutX(440);
		away.setLayoutY(200);
		away.setPrefWidth(80);

		cancel = new CancelButton("Cancel");
		cancel.setLayoutX(530);
		cancel.setLayoutY(200);
		cancel.setPrefWidth(80);

		pane.getChildren().addAll(text, button1, button2, button3, button4, button5, button6, button7, button8, button9,
				button0, zone1, zone2, zone3, readyStatus, motionDetector, stay, away, cancel);

		try {
			while (securityContext == null) {
				Thread.sleep(1000);
			}
		} catch (Exception e) {

		}
		primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				System.exit(0);
			}
		});
	}

	/**
	 * Show ready status if all zones are checked
	 */
	@Override
	public void showReady() {
		if (zone1.isSelected() && zone2.isSelected() && zone3.isSelected()) {
			text.setText("Ready");
		} else {
			text.setText("Not Ready");
		}
	}

	/**
	 * Make sure all the zone are checked before alarming
	 */
	@Override
	public boolean testReady() {
		if (zone1.isSelected() && zone2.isSelected() && zone3.isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Make sure all the zone are checked before alarming for away
	 */
	@Override
	public void showAwayTimeLeft(int timeLeft) {
		if (timeLeft == 0) {
			text.setText("Away");
		} else {
			text.setText(timeLeft + " seconds for away");
		}
	}

	/**
	 * Make sure all the zone are checked before alarming for stay
	 */
	@Override
	public void showStayTimeLeft(int timeLeft) {
		if (timeLeft == 0) {
			text.setText("Stay");
		} else {
			text.setText(timeLeft + " seconds for stay");
		}
	}

	/**
	 * Make sure all the zone are checked before alarming for warning
	 */
	@Override
	public void showWarningTimeLeft(int timeLeft) {
		if (timeLeft == 0) {
			text.setText("Security has been breached...");
		} else {
			text.setText(timeLeft + " seconds left until security breach... ");
		}
	}

	/**
	 * This will show the how much time left before security breach you have and how
	 * many incorrect attempt to unlock
	 */
	@Override
	public void showWarningTimeLeft(int timeLeft, int incorrectAttempt) {
		if (timeLeft == 0) {
			text.setText("Security has been breached...");
		} else {
			if (timeLeft != 0 && incorrectAttempt == 0) {
				text.setText(timeLeft + " seconds left until security breach... ");
			} else {
				text.setText(timeLeft + " seconds left until security breach..." + " (" + incorrectAttempt + ")"
						+ " Wrong passcode. Enter passcode: ");
			}
		}
	}

	/**
	 * Show passcode information
	 */
	@Override
	public void showPasscodeInfo() {
		text.setText("Enter the passcode: ");
	}

	/**
	 * Show passcode information with passcode
	 */
	@Override
	public void showPasscode(int passcode) {
		if (text.getText().equals("Enter the passcode: ") || text.getText().length() > 4) {
			text.setText(passcode + "");
		} else {
			text.setText(text.getText() + passcode);
		}
	}

	/**
	 * Show incorrect attempts for stay event
	 */
	@Override
	public void showPasscodeStayRedo(int incorrectAttempt) {
		String copyText = text.getText().substring(0, 29);
		text.setText(copyText + " (" + incorrectAttempt + ")" + "Wrong passcode. Enter passcode: ");
	}

	/**
	 * Show incorrect attempts for cancel event
	 */
	@Override
	public void showPasscodeCancelRedo(int incorrectAttempt) {
		text.setText("(" + incorrectAttempt + ")" + "Wrong passcode. Enter passcode: ");
	}

}
