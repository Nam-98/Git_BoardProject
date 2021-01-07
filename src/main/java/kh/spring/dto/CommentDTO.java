package kh.spring.dto;

import java.util.Date;

public class CommentDTO {

	private int seq;
	private String writer;
	private String comments;
	private Date write_date;
	private int board_seq;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getComments() {
		return comments;
	}
	public void setComment(String comment) {
		this.comments = comment;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public CommentDTO(int seq, String writer, String comments, Date write_date, int board_seq) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.comments = comments;
		this.write_date = write_date;
		this.board_seq = board_seq;
	}
	public CommentDTO() {
		super();
	}
	
}
