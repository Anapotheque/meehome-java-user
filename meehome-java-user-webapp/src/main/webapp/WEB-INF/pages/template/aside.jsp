<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

Menu
<hr/>
<c:choose>
	<c:when test="${empty not userAuthentificated.nom}">
		
		<script>$(function(){$("#accordion").accordion();});</script>
		<div id="accordion">
			<h3>Creation CV</h3>
			<div>
				<a href="#">Creer un nouveau CV</a>
				<a href="#">Modifier un CV</a>
			</div>
			<h3>Mon compte</h3>
			<div>
				<a href="#">modifier mon compte</a>
				<a href="#">déconnexion</a>
			</div>
			<h3>Divers</h3>
			<div>
				<a href="#">modifier mon compte</a>
				<a href="#">modifier mon compte</a>
			</div>
		</div>
		
	</c:when>
	<c:otherwise>
		Pas encode de compte ? 
		<a href="<c:url value='inscription' />" class="awesome">inscription</a>
	</c:otherwise>
</c:choose>