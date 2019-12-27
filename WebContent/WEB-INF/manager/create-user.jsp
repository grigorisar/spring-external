<%--
  Created by IntelliJ IDEA.
  User: owl
  Date: 21/12/2019
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<%--    load the jquery library BEFORE running the actual script--%>

    <title>The Original Jupiter Experience</title>



</head>
<body>
<form id="user_details" name="user_creation" method="post" action="/user/create">

    <div class="form-group">
        <label for="username">Username</label>>
        <input type="text" name="username" id="username" placeholder="Username" ><br>
    </div>
    <br>
    <div class="form-group">
        <label for="password">Password</label>>
        <input type="password" name="password" id="password" placeholder="Password" ><br>
    </div>
    <br>
    <div class="form-group">
        <input type="submit" value = "Submit">
    </div>

</form>


</body>
</html>
