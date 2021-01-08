package kh.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.BoardDTO;
import kh.spring.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService bservice;
	
	@Autowired
	private HttpSession session;
	
	//게시판 목록에서 글작성 버튼 클릭시
	@RequestMapping("insertBoardClick.board")
	public String insertBtnClick(Model m) throws Exception{
		String id = (String)session.getAttribute("id");
		m.addAttribute("id", id);
		return "/board/boardWriteView";
	}
	
	//글쓰기에서 작성완료 했을 시
	@RequestMapping("insertBoard.board")
	public String insertBoard(BoardDTO bdto) throws Exception{
		int result = bservice.insertBoard(bdto);
		System.out.println("글작성 성공유무 ::"+result);
		return "redirect: /board/mainBoardView";//게시글 리스트 jsp로
	}
	
	//수정 전 글내용 불러오기
	@RequestMapping("fixBeforeBoard.board")
	public String fixBeforeBoard(HttpServletRequest request, Model m) throws Exception{
		String seq = request.getParameter("seq");
		BoardDTO bdto = bservice.fixBeforeBoard(seq);
		m.addAttribute("bdto", bdto);
	      return "/board/boardFixView";
	   }
	
	//글 수정 후 글내용 저장하기
	@RequestMapping("fixAfterBoard.board")
	public String fixAfterBoard(BoardDTO bdto) throws Exception{
		int result = bservice.fixAfterBoard(bdto);
		System.out.println("글수정 성공유무 ::"+result);
		return "redirect:/board/mainBoardView";//게시글 리스트 jsp로
	}
	
	
	
}
