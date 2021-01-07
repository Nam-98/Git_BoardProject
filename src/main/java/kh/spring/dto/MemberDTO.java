package kh.spring.dto;

import java.util.Date;

import kh.spring.encryptUtils.EncryptUtils;

public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String contact;
	private String zipcode;
	private String address1;
	private String address2;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public MemberDTO(String id, String pw, String name, String email, String contact, String zipcode, String address1,
			String address2) {
		this.id = id;
		this.pw = EncryptUtils.getSHA256(pw);
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.zipcode = zipcode;
		this.address1 = address1;
		this.address2 = address2;
	}
	public MemberDTO() {
	}

	
}
