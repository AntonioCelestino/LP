<!DOCTYPE HTML>
<html>
	<head>
		<title>IF Sudeste MG</title>
		<meta name="author" content="Antonio & Nathan" />
		<meta name="keywords" content="bolsa, IF Sudeste" />
		<meta charset="UTF-8" />
	</head>
	<body>
		<form name="input" action="formulario.asp" method="post">
				<h2>Sistema de Assistência Estudantil</h2>
				<h3>- - - Folha de Pagamento - - -</h3>
				<p>
				Modalidade bolsa&nbsp;
					<select name="bolsa">
						<option value="selecionar">--selecionar--</option>
						<option value="Alimentacao">Alimentação</option>
						<option value="Manutencao">Manutenção</option>
						<option value="Moradia">Moradia</option>
						<option value="Transporte">Transporte</option>
					</select>
				</p>
				<p>
				Mês competência&nbsp;
					<select name="bolsa">
						<option value="selecionar">--selecionar--</option>
						<option value="janeiro">Janeiro</option>
						<option value="fevereiro">Fevereiro</option>
						<option value="março">Março</option>
						<option value="abril">Abril</option>
						<option value="maio">Maio</option>
						<option value="junho">Junho</option>
						<option value="julho">Julho</option>
						<option value="agosto">Agosto</option>
						<option value="setembro">Setembro</option>
						<option value="outubro">Outubro</option>
						<option value="novembro">Novembro</option>
						<option value="dezembro">Dezembro</option>
					</select>
				</p>
				<p>Ano competência&nbsp;<input type="text" size="2" /></p>
				<p><input name="folha" type="submit" value="Gerar" /></p>

				<p><input name="voltar" type="submit" value="Voltar"/></p>
		</form>
	</body>
</html>