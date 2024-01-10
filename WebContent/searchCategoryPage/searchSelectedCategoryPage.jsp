<%@page import="java.util.ArrayList"%>
<%@page import="dao.searchCategoryPage.SearchCategoryPageVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/header.jsp" %>
<style>
.btn:active {
  position:relative;
  box-shadow:inset 0 0 3px;}
  
table, tr, td, th {
border:1px solid #ccc;
}
</style>
 
<form name="category" method="post" action="searchCategoryPage.do">
<table>
<tr>
<td style="text-align:center">
<button type="submit" class="btn btn-default btn-sm">초기화</button>
</td>
</tr>
</table>
</form>

    <div class="section4">
      <div data-aos="fade-up" data-aos-once="false">
        <div class="section4-wrap">
          <section class="other">
            <h2>条件によるおすすめ</h2>
            <div class="container">
            <c:choose>
            <c:when test="${empty country}">
              <h3 class="col-md-4">미선택</h3>
            </c:when>
            <c:otherwise>
              <h3 class="col-md-4">${country}</h3>
            </c:otherwise>
			</c:choose>
			<c:choose>
			<c:when test="${empty ingredient}">
              <h3 class="col-md-4">미선택</h3>
            </c:when>
            <c:otherwise>
              <h3 class="col-md-4">${ingredient}</h3>
            </c:otherwise>
            </c:choose>
			<c:choose>
			<c:when test="${empty season}">
              <h3 class="col-md-4">미선택</h3>
            </c:when>
            <c:otherwise>
           	  <h3 class="col-md-4">${season}</h3>
            </c:otherwise>
            </c:choose>
            </div>
          </section>
		</div>
	  </div>
	</div>
<table class="table table-hover">
<tr>
<th>음식명</th>
<th>국가별 구분</th>
<th>주 재료</th>
<th>계절</th>
</tr>
<c:forEach var="listFood" items="${selectedCategory}">
<tr>
<td>${listFood.eldd_foodname}</td>
<td>${listFood.eldd_country}</td>
<td>${listFood.eldd_ingredient}</td>
<td>${listFood.eldd_season}</td>
</tr>
</c:forEach>
</table>
	
	<!-- Paging -->
	<div class="paging">
		<c:if test="${page.prev}">
			<a href="selectedCategoryPage.do?pageNum=${page.startPage-1}&amount=${page.cri.amount}&country=${page.cri.country}&ingredient=${page.cri.ingredient}&season=${page.cri.season}"><i class="fa fa-angle-left"></i></a>
		</c:if>
		<c:forEach var="num" begin="${page.startPage}" end="${page.endPage}">
			<a href="selectedCategoryPage.do?pageNum=${num}&amount=${page.cri.amount}&country=${page.cri.country}&ingredient=${page.cri.ingredient}&season=${page.cri.season}" class="${page.cri.pageNum==num?'active':''}">${num}</a>
		</c:forEach>
		<c:if test="${page.next}">
			<a href="selectedCategoryPage.do?pageNum=${page.next+1}&amount${page.cri.amount}&country=${page.cri.country}&ingredient=${page.cri.ingredient}&season=${page.cri.season}"><i class="fa fa-angle-right"></i></a>
		</c:if>
	</div>
<%@ include file = "/footer.jsp" %>