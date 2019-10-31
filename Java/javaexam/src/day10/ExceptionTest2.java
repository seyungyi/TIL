package day10;

public class ExceptionTest2 {
	public static void main(String[] args) {
		System.out.println("수행시작");
		try {
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			int result = num1 / num2;		
			System.out.println("연산 결과 : " + result);
		} catch(Exception e) {
			System.out.println(e);
		}
		/*catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("프로그램 아규먼트를 전달하세요");
		} catch(ArithmeticException e) {
			System.out.println("프로그램 아규먼트를 전달하세요");
		} */finally {
			System.out.println("항상 수행");
		}
		System.out.println("수행종료");	
	}
}
