<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "setting_home.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type = "text/javascript">
switch(${sessionScope.msg}){
case 100 : alert("구매 완료."); <c:set var = "msg" value = "0" scope = "session" /> break;
case 200 : alert("카트가 비었습니다."); <c:set var = "msg" value = "0" scope = "session" /> break;
case 300 : alert("로그인 완료."); <c:set var = "msg" value = "0" scope = "session" /> break;
case 400 : alert("담기 완료."); <c:set var = "msg" value = "0" scope = "session" /> break;
case 500 : alert("가입 완료. \n반갑습니다."); <c:set var = "msg" value = "0" scope = "session" /> break;
case 600 : alert("변경 완료."); <c:set var = "msg" value = "0" scope = "session" /> break;
case 700 : alert("로그 아웃 완료. \n안녕히가세요."); <c:set var = "msg" value = "0" scope = "session" /> break;
case 800 : alert("탈퇴 완료. \n감사했습니다."); <c:set var = "msg" value = "0" scope = "session" /> break;
} 
</script>


</head>
<body onload = "gohome()">
	<table>
		<tr>
		<td id = "homefirstcattd">
			<div>
				<ul id = "nav">
					<!-- 로그인 안된 경우 로그인 페이지 / 로그인 된 경우 id님 -->
					<c:if test = "${sessionScope.memId != null}">
							<li>${memId}님</li>
					</c:if>
					<c:if test = "${sessionScope.memId == null}">
						<li><a class = "aTag" href = "login">LogIn</a></li>
					</c:if>
					
					<!-- 로그인 안된 경우 회원가입 페이지 / 로그인 된 경우 로그아웃 -->
					<c:if test = "${sessionScope.memId == null}">
						<li><a class = "aTag" href = "joinUs">JoinUs</a></li>
					</c:if>
					<c:if test = "${sessionScope.memId != null}">
							<li><a class = "aTag" href = "logout">Logout</a></li>
					<li><a class = "aTag" href = "cart">Cart</a></li>
					<li><a class = "aTag" href = "mypage">MyPage</a></li>
					</c:if>
				</ul>
				<label for ="toggle"><img id = "menuclick" src = "bms/resources/Images/ClickHere/click2.png"></label>
			</div>
			<div id = "top">
			<img id = "logo" src = "bms/resources/Images/catlogo/CATLOGO_WHITE.png"><br>
			<span>Welcome To</span><br>
			The Ong's Book Store
				<form action = "searchBook?cnt=1" method = "post">
					<input id = "search" type = "text" name = "search" placeholder = " 찾으시는 책의 제목을 입력하세요." >
					<input id = "searchButton" type = "submit" value = "검색">
				</form>
			</div>
		</td>
		</tr>
		<tr>
			<td class = "ongsselect" colspan = "3">
				<p>- Ong's Select -</p>
					It's For You.
			</td>
		<tr>
			<td class = "ongsselect">
			<c:forEach var = "dto" items = "${dtolist}" end = "4">
				<a href = "bookpage?num=${dto.isbn}"><img src ="bms/resources/Images/imagebyin/${dto.isbn}.jpg"></a>
			</c:forEach>
			</td>
		</tr>
		<tr>
			<td class = "ongsselect" colspan = "3">
				<p>- Guest's Select -</p>
					Best Seller
			</td>
		<tr>
			<td class = "ongsselect">
			<c:forEach var = "dto" items = "${dtolist}" begin = "5">
				<a href = "bookpage?num=${dto.isbn}"><img src ="bms/resources/Images/imagebyin/${dto.isbn}.jpg"></a>
			</c:forEach>
			</td>
		</tr>
		<tr>
		<td>
		<br><br><br><br><br>
		</td>
		</tr>	
	</table>
<footer>
	<img src = "bms/resources/Images/catlogo/CATLOGO_BLACK.png"><br>
	Always With You
</footer>
</body>
</html>