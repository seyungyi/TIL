package day1;

public class VariableTest1 {
	public static void main(String[] args) {
		int num; //변수 선언
		num = 10000;
		System.out.println(100);
		System.out.println("연산전 : " + num);
		num = 10+20;
		System.out.println("연산후 : " + num);
		char munja = 'A';
		System.out.print(munja);
		munja++;
		System.out.print(munja);
		munja += 1;
		System.out.print(munja);
		munja = (char)(munja+1); // munja = munja + 1 은 타입이 다르기에 형변환으로 연산
		System.out.println(munja);
		}
}
