<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Update</title>
</head>
<body>
    <h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
    <p><strong>Update Here | <a href="/City2/read">Click for Read</a></strong></p>
        <form action="/City2/update" method="post">
            <pre>
            <c:forEach var="city" items="${listCity}">

                Id:        <input type="text" name="dispId" value="${city.id}" disabled="disabled"/>
                        <input type="hidden" name="id" value="${city.id}"/>
                Name:      <input type="text" name="name" value="${city.name}" />
                        
                Email:     <input type="text" name="land" value="${city.land}" />
                        
              
                        
                    <input type="submit" value="Update" />
            </c:forEach>
            </pre>
            </form>

</body>
</html>