<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	int idInscripcion = (Integer) request.getAttribute("idInscripcion");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscripci�n realizada</title>
</head>
<body>

	<h2>�Felicitaciones!</h2>
	<hr>
	<br>
	<p>Su c�digo de inscripci�n es: <%=idInscripcion%></p>
	<br>

</body>
</html>