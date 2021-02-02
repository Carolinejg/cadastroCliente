<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt_BR">
	<head>
		<link rel="stylesheet" type="text/css" href="sucesso.css" media="screen" />
	</head>
	<body>
		<div>
			<center>
				<img src="check.png" alt="some text" width=60 height=70>
			</center>
			<h1>Tudo certo!</h1>
			<h2 id="logo">
			Cadastro já realizado na data e hora: <c:out value="${datacad}" />!</h1>
		</div>
	</body>
</html>