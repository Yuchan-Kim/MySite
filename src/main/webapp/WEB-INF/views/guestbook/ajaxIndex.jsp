<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="http://localhost:8888/mysite/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="http://localhost:8888/mysite/assets/css/guestbook.css" rel="stylesheet" type="text/css">


</head>

<body>
	<div id="wrap">

		<c:import url = "/WEB-INF/views/include/header.jsp"></c:import>
	
		<div id="container" class="clearfix">
			<div id="aside">
				<h2>방명록</h2>
				<ul>
					<li>일반방명록</li>
					<li>방명록</li>
				</ul>
			</div>
			<!-- //aside -->

			<div id="content">
				
				<div id="content-head" class="clearfix">
					<h3>일반방명록</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>방명록</li>
							<li class="last">일반방명록</li>
						</ul>
					</div>
				</div>
				<!-- //content-head -->

				<div id="guestbook">
					<form action = "/mysite/guestbook/register" method = "post">
						<table id="guestAdd">
							<colgroup>
								<col style="width: 70px;">
								<col>
								<col style="width: 70px;">
								<col>
							</colgroup>
							<tbody>
								<tr>
									<th><label class="form-text" for="input-uname">이름</label></td>
									<td><input id="input-uname" type="text" name="name"></td>
									<th><label class="form-text" for="input-pass">패스워드</label></td>
									<td><input id="input-pass"type="password" name="pw"></td>
								</tr>
								<tr>
									<td colspan="4"><textarea name="comments" cols="72" rows="5"></textarea></td>
								</tr>
								<tr class="button-area">
									<td colspan="4" class="text-center"><button type="submit">등록</button></td>
								</tr>
							</tbody>
							
						</table>
						<!-- //guestWrite -->
						
						
					</form>	
					
					<!-- 리스트자리 -->
					<div id="guestbookListArea">
						<!-- afterbegin(시작후)  -->
					</div>
					<!-- 리스트자리 -->
					
					
				</div>
				<!-- //guestbook -->
			
			</div>
			<!-- //content  -->
		</div>
		<!-- //container  -->

		<c:import url = "/WEB-INF/views/include/footer.jsp"></c:import>
	</div>
	<!-- //wrap -->
	<!-- Axios 라이브러리 포함 -->
	<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
	
	<script>
		document.addEventListener('DOMContentLoaded',function(){
			console.log("DOM TREE");
			
			 axios({
				 	method: 'get',           // put, post, delete                   
        		 	url: '/mysite/api/guestbook/list',
        		 	headers: {"Content-Type" : "application/json; charset=utf-8"}, //전송타입
       			 	//params: guestbookVo,  //get방식 파라미터로 값이 전달
         		 	//data: guestbookVo,   //put, post, delete 방식 자동으로 JSON으로 변환 전달
    
        		 	responseType: 'json' //수신타입
    			 }).then(function (response) {
        			console.log(response.data); //수신데이타
        			//태그 가져오기
        			
        			
        			
        			for(let i=0; i<response.data.length; i++){
        				//console.log(response.data[i].name);
        				let guestVo = response.data[i];
        				render(guestVo);
        			}
        			
        			
        			
    
    			 }).catch(function (error) {
        		    console.log(error);
    
    		  });
			
		});
		
		function render(guestVo){
			let listArea = document.querySelector('#guestbookListArea');
			let str = "";
				str += '	<table class="guestRead">	';
				str += '		<colgroup>	'
				str += '			<col style="width: 10%;">	';
				str += '			<col style="width: 40%;">';
				str += '			<col style="width: 40%;">';
				str += '			<col style="width: 10%;">';
				str += '		</colgroup>';
				str += '		<tr>';
				str += '			<td>'+guestVo.personId+'</td>';
				str += '			<td>'+guestVo.name+'</td>';
				str += '			<td>'+guestVo.time+'</td>';
				str += '			<td><a href="">[삭제]</a></td>';
				str += '		</tr>';
				str += '		<tr>';
				str += '			<td colspan=4 class="text-left">'+guestVo.comments+'</td>';
				str += '	</tr>';
				str += '	</table>';
				
				
				listArea.insertAdjacentHTML('afterbegin', str);
				
		
				
				
				
				
		}
	</script>

</body>

</html>