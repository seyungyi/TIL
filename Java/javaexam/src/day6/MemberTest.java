package day6;

class Member {
	String name;	//이름
	String account;	//계정
	String passwd;	//암호
	int birthyear;	//생일
	String mbPrint() {
		return  name + "(" + account
					+ ", " + passwd + ", " + birthyear + ")";
	}
}
public class MemberTest {
	public static void main(String[] args) {
		// 변수에 저장후 출력
		Member mb1 = new Member();
		mb1.name = "갤럭시10";
		mb1.account = "Galaxy10";
		mb1.passwd = "Samsung";
		mb1.birthyear = 1;
		
		Member mb2 = new Member();
		mb2.name = "갤럭시9";
		mb2.account = "Galaxy9";
		mb2.passwd = "Samsung";
		mb2.birthyear = 2;
		
		Member mb3 = new Member();
		mb3.name = "갤럭시8";
		mb3.account = "Galaxy8";
		mb3.passwd = "Samsung";
		mb3.birthyear = 3;
		
		System.out.println("회원1 : " + mb1.mbPrint());
		System.out.println("회원2 : " + mb2.mbPrint());
		System.out.println("회원3 : " + mb3.mbPrint());
	}
}
