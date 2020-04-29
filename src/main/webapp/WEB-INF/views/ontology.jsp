<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@800&display=swap" rel="stylesheet">
<title>Ontology</title>
</head>
<body style="min-height: 100%; background-color: #212121;">
	<div class="row align-items-center" style="height:100vh;">
		<div class="col offset-4">
			<h1 style="font-family: 'Open Sans', sans-serif; color: white;">PRIVACY POLICY UPLOADED</h1>
			<form method="GET" action="validate.jsp">
				<input type='hidden' name='filePath' id='file' value='${filePath}' />
				<input type="submit" value="Validate"/>
			</form>
			<br>
			<form method="GET" action="query.jsp">
				<input type='hidden' name='filePath' id='file' value='${filePath}' />
				<input type="submit" value="Query"/>
			</form>
		</div>
	</div>
</body>
</html>