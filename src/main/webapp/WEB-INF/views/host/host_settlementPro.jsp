<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="setting_host.jsp" %>
 <h1 align = "center">판매내역</h1>
  
   <table class = "table">
    	<tr>
	    	<th>
	    		Isbn
	    	</th>
	    	<th>
	    		제목
	    	</th>
	    	<th>
	    		구매자Id
	    	</th>
	    	<th>
	    		판매일
	    	</th>
	    	<th>
	    		가격
	    	</th>
	    	<th>
	    		수량
	    	</th>
	    	<th>
	    		구매액
	    	</th>
    	</tr>
    	 <c:if test = "${dtolist != null}">
		<c:forEach var = "dto" items = "${dtolist}" >
		<input type = "hidden" value = "${value}" name = "value" id = "value">
		<input type = "hidden" value = "${pageNum}" name = "pageNum" id = "pageNum">
		<input type = "hidden" value = "${startPage - pageBlock}" id = "[◁]">
		<input type = "hidden" value = "${startPage + pageBlock}" id = "[▷]">
		<input type = "hidden" value = "${pageCount}" id = "[▷▷]">
		<tr>
	    	<th>
	    		${dto.isbn}
	    	</th>
	    	<th>
	    		${dto.title}
	    		
	    	</th>
	    	<th>
	    		${dto.guestId}
	    	</th>
	    	<th>
	    		${dto.salesDay}
	    	</th>	
	    	<th>
	    	<fmt:formatNumber value="${dto.price}" type="number"/>원
	    	</th>
	    	<th>
	    	<fmt:formatNumber value="${dto.salesstock}" type="number"/>권
	    	</th>
	    	<th>
	    	<fmt:formatNumber value="${dto.price * dto.salesstock}" type="number"/>원
	    	</th>
    	
    	</c:forEach>
    	</c:if>
    	<c:if test = "${dtolist == null}">
    		<br><br>
			<th colspan = "7"><h2 align = "center">데이터가 없습니다.</h2></th>
		</c:if>
	</tr>
    </table>
    
    <table style = "width : 1000px" align = "center">
		<tr>
			<th align = "center">
				<c:if test = "${cnt > 0}">
					<c:if test = "${startPage > pageBlock}">
						<input type = "button" value = "[◁◁]" class = "pageGo">
						<input type = "button" class = "pageGo" value = "[◁]">
					</c:if>
					
					<c:forEach var = "i" begin = "${startPage}" end = "${endPage}">
						<input type = "button" class = "pageGo" value = "${i}">
					</c:forEach>
				
					<!-- 이거가져옴? -->
					<c:if test = "${pageCount > endPage}">
						<input type = "button" class = "pageGo" value = "[▷]">
						<input type = "button" class = "pageGo" value = "[▷▷]">
					</c:if>
				</c:if>
			</th>
		</tr>
	</table>
	