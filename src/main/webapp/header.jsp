<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<head>
<!-- basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- mobile metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<!-- site metas -->
<title>Frica</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">
<!-- bootstrap css -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<!-- style css -->
<link rel="stylesheet" type="text/css" href="css/style.css">
<!-- Responsive-->
<link rel="stylesheet" href="css/responsive.css">
<!-- fevicon -->
<link rel="icon" href="images/fevicon.png" type="image/gif" />
<!-- Scrollbar Custom CSS -->
<link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
<!-- Tweaks for older IEs-->
<link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
<!-- fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap"
	rel="stylesheet">
<!-- owl stylesheets -->
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css"
	media="screen">
<link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css"
	rel="stylesheet" type="text/css" />
<style>
.isSelected {
	color: green;
	font-weight: bold;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="header_section haeder_main">
		<div class="container-fluid">
			<nav class="navbar navbar-light bg-light justify-content-between">
				<div id="mySidenav" class="sidenav">
					<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
					<a href="index.jsp">Home</a> <a href="computers.jsp">Computers</a>
					<a href="contact.html">Contact</a>
				</div>
				<span style="font-size: 30px; cursor: pointer; color: #fff;"
					onclick="openNav()"><img src="images/toggle-icon.png"></span>
				<a class="navbar-brand" href="index.jsp"><img
					src="images/logo.png"></a>
				<form class="form-inline ">
					<div class="login_text">
						<ul>
							<span>
								<li><a href="techLogin.jsp"><img
										src="images/user-icon.png"></a></li>
								<li><form action="home">
										<input type="text" name="productName"> <input
											type="submit" value="search">
									</form> <img src="images/trolly-icon.png"></li>
								<li><a href="#"><img src="images/search-icon.png"></a></li>
							</span>
						</ul>
					</div>
					<div>
						<c:if test="${not empty sessionScope.user}">
							<div>Hello ${sessionScope.user.getUser_name()}</div>
							<a href="techLogout">
								<button
									onclick="document.getElementById('id01').style.display='block'"
									style="width: auto;">Logout</button>
							</a>
						</c:if>
						<c:if test="${empty sessionScope.cart}"> Cart(0)</c:if>
						<br> <a href="techViewCart.jsp"><c:if
								test="${not empty sessionScope.cart}"> Cart(${sessionScope.cart.products.size()}) </c:if></a>
					</div>
				</form>
			</nav>
		</div>
	</div>
</body>
</html>