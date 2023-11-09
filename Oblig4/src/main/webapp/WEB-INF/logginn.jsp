<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/simple.css">
<title>Logg inn</title>
</head>
<body>
	<h2>Logg inn</h2>
        <% if (request.getAttribute("error") != null) { %>
            <p style="color:red;">${error}</p>
        <% } %>
	<form method="post">
		<fieldset>
			<label for="mobil">Mobil:</label> <input type="text" name="mobil" />
			<label for="passord">Passord:</label> <input type="password" name="passord" />
			<br><br><button type="submit">Logg inn</button>
		</fieldset>
	</form>

</body>
</html>