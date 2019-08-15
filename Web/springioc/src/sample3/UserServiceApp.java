package sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceApp {
	public static void main(String[] args) {
		ApplicationContext factory
        		=new ClassPathXmlApplicationContext("sample3/applicationContext.xml");
		System.out.println("** Container Initialization End **");
		
		UserService u1=(UserService)factory.getBean("userService");
		UserVo vo = (UserVo)factory.getBean("obj1");
		u1.addUser(vo);
		System.out.println(u1);
		System.out.println("----------------------------------------------------");
		
		UserService u2=factory.getBean("userService", UserService.class);
		UserVo vo2 = (UserVo)factory.getBean("obj2");
		u2.addUser(vo2);
		System.out.println(u2);		
		((ClassPathXmlApplicationContext)factory).close();
	}
}





