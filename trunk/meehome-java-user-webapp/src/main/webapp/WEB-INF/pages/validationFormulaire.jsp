<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="POST" commandName="user">
	
	<style>section {width:400px;float:none;margin:auto;margin-top:100px;}</style>
	
	<div class="panel ${validation.type}">
		<div class="panel-heading">
			<h3 class="panel-title">${validation.header}</h3>
		</div>
		<div class="panel-body">
			<p>${validation.message}</p>
			<a href="<c:url value='/accueil/' />">retour</a>
		</div>
	</div>

</form:form>