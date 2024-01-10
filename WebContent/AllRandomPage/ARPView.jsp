<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- ARP view (sub1) start -->

<!-- viewTest -->
<style>
	td  {border:1px solid #ddd; text-align:center; display:inline-block; width:100px;}
</style>
<script>
	function checkAgain(){
		alert("랜덤 결과를 형성합니다. 잠시만 기다려주세요.")
		return true;
	}
</script>

<section>
	<h2>골라골라</h2>
	<form name="chooseRandom" method="post" action="ARPViewPrint.do" onsubmit="return checkAgain();">
		<table>
			<tr>
				<td>
					<input type="submit" value="랜덤 시작">
				</td>
			</tr>
		</table>
	</form>
</section>

<%@ include file="../footer.jsp" %>