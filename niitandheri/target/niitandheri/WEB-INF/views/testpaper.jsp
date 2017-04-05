<%@ include file="header.jsp" %>
<form:form commandName="testPaper" action="addtestpaper" enctype="multipart/form-data">
	<div class="col-md-10 text-center"
		style="padding: 15px; padding-top: 0px; margin-left: 100px; text-align: center; border: 5px solid grey; border-top-right-radius: 20px; border-bottom-color: #0800ff; border-right-color: #0800ff;"
		align="center">
		<h2 style="font-family: Algerian; color: #0800ff;">Create Questions</h2>
		<div class="row text-center" align="center">

			<div class="col-md-6 col-sm-6 col-xs-12 text-center">
				<form:label path="question">Question</form:label>
				<form:textarea rows="5" path="question"
					placeholder="Add a Question" class="form-control" />
			</div>
			<div class="col-md-3 col-sm-3 col-xs-12 text-center">
				<form:label path="courseId">Test Syllabus Topic</form:label>
				<form:select items="${courseList}" path="courseId" itemValue="courseId"
					itemLabel="courseName" class="form-control" />					
			</div>
			
			<div class="col-md-3 col-sm-3 col-xs-12 text-center">
			<form:label path="testPaperSyllabusId">Test Syllabus Topic</form:label>
			<form:select class="form-control" path="testPaperSyllabusId">
					<c:forEach items="${courseList}" var="course">
					<form:option style ="margin-left:20px;" value="${course.courseName}" disabled="true"></form:option>
					<c:forEach items="${course.testPaperSyllabus}" var="testPaperSyllabus">
					<form:option style="font-weight:bold;" value="${testPaperSyllabus.testPaperSyllabusId}">${testPaperSyllabus.testPaperSyllabusContent}</form:option>
					</c:forEach>
					</c:forEach>
   					<%-- <form:option value="NONE" label="--- Select ---"/>
   					<form:options items="${categoryList}" itemValue="categoryName"
			itemLabel="categoryName" />
   					<form:options items="${subCategoryList}" itemValue="subCategoryName"
			itemLabel="subCategoryName" /> --%>
				</form:select>
				</div>
			</div>
			
			<div class="row text-center" align="center">

			<div class="col-md-12 col-sm-12 col-xs-12 text-center">
			<form:label path="option1">Option 1</form:label>
				<form:textarea rows="2" path="option1"
					placeholder="Option 1" class="form-control" />
			
			</div>
			</div>
			
			
			<div class="row text-center" align="center">

			<div class="col-md-12 col-sm-12 col-xs-12 text-center">
			<form:label path="option2">Option 2</form:label>
				<form:textarea rows="2" path="option2"
					placeholder="Option 2" class="form-control" />
			
			</div>
			</div>
			
			
			<div class="row text-center" align="center">

			<div class="col-md-12 col-sm-12 col-xs-12 text-center">
			<form:label path="option3">Option 3</form:label>
				<form:textarea rows="2" path="option3"
					placeholder="Option 3" class="form-control" />
			
			</div>
			</div>
			
			
			<div class="row text-center" align="center">

			<div class="col-md-12 col-sm-12 col-xs-12 text-center">
			<form:label path="option4">Option 4</form:label>
				<form:textarea rows="2" path="option4"
					placeholder="Option 4" class="form-control" />
			
			</div>
			</div>
			
			<div class="row text-center" align="center">

			<div class="col-md-6 col-sm-12 col-xs-12 text-center">
			<form:label path="testPaperImage">Add Image if required</form:label>
				<form:input type="file" rows="2" path="testPaperImage"
					class="form-control" />
			
			</div>
			</div>
			
			<div class="row text-center" align="center">

			<div class="col-md-6 col-sm-6 col-xs-12 text-center">
				<form:label path="answer">Correct Answer</form:label>
				<form:select path="answer"  class="form-control">
				<form:option value="1">1</form:option>
				<form:option value="2">2</form:option>
				<form:option value="3">3</form:option>
				<form:option value="4">4</form:option>
				
				</form:select>
			</div>
			<div class="col-md-2 col-sm-3 col-xs-12 text-center">
			<form:label path="marks">Marks</form:label>
				<form:input rows="2" path="marks"
					placeholder="Marks" class="form-control" />
			</div>
			<div class="col-md-4 col-sm-3 col-xs-12 text-center">
			<br>
				<input type="Submit" value="Create Question" class="btn btn-primary">				
			</div>
			</div>
			
			</div>
			</form:form>