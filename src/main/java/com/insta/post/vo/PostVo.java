package com.insta.post.vo;

import org.springframework.web.multipart.MultipartFile;

public class PostVo {

	private int    post_num;
	private String nickname;
	private String post_cont;
	private String post_img;
	private String regdate;
	private String place;
	private int likecount;
	private int likenum;
	private int like_post_num;
	private String like_post_user;
	
	private String email;
	private String j_nickname;
	private String password;
	private String name;
	private String tel;
	private String joindate;
	private String p_thumbnail;
	private String p_introduce;
	
	private MultipartFile uploadFile;
	private String post_img_filename;
	
	public PostVo() {
		
	}
	public PostVo(int post_num, String nickname, String post_cont, String post_img, String regdate, String place,
			int likecount, MultipartFile uploadFile, String post_img_filename) {
		super();
		this.post_num = post_num;
		this.nickname = nickname;
		this.post_cont = post_cont;
		this.post_img = post_img;
		this.regdate = regdate;
		this.place = place;
		this.likecount = likecount;
		this.uploadFile = uploadFile;
		this.post_img_filename = post_img_filename;
	}
	public PostVo(int post_num, String nickname, String post_cont, String post_img, String regdate, String place,
			int likecount, int likenum, int like_post_num, String like_post_user, String email, String j_nickname,
			String password, String name, String tel, String joindate, String p_thumbnail, String p_introduce) {
		super();
		this.post_num = post_num;
		this.nickname = nickname;
		this.post_cont = post_cont;
		this.post_img = post_img;
		this.regdate = regdate;
		this.place = place;
		this.likecount = likecount;
		this.likenum = likenum;
		this.like_post_num = like_post_num;
		this.like_post_user = like_post_user;
		this.email = email;
		this.j_nickname = j_nickname;
		this.password = password;
		this.name = name;
		this.tel = tel;
		this.joindate = joindate;
		this.p_thumbnail = p_thumbnail;
		this.p_introduce = p_introduce;
	}

	public int getPost_num() {
		return post_num;
	}
	public void setPost_num(int post_num) {
		this.post_num = post_num;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPost_cont() {
		return post_cont;
	}
	public void setPost_cont(String post_cont) {
		this.post_cont = post_cont;
	}
	public String getPost_img() {
		return post_img;
	}
	public void setPost_img(String post_img) {
		this.post_img = post_img;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getLikecount() {
		return likecount;
	}
	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}
	public int getLikenum() {
		return likenum;
	}
	public void setLikenum(int likenum) {
		this.likenum = likenum;
	}
	public int getLike_post_num() {
		return like_post_num;
	}
	public void setLike_post_num(int like_post_num) {
		this.like_post_num = like_post_num;
	}
	public String getLike_post_user() {
		return like_post_user;
	}
	public void setLike_post_user(String like_post_user) {
		this.like_post_user = like_post_user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJ_nickname() {
		return j_nickname;
	}
	public void setJ_nickname(String j_nickname) {
		this.j_nickname = j_nickname;
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
	public String getPost_img_filename() {
		return post_img_filename;
	}
	public void setPost_img_filename(String post_img_filename) {
		this.post_img_filename = post_img_filename;
	}
	
	@Override
	public String toString() {
		return "PostVo [post_num=" + post_num + ", nickname=" + nickname + ", post_cont=" + post_cont + ", post_img="
				+ post_img + ", regdate=" + regdate + ", place=" + place + ", likecount=" + likecount + ", likenum="
				+ likenum + ", like_post_num=" + like_post_num + ", like_post_user=" + like_post_user + ", email="
				+ email + ", j_nickname=" + j_nickname + ", password=" + password + ", name=" + name + ", tel=" + tel
				+ ", joindate=" + joindate + ", p_thumbnail=" + p_thumbnail + ", p_introduce=" + p_introduce
				+ ", uploadFile=" + uploadFile + ", post_img_filename=" + post_img_filename + "]";
	}
	
	
}
