package kh.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BCommentDTO;


@Repository
public class BCommentDAO {
	
	@Autowired
	private SqlSession db;

	public List<BCommentDTO> searchComment(int board_seq) throws Exception{
		return db.selectList("BComment.searchComment",board_seq);
		
	}
	
	public int insertComment(BCommentDTO dto) throws Exception {
		return db.insert("BComment.insertComment", dto);
	}
}
