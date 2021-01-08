package kh.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(HttpSession session) {
		if(session.getAttribute("id")==null) {
		return "/member/loginView";
		}else {
			return "/home";
			//로그아웃, board page로 가기 등이 있는 page로 바꾸어주세요.
		}
	}
	
}
