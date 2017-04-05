<%@ include file="header.jsp" %>
<div class="container">
<h3>Dear,  ${name}</h3>
<h4 class="text-center">Your Test Result</h4>
<table class="table table-bordered table-striped table-hover">
<tr>
<td>Total Number of Questions</td>
<td>Total Number of Questions Correct</td>
<td>Total Number of Questions Wrong</td>
<td>Total Marks Obtained</td>
<td>Percentage Obtained</td>
</tr>

<tr>
<th>${mydata.totalNoOfQuestions}</th>
<th>${mydata.totalNoOfCorrect}</th>
<th>${mydata.totalNoOfWrong}</th>
<th>${mydata.marksObtained}/${mydata.totalMarks}</th>
<th>${mydata.percentageObtained}</th>
</tr>

</table>
<ol>
<c:forEach items="${questionsAttemptedJSTL}" var="m" varStatus="status">
<li><pre><span style="text-decoration: underline;">Question ${status.index+1}</span>
<c:out value="${m.question}" escapeXml="true" />
<ol><li style="font-weight: bold;"><c:out value="${m.testPaper.option1}" escapeXml="true" /></li>
<li style="font-weight: bold;"><c:out value="${m.testPaper.option2}" escapeXml="true" /></li>
<li style="font-weight: bold;"><c:out value="${m.testPaper.option3}" escapeXml="true" /></li>
<li style="font-weight: bold;"><c:out value="${m.testPaper.option4}" escapeXml="true" /></li></ol>
<ul type="square"><li style="font-weight: bold;">Your Answer:${m.attemptedAnswer} <c:if test="${m.attemptedAnswer == m.correctAnswer}"><span class="glyphicon glyphicon-ok" style="color:green;"></span></c:if><c:if test="${m.attemptedAnswer != m.correctAnswer}"><span class="glyphicon glyphicon-remove" style="color:red;"></span></c:if></li><li style="font-weight: bold;">Correct Answer: <c:out value="${m.correctAnswer}" escapeXml="true" /></li>
</ul></pre>
</li>
</c:forEach>
</ol>
</div>

<%-- <div class="container" ng-app="myApp" ng-controller="myCont">
<h3>Dear,  ${name}</h3>
<h4 class="text-center">Your Test Result</h4>
<table class="table table-bordered table-striped table-hover">
<tr>
<td>Total Number of Questions</td>
<td>Total Number of Questions Correct</td>
<td>Total Number of Questions Wrong</td>
<td>Total Marks Obtained</td>
<td>Percentage Obtained</td>


</tr>
<tr>
<th>{{data.totalNoOfQuestions}}</th>
<th>{{data.totalNoOfCorrect}}</th>
<th>{{data.totalNoOfWrong}}</th>
<th>{{data.marksObtained}}/{{data.totalMarks}}</th>
<th>{{data.percentageObtained}}%</th>
</tr>
</table>
<hr>
<ol>

<li ng-repeat="m in mydata"><pre><span style="text-decoration: underline;">Question {{$index+1}}</span>
{{m.question}}
<ol><li style="font-weight: bold;">{{m.testPaper.option1}}</li>
<li style="font-weight: bold;">{{m.testPaper.option2}}</li>
<li style="font-weight: bold;">{{m.testPaper.option3}}</li>
<li style="font-weight: bold;">{{m.testPaper.option4}}</li></ol>
<ul type="square"><li style="font-weight: bold;">Your Answer:{{m.attemptedAnswer}} <span ng-if="m.attemptedAnswer == m.correctAnswer" class="glyphicon glyphicon-ok"></span><span ng-if="m.attemptedAnswer != m.correctAnswer" class="glyphicon glyphicon-remove"></span></li><li style="font-weight: bold;">Correct Answer:{{m.correctAnswer}}</li>
</ul></pre>
</li>




</ol>
</div>
 --%>
<script>

var app=angular.module('myApp',[]);

app.controller('myCont',function($scope,$window) {
	
	$scope.mydata=${questionsAttempted};
	$scope.data=${data};
});
</script>
