package day7;
class One {
	int x = 10;
	int y = 20;
}
class Two extends One {
	int x= 100;
	void testVariable(int x) {
		System.out.println(x);
		System.out.println(this.x);
		System.out.println(super.x);
		System.out.println(y);
		System.out.println(this.y);
		System.out.println(super.y);
	}
}

public class SuperThisTest {
	public static void main(String[] args) {
		new Two().testVariable(1000);
	}
}
