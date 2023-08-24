
<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
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
.text-underlined >li{color: red!important}
</style>

</head>
<body>
	<!-- header section start -->
	<c:import url="header.jsp"></c:import>

	<!--<div>
						<c:if test="${empty productList}"> Sorry! There is no book available</c:if>
						<c:if test="${not empty productList}">
							<ul>
								<c:forEach var="product" items="${productList}">
									<a href="bookDetail?bookId=${product.id}">
										<li>${product.name}</li>
									</a>
								</c:forEach>
							</ul>
						</c:if>
					</div>-->

	<!-- header section end -->
	<!-- banner section start -->
	<div class="banner_section layout_padding">
		<!--  -->
		<div id="my_slider" class="carousel slide" data-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<div class="container">
						<div class="row border_1">
							<div class="col-md-4">
								<div class="image_1">
									<img src="images/img-1.png" style="width: 100%">
								</div>
							</div>
							<div class="col-md-4">
								<h1 class="banner_taital">Big Sale Offer</h1>
								<!-- <div class="buynow_bt active">
									<a href="#">Buy Now</a>
								</div> -->
								<!-- 	<div class="contact_bt">
									<a href="#">Contact Us</a>
								</div> -->
							</div>
							<div class="col-md-4">
								<div class="image_2">
									<img src="images/img-2.png" style="width: 100%">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="carousel-item">
					<div class="container">
						<div class="row border_1">
							<div class="col-md-4">
								<div class="image_1">
									<img src="images/img-1.png" style="width: 100%">
								</div>
							</div>
							<div class="col-md-4">
								<h1 class="banner_taital">Big Sale Offer</h1>
								<!-- <div class="buynow_bt active">
									<a href="#">Buy Now</a>
								</div> -->
								<!-- <div class="contact_bt">
									<a href="contact.html">Contact Us</a>
								</div> -->
							</div>
							<div class="col-md-4">
								<div class="image_2">
									<img src="images/img-2.png" style="width: 100%">
								</div>
							</div>
						</div>
					</div>
				</div>

				<a class="carousel-control-prev" href="#my_slider" role="button"
					data-slide="prev"> <i class="fa fa-angle-left"></i>
				</a> <a class="carousel-control-next" href="#my_slider" role="button"
					data-slide="next"> <i class="fa fa-angle-right"></i>
				</a>
			</div>
		</div>
		<!-- banner section end -->
		<!-- catagary section start -->
		<div class="catagary_section layout_padding justify-content-center">
			<div class="container">
				<div class="catagary_main">
					<div class="catagary_left">
						<h2 class="categary_text">Brands</h2>
					</div>
					<div class="catagary_right">
						<div class="catagary_menu">
							<ul class="d-flex justify-content-center">
								<c:forEach var="category" items="${categoryList}">
									<a class="mx-5 ${category.id == categoryId ? 'text-underlined' : ''}" href="home?categoryId=${category.id}">
										<li>${category.name}</li>
									</a>
									<%-- <li
										class="cate-item ${category == categoryList.name ? 'active' : ''}"><a
										class="cate-link" href="home?categoryId=${category}">${category}</a></li> --%>
								</c:forEach>

							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="catagary_section_2">
			<div class="container-fluid pt-4">
				<div class="row">
					<c:forEach var="product" items="${productList}">
						<div class="col-md-4 mb-4">


							<div class="box_man h-100 d-flex flex-column">
								<a class="d-block h-100"
									href="techProductDetail?productId=${product.id}">
									<h3 class="mobile_text">${product.name}</h3>
									<div class="camera_im flex-fill">
										<img src="${product.image}">
									</div>
								</a>
								<div class="cart_main">
									<div class="cart_bt">
										<a href="techCart?command=ADD_TO_CART&productId=${product.id}">
											Add To Cart </a>
									</div>
									<h4 class="samsung_text">${product.name}</h4>
									<h6 class="rate_text">
										<div>${product.price}</div>
									</h6>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>

			<!-- paging statrt -->
			<ul class="pagination justify-content-center">

				<c:forEach var="pageNumber" begin="1" end="${totalPage}">
					<li class="page-item ${pageNumber == currentPage ? 'active' : ''}"><a
						class="page-link" href="home?page=${pageNumber}">${pageNumber}</a></li>


				</c:forEach>

			</ul>
		</div>
		<!-- paging end -->
		<!-- catagary section end -->
		<!-- computers section start -->
		<!-- <div class="computers_section layout_padding">
		<div class="container">
			<h1 class="computers_taital">Computers & Laptop</h1>
		</div>
	</div>
	<div class="computers_section_2">
		<div class="container-fluid">
			<div class="computer_main">
				<div class="row">
					<div class="col-md-4">
						<div class="computer_img">
							<img src="images/computer-img.png">
						</div>
						<h4 class="computer_text">COMPUTER</h4>
						<div class="computer_text_main">
							<h4 class="dell_text">Samsung</h4>
							<h6 class="price_text">
								<a href="#">$500</a>
							</h6>
							<h6 class="price_text_1">
								<a href="#">$1000</a>
							</h6>
						</div>
						<div class="cart_bt_1">
							<a href="#">Add To Cart</a>
						</div>
					</div>
					<div class="col-md-4">
						<div class="computer_img">
							<img src="images/laptop-img.png">
						</div>
						<h4 class="computer_text">LAPTOP</h4>
						<div class="computer_text_main">
							<h4 class="dell_text">Dell</h4>
							<h6 class="price_text">
								<a href="#">$500</a>
							</h6>
							<h6 class="price_text_1">
								<a href="#">$1000</a>
							</h6>
						</div>
						<div class="cart_bt_1">
							<a href="#">Add To Cart</a>
						</div>
					</div>
					<div class="col-md-4">
						<div class="computer_img">
							<img src="images/mac-img.png">
						</div>
						<h4 class="computer_text">macOS</h4>
						<div class="computer_text_main">
							<h4 class="dell_text">Apple</h4>
							<h6 class="price_text">
								<a href="#">$500</a>
							</h6>
							<h6 class="price_text_1">
								<a href="#">$1000</a>
							</h6>
						</div>
						<div class="cart_bt_1">
							<a href="#">Add To Cart</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div> -->
		<!-- computers section end -->


		<!-- footer section start -->
		<c:import url="footer.jsp"></c:import>
		<!-- footer section end -->
		<!-- copyright section start -->
		<div class="copyright_section">
			<div class="container">
				<p class="copyright_text">
					2020 All Rights Reserved. Design by <a href="https://html.design">Free
						html Templates</a>
				</p>
			</div>
		</div>
		<!-- copyright section end -->
		<!-- Javascript files-->
		<script src="js/jquery.min.js"></script>
		<script src="js/popper.min.js"></script>
		<script src="js/bootstrap.bundle.min.js"></script>
		<script src="js/jquery-3.0.0.min.js"></script>
		<script src="js/plugin.js"></script>
		<!-- sidebar -->
		<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
		<script src="js/custom.js"></script>
		<!-- javascript -->
		<script src="js/owl.carousel.js"></script>
		<script
			src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
		<script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js"
			type="text/javascript"></script>
		<script>
			function openNav() {
				document.getElementById("mySidenav").style.width = "100%";
			}

			function closeNav() {
				document.getElementById("mySidenav").style.width = "0";
			}
		</script>
</body>
</html>