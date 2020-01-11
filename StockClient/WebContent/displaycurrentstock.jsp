<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<meta charset="UTF-8" />
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
<title>Profile Information</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1 shrink-to-fit=no">
<meta name="description" content="Stock Brockerage User Profile Info" />
<meta name="author" content="Team Blue" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
<link href="css/addons/datatables.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/addons/datatables.min.js"></script>

<style>
/* Remove the navbar's default rounded borders and increase the bottom margin */
.navbar {
	margin-bottom: 50px;
	border-radius: 0;
}

div.container1 {
	width: 500px;
	margin: auto;
}

table.dataTable thead .sorting:after, table.dataTable thead .sorting:before,
	table.dataTable thead .sorting_asc:after, table.dataTable thead .sorting_asc:before,
	table.dataTable thead .sorting_asc_disabled:after, table.dataTable thead .sorting_asc_disabled:before,
	table.dataTable thead .sorting_desc:after, table.dataTable thead .sorting_desc:before,
	table.dataTable thead .sorting_desc_disabled:after, table.dataTable thead .sorting_desc_disabled:before
	{
	bottom: .5em;
}

.sidenav {
	height: 100%;
	width: 200px;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: #111;
	overflow-x: hidden;
	padding-top: 20px;
}

/* Style the sidenav links and the dropdown button */
.sidenav a, .dropdown-btn {
	padding: 6px 8px 6px 16px;
	text-decoration: none;
	font-size: 20px;
	color: #818181;
	display: block;
	border: none;
	background: none;
	width: 100%;
	text-align: left;
	cursor: pointer;
	outline: none;
}

/* On mouse-over */
.sidenav a:hover, .dropdown-btn:hover {
	color: #f1f1f1;
}

/* Add an active class to the active dropdown button */
.active {
	background-color: green;
	color: white;
}

/* Dropdown container (hidden by default). Optional: add a lighter background color and some left padding to change the design of the dropdown content */
.dropdown-container {
	display: none;
	background-color: #262626;
	padding-left: 8px;
}

/* Optional: Style the caret down icon */
.fa-caret-down {
	float: right;
	padding-right: 8px;
}

.main {
	margin-left: 200px; /* Same as the width of the sidenav */
	padding: 0px 10px;
}

a.kinda-link:hover {
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="container">
		<!--/ Codrops top bar -->
		<header>
			<h1>
				STOCK <span>BROCKERAGE</span>
			</h1>
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#myNavbar">
							<span class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
					<div class="collapse navbar-collapse" id="myNavbar">
						<ul class="nav navbar-nav">
							<li class="active"><a href="stockDetails">Home</a></li>
							<li><a href="profileinfo.html">Profile</a></li>
							<li><a href="buysell.html">Buy and Sell Stock</a></li>
							<li><a href="transfermoney.html">Transfer Money</a></li>
						</ul>

					</div>
				</div>
			</nav>
		</header>
		<section>
			<div class="sidenav">
				<%
			String contextPath=request.getContextPath();
			String con=request.getContextPath()+"/currentStock?tickerSymbol="+request.getParameter("tickerSymbol")+"&requestedData=";
			%>

				<a class='kinda-link' href="<%=con + "today"%>"
					onclick="myFunction(today)">Today's Stock Data</a> <a
					class='kinda-link' href="<%=con + "curweek"%>"
					onclick="myFunction(curweek)">Current Week</a> <a
					class='kinda-link' href="<%=con + "pastweek"%>" onclick="myFunction(pastweek)">Past Week</a> <a
					class='kinda-link'href="<%=con + "month"%>" onclick="myFunction(month)">Month To Date</a> <a
					class='kinda-link'href="<%=con + "curryear"%>" onclick="myFunction(curryear)">Year To Date</a><a
					class='kinda-link'href="<%=con + "pastyear"%>" onclick="myFunction(pastyear)">Past 5 years</a>
			</div>
		</section>
		<section class="main" id="currentday">
			<h3>CURRENT STOCK DATA VALUES WITH PRICE</h3>
			<c:choose>
				<c:when test="${not empty stockList}">
					<table id="dtBasicExample"
						class="table table-striped table-bordered table-sm"
						cellspacing="0" width="100%">
						<thead>
							<tr>
								<th class="th-sm">Ticker Symbol</th>
								<th class="th-sm">Date</th>
								<th class="th-sm">Open</th>
								<th class="th-sm">Close</th>
								<th class="th-sm">High</th>
								<th class="th-sm">Low</th>
								<th class="th-sm">Volume</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${stockList}" var="stockData">
								<tr>
									<td>${stockData.tickerSymbol}</td>
									<td>${stockData.date}</td>
									<td>${stockData.open}</td>
									<td>${stockData.close}</td>
									<td>${stockData.high}</td>
									<td>${stockData.low}</td>
									<td>${stockData.volume}</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<th>Ticker Symbol</th>
								<th>Date</th>
								<th>Open</th>
								<th>Close</th>
								<th>High</th>
								<th>Low</th>
								<th>Volume</th>
							</tr>
						</tfoot>
					</table>
				</c:when>
				<c:otherwise>
				No Data To Display
				</c:otherwise>
			</c:choose>
		</section>
	</div>
	</br>
	</br>
	<footer class="container-fluid text-center">
		<p class="mt-5 mb-3 text-muted">Stock Brockerage Copyright &copy;
			2019-2020</p>

	</footer>
	<input type="text" name="username"  value ="<%=request.getAttribute("username") %>"hidden="true">
	<input type="text" name="password" value ="<%=request.getAttribute("password") %>" hidden="true">
</body>

<script type="text/javascript">
	$(document).ready(function() {
		$('#dtBasicExample').DataTable();
		$('.dataTables_length').addClass('bs-select');

	});
	var dropdown = document.getElementsByClassName("dropdown-btn");
	var i;

	for (i = 0; i < dropdown.length; i++) {
		dropdown[i].addEventListener("click", function() {
			this.classList.toggle("active");
			var dropdownContent = this.nextElementSibling;
			if (dropdownContent.style.display === "block") {
				dropdownContent.style.display = "none";
			} else {
				dropdownContent.style.display = "block";
			}
		});
	}
	function myFunction(x) {
		var context = "${pageContext.request.contextPath}";
		var url = context + "/currentStock" + "?tickerSymbol="
				+
<%= request.getParameter("tickerSymbol") %>
	"&requestedData=" + x;
		// 		  return url;
		window.open(url, '_self');
	}
</script>


</html>