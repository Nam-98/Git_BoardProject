package kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.BCommentDTO;
import kh.spring.dto.BoardDTO;
import kh.spring.service.BCommentService;
import kh.spring.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService bservice;

	@Autowired
	private BCommentService cservice;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("contentsBoard.board")
	public String contentsBoard(HttpServletRequest request, BoardDTO dto) throws Exception {
		dto.setSeq(Integer.parseInt(request.getParameter("seq")));
		BoardDTO dtos = bservice.searchBoard(dto.getSeq());
		 List<BCommentDTO> list = cservice.searchComment(dto.getSeq());
		int result = bservice.addViewCountBoard(dto.getSeq());
		session.setAttribute("dtos", dtos);
		session.setAttribute("list", list);
		return "/board/clickBoardView";
	}
	
}
