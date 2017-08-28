<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "setting_host.jsp" %>
<html>
<body>
	<div id = "sec"></div>
	<table>
			<tr>
				<td id = "homefirstcattd">
					<img id = "logo" src = "bms/resources/Images/catlogo/CATLOGO_WHITE.png" onclick = "window.location = 'host'"><br>
					<span>The Ong's Book Store</span>
					<ul id = "nav">
						<!-- <li>Host</li> -->
						<li><a class = "aTag" href = "hostStock">재고관리</a></li>
						<li><a class = "aTag" href = "hostOrderList">주문관리</a></li>
						<li><a class = "aTag" href = "boardList">게시판관리</a></li>
						<li><a class = "aTag" href = "settlement">결산</a></li>
					</ul>
					<label for ="toggle"><img id = "menuclick" src = "bms/resources/Images/ClickHere/click2.png"></label>
				</td>
			</tr>
	</table>
</body>
</html>