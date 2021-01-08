package kh.spring.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.BCommentDTO;
import kh.spring.service.BCommentService;

@Controller
@RequestMapping("/bcomment")
public class BCommentController {

	@Autowired
	private BCommentService cservice;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("commentWrite.comment")
	public String commentWrite(HttpServletRequest request, BCommentDTO dto) throws Exception{
		dto.setContents(request.getParameter("content"));
		dto.setWriter((String) session.getAttribute("login"));
		dto.setBoard_seq(Integer.parseInt(request.getParameter("seq")));

		int result = cservice.insertComment(dto);
		request.setAttribute("result", result);
		request.setAttribute("board_num", dto.getBoard_seq());
		return "comment/commentWriteResult";
	}
}
