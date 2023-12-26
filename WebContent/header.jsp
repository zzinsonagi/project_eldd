<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- bootstrap -->
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" />

    <!-- css -->
    <link rel="stylesheet" href="eldd/css/styles.css" />

    <title>オルメチュ</title>

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	
	<!-- Bootstrap JS 및 jQuery -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<!-- 뭔지 모르겠는데 혹시나 해서 가져옴 -->
	<script src="js/jquery-1.12.4.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</head>
<body>

    <!-- HEADER -->
	
    <header id="header">
		<div class="header_wrap">
		
		
		<nav class="navbar navbar-expand-lg bg-body-tertiary">
			<div class="container-fluid">
				<a class="navbar-brand" href="index.html">
					<img src="eldd/images/logo_tmp.png" />
				</a>
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				
			<div class="collapse navbar-collapse" id="">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item">
						<a class="nav-link1" aria-current="page" href="ARPView.do">選んでみて!</a>
					</li>
					<li class="nav-item">
						<a class="nav-link2" href="sub2.html">条件検索</a>
					</li>
					<li class="nav-item">
						<a class="nav-link3" href="sub3.html">キーワード</a>
					</li>
					<li class="nav-item">
						<a class="nav-link4" href="RPMainView.do">ランキング</a>
					</li>
				</ul>
					
			</div>
			
			<div class="collapse navbar-collapse" id="">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item">
						<a class="nav-join" href="MemberMain.do">会員加入</a>
					</li>
					<li class="nav-item">
						<a class="nav-login" href="MemberMain.do">ログイン</a>
					</li>
				</ul>
					
			</div>
			
			</div>
		</nav>
		
      </div>
    </header>

</body>
</html>