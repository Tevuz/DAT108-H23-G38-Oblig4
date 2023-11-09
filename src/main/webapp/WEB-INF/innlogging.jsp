<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/resources/css/simple.css">
	<script src="/resources/js/innlogging.js" defer></script>
	<title>Logg inn</title>
</head>
<body>
	<h2>Logg inn</h2>
	<% if (request.getAttribute("feilmelding") != null) { %>
	<p style="color:red;">${feilmelding}</p>
	<% } %>
	<form method="post" id="form">
		<fieldset>
			<label>Mobil:</label>
			<input type="text" name="mobil" />
			<label>Passord:</label>
			<input type="password" name="passord" />
			<br><br><button type="submit">Logg inn</button>
			<a href="paamelding" style="padding: 0 0 0 2em">Registrer</a>
		</fieldset>
	</form>


</body>
</html>