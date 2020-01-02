<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<link type="text/css" rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/buttons.css"/>
<h1>Select a Service</h1>
<%-- NAVIGATE TO PAGE--%>
<h2><a href="<c:url value="/manager/users/student"></c:url>">Student Manager</a></h2>
<h2><a href="<c:url value="/manager/users/staff"></c:url>">Staff Manager</a></h2>
<h2><a href="<c:url value="/manager/users/user"></c:url>">User Index And Enabling</a></h2>
</body>
</html>