<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Weather Application</title>


</head>
<body>

<form id="weatherDetails" method="post">
		<strong>Please enter Latitude value</strong> 	:<input type="text" onkeypress="return isNumberKey(event)" id="latitude" name="latitude" value="50.85" /><br/>
		<strong>Please enter Longitude value: </strong>  <input type="text"onkeypress="return isNumberKey(event)" id="longitude"  name="longitude" value="4.35" /><br/>
		<input type="submit" /><br/>
	</form>
	  
</body>
</html>