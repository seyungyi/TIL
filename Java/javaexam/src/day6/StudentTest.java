package day6;
class Student {
	String name;
	String project;
	int age;
	void study() {
		System.out.println(name + "학생이 " + project + "을 공부합니다.");
	}
	String getStudentInfo() {
		return "이름 : " + name + ", 나이 : " + age;
	}
}
public class StudentTest {
	public static void main(String[] args) {
		Student student1 = new Student();
		student1.name = "둘리";
		student1.project = "수학";
		student1.age = 10;
		student1.study();
		System.out.println(student1.getStudentInfo());
		
		Student student2 = new Student();
		student2.name = "듀크";
		student2.project = "과학";
		student2.age = 24;
		student2.study();
		System.out.println(student2.getStudentInfo());
		student1 = student2;
		System.out.println("stuent1 = student2 수행한 후");
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student1.name);
		System.out.println(student2.name);
	}
}
