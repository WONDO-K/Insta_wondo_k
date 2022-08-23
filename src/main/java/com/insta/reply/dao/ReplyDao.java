package com.insta.reply.dao;

import java.util.HashMap;
import java.util.List;

import com.insta.reply.vo.ReplyVo;

public interface ReplyDao {

	List<ReplyVo> getReplyListSP(HashMap<String, Object> map);

	List<ReplyVo> getReplyList(int post_num);

	List<ReplyVo> getReplyViewList(int post_num);

}
