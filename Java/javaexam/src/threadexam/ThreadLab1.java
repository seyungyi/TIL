package threadexam;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ThreadLab1 {
	public static void main(String[] args) {
		ThreadLab1_1 t1 = new ThreadLab1_1();
		ThreadLab1_2 t2 = new ThreadLab1_2();
		t1.start();
		t2.start();
		
		for(int i=0; i<10; i++) {
			try {
				Thread.sleep(3000);
			} catch(Exception e) { }
			System.out.println("number of milliseconds snce January 1, 1970, 00:00:00 GMT");
		}
	}
}
class ThreadLab1_1 extends Thread {
	Calendar gc;
	int month;
	int day;
	public void run() {
		for(int i=0; i<3; i++) {
			try {
				Thread.sleep(10000);
			} catch(Exception e) {
				e.printStackTrace();
			}
			gc = new GregorianCalendar();
			month = gc.get(Calendar.MONTH)+1;
			day = gc.get(Calendar.DAY_OF_MONTH);
			System.out.println("오늘은 " + month + "월 " + day + "일입니다.");
		}
	}
}
class ThreadLab1_2 extends Thread {
	public void run() {
		Calendar gc;
		int hour;
		int minute;
		int second;
		for(int i=0; i<5; i++) {
			try {
				Thread.sleep(5000);
			} catch(Exception e) { }
			gc = new GregorianCalendar();
			hour = gc.get(Calendar.HOUR_OF_DAY);
			minute = gc.get(Calendar.MINUTE);
			second = gc.get(Calendar.SECOND);
			System.out.println(hour + "시 " + minute + "분 " + second + "초");
		}
	}
}