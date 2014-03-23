<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="POST" commandName="user">
	
	<style>section {width:400px;float:none;margin:auto;margin-top:100px;}</style>
	
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">Validation</h3>
		</div>
		<div class="panel-body">
			<p>Le formulaire a été validé avec success</p>
			<a href="<c:url value='/accueil/' />">retour</a>
		</div>
	</div>

</form:form>