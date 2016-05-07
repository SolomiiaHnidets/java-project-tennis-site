<html>
<head>
	<link rel="stylesheet" type="text/css" href="/css/mystyle.css">
	<script src="/javaScript/authentication_ajax_request.js" type="text/javascript"></script>
	<script src="/javaScript/home_page_ajax_request.js" type="text/javascript"></script>
	<!-- Download the latest minified version of jQuery -->
	<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
	<!-- Download the latest jquery.validate minfied version -->
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
	<!-- Download the latest minified bootstrap version -->
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<!-- Adding our jQuery code -->
	<script type="text/javascript" src="/javaScript/validation_login.js"></script>
</head>
<body>

	<div class="loginmodal-container">
		<h1>Login to Your Account</h1>
		<br>
		<form name="auth_form" id="auth_form">
			<input type="text" name="login" placeholder="Username" id="login" required="true"> 
			<input type="password" name="password" placeholder="Password" id="password" required="true"> 
			<input type="submit" name="login" class="login loginmodal-submit" value="Login">
		</form>
	</div>

</body>
</html>