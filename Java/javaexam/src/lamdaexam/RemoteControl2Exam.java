package lamdaexam;

public class RemoteControl2Exam {
	public static void main(String[] args) {
		RemoteControl2 rc = null;
		
		rc = new Television();
		rc.turnOn();
		rc.setMute(true);
		
		rc = new Audio();
		rc.turnOn();
		rc.setMute(true);
	}
}
