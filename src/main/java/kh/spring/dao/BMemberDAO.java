package kh.spring.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BMemberDTO;

@Repository
public class BMemberDAO {
	
	@Autowired
	private SqlSession db;
	
	public int isIdExistMember (String id) {
		return db.selectOne("BMember.isIdExistMember", id);
	}
	
	public int signUpMember (BMemberDTO dto) {
		return db.insert("BMember.signUpMember", dto);
	}
	
	public int loginMember (BMemberDTO dto) {
		System.out.println(dto.getId());
		System.out.println(dto.getPw());
		return db.selectOne("BMember.loginMember", dto);
	}
}
