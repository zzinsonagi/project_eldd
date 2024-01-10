<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    
    <!-- fonts -->
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
	
	<!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" rel="stylesheet" />

    <!-- css -->
    <link rel="stylesheet" href="../css/styles.css"/>
	
	<!-- jQuery CDN -->
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    

    <title>オルメチュ</title>
  </head>
  

  <body>
  
    <!-- HEADER -->
	
	<div class = "intro_bg">
		<header id="header">
			<div class="header_wrap">
			<nav class="navbar navbar-default">
			  <div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
					  </button>
					<a class="navbar-brand" href="main.html">
						<img src="../images/logo_tmp_b.png"/>
					</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				  <ul class="nav navbar-nav">
					<li><a class="nav-link1" href="sub1.html">選んでみて!</li>
					<li><a class="nav-link2" href="sub2.html">条件検索</li>
					<li><a class="nav-link3" href="sub3.html">キーワード</li>
					<li><a class="nav-link4" href="sub4.html">ランキング</li>
				  </ul>
				  <ul class="nav navbar-nav navbar-right">
					<li><a class="nav-join" href="join.html">会員加入</a>
					<li><a class="nav-login" href="login.html">ログイン</a>
				  </ul>
				</div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
			</div>
		</header>
	</div>
	
	<!-- HEADER -->
	

    <style>

      .custom-button {
        padding: 10px 20px;
        font-size: 16px;
        cursor: pointer;
        transition: transform 0.2s ease-in-out;
      }

      .custom-button.clicked {
        transform: scale(0.9);
      }
    </style>

    <script>
    document.addEventListener("DOMContentLoaded", function () {
        var button = document.getElementById("myButton");

        button.addEventListener("click", function () {
			button.classList.add("clicked");

			// 200밀리초 후에 clicked 원상복구
			setTimeout(function () {
            button.classList.remove("clicked");
			}, 200);
        });
    });
	
	
    </script>
  </head>

  <body>
    

    <!-- MAIN -->
    <main id="main">
	
		
        
		<div class="section1">
          <section class="other">
            <h2>ご希望の条件を選択して検索できます。</h2>
            <div class="container">
			
				<div class = "col-md-4">
					<h3 class="select-result-c">国別</h3>
				</div>
				<div class = "col-md-4">
					<h3 class="select-result-i">食材別</h3>
				</div>
				<div class = "col-md-4">
					<h3 class="select-result-s">季節別</h3>
				</div>
				
            </div>
          </section>
        </div>
		
		<div class="line"></div>
		
		<div class="select-area">
		<div class="container">
        <div class="row">
        <div class="col-md-9">
        <div class="section2">
           <div class="country">
				<p>国別</p>
					<input type="radio" id="japan" name="country-value">
					<label for="japan" class="custom-radio">和食</label>

					<input type="radio" id="western" name="country-value">
					<label for="western" class="custom-radio">洋食</label>
					
					<input type="radio" id="korea" name="country-value">
					<label for="korea" class="custom-radio">韓食</label>

					<input type="radio" id="china" name="country-value">
					<label for="china" class="custom-radio">中華</label>

					<input type="radio" id="asia" name="country-value">
					<label for="asia" class="custom-radio">アジア食</label>
					
					<input type="radio" id="other-c" name="country-value">
					<label for="other-c" class="custom-radio">その他</label>
					
			</div>
			
			<div class="line"></div>
			
			<div class="ingredient">
				<p>食材別</p>
				
					<input type="radio" id="noodle" name="ingredient-value">
					<label for="noodle" class="custom-radio">麺</label>
					
					<input type="radio" id="rice" name="ingredient-value">
					<label for="rice" class="custom-radio">ご飯</label>
					
					<input type="radio" id="bread" name="ingredient-value">
					<label for="bread" class="custom-radio">パン</label>
					
					<input type="radio" id="meat" name="ingredient-value">
					<label for="meat" class="custom-radio">肉類</label>
					
					<input type="radio" id="fish" name="ingredient-value">
					<label for="fish" class="custom-radio">魚類</label>
					
					<input type="radio" id="seafood" name="ingredient-value">
					<label for="seafood" class="custom-radio">海産物</label>
					
					<input type="radio" id="other-i" name="ingredient-value">
					<label for="other-i" class="custom-radio">その他</label>
					
			</div>
			
			<div class="line"></div>
			
			<div class="season">
				<p>季節別</p>
				
					<input type="radio" id="spring" name="season-value">
					<label for="spring" class="custom-radio">春</label>
					
					<input type="radio" id="summer" name="season-value">
					<label for="summer" class="custom-radio">夏</label>
					
					<input type="radio" id="autumn" name="season-value">
					<label for="autumn" class="custom-radio">秋</label>
					
					<input type="radio" id="winter" name="season-value">
					<label for="winter" class="custom-radio">冬</label>
					
					<input type="radio" id="other-s" name="season-value">
					<label for="other-s" class="custom-radio">その他</label>
				
			</div>
        </div> 
		
		</div> <!--<div class="col-md-9">-->
		
