package kh.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BMemberDTO;

@Repository
public class BMemberDAO {
	
	@Autowired
	private SqlSession db;
	
	public int quitProcessMember(String sessionId) {
		return db.delete("BMember.quitProcessMember", sessionId);
	}
	
	public int modifyProcessMember(BMemberDTO bmemberDTO) {
		return db.update("BMember.modifyProcessMember", bmemberDTO);
	}
	
	public List<BMemberDTO> getMyInfo(String sessionId) {
		return db.selectList("BMember.getMyInfo", sessionId);
	}

}
