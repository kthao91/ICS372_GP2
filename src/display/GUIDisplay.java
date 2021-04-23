package display;
	

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import states.SecurityContext;
import buttons.AwayButton;
import buttons.CancelButton;
import buttons.MotionButton;
import buttons.NumberButton;
import buttons.StayButton;
import buttons.ZoneOneCheckBox;
import buttons.ZoneThreeCheckBox;
import buttons.ZoneTwoCheckBox;


public class GUIDisplay extends Application implements SecurityDisplay{
	private TextField text;
	private CheckBox zone1;
	private CheckBox zone2;
	private CheckBox zone3;
	private static SecurityDisplay display;
    private SecurityContext microwaveContext;
	
	
	public static SecurityDisplay getInstance() {
        return display;
    }
	
	@Override
	public void start(Stage primaryStage) {
        microwaveContext = SecurityContext.instance();
        microwaveContext.setDisplay(this);
        display = this;

			Pane pane = new Pane();
			Scene scene = new Scene(pane,700,300);
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
			
			Button button1 = new NumberButton("1");
			button1.setLayoutX(30);
			button1.setLayoutY(20);
			button1.setPrefWidth(30);
			button1.setPrefHeight(30);
			
			Button button2 = new NumberButton("2");
			button2.setLayoutX(60);
			button2.setLayoutY(20);
			button2.setPrefWidth(30);
			button2.setPrefHeight(30);
			
			Button button3 = new NumberButton("3");
			button3.setLayoutX(90);
			button3.setLayoutY(20);
			button3.setPrefWidth(30);
			button3.setPrefHeight(30);
			
			Button button4 = new NumberButton("4");
			button4.setLayoutX(30);
			button4.setLayoutY(50);
			button4.setPrefWidth(30);
			button4.setPrefHeight(30);
			
			Button button5 = new NumberButton("5");
			button5.setLayoutX(60);
			button5.setLayoutY(50);
			button5.setPrefWidth(30);
			button5.setPrefHeight(30);
			
			Button button6 = new NumberButton("6");
			button6.setLayoutX(90);
			button6.setLayoutY(50);
			button6.setPrefWidth(30);
			button6.setPrefHeight(30);
			
			Button button7 = new NumberButton("7");
			button7.setLayoutX(30);
			button7.setLayoutY(80);
			button7.setPrefWidth(30);
			button7.setPrefHeight(30);
			
			Button button8 = new NumberButton("8");
			button8.setLayoutX(60);
			button8.setLayoutY(80);
			button8.setPrefWidth(30);
			button8.setPrefHeight(30);
			
			Button button9 = new NumberButton("9");
			button9.setLayoutX(90);
			button9.setLayoutY(80);
			button9.setPrefWidth(30);
			button9.setPrefHeight(30);
			
			Button button0 = new NumberButton("0");
			button0.setLayoutX(60);
			button0.setLayoutY(110);
			button0.setPrefWidth(30);
			button0.setPrefHeight(30);
			
			zone1 = new ZoneOneCheckBox("Zone 1");
			zone1.setLayoutX(30);
			zone1.setLayoutY(200);
			zone1.setSelected(true);
			
			zone2 = new ZoneTwoCheckBox("Zone 2");
			zone2.setLayoutX(100);
			zone2.setLayoutY(200);
			zone2.setSelected(true);
			
			zone3 = new ZoneThreeCheckBox("Zone 3");
			zone3.setLayoutX(170);
			zone3.setLayoutY(200);
			zone3.setSelected(true);
			
			Label readyStatus = new Label("Ready Status");
			readyStatus.setLayoutX(110);
			readyStatus.setLayoutY(230);
			
			Button motionDetector = new MotionButton("Motion Detector");
			motionDetector.setLayoutX(85);
			motionDetector.setLayoutY(250);
			motionDetector.setPrefWidth(120);
			
			Button stay = new StayButton("Stay");
			stay.setLayoutX(350);
			stay.setLayoutY(200);
			stay.setPrefWidth(60);
			
			Button away = new AwayButton("Away");
			away.setLayoutX(420);
			away.setLayoutY(200);
			away.setPrefWidth(60);
			
			Button cancel = new CancelButton("Cancel");
			cancel.setLayoutX(490);
			cancel.setLayoutY(200);
			cancel.setPrefWidth(60);
	
			pane.getChildren().addAll(text,button1,button2,button3,button4,button5,button6,button7,button8,button9,button0,zone1,zone2,zone3
					,readyStatus,motionDetector,stay,away,cancel);
			
			primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
	            @Override
	            public void handle(WindowEvent window) {
	                System.exit(0);
	            }
	        });
		
	}
	
	@Override
	public void showReady() {
		if(zone1.isSelected() && zone2.isSelected() && zone3.isSelected()) {
			text.setText("Ready");
		}
		else {
			text.setText("Not Ready");
		}
	}
	
	@Override
	public boolean testReady() {
		if(zone1.isSelected() && zone2.isSelected() && zone3.isSelected()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public void showAwayTimeLeft(int value) {
		if(value == 0) {
			text.setText("Away");
		}
		else {
			text.setText(value + " seconds for away");
		}
    }
	
	@Override
	public void showStayTimeLeft(int value) {
		if(value == 0) {
			text.setText("Stay");
		}
		else {
			text.setText(value + " seconds for away");
		}
    }
	
	@Override
	public void showWarningTimeLeft(int value) {
		if(value == 0) {
			text.setText("Security has been breached...");
		}
		else {
			text.setText(value + " seconds left until security breach...");
		}
    }
	
	@Override
	public void showPasscodeInfo() {
		text.setText("Enter the passcode: ");
    }
	
	@Override
	public void showPasscode(int value) {
		if(text.getText().equals("Enter the passcode: ")) {
			text.setText(value + "");
		}
		else {
		text.setText(text.getText() + value);
		}
    }
}
