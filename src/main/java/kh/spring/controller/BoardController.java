package kh.spring.controller;


import java.util.ArrayList;
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
	
	@RequestMapping("mainBoard.board")
	public String mainBoard(HttpServletRequest request) throws Exception {
		String cpage = request.getParameter("cpage");
		List<BoardDTO> list = new ArrayList<>();
		list = bservice.listByCpage(Integer.parseInt(cpage));
		String navi = bservice.getNavi(Integer.parseInt(cpage));

		session.setAttribute("list", list);
		session.setAttribute("navi", navi);
		session.setAttribute("cpage", cpage);


		return "board/mainBoardView";
	}
	
	@RequestMapping("contentsBoard.board")
	public String contentsBoard(HttpServletRequest request, BoardDTO dto) throws Exception {
		//----------합칠때 지울거(가짜 로그인, 가짜 글번호)---------
		System.out.println("들어오나요");
		session.setAttribute("id", "test");
		request.setAttribute("seq","1");
		//---------------------------------------------------------
		
		dto.setSeq(Integer.parseInt(request.getParameter("seq")));
		BoardDTO dtos = bservice.searchBoard(dto.getSeq());
		 List<BCommentDTO> list = cservice.searchComment(dto.getSeq());
		int result = bservice.addViewCountBoard(dto.getSeq());
		session.setAttribute("dtos", dtos);
		session.setAttribute("list", list);
		return "/board/clickBoardView";
	}
	
	@RequestMapping("deleteBoard.board")
	public String deleteBoard(HttpServletRequest request, BoardDTO dto) throws Exception{
		System.out.println("글삭제하러 들어왔습니다.");
		dto.setSeq(Integer.parseInt(request.getParameter("seq")));
		//int result = bservice.deleteBoard(dto.getSeq());
		return "";
	}
	
	@RequestMapping("fixBeforeBoard.board")
	public String fixBoard(HttpServletRequest request, BoardDTO dto) throws Exception{
		dto.setSeq(Integer.parseInt(request.getParameter("seq")));
		return "";
	}
}