<script>
    $(document).ready(function () {
        // 라디오 버튼 변경 이벤트
        $('input[name="country-value"]').on('change', function () {
            // 선택된 라디오 버튼의 라벨 텍스트를 가져와서 select-result에 반영
            var labelText = $('label[for="' + $(this).attr('id') + '"]').text();
            $('.section1 .select-result-c').text(labelText);
			
			// 선택된 라디오 버튼의 라벨 텍스트 스타일 변경
			$('.section1 .select-result-c').removeClass('selected-label'); // 클래스 제거
			$('.section1 .select-result-c').addClass('selected-label'); // 클래스 추가
       
        });
    });
	
	 $(document).ready(function () {
        // 라디오 버튼 변경 이벤트
        $('input[name="ingredient-value"]').on('change', function () {
            // 선택된 라디오 버튼의 라벨 텍스트를 가져와서 select-result에 반영
            var labelText = $('label[for="' + $(this).attr('id') + '"]').text();
            $('.section1 .select-result-i').text(labelText);
			
			// 선택된 라디오 버튼의 라벨 텍스트 스타일 변경
			$('.section1 .select-result-i').removeClass('selected-label'); // 클래스 제거
			$('.section1 .select-result-i').addClass('selected-label'); // 클래스 추가
       
        });
    });
	
	 $(document).ready(function () {
        // 라디오 버튼 변경 이벤트
        $('input[name="season-value"]').on('change', function () {
            // 선택된 라디오 버튼의 라벨 텍스트를 가져와서 select-result에 반영
            var labelText = $('label[for="' + $(this).attr('id') + '"]').text();
            $('.section1 .select-result-s').text(labelText);
			
			// 선택된 라디오 버튼의 라벨 텍스트 스타일 변경
			$('.section1 .select-result-s').removeClass('selected-label'); // 클래스 제거
			$('.section1 .select-result-s').addClass('selected-label'); // 클래스 추가
       
        });
    });
	
</script>
		
		
		<div class="col-md-3">
		<div class="sub2-btn">
			<a href="sub2choicepro.html">
				<button>検索 > </button>
			</a>
		</div>
		</div><!--<div class="col-md-3">-->
		
		
		</div>
		</div><!--container-->
		</div>
		</main>
		
		
		
	<!-- MAIN -->
        
		
		
	<!-- FOOTER -->
	
    <footer id="footer">
      <div class="footer_wrap">
        <div class="row">
          <div class="col-12">
            <p>개인정보처리방침 | 이용약관 | 청소년보호정책 | 기사제보</p>
          </div>
          <p>
            JSL인재 개발원 대표 : 채민경 (대전센터) 대전광역시 중구 계룡로 825 (용두동, 희영빌딩) 5층 7층 / (서울센터)서울 특별시 송파구 올림픽로 35길 104 ( 장미C상가 403호 )
          </p>
          <p>
            고객센터 : 042-242-4412 팩스 : 042-242-4413 사업자등록번호 : 305-86-06709 통신판매신고번호 :
            제2019-대전중구-0567호 사업자정보확인 인터넷신문등록일 : 2019.02.19
          </p>
          <p>등록번호 : 대전 아0325 발행인 : 박장수 편집인 : 박장수 청소년보호책임자 : 김현우</p>
        </div>
      </div>
    </footer>
	
	<!-- FOOTER -->
	
	
  </body>
</html>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>