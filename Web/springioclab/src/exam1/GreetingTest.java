package exam1;

import java.time.LocalDateTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("exam1/app.xml");
		int hour = ((LocalDateTime) context.getBean("localdatetime")).getHour();
		if(hour >=6  && hour < 12) {
			MorningGreetingImpl b1 = (MorningGreetingImpl)context.getBean("morning");
			b1.greet();
		} else if(hour >= 12 && hour < 17) {
			AfternoonGreetingImpl b2 = (AfternoonGreetingImpl)context.getBean("afternoon");
			b2.greet();			
		} else if(hour >= 17 && hour < 22) {
			context.getBean("evening", EveningGreetingImpl.class).greet();		
		} else {
			context.getBean("night", NightGreetingImpl.class).greet();					
		}
		((ClassPathXmlApplicationContext)context).close();
	}
}
