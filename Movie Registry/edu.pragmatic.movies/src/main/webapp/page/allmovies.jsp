<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Movie List</title>
    </head>
    <body>
     	<c:forEach items="${movies}" var="movie">
            <p>
				<a href="film?name=<c:out value="${movie.name}"/>"><c:out value="${movie.name}"/></a>                
            </p>
        </c:forEach>
    </body>
</html>