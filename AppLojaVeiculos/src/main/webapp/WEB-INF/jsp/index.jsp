<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<meta charset="ISO-8859-1">
	<title>appVendaVeiculos</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="container-fluid">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link active" href="/">appVendaVeiculos</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/vendedor/lista">Vendedores</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/produto/lista">Produtos</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/carro/lista">Carros</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/moto/lista">Motos</a>
	      </li>
	    </ul>
	  </div>
	</nav>
	
	<div class="container mt-3">
	
		<span class="badge rounded-pill bg-primary">Vendedor: ${qtdeVendedor}</span>
	  	<span class="badge rounded-pill bg-secondary">Produto: ${qtdeProduto}</span>
	  	<span class="badge rounded-pill bg-success">Carro: ${qtdeCarro}</span>
	  	<span class="badge rounded-pill bg-danger">Moto: ${qtdeMoto}</span>
  	
  		<c:if test="${not empty listagem}">
			<h2>AppVenda</h2>
			<p>Gestão de vendas de produtos:</p>
			<table class="table">
				<thead class="table-dark">
					<tr>
					  <th>${titulo}</th>
					  <th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${listagem}">
						<tr>
						  <td>${item}</td>
						  <td><a href="/${rota}/${item.id}/excluir">excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>