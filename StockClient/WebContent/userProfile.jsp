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
        <title>User Profile</title>
        <meta name="viewport" content="width=device-width, initial-scale=1 shrink-to-fit=no"> 
        <meta name="description" content="Stock Brockerage User Profile" />
        <meta name="author" content="Team Blue" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
		
		<style>
			/* Remove the navbar's default rounded borders and increase the bottom margin */ 
			.navbar {
			  margin-bottom: 50px;
			  border-radius: 0;
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
						<li class="active"><a href="userProfile.jsp">Home</a></li>
						<li><a href="profileinfo.jsp">Profile</a></li>
						<li><a href="buysell.jsp">Buy and Sell Stock</a></li>
						<li><a href="/">Stock Details</a></li>
						<li><a id="tra" href="#transfer">Transfer Money</a></li>
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
		
		</div>
		</div>
    </section>
    </div>
	</br></br>
    </body>
	
	<footer class="container-fluid text-center">
	<p class="mt-5 mb-3 text-muted">Stock Brockerage Copyright &copy;  2019-2020</p>
 
</footer>
</html>