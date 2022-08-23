package com.green.user.dao;

import java.util.HashMap;
import java.util.List;

import com.green.user.vo.UserVo;

public interface UserDao {
	
	// 우곤 ---------------------------------------------------

	void insertUser(HashMap<String, Object> map);

	UserVo login(HashMap<String, Object> map);

	public int idChk(UserVo vo) throws Exception;

	public int nickChk(UserVo vo) throws Exception;
	
	// 동호 ---------------------------------------------------
	
	List<UserVo> getUserRecommendListSP(HashMap<String, Object> map);

	List<UserVo> getUserListSP(HashMap<String, Object> map);
	
	// 남욱 ---------------------------------------------------
	
	// 보기
	UserVo getView(HashMap<String, Object> map);

	// 수정
	void updateUser(HashMap<String, Object> map);

	
	// -----------------------------------------------------------------------------
	
	// 게시글 count
	int getCount(HashMap<String, Object> map);

	// 팔로우 count
	int getfollowCount(HashMap<String, Object> map);

	// 팔로잉 count
	int getfollowingCount(HashMap<String, Object> map);
	
	// -----------------------------------------------------------------------------

	// 게시글 쓰기
	void insertPost(HashMap<String, Object> map);
	

}
