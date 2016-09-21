<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>Formulario Candidato</title>
	<base href="${pageContext.request.contextPath}/"></base>
	
	<link rel="stylesheet" href="resources/css/styles.css?v=1.0">
	
</head>
<body>
	
	<form  method="post">
		<input type="text" name="id" readonly="readonly"/>
		<input type="text" name="dni" placeholder="DNI"/>
		<input type="text" name="nombre" placeholder="NOMBRE"/>
		<input type="submit" value="Aceptar"/>
	</form>
	



	<!-- JavaScript -->

</body>
</html>