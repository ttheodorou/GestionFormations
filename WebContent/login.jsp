<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>S'identifier</title>
</head>
<body>
<center>
<br>

<h1>Merci de vous connecter !</h1>

<br>
<br>
<br>
<br>

<form action="MaServlet" method="post">
	Login:<input type="text" name="login"/>
	Mot de Passe: <input type="password" name="pwd"/>
	<input type="submit" value="valider"/>
</form>
</center>
</body>
</html>