<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log-in Page</title>
<style>
#body1 {
	background-image:
		url("https://images.unsplash.com/photo-1481437156560-3205f6a55735?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8c2hvcHBpbmd8ZW58MHx8MHx8fDA%3D");
	background-repeat: no-repeat;
	background-size: 100% 100%;
	height: 85.5vh;
	position: relative;
	opacity: 0.8;
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
		url("https://w0.peakpx.com/wallpaper/300/363/HD-wallpaper-girls-love-to-shop-female-girls-smile-cute-bags-shopping.jpg");
	background-repeat: no-repeat;
	background-size: 100% 100%;
}

.button {
	height: 20px;
	width: 200px;
}

#reset {
	margin-left: 20px;
}

.title {
	font-size: 20px;
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

#para{
font-size:25px;
color:red;
margin-left:0px;
margin-top:0px;
opacity:1.0;
border:1px solid black;
background-color:yellow;
width:600px;
}

</style>
<link rel="shortcut icon" href="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQSiRdlZ7wEgx0N2zOp29mOGeOnPdYS4UbCuQ&usqp=CAU" type="image/x-icon">
</head>
<body id="body1">



	<form action="login" method="post" id="form">
	
		<%
	String passmessage = (String) request.getAttribute("message");
	%>
	<%
	if (passmessage != null) {
	%>
	<span id="para"><%=passmessage%></span> <br><br>
	<%
	}
	%>

	
		<span class="title">Email : </span><input type="text" name="userEmail"
			autofocus required class="button"> <br> <br> <span
			class="title">Password : </span><input type="password"
			name="userPassword" required class="button"> <br> <br>
		<a href="myIndex.jsp" target="_self"><input type="button"
			class="button1"  value="Cancel"></a> <input
			type="submit" class="button1" id="reset">
			
			<p style="color:black;">Don't have an account?<a href="SignupPage.jsp">Sign up</a></p>			
	</form>

</body>
</html>