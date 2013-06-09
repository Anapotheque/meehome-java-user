<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="POST" cssClass="formulaire" commandName="user">
	
	Formulaire d'insciption
	<hr/>
	<i>Votre inscription s'est déroulé avec success</i><br/><br/>

	Login : ${user.login}
	<br/><br/>
	
	Nom : ${user.nom}
	<br/><br/>
	
	Prenom : ${user.prenom}
	<br/><br/>
	
	<a href="<c:url value='/accueil' />">retour</a>
	
</form:form>