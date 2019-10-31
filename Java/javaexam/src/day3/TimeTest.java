package day3;

public class TimeTest {
	public static void main(String[] args) {
		int time = 32150;
		int temp = time % 3600;
		int hour = time / 3600;
		int minute = (temp) / 60;
		int second = (temp) % 60;
		System.out.println(hour + "시간 " + minute + "분 " + second + "초");
	}
}
