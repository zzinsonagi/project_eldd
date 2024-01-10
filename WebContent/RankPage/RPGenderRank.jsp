<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>

<!-- RP TotRankview (sub4) start -->

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
	<h2>성별 인기순 TOP 5 (그림 상에선 없었으니 빼셔도 됩니당)</h2>
	<div class="container">
		<div class="row">
			<div class="col-lg-6">
				<div class="box">
				<img src="images/test_slide4.jpg" class="img-fluid">
				</div>
			</div>
			<div class="col-lg-6">
				<div class="box">
				<img src="images/test_slide4.jpg" class="img-fluid">
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-4">
				<div class="box">
				<img src="images/test_slide4.jpg" class="img-fluid">
				</div>
			</div>
			<div class="col-lg-4">
				<div class="box">
				<img src="images/test_slide4.jpg" class="img-fluid">
				</div>
			</div>
			<div class="col-lg-4">
				<div class="box">
				<img src="images/test_slide4.jpg" class="img-fluid">
				</div>
			</div>
		</div>
	</div>
	
</section>

<%@ include file="../footer.jsp" %>