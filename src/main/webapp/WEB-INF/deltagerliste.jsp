<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/resources/css/simple.css">
	<title>Deltagerliste</title>
</head>
<body>
    <p>Innlogget som: ${mobil} / ${fornavn} ${etternavn}</p>
	<h2>Deltagerliste</h2>
	<table>
		<tr>
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
		<c:forEach var="deltager" items="${deltagere}">
			<tr>
				<td>${deltager.kjonn}</td>
				<td>${deltager.fornavn} ${deltager.etternavn}</td>
				<td>${deltager.mobil}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<form action="utlogging" method="post">
	   <button type="submit">Logg ut</button> 
	</form>
</body>
</html>