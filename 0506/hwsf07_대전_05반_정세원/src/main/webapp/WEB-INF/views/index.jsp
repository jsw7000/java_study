<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
<%@include file="include/header.jsp" %> <!-- 이런 include된 jsp가 제공될 예정! -->

	<a href="<%=request.getContextPath()%>/list">[게시판 입장하기]</a>
	<a href="<%=request.getContextPath()%>/upload">[파일 업로드 하러가기]</a>
	<a href="<%=request.getContextPath()%>/fileList">[파일 목록 보러가기]</a>
</body>
</html>