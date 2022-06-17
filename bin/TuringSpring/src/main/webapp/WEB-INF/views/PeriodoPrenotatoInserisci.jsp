<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserisci periodo prenotato</title>
</head>
<body>
<form action="inserisci-prenotazione" method="POST">
	<label for="annuncio_id">Annuncio id</label>
	<input type="text" id="annuncio_id" name="annuncio_id">
	
	<label for="data_inizio">Data inizio</label>
	<input type="datetime-local" id="data_inizio" name="data_inizio">
	
	<label for="data_fine">Data fine</label>
	<input type="datetime-local" id="data_fine" name="data_fine">
	
	<label for="utente_id">Utente id</label>
	<input type="text" id="utente_id" name="utente_id">
	
	<label for="stato_pagamento">Stato pagamento ('ACCETTATO', 'RIFIUATO', 'IN_ATTESA', 'ANNULLATO')</label>
	<input type="text" id="stato_pagamento" name="stato_pagamento">
	
	<label for="stato_accettazione">Stato accettazione ('ACCETTATO', 'RIFIUATO', 'IN_ATTESA')</label>
	<input type="text" id="stato_accettazione" name="stato_accettazione">

	<input type="submit" class="order" value="Inserisci">
</form>
</body>
</html>