package kh.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
