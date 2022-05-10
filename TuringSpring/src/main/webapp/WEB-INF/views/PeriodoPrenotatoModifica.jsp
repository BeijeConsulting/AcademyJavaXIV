<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifica periodi prenotati</title>
</head>
<body>
<form action="modifica-prenotazione" method="POST">
	<input type="hidden" name="id" value="${periodoPrenotato.id}">

	<label for="data_inizio">Data inizio</label>
	<input type="datetime" id="data_inizio" name="data_inizio" value="${PeriodoPrenotato.data_inizio}">
	
	<label for="data_fine">Data fine</label>
	<input type="datetime" id="data_fine" name="data_fine" value="${PeriodoPrenotato.data_fine}">
	
	<label for="stato_pagamento">Stato pagamento ('ACCETTATO', 'RIFIUATO', 'IN_ATTESA', 'ANNULLATO')</label>
	<input type="text" id="stato_pagamento" name="stato_pagamento" value="${PeriodoPrenotato.stato_pagamento}">
	
	<label for="stato_accettazione">Stato accettazione ('ACCETTATO', 'RIFIUATO', 'IN_ATTESA')</label>
	<input type="text" id="stato_accettazione" name="stato_accettazione" value="${PeriodoPrenotato.stato_accettazione}">

	<input type="submit" class="order" value="Modifica">
</form>
</body>
</html>