<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%@ include file="../header.jsp" %>

	<div class="container">
		<div class="memberterms">
		<h2>약관</h2>
			<form name="my" method="post" action="join.do">
				<input type="hidden" name="check" value="${ran }">
				<input type="checkbox" class="agreeall" name="chkctrl" id="chkctrl" value="t">
				모든 약관에 동의합니다
				<textarea>
					제1조 정보등록
					1. ---------------------------------
				</textarea>
				<input type="checkbox" name="agree" id="agree1" value="t" onclick="check();">
				이용 약관 동의
				<textarea>
					제2조 회원등록
					1. ---------------------------------
					2. ---------------------------------
					3. ---------------------------------
				</textarea>
				<input type="checkbox" name="agree" id="agree2" value="t" onclick="check();">
				개인 정보 수집 및 동의
				<textarea>
					제3조 어쩌구
					1. ---------------------------------
					2. ---------------------------------
					3. ---------------------------------
				</textarea>
				<input type="checkbox" name="agree" id="agree3" value="t" onclick="check();">
				위치정보 이용 동의
					<div class="btnbox">
						<input type="button" class="btn submit btn_ok" id="btn_ok" value="등록">
						<input type="button" class="btn reset" value="취소" onclick="javascript:history.go(-1)">
					</div>
			</form>
		</div>
	</div>
	<!-- end contents -->
	
	<script>
		
	
		$(function(){
			var chklist = $("input[name=agree]");
			//input 태그 네임이 agree인 모든 태그를 chklist 변수에 담는다
			$("#chkctrl").click(function(){
				//id이름이 chkctrl을 클릭했을 때
				if($(this).is(":checked")){
					//현재 자신이 체크상태일 시
					chklist.prop("checked", true);
					//chklist에 담겨진 모든 태그를 체크 상태로 변경
				}else{
					chklist.prop("checked", false);
					//attr() 함수는 html에 작성된 속성값을 문자열로 받아오고
					//prop() 함수는 자바스크립트의 프로퍼티를 가져온다
				}
			})
			
			$("#agree1, #agree2, #agree3").on("click", function(){
				if($("#agree1").is(":checked") == true 
					&& $("#agree2").is(":checked") == true 
					&& $("#agree3").is(":checked") == true ) {
						$("#chkctrl").prop("checked", true);
				} else {
						$("#chkctrl").prop("checked", false);
				}
			})
			
			$("#btn_ok").on("click", function(){
				var chk = true;
				for(var i=0; i < chklist.length; i++){
					if(!chklist[i].checked){
						chk = false;
					}
				}
				if(!chk){
					alert("모든 약관에 동의해주세요");
					return false;
				}else{
					my.submit();
				}
			})
			
			
		})
		
		
	</script>
	
    <%@ include file="../footer.jsp" %>