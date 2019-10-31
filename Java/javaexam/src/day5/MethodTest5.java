package day5;

public class MethodTest5 {
	public static void main(String[] args) {
		//System.out.println("호출 결과 : " + operate(10, 20));
		int result = operate(10, 20);
		System.out.println("호출 결과값1 : " + result);
		System.out.println("호출 결과값2 : " + operate(100, 200));
		result = operate(11, 22) + 100;
		System.out.println("호출 결과값3 : " + result);
		System.out.println(getMyName());
		System.out.println(getMyName('?'));
		System.out.println(getMyName('!'));
	}
	static int operate(int num1, int num2) {
		//int result = num1 + num2;
		//return result;
		return num1 + num2;
	}
	static String getMyName() {
		return "Duke";
	}
	static String getMyName(char deco) { // 메소드 오버로딩
		return "Java Mascot Duke" + deco;
	}
}
