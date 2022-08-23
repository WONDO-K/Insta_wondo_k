package com.insta.reply.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insta.reply.dao.ReplyDao;
import com.insta.reply.vo.ReplyVo;

@Repository("replyDao")
public class ReplyDaoImpl implements ReplyDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ReplyVo> getReplyListSP(HashMap<String, Object> map) {
		System.out.println("ReplyList DAO MAP1:" + map);
		sqlSession.selectList("Reply.ReplyListSP", map);
		System.out.println("ReplyList DAO MAP2:" + map);
		List<ReplyVo> ReplyList = (List<ReplyVo>) map.get("result");
		System.out.println("replyDao:" + ReplyList);
		return ReplyList;
	}

	@Override
	public List<ReplyVo> getReplyList(int post_num) {
		List<ReplyVo> ReplyList = sqlSession.selectList("Reply.ReplyList",post_num);
		return ReplyList;
	}

	@Override
	public List<ReplyVo> getReplyViewList(int post_num) {
		List<ReplyVo> ReplyViewList = sqlSession.selectList("Reply.ReplyViewList",post_num);
		return ReplyViewList;
	}

}
