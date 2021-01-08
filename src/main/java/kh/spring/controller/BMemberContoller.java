package kh.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
