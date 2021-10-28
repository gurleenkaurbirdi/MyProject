<%@page import="gurleen.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>

 <body style="background-color:PowderBlue;">
 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>

<body>
<% 
User user = (User)session.getAttribute("keyUser");

%>
<center>
<br>

<h2>Welcome <%=user.name %> to the BMI Logger </h2>
<%=user.email %> 
<!-- <h3> Log Your Details Here : </h3>-->
<br>
<br>
 <a href="ViewBMI.jsp" class="btn btn-primary" role="button">RECORD</a>
<br>
</center>
   
<center>
<div class="container">
 <!--  <h2> Login Below</h2> -->
   <form action="addBMI.jsp" method="post">
  
  <h2>Log Your Details Here</h2>
   <div class="form-group">
      <label for="height">Height:</label>
      <input type="text" class="form-control" id="height" placeholder="Enter height" name="txtHeight">
    </div>
    <div class="form-group">
      <label for="weight">Weight:</label>
      <input type="text" class="form-control" id="weight" placeholder="Enter weight" name="txtWeight">
    </div>
        
      </label>
    </div>
    <button type="submit" class="btn btn-primary">LOG </button>
  </form>
</div>
<br>

</center>






 <!--   <form action="addBMI.jsp" method="post" >
<input type="text" name="txtHeight" placeholder="eg 162cm">
<input type="submit" value= "LOG HEIGHT">-->

</body>
</html>