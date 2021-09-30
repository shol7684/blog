<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<div class="container">

	<div class="m-2">
		<form class="form-inline d-flex justify-content-end" action="/blog/board">
			<input type="hidden" name="cmd" value="search" />
			<input type="hidden" name="page" value="0" />
			
			<input type="text" name="keyword" class="form-control mr-sm-2" placeholder="Search">			
			<button class="btn btn-primary m-1">검색</button>
		
		</form>
	</div>

	<div class="progress col-md-12 m-2">
		<div class="progress-bar" style="width: ${currentPersent }%"></div>
	</div>

		<div class="card col-md-12 m-2">
			<div class="card-body">
				<c:forEach items="${boardList }" var="boardList" >
					<span>${boardList.id }</span>
					<a href="/board/detail/${boardList.id}" style="font-size: 20px;">${boardList.title }</a>
					<hr>
				</c:forEach>
			
			
			</div>
		</div>

	<br />
	<ul class="pagination justify-content-center">
		<c:if test="${startPage - 1 <= 0 }">
			<li class="page-item disabled"><a class="page-link" href="/list/${startPage - 1 }">Previous</a></li>
		</c:if>
		<c:if test="${startPage - 1 > 0 }">
			<li class="page-item "><a class="page-link" href="/list/${startPage -1 }">Previous</a></li>
		</c:if>
		
		<c:set var="n" value="5" />
		<c:set var="start" value="1" />
		
		<c:forEach begin="${startPage }" end="${endPage }" var="i">
			<c:if test="${i <= totalPage }">
				<c:if test="${page == i }">
					<li><a href="/list/${i }" style="color: red; font-weight: bold;">${i }</a></li>
				</c:if>
				<c:if test="${page != i }">
					<li><a href="/list/${i }" >${i }</a></li>
				</c:if>
			</c:if>
		</c:forEach>
		
		<c:if test="${startPage + 4 <= totalPage }">
			<li class="page-item"><a class="page-link" href="/list/${startPage + 5 }">Next</a></li>
		</c:if>
		<c:if test="${startPage + 4 > totalPage }">
			<li class="page-item disabled"><a class="page-link" href="/list/${startPage + 5}">Next</a></li>
		</c:if>
		
		
	</ul>
</div>
</body>
</html>

