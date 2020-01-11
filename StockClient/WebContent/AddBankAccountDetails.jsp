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
	
	<script type="text/javascript">
  $(document).ready(function(){
     $("#tra").click(function(){
  	$(".transfer").toggle();
     });

  });
</script>
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
						<li><a href="profileinfo.html">Profile</a></li>
						<li><a href="buysell.html">Buy and Sell Stock</a></li>
						<li><a href="addaccount.html">Add Bank Account</a></li>
						<li><a id="tra" href="#transfer">Transfer Money</a></li>
					  </ul>
					    <ul class="nav navbar-nav navbar-right">
						  <li><a href="login.jsp">Logout</li>
	      			</ul>
					</div>
				  </div>
				</nav>
            </header>
			
			<section>				
               
 <div class="transfer" style="display: none;" align="center"> 
   <div class="tra">
        <h2>TRANSFER MONEY</h2>
			<h3>Choose account to which money must be transferred</h3>
			<select>
				  <option value="ba1">Acc No: A123479</option>
				  <option value="ba2">Acc No: A123456</option>
				</select>
		
		</div></br></br></br>
		</div>
		
		
    </section>
	
	
    
	<section>
		<form autocomplete="on" method="post" action="addBankAccount"> 
			<h3>ADD NEW BANK ACCOUNT</h3> 
			<p> 
				<label for="ssn" class="ssn" data-icon="u">SSN</label>
			  <input id="ssnsignup" name="ssn" required="required" type="text" placeholder="Enter SSN" />
			</p>
			<p> 
				<label for="bankrno" class="bankrno" data-icon="u">BANK ROUTING NUMBER</label>
			  <input id="brno" name="bankRoutingNumber" required="required" type="text" placeholder="Enter Bank Routing Number" />
			</p>
			<p> 
				<label for="bankaccno" class="bankaccno" data-icon="u">BANK ACCOUNT NUMBER</label>
			  <input id="braccno" name="bankAccountNumber" required="required" type="text" placeholder="Enter Bank Account Number" />
			</p>
<!-- 			<p>  -->
<!-- 				<label for="bal" class="bal" data-icon="u">BALANCE</label> -->
<!-- 			  <input id="balamnt" name="balance" required="required" type="number" placeholder="Enter existing balance" /> -->
<!-- 			</p> -->
			<p>
			<input type="submit" value="Submit"/><br><br>
			</p>
		</form>

	
	</section>
	</br></br>
			<section >
				<h3>EXISTING BANK ACCOUNT DETAILS</h3>
			<table class="table table-hover" id="ord" align="left">

	
		<thead>
			<tr>
			  <th class="th-sm">SSN
			  </th>
			  <th class="th-sm">Bank Routing Number</th>
			  <th class="th-sm">Bank Account Number
			  </th>
			  <th class="th-sm">Balance
			  </th>
			</tr>
		  </thead>
		  <tbody>
			<tr>
				<td>1234</td>
				<td>B123</td>
				<td>A124578</td>
				<td>3800</td>
			</tr>
			<tr>
				<td>1234</td>
				<td>B123</td>
				<td>A124578</td>
				<td>3800</td>
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