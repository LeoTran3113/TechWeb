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
	<c:import url="header.jsp"></c:import>
	
	
	<div class="container mt-5 mb-5">
    <div class="row d-flex justify-content-center">
        <div class="col-md-10">
            <div class="card">
                <div class="row">
                    <div class="col-md-6">
                        <div class="images p-3">
                            <div class="text-center p-4"> <img id="main-image" src="${product.image}" width="250" /> </div>
                            
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="product p-4">
                           
                            <div class="mt-4 mb-3"> 
                                <h5 class="text-uppercase">${product.name}</h5>
                                
                            </div>
                            <p class="about">Shop from a wide range of t-shirt from orianz. Pefect for your everyday use, you could pair it with a stylish pair of jeans or trousers complete the look.</p>
                           <div class="text-danger text-lg my-3" style="font-size:40px">$${product.price}</div>
                            <div class="cart mt-4 align-items-center"> <a href="techCart?command=ADD_TO_CART&productId=${product.id}" class="btn btn-danger text-uppercase mr-2 px-4">Add to cart</a> <i class="fa fa-heart text-muted"></i> <i class="fa fa-share-alt text-muted"></i> </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
	
	
	<c:import url="footer.jsp"></c:import>
</body>
</html>