<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board_list</title>
</head>
<script type="text/javascript">
</script>
<body>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<%-- <c:if test="${not empty deleteMsg}"> --%>
<!-- 	<script type="test/javascript"> -->
<!-- 		alert("삭제에 성공하였습니다."); -->
<!-- 	</script> -->
<%-- </c:if> --%>
	<div>
		<form action="${ctx}/search" method="post">
			<fieldset>
				<select name="select">
					<option value="btitle">제목</option>
					<option value="bnum">글 번호</option>
					<option value="bwriter">작성자</option>
				</select>
				<input type="text" name="search">
				<input type="submit" value="검색">
			</fieldset>
		</form>
	</div>
	<table border="1">
		<c:if test="${not empty pageInfo.bList}">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일시</th>
		</tr>
		
		<c:forEach items="${pageInfo.bList}" var="b">
			<tr>
				<td>${b.bnum}</td>
				<td><a href="${ctx}/read/${b.bnum}">${b.btitle}</a></td>
				<td>${b.bwriter}</td>
				<!--  <td><fmt:formatDate value="${b.bregdate}" type="both" timeStyle="short" dateStyle="short"/> </td>-->
				<td><fmt:formatDate value="${b.bregdate}" type="both" pattern="yyyy/MM/dd a hh:mm"/> </td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4">
				<c:if test="${pageInfo.startPage > 1}">
					<a href="${ctx}/list?page=${pageInfo.startPage-1}">[이전]</a>
				</c:if>
				
				<c:forEach var="i" begin="${pageInfo.startPage}" end="${pageInfo.endPage}">
					<a href="${ctx}/list?page=${i}">[${i}]</a>
				</c:forEach>
				
				<c:if test="${pageInfo.endPage < pageInfo.totalPage}">
					<a href="${ctx}/list?page=${pageInfo.endPage+1}">[다음]</a>
				</c:if>
			</td>
		</tr>
		</c:if>

		<c:if test="${empty pageInfo.bList}">
		게시글이 존재하지 않습니다. 게시글을 작성해 주세요.
		</c:if>
	</table>
	<a href="${ctx}/write">[글 작성하러 가기]</a>
</body>
</html>