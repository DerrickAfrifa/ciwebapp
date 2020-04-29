<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@800&display=swap" rel="stylesheet">
<title>Query Display</title>
</head>
<body style="min-height: 100%; background-color: #212121;">
	<div style="margin-top: 10em;" class="container">
		<div class="row ">
			<div class="col">
				<h1 style="font-family: 'Open Sans', sans-serif; color: white;">DISPLAY ${par}</h1>
				<ul class="list-group">
					<c:forEach items="${results}" var="entry">
				        <li class="list-group-item">
				        	<div class="d-flex w-100 justify-content-between">
						    	<a class="mb-1" href="<c:out value="${entry}"/>" target="_blank"><c:out value="${entry}" /></a>
						    </div>
				        </li>
					</c:forEach>	
				</ul>
			</div>
		</div>
	</div>
</body>
</html>