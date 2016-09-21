<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<title>Home</title>
</head>
	<body>
	<h1>
		Listado de Candidatos
	</h1>
		<ol>
			<li><a href="form">Nuevo Candidato</a></li>	
			<!-- <li><a href="buscar">Buscar</a></li> -->		
		</ol>
 		<form action="buscar" method="get">
 			 
 			<input type="text"  placeholder="Buscar por id"/> 
 			 
			
 			<input type="submit" value="Buscar"> 
 		</form> 
	
	</body>
</html>
