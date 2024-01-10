<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- RP MainView (sub4) start -->

<section>

		<div class="container-fluid">
		 <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
		  <!-- Indicators -->
		  <ol class="carousel-indicators">
		    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
		  </ol>
		
		  <!-- Wrapper for slides -->
		  <div class="carousel-inner" role="listbox">
		    <div class="item active">
		      <img src="images/test_slide1.jpg" alt="test1">
		      <div class="carousel-caption">
  	    		<h3>좋아요 랭킹 1위 음식</h3>
		      	<p>음식 이름은 이쪽</p>
		      </div>
		    </div>
		    <div class="item">
		      <img src="images/test_slide2.jpg" alt="test2">
		      <div class="carousel-caption">
		      	<h3>장르(국가별) 랭킹 1위 음식</h3>
		      	<p>음식 이름은 이쪽</p>
		      </div>
		    </div>
		    <div class="item">
		      <img src="images/test_slide3.png" alt="test3">
		      <div class="carousel-caption">
		      	<h3>성별 랭킹 1위 음식 (여자편)</h3>
		      	<p>음식 이름은 이쪽</p>
		      </div>
		    </div>
		    <div class="item">
		      <img src="images/test_slide4.jpg" alt="test4">
		      <div class="carousel-caption">
		      	<h3>성별 랭킹 1위 음식 (남자편)</h3>
		      	<p>음식 이름은 이쪽</p>
		      </div>
		    </div>
		  </div>
		
		  <!-- Controls -->
		  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
		    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		    <span class="sr-only">前へ</span>
		  </a>
		  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
		    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		    <span class="sr-only">後へ</span>
		  </a>
		</div>
	</div>
	
	<!-- 스르릉 버튼 (1) 전체 인기순  -->
		<div class="btn-group">
		  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Action <span class="caret"></span>
		  </button>
		  <ul class="dropdown-menu">
		    <li><a href="#">Action</a></li>
		    <li><a href="#">Another action</a></li>
		    <li><a href="#">Something else here</a></li>
		  </ul>
		</div>
		
	<!-- 스르릉 버튼 (2) 장르별 인기순  -->
		<div class="btn-group">
		  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Action <span class="caret"></span>
		  </button>
		  <ul class="dropdown-menu">
		    <li><a href="#">Action</a></li>
		    <li><a href="#">Another action</a></li>
		    <li><a href="#">Something else here</a></li>
		  </ul>
		</div>
		
	<!-- 스르릉 버튼 (3) 성별별 인기순  -->
		<div class="btn-group">
		  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Action <span class="caret"></span>
		  </button>
		  <ul class="dropdown-menu">
		    <li><a href="#">Action</a></li>
		    <li><a href="#">Another action</a></li>
		    <li><a href="#">Something else here</a></li>
		  </ul>
		</div>
	
	<div class="btn-group btn-group-justified" role="group" aria-label="...">
		<div class="btn-group" role="group">
	   		<a href="RPTotRank.do">전체 인기순</a>
	    </div>
	    <div class="btn-group" role="group">
	    	<a href="RPCountryRank.do">장르별 인기순</a>
	    </div>
	    <div class="btn-group" role="group">
	    	<a href="RPGenderRank.do">성별 인기순</a>
	    </div>
    </div>
    
	<h3>今日のおすすめはこちら！</h3>
		<div class="btn-group btn-group-justified" role="group" aria-label="...">
		  <div class="btn-group" role="group">
		    <button type="button" class="btn btn-default">전체 인기순</button>
		  </div>
		  <div class="btn-group" role="group">
		    <button type="button" class="btn btn-default">장르별 인기순</button>
		  </div>
		  <div class="btn-group" role="group">
		    <button type="button" class="btn btn-default">성별 인기순</button>
		  </div>
		</div>


</section>

<%@ include file="../footer.jsp" %>