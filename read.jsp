<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Read</title>
</head>
<body>

    <h2>Liste</h2>

    <p><strong>Student List is Here | <a href="/City2/create">Click for Create</a></strong></p>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Land</th>
            
            <th>Action</th>
        </tr>
        <c:forEach var="city" items="${listCity}">
            <tr>
                <td>${city.id}</td>
                <td>${city.name}</td>
                <td>${city.land}</td>
                
                <td><a href="/City2/update/<c:out value='${city.id}'/>">Update</a> | <a
                    href="/City2/delete/<c:out value='${city.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
