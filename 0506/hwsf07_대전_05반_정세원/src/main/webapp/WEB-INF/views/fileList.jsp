<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileList.jsp</title>
</head>
<body>
<table border="">
	<tr>
		<th>파일명</th>
		<th>실제 저장정보</th>
	</tr>
	<c:forEach items="${fileList}" var="f">
		<tr>
			<td><a href="download?fno=${f.fno}">${f.filename}</a></td>
			<td>${f.origin }</td>
		</tr>
	</c:forEach>

</table>
</body>
</html>