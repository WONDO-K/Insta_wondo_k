<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>   
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 
 <% String post_num = request.getParameter("post_num"); %>  
 <% String post_img = request.getParameter("post_img"); %> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/post.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
		$("submit").on("click",function(){
			location.href='';
		})
	})
</script>
</head>
<body>
	<%@ include file="/WEB-INF/include/fix.jsp" %>
	<c:forEach var="post" items="${PostViewList}" varStatus="status">
	<div id="imgarea">
		<div id="postimg">	
			<img id="picture" style="width:600px; height:525px;" src="/img/${post.post_img }">
		</div>
		<div id="replyarea">	
			<a href=""><img id="profile" src="/img/${post.p_thumbnail }"></a>
				<div id="userinfo">
				<!-- style="border: none; background: transparent;" -->
					<a href=""><input id="nickname_click" type="text" style="border: none; background: transparent; pointer-events: none;" value="${post.nickname}"><br></a>
					<input id="place" type="text" style="border: none; background: transparent; pointer-events: none;" value="${post.place }">
				</div>
				<hr>			
				<div>				
					<a href=""><img id="profile" src="/img/${post.p_thumbnail }" ></a>
					<div id="mytag">
						<a href=""><input id="nickname_click" type="text" style="border: none; background: transparent; pointer-events: none; width:70px; " value="${post.nickname }"></a>
						<input type="text"  style="border: none; background: transparent; pointer-events: none;" value="#김남욱">
					</div>	

					<input type="text"  style="border: none; background: transparent; pointer-events: none; font-size:5px;" value="2일 ">		
				</div>
				<!-- 반복문 사용 7개 사용가능 --> 
				<c:forEach var="replys" items="${prList.get(status.index)}">
					<div id="reply">
						<a href=""><img id="profile" src="/img/${replys.p_thumbnail }" ></a>
						<a href=""><input id="nickname_click" type="text" style="border: none; background: transparent; pointer-events: none;" value="${replys.reply_writer }"></a>
						<input type="text"  style="border: none; background: transparent; pointer-events: none;" value="${replys.reply_cont }">				
					</div>
				</c:forEach>					
			
				<div id="inputreply">
				<hr>
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
					<div style="clear:both;">
						<a href=""><img id="profile_mini" src="" ></a>
						<input id="wholike" type="text" style="border: none; background: transparent; pointer-events: none;" value="knw님 외 2명이 좋아합니다.">
						<input id="regdate" type="text" style="border: none; background: transparent; pointer-events: none; font-size:5px;" value="2022년 01월 09일">
						<hr>
							<form action="" method="post">
								<input id="replycont" name="replycont" style="margin:10px 0 0 5px;" type="text" style="border: none; background: transparent;" placeholder="댓글 달기...">
								<input type="submit" id="insertReply" style="height:36px; float:right; margin:10px 8px 0 0;" value="게시">
						    </form>
					</div>
				</div>
		</div>		
	</div>


	<br>
	<hr style="width:925px; margin: 0 0 0 465px;">
	<br>
	<div id="underfeed">
		<input type="text" style="border: none; background: transparent; pointer-events:none;" value="${post.nickname}님의 게시물 더 보기"><br><br>
		<c:forEach var="under" items="${ underList }">
		<a href="/Post?post_num=${under.post_num }"><img id="underpicture" src="/img/${ under.post_img }"></a>

		</c:forEach>
	</div>
	</c:forEach>
</body>
</html>