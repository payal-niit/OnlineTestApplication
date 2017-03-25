<%@ include file="header.jsp" %>
<div ng-app="myApp" ng-controller="myCont" class="container" style="border: 2px solid #0800ff;">
<form:form commandName="submitMultipleQuestions" action="submitTest">
<div class="row">
<h3>${testPaperTopic.testPaperSyllabusContent}</h3>
<div class="col-md-11 container" ng-repeat="m in mydata" style="border: 1px solid #0800ff;">
	
	<div class="row">
	<div class="col-md-10">
	
	<label class="form-control">{{$index + 1}}) {{m.question}}</label>
	</div></div>
	
	<div class="row">
	<div class="col-md-10">
	<input type="radio" name="noOfAttempts[{{$index}}].attemptedAnswer" value="1">{{m.option1}}
	<input type="radio" name="noOfAttempts[{{$index}}].attemptedAnswer" value="2">{{m.option2}}
	<input type="radio" name="noOfAttempts[{{$index}}].attemptedAnswer" value="3">{{m.option3}}
	<input type="radio" name="noOfAttempts[{{$index}}].attemptedAnswer" value="4">{{m.option4}}
	<%-- <form:radiobutton path="noOfAttempts[0].attemptedAnswer" value="1" />{{m.option1}}
	<form:radiobutton path="noOfAttempts["+{{$index}}+"].attemptedAnswer" value="2" />{{m.option2}}
	<form:radiobutton path="noOfAttempts["+{{$index}}+"].attemptedAnswer" value="3" />{{m.option3}}
	<form:radiobutton path="noOfAttempts["+{{$index}}+"].attemptedAnswer" value="4" />{{m.option4}} --%>
	</div>	
	</div>
	
	<div class="row">
	<div class="col-md-10">
	<input type="text" name="noOfAttempts[{{$index}}].correctAnswer" value="{{m.answer}}" />
	<input type="text" name="noOfAttempts[{{$index}}].testPaperId" value="{{m.testPaperId}}" />
	<input type="text" name="noOfAttempts[{{$index}}].question" value="{{m.question}}" />
	
	
	<%-- <form:input type="text" path="correctAnswer" value="{{m.answer}}" />
	<form:input type="text" path="testPaperId" value="{{m.testPaperId}}" />
	<form:input type="text" path="question" value="{{m.question}}" /> --%>
	</div>	
	</div>
	<input type="submit" value="Submit Test">
</div>
</div>
</form:form>
</div>

<script>
var app=angular.module('myApp',[]);

app.controller('myCont',function($scope) {
	
	$scope.mydata=${questionSet};
});
</script>