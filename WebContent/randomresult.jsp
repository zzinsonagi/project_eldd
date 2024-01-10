<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../header.jsp"%> 


	<c:set var="vo" value="${vo}"></c:set>

	<div class = "img_rdresult">
		<img src="../images/foodimages/${vo.eldd_foodCode}.jpg" alt="">
	</div>
	
	<div class = "main-rd-result">
		<span id="main-result-today">今日は</span> 
		<span id="main-result-food">『 ${vo.eldd_foodName} 』</span> 
		<span id="main-result-question">いかがですか？</span>
	</div>
	
	<div class="re_btn">
		<div class="container-mainrd">
			<div class="con-random1">
				<a href="randomresult.do" class="re-random-btn">やり直す</a>
			</div> 
		</div>
	</div>



<%@ include file="../footer.jsp"%> 

