$(function(){
			/* 배경화면 고양이 사진 8장 랜덤 지정  위한 그림 지정*/
			var images = ['1.jpg', '2.jpg', '3.jpg', '4.jpg', '5.jpg', '6.jpg', '7.jpg', '8.jpg'];
			/* 배경화면 고양이 사진 8장 랜덤 지정 위한 랜덤번호  */
			var randomnumber=Math.floor(Math.random()*8);
			/* 배경화면 고양이 사진 8장 랜덤 지정  */
			$('#homefirstcattd').css('background', 'url(bms/resources/Images/BackGroundcat/' + images[randomnumber] + ')');
			/* 배경화면 반복 안함 */
			$('#homefirstcattd').css('background-repeat', 'no-repeat');
			
			$('body').css('margin', '0');
			$('body').css('padding', '0');
			/* 전체 화면 크기 지정 */
			$('table').css('width', '100%');
			
			
			/* 메인 화면 크기 설정 */
			$("#homefirstcattd").css('height', '10%');
			$("#homefirstcattd").css('padding-top', '2%');
			$("#homefirstcattd").css('padding-bottom', '1%');
			
			/* 메인 화면 텍스트 설정 */
			/* 폰트 설정 */
			$('#homefirstcattd').css('font-family', 'Noto Serif');
			$("#homefirstcattd").css('text-align', 'center');
			$('#homefirstcattd').css('font-size', '500%');
			$("#homefirstcattd").css('valign', 'top');
			$("#homefirstcattd").css('color', 'white');
			$("#homefirstcattd").css('text-shadow', '2px 2px 8px rgba(0,0,0,0.7)');
			/* Welcome to 만 따로 설정 */
			$('#homefirstcattd span').css('font-style', 'italic');
			$('#homefirstcattd span').css('margin-top', '0%');
			$('#homefirstcattd span').css('font-size', '100%');
			
			/* 메인페이지 상단 로고 설정 */
			$("#logo").css('width', '6%');
			$("#logo").css('margin-bottom', '-1%');
			$("#logo").css('margin-left', '0%');
			
			/* 메뉴 손가락 설정 */
			$("#menuclick").css('width', '5%');
			/* $(".topMenu > img").css('float', 'left'); */
			$("#menuclick").css('position', 'absolute');
			$("#menuclick").css('left', '3%');
			$("#menuclick").css('top', '3%');
			/* 메뉴 위치 설정 */
			$("#nav").css('position', 'absolute');
			$("#nav").css('left', '1%');
			$("#nav").css('top', '1%');
			$("#nav >li").css('padding-right', '1%');
			$("#nav >li").css('display', 'inline');
			/* 메뉴 속성 설정 */
			$("#nav").css('list-style', 'none');
			$("#nav").css('font-size', '40%');
			$("#nav").css('width', '50%');
			$("#nav").css('align', 'left');
			
			
			/* a태그 글자 밑줄 색깔 변경 */
			$('.aTag').css('text-decoration', 'none');
			$('.aTag').css('color', 'white');
			
			/* 손가락 클릭 시 메뉴 보였다 사라졌다*/
			$("#nav").css('display', 'none');
			$("#menuclick").click(function(){
				$("#nav").toggle();
			});
			
			$('#sec').css('margin', '0');
			$('#sec').css('padding', '0');
			$('#sec').css('display', 'inline');
			
			/* footer 설정 */
			$("footer").css('text-align', 'center');
			/* footer 배경화면 */
			$('footer').css('background', 'url(bms/resources/Images/BackGroundcat/' + images[randomnumber] + ')');
			
			/* footer 반복 안함 */
			$('footer').css('background-repeat', 'no-repeat');
			$("footer > img").css('width', '5%');
			$('footer').css('font-family', 'Noto Serif');
			$("footer").css('text-align', 'center');
			$('footer').css('font-size', '300%');
			$("footer").css('valign', 'middle');
			$("footer").css('color', 'white');
			$("footer").css('text-shadow', '2px 2px 8px rgba(0,0,0,0.7)');
			$("footer").css('padding', '2%');

			/*hostStock---------------------------------------------------------------------------------------------*/
			$('.table').css('width', '80%');
			$('.table').css('padding', '1%');
			$('.table').css('margin', 'auto');
			$('.table').css('border', '1px dotted black');
			$('.table').css('border-radius', '2px');
			$('.table>tr').css('border', '1%');
			$('.table>tr').css('margin', '1%');
			$('.table>tr>td').css('border', '1%');
			$('.table>tr>td').css('margin', '1%');
			
			$('.bImg').css('size', '60%');
			$("#pageSize").change(function(){
				var pageSize = $("#pageSize option:selected").val();
				window.location.href = "hostStock?pageSize="+pageSize;
			});
			
			$('#hostStockAdd').click(function(){
				var result = confirm("등록하시겠습니까?");
				
				if(result){
					var form = $(this).parents("form");
					console.log($(this));
					console.log(form);
					var togo = $('#sec');
					
					  $.ajax({ 					
					       data: 	form.serialize(),		
					       type: 	'post',	 			
					       url: 	"hostStockAdd",	 	
					       success: function(response) { 		
					          alert("등록 완료");
					          window.location.reload(true);
					    	  /*togo.html(response);	*/	
					       }
					  });
				}
			});
			
			$('.hostStockModify').click(function(){
				var result = confirm("수정하시겠습니까?");
				
				if(result){
					var form = $(this).parents("form");
					console.log($(this));
					console.log(form);
					var togo = $('#sec');
					
					  $.ajax({ 					
					       data: 	form.serialize(),		
					       type: 	'post',	 			
					       url: 	"hostStockModify",	 	
					       success: function(response) { 		
					          alert("수정 완료");
					          window.location.reload(true);
					    	  /*togo.html(response); 	*/		
					       }
					  });
				}
			});
			
			$('.hostStockDelete').click(function(){
				var result = confirm("삭제하시겠습니까?");
				
				if(result){
					var form = $(this).parents("form");
					console.log($(this));
					console.log(form);
					var togo = $('#sec');
					
					  $.ajax({ 					
					       data: 	form.serialize(),		
					       type: 	'post',	 			
					       url: 	"hostStockDelete",	 	
					       success: function(response) { 		
					          alert("삭제 완료");
					          window.location.reload(true);
					    	 /* togo.html(response); 		*/	
					       }
					  });
				}
			});
			
			/*order-------------------------------------------------------------------------------------------------------*/
			
			$('#allView').unbind("click").bind("click",function(){
			
			var togo = $('#result');
			//var form = $(this).parents("form");
			var orderSize = document.getElementById("orderSize").value  == 0 ? 5 : document.getElementById("orderSize").value;
			var data = {"orderSize" : orderSize};
			document.getElementById("title").value = 0;
			document.getElementById("state").value = 99;
			document.getElementById("isbn").value = 0;	
			document.getElementById("guestId").value = 0;
				  
					$.ajax({ 					
				       data: 	data,
					  //data: 	form.serialize(),
				       type: 	'post',	 			
				       url: 	"hostOrderView",	 	
				       success: function(response) { 	
				    	  togo.html(response);			
				       }
				  });
		});
		
			
		
		$('#state').unbind("change").bind("change",function(){

			var togo = $('#result');
			var orderSize = document.getElementById("orderSize").value  == 0 ? 5 : document.getElementById("orderSize").value;
			var state = document.getElementById("state").value == 99 ? 99 : document.getElementById("state").value;
			document.getElementById("isbn").value = 0;
			document.getElementById("title").value = 0;
			document.getElementById("guestId").value = 0;
			var searchCnt = 0;
			var name = null;
			var value = null;
			
			if(state == 99){
				searchCnt = 0;
			}else if(state != 99){
				searchCnt = 99;
				name = "state"
				value	= state
			}
			var data = { "orderSize" : orderSize, 
					 "value" : value,
					 "name" : name,
					 "searchCnt" : searchCnt,
					};	
		
			  $.ajax({ 					
			       data: 	data,		
			       type: 	'post',	 			
			       url: 	"hostOrderView",	 	
			       success: function(response) { 
			    	  
			    	  togo.html(response);	
			    	  return false;	
			       }
			  });
	});
		
		$('#title').unbind("change").bind("change",function(){
			
			var togo = $('#result');
			var orderSize = document.getElementById("orderSize").value  == 0 ? 5 : document.getElementById("orderSize").value;
			var selectTitle = document.getElementById("title").value == 0 ? 0 : document.getElementById("title").value;
			document.getElementById("isbn").value = 0;
			document.getElementById("state").value = 99;
			document.getElementById("guestId").value = 0;
			var searchCnt = 0;
			var name = null;
			var value = null;
			
			if(selectTitle == 0){
				searchCnt = 0;
			}else if(selectTitle != 0){
				searchCnt = 99;
				name = "title"
				value	= selectTitle
			}
			
			var data = { "orderSize" : orderSize, 
					 "value" : value,
					 "name" : name,
					 "searchCnt" : searchCnt,
					};	
		
			  $.ajax({ 					
			       data: 	data,		
			       type: 	'post',	 			
			       url: 	"hostOrderView",	 	
			       success: function(response) { 
			    	   
			    	  togo.html(response);			
			       }
			  });
	});
		
		$('#isbn').unbind("change").bind("change",function(){
			
			var togo = $('#result');
			var orderSize = document.getElementById("orderSize").value  == 0 ? 5 : document.getElementById("orderSize").value;
			var selectIsbn = document.getElementById("isbn").value == 0 ? 0 : document.getElementById("isbn").value;
			document.getElementById("title").value = 0;
			document.getElementById("state").value = 99;
			document.getElementById("guestId").value = 0;
			var searchCnt = 0;
			var name = null;
			var value = null;
			
			if(selectIsbn == 0 ){
				searchCnt = 0;
			}else if(selectIsbn != 0){
				searchCnt = 99;
				name = "isbn"
				value = selectIsbn
			}
			
			var data = { "orderSize" : orderSize, 
					 "value" : value,
					 "name" : name,
					 "searchCnt" : searchCnt,
					};	
		
			  $.ajax({ 					
			       data: 	data,		
			       type: 	'post',	 			
			       url: 	"hostOrderView",	 	
			       success: function(response) { 	
			    	   
			    	  togo.html(response);			
			       }
			  });
	});
		
		$('#guestId').unbind("change").bind("change",function(){
			
			var togo = $('#result');
			var orderSize = document.getElementById("orderSize").value  == 0 ? 5 : document.getElementById("orderSize").value;
			var guestId = document.getElementById("guestId").value == 0 ? 0  : document.getElementById("guestId").value;
			document.getElementById("title").value = 0;
			document.getElementById("state").value = 99;
			document.getElementById("isbn").value = 0;
			var searchCnt = 0;
			var name = null;
			var value = null;
			
			if(guestId == null ){
				searchCnt = 0;
			}else if(guestId != 0){
				searchCnt = 99;
				name = "guestId"
				value = guestId
			}
			
			var data = { "orderSize" : orderSize, 
					 "value" : value,
					 "name" : name,
					 "searchCnt" : searchCnt,
					};	
		
			  $.ajax({ 					
			       data: 	data,		
			       type: 	'post',	 			
			       url: 	"hostOrderView",	 	
			       success: function(response) { 	
			    	   
			    	  togo.html(response);			
			       }
			  });
	});
		
		$('#orderSize').unbind("change").bind("change",function(){
			
			var togo = $('#result');
			var orderSize = document.getElementById("orderSize").value  == 0 ? 5 : document.getElementById("orderSize").value;
			var selectTitle = document.getElementById("title").value == 0 ? 0 : document.getElementById("title").value;
			var selectIsbn = document.getElementById("isbn").value == 0 ? 0 : document.getElementById("isbn").value;
			var state = document.getElementById("state").value == 99 ? 99 : document.getElementById("state").value;
			var guestId = document.getElementById("guestId").value == 0 ? 0 : document.getElementById("guestId").value;
			var searchCnt = 0;
			var name = null;
			var value = null;
			
			if(selectTitle == 0 && selectIsbn == 0 && state == 99 && guestId == 0){
				searchCnt = 0;
			}else if(selectTitle != 0){
				searchCnt = 99;
				name = "title"
				value	= selectTitle
			}else if(selectIsbn != 0){
				searchCnt = 99;
				name = "isbn"
				value	= selectIsbn
			}else if(state != 0){
				searchCnt = 99;
				name = "state"
				value	= state
			}else if(guestId != 0){
				searchCnt = 99;
				name = "guestId"
				value	= guestId
			}
			
			var data = { "orderSize" : orderSize, 
					 "value" : value,
					 "name" : name,
					 "searchCnt" : searchCnt,
					};	
		
			  $.ajax({ 					
			       data: 	data,		
			       type: 	'post',	 			
			       url: 	"hostOrderView",	 	
			       success: function(response) { 	
			    	   
			    	  togo.html(response);			
			       }
			  });
	});
			
			$('.pageMove').unbind("click").bind("click",function(){
				var pageNum = this.value;
				if(pageNum == "[◁◁]"){
					pageNum = 1;
				}else if(pageNum == "[◁]"){
					pageNum = document.getElementById("[◁]").value;
				}else if(pageNum == "[▷]"){
					pageNum = document.getElementById("[▷]").value;
				}else if(pageNum == "[▷▷]"){
					pageNum = document.getElementById("[▷▷]").value;
				}
				var togo = $('#result');
				var orderSize = document.getElementById("orderSize").value  == 0 ? 5 : document.getElementById("orderSize").value;
				var selectTitle = document.getElementById("title").value == 0 ? 0 : document.getElementById("title").value;
				var selectIsbn = document.getElementById("isbn").value == 0 ? 0 : document.getElementById("isbn").value;
				var state = document.getElementById("state").value == 99 ? 99 : document.getElementById("state").value;
				var guestId = document.getElementById("guestId").value == 0 ? 0 : document.getElementById("guestId").value;
				var searchCnt = 0;
				var name = null;
				var value = null;
				
				if(selectTitle == 0 && selectIsbn == 0 && state == 99 && guestId == 0){
					searchCnt = 0;
				}else if(selectTitle != 0){
					searchCnt = 99;
					name = "title"
					value	= selectTitle
				}else if(selectIsbn != 0){
					searchCnt = 99;
					name = "isbn"
					value	= selectIsbn
				}else if(state != 99){
					searchCnt = 99;
					name = "state"
					value	= state
				}else if(guestId != 0){
					searchCnt = 99;
					name = "guestId"
					value	= guestId
				}
			var data = { "orderSize" : orderSize, 
						 "value" : value,
						 "name" : name,
						 "searchCnt" : searchCnt,
						 "pageNum" : pageNum
						};	
			
				  $.ajax({ 					
				       data: 	data,		
				       type: 	'post',	 			
				       url: 	"hostOrderView",	 	
				       success: function(response) { 
				    	   togo.html(response);			
				       }
				  });
		});
			
		
		/*결산-------------------------------------------------------------------------------------------------------*/
		$('#dateClick').unbind("click").bind("click",function(){
			var startDate = document.getElementById("startDate").value;
			
			var selectedEndDate = document.getElementById("endDate").value;
			var year = selectedEndDate.substr(0,4);
			var month = selectedEndDate.substr(5,2);
			var day = selectedEndDate.substr(8,2);
			var date = new Date(year, month, (day));
			var endDate = date.getFullYear() + "-" + (date.getMonth()) + "-" + (date.getDate()+1);
			
			var guestId = document.getElementById("selectGuestId").value == 0 ? 0 : document.getElementById("selectGuestId").value;
			var selectTitle = document.getElementById("selectTitle").value == 0 ? 0 : document.getElementById("selectTitle").value;
			var daySelect = 50;
			document.getElementById("daySelect").value = 50;
			var searchCnt = 0;
			var name = null;
			var value = null;
			
			if(startDate == "" || endDate == ""){
				alert("날짜를 입력하시오.");
				return false;
			
			}else if(startDate > endDate){
				alert("끝 날짜는 시작 날짜보다 클 수 없습니다.");
				return false;
			}
				
			if(selectTitle == 0 && guestId == 0){
				searchCnt = 0;
			}else if(selectTitle != 0){
				searchCnt = 99;
				name = "title"
				value	= selectTitle
			}else if(guestId != 0){
				searchCnt = 99;
				name = "guestId"
				value	= guestId
			}
			
			var data = { 
						 "value" : value,
						 "name" : name,
						 "searchCnt" : searchCnt,
						 "daySelect" : daySelect,
						 "startDate" : startDate,
						 "endDate" : endDate,
						};
			
			data["go"] = "settlement";
			$.ajax({ 					
				   data : data,
				   type: 	'post',	 			
			       url: 	"settlementPro",	 	
			       success: function(a) { 	
			    	   $('#settlement').html(a);			
			       }
			  });
					
			data["go"] = "settlementStock";
			$.ajax({ 					
					   data : data,		
				       type: 	'post',	 			
				       url: 	"settlementPro",	 	
				       success: function(response) {
				    	   $('#settlementStock').html(response);			
				       }
				});
			
			/*data["go"] = "container";
			$.ajax({ 					
				   data : data,
			       type: 	'post',	 			
			       url: 	"settlementPro",	 	
			       success: function(response) {
			    	   $('#container').html(response);			
			       }
			});*/
			
		});
		
		$('#clickMonth').unbind("change").bind("change",function(){
			document.getElementById("startDate").value = "";
			document.getElementById("endDate").value = "";
			document.getElementById("selectTitle").value = 0;
			document.getElementById("selectGuestId").value = 0;
			
			var clickMonth = document.getElementById("clickMonth").value;
			var guestId = document.getElementById("selectGuestId").value == 0 ? 0 : document.getElementById("selectGuestId").value;
			var selectTitle = document.getElementById("selectTitle").value == 0 ? 0 : document.getElementById("selectTitle").value;
			var daySelect = 60;
			document.getElementById("daySelect").value = 60;
			var searchCnt = 0;
			var name = null;
			var value = null;
			
			if(selectTitle == 0 && guestId == 0){
				searchCnt = 0;
			}else if(selectTitle != 0){
				searchCnt = 99;
				name = "title"
				value	= selectTitle
			}else if(guestId != 0){
				searchCnt = 99;
				name = "guestId"
				value	= guestId
			}
			
			var data = { 
						 "value" : value,
						 "name" : name,
						 "searchCnt" : searchCnt,
						 "daySelect" : daySelect,
						 "clickMonth" : clickMonth
						};
			
			data["go"] = "settlement";
			$.ajax({ 					
				   data : data,
				   type: 	'post',	 			
			       url: 	"settlementPro",	 	
			       success: function(a) { 	
			    	   $('#settlement').html(a);			
			       }
			  });
					
			data["go"] = "settlementStock";
			$.ajax({ 					
					   data : data,		
				       type: 	'post',	 			
				       url: 	"settlementPro",	 	
				       success: function(response) {
				    	   $('#settlementStock').html(response);			
				       }
				});
			
			/*data["go"] = "container";
			$.ajax({ 					
				   data : data,
			       type: 	'post',	 			
			       url: 	"settlementPro",	 	
			       success: function(response) {
			    	   $('#container').html(response);			
			       }
			});*/
			
		});
			
		$('#viewAll').unbind("click").bind("click",function(){
		document.getElementById("startDate").value = "";
		document.getElementById("endDate").value = "";
		document.getElementById("selectTitle").value = 0;
		document.getElementById("selectGuestId").value = 0;
		document.getElementById("clickMonth").value = 0;
		document.getElementById("daySelect").value = 0;
		
		$("#settlement").empty();
		$("#settlementStock").empty();
		
		var daySelect = 0;
		var searchCnt = 0;
		var name = null;
		var value = null;
		
			$.ajax({ 					
				   data : data = {"searchCnt" : searchCnt, "go" : "settlement", "daySelect" : 0},
			       
				   type: 	'post',	 			
			       url: 	"settlementPro",	 	
			       success: function(a) { 	
			    	   $('#settlement').html(a);			
			       }
			  });
				
			$.ajax({ 					
					   data : data = {"searchCnt" : searchCnt, "go" : "settlementStock"},		
				       type: 	'post',	 			
				       url: 	"settlementPro",	 	
				       success: function(response) {
				    	   $('#settlementStock').html(response);			
				       }
				});
				
				/*$.ajax({ 					
					   data : data = {"searchCnt" : searchCnt, "go" : "container"},		
				       type: 	'post',	 			
				       url: 	"settlementPro",	 	
				       success: function(response) {
				    	   $('#container').html(response);			
				       }
				});*/
		});
			
		$('#selectTitle').unbind("change").bind("change",function(){
			document.getElementById("startDate").value = "";
			document.getElementById("endDate").value = "";
			document.getElementById("selectGuestId").value = 0;
			document.getElementById("clickMonth").value = 0;
			var selectTitle = document.getElementById("selectTitle").value == 0 ? 0 : document.getElementById("selectTitle").value;
			var daySelect = document.getElementById("daySelect").value == 0 ? 0 : document.getElementById("daySelect").value;
			var searchCnt = 0;
			var name = null;
			var value = null;
			
			$("#settlement").empty();
			$("#settlementStock").empty();
			
			if(selectTitle != 0){
				searchCnt = 99;
				name = "title"
				value	= selectTitle
			}
			var data = { 
						 "value" : value,
						 "name" : name,
						 "searchCnt" : searchCnt,
						 "daySelect" : daySelect
						};
			
			data["go"] = "settlement";
			$.ajax({ 					
				   data : data,
				   type: 	'post',	 			
			       url: 	"settlementPro",	 	
			       success: function(a) { 	
			    	   $('#settlement').html(a);			
			       }
			  });
					
			data["go"] = "settlementStock";
			$.ajax({ 					
					   data : data,		
				       type: 	'post',	 			
				       url: 	"settlementPro",	 	
				       success: function(response) {
				    	   $('#settlementStock').html(response);			
				       }
				});
			
			/*data["go"] = "container";
			$.ajax({ 					
				   data : data,
			       type: 	'post',	 			
			       url: 	"settlementPro",	 	
			       success: function(response) {
			    	   $('#container').html(response);			
			       }
			});*/
		});
			
			
		$('#selectGuestId').unbind("change").bind("change",function(){
			document.getElementById("startDate").value = "";
			document.getElementById("endDate").value = "";
			document.getElementById("selectTitle").value = 0;
			document.getElementById("clickMonth").value = 0;
			var guestId = document.getElementById("selectGuestId").value == 0 ? 0 : document.getElementById("selectGuestId").value;
			var daySelect = document.getElementById("daySelect").value == 0 ? 0 : document.getElementById("daySelect").value;
			var searchCnt = 0;
			var name = null;
			var value = null;
			
			$("#settlement").empty();
			$("#settlementStock").empty();
			
			if(guestId != 0){
				searchCnt = 99;
				name = "guestId"
				value	= guestId
			}
			
			var data = { 
					 "value" : value,
					 "name" : name,
					 "searchCnt" : searchCnt,
					 "daySelect" : daySelect
						};
			
			data["go"] = "settlement";
			$.ajax({ 					
				   data : data,
			       
				   type: 	'post',	 			
			       url: 	"settlementPro",	 	
			       success: function(a) { 	
			    	   $('#settlement').html(a);			
			       }
			  });
					
			data["go"] = "settlementStock";
			$.ajax({ 					
					   data : data,		
				       type: 	'post',	 			
				       url: 	"settlementPro",	 	
				       success: function(response) {
				    	   $('#settlementStock').html(response);			
				       }
				});
			
			/*data["go"] = "container";
			$.ajax({ 					
				   data : data,
			       type: 	'post',	 			
			       url: 	"settlementPro",	 	
			       success: function(response) {
			    	   $('#container').html(response);			
			       }
			});*/
		});
			
			
		
		//날짜 검색도 들어가게 수정
		$('.pageGo').unbind("click").bind("click",function(){
			var pageNum = this.value;
			if(pageNum == "[◁◁]"){
				pageNum = 1;
			}else if(pageNum == "[◁]"){
				pageNum = document.getElementById("[◁]").value;
			}else if(pageNum == "[▷]"){
				pageNum = document.getElementById("[▷]").value;
			}else if(pageNum == "[▷▷]"){
				pageNum = document.getElementById("[▷▷]").value;
			}

			var guestId = document.getElementById("selectGuestId").value == 0 ? 0 : document.getElementById("selectGuestId").value;
			var selectTitle = document.getElementById("selectTitle").value == 0 ? 0 : document.getElementById("selectTitle").value;
			var daySelect = document.getElementById("daySelect").value == 0 ? 0 : document.getElementById("daySelect").value;
			var searchCnt = 0;
			var name = null;
			var value = null;
			
			if(selectTitle == 0 && guestId == 0){
				searchCnt = 0;
			}else if(selectTitle != 0){
				searchCnt = 99;
				name = "title"
				value	= selectTitle
			}else if(guestId != 0){
				searchCnt = 99;
				name = "guestId"
				value	= guestId
			}
			
			var data = { 
					 "value" : value,
					 "name" : name,
					 "searchCnt" : searchCnt,
					 "pageNum" : pageNum,
					 "daySelect" : daySelect
						};
			
			data["go"] = "settlement";
			$.ajax({ 					
				   data : data,
			       
				   type: 	'post',	 			
			       url: 	"settlementPro",	 	
			       success: function(a) { 	
			    	   $('#settlement').html(a);			
			       }
			  });
					
	});
			
		$('.pageGoStock').unbind("click").bind("click",function(){
			var pageNum = this.value;
			if(pageNum == "[◁◁]"){
				pageNum = 1;
			}else if(pageNum == "[◁]"){
				pageNum = document.getElementById("[◁]").value;
			}else if(pageNum == "[▷]"){
				pageNum = document.getElementById("[▷]").value;
			}else if(pageNum == "[▷▷]"){
				pageNum = document.getElementById("[▷▷]").value;
			}

			var guestId = document.getElementById("selectGuestId").value == 0 ? 0 : document.getElementById("selectGuestId").value;
			var selectTitle = document.getElementById("selectTitle").value == 0 ? 0 : document.getElementById("selectTitle").value;
			var daySelect = document.getElementById("daySelect").value == 0 ? 0 : document.getElementById("daySelect").value;
			var searchCnt = 0;
			var name = null;
			var value = null;
			
			if(selectTitle == 0 && guestId == 0){
				searchCnt = 0;
			}else if(selectTitle != 0){
				searchCnt = 99;
				name = "title"
				value	= selectTitle
			}else if(guestId != 0){
				searchCnt = 99;
				name = "guestId"
				value	= guestId
			}
			
			var data = { 
					 "value" : value,
					 "name" : name,
					 "searchCnt" : searchCnt,
					 "pageNum" : pageNum,
					 "daySelect" : daySelect
						};
			
			data["go"] = "settlementStock";
			$.ajax({ 					
					   data : data,		
				       type: 	'post',	 			
				       url: 	"settlementPro",	 	
				       success: function(response) {
				    	   $('#settlementStock').html(response);			
				       }
				});
			
	});
		
	$('#dateClickReset').click(function(){
		document.getElementById("startDate").value = "";
		document.getElementById("endDate").value = "";
	});
		
		
});
