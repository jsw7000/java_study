<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search_result.jsp</title>
</head>
<body>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
	<h2>검색 결과</h2>
	<table border="1">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일시</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty searchList}">
				<c:forEach items="${searchList}" var="b">
					<tr>
						<td>${b.bnum}</td>
						<td><a href="${ctx}/read/${b.bnum}">${b.btitle}</a></td>
						<td>${b.bwriter}</td>
						<td><fmt:formatDate value="${b.bregdate}" type="both" pattern="yyyy/MM/dd a hh:mm"/></td>
					</tr>			
				</c:forEach>
			</c:if>
			<c:if test="${empty searchList}">
				<tr>
					<td colspan="3">검색 결과가 존재하지 않습니다.</td>
				</tr>
			</c:if>
		</tbody>
	</table>
</body>
</html>