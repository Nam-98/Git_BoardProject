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

	public List<BCommentDTO> searchComment(int board_seq) throws Exception{
		return cdao.searchComment(board_seq);
	}
	
	public int insertComment(BCommentDTO dto) throws Exception {
		return cdao.insertComment(dto);
	}
	
	public int deleteBComment(int seq) throws Exception {
		return cdao.deleteBComment(seq);
	} 
}
