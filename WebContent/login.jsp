<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 2 | Log in</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="./bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="./bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="./bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="./dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="./plugins/iCheck/square/blue.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">




</head>
<body class="hold-transition login-page" style="background-image: url(maxresdefault.jpg); background-size: cover;">
<div class="login-box">
  <div class="login-logo">
    <a href="./index2.html"><b>Order</b>Matching System</a>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">Sign in to start your session</p>
    
	  	<%-- <%
		//java code in here
		
		String message = (String) request.getAttribute("errorString");
		if (message!=null) out.println(message + "<br>");
		
		%> --%> 
		
		<% 
		String message = (String) request.getAttribute("errorString");
		if(message!=null) 
			{ %>
		    <div id="noEntry" class = "alert" style = "margin:10px 0px; text-align:center; vertical-align:middle; padding-bottom:20px; line-height:5px; height:10px;  color: #D8000C; background-color: #FFD2D2;">
		        <p> <% out.println(message + "<br>"); %>   </p>
		    </div>
		<%	} %>
    

    <form action="login2" method="post">
      <div class="form-group has-feedback">
        <input type="text" name = "loginId" class="form-control" placeholder="User ID">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" name = "password" class="form-control" placeholder="Password">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
      
   <!--   <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> Remember Me
            </label>
          </div>
        </div>
         /.col -->
         
         <div class = "col-xs-1"></div>
        <div class="col-xs-10">
          <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
        </div>
        <div class = "col-xs-1"> </div>
        <!-- /.col -->
      </div>
    </form>

    <br>
    <!-- /.social-auth-links -->

  <!--   <a href="#">I forgot my password</a><br> -->
    <a href="register.jsp" class="text-center">Register a new membership</a>

  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 3 -->
<script src="./bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="./bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="./plugins/iCheck/icheck.min.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' /* optional */
    });
  });
</script>
</body>
</html>
