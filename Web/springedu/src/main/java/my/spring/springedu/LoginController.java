package my.spring.springedu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.LoginService;
import vo.ResultVO;

@Controller
public class LoginController {
	@Autowired
	private LoginService ls;
	
	@RequestMapping(value="/login", produces="application/json; charset=utf-8", method=RequestMethod.POST )
	@ResponseBody
	public ResultVO login(String id, String passwd) {
//		public ResultVO login(LoginnVO vo) {
//		boolean check = ls.login(vo.getId(), vo.getPasswd());
		boolean check = ls.login(id, passwd);
		ResultVO vo = new ResultVO();
		if(check)
			vo.setResult("ok");
		else
			vo.setResult("fail");		
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("result", vo.getResult());
		return vo;
	}
}
