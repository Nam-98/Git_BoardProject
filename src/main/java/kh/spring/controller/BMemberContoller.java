package kh.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.service.BMemberService;


@Controller
@RequestMapping("/bmember")
public class BMemberContoller {
	
	@Autowired
	private BMemberService bmservice;
	
	
	// 테스트영역 시작
	@RequestMapping("dummyInput.mem")
	public String dummyInput(HttpServletRequest request, Model model, HttpSession session) {
		session.setAttribute("id", "ttt");
		return "redirect:/";
	}
	
	@RequestMapping("quitProcessMember.mem")
	public String quitProcessMember(HttpServletRequest request, Model model) {
		String sessionId = (String)request.getSession().getAttribute("id");
		int result = bmservice.quitProcessMember(sessionId);
		
	}
	
	
	
	// 테스트영역 종료

}
