package kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.BoardDAO;
import kh.spring.dto.BoardDTO;
@Service
public class BoardService {
	
	@Autowired
	private BoardDAO bdao;
	
	public int insertBoard(BoardDTO bdto) throws Exception{
		System.out.println("서비스 :: "+bdto.getWriter() +":::" + bdto.getContent());
		return bdao.insertBoard(bdto);
	}
	
	public BoardDTO fixBeforeBoard(String seq) throws Exception{
		return bdao.fixBeforeBoard(seq);
	}
	
	public int fixAfterBoard(BoardDTO bdto) throws Exception{
		return bdao.fixAfterBoard(bdto);
	}

}
