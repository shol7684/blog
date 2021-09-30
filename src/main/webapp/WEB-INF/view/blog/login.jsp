<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>



<div class="container">
	${loginFail }

	<form action="/login" method="post" >
		<div class="form-group">
			<label for="Username">Username</label> 
			<input type="text"	class="form-control" placeholder="Enter Username" id="Username" name="username" required autocomplete="off">
		</div>
		
		<div class="form-group">
			<label for="password">password</label> 
			<input type="password"	class="form-control" placeholder="Enter password" id="password" name="password" required>
		</div>
		
		<button type="submit" class="btn btn-primary">로그인</button>
	</form>

</div>


	

</body>
</html>