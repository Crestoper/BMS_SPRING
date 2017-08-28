<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<%@ include file = "guest_header.jsp" %>
<body>

<script type = "text/javascript">
switch(${sessionScope.msg}){
case 350 : alert("PW를 잘못입력하셨습니다."); request.getSession().setAttribute("msg", "0"); break;
} 
</script>

<h3 align = "center">비밀번호 입력</h3>
<form name = "inputform" action = "infoExit.do" method = "post">
<p align = "center">
<input type = "hidden" value = "1" name = "cnt">
<input type = "password" name = "pw" id = "pw"">&ensp;
<c:if test = "${cnt == 0}"><input type = "button" value = "확인" onclick = "infoExit()"></c:if>
<c:if test = "${cnt == 3}"><input type = "button" value = "확인" onclick = "infoModify()"></c:if>
</p>
</form>



</body>
<%@ include file = "guest_footer.jsp" %>
</html>