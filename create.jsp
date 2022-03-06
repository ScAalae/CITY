<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Create</title>
</head>
<body>
    <h2>Neue Stadt</h2>
<form action="create" method="post">
    <pre>
    <strong>Create Here | <a href="./read">zur Liste zurück</a></strong>
        
    Name: <input type="text" name="name" />
    
    Land: <input type="text" name="land" />
    
    

    <input type="submit" value="Create" />
</pre>
</form>
</body>
</html>