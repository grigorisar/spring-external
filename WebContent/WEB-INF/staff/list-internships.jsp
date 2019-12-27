<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 27-Dec-19
  Time: 5:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>List Customers</title>
    <!-- reference our style sheet -->
</head>
<body>
<link type="text/css" rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/buttons.css"/>
<div id="wrapper">
    <div id="header">
        <h1>Internship Data Manager</h1>
    </div>
</div>

<div id="container">
    <div id="content">
        <!--  add our html table here -->
        <table>
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Salary</th>
                <th>Status</th>
            </tr>
            <!-- loop over and print interships -->
            <c:forEach var="tempInternship" items="${internships}">
                <tr>
                    <td>${tempInternship.title}</td>
                    <td>${tempInternship.description}</td>
                    <td>${tempInternship.salary}</td>
                    <td>${tempInternship.status}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<div class="main">
    <div class="sub-main">
        <button class="button-one">New Internship</button>
    </div>
    <div class="sub-main">
        <button class="button-two"><span>Update Internship</span></button>
    </div>
    <div class="sub-main">
        <button class="button-three">Delete Internship</button>
    </div>
</div>

<script type="text/javascript">
    function highlight(e) {
        if (selected[0]) selected[0].className = '';
        e.target.parentNode.className = 'selected';
        // var v= $(this).find(".selected td:first").html()
        var v = $('.selected td').eq(1).text();             //get selected table row'w second column (starts from zero)
        console.log(v);
    }
    var table = document.getElementById('list'),
        selected = table.getElementsByClassName('selected');
    table.onclick = highlight;
</script>
</body>
</html>
