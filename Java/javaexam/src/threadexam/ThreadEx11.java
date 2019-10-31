package threadexam;

import java.awt.Toolkit;

public class ThreadEx11 {
	public static void main(String[] args) {
		System.out.println("수행시작");
		Toolkit toolkit = Toolkit.getDefaultToolkit();		
		for(int i=0; i<10; i++) {
			toolkit.beep();
			System.out.println("ㅋ");
			try {
				Thread.sleep(3000);
			} catch(InterruptedException e) {			
			}		
		}
		System.out.println("수행종료");
	}
}
