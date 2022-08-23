<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/mypage.css">
</head>
<body>

  <!-- 상단 고정 -->
  <%@ include file="/WEB-INF/include/fix.jsp" %>
  
  <div class="mypage_intro1">
    <div class="picture">
	  <a href="/Mypage/Updateform?email=${ email }">
	    <img src="/img/${ user.p_thumbnail }" width="190" height="190"/>
	  </a>
	</div>
	<div class="mypage_intro2">
	  <div class="mypage_intro3">
	    <div class="nick_name">
	      ${ user.nickname }
	    </div>
	    <div class="email">
	      ${ user.email }
	    </div>
	  </div>  
	  <div class="mypage_intro4">
	    <div class="post">
	      게시글 ${ postCount }
	    </div>
	    <div class="follower">
	      팔로워 ${ followCount }
	    </div>
	    <div class="follow">
	      팔로잉 ${ followingCount }
	    </div>
	  </div>
	  <div class="intro">
	      <textarea>${ user.p_introduce }</textarea>
	  </div>
    <div class="post_write">
      <a href="/Mypage/PostWriteForm?email=${ email }">게시글 작성</a>
    </div>
	</div>
  </div>
  
  
  <hr style="width: 1000px;">
  
  <div class="mypage_post1">
    <div class="mypage_post2">
      <div class="feed">
        <i class="fa fa-th" aria-hidden="true"></i>&nbsp;
                  피드
      </div>
      <div class="love_post">
        <i class="fa fa-bookmark-o" aria-hidden="true"></i>&nbsp;
                  좋아요한 게시물
      </div>
      <div class="my_tag">
        <i class="fa fa-id-badge" aria-hidden="true"></i>&nbsp;
                  본인이 태그된 게시물
      </div>
    </div>
    <div class="mypage_post3">
      <div class="list">
        <img alt="" src="" width="100" height="100" />
      </div>
      <div class="list">
        <img alt="" src="" width="100" height="100" />
      </div>
      <div class="list">
        <img alt="" src="" width="100" height="100" />
      </div>
    </div>
  </div>
</body>
</html>