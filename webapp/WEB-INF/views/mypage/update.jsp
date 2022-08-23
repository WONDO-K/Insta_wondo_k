<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/update.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
  
  <!-- 상단 고정 -->
  <%@ include file="/WEB-INF/include/fix.jsp" %>
  
 
  <div class="all_update">
  
  <form action="/Update?email=${ user.email }" method="POST" enctype="multipart/form-data">
  <input type="hidden" id="p_thumbnail_filename" name="p_thumbnail_filename" value="${ user.p_thumbnail_filename }" />
    <h3>프로필 편집</h3>
  
  	<div class="update_profile1">
  	
  	  <%-- <c:if test="${user.p_thumbnail ne null}"> --%>
  	  <div id="divfile">
  	    <label class="update_input" id="p_thumbnail" name="p_thumbnail" >${ user.p_thumbnail }</label>
  	    <input type="file" id="uploadFile" name="uploadFile"/>
  	  </div>
  	 <%--  </c:if> --%>
  	  
  	</div>
  	
	<div class="update_profile2">
  	  <div>
  	  	<label class="update_input">이메일</label>
  	  	<input type="text" name="email" id="email" value="${ user.email }" readonly />
  	  </div>
  	  <div>
  	  	<label class="update_input">닉네임</label>
  	  	<input type="text" name="nickname" id="nickname" value="${ user.nickname }" />
  	  </div>
  	  <div>
  	  	<label class="update_input">비밀번호</label>
  	  	<input type="text" name="password" id="password" value="${ user.password }" />
  	  </div>
  	  <div>
  	  	<label class="update_input">이름</label>
  	  	<input type="text" name="name" id="name" value="${ user.name }" readonly />
  	  </div>
  	  <div>
  	  	<label class="update_input">전화번호</label>
  	  	<input type="text" name="tel" id="tel" value="${ user.tel }" />
  	  </div>
  	  <div>
  	  	<label class="update_input">가입날짜</label>
  	  	<input type="text" name="joindate" id="joindate" value="${ user.joindate }" readonly />
  	  </div>
  	  <div>
  	  	<label class="update_input">자기소개</label>
  	  	<textarea rows="3" cols="22" name="p_introduce" id="p_introduce" >${ user.p_introduce }</textarea>
  	  </div>
  	</div>
  	
  	<div class="submit">
  	  <input type="submit" value="수정하기" />
  	</div>
  	
  </form>
  
  </div>
  
</body>
</html>