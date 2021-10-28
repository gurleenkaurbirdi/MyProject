<%@page import="gurleen.dao.DB"%>
<%@page import="gurleen.model.User"%>
<%@page import="gurleen.model.BMI"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BMI Add</title>

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
<h3> Your BMI </h3>
<%= user.name %>

</center>

<%
BMI bmi = new BMI();
bmi.userId = user._id;
bmi.height= Integer.parseInt(request.getParameter("txtHeight"));
bmi.weight= Double.parseDouble(request.getParameter("txtWeight"));
bmi.yourBMI= (bmi.weight/(bmi.height*bmi.height))*10000;
bmi.phoneNumber= user.phoneNumber;
DB db= new DB();

db.LogBMI(bmi);

%>

<center>
<% 
out.println("Your BMI is : "+bmi.yourBMI);

out.println("Thank You :) your BMI has been Recorded successfully <");

%>
<p <%= bmi.height %>></p>
<p <%=bmi.weight %>></p>
<p<%=bmi.phoneNumber %>></p>
<a href="ViewBMI.jsp" class="btn btn-primary" role="button">RECORD</a>

<br>
<br>


<%
if(bmi.yourBMI<18.5){
	out.println("UNDERWEIGHT");
	 String message= "<html><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n"
 	   		+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
 	   		+ "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n"
 	   		+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n"
 	   		+ "\r\n"
 	   		+ "<body><center><br> <h3>YOU ARE UNDERWEIGHT <br>"
 	   		+user.name+"</h3><br> "
 			   
 	   		+" <a href=\"video1.jsp\" class=\"btn btn-primary\" role=\"button\">UNDERWEIGHT</a>"
 			   + "</center></body></html>";
        out.println(message);
}
else if(bmi.yourBMI>=18.5 && bmi.yourBMI<=24.9 ){
	out.println("HEALTHY");
	String message= "<html><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n"
 	   		+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
 	   		+ "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n"
 	   		+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n"
 	   		+ "\r\n"
 	   		+ "<body><center><br> <h3>YOU ARE HEALTHY <br>"
 	   		+user.name+"</h3><br> "
 	   			
 	   		+" <a href=\"video1.jsp\" class=\"btn btn-primary\" role=\"button\">HEALTHY</a>"
 			   + "</center></body></html>";
        out.println(message);
}else if(bmi.yourBMI>=25 && bmi.yourBMI<=29.9){
	out.println("OVERWEIGHT");
	String message= "<html><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n"
 	   		+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
 	   		+ "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n"
 	   		+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n"
 	   		+ "\r\n"
 	   		+ "<body><center><br> <h3>YOU ARE OVERWEIGHT <br>"
 	   		+user.name+"</h3><br> "
 			   
 	   		+" <a href=\"video.jsp\" class=\"btn btn-primary\" role=\"button\">OVERWEIGHT</a>"
 			   + "</center></body></html>";
        out.println(message);
}
else if (bmi.yourBMI>=30){
	out.println("OBESE");
	String message= "<html><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n"
 	   		+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
 	   		+ "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n"
 	   		+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n"
 	   		+ "\r\n"
 	   		+ "<body><center><br> <h3>YOU ARE OBESE <br>"
 	   		+user.name+"</h3><br> "
 			   
 	   		+" <a href=\"video.jsp\" class=\"btn btn-primary\" role=\"button\">UNDERWEIGHT</a>"
 			   + "</center></body></html>";
        out.println(message);
}



%>
</center>





</body>
</html>