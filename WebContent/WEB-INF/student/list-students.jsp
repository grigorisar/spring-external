<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>List Customers</title>
    <!-- reference our style sheet -->
</head>
<body>

<link type="text/css" rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/buttons.css"/>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src=" https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>

<div id="wrapper">
    <div id="header">
        <h1>Student Data Manager</h1>
    </div>
</div>
<div id="container">
    <div id="content">
        <!--  add our html table here -->
        <table id="list" class="steelBlueCols" style="width:100%">
            <tr>
                <th>Username</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Department</th>
                <th>Year</th>
                <th>Failed Classes</th>
            </tr>
            <!-- loop over and print students -->
            <c:forEach var="tempStudent" items="${students}">
                <tr>
                    <td>${tempStudent.username}  </td>
                    <td>${tempStudent.firstName}  </td>
                    <td>${tempStudent.lastName}  </td>
                    <td>${tempStudent.dept}  </td>
                    <td>${tempStudent.year}  </td>
                    <td>${tempStudent.failed}  </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<div class="main">
    <div class="sub-main">
        <button class="button-one">New Student</button>
    </div>
    <div class="sub-main">
        <button class="button-two"><span>Update Student</span></button>
    </div>
    <div class="sub-main">
        <button class="button-three">Delete Student</button>
    </div>
</div>
<script type="text/javascript">
    function highlight(e) {
        if (selected[0]) selected[0].className = '';
        e.target.parentNode.className = 'selected';
        var v = $('.selected td').eq(1).text();             //get selected table row'w second column (starts from zero)
        console.log(v);
    }
    var table = document.getElementById('list'),
        selected = table.getElementsByClassName('selected');

    table.onclick = highlight;

</script>
</body>
</html>
