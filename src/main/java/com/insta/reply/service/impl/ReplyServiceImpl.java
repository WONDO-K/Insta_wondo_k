package com.insta.reply.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insta.reply.dao.ReplyDao;
import com.insta.reply.service.ReplyService;
import com.insta.reply.vo.ReplyVo;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDao replyDao;

	@Override
	public List<ReplyVo> getReplyListSP(HashMap<String, Object> map) {
		List<ReplyVo> replyList = replyDao.getReplyListSP(map);
		return replyList;
	}

	@Override
	public List<ReplyVo> getReplyList(int post_num) {
		List<ReplyVo> replyList = replyDao.getReplyList(post_num);
		return replyList;
	}

	@Override
	public List<ReplyVo> getReplyViewList(int post_num) {
		List<ReplyVo> ReplyViewList = replyDao.getReplyViewList(post_num);
		return ReplyViewList;
	}


}
