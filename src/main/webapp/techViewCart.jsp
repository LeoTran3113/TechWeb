<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
</head>
<body>
	<c:if test="${empty sessionScope.user}">
		<a href="techLogin.jsp">Please signin to checkout your cart</a>
	</c:if>
	<c:if test="${not empty sessionScope.user}">


		<div class="container mt-5 mb-5">
			<div class="d-flex justify-content-center row">
				<div class="col-md-8">
					<div class="p-2 d-flex justify-content-between">
						<h4>Your Shopping cart</h4>
						<a href="home"><h4>
								<mark class="text-danger">Continue Shopping</mark>
							</h4></a>

					</div>
					<c:forEach var="product" items="${sessionScope.cart.products}"
						varStatus="status">
						<div
							class="d-flex flex-row justify-content-between align-items-center p-2 bg-white mt-4 px-3 rounded">
							<div class="mr-1">
								<img class="rounded" src="${product.image}" width="70">
							</div>
							<div
								class="d-flex flex-column align-items-center product-details">
								<span class="font-weight-bold">${product.name}</span>

							</div>
							<%-- <div class="d-flex flex-row align-items-center qty">
								<a class="fa fa-minus text-danger" href="techQuantity?action=dec&productId=${cart.getProductId()}>"></a>
								<h5 class="text-grey mt-1 mr-1 ml-1">${cart.getQuantity()}</h5>
								<a class="fa fa-plus text-success" href="techQuantity?action=dinc&productId=${cart.getProductId()}>"></a>
							</div> --%>
							<div >
								<h5 class="text-grey">${product.price}</h5>
							</div>

							<div class="d-flex align-items-center">
								<i class="fa fa-trash mb-1 text-danger"></i> <a
									class="text-info"
									href="techCart?command=REMOVE&productId=${product.id}">Remove</a>
							</div>
						</div>
					</c:forEach>
					Total Price: ${sessionScope.cart.totalPrice}
					<div
						class="d-flex flex-row align-items-center mt-3 p-2 bg-white rounded">
						<a class="btn btn-warning btn-block btn-lg ml-2 pay-button"
							href="techCart?command=CHECKOUT">Checkout</a>
					</div>
				</div>
			</div>
		</div>
	</c:if>

	<c:import url="footer.jsp"></c:import>
</body>
</html>