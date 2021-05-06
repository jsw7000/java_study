<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<meta charset="UTF-8">
<title>uploadResult.jsp</title>
</head>
<body>
파일 업로드 완료.
<a href="${ctx}/fileList">[파일 목록으로 가기]</a>
</body>
</html>