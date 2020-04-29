<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%;">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@800&display=swap" rel="stylesheet">
<title>Home</title>
</head>
<body style="min-height: 100%; background-color: #212121;">
	<div class="row align-items-center" style="height:100vh;">
		<div class="col offset-4">
			<h3 style="font-family: 'Open Sans', sans-serif; color: white;">UPLOAD YOUR DATA FILE</h3>
			</hr>
			<form style="color: white;" method="post" action="ontology.jsp" enctype="multipart/form-data">
				<input type="file" name="myFile" multiple/>
				<input type="submit" name="upload"/>
			</form>			
		</div>
	</div>
</body>
</html>