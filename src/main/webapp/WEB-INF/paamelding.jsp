<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="no">
<head>
	<meta charset="UTF-8">
	<link href="css/simple.css" rel="stylesheet" type="text/css" />
<!-- <script src="js/myscript.js" defer></script>  -->  
	<title>Påmelding</title>
</head>

<body>
	<h2>Påmelding</h2>
	<% if (request.getAttribute("feilmelding") != null) { %>
		<p style="color:red;">${feilmelding}</p>
	<% } %>
	<form method="post">
		<fieldset>
		
			<label>Fornavn</label>
			<input type="text" name="fornavn" value="" />
			
			<label>Etternavn</label>
			<input type="text" name="etternavn" value="" />
			
			<label>Mobil (8 siffer)</label>
			<input type="text" name="mobil" value="" />
			
			<label>Passord</label>
			<input type="password" name="passord" />
			<label>Passord repetert</label>
			<input type="password" name="passordRepetert" />

			<label>Kjønn</label>
			<input type="radio" name="kjonn" value="mann" checked="checked" />mann
			<input type="radio" name="kjonn" value="kvinne" />kvinne

			<br><br>
			<button type="submit">Meld meg på</button>
		</fieldset>
	</form>
</body>
</html>
