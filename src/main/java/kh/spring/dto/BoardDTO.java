package kh.spring.dto;

import java.util.Date;


public class BoardDTO {

	private int seq;
	private String writer;
	private String title;
	private String content;
	private int view_count;
	private Date write_date;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}

	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	
	public BoardDTO(int seq, String writer, String title, String content, int view_count, Date write_date) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.view_count = view_count;
		this.write_date = write_date;
	}
	public BoardDTO() {
	}
	
	
}
