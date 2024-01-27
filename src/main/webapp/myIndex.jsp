<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>

<style>
#body1 {
	background-image:
		url("https://images.unsplash.com/photo-1481437156560-3205f6a55735?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8c2hvcHBpbmd8ZW58MHx8MHx8fDA%3D");
	background-repeat: no-repeat;
	background-size: 100% 100%;
	height: 85.5vh;
	position: relative;
	opacity: 1.0;
}

#form {
	border: 1px solid black;
	text-align: center;
	height: 50vh;
	width: 100vh;
	margin-top: 80px;
	margin-left: 300px;
	padding-top: 150px;
	background-image:
		url("https://c4.wallpaperflare.com/wallpaper/418/116/876/5bd4369c73870-wallpaper-preview.jpg");
	background-repeat: no-repeat;
	background-size: 100% 100%;
}

a:link {
	text-decoration: none;
}

a:visited {
	color: white;
}

a:active {
	color: red;
}

a:hover {
	font-size: 30px;
	color: red;
}

.button {
	border: 1px solid black;
	height: 40px;
	width: 250px;
	border-radius: 10px;
	font-size: 20px;
	position: relative;
	margin-left: 200px;
	padding-top: 8px;
	background-color: rgb(61, 53, 53);
}

.button:hover {
	background-color: rgb(124, 121, 121);
}


</style>
<link rel="shortcut icon" href="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQSiRdlZ7wEgx0N2zOp29mOGeOnPdYS4UbCuQ&usqp=CAU" type="image/x-icon">
</head>
<body id="body1">

	<%
	String message = (String) request.getAttribute("message");
	%>

	<%
	if (message != null) {
	%>
	<%=message%>
	<%
	}
	%>

	<form action="" id="form">
		<p class="button">
			<a href="LoginPage.jsp" target="_self">Login &nbsp;<i class="fa-solid fa-arrow-right-to-bracket" style="font-size:25px;"></i></a>
		</p>
		<p class="button">
			<a href="SignupPage.jsp" target="_self">Sign-up</a>
		</p>
	</form>

<script src="https://kit.fontawesome.com/0238f0f5a2.js" crossorigin="anonymous"></script>

</body>
</html>