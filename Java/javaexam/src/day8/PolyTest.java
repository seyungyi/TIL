package day8;

public class PolyTest {
	public static void main(String[] args) {
		printObjectInfo(new Object());
		printObjectInfo(new String("가나다"));
		printObjectInfo("ABC");
		printObjectInfo(new java.io.File("c:\\"));
		printObjectInfo(new java.util.Date());
		printObjectInfo(new int[10]);
		printObjectInfo(new double[5][3]);
	}
	static void printObjectInfo(Object o) {
		if(o instanceof String) {
			System.out.println("String객체가 전달됨!!! - " + o.toString() + 
					"(" + o.toString().length() + ")");
		} else {
			System.out.println("전달된 객체의 클래스명" + o.getClass().getName());			
		}
	}
}
