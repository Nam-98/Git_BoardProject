package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.BMemberDAO;
import kh.spring.dto.BMemberDTO;

@Service
public class BMemberService {
	
	@Autowired
	private BMemberDAO mdao;
	
	public int quitProcessMember(String sessionId) {
		return mdao.quitProcessMember(sessionId);
	}
	
	public int modifyProcessMember(BMemberDTO bmemberDTO) {
		return mdao.modifyProcessMember(bmemberDTO);
	}

	public List<BMemberDTO> getMyInfo(String sessionId) {
		return mdao.getMyInfo(sessionId);
	}
}
