<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "host_header.jsp" %>
<html>
<body>
<form >
<input type = "hidden" value = "${daySelect}" id = "daySelect">
<input type = "hidden" value = "${startDate}" id = "selectedStartDate">
<input type = "hidden" value = "${endDate}" id = "selectedEndDate">
<br>
<table class = "table">
	<tr>
		<th colspan = "3">
			검색조건
		</th>
	</tr>
	<tr>
		<th>
			<input type = "button" value = "전체보기" id = "viewAll">
			<select name = "title" id = "selectTitle">
				<option value = "0">TITLE 전체보기</option>
				<c:forEach var = "dto" items = "${searchList}" >
				<option value = "${dto.title}">${dto.title}</option>
				</c:forEach>
			</select>

			<select name = "guestId" id = "selectGuestId">
				<option value = "0">guestId 전체보기</option>
				<c:forEach var = "dto" items = "${guestIdList}">
				<option value = "${dto.guestId}">${dto.guestId}</option>
				</c:forEach>
			</select>

			<select name = "clickMonth" id = "clickMonth">
				<option value = "0">월별 보기</option>
			<c:forEach var = "month" begin = "1" end = "12">
				<option value = "${month}">${month}월</option>
			</c:forEach>
			</select>
			<br><br>
		</th>
	</tr>
	<tr>
		<th>
			<input type = "date" id = "startDate" name = "startDate">
			<input type = "date" id = "endDate" name = "endDate">
			<input type = "button" value = "확인" id = "dateClick">
			<input type = "button" value = "리셋" id = "dateClickReset">
			<br><br>
		</th>
	</tr>
	<tr>
		
	</tr>
</table>

</form>
<br><br>
<!-- 판매량 -->
<div id="settlementStock"></div>
<br><br>
<!-- 그래프 -->    
<div id="container"></div>
<br>
<div id = "settlement"></div>
</body>
</html>