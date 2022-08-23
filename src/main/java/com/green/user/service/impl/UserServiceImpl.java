package com.green.user.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.user.dao.UserDao;
import com.green.user.service.UserService;
import com.green.user.vo.UserVo;

@Service("userService")
public class UserServiceImpl implements UserService {

	// 우곤 ---------------------------------------------------
	
	@Autowired
	private   UserDao    userDao;
	
	@Override
	public void insertUser(HashMap<String, Object> map) {
		
		userDao.insertUser( map );
		
	}

	@Override
	public UserVo login(HashMap<String, Object> map) {
		
		UserVo   vo   =   userDao.login( map );
		
		return   vo;
	}

	@Override
	public int idChk(UserVo vo) throws Exception {
		System.out.println("service " + vo);
		int result = userDao.idChk(vo);
		return result;
	}

	@Override
	public int nickChk(UserVo vo) throws Exception {
		int result = userDao.nickChk(vo);
		return result;
	}
	
	// 동호 ---------------------------------------------------

	@Override
	public List<UserVo> getUserRecommendListSP(HashMap<String, Object> map) {
		List<UserVo> userRecommendlist = userDao.getUserRecommendListSP(map);
		return userRecommendlist;
	}

	@Override
	public List<UserVo> getUserListSP(HashMap<String, Object> map) {
		List<UserVo> userList = userDao.getUserListSP(map);
		return userList;
	}
	
	// 남욱 ---------------------------------------------------
	
	// 보기
	@Override
	public UserVo getView(HashMap<String, Object> map) {
		
		UserVo userVo = userDao.getView( map );
		
		return userVo;
	}

	// 수정
	@Override
	public void updateUser(HashMap<String, Object> map) {
		
		userDao.updateUser( map );
		
	}

	
	// -----------------------------------------------------------------------------
	
	// 게시글 count
	@Override
	public int getCount(HashMap<String, Object> map) {
		
		int count = userDao.getCount( map );
		
		return count;
	}

	// 팔로우 count
	@Override
	public int getfollowCount(HashMap<String, Object> map) {

		int followCount = userDao.getfollowCount( map );
		
		return followCount;
	}

	// 팔로잉 count
	@Override
	public int getfollowingCount(HashMap<String, Object> map) {

		int followingCount = userDao.getfollowingCount( map );
		
		return followingCount;
	}

	// -----------------------------------------------------------------------------
	
	@Override
	public void insertPost(HashMap<String, Object> map) {
		
		userDao.insertPost( map );
		
	}	
}






