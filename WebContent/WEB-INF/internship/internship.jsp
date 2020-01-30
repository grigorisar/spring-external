<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header-footer.css">
<title>Application</title>
<body>
<div class="svg-container">
    <!-- I crated SVG with: https://codepen.io/anthonydugois/pen/mewdyZ -->
    <svg viewbox="0 0 1650 400" class="svg">
        <path id="curve" fill="#50c6d8" d="M 1650 300 Q 400 350 0 300 L 0 0 L 1650 0 L 1650 300 Z">
        </path>
    </svg>
</div>

<header>
    <h1>This is an internship request page</h1>
    <h3>Here you are, scroll down.</h3>
</header>

<main>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/form.css">
    <div class="square">
        <div class="form-style-6">
            <h1>Internship proposal</h1>
            <form>
                <input type="text" name="title" placeholder="Position Title" />
                <select name="company" id="company">
                    <c:forEach var="company" items="${companies}">
                    <optgroup label="${company.companyName}">
                            <c:forEach var="internship" items="${company.internships}">
                                <option value="${internship.name}">
                            </c:forEach>
                    </c:forEach>
                </select>
                <input type="number" name="salary" placeholder="Salary / Per Year">
                <textarea name="description" placeholder="Internship Description and Requirements"></textarea>
                <input type="text" name="comments" placeholder="Additional Comments">
                <input type="submit" value="Send" />
            </form>
        </div>
    </div>

</main>

<footer>
    <p>All rights included... Greg & Tanabe Co.</p>
    <small>🕷 Wish you luck, <a href="http://github.com/grigorisar">Gregory</a>.</small>
</footer>
</body>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/header.js"> /*DO NOT REMOVE THIS COMMENT #askjava*/</script>