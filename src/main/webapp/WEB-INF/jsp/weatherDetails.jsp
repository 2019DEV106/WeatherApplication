<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Weather Application</title>

<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<style type="text/css">
.table {
	width: 40%;
}
</style> 

</head>
<body>


	<table class="table table-striped">
		<caption>
			<strong>Weather Details</strong>
		</caption>
		<thead>
		</thead>
		<tbody>
			<tr>
				<td>Location</td>
				<td>${weatherData.name}</td>
			</tr>
			<tr>
				<td>humidity</td>
				<td>${weatherData.weatherDetails.humidity}</td>
			</tr>
			<tr>
				<td>pressure</td>
				<td>${weatherData.weatherDetails.pressure}</td>
			</tr>
			<tr>
				<td>temp</td>
				<td>${weatherData.weatherDetails.temp}</td>
			</tr>
			<tr>
				<td>temp_max</td>
				<td>${weatherData.weatherDetails.tempMax}</td>
			</tr>
			<tr>
				<td>temp_min</td>
				<td>${weatherData.weatherDetails.tempMin}</td>
			</tr>
			<tr>
				<td>Wind Speed</td>
				<td>${weatherData.windDetails.speed}</td>
			</tr>
		</tbody>
	</table>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>	
</body>
</html>