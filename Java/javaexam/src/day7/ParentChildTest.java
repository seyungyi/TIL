package day7;

import java.util.Date;

class Parent {
	int num=1;
}
class Child extends Parent {
	public String toString() { // 메서드 오버라이딩
		return "Child 객체입니다!!";
	}
}

public class ParentChildTest {
	public static void main(String[] args) {
		Parent obj = new Parent();
		System.out.println(obj.toString());
		Child obj2 = new Child();
		System.out.println(obj2.toString());
		System.out.println(obj.num);
		System.out.println(obj2.num);
		System.out.println("객체의 정보: " + obj);
		System.out.println("객체의 정보 : " + obj2);
		Date d = new Date();
		System.out.println("객체의 정보 : " + d);
	}
}
