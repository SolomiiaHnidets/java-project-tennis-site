
<html>
<head>
<title>Authentication form</title>
<link rel="stylesheet" href="/resources/themes/master.css" type="text/css" />
<link
 href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
 rel="stylesheet" type="text/css" />
<style>
 
 .myErrors {
  color:red;
 }
 
</style> 

<script
 src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js"
 type="text/javascript"></script>
<script
 src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
 type="text/javascript"></script>
<script
 src="http://ajax.microsoft.com/ajax/jquery.validate/1.7/jquery.validate.js"
 type="text/javascript"></script>
 
 <script src="/javaScript/login.js" type="text/javascript"></script>
<script src="/javaScript/validation_login.js" type="text/javascript"></script>
</head>
<body>
	<form name="auth_form" id="auth_form">
		Login:<input type="text" name="login" id="login" /><br /> Password:<input
			type="text" name="password" id="password" /><br /> <input
			type="submit" value="ok"  />
	</form>
</body>
</html>
