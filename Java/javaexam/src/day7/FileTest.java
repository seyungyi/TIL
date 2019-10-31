package day7;

public class FileTest {
	public static void main(String[] args) {
		if(args.length == 1) 	{
			java.io.File f = new java.io.File(args[0]);
			if(f.exists()){
				if(f.isDirectory()) {
					System.out.println(args[0] + " : 디렉토리");
				} else {
					System.out.println(args[0] + " : " + f.length());
				}
			} else {
				System.out.println(args[0] +" : 존재하지 않습니다.");
			}
		} else {
			System.out.println("체크하려는 파일 이름을 "
					                                + "프로그램 아규먼트로 전달하시오");
		}
	}
}
