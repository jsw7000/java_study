<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
</head>
<body>
<%@ include file="include/header.jsp" %>
<script type="text/javascript">
	alert('로그인이 필요한 기능입니다.');
	location.href='${ctx}/';
</script>
</body>
</html>