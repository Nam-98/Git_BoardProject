package kh.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

		List<BoardDTO> list = new ArrayList();
		System.out.println(cpage);
		list = bservice.listByCpage(Integer.parseInt(cpage));
		String navi = bservice.getNavi(Integer.parseInt(cpage));

		session.setAttribute("list", list);
		session.setAttribute("navi", navi);
		session.setAttribute("cpage", cpage);
		
		return "/board/mainBoardView";
	}
	

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
		return "redirect:/board/mainBoard.board?cpage="+session.getAttribute("cpage");//게시글 리스트 jsp로
	}
	
	//수정 전 글내용 불러오기
	@RequestMapping("fixBeforeBoard.board")
	public String fixBeforeBoard(HttpServletRequest request, Model m) throws Exception{
		int seq = Integer.parseInt(request.getParameter("seq"));
		BoardDTO bdto = bservice.fixBeforeBoard(seq);
		m.addAttribute("bdto", bdto);
	      return "/board/boardFixView";
	   }
	
	//글 수정 후 글내용 저장하기
	@RequestMapping("fixAfterBoard.board")
	public String fixAfterBoard(BoardDTO bdto) throws Exception{
		int result = bservice.fixAfterBoard(bdto);
		System.out.println("글수정 성공유무 ::"+result);
		return "redirect:/board/mainBoard.board?cpage=1";//게시글 리스트 jsp로
	}
	
	//글제목 클릭 시, 글 세부 사항
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
	
	//글삭제
	@RequestMapping("deleteBoard.board")
	public String deleteBoard(HttpServletRequest request, BoardDTO dto) throws Exception{
		dto.setSeq(Integer.parseInt(request.getParameter("seq")));
		int result = bservice.deleteBoard(dto.getSeq());
		return "redirect:/board/mainBoard.board?cpage="+session.getAttribute("cpage");
	}

	@ExceptionHandler
	public String exceptionalHandler(Throwable e) {
		e.printStackTrace();
		return "error";
	}

}
