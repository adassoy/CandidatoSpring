<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>Pagina de inicio</title>
	<base href="${pageContext.request.contextPath}/"></base>
	
	<link rel="stylesheet" href="resources/css/styles.css?v=1.0">
	
</head>
<body>

		<ol>
			<li><a href="form">Nuevo Candidato</a></li>	
		</ol>
	
	<form action="buscar" method="get">
		<input type="text" placeholder="Inserta un DNI"/>
		<input type="submit" value="Buscar"/>
	</form>
	
	<c:forEach items="${candidatos}" var="can">			    	
		<c:out value="${can.id}"/>
		<c:out value="${can.dni}"/>
		<c:out value="${can.nombre}"/>      	      
		<br><br>
	</c:forEach>


	<!-- JavaScript -->

</body>
</html>
