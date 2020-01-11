<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Profile Information</title>
        <meta name="viewport" content="width=device-width, initial-scale=1 shrink-to-fit=no"> 
        <meta name="description" content="Stock Brockerage User Profile Info" />
        <meta name="author" content="Team Blue" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
		<link href="css/addons/datatables.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
		
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
	</style>
    </head>
    <body>
        <div class="container">
            <!--/ Codrops top bar -->
            <header>
                <h1>STOCK <span>BROCKERAGE</span></h1>
				<nav class="navbar navbar-inverse">
				  <div class="container-fluid">
					<div class="navbar-header">
					  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>                        
					  </button>
					</div>
					<div class="collapse navbar-collapse" id="myNavbar">
					  <ul class="nav navbar-nav">
						<li class="active"><a href="stockDetails">Home</a></li>
						<li><a href="profileinfo.jsp">Profile</a></li>
						<li><a href="buysell.html">Buy and Sell Stock</a></li>
						<li><a href="transfermoney.html">Transfer Money</a></li>
					  </ul>
					  
					</div>
				  </div>
				</nav>
            </header>
            <section>	
            <form action="AddBankAccountDetails.jsp">
            <input type="submit" value="Add Bank Account"/>
            
            </form>
            
            			
                <div class="container1 ">
					
						<div style="background-color: #f5f5f5;">
                        <h4>PROFILE INFORMATION:</h4>
						
						<p>Name:</p>
						<p>Address:</p>
						<p>E-mail:</p>
						<p>SSN:</p>
						
					
				
    
        
				</div>
				</div>
            </section>
			</br></br>
			<section >
				<h3>PURCHASE HISTORY</h3>
			<table class="table table-hover" id="ord" align="left">

	
		<thead>
			<tr>
			  <th class="th-sm">SSN</th>
			  <th class="th-sm">Ticker Symbol
			  </th>
			  <th class="th-sm">Price
			  </th>
			  <th class="th-sm">Quantity
			  </th>
			  
			</tr>
		  </thead>
		  <tbody>
			<tr>
				<td>1234</td>
				<td>LRW</td>
				<td>$12</td>
				<td>3</td>
			</tr>
			<tr>
				<td>1234</td>
				<td>LRW</td>
				<td>$12</td>
				<td>3</td>
			</tr>
			
		  </tbody>
		  <tfoot>
			<tr>
			  <th class="th-sm">SSN</th>
			  <th class="th-sm">Ticker Symbol
			  </th>
			  <th class="th-sm">Price
			  </th>
			  <th class="th-sm">Quantity
			  </th>
			  
			</tr>
		  </tfoot>
</table>
</div>	
        </div>
		</br></br>
		<footer class="container-fluid text-center">
	<p class="mt-5 mb-3 text-muted">Stock Brockerage Copyright &copy;  2019-2020</p>
 
</footer>
    </body>
	
	<script type="text/javascript">
  $(document).ready(function () {
$('#ord').DataTable();
$('.dataTables_length').addClass('bs-select');


});

</script>	
	
	
</html>