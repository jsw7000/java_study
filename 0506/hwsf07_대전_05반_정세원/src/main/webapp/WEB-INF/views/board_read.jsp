<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<meta charset="UTF-8">
<title>read</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">
	function getCmtList(){
		$.ajax({ // 현재 글에 대한 댓글목록 요청해서 받아오기
			url:'${ctx}/ajax?bnum=${boardDto.bnum}',
// 			data:{'bnum':'${boardDto.bnum}'},
			method:'get',
			dataType:'json',
			success:function(data){
// 				data = JSON.parse(data); // 백엔드에서 준 데이터를 현재 그냥 문자열로 인식중이라서..
				let table = '<table border="1">';
				$.each(data, function(idx, cmt){
					table += '<tr>';
					table += '<td>'+cmt['cwriter']+'</td>';
					table += '<td>'+cmt['ccontent']+'</td>';
					table += '</tr>';
				})
				table += '</table>';
				
				$('#cmt-area').html(table);
			}
		})
	}

	$(function(){
		getCmtList(); // 맨 처음에 댓글목록 일단 가져오고.
		
		$('#cmt-btn').click(function(){
			$.ajax({
				url:'${ctx}/ajax',
				data:JSON.stringify({ // javascript의 객체를 java가 알아들을리가 없으니까 문자열 string으로 만들어 보내기
					'bnum' : '${boardDto.bnum}', 
					'ccontent' : $('#cmt-content').val()
					}),
				beforeSend: function (xhr) { // ajax 요청을 보내는 front->back 요청에 헤더 설정이 필요.
				        xhr.setRequestHeader("Accept", "application/json");
				        xhr.setRequestHeader("Content-Type", "application/json");
				},
				method:'post',
				dataType:'text', // back -> front에게 응답하는 response 데이터의 형식
				success:function(data){
					if(data=='success'){
						alert('댓글 작성 완료!');
						$('#cmt-writer').val('');
						$('#cmt-content').val('');
						getCmtList(); // 방금 작성한 댓글 포함해서 다시 댓글 리스트 받아오자!
					}else if(data=='fail'){
						alert('댓글 작성 실패!');
					}else{
						alert('what the....?')
					}
				},
				error:function(){
					alert('error');
				}
			})
		})
	})
</script>	
</head>
<body>
<%@include file="include/header.jsp" %>
	<table border="1">
		<tr>
			<td>제목</td>
			<td>${boardDto.btitle}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${boardDto.bwriter }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${boardDto.bcontent }</td>
		</tr>
	</table>
	<c:if test="${not empty sameWriter}">
		<a href="${ctx}/delete/${boardDto.bnum}">[삭제]</a>	
		<a href="${ctx}/update/${boardDto.bnum}">[수정]</a><br>
	</c:if>
	<a href="${ctx}/list">[목록으로 돌아가기]</a>
	
	<div id="cmt-area">
	
	</div>
	<div id="cmt-write-area">
<!-- 		댓글작성자 : <input type="text" id="cmt-writer" placeholder="김개똥"><br> -->
		댓글내용 : <input type="text" id="cmt-content" placeholder="댓글내용을 쓰세용"><br>
		<button id="cmt-btn">댓글 작성</button>
	</div>
</body>
</html>


