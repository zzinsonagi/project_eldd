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

<h3>카테고리 선택</h3>
<form name="category" method="post" action="selectedCategoryPage.do">
<table>

<tr>
<td style="background: #ccc">국가별</td>
<td>
<c:forEach var="listCountry" items="${listCountry}" varStatus="statusCountry">
<input type="radio" class="radioCountry"
name="country"
value="${listCountry.eldd_country}">${listCountry.eldd_country}
</c:forEach>
</td>
</tr>

<tr>
<td style="background: #ccc">주 재료</td>
<td>
<c:forEach var="listIngredient" items="${listIngredient}" varStatus="statusIngredient">
<input type="radio" class="radioIngredient"
name="ingredient"
value="${listIngredient.eldd_ingredient}">${listIngredient.eldd_ingredient}
</c:forEach>
</td>
</tr>

<tr>
<td style="background: #ccc">계절</td>
<td>
<c:forEach var="listSeason" items="${listSeason}" varStatus="statusSeason">
<input type="radio" class="radioSeason"
name="season"
value="${listSeason.eldd_season}">${listSeason.eldd_season}
</c:forEach>
</td>
</tr>

<tr>
<td colspan="2" style="text-align:center">
<button type="submit" class="btn btn-default btn-sm">검색</button>
<button type="reset" class="btn btn-default btn-sm" onclick="/searchCategoryPage.do">초기화</button>
</td>
</tr>
</table>
</form>

<table class="table table-hover">
<tr>
<th>음식명</th>
<th>국가별 구분</th>
<th>주 재료</th>
<th>계절</th>
</tr>
<c:forEach var="listFood" items="${listFood}">
<tr>
<td>${listFood.eldd_foodname}</td>
<td>${listFood.eldd_country}</td>
<td>${listFood.eldd_ingredient}</td>
<td>${listFood.eldd_season}</td>
</tr>
</c:forEach>

</table>

<div class="paging">
	<c:if test="${page.prev}">
		<a href="searchCategoryPage.do?pageNum=${page.startPage-1}&amount=${page.cri.amount}&country=${page.cri.country}&ingredient=${page.cri.ingredient}&season=${page.cri.season}"><i class="fa fa-angle-left"></i></a>
	</c:if>
	<c:forEach var="num" begin="${page.startPage}" end="${page.endPage}">
		<a href="searchCategoryPage.do?pageNum=${num}&amount=${page.cri.amount}&country=${page.cri.country}&ingredient=${page.cri.ingredient}&season=${page.cri.season}" class="${page.cri.pageNum==num?'active':''}">${num}</a>
	</c:forEach>
	<c:if test="${page.next}">
		<a href="searchCategoryPage.do?pageNum=${page.next+1}&amount${page.cri.amount}&country=${page.cri.country}&ingredient=${page.cri.ingredient}&season=${page.cri.season}"><i class="fa fa-angle-right"></i></a>
	</c:if>
</div>

<%@ include file = "/footer.jsp" %>