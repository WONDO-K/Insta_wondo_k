package com.insta.reply.vo;

public class ReplyVo {
	private int reply_idx;
	private String reply_writer;
	private int post_num;
	private String reply_cont;
	private String target_id;
	private int reply_class;
	private int reply_order;
	private int grp_num;
	private String regdate;
	private String p_thumbnail;
	
	public ReplyVo() {
		
	}

	public ReplyVo(int reply_idx, String reply_writer, int post_num, String reply_cont, String target_id,
			int reply_class, int reply_order, int grp_num, String regdate, String p_thumbnail) {
		super();
		this.reply_idx = reply_idx;
		this.reply_writer = reply_writer;
		this.post_num = post_num;
		this.reply_cont = reply_cont;
		this.target_id = target_id;
		this.reply_class = reply_class;
		this.reply_order = reply_order;
		this.grp_num = grp_num;
		this.regdate = regdate;
		this.p_thumbnail = p_thumbnail;
	}

	public int getReply_idx() {
		return reply_idx;
	}

	public void setReply_idx(int reply_idx) {
		this.reply_idx = reply_idx;
	}

	public String getReply_writer() {
		return reply_writer;
	}

	public void setReply_writer(String reply_writer) {
		this.reply_writer = reply_writer;
	}

	public int getPost_num() {
		return post_num;
	}

	public void setPost_num(int post_num) {
		this.post_num = post_num;
	}

	public String getReply_cont() {
		return reply_cont;
	}

	public void setReply_cont(String reply_cont) {
		this.reply_cont = reply_cont;
	}

	public String getTarget_id() {
		return target_id;
	}

	public void setTarget_id(String target_id) {
		this.target_id = target_id;
	}

	public int getReply_class() {
		return reply_class;
	}

	public void setReply_class(int reply_class) {
		this.reply_class = reply_class;
	}

	public int getReply_order() {
		return reply_order;
	}

	public void setReply_order(int reply_order) {
		this.reply_order = reply_order;
	}

	public int getGrp_num() {
		return grp_num;
	}

	public void setGrp_num(int grp_num) {
		this.grp_num = grp_num;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getP_thumbnail() {
		return p_thumbnail;
	}

	public void setP_thumbnail(String p_thumbnail) {
		this.p_thumbnail = p_thumbnail;
	}

	@Override
	public String toString() {
		return "ReplyVo [reply_idx=" + reply_idx + ", reply_writer=" + reply_writer + ", post_num=" + post_num
				+ ", reply_cont=" + reply_cont + ", target_id=" + target_id + ", reply_class=" + reply_class
				+ ", reply_order=" + reply_order + ", grp_num=" + grp_num + ", regdate=" + regdate + ", p_thumbnail="
				+ p_thumbnail + "]";
	}
	
}