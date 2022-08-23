package com.insta.post.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insta.post.dao.PostDao;
import com.insta.post.vo.PostVo;

@Repository("postDao")
public class PostDaoImpl implements PostDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<PostVo> getPostListSP(HashMap<String, Object> map) {
		
		//map은 inout 역할 : cursor 값을 map으로 돌려받는 호출
		System.out.println("PostDAO MAP1:" + map);
		sqlSession.selectList("Post.PostListSP",map);
		System.out.println("PostDAO MAP2:" + map);
		List<PostVo> PostList = (List<PostVo>) map.get("result");
		System.out.println("postDao: " + PostList);
		return PostList;
	}

	@Override
	public List<PostVo> getPostViewList(int post_num) {
		List<PostVo> PostViewList = sqlSession.selectList("Post.ViewPost",post_num);
		return PostViewList;
	}

	@Override
	public List<PostVo> getUnderList(String nickname) {
		List<PostVo> underList = sqlSession.selectList("Post.UnderList",nickname);
		return underList;
	}

	
}
