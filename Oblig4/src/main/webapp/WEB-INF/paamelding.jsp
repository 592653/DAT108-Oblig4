<!DOCTYPE html>
<html lang="no">
<head>
	<link href="css/simple.css" rel="stylesheet" type="text/css" />
<!-- <script src="js/myscript.js" defer></script>  -->  
	<title>Paamelding</title>
</head>

<body>
	<h2>Paamelding</h2>
	<p style="color:red;">Paameldingsdetaljer er ugyldige</p>
	<form method="post">
		<fieldset>
		
			<label>Fornavn</label>
			<input type="text" name="fornavn" value="Lars" />
			
			<label>Etternavn</label>
			<input type="text" name="etternavn" value="Larsen" />
			
			<label>Mobil (8 siffer)</label>
			<input type="text" name="mobil" value="1234" />
			
			<label>Passord</label>
			<input type="password" name="passord" />
			<label>Passord repetert</label>
			<input type="password" name="passordRepetert" />
			
			<label>Kjonn</label> 
			<input type="radio" name="kjonn" value="mann" checked="checked" />mann
			<input type="radio" name="kjonn" value="kvinne" />kvinne
			     
			<br><br><button type="submit">Meld meg paa</button>
		</fieldset>
	</form>
</body>
</html>
