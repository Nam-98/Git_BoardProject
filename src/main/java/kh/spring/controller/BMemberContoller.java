package kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.BMemberDTO;
import kh.spring.service.BMemberService;


@Controller
@RequestMapping("/bmember")
public class BMemberContoller {
	
	@Autowired
	private BMemberService mservice;
	
	
	// 테스트영역 시작
	
//	@RequestMapping("dummyInput.mem")
//	public String dummyInput(HttpServletRequest request, Model model, HttpSession session) {
//		session.setAttribute("id", "ttt");
//		return "redirect:/";
//	}
	
	@RequestMapping("quitProcessMember.mem")
	public String quitProcessMember(HttpServletRequest request, Model model) {
		String sessionId = (String)request.getSession().getAttribute("id");
		int result = mservice.quitProcessMember(sessionId);
		return "로그아웃 프로세스로 이동";
	}
	
	@RequestMapping("getMyInfo.mem")
	public String getMyInfo(HttpServletRequest request, Model model) {
		String sessionId = (String)request.getSession().getAttribute("id");
		
		List<BMemberDTO> list = mservice.getMyInfo(sessionId);
		
		model.addAttribute("list", list);
		
		return "/bmember/myInfoView";
	}
	
	@RequestMapping("modifyMyInfo.mem")
	public String modifyMyInfo(HttpServletRequest request, Model model) {
		String sessionId = (String)request.getSession().getAttribute("id");
		
		List<BMemberDTO> list = mservice.getMyInfo(sessionId);
		
		model.addAttribute("list", list);
		
		return "/bmember/modifyMyInfoView";
	}
	
	
	@RequestMapping("modifyProcessMember.mem")
	public String modifyProcessMember(BMemberDTO bmemberDTO, HttpServletRequest request) {
		
		bmemberDTO.setId((String)request.getSession().getAttribute("id"));
		mservice.modifyProcessMember(bmemberDTO);
		return "redirect:/bmember/getMyInfo.mem";
	}
	
	
	// 테스트영역 종료

}
