package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.BoardDAO;
import kh.spring.dto.BoardDTO;

import kh.spring.statics.BoardConfigurator;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO bdao;
	
	public List<BoardDTO> listByCpage(int cpage) throws Exception {		
		return bdao.listByCpage(cpage);
	}

	public String getNavi(int currentPage) throws Exception {
		// 설정값 정하기 :
		// 총 데이터가 몇개 있는지
		
		int a = bdao.listBoardAll().size();
		int recordTotalCount = a;

		// 한 페이지에 몇 개의 글을 보여줄건지.
		int recordCountPerPage = BoardConfigurator.recodeCountPerPage; // 한 페이지에 8개씩 게시물을 보여줄 예정

		// 한 페이지에서 몇 개의 네비넘버를 볼건지
		int naviCountPerPage = BoardConfigurator.naviCountPerPage; // 한 페이지에 네비게이터는 10개씩 보여줄 예정

		// 총 페이지 갯수
		int pageTotalCount;
		if (recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}

		// 사용자는 현재 4페이지에 있다고 가정
		// int currentPage= 4;
		// 보안처리 코드(클라이언트가 넘겨주는 유일한 값이기 때문에 보안에 취약할 수 있다.)
		if (currentPage < 1) {
			currentPage = 1;
		} else if (currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		// 시작 위치는 현재위치에서 1빼고 10나누고(몫) 10 곱하고 1더하면 됨.
		int startNavi = (currentPage - 1) / naviCountPerPage * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;

		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		// boolean needPrev1 = true;
		boolean needNext = true;
		// boolean needNext1 = true;

		if (startNavi == 1) {
			needPrev = false;
		}
		if (endNavi == pageTotalCount) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();

		if (startNavi != 1) {
			sb.append("<a href ='/board/mainBoard.board?cpage=1'><맨 앞으로></a>");
			sb.append("&nbsp;&nbsp;&nbsp;&nbsp;");
		}

		if (needPrev) {
			sb.append("<a href ='mainBoard.board?cpage=" + (startNavi - 1) + "'>◀</a>");
		}
		for (int i = startNavi; i <= endNavi; i++) {
			sb.append("<a href ='mainBoard.board?cpage=" + i + "'>" + i + "</a>");
			sb.append(" ");
		}
		if (needNext) {
			sb.append("<a href ='mainBoard.board?cpage=" + (endNavi + 1) + "'>▶</a>");
		}

		if (endNavi != pageTotalCount) {
			sb.append("&nbsp;&nbsp;&nbsp;&nbsp;");
			sb.append("<a href ='mainBoard.board?cpage=" + pageTotalCount + "'>" + "<맨 끝으로></a>");
		}

		return sb.toString();
	}
	public int insertBoard(BoardDTO bdto) throws Exception{
		System.out.println("서비스 :: "+bdto.getWriter() +":::" + bdto.getContent());
		return bdao.insertBoard(bdto);
	}
	
	public BoardDTO fixBeforeBoard(int seq) throws Exception{
		return bdao.fixBeforeBoard(seq);
	}
	
	public int fixAfterBoard(BoardDTO bdto) throws Exception{
		return bdao.fixAfterBoard(bdto);
	}

	//seq로 글 정보 불러오기
	public BoardDTO searchBoard(int seq) throws Exception {
		return bdao.searchBoard(seq);
	}
	//조회수 +1
	public int addViewCountBoard(int seq) throws Exception {
		return bdao.addViewCountBoard(seq);
	}
	
	//글삭제
	public int deleteBoard(int seq) throws Exception{
		return bdao.deleteBoard(seq);
	}
	
}
