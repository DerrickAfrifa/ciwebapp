<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@800&display=swap" rel="stylesheet">
<title>Query</title>
</head>
<body style="min-height: 100%; background-color: #212121;">
	<div class="row align-items-center" style="height:100vh;">
		<div class="col offset-4">
			<h1 style="font-family: 'Open Sans', sans-serif; color: white;">QUERY</h1>
			<form style="color: white;" action="/queryDisplay">
			  <input type='hidden' name='filePath' id='file' value='${filePath}' />
			  <label for="queryType">Choose a query:</label>
			  <select id="queryType" name="queryType">
			    <option value="pdc">Missing personal data category</option>
			    <option value="dsubj">Missing data subject</option>
			    <option value="dsrc">Missing data source</option>
			    <option value="rec">Missing recipient</option>
			    <option value="pur">Missing purpose</option>
			    <option value="tom">Missing technical/organisational measures</option>
			    <option value="tid">Missing 3rd part recipient identity</option>
			    <option value="vag">Violation</option>
			  </select>
			  <input type="submit">
			</form>
		</div>
	</div>
</body>
</html>