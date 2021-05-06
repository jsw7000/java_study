<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<!-- header.jsp -->
	<c:if test="${not empty requestScope.msg}">
		<script type="text/javascript">
			alert('${msg}');
		</script>
	</c:if>


	<c:if test="${empty sessionScope.loginUser}">
		<form action="<%=request.getContextPath()%>/login" method="post">
			<input type="hidden" name="login">
			ID:<input type="text" name="userid"> 
			PW:<input type="password" name="userpwd"> 
			<input type="submit" value="LOGIN">
		</form>
	</c:if>
	<c:if test="${not empty sessionScope.loginUser}">
		<b>${loginUser.username}</b>(${loginUser.userid})님 반갑습니다.
		<a href="<%=request.getContextPath()%>/logout">[로그아웃]</a>
	</c:if>
	<hr>
</body>
</html>