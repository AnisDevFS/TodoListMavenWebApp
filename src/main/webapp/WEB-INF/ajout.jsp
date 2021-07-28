<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un tache</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

<div class="container"><br>
<h2>${connectedUser.getNom()} veut ajouter une tache</h2>
<br><br>

		<form method="post" action="ajouter">
			<div class="form-group">
				<label for="exampleInputEmail1">Tache à ajouter</label>
				<input
					type="text" class="form-control" id="tache" name="tache"
					aria-describedby="tache" placeholder="Enter tache">
			</div>

			<button type="submit" class="btn btn-primary">Ajouter</button>

		</form>
	</div>


</body>
</html>