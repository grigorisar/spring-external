<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 26-Dec-19
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--TODO THIS--%>

<html>
<head>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
    <%--    load the jquery library BEFORE running the actual script--%>
    <title>Create Student</title>
</head>


<body>


<div align="center">

    <br>

    <div id="top">

    </div>

    <br>

    <form  id="user_details" name="user_creation" method="post" action="/Springmvc1_war_exploded/user/create_user_process">

            <div class="form-group">
                <label for="username">Username</label> <br>
                <input required type="text" name="username" id="username" placeholder="Username" maxlength="50"><br>
            </div>

            <div class="form-group">
                <label for="password">Password</label><br>
                <input required type="password" name="password" id="password" placeholder="Password" maxlength="100"><br>

            </div>

            <div class="form-group">
                <label for="firstname">First Name</label><br>
                <input required type="text" name="firstname" id="firstname" placeholder="First Name" maxlength="45"><br>

            </div>

            <div class="form-group">
                <label for="lastname">Last Name</label><br>
                <input required type="text" name="lastname" id="lastname" placeholder="Last Name" maxlength="45"><br>

            </div>

            <div class="form-group" id="PositionDiv">
                <label for="position">Position</label><br>
                <input required type="text" name="position" id="position" placeholder="Position" maxlength="30"><br>

            </div>

            <div hidden class="form-group" id="YearField">
                <label for="year">Year</label><br>
                <input step="1" type="text" pattern="\d+" name="year" id="year" placeholder="Year" maxlength="5"><br>

            </div>

            <div hidden class="form-group" id="Department">
                <label for="dept">Department</label><br>
                <input type="text" name="dept" id="dept" placeholder="Department Name" maxlength="45"><br>

            </div>

            <div hidden class="form-group" id="FailedClasses">
                <label for="failed">Failed Classes</label><br>
                <input step="1" type="number" pattern="\d+" name="failed" id="failed" placeholder="Failed Classes" maxlength="2"><br>
                <%--            input type = "number" is an HTML5 feature compatibility is not guaranteed --%>

            </div>

            <div class="form-group">
                <input type="submit" class="button" value = "Submit" id="somebutton">

            </div>

            <div class="form-group">
                <select name="select" form="user_details" id="select">
                    <option value="Staff">Staff</option>
                    <option value="Student">Student</option>

                </select>
            </div>

        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>

    </form>

</div>

<%--Put the scripts on the bottom so the page loads first--%>

<script type="text/javascript"> //script to show the extra fields  only when the student is selected

window.onload = function() {
    console.log("welcome")

    $("#select").change(function() {
        if ($(this).val() == "Student") {
            $('#PositionDiv').hide();                            //hide field Position
            $('#position').removeAttr('required');
            $('#position').removeAttr('data-error');

            $('#YearField').show();                             //show field Year
            $('#year').attr('required', '');
            $('#year').attr('data-error', 'This field is required.');

            $('#Department').show();                             //show field Department
            $('#dept').attr('required', '');
            $('#dept').attr('data-error', 'This field is required.');

            $('#FailedClasses').show();                             //show field Failed Classes
            $('#failed').attr('required', '');
            $('#failed').attr('data-error', 'This field is required.');
        } else {
            $('#PositionDiv').show();                             //show field Position
            $('#position').attr('required', '');
            $('#position').attr('data-error', 'This field is required.');

            $('#YearField').hide();
            $('#year').removeAttr('required');
            $('#year').removeAttr('data-error');

            $('#Department').hide();
            $('#dept').removeAttr('required');
            $('#dept').removeAttr('data-error');

            $('#FailedClasses').hide();
            $('#failed').removeAttr('required');
            $('#failed').removeAttr('data-error');
        }
    });
    $("#seeAnotherField").trigger("change");
};

/* attach a submit handler to the form */
$("#user_details").submit(function(event) {

    /* stop form from submitting normally */
    event.preventDefault();

    /* get some values from elements on the page: */
    var $form = $(this),
        url = $form.attr('action');

    console.log("posting happens");

    // var datastring = $("#user_details").serialize();
    $.ajax({
        type: "POST",
        url: url,
        data : $('#user_details').serialize(),
        // dataType: "plain/text",
        success: function(data) {                                   //on success of ajax
            //var obj = jQuery.parseJSON(data); if the dataType is not specified as json uncomment this
            $("#top").empty().append(data)
        },
        error: function(xhr, request, error) {                                 //on error
            //  = eval("(" + xhr.responseText + ")");       //eval is evil dont use it
            // alert(err.Message);
            var err = xhr.responseText
            alert(err)
            $('#top').empty().append("Error Encountered with request ")

        },
        complete: function () {                             //on completion
            console.log("posting finishes")
        }
    });



});
</script>

</body>
</html>
