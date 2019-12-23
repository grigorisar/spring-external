<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 23-Dec-19
  Time: 1:32 PM
  To change this template use File | Settings | File Templates.
--%>
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
<h1>Select a Service</h1>
<%-- NAVIGATE TO PAGE--%>
<a href="<c:url value="/manager/role"></c:url>">Role Manager</a>
<br/>
<a href="<c:url value="/manager/user"></c:url>">User Manager</a>
<br/>
<a href="<c:url value="/manager/service"></c:url>">Service Manager and update user permisions on them</a>
<br/>
</body>
</html>