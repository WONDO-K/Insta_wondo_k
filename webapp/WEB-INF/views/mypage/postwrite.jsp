<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/postwrite.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
  
  <!-- 상단 고정 -->
  <%@ include file="/WEB-INF/include/fix.jsp" %>
  
  <div class="all_postwrite">
  <form action="/PostWrite?email=${ user.email }" method="POST" enctype="multipart/form-data">
  
  <p>게시글 쓰기</p>
  
    <div class="write_post1">
      <div id="postfile">
  	    <label class="write_input" id="post_img" name="post_img" >게시글 사진</label>
  	    <input type="file" id="uploadFile" name="uploadFile"/>
  	  </div>
    </div>
  
    <div class="write_post2">
	  <div class="profile_picture">
	    <label class="write_input">프로필 사진</label>
	    <img src="/img/${ user.p_thumbnail }" width="50" height="50"/>
	  </div>
	  <div>
	    <label class="write_input">닉네임</label>
	    <input type="text" name="nickname" id="nickname" value="${ user.nickname }" />
	  </div>
	  <div>
	    <label class="write_input">장소</label>
	    <input type="text" name="place" id="place" />
	  </div>
	  <div>
	    <label class="write_input">게시글 내용</label>
	    <textarea rows="10" cols="22" name="post_cont" id="post_cont" value="post_cont"></textarea>
	  </div>
    </div>
    
    <div class="submit">
  	  <input type="submit" value="글쓰기" />
  	</div>
  	
  </form>
  </div>
  
</body>
</html>