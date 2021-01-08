package kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.spring.dto.BMemberDTO;
import kh.spring.service.BMemberService;

@Controller
@RequestMapping("/bmember")
public class BMemberContoller {

	@Autowired
	private BMemberService mservice;
	
	@RequestMapping("toSignUpViewMember.member")
	public String toSignUpViewMember () {
		return "/bmember/signUpView";
	}
	
	@RequestMapping("signUpMember.member")
	public String signUpMember (BMemberDTO dto,Model model) {
		model.addAttribute("result", mservice.signUpMember(dto));
		return "/bmember/signUpView";
	}
	
	@ResponseBody
	@RequestMapping(value = "isIdExistMember.member", produces = "text/plane; charset=UTF8")
	public String isIdExistMember (String id, Model model) {
		return mservice.isIdExistMember(id);
	}
	
	@RequestMapping("logoutMember.member")
	public String logoutMember () {
		mservice.logoutMember();
		return "redirect:/";
	}
	
	@RequestMapping("loginMember.member")
	public String loginMember (BMemberDTO dto,Model model) {
		int result =  mservice.loginMember(dto);
		System.out.println(result);
		model.addAttribute("loginResult", result);
		return "redirect:/";
	}
	
	// 테스트영역 시작
	
//	@RequestMapping("dummyInput.mem")
//	public String dummyInput(HttpServletRequest request, Model model, HttpSession session) {
//		session.setAttribute("id", "ttt");
//		return "redirect:/";
//	}
	
	@RequestMapping("quitProcessMember.member")
	public String quitProcessMember(HttpServletRequest request, Model model) {
		String sessionId = (String)request.getSession().getAttribute("id");
		int result = mservice.quitProcessMember(sessionId);
		return "redirect:/bmember/logoutMember.member";
	}
	
	@RequestMapping("getMyInfo.member")
	public String getMyInfo(HttpServletRequest request, Model model) {
		String sessionId = (String)request.getSession().getAttribute("id");
		
		List<BMemberDTO> list = mservice.getMyInfo(sessionId);
		
		model.addAttribute("list", list);
		
		return "/bmember/myInfoView";
	}
	
	@RequestMapping("modifyMyInfo.member")
	public String modifyMyInfo(HttpServletRequest request, Model model) {
		String sessionId = (String)request.getSession().getAttribute("id");
		
		List<BMemberDTO> list = mservice.getMyInfo(sessionId);
		
		model.addAttribute("list", list);
		
		return "/bmember/modifyMyInfoView";
	}
	
	
	@RequestMapping("modifyProcessMember.member")
	public String modifyProcessMember(BMemberDTO bmemberDTO, HttpServletRequest request) {
		
		bmemberDTO.setId((String)request.getSession().getAttribute("id"));
		mservice.modifyProcessMember(bmemberDTO);
		return "redirect:/bmember/getMyInfo.member";
	}
	
	
	// 테스트영역 종료
	@ExceptionHandler
	public String exceptionalHandler(Throwable e) {
		e.printStackTrace();
		return "error";
	}
}
