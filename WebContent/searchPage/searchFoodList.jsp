<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/header.jsp" %>

<div class="container">
	  <div class="search_wrap">
	  <div class="bord_list">
		<table class="bord_table">
			<caption class="sr-only">검색 결과</caption>
			<colgroup>
				<col width="30%">
			</colgroup>
				<tr>
					<th>음식이름</th>
				</tr>
				<c:forEach var="sfood" items="${foodList}">
				<tr>
					<td>${sfood.eldd_foodname}</td>
				</tr>
				</c:forEach>
		</table>
		<div class="paging">
		<c:if test="${page.prev}">
			<a href="searchFoodList.do?pageNum=${page.startPage-1}&amount=${page.cri.amount}&foodname=${page.cri.foodname}"><i class="fa fa-angle-left"></i></a>
		</c:if>
		<c:forEach var="num" begin="${page.startPage}" end="${page.endPage}">
			<a href="searchFoodList.do?pageNum=${num}&amount=${page.cri.amount}&foodname=${page.cri.foodname}" class="${page.cri.pageNum==num?'active':''}">${num}</a>
		</c:forEach>
		<c:if test="${page.next}">
			<a href="searchFoodList.do?pageNum=${page.next+1}&amount${page.cri.amount}&foodname=${page.cri.foodname}"><i class="fa fa-angle-right"></i></a>
		</c:if>
		</div>
	  </div>
	</div>
</div>
<%@ include file = "/footer.jsp" %>