<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
    <head>
        <title>Page non trouvée</title>
        <link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.0.0/css/bootstrap-theme.css' />" type="text/css" />
		<link rel="stylesheet" href="<c:url value='/resources/bootstrap-3.0.0/css/bootstrap.css' />" type="text/css" />
		<link rel="stylesheet" href="<c:url value='/resources/css/meehome-java-user.css' />" />
		
    </head>
    <body>
    	
    	<section>
	    	<style>section {width:400px;float:none;margin:auto;margin-top:100px;}</style>
		
			<div class="panel panel-danger">
				<div class="panel-heading">
					<h3 class="panel-title">Erreur : page non trouvée</h3>
				</div>
				<div class="panel-body">
					<p>Votre page n'existe pas</p>
					<a href="<c:url value='/accueil/' />">Retour à la page d'accueil</a>
				</div>
			</div>
		</section>
    
    </body>
</html>