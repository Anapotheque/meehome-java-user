<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="POST" cssClass="formulaire form-horizontal" commandName="user">
	
	<div class="panel panel-default">
		
		<div class="panel-heading">
			<h3 class="panel-title">Accueil</h3>
		</div>
		<div class="panel-body">
		
			<p><i>Veuillez renseigner l'ensemble de ces champs afin de valider votre inscription</i></p>
		
			<form:errors path="*" cssClass="ui-state-error ui-corner-all error" element="div" />
			
			<div class="form-group">
				<label for="emailUser" class="col-lg-2 control-label">Email</label>
				<div class="col-lg-10">
					<form:input path="email" placeholder="email" id="emailUser" class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="nom" class="col-lg-2 control-label">Nom</label>
				<div class="col-lg-10">
					<form:input path="nom" placeholder="nom" id="nom" class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="prenom" class="col-lg-2 control-label">Prenom</label>
				<div class="col-lg-10">
					<form:input path="prenom" placeholder="prenom" id="prenom" class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="passwordUser" class="col-lg-2 control-label">Password</label>
				<div class="col-lg-10">
					<form:password path="password" placeholder="password" id="passwordUser" class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<a href="<c:url value='/accueil/' />" class="col-lg-2 control-label">retour</a>
				<div class="col-lg-10">
					<button id="buttonInscription" class="btn btn-default">valider</button>
				</div>
			</div>
		
		</div>
	</div>
	
</form:form>