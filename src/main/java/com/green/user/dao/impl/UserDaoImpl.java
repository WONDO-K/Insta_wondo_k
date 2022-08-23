package com.green.user.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.user.dao.UserDao;
import com.green.user.vo.UserVo;

@Repository("userDao")
public class UserDaoImpl  implements  UserDao {

	@Autowired
	private  SqlSession  sqlSession;
	
	// 우곤 ---------------------------------------------------
	
	@Override
	public void insertUser(HashMap<String, Object> map) {
		
		String    email    		= (String) map.get("email");
		String    nickname  	= (String) map.get("nickname");
		String    password  	= (String) map.get("password");
		String    name  		= (String) map.get("name");
		String    tel  			= (String) map.get("tel");
		String    joindate  	= (String) map.get("joindate");
		String    p_thumbnail  	= (String) map.get("p_thumbnail");
		String    p_introduce  	= (String) map.get("p_introduce");
		UserVo    vo        =  new UserVo(email, nickname, password, name, tel, joindate, p_thumbnail, p_introduce);
	    sqlSession.insert("User.InsertUser", vo );
	    
	    System.out.println("userdao vo" + vo);
		
	}

	@Override
	public UserVo login(HashMap<String, Object> map) {
		
		UserVo   vo   =  sqlSession.selectOne( "User.Login", map );   
		
		return   vo;
	}

	@Override
	public int idChk(UserVo vo) throws Exception {
		System.out.println("dao " + vo);
		int result = sqlSession.selectOne("User.idChk", vo);
		return result;
	}

	@Override
	public int nickChk(UserVo vo) {
		int result = sqlSession.selectOne("User.nickChk", vo);
		return result;
	}
	
	// 동호 ---------------------------------------------------

	@Override
	public List<UserVo> getUserRecommendListSP(HashMap<String, Object> map) {
		System.out.println("UserRecommend DAO MAP1:" + map);
		sqlSession.selectList("User.UserRecommendListSP",map);
		System.out.println("UserRecommend DAO MAP2:" + map);
		List<UserVo> UserRecommendList = (List<UserVo>) map.get("result");
		System.out.println("userDao:" + UserRecommendList);
		return UserRecommendList;
	}

	@Override
	public List<UserVo> getUserListSP(HashMap<String, Object> map) {
		System.out.println("UserList DAO MAP1:" + map);
		sqlSession.selectList("User.UserListSP",map);
		System.out.println("UserList DAO MAP2:" + map);
		List<UserVo> UserList = (List<UserVo>) map.get("result");
		System.out.println("userDao:" + UserList);
		return UserList;
	}
	
	// 남욱 ---------------------------------------------------
	
	// 보기
	@Override
	public UserVo getView(HashMap<String, Object> map) {

		sqlSession.selectList("User.UserView", map);
		
		List<UserVo> userList = (List<UserVo>) map.get("result");
		UserVo   userVo   = userList.get(0);
		
		return userVo;
	
	}

	// 수정
	@Override
	public void updateUser(HashMap<String, Object> map) {
        System.out.println("1daomap" + map);
		sqlSession.update("User.UserUpdate", map);
		System.out.println("2daomap" + map);
		
		
	}

	
	// -----------------------------------------------------------------------------
	
	// 게시글 count
	@Override
	public int getCount(HashMap<String, Object> map) {
		
		sqlSession.selectOne("Post.PostCount", map);
		
		int count = (int) map.get("result");
		
		return count;
	}

	// 팔로우 count
	@Override
	public int getfollowCount(HashMap<String, Object> map) {
		
		sqlSession.selectOne("Follow.FollowCount", map);
		
		int followcount = (int) map.get("result");
		
		return followcount;
	}

	// 팔로잉 count
	@Override
	public int getfollowingCount(HashMap<String, Object> map) {
		
		sqlSession.selectOne("Follow.FollowingCount", map);
		
		int followingcount = (int) map.get("result");
		
		return followingcount;
	}

	// -----------------------------------------------------------------------------
	
	// 게시글 쓰기
	@Override
	public void insertPost(HashMap<String, Object> map) {
		
		sqlSession.insert("Post.PostInsert", map);
		
	}
}





