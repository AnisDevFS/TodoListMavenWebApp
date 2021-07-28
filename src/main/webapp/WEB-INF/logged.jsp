<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>${connectedUser.getNom()} Logged</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

</head>

<body>

	<div class=" row bg-light p-5"
		style="width: 100%; margin-left: auto; margin-right: auto; margin-top: 50px; text-align: center;">
		<div class="col-11">
		
			<h3>Liste des taches ${connectedUser.getNom()}</h3> 
			<table class="table">
				<thead class="thead-dark">
					<tr>	
						<th scope="col">Id</th>		
						<th scope="col">Texte</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="tache" items="${connectedUser.getTaches()}">
								<tr>
								<td><c:out value="${tache.getId_tache()}" /></td>
								<td><c:out value="${tache.getTexte()}" /></td>
								<td><a class="btn btn-danger" href="supprimer?idTache=${tache.getId_tache() }"><i class="far fa-trash-alt"></i></a>
								<a class="btn btn-warning" href="modifier?idTache=${tache.getId_tache() }"><i class="far fa-edit"></i></a>
								</td>
								
								</tr>
					</c:forEach>
				</tbody>
			</table>
<!-- 			<form method="post" action="jstl"> -->
<!--                 <label for='txtNom'>Nouveau produit :</label> -->
<!--                 <input id='txtNom' name='txtNom' type='text' value='' autofocus /> <br /> -->
<!--                 <br /> -->
<!--                 <input name='btnConnect' type='submit' value='Ajouter Nom' /> <br /> -->
<!--             </form> -->
<br> 
       
            <a href="ajouter" class="btn btn-primary" 
            name='btnConnect' />Ajouter Tache</a> <br/>
        
		</div>
		

	</div>
</body>

</html>