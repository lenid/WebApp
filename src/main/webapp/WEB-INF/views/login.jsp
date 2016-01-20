<%@include file="include/head.jsp"%>

<style>
body {
	background-color: #F2F2F2;
}

h4 {
	border: 0 solid #fff;
	border-bottom-width: 1px;
	padding-bottom: 10px;
	text-align: center;
}

.form-control {
	border-radius: 10px;
}

.form-login {
	background-color: #E6E6E6;
	padding-top: 10px;
	padding-bottom: 20px;
	padding-left: 20px;
	padding-right: 20px;
	border-radius: 15px;
	border-color: #d2d2d2;
	border-width: 5px;
	box-shadow: 0 1px 0 #cfcfcf;
}

.main {
	padding: 70px;
	padding-top: 6%;
}

.message {
	padding: 15px;
}

.wrapper {
	text-align: center;
}
</style>

<body>
	<%@include file="include/top.jsp"%>

	<div class="col-lg-12 message">
		<c:if test="${not empty param.error}">
			<div class="alert alert-danger" role="alert">
				<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> 
				Error: <s:message code="login.error.bad_cred" />
				<!-- Will be delete -->
				<p>
					${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
				</p>
			</div>
		</c:if>
	</div>

	<div class="col-lg-4 col-lg-offset-4 main">

		<form class="form-signin" method="POST" action="<c:url value="/j_spring_security_check" />" role="form">
			<div class="form-login">
				<h4><s:message code="login.label.main" /></h4>
				<input class="form-control input-sm chat-input" name="j_username" type="text" placeholder="<s:message code="login.placeholder.login" />" required autofocus /> 
				</br> 
				<input class="form-control input-sm chat-input" name="j_password" type="password" placeholder="<s:message code="login.placeholder.passwd" />" required /> </br>
				<div>
					<a href="signup"><s:message code="login.href.signup" /></a>
				</div>
				<div class="wrapper">
					<button class="btn btn-primary" type="submit">
						<s:message code="login.button.signin" />
					</button>
				</div>
			</div>
		</form>

	</div>
</body>

</html>