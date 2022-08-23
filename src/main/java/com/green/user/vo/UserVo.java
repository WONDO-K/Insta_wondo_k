package com.green.user.vo;

import org.springframework.web.multipart.MultipartFile;

public class UserVo {

	// Field
	private String email;
	private String nickname;
	private String password;
	private String name;
	private String tel;
	private String joindate;
	private String p_thumbnail;
	private String p_introduce;
	
	private MultipartFile uploadFile;
	private String p_thumbnail_filename;
	
	// Constructor
	public UserVo() {
		
	}	
	public UserVo(String email, String nickname, String password, String name, String tel) {
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.name = name;
		this.tel = tel;
	}
	public UserVo(String email, String nickname, String password, String name, String tel, String joindate,
			String p_thumbnail, String p_introduce) {
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.name = name;
		this.tel = tel;
	}
	public UserVo(String email, String nickname, String password, String name, String tel, String joindate,
			String p_thumbnail, String p_introduce, MultipartFile uploadFile, String p_thumbnail_filename) {
		super();
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.name = name;
		this.tel = tel;
		this.joindate = joindate;
		this.p_thumbnail = p_thumbnail;
		this.p_introduce = p_introduce;
		this.uploadFile = uploadFile;
		this.p_thumbnail_filename = p_thumbnail_filename;
	}
	
	// Getter / Setter
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getP_thumbnail() {
		return p_thumbnail;
	}
	public void setP_thumbnail(String p_thumbnail) {
		this.p_thumbnail = p_thumbnail;
	}
	public String getP_introduce() {
		return p_introduce;
	}
	public void setP_introduce(String p_introduce) {
		this.p_introduce = p_introduce;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getP_thumbnail_filename() {
		return p_thumbnail_filename;
	}
	public void setP_thumbnail_filename(String p_thumbnail_filename) {
		this.p_thumbnail_filename = p_thumbnail_filename;
	}
	
	// toString
	@Override
	public String toString() {
		return "UserVo [email=" + email + ", nickname=" + nickname + ", password=" + password + ", name=" + name
				+ ", tel=" + tel + ", joindate=" + joindate + ", p_thumbnail=" + p_thumbnail + ", p_introduce="
				+ p_introduce + ", uploadFile=" + uploadFile + ", p_thumbnail_filename=" + p_thumbnail_filename + "]";
	}	
	
}
