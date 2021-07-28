<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

<div class="container"><br>
<h2>C'est ma page login</h2>
<br><br>

		<form method="post" action="login">
			<div class="form-group">
				<label for="exampleInputEmail1">Email</label>
				<input
					type="email" class="form-control" id="email" name="email"
					aria-describedby="email" placeholder="Enter email">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> 
				<input
					type="password" class="form-control" id="password" name="password"
					placeholder="Password">
			</div>
			<button type="submit" class="btn btn-primary">Se connecter</button>
			<br><br>
			<strong class="text-danger">${error }</strong>
		</form>
	</div>


</body>
</html>