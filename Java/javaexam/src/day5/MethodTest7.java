package day5;

public class MethodTest7 {
	public static void main(String[] args) {
		System.out.println(args.length);
		if(args.length == 0) {
			System.out.println("전달될 프로그램 아규먼트가 없다!");
			return;
		}
		for(String data : args) {
			System.out.println(data);
		}
		System.out.println("프로그램 아규먼트를 " + args.length + 
				"개 전달했습니다!");
	}
}
