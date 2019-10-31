package day6;

class Member3 {
	String name;	//이름
	String account;	//계정
	String passwd;	//암호
	int birthyear;	//생일
	
	Member3() {
		System.out.println("객체 생성");
	}
	/*
	Member3(String n, String a, String p, int by) {
		name = n;
		account = a;
		passwd = p;
		birthyear = by;
	}
	*/
	Member3(String name, String account, String passwd, int birthyear) {
		this.name = name;
		this.account = account;
		this.passwd = passwd;
		this.birthyear = birthyear;
	}
	
	String mbPrint() {
		return  name + "(" + account
					+ ", " + passwd + ", " + birthyear + ")";
	}
}
public class MemberTest3 {
	public static void main(String[] args) {
		// 변수에 저장후 출력
		Member3 objA[] = new Member3[3];
		objA[0] = new Member3("갤럭시10", "Galaxy10", "Samsung", 1);
		
		objA[1] = new Member3("갤럭시9", "Galaxy9", "Samsung", 2);
		objA[2] = new Member3("갤럭시8", "Galaxy8", "Samsung", 3);
		
		for(int i=0; i<objA.length; i++) {
			System.out.println("회원" + (i+1) + ": " + objA[i].mbPrint());			
		}
	}
}
