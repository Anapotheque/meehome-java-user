<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
			
			<form:form modelAttribute="user" method="POST" action="">
			
				<form:errors path="*"  />
			
				<fieldset>
				
					<label>Login</label>
					<form:input path="login" />
					
					
					<label>Password</label>
					<form:password path="password" />
					
				</fieldset>
				<input type="submit" value="connexion">
			
			</form:form>
			
		</div>
	</body>
</html>