package my.spring.springedu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.MyModel;
import vo.XmlVO;

@Controller
public class ResponseBodyController {
	@RequestMapping(value = "/body/text/{id}", produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String getByIdInTEXT(@PathVariable String id) {
		return "<h1>It returns the string directly from the controller : " + id + "</h1>";
	}

	@RequestMapping(value = "/body/htmltext/{id}", produces = "text/html; charset=utf-8")
	@ResponseBody
	public String getByIdInHTMLTEXT(@PathVariable String id) {
		return "<h1>It returns the HTML directly from the controller : " + id + "</h1>";
	}


	
	@RequestMapping(value = "/body/json/{id}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public MyModel getByIdInJSON1(@PathVariable String id) {
		MyModel my = new MyModel();
		my.setFlowerName("ROSE");
		my.setNum(5);
		my.setId(id);		
		return my;
	}	
	
	@RequestMapping(value = "/body/json2/{id}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<MyModel> getByIdInJSON2(@PathVariable String id) {
		List<MyModel> list = new ArrayList<MyModel>();
		MyModel my = new MyModel();
		my.setFlowerName("ROSE");
		my.setNum(5);
		my.setId(id);
		list.add(my);
		my = new MyModel();
		my.setFlowerName("LILY");
		my.setNum(5);
		my.setId(id);
		list.add(my);
		return list;
	}
	
	@RequestMapping(value = "/body/json3/{id}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String lll(@PathVariable String id) {
		String s = "{ \"name\" : \"ROSE\", \"num\":5, \"id\" : \""+id+"\"}";
		return s;
	}

	@RequestMapping(value = "/body/xml/{id}", produces = "application/xml; charset=utf-8")
	@ResponseBody
	public MyModel getByIdInXML1(@PathVariable String id) {
		MyModel my = new MyModel();
		my.setFlowerName("ROSE");
		my.setNum(5);
		my.setId(id);
		return my;
	}

	
	@RequestMapping(value = "/body/xml2/{id}", produces = "application/xml; charset=utf-8")
	@ResponseBody
	public XmlVO getByIdInXML4(@PathVariable String id) {
		XmlVO vo = new XmlVO();
		List<MyModel> list = new ArrayList<MyModel>();
		MyModel my = new MyModel();
		my.setFlowerName("ROSE");
		my.setNum(5);
		my.setId(id);
		list.add(my);
		my = new MyModel();
		my.setFlowerName("LILY");
		my.setNum(5);
		my.setId(id);
		list.add(my);
		vo.setList(list);
		return vo;
	}
	@RequestMapping(value = "/getJSON1", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String test1(String id) {
		String s = "{ \"result\" : \" ㅋㅋ1" + id + "\"}";		
		return s;
	}	
	@RequestMapping(value = "/getJSON2", produces = "application/json; charset=utf-8")
	@ResponseBody
	public HashMap<String, String> test2(String id) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("result", "ㅋㅋ2"+id);
		return map;
	}	
}
