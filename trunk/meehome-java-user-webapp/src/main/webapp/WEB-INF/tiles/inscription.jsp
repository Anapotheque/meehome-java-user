<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<aside>
	ASIDE
</aside>

<section>			
	<form:form modelAttribute="user" method="POST" action="">
	
		Formulaire d'insciption
		<hr/>
		<i>Veuillez renseigner l'ensemble de ses champs afin de valider votre inscription</i><br/><br/>
	
		<form:errors path="*"  />
	
		<label>Login</label>
		<form:input path="login" placeholder="login" />
		<br/><br/>
		
		<label>Nom</label>
		<form:input path="nom" placeholder="Nom" />
		<br/><br/>
		
		<label>Prenom</label>
		<form:input path="prenom" placeholder="Prenom" />
		<br/><br/>
		
		<label>Password</label>
		<form:password path="password" placeholder="Password" />
		<br/><br/>
		
		<a href="<c:url value='/accueil' />">retour</a>
		<button id="buttonInscription">inscription</button>
		
	</form:form>
</section>