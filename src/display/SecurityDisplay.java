package display;

public interface SecurityDisplay {
	
	public void showReady();
	
	public boolean testReady();
	
	public void showAwayTimeLeft(int time);
	
	public void showStayTimeLeft(int time);
	
	public void showWarningTimeLeft(int time);
	
	public void showWarningTimeLeft(int time, int number);
	
	public void showPasscodeInfo();
	
	public void showPasscodeStayRedo(int number);
	
	public void showPasscodeCancelRedo(int number);
	
	public void showPasscode(int number);
}
