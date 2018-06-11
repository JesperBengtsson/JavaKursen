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
  <h2>Button Tags</h2>
  <a href="books" class="btn btn-primary" role="button">Show books in db</a>
  <a href="addbooks" class="btn btn-primary" role="button">Add books to db</a>
  <a href="editbook" class="btn btn-primary" role="button">edit book in db</a>
  <a href="searchbook" class="btn btn-primary" role="button">Search book in db</a>
  <a href="deletebook" class="btn btn-primary" role="button">Delete book from db</a>
</div>
	
</body>  
 

</html>