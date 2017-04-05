<%@ include file="header.jsp" %>
<div class="container" style="border: 2px solid #0800ff;">
<form:form id="form" commandName="submitMultipleQuestions" action="submitTest">
<div class="articles row">
<div class="col-md-10">
<h2 class="text-center" style="font-family: Algerian; color: #0800ff;">${testPaperTopic.testPaperSyllabusContent}</h2>
</div>
<div style="font-weight: bold;" class="col-md-2" id="ms_timer">Time</div>
<c:forEach items="${questionSet}" var="m" varStatus="status">
<div class="article col-md-12 container" style="border: 1px solid #0800ff;">
<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
	
	<pre><h4>Question ${status.index+1}</h4><form:label path="noOfAttempts[${status.index}].question"><c:out value="${m.question}" escapeXml="true"/></form:label>(${m.marks} Marks)</pre>
	</div>
	</div>
	
	<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
	<pre><form:radiobutton path="noOfAttempts[${status.index}].attemptedAnswer" value="1" /><c:out value="${m.option1}" escapeXml="true"></c:out></pre>
	
	</div>
	<div class="col-md-12 col-sm-12 col-xs-12">
	<pre><form:radiobutton path="noOfAttempts[${status.index}].attemptedAnswer" value="2" /><c:out value="${m.option2}" escapeXml="true"></c:out></pre>
	</div>
	<div class="col-md-12 col-sm-12 col-xs-12">	
	<pre><form:radiobutton path="noOfAttempts[${status.index}].attemptedAnswer" value="3" /><c:out value="${m.option3}" escapeXml="true"></c:out></pre>

	</div>
	<div class="col-md-12 col-sm-12">
	<pre><form:radiobutton path="noOfAttempts[${status.index}].attemptedAnswer" value="4" /><c:out value="${m.option4}" escapeXml="true"></c:out></pre>
	<%-- <form:radiobutton path="noOfAttempts[${index}].attemptedAnswer" value="1" />{{m.option1}}
	<form:radiobutton path="noOfAttempts[${index}].attemptedAnswer" value="2" />{{m.option2}}
	<form:radiobutton path="noOfAttempts[${index}].attemptedAnswer" value="3" />{{m.option3}}
	<form:radiobutton path="noOfAttempts[${index}].attemptedAnswer" value="4" />{{m.option4}} --%>
	</div>	
	</div>
	
	
	<div class="row">
	<div class="col-md-10 col-sm-12">
	<%-- <form:hidden path="noOfAttempts[${status.index}].correctAnswer" value="${m.answer}" /> --%>
	<form:hidden path="noOfAttempts[${status.index}].testPaperId" value="${m.testPaperId}" />
 	<form:hidden path="noOfAttempts[${status.index}].question" value="${m.question}" /> 
	<form:hidden path="noOfAttempts[${status.index}].marks" value="${m.marks}" />
	</div>
	</div>
</div>
</c:forEach>


<%-- <div class="col-md-12 container" ng-repeat="m in mydata | orderBy:random| limitTo:limit" style="border: 1px solid #0800ff;">
	
	<div class="row">
	<div class="col-md-12">
	
	<pre><h4>Question {{$index+1}}</h4><label>{{m.question}} </label>({{m.marks}} Marks)</pre>
	</div></div>
	
	<div class="row">
	<div class="col-md-12">
	<pre><input type="radio" name="noOfAttempts[{{$index}}].attemptedAnswer" value="1">{{m.option1}}</pre>
	
	</div>
	<div class="col-md-12">
	<pre><input type="radio" name="noOfAttempts[{{$index}}].attemptedAnswer" value="2">{{m.option2}}</pre>
	</div>
	<div class="col-md-12">	
	<pre><input type="radio" name="noOfAttempts[{{$index}}].attemptedAnswer" value="3">{{m.option3}}</pre>
	
	</div>
	<div class="col-md-12">
	<pre><input type="radio" name="noOfAttempts[{{$index}}].attemptedAnswer" value="4">{{m.option4}}</pre>
	<form:radiobutton path="noOfAttempts[0].attemptedAnswer" value="1" />{{m.option1}}
	<form:radiobutton path="noOfAttempts["+{{$index}}+"].attemptedAnswer" value="2" />{{m.option2}}
	<form:radiobutton path="noOfAttempts["+{{$index}}+"].attemptedAnswer" value="3" />{{m.option3}}
	<form:radiobutton path="noOfAttempts["+{{$index}}+"].attemptedAnswer" value="4" />{{m.option4}}
	</div>	
	</div>
	
	<div class="row">
	<div class="col-md-10">
	<input type="hidden" name="noOfAttempts[{{$index}}].correctAnswer" value="{{m.answer}}" />
	<input type="hidden" name="noOfAttempts[{{$index}}].testPaperId" value="{{m.testPaperId}}" />
	<input type="hidden" name="noOfAttempts[{{$index}}].question" value="{{m.question}}" />
	<input type="hidden" name="noOfAttempts[{{$index}}].marks" value="{{m.marks}}" />
	
	
	
	<form:input type="text" path="correctAnswer" value="{{m.answer}}" />
	<form:input type="text" path="testPaperId" value="{{m.testPaperId}}" />
	<form:input type="text" path="question" value="{{m.question}}" />
	</div>	
	</div>
	
</div> --%>
</div>
<nav class="pageination">
<div class="row">
  <div class="col-md-1 prev btn btn-primary btn-sm">
 PREVIOUS 
  </div>

 <!--  <div class="col-md-1 text-center current-page"></div> -->
  <div class="col-md-1 next btn btn-primary btn-sm">
  NEXT
  </div>
  </div>
</nav>
<div  class="text-center">
<br>
<input type="submit" class="text-center btn btn-primary btn-lg" value="Submit Test">
<br>
<br>
<br>

</div>
</form:form>
</div>
<script src="resources/js/myscript.js"></script>
<script>
var articleLimit = 1;
var currentPage = 1;
var $currentPage = $('.current-page');
var $articles = $('.article');
var totalArticles = $articles.length;
var totalPages = (totalArticles / articleLimit);

$articles.hide();
$currentPage.html(currentPage);
changePage();

$('.next').on('click', function(){
	currentPage++;
  if (currentPage > totalPages) {
  	currentPage = 1;
  }
  changePage();
});
$('.prev').on('click', function(){
	currentPage--;
  if (currentPage < 1) {
  	currentPage = totalPages;
  }
  changePage();
});

function changePage() {
	$articles.hide();
  $currentPage.html(currentPage);
  $($articles[currentPage * articleLimit - 1]).show();
  $($articles[currentPage * articleLimit - 1]).show();
}

history.pushState({ page: 1 }, "Title 1", "#no-back");

window.onhashchange = function (event) {
  window.location.hash = "no-back";
};

</script>
