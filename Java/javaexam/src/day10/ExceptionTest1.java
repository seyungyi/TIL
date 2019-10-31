package day10;

public class ExceptionTest1 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("수행시작");
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		int result = num1 / num2;		
		System.out.println(result);
		System.out.println("수행종료");
	}
}
