<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/simple.css">
<title>Påmeldingsbekreftelse</title>
</head>
<body>
	<h2>Påmeldingsbekreftelse</h2>
	<p>Påmeldingen er mottatt for</p>
	<p style="padding: 0 0 0 3em">
		${fornavn}<br/>
		${etternavn}<br/>
		${mobil}<br/>
		${kjonn}
	</p>
	<a href="deltagerliste">Gå til deltagerlisten</a>
</body>
</html>