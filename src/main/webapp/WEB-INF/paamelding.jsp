<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="no">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/resources/css/simple.css">
	<script src="/resources/js/paamelding.js" defer></script>
	<title>Påmelding</title>
</head>

<body>
	<h2>Påmelding</h2>
	<% if (request.getAttribute("feilmelding") != null) { %>
		<p style="color:red;">${feilmelding}</p>
	<% } %>
	<form method="post" id="form">
		<fieldset>
		
			<label>Fornavn</label>
			<input type="text" name="fornavn" value="" />
			
			<label>Etternavn</label>
			<input type="text" name="etternavn" value="" />
			
			<label>Mobil (8 siffer)</label>
			<input type="text" name="mobil" value=""/>

			<label>Passord</label>
			<input type="password" name="passord" />

			<label>Passord repetert</label>
			<input type="password" name="passordRepetert" />

			<label>Kjønn</label>
			<input type="radio" name="kjonn" value="mann" checked="true"/>mann
			<input type="radio" name="kjonn" value="kvinne" />kvinne

			<br><br>
			<button type="submit">Meld meg på</button>
			<a href="innlogging" style="padding: 0 0 0 2em">logg inn</a>
		</fieldset>
	</form>
</body>
</html>
