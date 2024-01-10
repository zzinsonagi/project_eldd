<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    
    <!-- fonts -->
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
	
	
	<!-- jQuery CDN -->
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	
	<!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" rel="stylesheet" />
	
    <!-- css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"/>
	
    

    <title>オルメチュ</title>
</head>

<body>


	<div class="back-to-main">
		<a href="main.do">
			<img src="${pageContext.request.contextPath}/images/logo_tmp_l.png" alt="로고 이미지">
		</a>
	</div>


	
	<div class="w3-content w3-container w3-margin-top">
      <div class="w3-container w3-card-4" style="width: 600px; margin: 0 auto">
        <div class="w3-center w3-large w3-margin-top" style="text-align:center;">
          <h3>会員登録</h3>
        </div>
        <div>
          <form name="join" method="post" action="" id="join" onsubmit="return fn_save()">
	
              <label>ID</label>
				<div class = "msg">
					<input class="w3-input" type="text" id="id" name="id" placeholder="IDを入力してください"/>
					<p id="idmsg"></p>
				</div>
              <label>PASSWORD</label>
				<div class = "msg">
					<input class="w3-input" type="text" id="pw" name="pw" placeholder="パスワードを入力してください"/>
					<p id="pwmsg"></p>
				</div>
          
              <label>PASSWORD 確認</label>
				<div class = "msg">
					<input class="w3-input" type="text" id="pw2" name="pw2" placeholder="パスワードを確認してください"/>
					<p id="pw2msg"></p>
				</div>
          
			<p class="join-terms">ID:5~20文字の英文小文字、数字と特殊記号(_)、(-)のみ使用できます。</p>
			<p class="join-terms">パスワード:8~16文字の英語大/小文字、数字、特殊文字を使用してください。</p>
			<br />
			<br />
			<br />
			
              <label>お名前</label>
              <input class="w3-input-n" type="text" id="lastname" name="lastname" placeholder="例）二宮"/>
              <input class="w3-input-n" type="text" id="firstname" name="firstname" placeholder="例) 和也"/>
           
              <label>お名前 (読み仮名)</label>
              <input class="w3-input-n" type="text" id="lastyomi" name="lastyomi" placeholder="例）にのみや"/>
              <input class="w3-input-n" type="text" id="firstyomi" name="firstyomi" placeholder="例）かずなり"/>
         
             <label>生年月日</label>
             <input class="w3-input-b" type="text" id="year" name="birth" placeholder="例）1983"/>年
			  <input class="w3-input-d" type="text" id="month" name="birth" placeholder="例）06"/>月
			  <input class="w3-input-d" type="text" id="day" name="birth" placeholder="例)  17"/>日
          
			
			<label>性別</label>
			
			<input type="radio" id="male" name="gender" value="M" checked>
			<label for="male" class="custom-radio">男性</label>
			
			<input type="radio" id="female" name="gender" value="F">
			<label for="female" class="custom-radio">女性</label>
					
			<br />
			<br />
			<br />
			<br />
			
			<label>メールアドレス</label>
			
			<input type="email" class="w3-input-e" id="email" name="email" placeholder="例）michieda@gmail.com"/>
			<input type="button" id="btn-email" class="btn-email" value="送信する">
			<input type="password" class="w3-input-e" name="certinumber"id="certinumber" placeholder="認証番号入力してください">
			<input type="button" id="email-ok" class="email-ok" value="確認する">
			
           
		    <p class="w3-center" style="display: flex; justify-content: space-between;">
             <button type="submit" class="join-btn">ログイン</button>
			  <button type="submit" class="join-btn">会員登録</button>
            </p>
          </form>
          <br />
        </div>
      </div>
    </div>
	
	
	<script>
	
		function fn_save() {
			//아이디 비밀번호 유효성검사
			if(!join.id.value) {
				alert("IDを入力してください");
				join.id.focus();
				return false;
			}if(!join.pw.value) {
				alert("パスワードを入力してください");
				join.pw.focus();
				return false;
			}if(!join.pw2.value) {
				alert("パスワードを確認してください");
				join.pw2.focus();
				return false;
			}
			
			//이름 유효성검사
			if(!join.lastname.value) {
				alert("お名前を入力してください");
				join.lastname.focus();
				return false;
			}if(!join.firstname.value) {
				alert("お名前を入力してください");
				join.firstname.focus();
				return false;
			}if(!join.lastyomi.value) {
				alert("読み仮名を入力してください");
				join.lastyomi.focus();
				return false;
			}if(!join.firstyomi.value) {
				alert("読み仮名を入力してください");
				join.firstyomi.focus();
				return false;
			}
			
			//생년월일 유효성검사
			if(!join.year.value) {
				alert("生まれた生を入力してください");
				join.year.focus();
				return false;
			}if(!join.month.value) {
				alert("生まれた月を入力してください");
				join.month.focus();
				return false;
			}if(!join.day.value) {
				alert("生まれた日を入力してください");
				join.day.focus();
				return false;
			}
			
			//이메일 유효성검사
			if(!join.email.value) {
				alert("メールアドレスを入力してください");
				join.email.focus();
				return false;
			}
			
			//member 폼 안에 모든 값들을 action="" 서버로 전송한다
			else {
				join.submit(); 
			}
			
		}
		
</script>

<script>
	
	var sendcheck = "";
	
	$(function() {
	    $(".location  .dropdown > a").on("click",function(e) {
	       e.preventDefault();
	       if($(this).next().is(":visible")) {
	          $(".location  .dropdown > a").next().hide();
	       } else {
	          $(".location  .dropdown > a").next().hide();
	          $(this).next().show();
	       }
	    });
	    
	    $("#id").blur(function(){
	       if(!$("#id").val()){
	          $("#idmsg").html("<span style='color:#f00; margin-left:6px; font-size:10px;'>IDは必須入力です</span>");
	       } else {
	          $("#idmsg").html("");
	       }
	    })
		
		$("#pw").blur(function(){
	       if(!$("#pw").val()){
	          $("#pwmsg").html("<span style='color:#f00; margin-left:6px; font-size:10px;'>パスワードは必須入力です</span>");
	       } else {
	          $("#pwmsg").html("");
	       }
	    })
	    
	    $("#pw2").blur(function(){
	       var pw1 = $("#pw").val();
	       var pw2 = $("#pw2").val();
	       
	       if((pw1 == "")||(pw2 == "")){
	          if(pw1 == ""){
	                 $("#pw2msg").html("<span style='color:#f00; margin-left:6px; font-size:10px;'>パスワードを確認してください</span>")
	                 $("#pw").focus();
	             } else if(pw2 == ""){
	                $("#pw2msg").html("<span style='color:#f00; margin-left:6px; font-size:10px;'>パスワードを確認してください</span>")
	                 $("#pw2").focus();
	             }
	       } else {
	          if(pw1 != pw2){
	             $("#pw2msg").html("<span style='color:#f00;  margin-left:6px; font-size:10px;'>パスワードが一致しません</span>");
	          } else {
	             $("#pw2msg").html("<span style='color:#00f;  margin-left:6px; font-size:10px;'>パスワードが一致します</span>");
	          }
	       }
	       
	    })
	    
	    
 });
		
		
</script>
	
	



<%@ include file="../footer.jsp"%> 

