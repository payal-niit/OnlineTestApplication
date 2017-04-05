<%@ include file="header.jsp" %>
<form:form id="regForm" method="post" commandName="student" action="addStudent" class="form-horizontal">
<div class="col-md-6 text-center" style="padding:15px;padding-top:0px;margin-left: 200px; text-align:center;border: 5px solid grey;border-top-right-radius:20px;border-bottom-color: #0800ff;border-right-color: #0800ff;" align="center">
<h2 style="font-family:Algerian;color:#0800ff;">REGISTER</h2>
<div class="row text-center" align="center">

<div class="col-md-6 col-sm-6 col-xs-12 text-center">
<div class="form-group">
<form:label path="studentId" class="control-label">Student ID</form:label>
<label><form:errors class="errormsg" path="studentId"></form:errors></label>
<form:input path="studentId" placeholder="Enter your Student ID" class="form-control"/>
</div>
</div>
<div class="col-md-6 col-sm-6 col-xs-12 text-center">
<div class="form-group">
<form:label path="password" class="control-label">Password</form:label>
<label><form:errors class="errormsg" path="password"></form:errors></label>
<form:input type="password" path="password" placeholder="Password" class="form-control"/>
</div>
</div>
</div>

<div class="row text-center" align="center">
<div class="col-md-6 col-sm-6 col-xs-12 text-center">
<form:label path="fname">First Name</form:label>
<label><form:errors class="errormsg" path="fname"></form:errors></label>
<form:input path="fname" placeholder="First Name" class="form-control"/>
</div>
<div class="col-md-6 col-sm-6 col-xs-12 text-center">
<form:label path="lname">Last Name</form:label>
<label><form:errors class="errormsg" path="lname"></form:errors></label>
<form:input path="lname" placeholder="Last Name" class="form-control"/>
</div>
</div>

<div class="row text-center" align="center">
<div class="col-md-3 col-sm-6 col-xs-12 text-center">

</div>
<div class="col-md-6 col-sm-6 col-xs-12 text-center">
<form:label path="dob">Date of Birth</form:label>
<form:input type="date" path="dob" placeholder="First Name" class="form-control text-center"/>
</div>
<div class="col-md-3 col-sm-6 col-xs-12 text-center">
</div>
</div>
<br>
<input type="submit" id="createuser" value="Register" class="btn btn-primary">
</div>
</form:form>
<script>
$('#createuser').on('click', function() {
	
	 var msg="${msg}"; 
	 console.log(msg)
	 alert(msg);
});
</script>
<script>
$(document).ready(function() {
    $('#regForm').formValidation({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            studentId: {
                validators: {
                    notEmpty: {
                        message: 'The username is required'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: 'The username must be more than 6 and less than 30 characters long'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: 'The username can only consist of alphabetical, number, dot and underscore'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'The password is required'
                    }
                }
            }
        }
    });
});
</script>