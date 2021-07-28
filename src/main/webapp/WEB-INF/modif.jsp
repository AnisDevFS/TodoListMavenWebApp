<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier une tache</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

<div class="container"><br>
<h2>${connectedUser.getNom()} veut modifier une tache</h2>
<br><br>

		<form method="post" action="modifier?idTache=${tacheAModifier.getId_tache() }">
			<div class="form-group">
				<label for="exampleInputEmail1">Tache à modifier</label>
				<input
					type="text" class="form-control" id="tacheAModifier" 
					name="tacheAModifier"
					value="${tacheAModifier.getTexte() }">
			</div>

			<button type="submit" class="btn btn-warning">Modifer</button>

		</form>
	</div>


</body>
</html>