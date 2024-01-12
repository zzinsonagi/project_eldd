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
         <img src="images/logo_tmp_l.png" alt="로고 이미지">
      </a>
   </div>
  
  
    <div class="w3-content w3-container w3-margin-top">
       <div class="w3-container w3-card-4" style="width: 600px; margin: 0 auto">
           <div class="w3-center w3-large w3-margin-top" style="">
                <h3>ログイン</h3>
           </div>
        
        <div>
           <form id="login" action="loginPro.do" name="login" method="post" onsubmit="return fn_login()">
                  <label>ID</label>
                       <input class="w3-input" type="text" id="id" name="id" />
                       
                    <label>PASSWORD</label>
                       <input class="w3-input" type="text" id="pw" name="pw" />
               
                  <p class="w3-center">
                       <button type="submit" class="w3-button w3-block w3-black w3-ripple w3-margin-top w3-round">ログイン</button>
                  </p>
            </form>
            <br />
        </div>
         </div>
   </div>
   
   
   <script>
      function fn_login() {
         if(login.id.value == ""){
            alert("IDを入力してください")
            login.id.focus();
            return false;
         }
         if(login.pw.value == ""){
            alert("パスワードを入力してください")
            login.pw.focus();
            return false;
         }
         
      }
   </script>

   <script>
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
      });
   </script>

</body>
</html>


<%@ include file="../footer.jsp"%>