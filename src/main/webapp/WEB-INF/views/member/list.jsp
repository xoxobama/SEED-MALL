<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/top"/>
<style>

</style>
<div class="container mt-3" style="height:1000px;overflow: auto;">
	<h1 class="text-center">회원리스트</h1>
	<div>
		<%-- ${userArr} --%>
		<table class="table table-bordered mt-3">
			<tr>
				<th>번호</th>
				<th>이메일</th>
				<th>이름/등급</th>
				<th>연락처</th>
				<th>주소</th>
				<th>회원상태</th>
				<th>가입일자</th>
				<th>수정|삭제</th>
			</tr>
			<c:forEach var="user" items="${userArr}">
			<!-- ----------------------  -->
			<tr>
				<td>${user.midx}</td>
				<td>${user.email}</td>
				
				<td>${user.mname}</td><br>
				<td>${user.grade}</td>
				
				<td>${user.allHp}</td>
				<td>${user.post}</td><br>
				<td>${user.AllAddr}</td>
				<td>${user.mdate}</td>
				<td class="txt${user.status}">${user.statusStr}</td>
				<td>
				<a href="javascript:userEdit('${user.midx}')">수정</a>|
				<a href="#" onclick="userDel('${user.midx}')">삭제</a>
				</td>
			</tr>
			</c:forEach>
			<!-- ----------------------  -->
		</table> 
	</div>
</div>
<form name="frm" id="frm" method="post">
	<input type="hidden" name="idx" id="idx">
</form>
<script>
	function userDel(vidx){
		$('#midx').val(vidx);
		//attr():정적인 속성을 추가할 때 사용 , prop(): 기능적인 속성을 추가할 때 사용
		$('#frm').prop('action','userDel');
		$('#frm').submit();
	}
	function userEdit(vidx){
		$('#midx').val(vidx);
		$('#frm').prop('action','userEdit');
		$('#frm').submit();
	}

</script>

<c:import url="/foot" />




