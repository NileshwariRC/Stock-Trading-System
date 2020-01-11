<!DOCTYPE html>
<html>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
  padding: 14px 20px;
  background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
  padding: 16px;
}

/* Clear floats */
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
  .cancelbtn, .signupbtn {
     width: 100%;
  }
}
</style>
<body>

<form method="post" action="transferMoney.do" style="border:1px solid #ccc">
  <div class="container">
    <h1 align = "center">Transfer Money</h1>
    <p>Please enter account details to transfer money</p>
    <hr>
    <!-- Username and password should be internally fetched to transfer money
    Write code for that here -->
    <label for="Username"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="Username" required>
    
    <label for="FromAccountNo"><b>Transfer from : </b></label>
    <input type="text" placeholder="Transfer from" name="FromAccountNo" required>
	
    <label for="ToAccNo"><b>Transfer to : </b></label>
    <input type="text" placeholder="Transfer to" name="ToAccNo" required>
    
    <label for="password"><b>Password : </b></label>
    <input type="password" placeholder="Enter password" name="password" required>
    
    <label for="amount"><b>Password : </b></label>
    <input type="text" placeholder="Enter amount" name="amount" required>

    <div class="clearfix">
      
      <button class="signupbtn">Transfer</button>
      <script type="text/javascript">
		function alertName(){
		alert(request.getAttribute(message));
		} 
	</script>
	<script type="text/javascript"> window.onload = alertName; </script>
    </div>
  </div>
</form>

</body>
</html>
