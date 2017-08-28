<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="setting_host.jsp" %>
<h1 align = "center">날짜별 판매액</h1>
   <table class = "table">
    	<tr>
    		<th>
    			날짜
    		</th>
	    	<th>
	    		판매액
	    	</th>
    	</tr>
    	<c:if test = "${sattlementStock != null}">
		<c:if test = "${daySelect == 50}">
		<c:forEach var = "dto" items = "${sattlementStock}" >
		<tr>
			<th>
				${dto.year}년${dto.month}월 
			</th>
	    	<th>
	    		<fmt:formatNumber value="${dto.closing}" type="number"/>원
	    	</th>
    	</tr>
    	</c:forEach>
    	</c:if>
    	 
    	 <c:if test = "${daySelect != 50}">
		<c:forEach var = "dto" items = "${sattlementStock}" >
		<tr>
			<th>
				${dto.year}년${dto.month}월${dto.day}일  
			</th>
	    	<th>
	    		<fmt:formatNumber value="${dto.closing}" type="number"/>원
	    	</th>
    	</tr>
    	</c:forEach>
    	</c:if>
		<tr>
		<th> 합계
		</th>
		<th>
			<fmt:formatNumber value="${closing}" type="number"/>원
		</th>
		</tr>
		</c:if>
		<c:if test = "${sattlementStock == null}">
			<tr>
				<br><br>
				<th colspan = "2"><h2 align = "center">데이터가 없습니다.</h2></th>
			</tr>
		</c:if>
		</table>
		