<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
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
	
	<!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" rel="stylesheet" />

    <!-- css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mainstyles.css"/>

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
					<a class="navbar-brand" href="main.do">
						<img src="${pageContext.request.contextPath}/images/logo_tmp.png"/>
					</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				  <ul class="nav navbar-nav">
					<li><a class="nav-link1" href="sub1.do">選んでみて!</a></li>
					<li><a class="nav-link2" href="sub2.do">条件検索</a></li>
					<li><a class="nav-link3" href="sub3.do">キーワード</a></li>
					<li><a class="nav-link4" href="sub4.do">ランキング</a></li>
				  </ul>
				  <ul class="nav navbar-nav navbar-right">
					<li><a class="nav-join" href="terms.do">会員登録</a></li>
					<li><a class="nav-login" href="login.do">ログイン</a></li>
					<li><a class="nav-mypage" href="mypage.do">マイページ</a></li>
					<li><a class="nav-logout" href="">ログアウト</a></li>
				  </ul>
				</div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
			</div>
		</header>
		
		
	
		