<%@page import="gurleen.dao.DB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Action</title>

 <body style="background-color:PowderBlue;">
 
</head>
<body>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous"></head>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<% 
DB db = new DB();
String action = request.getParameter("action");
String bmiId= request.getParameter("bmiid");
String bmi = request.getParameter("bmi");
Double weight = Double.parseDouble(request.getParameter("weight"));
Integer height = Integer.parseInt(request.getParameter("height"));


session.setAttribute("bmiid", bmiId);

if(action.equals("update")){
	  
	   
	   
%>

   <p>UPDATE  DETAILS </p>  
   <h3>Log New Details Here</h3>
   
 <form action='intermediateupdate.jsp'>
  <div class="form-group">
      <label for="txt">Update Height</label>
      <input type="text" class="form-control" id="email" value="<%=height%>" name="height">
      </div>
      	<br>
   <div class="form-group">
      <label for="txt">Update Weight</label>
      <input type="text" class="form-control" id="email" value="<%=weight%>" name="weight">
      </div>
      	<br>
    
      	<input type="submit" value="UPDATE">
      
      
      </form>
  
 
	<%			// update the fever record
		}
	%>
	</center>

</body>
</html>