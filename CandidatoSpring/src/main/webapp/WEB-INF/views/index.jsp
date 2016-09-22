<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html lang="es">
<head>
<meta charset="utf-8">
<title>Pagina de inicio</title>
<base href="${pageContext.request.contextPath}/"></base>

<link rel="stylesheet" href="resources/css/styles.css?v=1.0">

</head>
<body>

	<ol>
		<li><a href="candidato/nuevo">Nuevo Candidato</a></li>
	</ol>

	<form action="buscar" method="get">
		<input type="text" placeholder="Inserta un DNI" /> <br>
		<br> <input type="submit" value="Buscar" /> <br>
		<br>
	</form>	

	<c:forEach items="${candidatos}" var="can">
		<a href="candidato/detalle/${can.id}"> <c:out
 				value="${can.dni}" /> <i>$<c:out value="${can.nombre}" /></i>
		</a>
		<a href="candidato/eliminar/${can.id}"> [X] </a>

		<br>
		<br>
	</c:forEach>

	
	<!-- JavaScript -->

</body>
</html>