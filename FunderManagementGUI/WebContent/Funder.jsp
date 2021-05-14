<%@page import="com.model.funder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Funder Management</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">

<script src="Component/jquery-3.5.0.min.js"></script>
<script src="Component/Funder.js"></script>

<style type="text/css">
html {
	position: relative;
	min-height: 100%;
}

body {
	padding-top: 4.5rem;
	margin-bottom: 4.5rem;
}

.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 3.5rem;
	line-height: 3.5rem;
	background-color: #ccc;
}

.nav-link:hover {
	transition: all 0.4s;
}

.nav-link-collapse:after {
	float: right;
	content: '\f067';
	font-family: 'FontAwesome';
}

.nav-link-show:after {
	float: right;
	content: '\f068';
	font-family: 'FontAwesome';
}

.nav-item ul.nav-second-level {
	padding-left: 0;
}

.nav-item ul.nav-second-level>.nav-item {
	padding-left: 20px;
}

@media ( min-width : 992px) {
	.sidenav {
		position: absolute;
		top: 0;
		left: 0;
		width: 230px;
		height: calc(100vh - 3.5rem);
		margin-top: 3.5rem;
		background: #343a40;
		box-sizing: border-box;
		border-top: 1px solid rgba(0, 0, 0, 0.3);
		width: 230px;
	}
	.navbar-expand-lg .sidenav {
		flex-direction: column;
	}
	.content-wrapper {
		margin-left: 230px;
	}
	.footer {
		width: calc(100% - 230px);
		margin-left: 230px;
	}
}
</style>

</head>
<body>

	<!-- Navbar-->
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
		<a class="navbar-brand" href="#">GadgetBadget</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto sidenav" id="navAccordion">
				<li class="nav-item ml-3"><a class="nav-link"
					href="AdminPanel.jsp">Home </a></li>
				<!--<li class="nav-item"><a class="nav-link" href="#">Item 1</a></li> -->

				<li class="nav-item active ml-3"><a
					class="nav-link nav-link-collapse" href="#" id="hasSubItems"
					data-toggle="collapse" data-target="#collapseSubItems3"
					aria-controls="collapseSubItems3" aria-expanded="false">Funder
						Details<span class="sr-only">(current)</span>
				</a>
					<ul class="nav-second-level collapse" id="collapseSubItems3"
						data-parent="#navAccordion">
						<li style="list-style-type: none;" class="nav-item"><a
							class="nav-link" href="Funder.jsp"> <span
								class="nav-link-text">Add Funder Details</span>
						</a></li>
					</ul></li>
				<li class="nav-item ml-3"><a class="nav-link" href="#">Project
						Details</a></li>
				<li class="nav-item ml-3"><a class="nav-link" href="#">Buyer
						Details</a></li>
				<li class="nav-item ml-3"><a class="nav-link" href="#">Researcher
						Details</a></li>
				<li class="nav-item ml-3"><a class="nav-link" href="#">Product
						Details</a></li>
				<li class="nav-item ml-3"><a class="nav-link" href="#">Payment
						Details</a></li>
			</ul>
		</div>
	</nav>

	<main class="content-wrapper">
		<div class="container-fluid">
			<section class="mt-2">
				<div class="pl-5 pr-5">
					<h2 class="mb-3">Add Funder Details</h2>

					<form id="FUNDER" name="FUNDER" class="border border-light p-5">

						<div class="form-outline mb-4">
							<label class="form-label" for="form6Example3"
								class="col-sm-2 col-form-label col-form-label-sm">Code:</label>
							<input type="hidden" id="funderID" name="funderID"> <input
								type="text" id="funderCode" class="form-control" name="funderCode">
						</div>

						<div class="form-outline mb-4">
							<label class="form-label" for="form6Example3"
								class="col-sm-2 col-form-label col-form-label-sm">Name:</label>
							<input type="text" id="funderName" class="form-control" name="funderName">
						</div>

						<div class="form-outline mb-4">
							<label class="form-label" for="form6Example3"
								class="col-sm-2 col-form-label col-form-label-sm">Address:</label>
							<input type="text" id="funderAddress" class="form-control" name="funderAddress">
						</div>

						<div class="form-outline mb-4">
							<label class="form-label" for="form6Example3"
								class="col-sm-2 col-form-label col-form-label-sm">Telephone
								:</label> <input type="text" id="funderTel" class="form-control" name="funderTel">
						</div>
						<div class="form-outline mb-4">
							<label class="form-label" for="form6Example3"
								class="col-sm-2 col-form-label col-form-label-sm">Email
								:</label> <input type="text" id="funderEmail" class="form-control" name="funderEmail">
						</div>
						<div class="form-outline mb-4">
							<label class="form-label" for="form6Example3"
								class="col-sm-2 col-form-label col-form-label-sm">Gender:</label>
								 <input type="text" id="funderGender" class="form-control"
								name="funderGender">
						</div>
						<div class="form-outline mb-4">
							<label class="form-label" for="form6Example3"
								class="col-sm-2 col-form-label col-form-label-sm">Fund
								Amount :</label> <input type="text" id="funderFund" class="form-control"
								name="funderFund">
						</div>
						<div class="form-outline mb-4">
							<label class="form-label" for="form6Example3"
								class="col-sm-2 col-form-label col-form-label-sm">Duration
								:</label> <input type="date" id="funderTime" class="form-control" name="funderTime">
						</div>
						<div class="form-outline mb-4">
							<label class="form-label" for="form6Example3"
								class="col-sm-2 col-form-label col-form-label-sm">Description
								:</label> <input type="text" id="funderDes" class="form-control" name="funderDes">
						</div>
						<br>
						<div id="alertSuccess" class="alert alert-success"></div>
						<div id="alertError" class="alert alert-danger"></div>
						<input id="btnSave" name="btnSave" type="button" value="Save"
							class="btn btn-primary btn-lg btn-block">

					</form>


				</div>
			</section>
		</div>

		<div class="ml-5">
			<h2 class="mb-3">All Funder Details</h2>
		</div>
		<div class="container-fluid col-12 mb-5" id="FunderGrid">
			<fieldset>
				<form method="post" action="Funder.jsp"
					class="table container-fluid table-striped">
					<%
						funder viewProject = new funder();
						out.print(viewProject.viewFunders());
					%>
				</form>
				<br>
			</fieldset>
		</div>

	</main>
	<footer class="footer bg-dark mt-5">
		<div class="container">
			<div class="text-center text-light">
				<span>Create by , <span style="color: #87CEEB;">PAF
						Team</span> 2021
				</span>
			</div>
		</div>
	</footer>

	<!-- jQuery library -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	<!-- Popper JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {

			$('.nav-link-collapse').on('click', function() {
				$('.nav-link-collapse').not(this).removeClass('nav-link-show');
				$(this).toggleClass('nav-link-show');
			});

		});
	</script>



</body>
</html>