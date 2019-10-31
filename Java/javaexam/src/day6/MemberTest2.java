package day6;

class Member2 {
	String name;	//이름
	String account;	//계정
	String passwd;	//암호
	int birthyear;	//생일
	String mbPrint() {
		return  name + "(" + account
					+ ", " + passwd + ", " + birthyear + ")";
	}
}
public class MemberTest2 {
	public static void main(String[] args) {
		// 변수에 저장후 출력
		Member2 objA[] = new Member2[3];
		objA[0] = new Member2();
		objA[0].name = "갤럭시10";
		objA[0].account = "Galaxy10";
		objA[0].passwd = "Samsung";
		objA[0].birthyear = 1;
		
		objA[1] = new Member2();
		objA[1].name = "갤럭시9";
		objA[1].account = "Galaxy9";
		objA[1].passwd = "Samsung";
		objA[1].birthyear = 2;
		
		objA[2] = new Member2();
		objA[2].name = "갤럭시8";
		objA[2].account = "Galaxy8";
		objA[2].passwd = "Samsung";
		objA[2].birthyear = 3;
		
		for(int i=0; i<objA.length; i++) {
			System.out.println("회원" + (i+1) + ": " + objA[i].mbPrint());			
		}
	}
}
