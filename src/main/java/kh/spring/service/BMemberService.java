package kh.spring.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;

import kh.spring.dao.BMemberDAO;
import kh.spring.dto.BMemberDTO;

@Service
public class BMemberService {
	
	@Autowired
	private BMemberDAO mdao;
	
	@Autowired
	private HttpSession session;
	
	public String isIdExistMember (String id) {
		JsonObject obj = new JsonObject();

		int result = mdao.isIdExistMember(id);
		if (result==0) {
			obj.addProperty("result", true);
			obj.addProperty("msg", "사용가능한 아이디 입니다.");
			return obj.toString();
		} else {
			obj.addProperty("result", false);
			obj.addProperty("msg", "사용할 수 없는 아이디 입니다.");
			return obj.toString();
		}
	}
	
	public void logoutMember () {
		session.removeAttribute("id");
	}
	
	public String signUpMember(BMemberDTO dto) {
		int result = mdao.signUpMember(dto);
		if(result>0) {
			return "true";
		}
		return "false";
	}
	
	public int loginMember(BMemberDTO dto) {
		int result = mdao.loginMember(dto);
		if(result==1) {
			session.setAttribute("id", dto.getId());
		}
		return result;
	}

}
