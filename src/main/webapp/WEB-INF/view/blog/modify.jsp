<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
<div class="container">
	<form action="/board/modify" method="POST">
	
		<div class="form-group">
			<label for="title">Title:</label>
			<input type="text" class="form-control" placeholder="title" id="title" name="title" autocomplete="off" value="${boardVO.title }">
		</div>
	
		<div class="form-group">
			<label for="content">Content:</label>
			<textarea class="form-control" rows="5" id="summernote" name="content" >${boardVO.content }</textarea>
		</div>
	
		<input type="hidden" value="${boardVO.id }" name="id" >
		<button type="submit" class="btn btn-primary">수정 하기</button>
	</form>
</div>


  <script>
    $(document).ready(function() {
        $('#summernote').summernote({
        	tabsize: 2,
        	height: 300
        });
    });
  </script>



</body>
</html>

