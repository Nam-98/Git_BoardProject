package kh.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@Autowired
	private HttpSession session;

	@RequestMapping("/")
	public String home() {
		if(session.getAttribute("id")==null) {
		return "/bmember/loginView";
		}else {
			return "/home";
			//로그아웃, board page로 가기 등이 있는 page로 바꾸어주세요.
		}
	}
	
	@ExceptionHandler
	public String exceptionalHandler(Throwable e) {
		e.printStackTrace();
		return "error";
	}
}
