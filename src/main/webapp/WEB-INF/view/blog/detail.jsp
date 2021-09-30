<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<div class="container">
		
		<c:if test="${user.id == boardDetail.userId }">
			<form action="/board/modifyPage" method="post" style="display: inline;">
				<input type="hidden" value="${boardDetail.id}" name="id">
				<input type="hidden" value="${boardDetail.title}" name="title">
				<input type="hidden" value="${boardDetail.content}" name="content">
				
				<input type="submit" value="수정" class="btn btn-warning">
			</form>
			
			
			<button class="btn btn-danger" id="delete_btn">삭제</button>
		</c:if>

	<br /> <br />
	<h6 class="m-2">
		작성자 : <i>${boardDetail.userId}</i> 조회수 : <i>${boardDetail.readCount}</i>
	</h6>
	<br />
	<h3 class="m-2">
		<b>${boardDetail.title}</b>
	</h3>
	<hr />
	<div class="form-group">
		<div class="m-2">${boardDetail.content}</div>
	</div>

	<hr />

	<!-- 댓글 박스 -->
	<div class="row bootstrap snippets">
		<div class="col-md-12">
			<div class="comment-wrapper">
				<div class="panel panel-info">
					<div class="panel-heading m-2">
						<b>Comment</b>
					</div>
					<div class="panel-body">
						<input type="hidden" name="userId"
							value="${sessionScope.principal.id}" /> <input type="hidden"
							name="boardId" value="${dto.id}" />
						<textarea id="content" id="reply__write__form"
							class="form-control" placeholder="write a comment..." rows="2"></textarea>
						<br>

						<button
							onClick="replySave(${sessionScope.principal.id}, ${dto.id})"
							class="btn btn-primary pull-right">댓글쓰기</button>

						<div class="clearfix"></div>
						<hr />

						<!-- 댓글 리스트 시작-->
						<ul id="reply__list" class="media-list">
								<!-- 댓글 아이템 -->
								<li id="reply-${reply.id}" class="media">
									<div class="media-body">
										<strong class="text-primary">${reply.userId}</strong>
										<p>${reply.content}</p>
									</div>
									<div class="m-2">
										<c:if test="${sessionScope.principal.id == reply.userId }">
											<i onclick="deleteReply(${reply.id})" class="material-icons">delete</i>
										</c:if>
									</div>
								</li>


						</ul>
						<!-- 댓글 리스트 끝-->
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- 댓글 박스 끝 -->
</div>

<script>
	$("#delete_btn").click(function(){
		if(confirm("삭제하시겠습니까?")){
			var id = ${boardDetail.id};
			
			$.ajax({
				type: "POST",
				url: "/board/delete",
				data: {"id" : id},
				success: function(){
					location.replace("/list");
				}
			});
		}
	})
</script>

</body>
</html>
