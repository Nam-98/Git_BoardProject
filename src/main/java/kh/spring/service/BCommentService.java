package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.BCommentDAO;
import kh.spring.dto.BCommentDTO;

@Service
public class BCommentService {
	
	@Autowired
	private BCommentDAO cdao;

	public List<BCommentDTO> searchComment(int board_num) throws Exception{
		return cdao.searchComment(board_num);
	}
}
