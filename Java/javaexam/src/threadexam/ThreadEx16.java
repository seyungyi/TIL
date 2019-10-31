package threadexam;

public class ThreadEx16 {
	public static void main(String[] args)  {
		Thread thread = new PrintThread2();
		thread.start();		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}		
		thread.interrupt();
	}
}

class PrintThread2 extends Thread {
	public void run() {	
		//how1
		/*try {
			while(true) {
				System.out.println("실행 중");
				Thread.sleep(10000);
			}	
		} catch(InterruptedException e) {	
			
		}*/
		
		//how2
		while(true) {
			System.out.println("실행 중");
			if(Thread.interrupted()) {			
				System.out.println("인터럽트!!!");
				break;
			}
		}
		
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
}

