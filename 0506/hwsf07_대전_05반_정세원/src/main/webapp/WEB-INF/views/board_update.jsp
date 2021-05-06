<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board_update.jsp</title>
</head>
<body>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
	<form action="${ctx}/update" method="post">
		
		<table border="1">
			<input type="hidden" name="bnum" value="${boardDto.bnum}">
			<tr>
				<td>제목</td>
				<td><input name="btitle" type="text" value="${boardDto.btitle}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="bcontent" rows="20" cols="30">${boardDto.bcontent}</textarea> </td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="작성완료"></td>
			</tr>
		</table>
	</form>
</body>
</html>