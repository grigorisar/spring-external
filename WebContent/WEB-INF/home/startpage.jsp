<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/buttons.css"/>
    <h1 style="align-content: center">Spring MVC demo project!</h1>
    <h3><a href="<c:url value="/showForm"></c:url>">Show Form</a></h3>
    <h3><a href="<c:url value="/student/"></c:url>">Show Student Menu</a></h3>
    <h3><a href="<c:url value="/manager/"></c:url>">Show Manager Menu</a></h3>
    <h3><a href="<c:url value="/example"></c:url>">Show CSS Example</a></h3>
</body>
</html>