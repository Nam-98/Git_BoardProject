package kh.spring.dto;

import java.sql.Date;

public class FileDTO {
	private int seq;
	private int parent_seq; //-> 만약 게시판에 첨부파일로 올리는 경우라면 해당 파일이 어느 게시글에 올라간 파일인지 확인해야 하므로 필요
	private String oriName;
	private String savedName;
	private Date uploadedDate;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getParent_seq() {
		return parent_seq;
	}
	public void setParent_seq(int parent_seq) {
		this.parent_seq = parent_seq;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	public String getSavedName() {
		return savedName;
	}
	public void setSavedName(String savedName) {
		this.savedName = savedName;
	}
	public Date getUploadedDate() {
		return uploadedDate;
	}
	public void setUploadedDate(Date uploadedDate) {
		this.uploadedDate = uploadedDate;
	}
	public FileDTO(int seq, int parent_seq, String oriName, String savedName, Date uploadedDate) {
		super();
		this.seq = seq;
		this.parent_seq = parent_seq;
		this.oriName = oriName;
		this.savedName = savedName;
		this.uploadedDate = uploadedDate;
	}
	public FileDTO() {
		super();
	}

}
