package kh.spring.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession db;

	public int insertBoard(BoardDTO bdto) throws Exception{
		return db.insert("Board.insertBoard",bdto);
	}
	
	public BoardDTO fixBeforeBoard(String seq) throws Exception{
		return db.selectOne("Board.fixBeforeBoard", seq);
	}
	
	public int fixAfterBoard(BoardDTO bdto) throws Exception{
		return db.update("Board.fixAfterBoard",bdto);
	}
	
	}

