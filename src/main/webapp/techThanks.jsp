<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bootstrap 5 Thank You Example</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="d-flex justify-content-center align-items-center">
		<div>
			<div class="mb-4 text-center">
				<svg xmlns="http://www.w3.org/2000/svg" class="text-success"
					width="75" height="75" fill="currentColor"
					class="bi bi-check-circle-fill" viewBox="0 0 16 16">
                        <path
						d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z" />
                    </svg>
			</div>
			<div class="text-center">
				<h1>Thank You For Shoping With FRICA !</h1>
				<a class="btn btn-primary" href="home">Back Home</a>
			</div>
		</div>
		
	</div>
	
	
	
<c:import url="footer.jsp"></c:import>
</body>
</html>