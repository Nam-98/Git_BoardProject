package kh.spring.dto;

import java.util.Date;

import kh.spring.encryptUtils.EncryptUtils;

public class BMemberDTO {
	private String id; // pk
	private String pw;
	private String name;
	private String email;
	private String contact;
	private Date reg_date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = EncryptUtils.getSHA256(pw);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public BMemberDTO(String id, String pw, String name, String email, String contact, Date reg_date) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.reg_date = reg_date;
	}
	public BMemberDTO() {
		super();
	}	
	
}
