<%@page import="dao.DAO_Product"%>
<%@page import="java.util.Base64"%>
<%@page import="dto.DTO_Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Product</title>

<style>

#body1 {
	background-image:
		url("https://www.wallpapers13.com/wp-content/uploads/2016/08/New-York-night-USA-port-lit-buildings-reflection-in-water-HD-Wallpaper-for-Desktop-1920x1200-1920x1080.jpg");
	background-repeat: no-repeat;
	background-size: 100% 100%;
	height: 85.5vh;
	position: relative;
	opacity: 0.9;
}

#form {
	border: 1px solid black;
	text-align: center;
	height: 60vh;
	width: 80vh;
	margin-top: 80px;
	margin-left: 400px;
	padding-top: 50px;
	padding-bottom:50px;
	background-image:
		url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSUCiPslQaeqGcKChUcPc8dAULCOKlX9UbTwPoBV_r-TXLt5na4YECMXRJvkf5cX6WUo1g&usqp=CAU");
	background-repeat: no-repeat;
	background-size: 100% 100%;
}

.button1 {
	height: 30px;
	width: 200px;
	font-size: 15px;
	cursor: pointer;
}

.button1:hover {
	background-color: rgb(124, 121, 121);
	color: rgb(244, 237, 237);
	font-size: 20px;
	border-style: none;
}


</style>
<link rel="shortcut icon" href="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQSiRdlZ7wEgx0N2zOp29mOGeOnPdYS4UbCuQ&usqp=CAU" type="image/x-icon">
</head>

<body id="body1">

<%DTO_Product product = (DTO_Product) request.getAttribute("productUpdate"); %>

<form action="finalProduct" method="post" enctype="multipart/form-data" id="form">
	
		Product Id : <input type="text" name="productId" autofocus value="<%=product.getId()%>" readonly> <br> <br>
		Product Name : <input type="text" name="productName" value="<%=product.getName()%>"> <br><br>
		Brand Name : <input type="text" name="brandName" value="<%=product.getBrand()%>"> <br> <br>
		Product Disc % : <input type="text" name="productDisc" value="<%=product.getDisc()%>"> <br> <br>
		Product MRP : <input type="text" name="productMrp" value="<%=product.getMrp()%>">
		<br> <br>
		<%
		String image = Base64.getEncoder().encodeToString(product.getImg());
		%>
		Add Image: <input type="file" name="updateImage"> <br> <br> 
		<img src="data:image/jpeg;base64,<%=image%>" height="100px"
			width="100px"> <br> <br> <input type="submit" class="button1">
		<a href="Home.jsp" target="_self"><input type="button" value="Cancel" class="button1"></a>
	</form>

</body>
</html>