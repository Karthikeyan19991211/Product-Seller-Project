<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign-up Page</title>
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
	height: 50vh;
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
</style>
<link rel="shortcut icon" href="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6Bd2EB62Xf44y6M0pfX0n0KuwTRljQwAJ0eQPjzNwMHmh9ZKe8D3YoH-ly3T44lTR170&usqp=CAU" type="image/x-icon">
</head>
<body id="body1">
	<form action="signup" method="post" id="form">

		<span class="title">ID : </span> <input type="text" name="userId"
			placeholder="Enter the Id" autofocus required class="button">
		<br>
		<br> <span class="title">Name : </span> <input type="text"
			name="userName" placeholder="Enter the Name" required class="button">
		<br>
		<br> <span class="title">Contact : </span> <input type="tel"
			name="userContact" placeholder="Enter the Contact"
			pattern="[0-9]{10}" required class="button"> <br>
		<br> <span class="title">Email :</span> <input type="email"
			name="userEmail" placeholder="Enter the Email" required
			class="button"> <br>
		<br> <span class="title">Password :</span> <input type="password"
			name="userPassword" required class="button"> <br>
		<br> <a href="myIndex.jsp" target="_self"><input
			type="button" class="button1" id="reset" value="Cancel"></a> <input
			type="reset" class="button1" id="reset"> <br><br> <input type="submit"
			class="button1" id="reset">
	</form>
</body>
</html>