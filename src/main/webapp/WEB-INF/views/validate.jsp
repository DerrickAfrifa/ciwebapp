<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script type="text/javascript">
window.onload = function() { 
 
var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light2",
	title: {
		text: "Violations Report"
	},
	subtitles: [{
		text: "For privacy policy"
	}],
	axisY: {
		title: "Number of violation instances",
		labelFormatter: addSymbols
	},
	data: [{
		type: "bar",
		indexLabel: "{y}",
		indexLabelFontColor: "#444",
		indexLabelPlacement: "inside",
		dataPoints: <%=request.getAttribute("data") %>,
	}]
});
chart.render();
 
function addSymbols(e) {
	var suffixes = ["", "K", "M", "B"];
 
	var order = Math.max(Math.floor(Math.log(e.value) / Math.log(1000)), 0);
	if(order > suffixes.length - 1)
	order = suffixes.length - 1;
 
	var suffix = suffixes[order];
	return CanvasJS.formatNumber(e.value / Math.pow(1000, order)) + suffix;
}
 
}
</script>
<title>Validate</title>
</head>
<body>
	<div id="chartContainer" style="height: 370px; width: 100%; margin-top: 20px;"></div>
	<br/>
	<div class="container">
		<h5>Total Violations ${totalViolations}</h5>
		<br/>
		<h2>Violations:</h2>
		<ul class="list-group">
			<c:forEach items="${entries}" var="entry">
		        <li class="list-group-item list-group-item-action list-group-item-danger">
				    <div class="d-flex w-100 justify-content-between">
				      <h5 class="mb-1"><c:out value="${entry[0]}" /></h5>
				    </div>
				    <p class="mb-1">Violation Message: <c:out value="${entry[2]}" /></p>
				    <small class="text-muted"><a href="<c:out value="${entry[1]}" />" target="_blank"><c:out value="${entry[1]}" /></a></small>
		        </li>
			</c:forEach>	
		</ul>
	</div>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>