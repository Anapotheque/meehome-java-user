<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype HTML>

<html>
	<head>
		<title>Mon CV</title>
		<meta charset="utf-8" />
		
        <link rel="stylesheet" href="<c:url value='/resources/css/normalize.css' />" type="text/css" />
		<link rel="stylesheet" href="<c:url value='/resources/css/structure.css' />" type="text/css" />
		<link rel="stylesheet" href="<c:url value='/resources/css/module.css' />" type="text/css" />
		
	</head>
	<body>
		<div class="wrapper">
			
			<form method="post" action="connexion.html">
				<fieldset>
					<label>Login</label>
					<input type="text" value="" />
					
					<label>Nom</label>
					<input type="text" value="" />
					
					<label>Prenom</label>
					<input type="text" value="" />
					
					<label>Password</label>
					<input type="password" value="" />
					
				</fieldset>
				<a href="/accueil">retour</a>
				<input type="submit" value="inscription">
			</form>
			
		</div>
	</body>
</html>