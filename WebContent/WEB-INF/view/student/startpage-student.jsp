<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 24-Dec-19
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/buttons.css" />
<p>This is a the following list of petitions</p>
<div class="main">
    <div class="sub-main">
        <button class="button-one" onclick=redirect("new-petition")> New petition</button>
    </div>
    <div class="sub-main">
        <button class="button-two" onclick=redirect("list")><span>Student List</span></button>
    </div>
    <div class="sub-main">
        <button class="button-three" onclick=window.location.href="..">Blank Button</button>
    </div>
</div>

<script type="text/javascript">
    function redirect(link) {
        window.location.href =link;
    }

</script>

