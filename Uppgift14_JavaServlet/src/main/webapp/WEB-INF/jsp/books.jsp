<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 

</head>
<body>
	
	
<div class="container">
  <h2>Books</h2>        
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Book id</th>
        <th>Title</th>
        <th>Description</th>
      </tr>
    </thead>
    <tbody>

      <c:forEach items="${books}" var="book">   			  
       
      <tr>  
        <td>${book.getId()}</td>
        <td>${book.getTitle()}</td>
        <td>${book.getDescription()}</td>
        
        <td><button onclick="/editbook" type="submit" class="btn btn-primary" id="${book.getId()}">Edit</button></td>
    
      </tr>
     
   	  </c:forEach>
   	  
    </tbody>
  </table>
</div>

</body>  
 

</html>