<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 23-Dec-19
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Petition Manager</title>
    <!-- reference our style sheet -->
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Service List</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <h1> Select a service </h1>
        <form method="POST" name="serviceIndex" action="/more">
            <!--  add our html table here -->
            <table>
                <tr>
                    <th>Service Name    </th>
                    <th>|Service Description </th>
                </tr>
                <!-- loop over and print our petitions -->
                <c:forEach var="tempService" items="${services}">
                    <!-- insert checkbox here -->
                    <tr>
                        <td>${tempService.title}      </td>
                        <td>|${tempService.description}</td>
                        <td><button type="button" value=${tempService.id} onclick="setTitle(${tempService.title})">Select</button></td>
                    </tr>
                </c:forEach>
            </table>
            <input type="hidden" id="selectService" name="selectService" value="">
        </form>

        <!-- call /manager/service/new mapping -->
        <form method="POST" action="/manager/service/index">
            <button type="button" value="" onclick="">+Add Service</button>
        </form>


        <script type="text/javascript">
            function setTitle(title) {
                alert(JSON.stringify(title));
                alert("hello world")
                document.getElementByName('selectService').value = title;
            }
        </script>
    </div>
</div>

</body>
</html>
