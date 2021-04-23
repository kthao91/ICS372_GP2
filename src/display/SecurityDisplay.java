package display;

public interface SecurityDisplay {
	
	public void showReady();
	
	public boolean testReady();
	
	public void showAwayTimeLeft(int time);
	
	public void showStayTimeLeft(int time);
	
	public void showWarningTimeLeft(int time);
	
	public void showPasscode(int number);
	
	public void showPasscodeInfo();
}
