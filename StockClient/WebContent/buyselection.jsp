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
		
		<c:choose>
				<c:when test="${not empty selectedTickerList}">
				<form action="buyStocks" method="post">
					<table id="dtBasicExample"
						class="table table-striped table-bordered table-sm"
						cellspacing="0" width="100%">
						<thead>
							<tr>
								<th class="th-sm">Ticker Symbol</th>
								<th class="th-sm">Schedule</th>
								<th class="th-sm">Date</th>
								<th class="th-sm">Number of Stocks to buy</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${selectedTickerList}" var="stockData">
								<tr>
									<td>${stockData}</td>
									<td><select>
								<option value="onetime">One time</option>
								<option value="recurring">Recurring based on a set schedule</option>
							</select></td>
									<td><input type="Date" name="DateOut"
								value="<%=request.getAttribute("date")%>" readonly> </td>
								<td><input type="number" name="numOfStocks" contenteditable='true'> </td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<input type="submit" value="submit">
					<input type="text" name="stockList" value="<%=request.getAttribute("selectedTickerList") %>" hidden="true">
	<input type="text" name="username"  value ="<%=request.getAttribute("username") %>"hidden="true">
	<input type="text" name="password" value ="<%=request.getAttribute("password") %>" hidden="true">
					</form>
				</c:when>
				<c:otherwise>
				No Data To Display
				</c:otherwise>
			</c:choose>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
<%-- 			<c:choose> --%>
<%-- 				<c:when test="${not empty selectedTickerList}"> --%>
				
				
				
<!-- 					<table width='50'> -->
<!-- 						<tr> -->
<!-- 							<td>Selected Tickers:</td> -->
<!-- 							<td><input type="text" name="selectedTickerList" -->
<%-- 								value="<%=request.getAttribute("selectedTickerList")%>" required --%>
<!-- 								disabled> <br></td> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td>Schedule:  </td> -->
<!-- 							<td> -->
<!-- 							<select> -->
<!-- 								<option value="onetime">One time</option> -->
<!-- 								<option value="recurring">Recurring based on a set schedule</option> -->
<!-- 							</select> -->
<!-- 							</td> -->
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td>Date Out:</td> -->
<!-- 							<td><input type="Date" name="DateOut" -->
<%-- 								value="<%=request.getAttribute("date")%>" readonly> <br></td> --%>
<!-- 						</tr> -->
<!-- 						<tr> -->
<!-- 							<td><input type="hidden" name="searchValue" -->
<%-- 								value="<%=request.getAttribute("searchValue")%>"> <input --%>
<!-- 								type="submit" formtarget="_self"></td> -->
<!-- 						</tr> -->
<!-- 					</table> -->





<%-- 				</c:when> --%>
<%-- 				<c:otherwise> --%>
<!-- 				No Data To Display -->
<%-- 				</c:otherwise> --%>
<%-- 			</c:choose> --%>
		</section>
	</div>
	</br>
	</br>
	<footer class="container-fluid text-center">
		<p class="mt-5 mb-3 text-muted">Stock Brockerage Copyright &copy;
			2019-2020</p>

	</footer>
</body>

<script type="text/javascript">
	$(document).ready(function() {
		$('#dtBasicExample').DataTable();
		$('.dataTables_length').addClass('bs-select');

	});
	function myFunction(x) {
		var context = "${pageContext.request.contextPath}";
		var url = context + "/currentStock" + "?tickerSymbol=" + x.innerText;
		window.open(url, '_self');
	}
</script>


</html>