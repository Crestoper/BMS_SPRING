<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<%@ include file = "../guest/guest_header.jsp"%>
<h2 align = "center">비밀번호 입력</h2>

<form name = "inputform" action = "boardDelete" method = "post">
<input type = "hidden" value = "${num}" name = "num" id = "num">
<input type = "hidden" value = "1" name = "cnt">
<input type = "hidden" value = "${pageNum}" id = "pageNum">
<input type = "hidden" value = "${writer}" id = "writer">
<p align = "center">
<input type = "password" name = "pw" id = "pw" placeholder = "비밀번호를 입력하시오.">
<c:if test = "${cnt == 4}">
<input type = "button" value = "확인" onclick = "boardDelete()" >
</c:if>
<c:if test = "${cnt == 3}">
<input type = "button" value = "확인" onclick = "boardModify()" >
</c:if>
</p>
</form>

<%@ include file = "../guest/guest_footer.jsp"%>
</body>
</html>