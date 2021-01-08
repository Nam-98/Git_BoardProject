package kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.BoardDAO;
import kh.spring.dto.BoardDTO;
@Service
public class BoardService {
	
	@Autowired
	private BoardDAO bdao;

	//seq로 글 정보 불러오기
	public BoardDTO searchBoard(int seq) throws Exception {
		return bdao.searchBoard(seq);
	}
	//조회수 +1
	public int addViewCountBoard(int seq) throws Exception {
		return bdao.addViewCountBoard(seq);
	}
	
}
