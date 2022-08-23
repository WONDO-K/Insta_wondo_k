<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>   
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   <!-- forEach사용을 위한  -->
 
 <% String nickname = request.getParameter("nickname"); %>
 <% String name = request.getParameter("name"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

</style>
</head>
<body>
	<%@ include file="/WEB-INF/include/fix.jsp" %>

	<c:forEach var="post" items="${ postList }"  varStatus="status">
	<div id="feed">	
		<a href="/Mypage/Profile?email=${ user.email }"><img id="profile" src="/img/${ post.p_thumbnail }"></a>
			<div id="userinfo">
			<!-- style="border: none; background: transparent;" -->
				<a href=""><input id="nickname_click" type="text" style="border: none; background: transparent;" value="${ post.nickname }"><br></a>
				<input id="place" type="text" style="border: none; background: transparent;" value="${post.place}">
			</div>
		<hr>		
			<a href="/Post?post_num=${ post.post_num }"><img id="postimg" src="/img/${ post.post_img }"></a>
			
			<div id="icon">	
				<div class="postlike">
				  <a href="">
				  <i class="fa fa-heart-o" aria-hidden="true"></i>
				  </a>
				</div>
				
				<div class="postreply">
				  <a href="">
				 <i class="fa fa-comment-o" aria-hidden="true"></i>
				  </a>
				</div>
							
				<div class="postdm">
				  <a href="">
				  <i class="fa fa-paper-plane-o" aria-hidden="true"></i>
				  </a>
				</div>
			</div>
				<div id="likepeople">
					<a href=""><img id="likeprofile" src=""></a>
					<input id="wholike" type="text" style="border: none; background: transparent;" value="${post.like_post_user}님 외 ${post.likecount }명이 좋아합니다"><br>
					<input id="postcont" type="text"style="border: none; background: transparent;" value="${post.post_cont }">
				</div>
				  <c:forEach  var="reply" items='${ rList.get( status.index ) }'>
					<div id="replyarea">
						<a href=""><img id="replyprofile" src="/img/${reply.p_thumbnail }"></a> 
						<input id="replynickname" type="text" style="border: none; background: transparent;" value="${ reply.reply_writer }">
						<input id="replycont" type="text" style="border: none; background: transparent; " value="${ reply.reply_cont }">
					</div>
				 </c:forEach>	
				
	</div>
	</c:forEach>
	
	<article id="side">
		<div id="sidemyprofile">
			<a href="/Mypage/Profile?email=${ user.email }"><img id="profile" src="/img/${ user.p_thumbnail }"></a>
			<a href=""><input id="nickname_click" type="text" style="border: none; background: transparent;" value="<%= nickname %>"><br></a>
			<input id="nickname" type="text" style="border: none; background: transparent; pointer-events: none;" value="<%= name %>">
			<hr>
		</div>
		
		<div id="recommend" >
			<input type="text" style="border: none; background: transparent; pointer-events: none;margin:0 0 0 5px;" value="회원님을 위한 추천">
			<button id="allview">모두보기</button>	
			
			<ul id="recommenduser">
			<c:forEach var="user" items='${ userRecommendList }'>
				<li>
					<a href=""><img id="profile" src="/img/${user.p_thumbnail}"></a>
					<a href=""><input id="nickname_click" type="text" style="border: none; background: transparent; pointer-events: none;" value="${user.nickname }"></a>
					<button id="follow">팔로우</button>	
					<input type="text" style="border: none; background: transparent; pointer-events: none; " value="회원님을 위한 추천">
				</li>	
			</c:forEach>
			</ul>
		</div>
		<footer  id="sidefooter">
			<span>
				<div id="footermenu">
					<a href="">소개</a>
					<a href="">도움말</a>
					<a href="">홍보 센터</a>
					<a href="">API</a>
					<a href="">채용 정보</a><br>
					<a href="">개인정보처리방침/약관</a>
					<a href="">위치</a>
					<a href="">인기계정</a>
					<a href="">해시태그</a>
					<a href="">언어</a>
				</div>
				<div id="copyright">
					@2020 INSTAMILLIGRAM FROM 95's
				</div>

			</span>
			
		</footer>
	</article>
	
</body>
</html>