package com.insta.post.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.insta.post.vo.PostVo;

@Service("postService")
public interface PostService {

	List<PostVo> getPostListSP(HashMap<String, Object> map);

	List<PostVo> getViewPost(int post_num);

	List<PostVo> getUnderList(String nickname);


}
