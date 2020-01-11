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
        <title>STOCK BROCKERAGE</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Stock Brockerage Login Page" />
        <meta name="keywords" content="stock, buy, sell , login" />
        <meta name="author" content="Team Blue" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
    </head>
    <body>
        <div class="container">
            <!--/ Codrops top bar -->
            <header>
                <h1>STOCK <span>BROCKERAGE</span></h1>
            </header>
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  action="login.do" method="post" autocomplete="on"> 
                                <h1>Log in</h1> 
                                <p> 
                                    <label for="username" class="uname" data-icon="u" > Your email or username </label>
                                    <input id="username" name="userName" required="required" type="text" placeholder="myusername or mymail@mail.com"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                                    <input id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO" /> 
                                </p>
                                <p class="keeplogin"> 
									<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
									<label for="loginkeeping">Keep me logged in</label>
								</p>
                                <p class="login button"> 
                                    <input type="submit" value="Login" /> 
								</p>
                                <p class="change_link">
									Not a member yet ?
									<a href="#toregister" class="to_register">Join us</a>
								</p>
                            </form>
                        </div>

                        <div id="register" class="animate form">
                            <form  method="post" action="Signup.do" autocomplete="on"> 
                                <h1> Sign up </h1> 
								<p> 
                                    <label for="ssnsignup" class="ssn" data-icon="u">Your SSN</label>
                                    <input id="ssnsignup" placeholder="Enter SSN" name="SSN" required="required" type="text"  />
                                </p>
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">Your username</label>
                                    <input id="usernamesignup" placeholder="Enter Username" name="Username" required="required" type="text"  />
                                </p>
                                 <p> 
                                    <label for="addresssignup" class="address" data-icon="a" > Your address</label>
                                    <input id="emailsignup" placeholder="Enter Address" name="address" required="required" type="text" /> 
                                </p>
                                <p> 
                                    <label for="emailsignup" class="youmail" data-icon="e" > Your email</label>
                                    <input id="emailsignup" placeholder="Enter Email" name="email" required="required" type="email" /> 
                                </p>
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" data-icon="p">Your password </label>
                                    <input id="passwordsignup" placeholder="Enter Password" name="psw" required="required" type="password"/>
	                                </p>
								<label> <input type="checkbox" checked="checked"
									name="remember" style="margin-bottom: 15px"> Remember me
								</label>
								<div class="clearfix">
									<button type="button" class="cancelbtn">Cancel</button>
									<button type="submit" class="signupbtn">Sign Up</button>
							</div>
							<p class="change_link">  
									Already a member ?
									<a href="#tologin" class="to_register"> Go and log in </a>
								</p>
                            </form>
                        </div>
						
                    </div>
                </div>  
            </section>
			
			</br>
		</br>
			</br>
	<footer class="container-fluid text-center">
	<p class="mt-5 mb-3 text-muted">Stock Brockerage Copyright &copy;  2019-2020</p>
 
</footer>
        </div>
    </body>
	
</html>