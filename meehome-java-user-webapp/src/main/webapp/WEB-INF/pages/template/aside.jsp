<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="panel panel-default">
		
	<div class="panel-heading">
		<h3 class="panel-title">Menu</h3>
	</div>
	
	<div class="panel-body">
   
		<c:choose>
			<c:when test="${not empty userAuthentificated.nom}">
			
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="<c:url value='/accueil/' />">Accueil</a></li>
					<li><a href="<c:url value='/accueil/updateUser' />">Modifier mon compte</a></li>
					<li><a href="<c:url value='/deconnexion' />">Déconnexion</a></li>
				</ul>
				
			</c:when>
			<c:otherwise>
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="<c:url value='/accueil/' />">Accueil</a></li>
					<li><a href="<c:url value='/accueil/authentification' />" class="awesome">Authentification</a></li>
					<li><a href="<c:url value='/accueil/inscription' />" class="awesome">Inscription</a></li>
				</ul>
			</c:otherwise>
		</c:choose>

	</div>
</div>