<%@ include file="header.jsp" %>
<form:form commandName="student" action="addStudent" class="form">
<div class="col-md-6 text-center" style="padding:15px;padding-top:0px;margin-left: 200px; text-align:center;border: 5px solid grey;border-top-right-radius:20px;border-bottom-color: #0800ff;border-right-color: #0800ff;" align="center">
<h2 style="font-family:Algerian;color:#0800ff;">REGISTER</h2>
<div class="row text-center" align="center">

<div class="col-md-6 col-sm-6 col-xs-12 text-center">
<form:label path="studentId">Student ID</form:label>
<form:input path="studentId" placeholder="Enter your Student ID" class="form-control"/>
</div>
<div class="col-md-6 col-sm-6 col-xs-12 text-center">
<form:label path="password">Password</form:label>
<form:input type="password" path="password" placeholder="Password" class="form-control"/>
</div>
</div>

<div class="row text-center" align="center">
<div class="col-md-6 col-sm-6 col-xs-12 text-center">
<form:label path="fname">First Name</form:label>
<form:input path="fname" placeholder="First Name" class="form-control"/>
</div>
<div class="col-md-6 col-sm-6 col-xs-12 text-center">
<form:label path="lname">Last Name</form:label>
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
<input type="submit" value="Register" class="btn btn-primary">
</div>
</form:form>