<%@page import="java.util.List"%>
<%@page import="dao.DAO_Product"%>
<%@page import="dto.DTO_Product"%>
<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>

<style>
table, td, th {
	border: 2px solid black;
	/* border-spacing: 12px; */
	border-collapse: collapse;
}

th {
	text-align: center;
	padding: 15px;
	color: red;
	font-size: 20px
}

td {
	text-align: center;
	padding: 5px;
	color: black;
	font-size: 20px
}

.button1 {
	border: 1px solid black;
	height: 30px;
	width: 90px;
	text-decoration: none;
	cursor: pointer;
	border-radius: 10px;
}

.button1:hover {
	background-color: #6e7176;
	color: white;
}

#table {
	width: 100%;
	height: auto;
}

#div {
	border: 2px solid black;
	width: 99.7%;
	height: 60px;
	background-color: skyblue;
	border-bottom: none;
}

.button2 {
	border: 2px solid grey;
	height: 30px;
	width: 90px;
	text-decoration: none;
	cursor: pointer;
	border-radius: 10px;
	position: absolute;
	right: 200px;
	top: 27px;
}

#space {
	position: absolute;
	right: 100px;
}

.button2:hover {
	background-color: #6e7176;
	color: white;
	border: 2px solid white;
}

#title {
	font-size: 29px;
	margin-left: 450px;
	margin-top: 0px;
}

p::first-letter {
	font-size: 50px;
	color: red;
}

#addp {
	width: 100px;
}
</style>
<link rel="shortcut icon"
	href="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQSiRdlZ7wEgx0N2zOp29mOGeOnPdYS4UbCuQ&usqp=CAU"
	type="image/x-icon">
</head>
<body>

	<div id="div">
		<p id="title">
			Your Product <i class="fa-solid fa-bag-shopping" style="color: grey;"></i>
		</p>
		<a href="addProduct.jsp" target="_self"><button class="button2"
				id="addp">
				<i class="fa-light fa-plus" style="font-size: 17px;"></i>Add Product
			</button></a> 
		
		<a href="productlogOut" target="_self"><input type="button" value="Log Out" id="space" class="button2"></a>


	</div>

	<table id="table">
		<tbody>
			<tr style="background: yellow;">
				<th>Product Id</th>
				<th>Product Name</th>
				<th>Brand Name</th>
				<th>Product Disc</th>
				<th>Product Mrp</th>
				<th>Product Image</th>
				<th>Edit Product</th>
				<th>Delete Product</th>
			</tr>
			<%
			DAO_Product p = new DAO_Product();
			List<DTO_Product> list = p.findAll();
			%>
			<%
			for (DTO_Product p1 : list) {
			%>
			<tr style="background: limegreen;">
				<td><%=p1.getId()%></td>
				<td><%=p1.getName()%></td>
				<td><%=p1.getBrand()%></td>
				<td><%=p1.getDisc()%></td>
				<td><%=p1.getMrp()%></td>

				<%
				String img = Base64.getEncoder().encodeToString(p1.getImg());
				%>
				<td><img src="data:image/jpeg;base64,<%=img%>" height="100px"
					width="100px"></td>
				<td><a href="edit?id=<%=p1.getId()%>"><button
							class="button1">Edit</button></a></td>

				<td><a href="delete?id=<%=p1.getId()%>"><button
							class="button1">Delete</button></a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<script src="https://kit.fontawesome.com/0238f0f5a2.js"
		crossorigin="anonymous"></script>
</body>
</html>