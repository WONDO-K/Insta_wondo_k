<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Dancing+Script" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/fix.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="fix">
  <div class="fix_title">Instamilligram</div>
  <div class="fix_search_bar">
    <i class="fa fa-search" aria-hidden="true"></i>
    <input class="fix_search" type="search" placeholder="검색" />
  </div>
  <div class="icon">
   <div class="fix_message">
     <a href="">
       <i class="fa fa-paper-plane-o" aria-hidden="true"></i>
     </a>
   </div>
   <div class="fix_notice">
     <a href="">
       <i class="fa fa-heart-o" aria-hidden="true"></i>
     </a>
   </div>
   <div class="fix_profile">
     <a href="/Mypage/Profile?email=${ user.email }"><img src="/img/${ user.p_thumbnail }"/></a>
   </div>
  </div>
</div>
<hr>
</body>
</html>