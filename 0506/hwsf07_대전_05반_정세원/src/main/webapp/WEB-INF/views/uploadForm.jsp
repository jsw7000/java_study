<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<meta charset="UTF-8">
<title>uploadForm.jsp</title>
</head>
<body>
	파일을 선택하세요.<br>
	<form action="${ctx}/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="uploadFile">
		<input type="submit" value="전송">
	</form>
</body>
</html>