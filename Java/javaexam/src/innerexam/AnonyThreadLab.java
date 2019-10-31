package innerexam;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AnonyThreadLab {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			Calendar gc;
			@Override
			public void run() {
				for(int i=0; i<3; i++) {
					try {
						Thread.sleep(10000);
					} catch(Exception e) {
						e.printStackTrace();
					}
					gc = new GregorianCalendar();
					int month = gc.get(Calendar.MONTH)+1;
					int day = gc.get(Calendar.DAY_OF_MONTH);
					System.out.println("오늘은 " + month + "월 " + day + "일입니다.");
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
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
		});
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