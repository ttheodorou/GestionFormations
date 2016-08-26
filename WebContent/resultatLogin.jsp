<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.objis.gestionformations.domaine.User"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultat Identification</title>
</head>
<body>
	<%
		User u = (User) session.getAttribute("utilisateur");
	%>
	<ul>
		<li>Login : <%=u.getIdentifiant()%>
		<li>Mot de passe : <%=u.getMotDePsse()%>
	</ul>



</body>
</html>