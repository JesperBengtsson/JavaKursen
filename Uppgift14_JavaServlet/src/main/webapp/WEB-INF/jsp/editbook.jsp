<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
        <h2>Edit book</h2>
        <form:form method="POST" action="/savebook" modelAttribute="book" class="form-group">
            <table>
                <form:hidden path="id" />
                <tr>
                    <td><form:label path="title">Title</form:label></td>
                    <td><form:input path="title" class="form-control"/></td>
                </tr>
                <tr>
                    <td><form:label path="description">Description</form:label></td>
                    <td><form:input path="description" class="form-control"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit" class="btn btn-default"/></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>