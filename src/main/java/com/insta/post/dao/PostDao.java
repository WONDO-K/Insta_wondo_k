package com.insta.post.dao;

import java.util.HashMap;
import java.util.List;

import com.insta.post.vo.PostVo;

public interface PostDao {


	List<PostVo> getPostListSP(HashMap<String, Object> map);

	List<PostVo> getPostViewList(int post_num);

	List<PostVo> getUnderList(String nickname);






}
