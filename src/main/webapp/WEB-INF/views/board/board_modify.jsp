<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<%@ include file = "../guest/guest_header.jsp"%>

<h2><center>글 수정</center></h2>
<form action = "boardModify2" method = "post" name = "modifyform">
	<input type = "hidden" name = "cnt" value = "3">
	<input type = "hidden" name = "num" value = "${num}" id = "num">
	<input type = "hidden" name = "pageNum" value = "${pageNum}" id = "pageNum">
	
	<table align = "center" class = "boardTable">
		<tr>
			<th colspan = "2" align = "center"> 수정할 정보를 입력하시오.</th>
		</tr>
		<c:forEach var = "dto" items = "${dtolist}">
		<tr>
			<th align = "center">작성자</th>
			<td align = "center">${dto.writer}</td>
		</tr>
		<tr>
			<th align = "center">글제목</th>
			<td align = "center"><input class = "input" type = "text" id = "subject" name = "subject" maxlength = "50" value = "${dto.subject}" style = "width : 270"></td>
		</tr>
		<tr>
			<th align = "center">글내용</th>
			<td align = "center"><textArea class = "input" rows = "10" cols = "40" name = "content" id = "content" >${dto.content}</textArea></td>
		</tr>
		<tr>
			<th align = "center">비밀번호</th>
			<td align = "center"><input class = "input" type = "password" id = "pw" name = "passwd" maxlength = "10" value = "${dto.passwd}" style = "width : 270"></td>
		</tr>
		</c:forEach>	
		<tr>
			<td colspan = "2" align = "center">
			<input type = "submit" class = "inputButton" value = "수정" >
			<input type = "reset" class = "inputButton" value = "취소">
			<input type = "button" class = "inputButton" value = "목록보기" onclick = "window.location = 'boardList?pageNum=${pageNum}'">
			
			</td>
		</tr>	
	</table>
</form>
<br>
<br>
<br>
<%@ include file = "../guest/guest_footer.jsp"%>
</body>
</html>