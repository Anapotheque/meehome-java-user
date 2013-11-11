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
		<meta charset="utf-8" />
		<link rel="stylesheet" href="<c:url value='/resources/css/normalize.css' />" type="text/css" />
		<link rel="stylesheet" href="<c:url value='/resources/css/structure.css' />" type="text/css" />
		<link rel="stylesheet" href="<c:url value='/resources/css/formulaire.css' />" type="text/css" />
		
		<!-- TEST -->
		<link href="<c:url value='/resources/css/smoothness/jquery-ui-1.10.3.custom.css'/>" rel="stylesheet">
		<script src="<c:url value='/resources/js/jquery-1.9.1.js'/>"></script>
		<script src="<c:url value='/resources/js/jquery-ui-1.10.3.custom.js'/>"></script>
    </head>
    <body>
    	<div class="wrapper">
   	    	<div class="ui-state-error ui-corner-all" style="padding: 20px;text-align:center;">
            	<p>VOTRE PAGE N'EXISTE PAS</p>
            	<br/>
            	<a href="<c:url value='/accueil/' />">Retour à la page d'accueil</a>
            </div>
        </div>
    </body>
</html>