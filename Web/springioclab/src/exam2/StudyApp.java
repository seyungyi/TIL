package exam2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class StudyApp {
	public static void main(String[] args) {
		ApplicationContext factory =
				   new ClassPathXmlApplicationContext("exam2/app2.xml");
		
		Student[] st = {
				factory.getBean("st1", Student.class),
				factory.getBean("st2", Student.class),
				factory.getBean("st3", Student.class)
		};
		for(int i=0; i<st.length; i++) {
			factory.getBean("st"+(i+1), Student.class);
		}
		for(Student data : st)
			System.out.println(data.toString());
		((ClassPathXmlApplicationContext)factory).close();
	}
}
