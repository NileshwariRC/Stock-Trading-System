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
        <title>Buy/Sell stock</title>
        <meta name="viewport" content="width=device-width, initial-scale=1 shrink-to-fit=no"> 
        <meta name="description" content="Stock Brockerage Buy/Sell stock" />
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
						<li><a href="transfermoney.html">Transfer Money</a></li>
					  </ul>
					  
					</div>
				  </div>
				</nav>
            </header>
            <section>								
                
				<h3>STOCK AVAILABLE FOR PURCHASE</h3>
			<table class="table table-hover" id="ord" align="left">

	
		<thead>
			<tr>
			  <th class="th-sm">Ticker Symbol
			  </th>
			  <th class="th-sm">Company Name
			  </th>
			  <th class="th-sm">Price
			  </th>
			  <th class="th-sm">Quantity
			  </th>
			  <th class="th-sm">Total
			  </th>
			  
			</tr>
		  </thead>
		  <tbody>
			<tr>
				<td>LRW</td>
				<td>Lords</td>
				<td>$12</td>
				<td>3</td>
				<td>Computed</td>
				
				<td><a class="add" title="Add" data-toggle="tooltip"><i class="material-icons">&#xE03B;</i></a> <a class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a> <a class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a> </td></tr>
			</tr>
			<tr>
				<td>LRW</td>
				<td>Lords</td>
				<td>$12</td>
				<td>3</td>
				<td>Computed</td>
			</tr>
			
		  </tbody>
		  
</table>

			<div>
                        <button type="button" class="btn btn-info add-new"><i class="fa fa-plus"></i> Add Row</button>
                    </div>

        </div>
		</div>	
        </div>
		</br></br>   
            </section>
        </div>
    </body>
	
	<script type="text/javascript">
$(document).ready(function(){
	$('[data-toggle="tooltip"]').tooltip();
	var actions = $("table td:last-child").html();
	// Append table with add row form on add new button click
    $(".add-new").click(function(){
		$(this).attr("disabled", "disabled");
		var index = $("table tbody tr:last-child").index();
        var row = '<tr>' +
            '<td><input type="text" class="form-control" name="name" id="name"></td>' +
            '<td><input type="text" class="form-control" name="quantity" id="quantity"></td>' +
            '<td><input type="text" class="form-control" name="rdate" id="rdate"></td>' +
			'<td> <a class=\"add\" title=\"Add\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE03B;</i></a> <a class=\"edit\" title=\"Edit\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE254;</i></a> <a class=\"delete\" title=\"Delete\" data-toggle=\"tooltip\"><i class=\"material-icons\">&#xE872;</i></a></td>' +
        '</tr>';
    	$("table").append(row);		
		$("table tbody tr").eq(index + 1).find(".add, .edit").toggle();
        $('[data-toggle="tooltip"]').tooltip();
    });
	// Add row on add button click
	$(document).on("click", ".add", function(){
		var empty = false;
		var input = $(this).parents("tr").find('input[type="text"]');
        input.each(function(){
			if(!$(this).val()){
				$(this).addClass("error");
				empty = true;
			} else{
                $(this).removeClass("error");
            }
		});
		$(this).parents("tr").find(".error").first().focus();
		if(!empty){
			input.each(function(){
				$(this).parent("td").html($(this).val());
			});			
			$(this).parents("tr").find(".add, .edit").toggle();
			$(".add-new").removeAttr("disabled");
		}		
    });
	// Edit row on edit button click
	$(document).on("click", ".edit", function(){		
        $(this).parents("tr").find("td:not(:last-child)").each(function(){
			$(this).html('<input type="text" class="form-control" value="' + $(this).text() + '">');
		});		
		$(this).parents("tr").find(".add, .edit").toggle();
		$(".add-new").attr("disabled", "disabled");
    });
	// Delete row on delete button click
	$(document).on("click", ".delete", function(){
        $(this).parents("tr").remove();
		$(".add-new").removeAttr("disabled");
    });
});
</script>
	
	<footer class="container-fluid text-center">
	<p class="mt-5 mb-3 text-muted">Stock Brockerage Copyright &copy;  2019-2020</p>
 
</footer>
</html>