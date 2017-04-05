<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NIIT Application</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/style.css">
<!-- <link rel="stylesheet" href="resources/css/jquery.countdownTimer.css"> -->
<style>
.navbar-brand>img {
  height: 100%;
}
.navbar-brand {
  padding: 0;
}

</style>
</head>
<body>
<div>
<nav class="navbar navbar-transparent" sty>
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="http://localhost:8083/niitandheri/"><img class="img-responsive" src="resources/images/brand-logo.png" width="220px" height="120px"></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      
      <form action="perform_login" method="post" class="navbar-form navbar-right">
        <sec:authorize access="isAnonymous()"> 
          <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
      <div class="alert alert-warning"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
        
        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
        <c:remove var = "SPRING_SECURITY_LAST_EXCEPTION" scope = "session" />
      </div>
</c:if>
        <div class="form-group">
       
          <input type="text" name="studentId" class="form-control input-sm" placeholder="Student ID" autofocus="true">
          <input type="password" name="password" class="form-control input-sm" placeholder="Password">
        </div>
       
        <button type="submit" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-log-in"></span> Login</button>
     
     <a href="register" class="btn btn-primary btn-sm">Register</a> 
     </sec:authorize>
      <sec:authorize access="isAuthenticated()"> 
     <a href="perform_logout" id="clickme" class="btn btn-primary btn-sm">Logout</a> 
     </sec:authorize>
      </form>
      
      <ul class="nav navbar-nav navbar-right">
     <sec:authorize access="hasRole('ROLE_STUDENT')">
         <li class="dropdown">
         
          <a href="#" style="border: 1px solid #337ab7;background-color:#337ab7;color:white;padding: 5px;margin-top: 8px;border-radius:5px;" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Welcome, ${name} <span class="caret"></span></a>
          
          <ul class="dropdown-menu">
            <li><a href="#">Profile <span style="text-align: right;" class="glyphicon glyphicon-edit"></span></a></li>
            <li><a href="#">Previous Results <span style="text-align: right;" class="glyphicon glyphicon-tasks"></span></a></li>
            
            <li role="separator" class="divider"></li>
            <li><a href="perform_logout">Logout <span style="text-align: right;" class="glyphicon glyphicon-log-out"></span></a></li>
          </ul>
          
        </li>
        </sec:authorize>
        
         <sec:authorize access="hasRole('ROLE_ADMIN')">
        <li class="dropdown">        
          <a href="#" style="border: 1px solid #337ab7;background-color:#337ab7;color:white;padding: 5px;margin-top: 8px;border-radius:5px;" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Welcome, ${name} <span class="caret"></span></a>
          
          <ul class="dropdown-menu">
            <li><a href="course">COURSE <span style="text-align: right;" class="glyphicon glyphicon-edit"></span></a></li>
            <li><a href="testsyllabus">COURSE - SYLLABUS <span style="text-align: right;" class="glyphicon glyphicon-tasks"></span></a></li>
            <li><a href="testpaper">TEST PAPER <span style="text-align: right;" class="glyphicon glyphicon-tasks"></span></a></li>
            
            <li role="separator" class="divider"></li>
            <li><a href="perform_logout">Logout <span style="text-align: right;" class="glyphicon glyphicon-log-out"></span></a></li>
          </ul>          
        </li>
        </sec:authorize>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<hr style="background-color:#0800ff;border-color:#0800ff;width:90%;min-height:2px;">
</div>
<div class="container">
<nav class="navbar navbar-default navbar">  
<div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
      <ul class="nav navbar-nav">
      <c:forEach items="${courseList}" var="course">
         <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${course.courseName}</a>
          <ul class="dropdown-menu">
          <c:forEach items="${course.testPaperSyllabus}" var="testSyllabus">
            <li><a href="test-${testSyllabus.testPaperSyllabusId}">${testSyllabus.testPaperSyllabusContent}</a></li>
            
            
            </c:forEach>
            <li role="separator" class="divider"></li>
            <li><a href="">Attempt Complete Test</a></li>
          </ul>
        </li>
        </c:forEach>
        
        
      </ul>
     
    
    </div><!-- /.navbar-collapse -->
    </nav>
</div>
<script type="text/javascript" src="resources/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.countdownTimer.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/angular.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.cookie.js"></script>
<script type="text/javascript">

 
$('#clickme').on('click', function() {
	 var temp="${logout}";
	 console.log(temp)
    alert(temp);
});
</script>


</body>
</html>