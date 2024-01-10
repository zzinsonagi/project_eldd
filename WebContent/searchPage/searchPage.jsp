<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/footer.jsp" %>
<form name="food" method="post" action="searchFoodList.do">
<div class="row">
  <div class="col-lg-6">
    <div class="input-group">
      <input type="text" name="foodname" placeholder="검색할 음식은 무엇인가용">
      <span class="input-group-btn">
        <button class="btn btn-default" type="submit">검색</button>
      </span>
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
</div><!-- /.row -->
</form>
<%@ include file="/footer.jsp" %>