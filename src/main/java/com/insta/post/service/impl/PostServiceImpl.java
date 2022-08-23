package com.insta.post.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insta.post.dao.PostDao;
import com.insta.post.service.PostService;
import com.insta.post.vo.PostVo;

@Service("postService")
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostDao postDao;
	
	
	@Override
	public List<PostVo> getPostListSP(HashMap<String,Object>map) {
		List<PostVo> postlist = postDao.getPostListSP(map); 
		return postlist;
	}


	@Override
	public List<PostVo> getViewPost(int post_num) {
		List<PostVo> PostViewList = postDao.getPostViewList(post_num);
		return PostViewList;
	}


	@Override
	public List<PostVo> getUnderList(String nickname) {
		List<PostVo> underList = postDao.getUnderList(nickname);
		return underList;
	}




}
