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
    <h2>Add book</h2>
        <form action="/addbooks" method="post">
            <div class="form-group">
                <label for="title">Title:</label>
                <input type="text" class="form-control" id="title" name="title">
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <input type="text" class="form-control" id="description" name="description">
            </div>
            <button type="submit" class="btn btn-default">Save book</button>
        </form>
    <h2>Search</h2>
    <form action="/books">
        <div class="form-group">
            <label for="search">Search:</label>
            <input type="text" name="search" class="form-control"><br>
        </div>
        <button type="submit" class="btn btn-default">Search</button>
    </form>

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

                    <td><a href="/editbook/${book.getId()}" class="btn btn-primary">EDIT</a></td>
                    <td><a href="/deletebook/${book.getId()}" class="btn btn-primary">DELETE</a></td>
                </tr>
   	        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>