<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inscription</title>
</head>
<body>
<center>
<h1>Bienvenue dans le service de création d'utilisateur !</h1>
<br>
<br>
<br>
<br>
<br>

<form action="MaServletC" method="post">
	prénom:<input type="text" name= "prenom"/>
	Nom:<input type="text" name="nom"/>	
	Login:<input type="text" name="login"/>
	Mot de Passe: <input type="password" name="pwd"/>
	<input type="submit" value="valider"/>
</form>
</center>

</body>
</html>