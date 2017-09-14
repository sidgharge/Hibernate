<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reset Password</title>

<!-- Bootsrap css link -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="styles/forgotpassword.css">

<script type="text/javascript" src="scripts/forgotpassword.js"></script>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-lg-5 col-md-6 col-sm-8 col-xs-8 center-col">
				<h1>Reset Password</h1>
				<hr>
				<form action="PreLogIn" method="post">
					<div class="form-group">
						<label for="email">Email address:</label> <input type="email"
							class="form-control" name="email" id="email">
					</div>

					<div class="form-group">
						<label for="password">New Password:</label> <input type="password"
							class="form-control" id="password" name="password">
					</div>

					<div class="form-group">
						<label for="cpassword">Confirm Password:</label> <input
							type="password" class="form-control" id="cpassword"
							name="cpassword">
					</div>

					<input type="submit" value="Reset Password"
						class="btn btn-danger btn-block btn-reset" onclick="return validateReset()">

				</form>
			</div>
		</div>
	</div>
</body>
</html>