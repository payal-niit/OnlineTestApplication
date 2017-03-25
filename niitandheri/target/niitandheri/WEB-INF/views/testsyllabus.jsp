<%@ include file="header.jsp" %>
<form:form commandName="testPaperSyllabus" action="addtestsyllabus">
	<div class="col-md-6 text-center"
		style="padding: 15px; padding-top: 0px; margin-left: 200px; text-align: center; border: 5px solid grey; border-top-right-radius: 20px; border-bottom-color: #0800ff; border-right-color: #0800ff;"
		align="center">
		<h2 style="font-family: Algerian; color: #0800ff;">Create Syllabus Topic</h2>
		<div class="row text-center" align="center">

			<div class="col-md-6 col-sm-6 col-xs-12 text-center">
				<form:label path="testPaperSyllabusContent">Test Syllabus Topic</form:label>
				<form:input path="testPaperSyllabusContent"
					placeholder="Test Syllabus Topic" class="form-control" />
			</div>
			
			<div class="col-md-6 col-sm-6 col-xs-12 text-center">
				<form:label path="courseId">Course</form:label>
				<form:select items="${courseList}" path="courseId" itemValue="courseId"
					itemLabel="courseName" class="form-control" />
					
			</div>
			</div>
			<br>
			<input type="submit" value="Create Syllabus Topic" class="btn btn-primary">
		</div>
	


</form:form>