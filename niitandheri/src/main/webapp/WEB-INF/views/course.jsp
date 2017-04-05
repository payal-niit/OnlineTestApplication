<%@ include file="header.jsp"%>
<form:form commandName="course" action="addcourse">
	<div class="col-md-6 text-center"
		style="padding: 15px; padding-top: 0px; margin-left: 200px; text-align: center; border: 5px solid grey; border-top-right-radius: 20px; border-bottom-color: #0800ff; border-right-color: #0800ff;"
		align="center">
		<h2 class="new">Create
			Course</h2>
		<div class="row text-center" align="center">

			<div class="col-md-6 col-sm-6 col-xs-12 text-center">
				<form:label path="courseName">Course Topic</form:label>
				<form:input path="courseName"
					placeholder="Test Syllabus Topic" class="form-control" />
			</div>
			<div class="col-md-6 col-sm-6 col-xs-12 text-center">
			<br>
				<input type="submit" value="Create Course Topic"
					class="btn btn-primary">
			</div>
		</div>
	</div>
</form:form>