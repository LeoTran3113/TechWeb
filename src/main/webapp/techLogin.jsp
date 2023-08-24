<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="sidenav"></div>
	<div class="main">
		<div class="login-main-text">
			<h1>
				Frica Login Page
				<h1 />
		</div>
		<div class="col-md-6 col-sm-12">
			<div class="login-form">
				<form action="login" method="get">
					<h1>
						<p {color: red;} class="text-danger">${message}</p>
					</h1>

					<div class="form-group">
						<label>User Name</label> <input name="user" type="text"
							class="form-control" placeholder="User Name">
					</div>
					<div class="form-group">
						<label>Password</label> <input name="pass" type="password"
							class="form-control" placeholder="Password">
					</div>
					<div class="form-group">
						<a href="forgotPassword.jsp">Forgot Password?</a>
					</div>
					<button type="submit" class="btn btn-black">Login</button>

				</form>

				<div class="sign-up text-danger">
					Don't have an account? <a href="techRegister.jsp"> Create One </a>
				</div>
			</div>
		</div>
	</div>
	<%-- 	<div class="pt-5">
		<div class="global-container">
			<div class="login-form">

				<h1>Frica Login Page</h1>
				<div class="card-text">
					<form action="login" method="get">
						<h1>
							<p {color: red;} class="text-danger">${message}</p>
						</h1>
						<div class="form-group">
							<label>Enter Username </label> <input name="user" type="text"
								class="form-control" placeholder="User Name">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Enter Password </label> <a
								href="#" style="float: right; font-size: 12px;"> Forgot
								password? </a> <input type="password"
								class="form-control form-control-sm" id="exampleInputPassword1">
						</div>
						<button type="submit" class="btn btn-primary btn-block">
							Sign in</button>
					</form>
					<div class="sign-up">
						Don't have an account? <a href="#"> Create One </a>
					</div>

				</div>
			</div>
		</div>
	</div> --%>
	<c:import url="footer.jsp"></c:import>
</body>
</html>