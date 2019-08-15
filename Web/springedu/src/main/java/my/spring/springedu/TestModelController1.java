package my.spring.springedu;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import vo.MyVO;
@Controller
public class TestModelController1 {
	@ModelAttribute("v1")
	public String createString() {
		System.out.println("Creating an object automatically 1");
		return "TEST!!";
	}
	@ModelAttribute("v2")
	public int[] createArray() {
		System.out.println("Creating an object automatically 2");
		return new int[]{10, 20, 30, 40, 50};
	}
	@ModelAttribute("v3")
	public MyVO createVO() {
		System.out.println("Creating an object automatically 3");
		MyVO vo = new MyVO();
		vo.setMyColor("yellow");
		vo.setMyNumber(23);
		return vo;
	}	
	@ModelAttribute("v4")
	public Date createDate() {
		System.out.println("Creating an object automatically 4");		
		return new Date();
	}	
	@ModelAttribute("v5")
	public ArrayList<String> createList() {
		System.out.println("Creating an object automatically 5");
		ArrayList<String> list = new ArrayList<String>();
		list.add("ABC");
		list.add("XYZ");
		list.add("123");
		return list;
	}	
	@RequestMapping("/testmodel1")
	public String handle() {
		System.out.println("handle() Method Call");		
		return "modelResult";
	}
}



