<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board_write</title>
</head>
<body>

<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
	<form action="${ctx}/write" method="post">
		
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input name="btitle" type="text" placeholder="글 제목을 입력하세요."></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="20" cols="30" name="bcontent"></textarea> </td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="작성완료"></td>
			</tr>
		</table>
	</form>
</body>
</html>